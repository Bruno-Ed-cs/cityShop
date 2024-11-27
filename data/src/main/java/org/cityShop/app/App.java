package org.cityShop.app;

import org.cityShop.usuario.*;
import org.cityShop.loja.Loja;
import org.cityShop.produto.*;
import org.cityShop.database.Database;
import java.util.Scanner;

public class App {

    // Aplicação do singleton
    private static App instance;

    public Usuario usuarioLogado;
    public Loja loadedShop;
    public Produto loadedProduto;

    // Construtor
    private App() {
        this.usuarioLogado = new Usuario("testeJoadodasilva", "772.33.11.2", 20L, true);
    }

    // Método para garantir que apenas uma instância do App seja criada

    public static App getInstance() {

        if (instance == null) {
            instance = new App();
        }
        return instance;
    }

	public void run() {

		
	}

    // Função de login
    public Boolean login(String nomeUsuario, String senha) {

        if (usuarioLogado != null && usuarioLogado.getNome().equals(nomeUsuario)) {

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
        Produto[] produtos = database.querryProdutos();

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

        Loja[] lojas = database.querryLojas();

        if (lojas.length == 0) {

            System.out.println("Nenhuma loja cadastrada ainda :(");

            return false;
        } else {

            for (Loja loja : lojas) {

                System.out.println("Loja: " + loja.getNome());
            }

            return true;
        }
    }

    // Listar favoritos

    public Boolean listarFavoritos() {

        Usuario usuario = App.getInstance().usuarioLogado;

        if (usuario != null) {

            System.out.println("Favoritos de: " + usuario.getNome() + ":");

            boolean encontrouLojaFavorita = false;
            boolean encontrouProdutoFavorito = false;

            System.out.println("\n--- Lojas Favoritas ---");

            for (Favoritavel favorito : usuario.getFavoritos()) {

                if (favorito.getType() == FavTypes.LOJA) {

                    System.out.println(favorito.toJSON());
                    encontrouLojaFavorita = true;
                }
            }

            if (!encontrouLojaFavorita) {

                System.out.println("Nenhuma loja favorita ainda :(");
            }

            System.out.println("\n--- Produtos Favoritos ---");

            for (Favoritavel favorito : usuario.getFavoritos()) {

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

            FavoritoLoja favorito = new FavoritoLoja(idLoja, usuarioLogado.getId());

            usuarioLogado.addFavorito(favorito);

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

            FavoritoProduto favorito = new FavoritoProduto(idProduto, usuarioLogado.getId());

            usuarioLogado.addFavorito(favorito);

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
        return false;
    }

    // Função de criação de usuário 
    public Boolean createUsuario() {

       
        return true;
    }

    // Função de criação de produto 
    public Boolean createProduto() {
        
        return true;
    }

    // Função de criação de loja 
    public Boolean createLoja() {
       
        return true;
    }

    // Função de reservar produto 
    public Boolean reservarProduto() {
        
        return true;
    }

    // Acessar loja
    public Boolean acessLoja() {

        if (loadedShop != null) {
            System.out.println("Acessando a loja: " + loadedShop.getNome());
            return true;
        }
        return false;
    }

    // Acessar produto
    public Boolean acessProduto() {

        if (loadedProduto != null) {
            System.out.println("Acessando o produto: " + loadedProduto.getNome());
            return true;
        }
        return false;
    }
}
