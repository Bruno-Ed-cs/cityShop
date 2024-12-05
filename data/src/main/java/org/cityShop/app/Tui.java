package org.cityShop.app;
import java.io.*;

import java.util.Scanner;

import javax.security.sasl.Sasl;
import javax.xml.crypto.Data;

import org.cityShop.loja.*;
import org.cityShop.produto.*;
import org.cityShop.usuario.*;


public class Tui {

    private static Scanner sc = new Scanner(System.in);

    public static void mainMenu() {


        App app = App.getInstance();

        Tui.clearTerminal();
        System.out.println("Bem-vindo ao CityShop! :)");
        System.out.println("Escolha uma opção:");
        System.out.println("1 - Login");
        System.out.println("2 - Cadastro");

        if (app.isLogged()){

            System.out.println("3 - Logout");
            System.out.println("4 - Listar Loja");
            System.out.println("5 - Listar Produtos");
            System.out.println("6 - Listar Favoritos");

            if (app.isLojista()){

                System.out.println("7 - Gerenciar Loja");
            }

        } else {

            System.out.println();
            System.out.println("!! Para acessar o app completo, pro favoe entre com um usuario !!");
            System.out.println();
        }
        System.out.println("0 - Sair");

    }

    public static void login(App app){

        Tui.clearTerminal();

        Scanner sc = new Scanner(System.in);

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

    public static int getChoice(int max, int min) {

        int choice = -1;
        boolean validChoice = false;
        
        while (!validChoice) {

            System.out.print("Digite sua escolha: ");
            
            try {

                choice = sc.nextInt();  
                
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

        Database database = Database.getInstance();

        Produto[] produtos = database.querryProduto();

        if(produtos == null || produtos.length == 0) {
            
            System.out.println("Nenhum produto cadastrado ainda :(");
            Tui.hold();
            return;
        }

        System.out.println("Escolha um produto p/ favoritar: ");

        for (int i = 0; i < produtos.length; i++) {

            System.out.println(produtos[i].id + " - " + produtos[i].getNome());
        }

        System.out.println("< 0 - Voltar");

        int choice = Tui.getChoice(produtos.length, 0);

        if (choice == 0) {
            	
            return;
        }

        Produto produtoSelecionado = produtos[choice - 1];

        App app = App.getInstance();
        boolean sucesso = app.favoritarProduto(produtoSelecionado.id);
        System.out.println(sucesso ? "Produto favoritado com sucesso!" : "Falha ao favoritar produto");
        Tui.hold();

    }

    private static void favoritarLoja() {

        Tui.clearTerminal();

        Database database = Database.getInstance();

        Loja[] lojas = database.querryLoja();

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
        App app = App.getInstance();
        boolean sucesso = app.favoritarLoja(lojaSelecionada.id);
        System.out.println(sucesso ? "Loja favoritada com sucesso!" : "Falha ao favoritar loja");
        Tui.hold();

    }

    public static void listarLoja(Loja[] lojas) {

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
            System.out.println(loja.nome);
            System.out.println("Favoritos: " + loja.favoritadas);
            System.out.println("Localização: " + loja.localizacao.endereco);
            System.out.println("Nota: " + loja.getMediaNotas() + "/5");

            if (loja.aberto){

                System.out.println("Aberto");
            } else {

                System.out.println("Fechado");
            }




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

        Database database = Database.getInstance();

        Tui.clearTerminal();
        System.out.println("=====================Produtos====================");

        for (Produto prod : produtos){

            Local place = database.getLoja(prod.idLoja).localizacao;

            System.out.println();
            System.out.println("opções => " + count);
            System.out.println(prod.getNome());
            System.out.println(prod.descricao.corpo);
            System.out.println(prod.categorias);
            System.out.println("Localização: " + place.endereco);
            System.out.println("R$ " + prod.getPreco());
            System.out.println("Favoritos: " + prod.favoritadas);

            count++;

        }

        System.out.println();
        System.out.println("<<<< 0 => Back");
        return; 

    }

    public static void listarFavoritos(App app) {

        if(!app.listarFavoritos()) {

            System.out.println("falha ao listar favoritos :(");

        }
    }


    public static void menuProduto(Produto produto, Boolean isFavorito, Loja loja, Long idUsuario){

        Tui.clearTerminal();

        System.out.println("==================================================Produto==================================================");

        System.out.println();

        System.out.println("Loja: " + loja.nome);
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

        if (isFavorito){

            System.out.println("Favorito: ");
        } else {

            System.out.println("Favorito: ");

        }

        System.out.println("Reservas: ");

        for (Reserva reserva : loja.reservas.reservas){

            if (!reserva.concluido && reserva.cliente == idUsuario && reserva.isActive()){

                System.out.println("Id: " + reserva.id);
                System.out.println("Válido até: " + reserva.expiracaoHora.toString());
                System.out.println("Quandtidade: " + reserva.qtdProduto);
                System.out.println();
            }

        }

        System.out.println("Opções");
        if (isFavorito){

            System.out.println("1 => Remover Favorito");
        } else {

            System.out.println("1 => Favoritar");
        }

        System.out.println("2 => Reservar");

        System.out.println("3 => Acessar loja");

        System.out.println("4 => Cancelar Reserva");

        System.out.println();

        System.out.println("0 => Voltar");



    }

    public static void menuLoja(Loja loja, Boolean isFavorito){

        Database database = Database.getInstance();

        Tui.clearTerminal();
        System.out.println("===========================================" + loja.nome + "===========================================");
        System.out.println("Dono: " + database.getUsuario(loja.dono).nome);
        System.out.println("Favoritos: " + loja.favoritadas);
        System.out.println();
        System.out.println("Endereço: " + loja.localizacao.endereco);
        System.out.println("Coordenadas: " + loja.localizacao.latitude + " " + loja.localizacao.longitude);
        System.out.println();
        System.out.println("Nota: " + loja.getMediaNotas() + "/5");

        String estrela = isFavorito? "" : "";
        System.out.println("Favorito: " + estrela);

        if (loja.aberto){

            System.out.println("Aberto");
        } else {

            System.out.println("Fechado");
        }

        //listar produtos
        //favoritar
        //adicionar avaliacao
        //listar avaliacoes

        System.out.println("Opções: ");
        System.out.println("1 => Listar Produtos");

        if (isFavorito){

            System.out.println("2 => Remover Favorito");
        } else {
            System.out.println("2 => Favoritar Loja");
        }

        System.out.println("3 => Deixar Avaliação");
        System.out.println("4 => Ver Avaliações");
        System.out.println();
        System.out.println("<<<<<< 0 => Voltar");



    }

    public static void printAvaliacao(Avaliacao avaliacao){

        System.out.println();
        System.out.println("Nota: " + avaliacao.nota + "/5");

        StringBuilder corpo = new StringBuilder(avaliacao.corpo);


        for (int i = 0; i < corpo.length(); i++){

            if (i % 100 == 0){
                corpo.insert(i, "\n");
            }
            
        }

        System.out.println("Corpo: \n" + corpo.toString());
        System.out.println();

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





