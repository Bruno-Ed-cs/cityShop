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

		return null;
	}

	public Boolean listarLojas(){

		return null;
	}

	public Boolean listarFavoritos(FavTypes type){

		return null;
	}

	public Boolean FavoritarLoja(){


		return null;
	}

	public Boolean favoritarProduto(){

		return null;
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
