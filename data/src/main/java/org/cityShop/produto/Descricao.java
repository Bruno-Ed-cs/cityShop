package org.cityShop.produto;

import org.json.JSONObject;

public class Descricao 
{
	public String nome;
	public String corpo;

	public Descricao(){


	}


	public Descricao (JSONObject json){

		this.nome = json.getString("nome");
		this.corpo = json.getString("corpo");

	}

	public JSONObject toJSON(){

		JSONObject json = new JSONObject();

		json.put("nome", this.nome);
		json.put("corpo", this.corpo);

		return json;
	}
}
