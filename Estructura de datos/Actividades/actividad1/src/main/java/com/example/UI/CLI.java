package com.example.UI;

import com.example.process.Manager;
import java.util.*;
import com.example.data.Peliculas;

public class CLI {
    private Manager manager;
    private Scanner scanner;

    public CLI() {
        manager = new Manager();
        scanner = new Scanner(System.in);
    }

    public void start() {
        String command;
        do {
            System.out.println("");
            menu();
            System.out.println("Seleccione la opcion deseada: ");
            command = scanner.nextLine();
            switch (command) {
                case "1":
                    addPelicula();
                    break;
                case "2":
                    menu2();
                    break;
                case "3":
                    deletePelicula();
                /*aca poner 2 mas para poner el  pila y cola */
                    break;
                case "4":
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Comando no reconocido.");
            }
        } while (!command.equals("4"));
    }

    public void menu(){
        System.out.println("");
        System.out.println("1. Agregar pelicula.");
        System.out.println("2. Mostrar peliculas por genero.");
        System.out.println("3. Eliminar pelicula.");
        System.out.println("4. Salir.");
    }

    private void addPelicula() {
        System.out.println("");
        System.out.println("Ingrese el titulo de la pelicula: ");
        String titulo = scanner.nextLine();
        System.out.println("Ingrese el genero de la pelicula: ");
        String genero = scanner.nextLine();
        System.out.println("Ingrese el año de la pelicula: ");
        int año = scanner.nextInt();
        scanner.nextLine();
        System.out.println("La pelicula se agregó con exito.");
        System.out.println("");
        manager.addPeliculas(titulo, genero, año); 
    } 

    public void showPeliculas() {
        System.out.println("");
        System.out.println("Generos: ");
        System.out.println("1. Accion.");
        System.out.println("2. Terror.");
        System.out.println("3. Comedia.");
        System.out.println("-----> Ingrese el genero de las peliculas a mostrar: ");
        String genero = scanner.nextLine();
        if (manager.showPeliculas(genero).isEmpty()){
            System.out.println("-----X----- No hay peliculas disponibles para este genero. -----X-----");
        }else{
            manager.showPeliculas(genero);
        System.out.println("Peliculas encontradas del genero " + genero + ":");
            for (Peliculas pelicula : manager.showPeliculas(genero)){
                System.out.println("");
                System.out.println("* Titulo: " + pelicula.getTitulo());
                System.out.println("  Genero: " + pelicula.getGenero());
                System.out.println("  Año: " + pelicula.getAño());
                System.out.println("");
            }
        }
    }
    

    private void deletePelicula() {
        System.out.println("");
        System.out.println("Ingrese el título de la película a eliminar: ");
        String titulo = scanner.nextLine();
        System.out.println("La pelicula ha sido eliminada.");
        manager.deletePelicula(titulo);
    }

    public void menu2(){
        System.out.println("");
        System.out.println("Selecciona las peliculas a buscar: ");
        System.out.println("1. Estrenos.");
        System.out.println("2. Clasicos.");
        int opcion = scanner.nextInt();
        scanner.nextLine();
        if (opcion == 1){
            showPeliculas();
        }else if (opcion == 2){
            showPeliculasLifo();
        }else {
            System.out.println("Opción no válida.");
        }
        
    }

    public void showPeliculasLifo(){
        System.out.println("");
        System.out.println("Generos: ");
        System.out.println("1. Accion.");
        System.out.println("2. Terror.");
        System.out.println("3. Comedia.");
        System.out.println("Ingrese el genero de las peliculas a mostrar: ");
        String genero2 = scanner.nextLine();
        if (manager.showPeliculas(genero2).isEmpty()){
            System.out.println("-----X----- No hay peliculas disponibles para este genero. -----X-----");
        }else{
            System.out.println("-----> Clasicos disponibles: ");
            for (int i = manager.showPeliculas(genero2).size() - 1; i >= 0; i--){
                Peliculas pelicula = manager.showPeliculas(genero2).get(i);
                System.out.println("");
                System.out.println("* Titulo: " + pelicula.getTitulo());
                System.out.println("  Genero: " + pelicula.getGenero());
                System.out.println("  Año: " + pelicula.getAño());
            }
        }
    }
}
