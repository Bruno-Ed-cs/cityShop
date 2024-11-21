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

	//agora, eu adicionei o tipo de favorito que vai ser especificado, definir se é uma loja ou um produto

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

		return;
	}

	//funcao para retornar um array com os favoritos de um tipo que específico

	public Favoritavel[] querryFavoritos(FavTypes type){

		return favoritos.stream()
		
			.filter( f -> f instanceof FavoritoProduto && type == FavTypes.PRODUTO || f instanceof FavoritoLoja && type == FavTypes.LOJA)
			.toArray(Favoritavel[]::new);
	}
}
