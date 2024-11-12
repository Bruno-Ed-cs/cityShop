package org.cityShop.app;

import org.cityShop.produto.*;
import org.json.JSONObject;


public class App {

	public static void main(String[] args) {

		Produto prod = new Produto();
		JSONObject json = new JSONObject();

		json.put("Titulo", "Eu sou o batman");
		json.put("Ano", 2200);
		json.put("Puto", true);

		System.out.println("It just works " + prod);
		System.out.println(json.toString());
	}
}
