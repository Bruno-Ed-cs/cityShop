package org.cityShop.produto;

import org.json.JSONObject;

public class Descricao 
{
	public String nome;
	public String corpo;


	public Descricao (JSONObject json){

		this.nome = json.getString("nome");
		this.corpo = json.getString("corpo");

	}
}
