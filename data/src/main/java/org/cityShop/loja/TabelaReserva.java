package org.cityShop.loja;

import java.net.ResponseCache;
import java.util.ArrayList;

import org.json.JSONArray;

public class TabelaReserva{
	
	public ArrayList<Reserva> reservas;

	public TabelaReserva(JSONArray array){

		this.reservas = new ArrayList<Reserva>();

		for (int i = 0; i < array.length() && !array.isEmpty(); i++){

			Reserva reserva = new Reserva(array.getJSONObject(i));

			this.reservas.add(reserva);
		}
	}



	public Integer getQtdVenda() {

		return null;

	}

	public Reserva getReserva(Long id) {

		return null;
		
	}

}
