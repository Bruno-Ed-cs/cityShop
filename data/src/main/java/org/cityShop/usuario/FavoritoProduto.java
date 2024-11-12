package org.cityShop.usuario;

import org.cityShop.app.*;


//classe "FavoritoProduto" adiciona os produtos favoritos do usuário

public class FavoritoProduto implements Favoritavel

{

	public Produto target;
	public Usuario publisher;
	

	//criando um construtor pra iniciar

	public FavoritoProduto(Produto target, Usuario publiher) {

		this.target = target;
		this.publisher = publisher;
	}

	//implementando os métodos na interface (fazer o construtor, implementar os metodos e etc...) 

	@Override
	public void adicionarAosFavoritos(Usuario usuario) {

		usuario.produtosFavoritos.add(this);
	}

	@Override
	public void removerDosFavoritos(Usuario usuario) {

		usuario.getProdutosFavoritos().remove(this);
	}
}
