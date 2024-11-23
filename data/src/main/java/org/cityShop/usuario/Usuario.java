package org.cityShop.usuario;

import java.util.ArrayList;

import org.cityShop.testes.Json;
import org.json.JSONArray;
import org.json.JSONObject;

public class Usuario 
{

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

	public Usuario(JSONObject json){

<<<<<<< HEAD
	public void adicionarFavorito(Long idTarget, FavType type){
	
	
=======
		this.nome = json.getString("nome");
		this.cpf = json.getString("cpf");
		this.id = json.getLong("id");
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

	//agora, eu adicionei o tipo de favorito que vai ser especificado, definir se é uma loja ou um produto
	


	public void adicionarFavorito(Long idTarget, FavTypes type){


>>>>>>> b9d2c465865f1d7315e9edaf28ef3bc03162247f
		Favoritavel favorito;
	
		switch(type){
<<<<<<< HEAD
	
			case FavType.PRODUTO:
	
				favorito = new FavoritoProduto(idTarget, this.id);
				break;
	
			case FavType.LOJA:
	
				favorito = new FavoritoLoja(idTarget, this.id);
=======

			case FavTypes.PRODUTO:

				favorito = new FavoritoProduto(idTarget);
				break;

			case FavTypes.LOJA:

				favorito = new FavoritoLoja(idTarget);
>>>>>>> b9d2c465865f1d7315e9edaf28ef3bc03162247f
				break;
		
			default:
				throw new IllegalArgumentException("favorito nao definido");
	
		}
<<<<<<< HEAD
	
		favoritos.add(favorito);

		return
	
=======


		favoritos.add(favorito);

		return;
>>>>>>> b9d2c465865f1d7315e9edaf28ef3bc03162247f
	}

	//funcao para retornar um array com os favoritos de um tipo que específico

	public Favoritavel[] querryFavoritos(FavTypes type){

		return favoritos.stream()
<<<<<<< HEAD

			.filter( f -> f instanceof FavoritoProduto && type == FavType.PRODUTO || f instanceof FavoritoLoja && type == FavType.LOJA)
=======
		
			.filter( f -> f instanceof FavoritoProduto && type == FavTypes.PRODUTO || f instanceof FavoritoLoja && type == FavTypes.LOJA)
>>>>>>> b9d2c465865f1d7315e9edaf28ef3bc03162247f
			.toArray(Favoritavel[]::new);
	}
}
