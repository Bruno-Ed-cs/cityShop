package org.cityShop.produto;

import java.util.ArrayList;

import org.cityShop.app.Database;
import org.cityShop.loja.Loja;
import org.json.JSONArray;
import org.json.JSONObject;


public class Produto
{

	public Long id;
	public Long idLoja;	
	public Descricao descricao;
	public ArrayList<String> categorias;
	public Long favoritadas;
	public ItemEstoque estoque;

	public void addFavorito(Long idUsuario){

	}

	public Produto(){

		categorias = new ArrayList<String>();
		favoritadas = 0L;
	}

	public Produto(JSONObject json){

		//System.out.println(json.toString());
		this.id = json.getLong("id");
		this.idLoja = json.getLong("idLoja");
		this.favoritadas = json.getLong("favoritadas");

		this.descricao = new Descricao(json.getJSONObject("descricao"));
		this.estoque = new ItemEstoque(json.getJSONObject("estoque"));

		JSONArray buffer = new JSONArray(json.getJSONArray("categorias").toString());
		this.categorias = new ArrayList<String>();
		//System.out.println(buffer.toString());

		for (int i = 0; i < buffer.length(); i++){

			if (!buffer.isEmpty()){
				this.categorias.add(buffer.getString(i));
			}

		}


	}

	public JSONObject toJSON(){

		JSONObject json = new JSONObject();

		json.put("id", this.id);
		json.put("idLoja", this.idLoja);
		json.put("favoritadas", this.favoritadas);

		JSONArray categorias = new JSONArray();

		for (String categ : this.categorias){

			categorias.put(categ);
		}

		json.put("categorias", categorias);

		json.put("descricao", this.descricao.toJSON());

		json.put("estoque", this.estoque.toJSON());

		return json;
	}

public Double getPreco(){

		Loja loja = Database.getInstance().getLoja(this.idLoja);

		TabelaPreco tPreco = loja.tabelasPreco.getLast();

		for (int i = 0; i < tPreco.produtos.size(); i++) {

			if (tPreco.produtos.get(i).idProduto == this.id){

				return tPreco.produtos.get(i).preco;
			}
			
		}

		return null;

	}

}
