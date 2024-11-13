package org.cityShop.usuario;

import org.cityShop.produto.*;


//classe "FavoritoProduto" adiciona os produtos favoritos do usuário

public class FavoritoProduto implements Favoritavel

{

	public Produto target;
	public Usuario publisher;
	

	//criando um construtor pra iniciar

	public FavoritoProduto(Produto target, Usuario publisher) {

		this.target = target;
		this.publisher = publisher;
	}

}
