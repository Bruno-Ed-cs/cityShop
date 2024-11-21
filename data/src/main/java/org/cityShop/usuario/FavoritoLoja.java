package org.cityShop.usuario;

import org.cityShop.app.*;
import org.cityShop.loja.*;


//classe "FavoritoLoja" adiciona as lojas favoritas do usuário

public class FavoritoLoja implements Favoritavel
{

	public Long idTarget; //Loja favorita
	public Long idUsuario; //Usuário que adicionou a loja aos favoritos
	public FavTypes type = FavTypes.LOJA;

	public FavoritoLoja(Long idTarget, Long idUsuario){

		this.idTarget = idTarget;
		this.idUsuario = idUsuario;
	}
	
}
