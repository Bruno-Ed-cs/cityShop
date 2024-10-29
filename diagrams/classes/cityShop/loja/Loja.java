package cityShop.loja;


import cityShop.app.*;
import cityShop.vendas.*;
import cityShop.loja.*;

public class Loja 
{
	public String nome;
	public Long id;

	public Local localizacao;
	public ArrayList<Avaliacao> avaliacoes;

	public TabelaVenda vendas;
	public TabelaProduto produtos;

	public ArrayList<FavoritoLoja> favoritos;
	
}
