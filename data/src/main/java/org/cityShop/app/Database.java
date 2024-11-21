package org.cityShop.app;

import org.cityShop.usuario.*;
import org.cityShop.produto.*;
import org.cityShop.loja.*;
import org.json.*;
import java.io.*;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import javax.sound.midi.SoundbankResource;
import javax.swing.ActionMap;



public class Database {
	
	private static Database instance;

	private String path = "./src/resources/";

	private JSONObject database;

	private Database(){

		
	}

	public static Database getInstance(){

		if (Database.instance == null){

			Database.instance = new Database();


		}

		return Database.instance;

	}


	public void loadDatabase(){


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

	public void saveDatabase(){


	}

	public Usuario getUser(Long idUser){


		return null;
	}

	public Loja getLoja(Long idLoja){

		return null;
	}

	public Produto getProduto(Long idProduto){


		return null;
	}

	public Boolean addProduto(Produto produto){

		return null;
	}

	public Boolean addLoja(Loja	loja){

		return null;
	}


	public Boolean addUsuario(Usuario usuario){

		return null;
	}


	public Produto[] querryProduto(Long idLoja){

		this.loadDatabase();

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

		this.loadDatabase();
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

	public Loja[] querryLoja(Long idDono){

		return null;
	}

	public Boolean changeLoja(Loja novaLoja, Long idTarget){

		return null;
	}

	public Boolean changeProduto(Produto novoProduto, Long idTarget){


		return null;
	}
}
