package org.cityShop.usuario;

import org.cityShop.app.*;
import org.cityShop.loja.*;


//classe "FavoritoLoja" adiciona as lojas favoritas do usuário

public class FavoritoLoja implements Favoritavel
{


	public Long idTarget; //Loja favorita
	public Long idUsuario; //Usuário que adicionou a loja aos favoritos
	

	public FavoritoLoja(Loja target, Usuario publisher) {

		this.idTarget= target.id;
		this.idUsuario = publisher.id;
	}
}
