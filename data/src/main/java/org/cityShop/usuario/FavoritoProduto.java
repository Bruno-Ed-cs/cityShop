package org.cityShop.usuario;


//classe "FavoritoProduto" adiciona os produtos favoritos do usuário e tambem implementa a interface favoritavel

public class FavoritoProduto implements Favoritavel

{

	public Long idUsuario;
	public Long idTarget;
	public FavTypes type = FavTypes.PRODUTO;

	public FavoritoProduto(Long idTarget1, Long id){


	}


	public FavoritoProduto(Long idTarget){

		this.idTarget = idTarget;
		this.type = FavTypes.PRODUTO;
		this.idUsuario = null;

	}

	    public FavoritoProduto(Long idUsuario, Long idTarget, FavTypes type) {

        this.idUsuario = idUsuario;
        this.idTarget = idTarget;
        this.type = FavTypes.PRODUTO;
    }


	public Long getTarget() {
		
		return this.idTarget;
	}

	public Long getIdTargeLong() {

		return idUsuario;

	}

	@Override
	public FavTypes getType() {

		return type;

	}


}
