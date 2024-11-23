package org.cityShop.loja;


import org.cityShop.app.*;
import org.cityShop.usuario.*;
import org.json.JSONArray;
import org.json.JSONObject;
import org.cityShop.loja.*;
import org.cityShop.produto.*;

import java.util.ArrayList;

import javax.swing.text.TabSet;

public class Loja 
{
	public String nome;
	public Long id;
	public Boolean aberto;
	public Long dono;
	public Long favoritadas;

	public Local localizacao;
	public TabelaReserva reservas;

	public ArrayList<TabelaPreco> tabelasPreco;
	public ArrayList<Avaliacao> avaliacoes;

	public Loja(){


	}

	public Loja(JSONObject json){

		this.nome = json.getString("nome");
		this.id = json.getLong("id");
		this.aberto = json.getBoolean("aberto");
		this.favoritadas = json.getLong("favoritadas");
		this.dono = json.getLong("dono");

		JSONObject local = new JSONObject(json.getJSONObject("localizacao").toString());

		if (local.isEmpty()){

			this.localizacao = new Local();
		} else{

			this.localizacao = new Local(
				local.getString("endereco"),
				local.getString("longitude"),
				local.getString("latitude")
			);
		}


		JSONArray precos = new JSONArray(json.getJSONArray("tabelasPreco").toString());
		this.tabelasPreco = new ArrayList<TabelaPreco>();

		for (int i = 0; i < precos.length() && !precos.isEmpty(); i++){

			TabelaPreco tabela = new TabelaPreco(precos.getJSONObject(i));

			this.tabelasPreco.add(tabela);

		}

		this.reservas = new TabelaReserva(json.getJSONArray("reservas"));

		JSONArray avaliacoes = new JSONArray(json.getJSONArray("avaliacoes").toString());
		this.avaliacoes = new ArrayList<Avaliacao>();


		for (int i = 0; i < avaliacoes.length(); i++){
			this.avaliacoes.add(
				new Avaliacao(
					avaliacoes.getJSONObject(i).optInt("nota", 0),
					avaliacoes.getJSONObject(i).optString("corpo", ""),
					avaliacoes.getJSONObject(i).optLong("idUsuario", 0L))
			);


		}
	}

	public TabelaPreco getBaseTabelaPreco(){

		return null;
	}

	public TabelaPreco getActiveTabelaPreco(){

		return null;
	}

	public Boolean addProduto(Produto produto){


		return null;
	}

	public void addFavorito(Long idUsuario){

	}
	
}
