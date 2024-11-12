package org.cityShop.testes;

import org.cityShop.produto.*;
import org.json.JSONObject;
import java.io.*;
import java.util.Scanner;


public class Json{

	public static void main(String[] args) {

		Produto prod = new Produto();
		JSONObject json = new JSONObject();
		String path = "./src/resources/";


		File newJson = new File(path + "estado.json");

		if (newJson.exists()) {

			System.out.println("File exists");

			try {


				Scanner reader = new Scanner(newJson);
				//System.out.println(reader.next());
				String file = new String();
				while (reader.hasNextLine()) {

					file = file + reader.nextLine();
					file += "\n";

				}
				System.out.println(file);
				json = new JSONObject(file);
				reader.close();


			} catch (Exception e) {

				e.printStackTrace();
			}


		} else {

			try {


				newJson.createNewFile();
				json.put("Titulo", "Eu sou o batman");
				json.put("Ano", 2200);
				json.put("Puto", true);

			} catch (Exception e) {


				System.out.println("failed to create file" + e.toString());
			}

			try {

				FileWriter writer = new FileWriter(newJson);
				writer.write(json.toString(4));
				writer.close();

			} catch (Exception e) {

				System.out.println("error in writing file" + e.toString());
			}


		}

		System.out.println("It just works " + prod);
		System.out.println(json.toString(4));
	}
}
