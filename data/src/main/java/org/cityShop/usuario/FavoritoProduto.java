package org.cityShop.usuario;


//classe "FavoritoProduto" adiciona os produtos favoritos do usuário

public class FavoritoProduto implements Favoritavel

{

	public Long idTarget;
	public FavTypes type = FavTypes.PRODUTO;

	public FavoritoProduto(){


	}


	public FavoritoProduto(Long idTarget){

		this.idTarget = idTarget;
	}

	@Override
	public Long getTarget() {
		// TODO Auto-generated method stub
		return this.idTarget;
	}


}
