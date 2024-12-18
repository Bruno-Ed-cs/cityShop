package org.cityShop.app;

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

                if (app.isLojista()){

                    choice = Tui.getChoice(7, 0);

                } else {


                    choice = Tui.getChoice(6, 0);
                }

            } else {

                choice = Tui.getChoice(2, 0);

            }

            switch (choice) {

                case 1 -> Tui.login(app);
                case 2 -> app.cadastro();
                case 3 -> app.logout();
                case 4 -> app.listarLoja();
                case 5 -> app.listarProdutos();
                case 6 -> Tui.listarFavoritos(app);
                case 7 -> app.gerenciarLoja();

                case 0 -> {
                    System.out.println("Saindo...");
                    running = false;
                } 

                default -> {

                    System.out.println("Funcao ainda nao implementada");
                    Tui.hold();
                }

            }


        }
    }
}


