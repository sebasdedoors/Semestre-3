package com.example.data;

public class Peliculas {
    public String titulo;
    public String genero;
    public int año;

    public Peliculas(String titulo, String genero, int año){
        setTitulo(titulo);
        setGenero(genero);
        setAño(año);
    }

    public String getTitulo(){
        return titulo;
    }
    
    public String getGenero(){
        return genero;
    }

    public int getAño(){
        return año;
    }

    public void setTitulo(String titulo){
        if (titulo == null || titulo.trim().isEmpty()){
            throw new IllegalArgumentException("El titulo no puede estar vacio.");
        }
        this.titulo = titulo;
    }

    public void setGenero(String genero){
        if (genero == null || genero.trim().isEmpty()){
            throw new IllegalArgumentException("El genero no puede estar vacio.");
        }
        this.genero = genero;
    }

    public void setAño(int año){
        if (año <= 0){
            throw new IllegalArgumentException("El año debe ser un numero positivo.");
        }
        this.año = año;
    }

}
