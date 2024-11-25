package org.cityShop.loja;

import org.json.JSONObject;

public class Local 
{

	public String endereco;
	public String longitude;
	public String latitude;

	public Local(){

	}

	public Local(String endereco, String longitude, String latitude) {
		this.endereco = endereco;
		this.longitude = longitude;
		this.latitude = latitude;
	}

	public JSONObject toJSON(){

		JSONObject json = new JSONObject();

		json.put("endereco", this.endereco);
		json.put("longitude", this.longitude);
		json.put("latitude", this.latitude);

		return json;
	}

}
