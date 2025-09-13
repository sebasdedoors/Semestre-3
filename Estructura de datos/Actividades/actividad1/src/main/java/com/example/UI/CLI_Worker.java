package com.example.UI;

import java.util.*;

import com.example.data.Task;
import com.example.process.WorkerManager;

public class CLI_Worker {
    private WorkerManager workerManager = new WorkerManager();
    private Scanner scanner = new Scanner(System.in);

    public void start(){
        String command;
        do {
            System.out.println("");
            menu();
            System.out.println("");
            System.out.print("Ingrese su opción: ");
            command = scanner.nextLine();
            switch (command) {
                case "1":
                    addTask();
                    break;
                case "2":
                    removeTask();
                    break;
                case "3":
                    showTask();
                    break;
                case "4":
                    System.out.println("Gracias por su labor del día.");
                    break;
                default:
                    System.out.println("Opción no válida, intente de nuevo.");
                    break;
            }

        } while (!command.equals("4"));
    }

    public void menu(){
        System.out.println("+---------------------------------+");
        System.out.println("|          Bienvenido             |");
        System.out.println("+---------------------------------+");
        System.out.println("");
        System.out.println("+-----------------------------------+");
        System.out.println("|      Seleccione una opción.       |");
        System.out.println("| 1. Añadir tarea.                  |");
        System.out.println("| 2. Remover tarea.                 |");
        System.out.println("| 3. Mostrar tareas segun prioridad.|");
        System.out.println("| 4. Cerrar sesión.                 |");
        System.out.println("+-----------------------------------+");
    }

    private void addTask(){
        System.out.println("");
        System.out.println("+-------------------------------+");
        System.out.println("|         Añadir tarea.         |");
        System.out.println("+-------------------------------+");
        System.out.println("");
        System.out.println("+-------------------------------+");
        System.out.println("|        Ingrese la tarea.      |");
        System.out.println("+-------------------------------+");
        System.out.println("");
        String description = scanner.nextLine();
        System.out.println("");
        System.out.println("+-------------------------------+");
        System.out.println("|    Ingrese su departamento.   |");
        System.out.println("| 1. Finanzas.                  |");
        System.out.println("| 2. Inventario.                |");
        System.out.println("+-------------------------------+");
        System.out.println("");
        int department = scanner.nextInt();
        scanner.nextLine();
        System.out.println("");
        System.out.println("+-------------------------------+");
        System.out.println("|   Ingrese el ID de la tarea.  |");
        System.out.println("+-------------------------------+");
        System.out.println("");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("");
        System.out.println("+---------------------------------+");
        System.out.println("|  Ingrese el nivel de prioridad. |");
        System.out.println("| 1. Alta.                        |");
        System.out.println("| 2. Media.                       |");
        System.out.println("| 3. Baja.                        |");
        System.out.println("+---------------------------------+");
        System.out.println("");
        int priority = scanner.nextInt();
        scanner.nextLine();
        workerManager.addTask(description, department, id, priority);
    }

    private void removeTask(){
        System.out.println("");
        System.out.println("+-------------------------------+");
        System.out.println("|         Remover tarea.        |");
        System.out.println("+-------------------------------+");
        System.out.println("");
        System.out.println("+-------------------------------+");
        System.out.println("|    Ingrese su departamento.   |");
        System.out.println("| 1. Finanzas.                  |");
        System.out.println("| 2. Inventario.                |");
        System.out.println("+-------------------------------+");
        System.out.println("");
        int department = scanner.nextInt();
        scanner.nextLine();
        System.out.println("");
        System.out.println("+-------------------------------+");
        System.out.println("|   Ingrese el ID de la tarea.  |");
        System.out.println("+-------------------------------+");
        System.out.println("");
        int id = scanner.nextInt();
        scanner.nextLine();
        workerManager.removeTask(department, id);
    }

    private void showTask(){
        System.out.println("");
        System.out.println("+-------------------------------+");
        System.out.println("|       Mostrar tareas.         |");
        System.out.println("+-------------------------------+");
        System.out.println("");
        System.out.println("+-------------------------------+");
        System.out.println("|    Ingrese su departamento.   |");
        System.out.println("| 1. Finanzas.                  |");
        System.out.println("| 2. Inventario.                |");
        System.out.println("+-------------------------------+");
        System.out.println("");
        int department = scanner.nextInt();
        scanner.nextLine();
        System.out.println("");
        System.out.println("+---------------------------------+");
        System.out.println("|  Ingrese el nivel de prioridad. |");
        System.out.println("| 1. Alta.                        |");
        System.out.println("| 2. Media.                       |");
        System.out.println("| 3. Baja.                        |");
        System.out.println("+---------------------------------+");
        System.out.println("");
        int priority = scanner.nextInt();
        scanner.nextLine();
        for (Task task : workerManager.viewTasks(department, priority)){
            System.out.println("+-----------------------------+");
            System.out.println("| ID: " + task.getId() + "      |");
            System.out.println("| Descripción: " + task.getDescription() + " |");
            System.out.println("| Prioridad: " + task.getPriority() + "        |");
            System.out.println("+-----------------------------+");
        }           
    }
}
