package com.example.UI;

import com.example.process.ClientManager;
import com.example.process.WorkerManager;

import java.util.*;

public class CLI_Login {
    private Scanner scanner = new Scanner(System.in);
    private CLI_Client cliClient = new CLI_Client();
    private CLI_Worker cliWorker = new CLI_Worker();
    private CLI cli = new CLI();
    private WorkerManager workerManager = new WorkerManager();
    private ClientManager clientManager = new ClientManager();

    public void start(){
        String command;
        do{
            System.out.println("");
            menu();
            System.out.print("Escriba la opción aqui: ");
            command = scanner.nextLine();
            switch (command) {
                case "1":
                    workerLogin();
                    break;
                case "2":
                    clientLogin();
                    break;
                case "3":
                    //cli.start();
                    break;
                case "4":
                    System.out.println("Gracias por visitarnos.");
                    break;
                default:
                    System.out.println("Opción no valida.");
                    break;
            }
        }while(!command.equals("4"));
    }

    private void menu(){
        System.out.println("+---------------------------+");
        System.out.println("|         Bienvenido.       |");
        System.out.println("+---------------------------+");
        System.out.println("");
        System.out.println("+---------------------------+");
        System.out.println("|     Seleccione su rol.    |");
        System.out.println("| 1. Trabajador.            |");
        System.out.println("| 2. Cliente.               |");
        System.out.println("| 3. Administrador.         |");
        System.out.println("| 4. Salir.                 |");
        System.out.println("+---------------------------+");
    }

    private void workerLogin(){
        System.out.println("");
        System.out.println("+---------------------------+");
        System.out.println("|       Iniciar Sesión.     |");
        System.out.println("+---------------------------+");
        System.out.println("");
        System.out.println("+---------------------------+");
        System.out.println("|     Ingrese sus datos.    |");
        System.out.println("+---------------------------+");
        System.out.println("");
        System.out.print("Nombre: ");
        String name = scanner.nextLine();
        System.out.println("");
        System.out.println("Departamento: ");
        System.out.println(" 1. Finanzas.");
        System.out.println(" 2. Inventario.");
        System.out.print("-> ");
        int department = scanner.nextInt();
        scanner.nextLine();
        System.out.println("");
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        if (workerManager.login(name, department, id) == false){
            System.out.println("Parece que no estas registrado, se te registrará de inmediato.");
            workerManager.addWorker(name, department, id);
            System.out.println("");
            System.out.println("Has sido registrado con exito.");
            //cliWorker.start();
        }
        //cliWorker.start();
    }

    private void clientLogin(){
        System.out.println("");
        System.out.println("+---------------------------+");
        System.out.println("|       Iniciar Sesión.     |");
        System.out.println("+---------------------------+");
        System.out.println("");
        System.out.println("+---------------------------+");
        System.out.println("|     Ingrese sus datos.    |");
        System.out.println("+---------------------------+");
        System.out.println("");
        System.out.print("Nombre: ");
        String name = scanner.nextLine();
        System.out.println("");
        System.out.print("Contraseña: ");
        String password = scanner.nextLine();
        if (clientManager.login(name, password) == false){
            System.out.println("Parece que eres nuevo cliente, permitenos registrarte de inmediato.");
            clientManager.addClient(name, password);
            System.out.println("");
            System.out.println("Listo, has sido registrado con exito.");
            //cliClient.start();
        }
        //cliClient.start();
    }
}
