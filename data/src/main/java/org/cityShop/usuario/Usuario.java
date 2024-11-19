package org.cityShop.usuario;

import java.util.ArrayList;

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

	//o target pode ser ou om produto ou uma loja basta passar o id
	public void adicionarFavorito(Long idTarget, FavType type){


		Favoritavel favorito;

		switch(type){

			case FavType.PRODUTO:
				favorito = new FavoritoProduto(idTarget, this.id);
				break;

			case FavType.LOJA:
				favorito = new FavoritoLoja(idTarget, this.id);
				break;

			default:
				return;

		}

		favoritos.add(favorito);

	}

	//funcao para retornar um array com os favoritos de um tipo
	public Favoritavel[] querryFavoritos(FavType type){

		return null;
	}

}
