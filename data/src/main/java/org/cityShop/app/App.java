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
    public Boolean listarProdutos() {
        Database database = Database.getInstance();
        Produto[] produtos = database.querryProduto();

        if (produtos.length == 0) {
            System.out.println("Nenhum produto cadastrado ainda :(");
            return false;
        } else {
            for (Produto produto : produtos) {
                System.out.println("Produto: " + produto.getNome());
            }
            return true;
        }
    }

    // Listar lojas
    public Boolean listarLojas() {
        Database database = Database.getInstance();
        Loja[] lojas = database.querryLoja();

        if (lojas.length == 0) {
            System.out.println("Nenhuma loja cadastrada ainda :(");
            return false;
        } else {
            for (Loja loja : lojas) {
                System.out.println("Loja: " + loja.nome);
            }
            return true;
        }
    }

    // Listar favoritos
    public Boolean listarFavoritos() {
        if (usuarioLogado != null) {
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

            return true;
        } else {
            System.out.println("Você precisa logar para ver seus favoritos.");
            return false;
        }
    }

    // Favoritar loja
    public Boolean favoritarLoja(Long idLoja) {
        if (usuarioLogado != null) {
            usuarioLogado.adicionarFavorito(idLoja, FavTypes.LOJA);
            System.out.println("Loja favoritada com sucesso!");
            return true;
        } else {
            System.out.println("Você precisa logar para favoritar uma loja.");
            return false;
        }
    }

    // Favoritar produto
    public Boolean favoritarProduto(Long idProduto) {
        if (usuarioLogado != null) {
            usuarioLogado.adicionarFavorito(idProduto, FavTypes.PRODUTO);
            System.out.println("Produto favoritado com sucesso!");
            return true;
        } else {
            System.out.println("Você precisa logar para favoritar um produto.");
            return false;
        }
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
    public Boolean acessarProduto() {
        if (loadedProduto != null) {
            System.out.println("Acessando o produto: " + loadedProduto.getNome());
            return true;
        }
        System.out.println("Nenhum produto carregado.");
        return false;
    }
}
