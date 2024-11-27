package org.cityShop.app;

import java.util.Scanner;
import org.cityShop.usuario.Favoritavel;
import org.cityShop.usuario.Usuario;

public class Tui {

    private static Scanner sc = new Scanner(System.in);

    public void mainMenu() {
        boolean running = true;

        while (running) {
            System.out.println("Bem-vindo ao CityShop! :)");
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
                    System.out.println("Aff, saindo...");
                    running = false;
                    break;

                default:
                    System.out.println("Não tem essa opção, analfabeto. Obrigado :)");
                    break;
            }
        }
    }

    private void loginMenu() {
        System.out.println("Digite o nome do usuário: ");
        sc.nextLine();  // Consume the newline character
        String nomeUsuario = sc.nextLine();

        System.out.println("Digite a senha: ");
        String senha = sc.nextLine();

        App app = App.getInstance();
        Boolean sucesso = app.login(nomeUsuario, senha);

        if (sucesso) {
            System.out.println("Login bem-sucedido!");
        } else {
            System.out.println("Falha ao logar!");
        }
    }

    private void listarLojas() {
        App app = App.getInstance();
        Boolean sucesso = app.listarLojas();
        if (!sucesso) {
            System.out.println("Nenhuma loja cadastrada ainda :(");
        }
    }

    private void listarProdutos() {
        App app = App.getInstance();
        Boolean sucesso = app.listarProdutos();
        if (!sucesso) {
            System.out.println("Nenhum produto cadastrado ainda :(");
        }
    }

    private void listarFavoritos() {

		App app = App.getInstance();

		if (app.usuarioLogado == null) {

			System.out.println("Você precisa logar para ver seus favoritos :(");

			return;
		}
		Boolean sucesso = app.listarFavoritos();

		if (!sucesso) {
			System.out.println("Nenhum favorito encontrado.");
		}
    }

    private void favoritarProduto() {

        System.out.println("Digite o ID do produto para favoritar: ");

    	Long idProduto = null;
		
    try {
        idProduto = sc.nextLong();
    } catch (Exception e) {
        System.out.println("Entrada inválida. Tente novamente.");
        sc.nextLine(); // limpar buffer de entrada
        return;
    }

    App app = App.getInstance();
    Boolean sucesso = app.favoritarProduto(idProduto);

    if (!sucesso) {
        System.out.println("Você precisa logar para favoritar um produto :(");
    } else {
        System.out.println("Produto favoritado com sucesso!");
    }
    }

    private void favoritarLoja() {
        System.out.println("Digite o ID da loja para favoritar: ");
        Long idLoja = sc.nextLong();

        App app = App.getInstance();
        Boolean sucesso = app.favoritarLoja(idLoja);

        if (!sucesso) {
            System.out.println("Você precisa logar para favoritar uma loja :(");
        } else {
            System.out.println("Loja favoritada com sucesso!");
        }
    }

    public static void clearTerminal() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
