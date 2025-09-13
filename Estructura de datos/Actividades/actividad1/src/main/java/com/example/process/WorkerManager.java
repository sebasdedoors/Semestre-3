package com.example.process;

import java.util.*;
import com.example.data.Task;
import com.example.data.Worker;

public class WorkerManager{
    HashMap<Integer, Task> tasksFinance = new HashMap<>();
    HashMap<Integer, Task> tasksInventory = new HashMap<>();
    HashMap<Integer, Worker> workers = new HashMap<>();

    public WorkerManager(){
        workers.put(0104, new Worker("Victor", 1, 0104));
        workers.put(2804, new Worker("Sebastian", 1, 2804));
        workers.put(1411, new Worker("Michel", 2, 1411));
        workers.put(2311, new Worker("Daniela", 2, 2311));
    }

    public void addTask(String description, int department, int id, int priority){
        if (department == 1) {
            tasksFinance.put(id, new Task(id, description, priority));
        }else if (department == 2) {
            tasksInventory.put(id, new Task(id, description, priority));
        }
    }

    public boolean login(String name, int department, int id){
        for (Worker worker : workers.values()){
            if (worker.getName().equals(name) && worker.getDepartment() == department && worker.getId() == id){
                return true;
            }
        }
        return false;
    }

    public void addWorker(String name, int department, int id){
        if(!workers.containsKey(id)){
            workers.put(id, new Worker(name, department, id));
        }else {
            System.out.println("El trabajador con ID: " + id + " ya existe.");
        }
    }

    public void removeWorker(int id){
        if(workers.containsKey(id)){
            workers.remove(id);
            System.out.println("Trabajador: " + workers.get(id).getId() + " - " + workers.get(id).getName() + " - " + workers.get(id).getDepartment() + " eliminado.");
        }
    }

    public void removeTask(int department, int id){
        if (department == 1) {
            if (tasksFinance.containsKey(id)) {
                tasksFinance.remove(id);
            }else {
                System.out.println("Tarea no encontrada.");
            }
        }else if (department == 2) {
            if (tasksInventory.containsKey(id)) {
                tasksInventory.remove(id);
            }else {
                System.out.println("Tarea no encontrada.");
            }
        }else {
            System.out.println("Departamento no encontrado.");
        }
    }

    public List<Task> viewTasks(int department, int priority){
        List<Task> tasks = new ArrayList<>();
        if (department == 1) {
            for (Task task : tasksFinance.values()) {
                if (task.getPriority() == priority) {
                    tasks.add(task);
                }
            }
        }else if (department == 2) {
            for (Task task : tasksInventory.values()) {
                if (task.getPriority() == priority) {
                    tasks.add(task);
                }
            }
        }else {
            System.out.println("Departamento no encontrado.");
        }
        return tasks;
    }
}
