package org.cityShop.loja;
import org.cityShop.produto.Produto;
import org.cityShop.usuario.Usuario;
import org.json.JSONObject;

import java.sql.Timestamp;


public class Reserva
{

	public Long id;
	public Long qtdProduto;
	public Double precoFinal;
	public Long cliente;
	public Long produto;
	public Timestamp dataReserva;
	public Timestamp expiracaoHora;
	public Boolean concluido;
	public Boolean pego;

	public Reserva(Produto produto, Usuario usuario, Long qtdProduto, Long prazoHoras, Long id){

		this.qtdProduto = qtdProduto;
		this.id = id;

		Timestamp curtime = new Timestamp(System.currentTimeMillis());
		this.dataReserva = curtime;
		this.expiracaoHora = new Timestamp(curtime.getTime() + 1000 * (3600L * prazoHoras));

		this.cliente = usuario.id;
		this.produto = produto.id;
		this.precoFinal = produto.getPreco();

		this.concluido = false;
		this.pego = false;
	}

	public Reserva(JSONObject json){

		this.qtdProduto = json.getLong("qtdProduto");
		this.precoFinal = json.getDouble("precoFinal");
		this.cliente = json.getLong("cliente");
		this.produto = json.getLong("produto");
		this.dataReserva = Timestamp.valueOf(json.getString("dataReserva"));
		this.expiracaoHora = Timestamp.valueOf(json.getString("expiracaoHora"));
		this.concluido = json.getBoolean("concluido");
		this.pego = json.getBoolean("pego");
		this.id = json.getLong("id");

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
		json.put("id", this.id);

		return json;
	}

	public Boolean isActive(){

		Timestamp curtime = new Timestamp(System.currentTimeMillis());

		if (!this.expiracaoHora.after(curtime)){

			this.concluido = false;

			return false;
		} else {

			return true;
		}
	}

}
