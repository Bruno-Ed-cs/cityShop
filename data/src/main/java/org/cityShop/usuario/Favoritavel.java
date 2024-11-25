package org.cityShop.usuario;

import org.json.JSONObject;

public interface Favoritavel
{

	public Long getTarget();
	public FavTypes getType();
	public JSONObject toJSON();

}
