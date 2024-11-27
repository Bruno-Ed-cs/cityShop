package org.cityShop.app;

import java.sql.Date;

public class Main {
	
	public static void main(String[] args) {

		App app = App.getInstance();
		Database database = Database.getInstance();

		Tui tui = new Tui();
		tui.mainMenu();
		
		app.run();
		database.teste();

		Tui.clearTerminal();

			


	}
}
