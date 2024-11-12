package org.cityShop.loja;

import java.util.ArrayList;

public class TabelaReserva{
	
	public Integer qtdVenda;
	public ArrayList<Reserva> reservas;
	private TabelaReserva instancia;

	private TabelaReserva() {


	}

	public TabelaReserva getInstance() {

		if (this.instancia == null) {


			this.instancia = new TabelaReserva();

		}

		return this.instancia;

	}

	public Integer getQtdVenda() {

		return null;

	}

	public ArrayList<Reserva> getReservas() {

		return null;
		
	}

}
