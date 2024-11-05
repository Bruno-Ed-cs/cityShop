package cityShop.loja;

import cityShop.app.*;
import cityShop.usuario.Usuario;

public class FavoritoLoja implements Favoritavel
{

	public Loja target;
	public Usuario publisher;
	

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
