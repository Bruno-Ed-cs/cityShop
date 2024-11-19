package org.cityShop.usuario;


//classe "FavoritoProduto" adiciona os produtos favoritos do usuário

public class FavoritoProduto implements Favoritavel

{

	public Long idTarget;
	public Long idUsuario;
	public FavType type = FavType.PRODUTO;

	public FavoritoProduto(Long idTarget, Long idUsuario){

		this.idTarget = idTarget;
		this.idUsuario = idUsuario;
	}
}
