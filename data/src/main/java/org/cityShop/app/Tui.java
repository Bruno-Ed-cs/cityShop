package org.cityShop.app;
import java.io.*;

import java.util.Scanner;

import org.cityShop.produto.Produto;
import org.cityShop.usuario.Favoritavel;
import org.cityShop.usuario.Usuario;


public class Tui {

    private static Scanner sc = new Scanner(System.in);

    public static void mainMenu() {



        Tui.clearTerminal();
        System.out.println("Bem-vindo ao CityShop! :)");
        System.out.println("Escolha uma opção:");
        System.out.println("1 - Login");
        System.out.println("2 - Listar Lojas");
        System.out.println("3 - Listar Produtos");
        System.out.println("4 - Listar Favoritos");
        System.out.println("5 - Favoritar Loja");
        System.out.println("6 - Favoritar Produto");
        System.out.println("0 - Sair");

    }

    public static int getChoice(int max, int min) {

        int choice = -1;
        boolean validChoice = false;
        
        while (!validChoice) {

            System.out.print("Digite sua escolha: ");
            
            try {

                choice = sc.nextInt();  
                sc.nextLine(); 
                
                if (choice >= min && choice <= max) {

                    validChoice = true;  

                } else {

                    System.out.println("Opção inválida. Por favor, escolha uma opção entre " + min +" e " + max);

                }
            } catch (Exception e) {

                System.out.println("VOCE NUM TA VENDO QUE SO TEM 7 OPÇÕES SEU ABESTALHADO >:(");
                sc.nextLine();  
                
            }
        }
        
        return choice;
    }
    
    public static void login(App app){

        Tui.clearTerminal();

        System.out.println("digite o nome do usuario: ");
        String nomeUsuario = sc.nextLine();

        System.out.println("digite a senha: ");
        String senha = sc.nextLine();

        if(app.login(nomeUsuario, senha)) {

            System.out.println("logado com sucesso :D");
        } else {
            System.out.println("Falha ao logar >:()");
        }

        Tui.hold();
    }

    private static  void listarFavoritos() {

        Tui.clearTerminal();

        App app = App.getInstance();

        if (app.usuarioLogado == null) {

            System.out.println("Você precisa logar para ver seus favoritos :(");

            return;
        }
        Boolean sucesso = app.listarFavoritos();

        if (!sucesso) {
            System.out.println("Nenhum favorito encontrado.");
        }

        Tui.hold();
    }

    private static  void favoritarProduto() {

        Tui.clearTerminal();

        Produtos[] produtos = app.getProdutosDisponiveis();

        if(produtos == null || produtos.length == 0) {
            
            System.out.println("Nenhum produto cadastrado ainda :(");
            Tui.hold();
            return;
        }

        System.out.println("Escolha um produto p/ favoritar: ");

        for (int i = 0; i < produtos.length; i++) {

            System.out.println(produtos[i].id + " - " + produtos[i].nome);
        }

        System.out.println("< 0 - Voltar");

        int choice = Tui.getChoice(produtos.length, 0);

        if (choice == 0) {
            	
            return;
        }

        Produto produtoSelecionado = produtos[choice - 1];
        boolean sucesso = app.favoritarProduto(produtoSelecionado.id);
        System.out.println(sucesso ? "Produto favoritado com sucesso!" : "Falha ao favoritar produto");
        Tui.hold();

    }

    private static  void favoritarLoja() {

        Tui.clearTerminal();

        Lojas[] lojas = app.getLojasDisponiveis();

        if(lojas == null || lojas.length == 0) {
            
            System.out.println("Nenhuma loja cadastrada ainda :(");
            Tui.hold();
            return;
        }

        System.out.println("Escolha uma loja p/ favoritar: ");

        for (int i = 0; i < lojas.length; i++) {

            System.out.println(lojas[i].id + " - " + lojas[i].nome);
        }

        System.out.println("< 0 - Voltar");

        int choice = Tui.getChoice(lojas.length, 0);

        if (choice == 0) {
            	
            return;
        }

        Loja lojaSelecionada = lojas[choice - 1];
        boolean sucesso = app.favoritarLoja(lojaSelecionada.id);
        System.out.println(sucesso ? "Loja favoritada com sucesso!" : "Falha ao favoritar loja");
        Tui.hold();

    }

    public static void listarLojas(Loja[] lojas) {

       int count = 1;

            if (lojas == null) {

                System.out.println("falha ao listar lojas :(");
                return;
            }

            Tui.clearTerminal();

            System.out.println("=====================Lojas====================");

            for (Loja loja : lojas) {

                System.out.println();
                System.out.println("opções => " + count);
                System.out.println(loja.getNome());
                System.out.println(loja.descricao.corpo);
                System.out.println(loja.categorias);
                System.out.println("R$ " + loja.getPreco());
                System.out.println("Favoritos: " + loja.favoritadas);

                count++;

            }

            System.out.println();
            System.out.println("< 0 - voltar");

            return;
           
    }


    public static void listarProdutos(Produto[] produtos) {

        int count = 1;

        if(produtos == null) {

            System.out.println("falha ao listar produtos :(");
            return;

        }

        Tui.clearTerminal();
        System.out.println("=====================Produtos====================");

        for (Produto prod : produtos){

            System.out.println();
            System.out.println("opções => " + count);
            System.out.println(prod.getNome());
            System.out.println(prod.descricao.corpo);
            System.out.println(prod.categorias);
            System.out.println("R$ " + prod.getPreco());
            System.out.println("Favoritos: " + prod.favoritadas);

            count++;

        }

        System.out.println();
        System.out.println("< 0 - voltar");

        return; 

    }

    public static void listarFavoritos(App app) {

        if(!app.listarFavoritos()) {

            System.out.println("falha ao listar favoritos :(");

        }
    }

    public static void favoritarLoja(App app) {

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

    public static void favoritarProduto(App app) {

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

    public static void menuProduto(Produto produto){

        Tui.clearTerminal();

        System.out.println();
        System.out.println("Nome: " + produto.getNome());
        System.out.println();
        System.out.println("Descrição : " + produto.descricao.corpo);
        System.out.println("Tags: " + produto.categorias);
        System.out.println("Favoritos: " + produto.favoritadas);
        System.out.println("R$ " + produto.getPreco());
        System.out.println();
        System.out.println("Capacidade: " + produto.estoque.capacidade);
        System.out.println("Quandtidade disponível: " + produto.estoque.quantidade);
        System.out.println();

        System.out.println("Opções");
        System.out.println("1 => Favoritar");
        System.out.println("2 => Reservar");

        System.out.println();

        System.out.println("0 => Voltar");



    }

    public static void menuLoja(Loja loja){

        Tui.clearTerminal();

        System.out.println();
        System.out.println("Nome: " + loja.getNome());
        System.out.println();
        System.out.println("Descrição : " + loja.descricao.corpo);
        System.out.println("Tags: " + loja.categorias);
        System.out.println("Favoritos: " + loja.favoritadas);
        System.out.println("R$ " + loja.getPreco());
        System.out.println();
        System.out.println("Capacidade: " + loja.estoque.capacidade);
        System.out.println("Quandtidade disponível: " + loja.estoque.quantidade);
        System.out.println();

        System.out.println("Opções");
        System.out.println("1 => Favoritar");
        System.out.println("2 => Reservar");

        System.out.println();

        System.out.println("0 => Voltar");

    }


    public static void clearTerminal() {

        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void hold(){

        System.out.println("Pressione Enter para continuar...");

        try {

            System.in.read();

        } catch (IOException e){ 

            System.out.println(e);

        }
    }

}





