package org.cityShop.app;

import org.cityShop.usuario.*;
import org.cityShop.loja.Loja;
import org.cityShop.produto.*;
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

        this.usuarioLogado = new Usuario("testeJoadodasilva", "772.33.11.2", 20L, true);
    }

    // Método para garantir que apenas uma instância do App seja criada

    public static App getInstance() {
        if (instance == null) {

            instance = new App();
        }
        return instance;
    }

    // Função de login
	
    public Boolean login(String nomeUsuario, String senha) {
        
        if (usuarioLogado != null && usuarioLogado.nome.equals(nomeUsuario)) {
            System.out.println("Logado com sucesso!");
            return true;
        }
        System.out.println("Falha ao logar!");
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

            return false;
        }
    
        Tui.listarProdutos(produtos);  
        int opt = Tui.getChoice(produtos.length, 0);
    
        if (opt == 0) {

            return false;

        }
    
        loadedProduto = produtos[opt - 1];

        acessarProduto();  // Acessar o produto

        return true;
            
        
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

        System.out.println("\n--- Lojas Favoritas ---");

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

    }

    // Favoritar loja

    public Boolean favoritarLoja(Long idLoja) {

      Loja loja = getLojaById(idLoja);  

        if (loja != null) {

        usuarioLogado.addFavorito(loja);  // Adicione a loja aos favoritos do usuário
        
        return true;
    }

    return false;
}
    

    // Favoritar produto

    public Boolean favoritarProduto(Long idProduto) {

        Produto produto = getProdutoById(idProduto);

        if (produto != null) {
            usuarioLogado.addFavorito(produto);
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

    // Função de criação de loja 
    public Boolean createLoja() {
        // Implementação para criar uma nova loja
        return true;
    }

    // Função de reservar produto 
    public Boolean reservarProduto() {
        // Implementação para reservar um produto
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

            Tui.menuProduto(this.loadedProduto);

            int opt = Tui.getChoice(2, 0);

            if (opt == 0){

                break;
            }

            switch (opt){

                case 1 -> this.favoritarProduto(loadedProduto.id) ;

            }

        }


    }
}
