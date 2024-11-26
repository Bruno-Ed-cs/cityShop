package org.cityShop.produto;

import org.json.JSONObject;

public class ItemEstoque {

    public Integer capacidade;
    public Integer quantidade;

    public ItemEstoque(){


    }

    public ItemEstoque(JSONObject json){

	this.capacidade = json.getInt("capacidade") ;

	this.quantidade = json.getInt("quantidade");
    }

    public JSONObject toJSON(){

	JSONObject json = new JSONObject();

	json.put("quantidade", this.quantidade);
	json.put("capacidade", this.capacidade);

	return json;
    }



}
