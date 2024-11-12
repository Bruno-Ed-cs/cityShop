package org.cityShop.usuario;

import org.cityShop.app.*;


//classe "FavoritoLoja" adiciona as lojas favoritas do usuário

public class FavoritoLoja implements Favoritavel
{


	public Loja target; //Loja favorita
	public Usuario publisher; //Usuário que adicionou a loja aos favoritos
	

	public FavoritoLoja(Loja target, Usuario publisher) {

		this.target = target;
		this.publisher = publisher;
	}

	@Override
	public void adicionarAosFavoritos(Usuario usuario) {

		usuario.adicionarFavoritoLoja(this);
	}

	@Override 
	public void removerDosFavoritos(Usuario usuario) {

		usuario.getProdutosFavoritos().remove(this);
	}

}
