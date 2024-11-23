package org.cityShop.loja;

import org.cityShop.usuario.*;

public class Avaliacao {

	public Integer nota;
	public String corpo;
	public Long idUsuario;

	public Avaliacao(Integer nota, String corpo, Long autor) {

		this.nota = nota;
		this.corpo = corpo;
		this.idUsuario = autor;
	}
	
}
