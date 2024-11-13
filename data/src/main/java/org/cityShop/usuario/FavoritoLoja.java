package org.cityShop.usuario;

import org.cityShop.app.*;
import org.cityShop.loja.*;


//classe "FavoritoLoja" adiciona as lojas favoritas do usuário

public class FavoritoLoja implements Favoritavel
{


	public Loja target; //Loja favorita
	public Usuario publisher; //Usuário que adicionou a loja aos favoritos
	

	public FavoritoLoja(Loja target, Usuario publisher) {

		this.target = target;
		this.publisher = publisher;
	}
}
