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

        Boolean running = true;

        while (running){

            Tui.clearTerminal();

            Tui.mainMenu();

            int choice = Tui.getChoice();

            switch (choice) {

                case 1 -> Tui.login(app);
                case 2 -> Tui.listarLojas(app);
                case 3 -> Tui.listarProdutos(app);
                case 4 -> Tui.listarFavoritos(app);
                case 5 -> Tui.favoritarLoja(app);
                case 6 -> Tui.favoritarProduto(app);
                case 7 ->  running = false;
                

            } 

        }


    }
}


