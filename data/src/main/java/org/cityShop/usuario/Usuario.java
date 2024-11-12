package org.cityShop.usuario;

import java.util.ArrayList;
import org.cityShop.produto.*;
import org.cityShop.loja.*;

public class Usuario 
{

	public String nome;
	public String cpf;
	public Long id;

	public ArrayList<FavoritoLoja> lojasFavoritas;
	public ArrayList<FavoritoProduto> produtosFavoritos;

	//implementação singleton, com a instancia unica
	private static Usuario instancia;

	//aplicação do construtor privadp
	private Usuario(String nome, String cpf, Long id) {

		this.nome = nome;
		this.cpf = cpf;
		this.id = id;

		this.lojasFavoritas = new ArrayList<>();
		this.produtosFavoritos = new ArrayList<>();
	}
	
	//criação do método que vai acessar a instancia unica

	public static Usuario getInstance(String nome, String cpf, Long id) {

		if(instancia == null) {

			instancia = new Usuario(nome, cpf, id);
		}

		return instancia;
	} 


	//agora, vai estar aplicando os métodos para a adição dos favoritos

	public void adicionarFavoritoProduto(FavoritoProduto favoritoProduto) {

		produtosFavoritos.add(favoritoProduto);
	}

	public void adicionarFavoritoLoja(FavoritoLoja favoritoLoja) {

		lojasFavoritas.add(favoritoLoja);
	}

	public ArrayList<FavoritoProduto> getProdutosFavoritos() {

		return produtosFavoritos;
	} 

	public ArrayList<FavoritoLoja> getLojasFavoritas() {

		return lojasFavoritas;
	}
}
