package org.cityShop.usuario;

import org.cityShop.produto.*;


//classe "FavoritoProduto" adiciona os produtos favoritos do usuário

public class FavoritoProduto implements Favoritavel

{

	public Long idTarget;
	public Long idUsuario;
	

	//criando um construtor pra iniciar

	public FavoritoProduto(Produto target, Usuario publisher) {

		this.idTarget= target.id;
		this.idUsuario = publisher.id;
	}

}
