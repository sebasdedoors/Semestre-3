package com.example.data;

public class Client {
    private String name;
    private String password;

    public Client(String name, String password){
        setName(name);
        setPassword(password);
    }

    public String getName(){
        return name;
    }

    public String getPassword(){
        return password;
    }

    public void setName(String name){
        if (name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("El nombre no puede estar vacio.");
        }
        this.name = name;   
    }

    public void setPassword(String password){
        if (password == null || password.trim().isEmpty()){
            throw new IllegalArgumentException("La contrasena no puede estar vacia.");
        }
        this.password = password;
    }
}
