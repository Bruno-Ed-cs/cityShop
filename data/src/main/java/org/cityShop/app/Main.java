package org.cityShop.app;

import java.io.Console;
import java.io.InputStream;
import java.lang.reflect.Executable;

import com.sun.source.doctree.SystemPropertyTree;


public class Main {

    public static void main(String[] args) {

        // Obter as instâncias únicas de App e Database
        App app = App.getInstance();
        Database database = Database.getInstance();

        // Chamada de teste no banco de dados
        database.teste();

        // Instanciar a interface com o usuário (Tui)
        Tui tui = new Tui();

        boolean running = true;

        while (running) {
            Tui.clearTerminal(); // Limpa o terminal antes de exibir o menu

            tui.mainMenu(app); // Exibe o menu principal

            int choice = tui.getChoice(); // Obtém a escolha do usuário

            switch (choice) {
                case 1 -> tui.login(app); // Realiza login
                case 2 -> tui.listarLojas(app); // Lista lojas
                case 3 -> tui.listarProdutos(app); // Lista produtos
                case 4 -> tui.listarFavoritos(app); // Lista favoritos
                case 5 -> tui.favoritarLoja(app); // Favorita uma loja
                case 6 -> tui.favoritarProduto(app); // Favorita um produto
                case 7 -> running = false; // Encerra o loop
                default -> {} // Não precisa mais de código para tratar opção inválida aqui
            }
        }
    }
}
