package org.cityShop.app;

import java.util.Scanner;

import jdk.javadoc.internal.doclets.formats.html.SourceToHTMLConverter;

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

				listarFavoritos();ç

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
		String nomeUsuario = sc.nextLine();

		System.out.println("digite a senha: ");
		String senha = sc.nextLine();

		App app = App.getInstance();
		Usuario usuario = app.usuarioLogado;

		if (usuario != null && usuario.getNome().equals(nomeUsuario)) {

			System.out.println("logado com sucesso! :)");

		} else {

			System.out.println("falha ao logar!");
		}
	
	}

	private void listarLojas() {

		Database database = Database.getInstance();

		Loja[] lojas = database.querryLojas();

		if(lojas.length == 0) {

			System.out.println("nenhuma loja cadastrada ainda :(");

		} else {

			for (Loja loja : lojas) {

				System.out.println("Loja: " + loja.getNome());
		}

		}

	}








	public static void clearTerminal(){

		System.out.print("\033[H\033[2J");
	}

		

















}



