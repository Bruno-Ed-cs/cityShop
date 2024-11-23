package org.cityShop.produto;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Dictionary;

import org.cityShop.loja.TabelaReserva;
import org.json.JSONArray;
import org.json.JSONObject;

//a tabela de index 0 vai obrigatoriamente ser os precos padroes
//consertar o json do banco de datos para ter os precos certos

public class TabelaPreco {

	public Long id;
	public String nome;
	public Timestamp criacao;
	public Timestamp validade;
	public Double modificador;
	public Boolean hasDesconto;

	public ArrayList<ItemProduto> produtos;

	public TabelaPreco(Long id, String nome, Timestamp criacao,Timestamp validade, Double modificador, Boolean hasDesconto){

		this.id = id;
		this.nome = nome;
		this.criacao = criacao;
		this.validade = validade;
		this.modificador = modificador;
		this.hasDesconto = hasDesconto;

		this.produtos = new ArrayList<ItemProduto>();
	}

	public TabelaPreco(JSONObject json){

		this.id = json.getLong("id");
		this.nome = json.getString("nome");

		this.criacao = Timestamp.valueOf(json.getString("criacao"));

		this.validade = Timestamp.valueOf(json.getString("validade"));

		this.modificador = json.getDouble("modificador");
		this.hasDesconto = json.getBoolean("hasDesconto");

		this.produtos = new ArrayList<ItemProduto>();

		JSONArray precos = new JSONArray(json.getJSONArray("produtos").toString());
		for (int i = 0; i < precos.length() && !precos.isEmpty(); i++){
			
			ItemProduto item = new ItemProduto();

			item.preco = precos.getJSONObject(i).getDouble("preco");
			item.idProduto = precos.getJSONObject(i).getLong("idProduto");

			this.produtos.add(item);

		}

	}

	public void addProduto(Produto produto){

		//o preco vai ser aplicado com base no modificador da tabela
	}

	
	
}
