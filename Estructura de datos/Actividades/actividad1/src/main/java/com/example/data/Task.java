package com.example.data;

public class Task {
    private int id;
    private String description;
    private int priority;

    public Task(int id, String description, int priority){
        setId(id);
        setDescription(description);
        setPriority(priority);
    }

    public int getId(){
        return id;
    }

    public String getDescription(){
        return description;
    }

    public int getPriority(){
        return priority;
    }

    public void setId(int id){
        if(id <= 0){
            throw new IllegalArgumentException("ID invalido.");
        }
        this.id = id;
    }

    public void setDescription(String description){
        if(description == null || description.trim().isEmpty()){
            throw new IllegalArgumentException("La descripcion no puede estar vacia.");
        }
        this.description = description;
    }

    public void setPriority(int priority){
        if(priority < 1 || priority > 3){
            throw new IllegalArgumentException("Nivel de prioridad invalido.");
        }
        this.priority = priority;
    }
}
