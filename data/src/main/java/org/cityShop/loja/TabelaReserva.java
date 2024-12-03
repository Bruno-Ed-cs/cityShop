package org.cityShop.loja;

import java.beans.Introspector;
import java.util.ArrayList;

import org.json.JSONArray;

public class TabelaReserva{
	
	public ArrayList<Reserva> reservas;

	public TabelaReserva(){


	}

	public TabelaReserva(JSONArray array){

		this.reservas = new ArrayList<Reserva>();

		for (int i = 0; i < array.length() && !array.isEmpty(); i++){

			Reserva reserva = new Reserva(array.getJSONObject(i));

			this.reservas.add(reserva);
		}
	}

	public JSONArray toJSON(){

		JSONArray json = new JSONArray();

		for (Reserva reserva : this.reservas){

			json.put(reserva.toJSON());
		}

		return json;
	}

	public Integer getQtdVenda() {

		Integer vendas = 0;

		for (Reserva reserva : this.reservas){

			vendas++;
		}


		return vendas;

	}

	public void addReserva(Reserva reserva){

		this.reservas.add(reserva);

	}

}
