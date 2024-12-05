package org.cityShop.loja;


import org.json.JSONArray;
import org.json.JSONObject;
import org.cityShop.app.Database;
import org.cityShop.produto.*;

import java.sql.Timestamp;
import java.util.ArrayList;

import javax.xml.crypto.Data;

//TODO
//criar os metodos de controle de reservas

public class Loja 
{
	public String nome;
	public Long id;
	public Boolean aberto;
	public Long dono;
	public Long favoritadas;

	public Local localizacao;
	public TabelaReserva reservas;

	public ArrayList<TabelaPreco> tabelasPreco;
	public ArrayList<Avaliacao> avaliacoes;

	public Loja(){


	}

	public Loja(String nome, Long idDono, Local localizacao){

		Database database = Database.getInstance();

		this.nome = nome;
		this.dono = idDono;
		this.localizacao = localizacao;
		this.aberto = false;
		this.favoritadas = 0L;

		Loja[] lojas = database.querryLoja();

		Long maior = 0L;

		for (Loja loja : lojas){

			if (loja.id > maior){

				maior = loja.id;
			}

		}

		this.id = maior +1;

		this.reservas = new TabelaReserva();
		this.tabelasPreco = new ArrayList<TabelaPreco>();
		this.avaliacoes = new ArrayList<Avaliacao>();


	}

	public Loja(JSONObject json){

		this.nome = json.getString("nome");
		this.id = json.getLong("id");
		this.aberto = json.getBoolean("aberto");
		this.favoritadas = json.getLong("favoritadas");
		this.dono = json.getLong("dono");

		JSONObject local = new JSONObject(json.getJSONObject("localizacao").toString());

		if (local.isEmpty()){

			this.localizacao = new Local();
		} else{

			this.localizacao = new Local(
				local.getString("endereco"),
				local.getString("longitude"),
				local.getString("latitude")
			);
		}


		JSONArray precos = new JSONArray(json.getJSONArray("tabelasPreco").toString());
		this.tabelasPreco = new ArrayList<TabelaPreco>();

		for (int i = 0; i < precos.length() && !precos.isEmpty(); i++){

			TabelaPreco tabela = new TabelaPreco(precos.getJSONObject(i));

			this.tabelasPreco.add(tabela);

		}

		this.reservas = new TabelaReserva(json.getJSONArray("reservas"));

		JSONArray avaliacoes = new JSONArray(json.getJSONArray("avaliacoes").toString());
		this.avaliacoes = new ArrayList<Avaliacao>();


		for (int i = 0; i < avaliacoes.length(); i++){
			this.avaliacoes.add(
				new Avaliacao(
					avaliacoes.getJSONObject(i).optInt("nota", 0),
					avaliacoes.getJSONObject(i).optString("corpo", ""),
					avaliacoes.getJSONObject(i).optLong("idUsuario", 0L))
			);


		}
	}

	public JSONObject toJSON(){

		JSONObject json = new JSONObject();

		json.put("nome", this.nome);
		json.put("id", this.id);
		json.put("aberto", this.aberto);
		json.put("dono", this.dono);
		json.put("favoritadas", this.favoritadas);

		json.put("localizacao", this.localizacao.toJSON());
		json.put("reservas", this.reservas.toJSON());

		JSONArray tabelas = new JSONArray();

		for (int i = 0; i < this.tabelasPreco.size(); i++) {

			JSONObject preco = new JSONObject(this.tabelasPreco.get(i).toJSON().toString());

			tabelas.put(preco);
			
		}

		json.put("tabelasPreco", tabelas);

		JSONArray avaliacoes = new JSONArray();

		for (Avaliacao rating : this.avaliacoes){

			avaliacoes.put(rating.toJSON());
		}

		json.put("avaliacoes", avaliacoes);

		return json;

	}

	public TabelaPreco getBaseTabelaPreco(){

		TabelaPreco tabela = tabelasPreco.get(0);

		if (tabela == null){

			return null;
		} else {

			return tabela;
		}

	}

	public TabelaPreco getActiveTabelaPreco(){

		TabelaPreco tabela = this.tabelasPreco.get(0);
		Timestamp time = new Timestamp(System.currentTimeMillis());

		for (int i = this.tabelasPreco.size() -1; i >= 0; i--){

			TabelaPreco current = this.tabelasPreco.get(i);

			if (current.validade.compareTo(time) < 0){

				continue;
			} else {

				tabela = current;
				break;
			}
		}

		return tabela;
	}

	public void addProduto(Produto produto, Double precoOriginal){

		for (TabelaPreco tabela : this.tabelasPreco){

			tabela.addProduto(produto, precoOriginal);
		}

	}

	public void removeProduto(Produto produto, Double precoOriginal){

		for (TabelaPreco tabela : this.tabelasPreco){

			tabela.removeProduto(produto.id);
		}

	}

	public Produto[] getProdutos(){

		Produto[] produtos = new Produto[this.getBaseTabelaPreco().produtos.size()];
		Database database = Database.getInstance();
		int index = 0;

		for (ItemProduto item : this.getBaseTabelaPreco().produtos){

			produtos[index] = database.getProduto(item.idProduto);
			index++;
		}

		return produtos;

	}

	public Double getMediaNotas(){

		Double med = 0.0;
		Double count = 0.0;

		for (Avaliacao avaliacao : this.avaliacoes){

			count++;

			med += (double)avaliacao.nota;

		}

		if (count == 0.0){

			count = 1.0;
		}

		return med / count;

	}

	
}
