package com.example.UI;

import com.example.data.Peliculas;
import com.example.process.ClientManager;

import java.util.*;

public class CLI_Client {
    private ClientManager clientManager;
    private Scanner scanner = new Scanner(System.in);
    private CLI cli = new CLI();

    public void menu(){
        System.out.println("+---------------------------------+");
        System.out.println("|          Bienvenido             |");
        System.out.println("+---------------------------------+");
        System.out.println("");
        System.out.println("+-----------------------------------+");
        System.out.println("|      Seleccione una opción.       |");
        System.out.println("| 1. Mostrar peliculas disponibles. |");
        System.out.println("| 2. Agregar pelicula al carrito.   |");
        System.out.println("| 3. Eliminar pelicula del carrito. |");
        System.out.println("| 4. Mostrar carrito.               |");
        System.out.println("| 5. Cerrar sesión.                 |");
        System.out.println("+-----------------------------------+");
    }

    public void start(){
        clientManager = new ClientManager();
        String option;
        do {
            menu();
            System.out.println("");
            System.out.print("Escriba el número aqui: ");
            option = scanner.nextLine();
            switch (option) {
                case "1":
                    cli.menu2();
                    break;
                case "2":
                    addToCart();
                    break;
                case "3":
                    removeFromCart();
                    break;
                case "4":
                    showCart();
                    break;
                case "5":
                    System.out.println("Gracias por visitarnos....");
                    break;
                default:
                    System.out.println("Opción no válida, vuelva a intentarlo.");
                    break;
            }
        } while (!option.equals("5"));
    }

    private void addToCart(){
        System.out.println("");
        System.out.println("+-------------------------------+");
        System.out.println("|      Agregar al carrito       |");
        System.out.println("+-------------------------------+");
        System.out.println("");
        System.out.println("+-------------------------------+");
        System.out.println("|      Ingrese el titulo.       |");
        System.out.println("+-------------------------------+");
        System.out.println("");
        System.out.print("Escribe aqui: ");
        String titulo = scanner.nextLine();
        clientManager.addToCart(titulo);
    }

    private void removeFromCart(){
        System.out.println("");
        System.out.println("+-------------------------------+");
        System.out.println("|      Eliminar del carrito     |");
        System.out.println("+-------------------------------+");
        System.out.println("");
        System.out.println("+-------------------------------+");
        System.out.println("|      Ingrese el titulo.       |");
        System.out.println("+-------------------------------+");
        System.out.println("");
        System.out.print("Escribe aqui: ");
        String titulo = scanner.nextLine();
        clientManager.removeFromCart(titulo);
    }

    private void showCart(){
        for (Peliculas pelicula : clientManager.viewCart()){
            System.out.println("");
            System.out.println("+-------------------------------+");
            System.out.println("| Titulo: " + pelicula.getTitulo() + " |");
            System.out.println("| Genero: " + pelicula.getGenero() + " |");
            System.out.println("| Año: " + pelicula.getAño() + " |");
            System.out.println("+-------------------------------+");
        }
    }
}
