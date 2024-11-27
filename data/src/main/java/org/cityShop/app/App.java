package org.cityShop.app;

import org.json.JSONObject;

import org.cityShop.usuario.*;
import org.cityShop.loja.Loja;
import org.cityShop.produto.*;
import java.sql.Timestamp;


public class App {


	//aplicação do singleton no aplicativo

	private static App instance;


	public Usuario usuarioLogado;
	public Loja loadedShop;
	public Produto loadedProduto; //para carregar a pagina do produto em si


	//construtor

	private App() {

		this.usuarioLogado = new Usuario("testeJoadodasilva", "772.33.11.2", 20L, true);
	}

	public static App getInstance() {

		if (instance == null) {

			App.instance = new App(); 
		}

		return instance;
	}

	// run, executa o app

	public void run() {
	}

	//funcoes para criar as entidades do app
	// retornam booleanos pois esse é o sturuas da operacao, se falhar retorna false se for bem sucedidada retorna true
	
	public Boolean createUsuario(){

		return null;
	}

	
	public Boolean createProduto(){

		return null;
	}	

	public Boolean createLoja(){

		return null;
	}

	//funcoes para logar e delogar usuario armazenado no singleton

	public Boolean login(){

		return null;
	}

	public Boolean logout(){

		return null;
	}

	// funcoes de navegacao
	

	public Boolean listarProdutos(){

		Database database = Database.getInstance();

		Produto[] produtos = database.querryProdutos();

		if(produtos.length == 0) {

			System.out.println("nenhum produto cadastrado ainda :(");

			return false;

		} else {

			for (Produto produto : produtos) {

				System.out.println("Produto: " + produto.getNome());
		}

		return true;
	}

	}

	public Boolean listarLojas(){

		Database database = Database.getInstance();

		Loja[] lojas = database.querryLojas();

		if(lojas.length == 0) {

			System.out.println("nenhuma loja cadastrada ainda :(");

			return false;

		} else {

			for (Loja loja : lojas) {

				System.out.println("Loja: " + loja.getNome());
				
		}

			return true;

		}
;
	}

	public Boolean listarFavoritos(FavTypes type){

		Usuario usuario = App.getInstance().usuarioLogado;
		

		if (usuario != null) {

			System.out.println("Favoritos de: " + usuario.getNome() + ":");

			boolean encontrouLojaFavorita = false;
			boolean encontrouProdutoFavorito = false;

			System.out.println("\n--- Lojas Favoritas ---");

			for ( Favoritavel favorito : usuario.getFavoritos()) {

				if (favorito.getType() == FavTypes.LOJA) {

					System.out.println(favorito.toJSON());

					encontrouLojaFavorita = true;

				}

					return true;
		}

		if(!encontrouLojaFavorita) {

			System.out.println("Nenhuma loja favorita ainda :(");

			return false;

		}

		System.out.println("\n--- Produtos Favoritos ---");

		for ( Favoritavel favorito : usuario.getFavoritos()) {

			if (favorito.getType() == FavTypes.PRODUTO) {

				System.out.println(favorito.toJSON());

				encontrouProdutoFavorito = true;

				
			}

				return true;
		}

		if(!encontrouProdutoFavorito) {

			System.out.println("Nenhum produto favorito ainda :(");

			return false;
		} 

		else {

			System.out.println("voce precisa logar para ver seus favoritos :(");

			return false;
		}

		}
	}

	public Boolean FavoritarLoja(){


		System.out.println("digite ID da loja p/a favoritar: ");
		Long idLoja = sc.nextLong();
		sc.nextLine();

		sc.nextLine();

		Usuario usuario = App.getInstance().usuarioLogado;

		if (usuario != null) {

			FavoritoLoja favorito = new FavoritoLoja(idLoja, usuario.getId());

			usuario.addFavorito(favorito);
			System.out.println("Loja favoritada com sucesso!");

			return true;

		} else {

			System.out.println("voce precisa logar para favoritar uma loja :(");

			return false;
		}
	}

	public Boolean favoritarProduto(){

		System.out.println("digite o ID do produto p/a favoritar: ");
		Long idProduto = sc.nextLong();
		sc.nextLine();

		sc.nextLine();

		Usuario usuario = App.getInstance().usuarioLogado;

		if (usuario != null) {

			FavoritoPorduto favorito = new FavoritoProduto(idProduto, usuario.getId());

			usuario.addFavorito(favorito);
			System.out.println("Produto favoritado com sucesso!");

			return true;

		} else {

			System.out.println("voce precisa logar para favoritar um produto :(");

			return false;
		} 

	}

	public Boolean showUsuario(){


		return null;
	}

	public Boolean reservarProduto(){

		return null;
	}

	//modificar loja
	
	public Boolean acessLoja(){

		return null;
	}

	public Boolean acessProduto(){

		return null;
	}



}
