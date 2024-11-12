package org.cityShop.app;

import java.util.ArrayList;
import javax.sound.sampled.SourceDataLine;

import org.cityShop.estoque.*;
import org.cityShop.usuario.FavoritoLoja;
import org.cityShop.usuario.FavoritoProduto;
import org.cityShop.usuario.Usuario;
import org.json.JSONObject;


public class App {


	//aplicação do singleton no aplicativo

	private static App instance;

	
	public Usuario usuario;

	
	//construtor

	private App() {

		usuario.nome = "testeJoadodasilva";
		usuario.cpf = "666";
		usuario.id = 0L;
		usuario.lojasFavoritas = new ArrayList<FavoritoLoja>();
		usuario.produtosFavoritos = new ArrayList<FavoritoProduto>();

	}

	public static App getInstance() {

		if (instance == null) {

			instance = new App(); 
		}

		return instance;
	}

	 // run, executa o app

    public void run() {

        // teste da possivel criação de produto com dados faikes

		Produto prod = new Produto();

		System.out.println("Produto criado " + prod);

       JSONObject json = new JSONObejetc();

	   json.put("Titulo", "bruno eduardo é femboy");

	   json.put("Ano", 2069):

	   json.put("ana kelry eh linda", true);

		System.out.println("JSON criado" + json.toString());

		FavoritoLoja = LojaFavorita = new FavoritoLoja();

		FavoritoProduto produtoFavorito = new FavoritoProduto();

		usuario.lojasFavoritas.add(lojasFavoritas);

		usuario.produtosFavoritos.add(produtosFavoritos);
		
		System.out.println("Usuário: " + usuario.nome);
        System.out.println("Lojas favoritas: " + usuario.lojasFavoritas);
        System.out.println("Produtos favoritos: " + usuario.produtosFavoritos);
    }

	public static void main(String[] args) {

		App app = App.getInstance();
        app.run();

}

}
