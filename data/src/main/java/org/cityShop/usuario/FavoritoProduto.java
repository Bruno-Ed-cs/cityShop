package org.cityShop.usuario;

import org.json.*;


//classe "FavoritoProduto" adiciona os produtos favoritos do usuário e tambem implementa a interface favoritavel

public class FavoritoProduto implements Favoritavel

{

	public Long idUsuario;
	public Long idTarget;
	public FavTypes type = FavTypes.PRODUTO;

	public FavoritoProduto(Long idUsuario, Long idTarget) {

		this.idUsuario = idUsuario;
		this.idTarget = idTarget;
		this.type = FavTypes.PRODUTO;
	}


	@Override
	public JSONObject toJSON() {

		JSONObject json = new JSONObject();

		json.put("type", "PRODUTO");
		json.put("id", this.idTarget);
		
		return json;
	}

	public Long getTarget() {
		
		return this.idTarget;
	}

	public Long getIdTargeLong() {

		return idUsuario;

	}

	@Override
	public FavTypes getType() {

		return type;

	}


}
