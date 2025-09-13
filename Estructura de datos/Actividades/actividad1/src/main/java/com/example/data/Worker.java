package com.example.data;

public class Worker {
    private String name;
    private int department;
    private int id;


    public Worker(String name, int department, int id){
        setName(name);
        setDepartment(department);
        setID(id);
    }

    public String getName(){
        return name;
    
    }

    public int getDepartment(){
        return department;
    }

    public int getId(){
        return id;
    }

    public void setName(String name){
        if(name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("El nombre no puede estar vacio.");
        }
        this.name = name;
    }

    public void setDepartment(int department){
        if(department > 2 || department < 1){
            throw new IllegalArgumentException("El departamento seleccionado no es valido.");
        }
        this.department = department;
    }

    public void setID(int id){
        if(id <= 0){
            throw new IllegalArgumentException("El ID debe ser un numero positivo.");
        }
        this.id = id;
    }
}
