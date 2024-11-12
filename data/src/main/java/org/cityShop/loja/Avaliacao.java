package org.cityShop.loja;

import org.cityShop.usuario.*;

public class Avaliacao {

	public Integer nota;
	public String corpo;
	public Usuario autor;

	public Avaliacao(Integer nota, String corpo, Usuario autor) {

		this.nota = nota;
		this.corpo = corpo;
		this.autor = autor;
	}
	
}
