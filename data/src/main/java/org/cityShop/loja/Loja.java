package org.cityShop.loja;


import org.cityShop.app.*;
import org.cityShop.vendas.*;
import org.cityShop.loja.*;
import org.cityShop.estoque.*;

import java.util.ArrayList;

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
