package cityShop;

import java.lang.reflect.Array;
import java.util.ArrayList;

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

	public static Usario getInstance(String nome, String cpf, Long id) {

		if(instancia == null) {

			instancia = new Usuario(nome, cpf, id);
		}

		return instancia;
	} 


	//agora, vai estar aplicando os métodos para a adição dos favoritos

	public void adicionarFavoritoProduto(FavoritoProduto favoritoProduto) {

		produtosFavoritos.add(FavoritoProduto);
	}

	public void adicionarFavoritoLoja(FavoritoLoja favoritoLoja) {

		lojasFavoritas.add(FavoritoLoja);
	}

	public ArrayList<FavoritoProduto> getProdutosFavoritos() {

		return produtosFavoritos;
	} 

	public ArrayList<FavoritoLoja> getProdutosFavoritos() {

		return lojasFavoritas;
	}
}
