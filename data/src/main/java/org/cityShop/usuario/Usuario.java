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
	
		// nome do usuario
		this.nome = json.getString("nome"); 
		
		// CPF do usuario
		this.cpf = json.getString("cpf");
		
		// id do usuario
		this.id = json.getLong("id");
		
		// booleano que representa se o usuario e lojista ou nao
		this.lojista = json.getBoolean("lojista");
		
		JSONArray favoritosJson = json.getJSONArray("favoritos");
		this.favoritos = new ArrayList<>();

		for (int i = 0; i < favoritos.length(); i++){

			Favoritavel favorito = null;

			switch (favoritos.getJSONObject(i).getInt("type")){

				case 1: //produto

					favorito = new FavoritoProduto(favoritos.getJSONObject(i).getLong("id"));

				break;

				case 0: //loja

					favorito = new FavoritoLoja(favoritos.getJSONObject(i).getLong("id"));

				break;

				default:

					throw new IllegalArgumentException("favorito nao definido");
			}

			this.favoritos.add(favorito);


		}


	}



	//agora, eu adicionei o tipo de favorito que vai ser especificado e adicionado, se é uma loja ou produto
	
	public void adicionarFavorito(Long idTarget, FavTypes type){


		Favoritavel favorito;
	
		switch(type){
	
			case FavTypes.PRODUTO:
	
				favorito = new FavoritoProduto(idTarget, this.id);
				break;
	
			case FavTypes.LOJA:
	
				favorito = new FavoritoLoja(idTarget, this.id);

				break;
		
			default:
				throw new IllegalArgumentException("favorito nao definido");
	
		}
	
		favoritos.add(favorito);

	}

	//funcao para retornar um array com os favoritos de um tipo que específico

	public Favoritavel[] querryFavoritos(FavTypes type){

				return favoritos.stream()

		.filter( f -> f instanceof FavoritoProduto && type == FavTypes.PRODUTO || f instanceof FavoritoLoja && type == FavTypes.LOJA)
			.toArray(Favoritavel[]::new);
	}

}