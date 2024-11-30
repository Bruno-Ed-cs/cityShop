package org.cityShop.app;

import java.io.Console;
import java.io.InputStream;
import java.lang.reflect.Executable;

import javax.sound.sampled.BooleanControl;
import javax.swing.text.AbstractDocument.BranchElement;

import com.sun.source.doctree.SystemPropertyTree;


public class Main {

    public static App app = App.getInstance();
    public static Database database = Database.getInstance();


    public static void main(String[] args) {

        // Obter as instâncias únicas de App e Database
        App app = App.getInstance();
        Database database = Database.getInstance();

        // Chamada de teste no banco de dados
        //database.teste();
        //
        Boolean running = true;

        while (running){

            Tui.clearTerminal();


            Tui.mainMenu();

            int choice;

            if (app.isLogged()){

                System.out.println();
                System.out.println("Usuario Logado = " + app.usuarioLogado.nome);
                System.out.println();
                choice = Tui.getChoice(6, 0);

            } else {

                choice = Tui.getChoice(1, 0);

            }

            switch (choice) {

                case 1 -> Tui.login(app);
                case 2 -> app.listarLojas();
                case 3 -> app.listarProdutos();
                case 4 -> Tui.listarFavoritos(app);
                case 5 -> Tui.favoritarLoja(app);
                case 6 -> Tui.favoritarProduto(app);

                case 0 -> {
                    System.out.println("Saindo...");
                    running = false;
                } 

            }


        }
    }
}


