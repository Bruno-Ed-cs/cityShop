package org.cityShop.loja;
import org.cityShop.usuario.*;

import java.sql.Timestamp;

import org.cityShop.produto.*;

public class Reserva
{

	public Integer qtdProduto;
	public Double precoFinal;
	public Usuario cliente;
	public Produto produto;
	public Timestamp dataReserva;
	public Integer expiracaoHora;
	public Boolean concluido;
	public Boolean pego;

}
