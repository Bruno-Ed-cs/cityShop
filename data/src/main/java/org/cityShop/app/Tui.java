package org.cityShop.app;

import java.util.Scanner;

import org.cityShop.usuario.Favoritavel;
import org.cityShop.usuario.Usuario;

// classe para a interface no terminal

public class Tui {

	private static Scanner sc = new Scanner(System.in);

	public void mainMenu(){

		boolean running = true;

		while (running) {

			System.out.println("bem vindo ao cityshop! :)");
			System.out.println("Escolha uma opção:");
			System.out.println("1 - Login");
			System.out.println("2 - Listar Lojas");
			System.out.println("3 - Listar Produtos");
			System.out.println("4 - Listar Favoritos");
			System.out.println("5 - Favoritar Loja");
			System.out.println("6 - Favoritar Produto");
			System.out.println("7 - Sair");

			int choice = sc.nextInt();

			switch (choice) {
				case 1:

				loginMenu();

					break;

				case 2:

				listarLojas();

					break;

				case 3:

				listarProdutos();

				break;

				case 4:

				listarFavoritos();

				break;

				case 5:

				favoritarProduto();

				break;

				case 6:

				favoritarLoja();

				break;

				case 7:

				System.out.println("aff, saindo...");

				running = false;

				break;

				default:
					System.out.println("NAO TEM ESSA OPÇÃO, ANALFABETO. obrigado :)");

		}
		

	}

}

	private void loginMenu() {

		System.out.println("digite o nome do usuario: ");
		sc.nextLine();
		String nomeUsuario = sc.nextLine();

		System.out.println("digite a senha: ");
		String senha = sc.nextLine();

		App app = App.getInstance();
		Usuario usuario = app.usuarioLogado;

		
	}

	private void listarLojas() {

		
	}

	private void ListarProdutos() {

		

	}

	private void listarFavoritos() {

		
	}

	private void favoritarProduto() {

		
	}

	private void favoritarLoja() {

		
	}

	public static void clearTerminal(){

		System.out.print("\033[H\033[2J");
	}

		



}



