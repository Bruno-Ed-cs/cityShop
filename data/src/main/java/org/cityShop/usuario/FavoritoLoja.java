package org.cityShop.loja;

import org.cityShop.app.*;
import org.cityShop.usuario.Usuario;

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
