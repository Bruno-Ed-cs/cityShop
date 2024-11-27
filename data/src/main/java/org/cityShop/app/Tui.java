package org.cityShop.app;

import java.util.Scanner;

// classe para a interface no terminal
public class Tui {

	private static Scanner sc = new Scanner(System.in);

	public void mainMenu(){
		

	}

	public static void clearTerminal(){

		System.out.print("\033[H\033[2J");
	}

}
