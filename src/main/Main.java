package main;

/*
* made by: victorpointud
*/

public class Main {

    public static void main(String[] args) {
        try {
            Global.mainMenu.setVisible(true);
        } catch (Exception e) {
            System.err.println("Error al iniciar la aplicación: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
