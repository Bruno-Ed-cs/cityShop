package org.cityShop.produto;
import static java.util.Objects.requireNonNull;

import java.util.ArrayList;

import javax.sound.midi.SoundbankResource;

import org.cityShop.usuario.FavoritoProduto;
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

	public Double getPreco(){

		return null;

	}

}
