package org.cityShop.produto;
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
	public ArrayList<Categoria> categorias;
	public ArrayList<FavoritoProduto> favoritos;
	public ItemEstoque estoque;

	public void addFavorito(Long idUsuario){

	}

	public Produto(){

		categorias = new ArrayList<Categoria>();
		favoritos = new ArrayList<FavoritoProduto>();
	}

	public Produto(JSONObject json){

		//System.out.println(json.toString());
		this.id = json.getLong("id");
		this.idLoja = json.getLong("idLoja");

		this.descricao = new Descricao(json.getJSONObject("descricao"));
		this.estoque = new ItemEstoque(json.getJSONObject("estoque"));

		JSONArray buffer = new JSONArray(json.getJSONArray("categorias").toString());
		//System.out.println(buffer.toString());

		for (int i = 0; i < buffer.length(); i++){

			if (!buffer.getJSONObject(i).isEmpty()){
				this.categorias.add(new Categoria(buffer.getJSONObject(i)));
			}

		}

		this.favoritos = null;

	}

}
