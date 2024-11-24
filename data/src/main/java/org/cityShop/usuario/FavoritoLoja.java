package org.cityShop.usuario;

import org.cityShop.app.*;
import org.cityShop.loja.*;


//classe "FavoritoLoja" adiciona as lojas favoritas do usuário

public class FavoritoLoja implements Favoritavel
{
	public Long idUsuario;
	public Long idTarget; //Loja favorita
	public FavTypes type = FavTypes.LOJA;

	public FavoritoLoja(){


	}

	public FavoritoLoja(Long idTarget, Long idUsuario){

		this.idTarget = idTarget;
		this.idUsuario = idUsuario;
	}

	@Override
	public Long getTarget() {
		
		// TODO Auto-generated method stub

		return idTarget;
	}

	@Override
	public Long getIdTargeLong() {

		return idUsuario;

	}

	@Override
	public FavTypes getType() {

		return type;

}
