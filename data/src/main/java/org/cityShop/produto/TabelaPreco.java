package org.cityShop.produto;

import java.sql.Timestamp;
import java.util.ArrayList;

//a tabela de index 0 vai obrigatoriamente ser os precos padroes
//consertar o json do banco de datos para ter os precos certos

public class TabelaPreco {

	public Long id;
	public String nome;
	public Timestamp criacao;
	public Timestamp validade;
	public Modificador modificador;

	public ArrayList<ItemProduto> produtos;

	public TabelaPreco(Long id, String nome, Timestamp validade, Double modificador){


	}

	public void addProduto(Produto produto){

		//o preco vai ser aplicado com base no modificador da tabela
	}

	
	
}
