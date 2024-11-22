package org.cityShop.usuario;

import org.cityShop.app.*;
import org.cityShop.loja.*;


//classe "FavoritoLoja" adiciona as lojas favoritas do usuário

public class FavoritoLoja implements Favoritavel
{

	public Long idTarget; //Loja favorita
	public FavTypes type = FavTypes.LOJA;

	public FavoritoLoja(){


	}

	public FavoritoLoja(Long idTarget){

		this.idTarget = idTarget;
	}

	@Override
	public Long getTarget() {
		// TODO Auto-generated method stub
		return this.idTarget;
	}

}
