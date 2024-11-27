package org.cityShop.app;

import java.sql.Date;

public class Main {
	
	public static void main(String[] args) {

		App app = App.getInstance();
		Database database = Database.getInstance();
		app.run();
		database.teste();

		Tui.clearTerminal();

			


	}
}
