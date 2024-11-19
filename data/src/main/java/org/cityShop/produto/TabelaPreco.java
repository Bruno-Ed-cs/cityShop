package org.cityShop.produto;

import java.sql.Timestamp;
import java.util.ArrayList;

//a tabela de index 0 vai obrigatoriamente ser os precos padroes

public class TabelaPreco {

	public Long id;
	public String nome;
	public Timestamp criacao;
	public Timestamp validade;

	public ArrayList<ItemProduto> produtos;
	
}
