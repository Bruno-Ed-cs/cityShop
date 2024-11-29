package org.cityShop.app;

import java.io.Console;
import java.io.InputStream;
import java.lang.reflect.Executable;

import com.sun.source.doctree.SystemPropertyTree;

public class Main {
	
	public static void main(String[] args) {

		// Obter as instâncias únicas de App e Database

		App app = App.getInstance();

		Database database = Database.getInstance();

		// Chamada de teste
		
		database.teste();

		// Instanciar a interface com o usuário (Tui)

		Tui tui = new Tui();

		boolean running = true;

		while (running) {

			Tui.clearTerminal();

			tui.mainMenu(app);

			int choice = tui.getChoice();

			switch (choice) {

				case 1 -> tui.login(app);
				case 2 -> tui.listarLojas(app);
				case 3 -> tui.listarProdutos(app);
				case 4 -> tui.listarFavoritos(app);
				case 5 -> tui.favoritarLoja(app);
				case 6 -> tui.favoritarProduto(app);
				case 7 -> {

					System.out.println("Saindo...");

					running = false;
				}

				default -> System.out.println("NAO TEM ESSA OPÇAO")
		}

		// Limpar o terminal antes de exibir o menu

		Tui.clearTerminal();

		// Exibir o menu 

		Console console = System.console();

		tui.mainMenu();
	}
}


}