package org.cityShop.estoque;

import org.cityShop.app.*;
import org.cityShop.usuario.*;

//ajustar a classe "FavoritoProduto" pra que possa ser adicionado aos favoritos do usuário

public class FavoritoProduto implements Favoritavel
{

	public Produto target;
	public Usuario publisher;
	

	//criando um construtor pra iniciar

	public FavoritoProduto(Produto target, Usuario publiher) {

		this.target = target;
		this.publisher = publisher;
	}

	//implementar os métodos na interface (fazer o construtor, implementar os métodos...) 

	@Override
	public void adicionarAosFavoritos(Usuario usuario) {

		usuario.produtosFavoritos.add(this);
	}

	@Override
	public void removerDosFavoritos(Usuario usuario) {

		usuario.getProdutosFavoritos().remove(this);
	}
}
