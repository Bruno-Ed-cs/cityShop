package org.cityShop.loja;

import org.json.JSONObject;

public class Avaliacao {

	public Integer nota;
	public String corpo;
	public Long idUsuario;

	public Avaliacao(Integer nota, String corpo, Long autor) {

		if (nota > 5){

			nota = 5;
		}

		this.nota = nota;
		this.corpo = corpo;
		this.idUsuario = autor;
	}

	public JSONObject toJSON(){

		JSONObject json = new JSONObject();

		json.put("nota", this.nota);
		json.put("corpo", this.corpo);
		json.put("idUsuario", this.idUsuario);


		return json;
	}
	
}
