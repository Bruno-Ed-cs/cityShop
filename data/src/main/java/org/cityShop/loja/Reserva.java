package org.cityShop.loja;
import org.json.JSONObject;

import java.sql.Timestamp;


public class Reserva
{

	public Long qtdProduto;
	public Double precoFinal;
	public Long cliente;
	public Long produto;
	public Timestamp dataReserva;
	public Timestamp expiracaoHora;
	public Boolean concluido;
	public Boolean pego;

	

	public Reserva(JSONObject json){

		this.qtdProduto = json.getLong("qtdProduto");
		this.precoFinal = json.getDouble("precoFinal");
		this.cliente = json.getLong("cliente");
		this.produto = json.getLong("produto");
		this.dataReserva = Timestamp.valueOf(json.getString("dataReserva"));
		this.expiracaoHora = Timestamp.valueOf(json.getString("expiracaoHora"));
		this.concluido = json.getBoolean("concluido");
		this.pego = json.getBoolean("pego");

	}

	public JSONObject toJSON() {

		JSONObject json = new JSONObject();

		json.put("qtdProduto", this.qtdProduto);
		json.put("precoFinal", this.precoFinal);
		json.put("cliente", this.cliente);
		json.put("produto", this.produto);
		json.put("dataReserva", this.dataReserva.toString());
		json.put("expiracaoHora", this.expiracaoHora.toString());
		json.put("concluido", this.concluido);
		json.put("pego", this.pego);

		return json;
	}

}
