package org.cityShop.app;

import java.util.ArrayList;
import org.json.JSONObject;

import org.cityShop.usuario.*;
import org.cityShop.loja.Loja;
import org.cityShop.produto.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.sound.midi.SoundbankResource;
import javax.sound.sampled.BooleanControl;


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

		// teste da possivel criação de produto com dados faikes

		Produto prod = new Produto();

		System.out.println("Produto criado " + prod);

		JSONObject json = new JSONObject();

		json.put("Titulo", "bruno eduardo é femboy");

		json.put("Ano", 2069);

		json.put("ana kelry eh linda", true);

		System.out.println("JSON criado" + json.toString());

		Usuario user = App.getInstance().usuarioLogado;
		System.out.println("Usuário: " + user.nome);
		System.out.println("Lojas favoritas: " + user.favoritos);
		System.out.println("Produtos favoritos: " + user.favoritos);

		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		System.out.println(timestamp);

		Produto[] querry = Database.getInstance().querryProduto();

		for (int i = 0; i < querry.length; i++){

			System.out.println("ID = " + querry[i].id);
			System.out.println("IDLoja = " + querry[i].idLoja);
			System.out.println("Nome = " + querry[i].descricao.nome);
			System.out.println("Descricao = " + querry[i].descricao.corpo);
			System.out.println("Favoritadas = " + querry[i].favoritadas);


			System.out.println("Preço = R$ " + querry[i].getPreco());

			System.out.println("Categorias:");
			for (int j = 0; j < querry[i].categorias.size(); j++){


				System.out.println(querry[i].categorias.get(j));
			}

			System.out.println("");
		}


		System.out.println(FavTypes.PRODUTO);

		Loja[] lojas = Database.getInstance().querryLoja();

		for (int i = 0; i < lojas.length; i++){

			System.out.println(lojas[i].nome);
			System.out.println(lojas[i].aberto);
			System.out.println(lojas[i].favoritadas);

			Usuario dono = Database.getInstance().getUser(lojas[i].dono);

			System.out.println("Dono = " + dono.nome);

			System.out.println("");
		}

		System.out.println(lojas);

		Usuario[] users = Database.getInstance().querryUsuarios();

		for (int i = 0; i < users.length; i++) {

			System.out.println(users[i].nome);
			System.out.println(users[i].cpf);
			System.out.println(users[i].id);
			System.out.println(users[i].lojista);

			System.out.println("Favoritos: ");

			for (int y = 0; y < users[i].favoritos.size(); y++) {

				System.out.println(users[i].favoritos.get(y).getTarget());
			}
			
			System.out.println();
		}

		System.out.println(Database.getInstance().getProduto(2L).descricao.nome);




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
