package org.cityShop.app;

import java.sql.Date;

public class Main {
	
	public static void main(String[] args) {

		App app = App.getInstance();
		Database database = Database.getInstance();

		database.teste();

		Tui tui = new Tui();
		tui.mainMenu();

		Tui.clearTerminal();

			


	}
}
