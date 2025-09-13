package actividad2.ui;

import actividad2.data.Patient;
import actividad2.process.Manager;

import java.util.*;

public class CLI {
    Manager manager = new Manager();
    Scanner scanner = new Scanner(System.in);

    public void start(){
        int option = 0;
        while (option != 4){
            menu();
            option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    addPatient();
                    break;
                case 2:
                    showPatients();
                    break;
                case 3:
                    removePatient();
                    break;
                case 4:
                    System.out.println("Hasta pronto ;)");
                    break;
                default:
                    System.out.println("Opcion no valido.");
                    break;
            }
        }
    }

    public static void menu(){
        System.out.println("+--------------------------------+");
        System.out.println("| Bienvenido a Hospital Angelito |");
        System.out.println("+--------------------------------+");
        System.out.println("");
        System.out.println("Seleccione una opcion: ");
        System.out.println("");
        System.out.println("1. Agregar paciente.");
        System.out.println("2. Mostrar paciente.");
        System.out.println("3. Eliminar paciente.");
        System.out.println("4. Salir.");
        System.out.println("");
    }

    public void addPatient(){
        System.out.println("");
        System.out.println("Comencemos a agregar un nuevo paciente: ");
        System.out.println("");
        System.out.println("Escriba el nombre del paaciente: ");
        String name = scanner.nextLine();
        System.out.println("Escriba el ID designado al paciente: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Escriba la enfermedad o estado del paciente: ");
        String sick = scanner.nextLine();
        System.out.println("");
        System.out.println("Escriba el nivel de prioridad del paciente: ");
        System.out.println("1. Urgente.");
        System.out.println("2. Media.");
        System.out.println("3. Baja.");
        int priority = scanner.nextInt();
        scanner.nextLine();
        manager.addPatient(name, id, sick, priority);
    }

    public void showPatients(){
        System.out.println("");
        System.out.println("Seleccione la opción deseada: ");
        System.out.println("1. Mostrar todos los pacientes.");
        System.out.println("2. Mostrar pacientes por nivel de prioridad.");
        int option = scanner.nextInt();
        scanner.nextLine();
        switch (option){
            case 1:
                if(manager.showPatients().isEmpty()){
                    System.out.println("No hay pacientes para mostrar.");
                    break;
                }else{
                    manager.showPatients();
                    System.out.println("Pacientes registrados: ");
                    for(Patient patient : manager.showPatients()){
                        System.out.println("*Nombre: " + patient.getName());
                        System.out.println("ID: " + patient.getId());
                        System.out.println("Estado: " + patient.getSick());
                        System.out.println("Nivel de prioridad: " + patient.getPriority());
                        System.out.println("");
                    }
                    break;
                }
            case 2:
                System.out.println("Seleccione el nivel de prioridad: ");
                System.out.println("1. Urgente.");
                System.out.println("2. Media.");
                System.out.println("3. Baja.");
                int priority = scanner.nextInt();
                scanner.nextLine();
                if(manager.showPatientsLevel(priority).isEmpty()){
                    System.out.println("No hay pacientes con este nivel de prioridad.");
                }else{
                    System.out.println("Pacientes con nivel de prioridad " + priority + ":");
                    for(int i = manager.showPatientsLevel(priority).size() - 1; i >= 0; i--){
                        Patient patient = manager.showPatientsLevel(priority).get(i);
                        System.out.println("*Nombre: " + patient.getName());
                        System.out.println("ID: " + patient.getId());
                        System.out.println("Estado: " + patient.getSick());
                        System.out.println("Nivel de prioridad: " + patient.getPriority());
                        System.out.println("");
                    }
                }
        }
    }

    public void removePatient(){
        System.out.println("");
        System.out.println("Comencemos a eliminar al paciente:");
        System.out.println("Escriba el ID del paciente: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        manager.removePatient(id);
    }
}
