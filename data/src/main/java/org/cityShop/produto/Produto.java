package org.cityShop.produto;
import java.util.ArrayList;
import org.cityShop.usuario.FavoritoProduto;


public class Produto
{

	public Long id;
	public Long idLoja;	
	public Descricao descricao;
	public ArrayList<Categoria> categorias;
	public ArrayList<FavoritoProduto> favoritos;
	public ItemEstoque estoque;

	public void addFavorito(Long idUsuario){

	}

}
