package org.cityShop.usuario;

import java.util.ArrayList;

public class Usuario 
{

	public String nome;
	public String cpf;
	public Long id;

	public ArrayList<FavoritoLoja> lojasFavoritas;
	public ArrayList<FavoritoProduto> produtosFavoritos;


	public ArrayList<FavoritoProduto> getProdutosFavoritos(){

		return this.produtosFavoritos;

	}

	public void adicionarFavoritoLoja(FavoritoLoja favoritoLoja){

		this.lojasFavoritas.add(favoritoLoja);

	}

}
