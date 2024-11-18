package org.cityShop.app;

import java.util.ArrayList;
import org.json.JSONObject;

import org.cityShop.usuario.FavoritoLoja;
import org.cityShop.usuario.FavoritoProduto;
import org.cityShop.usuario.Usuario;
import org.cityShop.loja.Loja;
import org.cityShop.produto.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;


public class App {


	//aplicação do singleton no aplicativo

	private static App instance;


	public Usuario usuario;


	//construtor

	private App() {

		this.usuario = new Usuario();

		this.usuario.nome = "testeJoadodasilva";
		this.usuario.cpf = "666";
		this.usuario.id = 0L;
		this.usuario.lojasFavoritas = new ArrayList<FavoritoLoja>();
		this.usuario.produtosFavoritos = new ArrayList<FavoritoProduto>();

	}

	public static App getInstance() {

		if (instance == null) {

			App.instance = new App(); 
		}

		return instance;
	}

	// run, executa o app

	public void run() {

		// teste da possivel criação de produto com dados faikes

		Produto prod = new Produto();

		System.out.println("Produto criado " + prod);

		JSONObject json = new JSONObject();

		json.put("Titulo", "bruno eduardo é femboy");

		json.put("Ano", 2069);

		json.put("ana kelry eh linda", true);

		System.out.println("JSON criado" + json.toString());

		Usuario user = App.getInstance().usuario;

		FavoritoLoja lojaFavorita = new FavoritoLoja(new Loja(), user);

		FavoritoProduto produtoFavorito = new FavoritoProduto(new Produto(), user);

		user.lojasFavoritas.add(lojaFavorita);

		user.produtosFavoritos.add(produtoFavorito);

		System.out.println("Usuário: " + user.nome);
		System.out.println("Lojas favoritas: " + user.lojasFavoritas);
		System.out.println("Produtos favoritos: " + user.produtosFavoritos);

		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		System.out.println(timestamp);
	}

	public static void main(String[] args) {

		App app = App.getInstance();
		app.run();


	}

}
