package org.cityShop.app;

public class Main {
	
	public static void main(String[] args) {

		// Obter as instâncias únicas de App e Database

		App app = App.getInstance();
		Database database = Database.getInstance();

		// Chamada de teste
		
		database.teste();

		// Instanciar a interface com o usuário (Tui)

		Tui tui = new Tui();

		// Limpar o terminal antes de exibir o menu

		Tui.clearTerminal();

		// Exibir o menu 

		tui.mainMenu();
	}
}
