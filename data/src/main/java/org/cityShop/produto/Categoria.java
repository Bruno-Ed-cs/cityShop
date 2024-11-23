package org.cityShop.produto;

import org.json.JSONObject;

public class Categoria 
{
	
	public String nome;

	public Categoria(JSONObject json){

		this.nome = json.getString("nome");
	}
}
