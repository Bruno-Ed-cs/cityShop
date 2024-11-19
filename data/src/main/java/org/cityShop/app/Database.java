package org.cityShop.app;

import org.cityShop.usuario.*;
import org.cityShop.produto.*;
import org.cityShop.loja.*;
import org.json.JSONObject;
import java.io.*;
import java.util.Scanner;



public class Database {
	
	private static Database instance;

	private Database(){

		
	}

	public Database getInstance(){

		if (Database.instance == null){

			Database.instance = new Database();


		}

		return Database.instance;

	}


	public void loadDatabase(){


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

		return null;
	}

	public Loja[] querryLoja(Long idDono){

		return null;
	}
}
