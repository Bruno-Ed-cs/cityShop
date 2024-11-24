package org.cityShop.usuario;

import org.cityShop.app.*;
import org.cityShop.loja.*;


//classe "FavoritoLoja" adiciona as lojas favoritas do usuário e implementa a interface favoritavel

public class FavoritoLoja implements Favoritavel

{
	public Long idUsuario;
	public Long idTarget; 
	public FavTypes type = FavTypes.LOJA;


	//construtor

	public FavoritoLoja(){


	}

	
	public FavoritoLoja(Long idTarget, Long idUsuario){

		//Armazena o id da loja favoritada

		this.idTarget = idTarget;

		//Armazena o id do usuario que favoritou a loja

		this.idUsuario = idUsuario;

		this.type = FavTypes.LOJA; //Armazena o tipo do favorito (nesse caso, eh a loja)
	}


	//Retorna o id da loja que o usuario favoritou
	 
	public Long getTarget() {
	
		return idTarget;
	}

	
	//Retorna o id do usuario que favoritou a loja
	 
	public Long getIdTargeLong() {

		return idUsuario;

	}

	@Override

	// Retorna o tipo da favorita o (Loja ou Produto)
	
	public FavTypes getType() {

		return type;

	}


}