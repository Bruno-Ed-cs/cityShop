package org.cityShop.app;

import org.cityShop.usuario.*;
import org.cityShop.loja.Loja;
import org.cityShop.loja.Reserva;
import org.cityShop.produto.*;

import java.util.Scanner;

import javax.xml.crypto.Data;

import org.cityShop.app.Database;

public class App {

    // singleton

    private static App instance;

    public Usuario usuarioLogado;
    public Loja loadedShop;
    public Produto loadedProduto;

    // Construtor

    private App() {
        //teste

        //this.usuarioLogado = new Usuario("testeJoadodasilva", "772.33.11.2", 20L, true, "12345");
    }

    // Método para garantir que apenas uma instância do App seja criada

    public static App getInstance() {
        if (instance == null) {

            instance = new App();
        }
        return instance;
    }

    public void cadastro() {

        Database database = Database.getInstance();
        Scanner sc = new Scanner(System.in);

        Tui.clearTerminal();

        System.out.println("digite o nome do usuario: ");
        String nome = sc.nextLine();

        System.out.println("Digite a sua senha: ");
        String senha = sc.nextLine();

        System.out.println("digite o seu cpf uWu");
        String cpf = sc.nextLine();

        Usuario [] usuarios = database.querryUsuarios();

        Long maior = 0L;

        for (Usuario usuario: usuarios) {

            if (usuario.id > maior) {

                maior = usuario.id;
            }
        }

        long Novoid = maior + 1;

        Boolean isLojista = null;

        while (isLojista == null) {

            System.out.println("voce eh lojista? (sim/nao)");

            String resposta = sc.nextLine().toLowerCase();


            if(resposta.compareToIgnoreCase("sim") == 0) {

                isLojista = true;

            } else if (resposta.compareToIgnoreCase("nao") == 0) { 

                isLojista = false;

            } else {

                System.out.println("NAO TA CERTO.");
            }

        }

        Usuario user = new Usuario(nome, cpf, Novoid, isLojista, senha );

        database.addUsuario(user);


    }

    public Boolean isLojista(){

        return this.usuarioLogado.lojista;

    }


    public Boolean isLogged(){

        if (this.usuarioLogado != null){

            return true;

        } else {

            return false;
        }
    }

    // Função de login

    public Boolean login(String nomeUsuario, String senha) {

        Database database = Database.getInstance();
        Usuario [] usuarios = database.querryUsuarios();

        for (Usuario usuario: usuarios) {

            if (usuario.nome.equals(nomeUsuario) && usuario.senha.equals(senha)) {
                usuarioLogado = usuario;
                return true;
            }
        }

        System.out.println("Usuário ou senha incorretos :(");
        return false;

    }

    // Função de logout
    public Boolean logout() {
        usuarioLogado = null;
        System.out.println("Deslogado com sucesso.");
        return true;
    }

    // Listar produtos

    public void listarProdutos() {

        Database database = Database.getInstance();
        Produto[] produtos = database.querryProduto();

        if (produtos.length == 0) {

            System.out.println();

        }

        Tui.listarProdutos(produtos);  
        int opt = Tui.getChoice(produtos.length, 0);

        if (opt == 0) {

            return;

        }

        loadedProduto = produtos[opt - 1];

        acessarProduto();  // Acessar o produto



    }

    public void listarProdutos(Produto[] produtos) {


        if (produtos.length == 0) {

            System.out.println();

        }

        Tui.listarProdutos(produtos);  
        int opt = Tui.getChoice(produtos.length, 0);

        if (opt == 0) {

            return;

        }

        loadedProduto = produtos[opt - 1];

        acessarProduto();  // Acessar o produto

    }

    // Listar lojas
    public Boolean listarLojas() {

        Database database = Database.getInstance();
        Loja[] lojas = database.querryLoja();

        if (lojas.length == 0) {

            System.out.println("Nenhuma loja cadastrada.");
            return false;

        }

        Tui.listarLojas(lojas);
        int opt = Tui.getChoice(lojas.length, 0);

        if (opt == 0) {

            return false;

        }

        loadedShop = lojas[opt - 1];
        this.acessarLoja();
        return true;

    }



    // Listar favoritos

    public Boolean listarFavoritos() {

        if (usuarioLogado != null) {

            Tui.clearTerminal();

            System.out.println("Favoritos de: " + usuarioLogado.nome + ":");

            boolean encontrouLojaFavorita = false;
            boolean encontrouProdutoFavorito = false;

            System.out.println("\n--- Lojas Favoritas ---");

            for (Favoritavel favorito : usuarioLogado.favoritos) {

                if (favorito.getType() == FavTypes.LOJA) {
                    System.out.println(favorito.toJSON());
                    encontrouLojaFavorita = true;

                }
            }

            if (!encontrouLojaFavorita) {

                System.out.println();
            }

            System.out.println("\n--- Produtos Favoritos ---");

            for (Favoritavel favorito : usuarioLogado.favoritos) {

                if (favorito.getType() == FavTypes.PRODUTO) {
                    System.out.println(favorito.toJSON());
                    encontrouProdutoFavorito = true;
                }
            }

            if (!encontrouProdutoFavorito) {

                System.out.println();
            }

            Tui.hold();

            return true;

        } else {

            Tui.clearTerminal();
            System.out.println("Você precisa logar para ver seus favoritos.");
            Tui.hold();
            return false;
        }
    }
    // Favoritar loja

    public Boolean favoritarLoja(Long idLoja) {

        Loja loja = Database.getInstance().getLoja(idLoja);  

        if (loja != null) {

            usuarioLogado.adicionarFavorito(loja.id, FavTypes.LOJA);  // Adicione a loja aos favoritos do usuário

            return true;
        }

        return false;
    }


    // Favoritar produto

    public Boolean favoritarProduto(Long idProduto) {

        Produto produto = Database.getInstance().getProduto(idProduto);

        if (produto != null) {

            usuarioLogado.adicionarFavorito(produto.id, FavTypes.PRODUTO);
            return true;
        }

        return false;

    }



    // Mostrar usuário

    public Boolean showUsuario() {
        if (usuarioLogado != null) {
            System.out.println(usuarioLogado.toString());
            return true;
        }
        System.out.println("Você precisa estar logado para ver as informações do usuário.");
        return false;
    }

    // Acessar loja
    public void acessarLoja() {

        Boolean running = true;
        Database database = Database.getInstance();

        while (running){

            Boolean isFavorito = this.usuarioLogado.hasFavorito(this.loadedShop.id, FavTypes.LOJA);

            Tui.menuLoja(this.loadedShop, isFavorito);

            Integer opt = Tui.getChoice(4, 0);

            switch (opt){

                case 0 -> {
                    running = false;
                }

                //listar produtos
                case 1 -> {

                    Produto[] produtos = database.querryProduto(this.loadedShop.id);

                    if (produtos.length == 0){

                        Tui.clearTerminal();
                        System.out.println("Nenhuma loja encontrada");
                        Tui.hold();
                    } else {

                        this.listarProdutos(produtos);

                    }

                }

                //favoritar
                case 2 -> {

                    if (this.usuarioLogado.hasFavorito(this.loadedShop.id, FavTypes.LOJA)){

                        this.usuarioLogado.removerFavorito(this.loadedShop.id, FavTypes.LOJA);

                        Tui.clearTerminal();
                        System.out.println("Favorito removido =)");
                        Tui.hold();
                    } else {

                        this.usuarioLogado.adicionarFavorito(this.loadedShop.id, FavTypes.LOJA);

                        Tui.clearTerminal();
                        System.out.println("Favorito adicionado =)");
                        Tui.hold();

                    }

                }
                //adicionar avaliacao
                case 3 -> {

                }
                //listar avaliacoes

                case 4 -> {

                }




            }



            this.loadedShop = database.getLoja(this.loadedShop.id);

        }
    }

    // Acessar produto
    public void acessarProduto() {

        if (loadedProduto == null) {

            System.out.println("Nenhum produto carregado.");
        }

        Boolean running = true;

        while (running){

            Database database = Database.getInstance();
            this.loadedShop = database.getLoja(this.loadedProduto.idLoja);

            Tui.menuProduto(this.loadedProduto, 
                usuarioLogado.hasFavorito(this.loadedProduto.id, FavTypes.PRODUTO), 
                this.loadedShop, 
                usuarioLogado.id);

            int opt = Tui.getChoice(4, 0);

            switch (opt){

                case 0 -> {
                    running = false;
                }

                case 1 -> {


                    if (this.usuarioLogado.hasFavorito(this.loadedProduto.id, FavTypes.PRODUTO)){

                        this.usuarioLogado.removerFavorito(this.loadedProduto.id, FavTypes.PRODUTO);

                        Tui.clearTerminal();
                        System.out.println("Favorito removido =)");
                        Tui.hold();
                    } else {

                        this.usuarioLogado.adicionarFavorito(loadedProduto.id, FavTypes.PRODUTO);

                        Tui.clearTerminal();
                        System.out.println("Favorito adicionado =)");
                        Tui.hold();

                    }

                }

                //fazer reserva
                case 2 -> {

                    Scanner sc = new Scanner(System.in);
                    Loja loja = database.getLoja(this.loadedProduto.idLoja);

                    Tui.clearTerminal();

                    System.out.println("Quantos " + loadedProduto.getNome() + " você deseja reservar : ");
                    Long quantidade = 0L;
                    quantidade = (long)sc.nextInt();

                    System.out.println("Por quantas horas deseja Reservar: ");
                    Long prazo = 0L;
                    prazo = (long)sc.nextLong();


                    Long novoId = 0L;

                    for (Reserva rev : loja.reservas.reservas){

                        if (rev.id > novoId){

                            novoId = rev.id;
                        }
                    }

                    novoId = novoId + 1;

                    Reserva reserva = new Reserva(this.loadedProduto, this.usuarioLogado, quantidade, prazo, novoId);

                    loja.reservas.addReserva(reserva);

                    database.changeLoja(loja, loja.id);

                    System.out.println("Reserva criada com sucesso");
                    Tui.hold();

                }

                // adicionar acesso a loja 
                case 3 -> {

                    this.loadedShop = database.getLoja(this.loadedProduto.idLoja);

                    this.acessarLoja();

                }

                //cancelar reserva
                case 4 -> {

                    Scanner sc = new Scanner(System.in);

                    Long target = 0L;

                    Boolean found = false;

                    this.loadedShop = database.getLoja(this.loadedProduto.id);

                    Tui.clearTerminal();


                    System.out.println("Insira o id da Reserva:");

                    target = (long)sc.nextInt();

                    for (int i = 0; i < this.loadedShop.reservas.reservas.size(); i++){

                        Reserva reserva = this.loadedShop.reservas.reservas.get(i);

                        if (reserva.id == target){

                            found = true;
                            reserva.concluido = true;

                            database.changeLoja(this.loadedShop, this.loadedShop.id);
                            break;

                        }
                    }

                    if (found){
                        System.out.println("Reserva cancelada");

                    } else {

                        System.out.println("Reserva nao encontrada");
                    }

                    Tui.hold();
                }

            }


            this.loadedProduto = database.getProduto(this.loadedProduto.id);
        }



    }

    private void favoritar(FavTypes type){


        if (type == FavTypes.PRODUTO){

        } else if (type == FavTypes.LOJA){

        }
    }



}
