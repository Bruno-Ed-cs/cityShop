package org.cityShop.app;

import org.cityShop.usuario.*;
import org.cityShop.loja.*;
import org.cityShop.produto.*;

import java.util.Scanner;

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

        this.usuarioLogado = new Usuario("testeJoadodasilva", "772.33.11.2", 20L, true, "12345");
    }

    // Método para garantir que apenas uma instância do App seja criada

    public static App getInstance() {

        if (instance == null) {

            instance = new App();
        }
        return instance;
    }

    //cadastrar o lojista

    public void cadastroLojista() {

        Database database = Database.getInstance();
        Scanner sc = new Scanner(System.in);

        Tui.clearTerminal();

        System.out.println("digite o nome do usuario: ");
        String nome = sc.nextLine();

        System.out.println("Digite a sua senha: ");
        String senha = sc.nextLine();

        System.out.println("digite o seu cpf: ");
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

    //gerenciar as lojas

    public void gerenciarLoja() {

        if (usuarioLogado == null || !usuarioLogado.lojista) {

            System.out.println("Nao eh lojista, nao pode gerenciar lojas.");
            Tui.hold();
            return;
        }

        Database database = Database.getInstance();

        Loja [] lojas = Database.getInstance().querryLoja();

        if (lojas == null || lojas.length == 0) {

            System.out.println("Nenhuma loja cadastrada.");
        } else {

            for(Loja loja: lojas) {

                System.out.println(loja.id + " - " + loja.nome);
            }
        }

        System.out.println("1- adicionr loja");
        System.out.println("2- remover loja");
        System.out.println("3- gerenciar loja");
        System.out.println("0<<< voltar");

        int escolha = Tui.getChoice(3, 0);

        switch (escolha) {
            case 1 -> this.createLoja();
            case 2 ->{

                Scanner sc = new Scanner(System.in);
                System.out.println("Insira o id da loja que deseja remover");
                Long target = (long)sc.nextInt();

                this.removeLoja(target);

            }
            case 3 -> this.gerenciarLoja();
        }


    }

    //criar a loja

    public Boolean createLoja() {

        if (!this.isLojista()) {

            System.out.println("Nao eh lojista, nao pode criar loja.");
            return false;
        }

        Scanner sc = new Scanner(System.in);

        System.out.println("digite o nome da loja: ");
        String nome = sc.nextLine();

        System.out.println("digite o endereço da loja: ");
        String endereco = sc.nextLine();


        System.out.println("digite a latirude da loja: ");
        String latitude = sc.nextLine();


        System.out.println("digite a longitude da loja: ");
        String longitude = sc.nextLine();


        Local localizacao = new Local(endereco, longitude, latitude);

        Loja novLoja = new Loja(nome, this.usuarioLogado.id, localizacao);

        Database database = Database.getInstance();
        database.addLoja(novLoja);

        System.out.println("Loja criada com sucesso!");

        return true;
    }


    //remover loja
    public boolean removeLoja(Long idLoja) {

        Database database = Database.getInstance();
        Loja loja = database.getLoja(idLoja);

        if (loja == null || !loja.id.equals(this.loadedShop.id)) {

            System.out.println("Nenhuma loja carregada.");
            return false;
        }

        database.removeLoja(idLoja);

        System.out.println("Loja removida com sucesso!");
        return true;                                                

    }

    //adicionar um produto a loja

    public Boolean adicionarProdutoLoja() {

        Database database = Database.getInstance();

        Loja[] lojas = database.querryLoja();

        if (lojas == null || !lojas.lojista.equals(this.usuarioLogado)) {

            System.out.println("Loja nao encontrada ou voce nao tem permissao para adicionar um produto nesta loja.");
            return false;
        }

        loja.addProduto(this.loadedProduto);
        database.changeLoja(loja, idLoja);
        System.out.println("Produto adicionado com sucesso! \\(^-^)/");
        return true;
    }

    public Boolean removeverProdutoLoja() {

        Database database = Database.getInstance();

        Loja lojas = database.querryLoja(this.loadedShop.id);

        if (loja == null || !lojas.lojista.equals(this.usuarioLogado)) {

            System.out.println("Loja nao encontrada ou voce nao tem permissao para remover um produto nesta loja.");
            return false;
        }

        loja.removeProduto(this.loadedProduto);
        database.changeLoja(loja, idLoja);
        System.out.println("Produto removido com sucesso! \\(^-^)/");
        return true;
    }

    //remover um produto da loja

    public Boolean removerProdutoLoja() {

        Database database = Database.getInstance();

        Loja lojas = database.querryLoja(this.loadedShop.id);

        if (loja == null || !lojas.lojista.equals(this.usuarioLogado)) {

            System.out.println("Loja nao encontrada ou voce nao tem permissao para remover um produto nesta loja.");
            return false;
        }

        if(lojoa.removeProduto(this.loadedProduto)) {

            loja.removeProduto(this.loadedProduto);
            database.changeLoja(loja, idLoja);
            System.out.println("Produto removido com sucesso! \\(^-^)/");
            return true;

        }

        System.out.println("Produto nao encontrado.");
        return false;

    }

    public Boolean lojistaLoja()  {

        if(!isLojista()) {

            System.out.println("Voce nao eh lojista. >:( saia daqui.");
            return false;
        }

        Database database = Database.getInstance();
        Loja[] lojas = database.querryLoja();

        System.out.println("Loja do lojista: ");
        boolean encotrouLoja = false;
        for (Loja loja : lojas) {

            if (loja.dono.equals(this.usuarioLogado.id)) {

                System.out.println(loja.id + " - " + loja.nome);
                encotrouLoja = true;
            }
        }

        if (!encotrouLoja) {

            System.out.println("Nenhuma loja cadastrada.");
            return false;
        }

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

            System.out.println("Nenhum produto cadastrado ainda :(");

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
    public Boolean listarLoja() {

        Database database = Database.getInstance();
        Loja[] lojas = database.querryLoja();

        if (lojas.length == 0) {

            System.out.println("Nenhuma loja cadastrada.");
            return false;

        }

        Tui.listarLoja(lojas);
        int opt = Tui.getChoice(lojas.length, 0);

        if (opt == 0) {

            return false;

        }

        loadedShop = lojas[opt - 1];
        acessarLoja();
        return true;

    }



    // Listar favoritos

    public Boolean listarFavoritos() {

        if (usuarioLogado != null) {

            Tui.clearTerminal();

            System.out.println("Favoritos de: " + usuarioLogado.nome + ":");

            boolean encontrouLojaFavorita = false;
            boolean encontrouProdutoFavorito = false;

            System.out.println("\n--- Loja Favoritas ---");

            for (Favoritavel favorito : usuarioLogado.favoritos) {

                if (favorito.getType() == FavTypes.LOJA) {
                    System.out.println(favorito.toJSON());
                    encontrouLojaFavorita = true;

                }
            }

            if (!encontrouLojaFavorita) {

                System.out.println("Nenhuma loja favorita ainda :(");
            }

            System.out.println("\n--- Produtos Favoritos ---");

            for (Favoritavel favorito : usuarioLogado.favoritos) {

                if (favorito.getType() == FavTypes.PRODUTO) {
                    System.out.println(favorito.toJSON());
                    encontrouProdutoFavorito = true;
                }
            }

            if (!encontrouProdutoFavorito) {

                System.out.println("Nenhum produto favorito ainda :(");
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

    // Função de criação de usuário 

    public Boolean createUsuario() {
        // Implementação para criar um novo usuário
        return true;
    }

    // Função de criação de produto 

    public Boolean createProduto() {
        // Implementação para criar um novo produto
        return true;
    }



    // Função de reservar produto 

    public Boolean reservarProduto() {

        // Implementação para reservar um produto

        return true;


    }

    public Boolean alterarEstoqueProduto(Long idProduto, int novoEstoque) {


        Database databse = Databse.getInstance();
        Produto produto = database.getProduto(idProduto);

        if (produto == null || !usuarioLogado.isLojista()) {
            System.out.println("Produto nao encontrado ou voc nao tem permissao para alterar o estoque deste produto.");
            return false;
        }

        produto.setEstoque(novoEstoque);
        database.changeProduto(produto, idProduto);
        System.out.println("Estoque alterado com sucesso! <(>_<)>");
        return true;

    }

    public Boolean visualizarReversas(Long idLoja) {
        Database database = Database.getInstance();
        Loja loja = database.getLoja(idLoja);

        if (loja == null || !loja.lojista.equals(this.usuarioLogado)) {
            System.out.println("Loja nao encontrada ou voce nao tem permissao para visualizar as reservas desta loja.");
            return false;
        }

        Tui.menuReversas(loja);
        return true;
    }

    // Acessar loja

    public Boolean acessarLoja() {

        if (loadedShop != null) {
            System.out.println("Acessando a loja: " + loadedShop.nome);
            return true;
        }

        System.out.println("Nenhuma loja carregada.");

        return false;

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
                usuarioLogado.hasFavorito(this.loadedProduto.id), 
                this.loadedShop, 
                usuarioLogado.id);

            int opt = Tui.getChoice(2, 0);

            if (opt == 0){

                break;
            }

            switch (opt){

                case 1 -> {
                    if (this.usuarioLogado.hasFavorito(loadedProduto.id)){

                        this.usuarioLogado.removerFavorito(this.loadedProduto.id);

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

            }

        }



    }







}

