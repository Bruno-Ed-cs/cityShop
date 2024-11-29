package org.cityShop.app;
import java.io.*;

import java.util.Scanner;

import org.cityShop.usuario.Favoritavel;
import org.cityShop.usuario.Usuario;


public class Tui {

    private static Scanner sc = new Scanner(System.in);

    public void mainMenu(App app) {

    System.out.println("Bem-vindo ao CityShop! :)");
    System.out.println("Escolha uma opção:");
    System.out.println("1 - Login");
    System.out.println("2 - Listar Lojas");
    System.out.println("3 - Listar Produtos");
    System.out.println("4 - Listar Favoritos");
    System.out.println("5 - Favoritar Loja");
    System.out.println("6 - Favoritar Produto");
    System.out.println("7 - Sair");

    }

        public int getChoice() {
            
            int choice = sc.nextInt();
            sc.nextLine();
            return choice;
        }

        public void login(App app){

        System.out.println("digite o nome do usuario: ");
        String nomeUsuario = sc.nextLine();

        System.out.println("digite a senha: ");
        String senha = sc.nextLine();

        if(app.login (nomeUsuario, senha)) {

            System.out.println("logado com sucesso :D");

        } else {

            System.out.println("falha ao logar :(");
        }
 }

        public void listarLojas(App app) {
            
            if(!app.listarLojas()) {

                System.out.println("falha ao listar lojas :(");
        }
    }
    

        public void listarProdutos(App app) {

            if(!app.listarProdutos()) {

                System.out.println("falha ao listar produtos :(");

            }

        }

        public void listarFavoritos(App app) {

            if(!app.listarFavoritos()) {

                System.out.println("falha ao listar favoritos :(");

            }
        }

        public void favoritarLoja(App app) {

            System.out.println("digite o id da loja: ");

            try {
                
            Long idLoja = sc.nextLong();
            sc.nextLine();

            if(app.favoritarLoja(idLoja) ) {

                System.out.println("loja favoritada com sucesso :)");

            } else {

                System.out.println("falha ao favoritar loja :(");
            }

            } catch (Exception e) {

                System.out.println("Entrada inválida. Tente novamente.");
                sc.nextLine();
            }
        }

        public void favoritarProduto(App app) {

            System.out.println("digite o id do produto: ");

            try {
                
            Long idProduto = sc.nextLong();
            sc.nextLine();

            if(app.favoritarProduto(idProduto) ) {

                System.out.println("produto favoritado com sucesso :)");

            } else {

                System.out.println("falha ao favoritar produto :(");
            }

            } catch (Exception e) {

                System.out.println("Entrada inválida. Tente novamente.");
                sc.nextLine();
            }
        }


    public static void clearTerminal() {
		
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}





