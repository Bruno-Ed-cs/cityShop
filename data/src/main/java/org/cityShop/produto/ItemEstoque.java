package org.cityShop.produto;

import org.json.JSONObject;

public class ItemEstoque {

    public Integer quantidadeTotal;
    public Integer quantidadeReserva;

	public ItemEstoque(JSONObject json){

		this.quantidadeTotal = json.getInt("capacidade") ;

		this.quantidadeReserva = json.getInt("quantidade");
	}


}
