package org.cityShop.app;

// classe para a interface no terminal
public class Tui {

	private static Tui instancia;

	private Tui(){

	}

	public Tui getInstance(){

		if (Tui.instancia == null){

			Tui.instancia = new Tui();

		}

		return Tui.instancia;
	}

	public void printProdutos(){

	}

	public void printUsuario() {
		
	}

	public void printSelecao(){

	}
	
}
