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

		// Limpar o terminal antes de exibir o menu

		Tui.clearTerminal();

		// Exibir o menu 

		Console console = System.console();

		tui.mainMenu();
	}
}
