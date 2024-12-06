package org.cityShop.produto;

import org.json.JSONObject;

public class ItemProduto {
	
	public Long idProduto;
	public Double preco;

	public JSONObject toJSON(){

		JSONObject json = new JSONObject();

		json.put("idProduto", this.idProduto);
		json.put("preco", this.preco);

		return json;
	}
}
