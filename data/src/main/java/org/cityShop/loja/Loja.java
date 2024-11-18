package org.cityShop.loja;


import org.cityShop.app.*;
import org.cityShop.usuario.*;
import org.cityShop.loja.*;
import org.cityShop.produto.*;

import java.util.ArrayList;

public class Loja 
{
	public String nome;
	public Long id;
	public Boolean aberto;


	public Local localizacao;
	public TabelaReserva reservas;
	public TabelaProduto produtos;

	public ArrayList<TabelaPreco> tabelasPreco;
	public ArrayList<Avaliacao> avaliacoes;
	public ArrayList<FavoritoLoja> favoritos;
	
}
