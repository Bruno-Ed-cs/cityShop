package org.cityShop.app;

import org.cityShop.usuario.*;
import org.cityShop.produto.*;
import org.cityShop.loja.*;
import org.json.*;

import netscape.javascript.JSObject;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.sql.*;




public class Database {
	
	private static Database instance;

	private String path = "./src/resources/";

	private JSONObject database;

	private Database(){

		this.load();
		
	}

	public static Database getInstance(){

		if (Database.instance == null){

			Database.instance = new Database();


		}

		return Database.instance;

	}

	private File getArchive(){

		File file = new File(this.path + "active.json");

		if (!file.exists()){

			File original = new File(this.path + "originalDB.json");

			try {

				file.createNewFile();
				String data = new String();
				Scanner myReader = new Scanner(original);
				while (myReader.hasNextLine()) {
					data += myReader.nextLine() + "\n";

				}

				FileWriter writer = new FileWriter(file.getPath());

				writer.write(data);

				writer.close();
				myReader.close();

			} catch (Exception e){

				System.out.println(e);
			}



		}

		return file;
	}


	public void load(){

		File file = this.getArchive();
		String rawData = new String();

		try {
			Scanner scanner = new Scanner(file);

			while (scanner.hasNextLine()){

				rawData += scanner.nextLine() + "\n";
			}
			scanner.close();

		} catch (Exception e) {

			System.out.println(e);
		}



		//System.out.println(rawData);

		database = new JSONObject(rawData);

	}

	public void save(){

		File file = this.getArchive();

		try{

			FileWriter writer = new FileWriter(file.getPath());
			writer.write(this.database.toString(4));
			writer.close();

		} catch (Exception e){

			System.out.println(e);
		}


	}

	public Usuario getUsuario(Long idUser){

		Usuario[] querry = this.querryUsuarios();

		for (int i = 0; i < querry.length; i++) {

			if (querry[i].id == idUser){

				return querry[i];
			}
			
		}

		return null;
	}

	public Loja getLoja(Long idLoja){

		Loja[] querry = this.querryLoja();

		for (int i = 0; i < querry.length; i++) {

			if (querry[i].id == idLoja){

				return querry[i];
			}
			
		}

		return null;
	}

	public Produto getProduto(Long idProduto){

		Produto[] querry = this.querryProduto();

		for (int i = 0; i < querry.length; i++) {

			if (querry[i].id == idProduto){

				return querry[i];
			}
			
		}


		return null;
	}

	public Produto[] querryProduto(Long idLoja){


		Produto[] querry = this.querryProduto();
		ArrayList<Produto> result = new ArrayList<Produto>();
		Integer count = 0;

		for (int i = 0; i < querry.length; i++){

			if (querry[i].idLoja == idLoja){

				result.add(querry[i]);
				count++;
			}
		}

		querry = new Produto[count];
		querry = result.toArray(querry);

		return querry;
	}

	public Produto[] querryProduto(){

		//System.out.println(database.toString());


		JSONArray produtos = new JSONArray(database.getJSONArray("Produtos"));

		//System.out.println("curprodutos = \n" + produtos.toString());

		Produto[] querry = new Produto[produtos.length()];

		for (int i = 0; i < produtos.length(); i++){


			//System.out.println("produto " + i + " : " + produtos.getJSONObject(i).toString());
			JSONObject curProduto = new JSONObject(produtos.getJSONObject(i).toString());

			//System.out.println("CURRENT = " + curProduto.toString());

			Produto novo = new Produto(curProduto);

			querry[i] = novo;

		}

		return querry;
	}

	public Loja[] querryLoja(){

		JSONArray lojas = new JSONArray(this.database.getJSONArray("Lojas").toString());

		Loja[] querry = new Loja[lojas.length()];

		for (int i = 0; i < lojas.length() && !lojas.isEmpty(); i++){

			Loja loja = new Loja(lojas.getJSONObject(i));

			querry[i] = loja;
		}

		return querry;
	}

	public Usuario[] querryUsuarios(){

		JSONArray usuarios = new JSONArray(this.database.getJSONArray("Usuarios").toString());
		Usuario[] querry = new Usuario[usuarios.length()];

		for (int i = 0; i < usuarios.length(); i++){

			JSONObject usuario = new JSONObject(usuarios.getJSONObject(i).toString());

			querry[i] = new Usuario(usuario);
		}


		return querry;
	}

	public void changeLoja(Loja novaLoja, Long idTarget){


	}

	public void changeProduto(Produto novoProduto, Long idTarget){



	}

	public void changeUsuario(Usuario novoUsuario, Long idTarget){


	}

	public void addProduto(Produto produto){

		JSONObject novo = produto.toJSON();

		this.database.getJSONArray("Produtos").put(novo);

		this.save();


	}

	public void addLoja(Loja loja){

		JSONObject novo = loja.toJSON();

		this.database.getJSONArray("Lojas").put(novo);
		
		this.save();

	}

	public void addUsuario(Usuario usuario){

		JSONObject novo = usuario.toJSON();

		this.database.getJSONArray("Usuarios").put(novo);

		this.save();

	}

	public void removeProduto(Produto produto){


	}

	public void removeLoja(Loja	loja){


	}


	public void removeUsuario(Usuario usuario){


	}

	public void teste(){


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

			Usuario dono = Database.getInstance().getUsuario(lojas[i].dono);

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

		Database database = Database.getInstance();

		Loja nova = database.getLoja(1L);

		nova.id = 3L;
		nova.nome = "hwlvetica";

		database.database.getJSONArray("Lojas").put(nova.toJSON());

		Produto nuevo = new Produto();

		nuevo.idLoja = 1L;
		nuevo.favoritadas = 22L;
		nuevo.id = 44L;
		nuevo.categorias.add("comida");
		nuevo.descricao = new Descricao();
		nuevo.estoque = new ItemEstoque();

		nuevo.descricao.nome = "salsicha";
		nuevo.descricao.corpo = "saborososssss";

		nuevo.estoque.capacidade = 20;
		nuevo.estoque.quantidade = 13;

		database.database.getJSONArray("Produtos").put(nuevo.toJSON());

		Usuario juan = database.getUsuario(2L);

		juan.nome = "Juan";
		juan.id = 3L;
		juan.lojista = true;

		database.database.getJSONArray("Usuarios").put(juan.toJSON());
		
		database.save();


	}

}
