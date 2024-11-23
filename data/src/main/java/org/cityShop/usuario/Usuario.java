package org.cityShop.usuario;

import java.util.ArrayList;
import java.util.stream.Collectors;

import org.cityShop.testes.Json;
import org.json.JSONArray;
import org.json.JSONObject;

public class Usuario 

{

	//atributos de um usuario

	public String nome;
	public String cpf;
	public Long id;
	public Boolean lojista;

	public ArrayList<Favoritavel> favoritos; 

	//construtor de um usuario

	public Usuario(String nome, String cpf, Long id, Boolean lojista){

		this.nome = nome;
		this.cpf = cpf;
		this.id = id;
		this.lojista = lojista;
		this.favoritos = new ArrayList<>();

	}

		//construtor de um usuario a partir de um json

	public Usuario(JSONObject json){
	
	/*
	 Adiciona um favorito no usuario
	  1. idTarget: o id do produto/loja que sera adicionado como favorito
	  2. type: o tipo do favorito (produto/loja)
	 */

	public void adicionarFavorito(Long idTarget, FavType type) {
	
		
		// nome do usuario
		this.nome = json.getString("nome"); 
		
		// CPF do usuario
		this.cpf = json.getString("cpf");
		
		// id do usuario
		this.id = json.getLong("id");
		
		// booleano que representa se o usuario e lojista ou nao
		this.lojista = json.getBoolean("lojista");
	
		
		JSONArray favoritos = new JSONArray(json.getJSONArray("favoritos").toString()); 
		this.favoritos = new ArrayList<Favoritavel>();

		for (int i = 0; i < favoritos.length(); i++){

			Favoritavel favorito = null;

			switch (favoritos.getJSONObject(i).getInt("type")){

				case 1:

					favorito = new FavoritoProduto(favoritos.getJSONObject(i).getLong("id"));

				break;

				case 0:

					favorito = new FavoritoLoja(favoritos.getJSONObject(i).getLong("id"));

				break;
			}

			this.favoritos.add(favorito);


		}


	}

}

	//agora, eu adicionei o tipo de favorito que vai ser especificado, definir se é uma loja ou um produto
	


	public void adicionarFavorito(Long idTarget, FavTypes type){


		Favoritavel favorito;
	
		switch(type){
	
			case FavType.PRODUTO:
	
				favorito = new FavoritoProduto(idTarget, this.id);
				break;
	
			case FavType.LOJA:
	
				favorito = new FavoritoLoja(idTarget, this.id);

			case FavTypes.PRODUTO:

				favorito = new FavoritoProduto(idTarget);
				break;

			case FavTypes.LOJA:

				favorito = new FavoritoLoja(idTarget);
				break;
		
			default:
				throw new IllegalArgumentException("favorito nao definido");
	
		}
	
		favoritos.add(favorito);

		return
	


		favoritos.add(favorito);

		return;
	}

	//funcao para retornar um array com os favoritos de um tipo que específico

	public Favoritavel[] querryFavoritos(FavTypes type){

		return favoritos.stream()

			.filter( f -> f instanceof FavoritoProduto && type == FavType.PRODUTO || f instanceof FavoritoLoja && type == FavType.LOJA)
		
			.filter( f -> f instanceof FavoritoProduto && type == FavTypes.PRODUTO || f instanceof FavoritoLoja && type == FavTypes.LOJA)
			.toArray(Favoritavel[]::new);
	}
}


}