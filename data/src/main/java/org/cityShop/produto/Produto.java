package org.cityShop.produto;
import java.util.ArrayList;
import org.cityShop.usuario.FavoritoProduto;


public class Produto
{

	public Long id;
	public Long idLoja;	
	public Preco preco;
	public Descricao descricao;
	public ArrayList<Categoria> categorias;
	public ArrayList<FavoritoProduto> favoritados;
	public ItemEstoque estoque;


}
