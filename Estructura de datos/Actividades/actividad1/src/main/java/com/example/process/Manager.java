package com.example.process;

import com.example.data.Peliculas;
import java.util.*;

public class Manager {
    HashMap<String, Peliculas> peliculas = new HashMap<>();

    public Manager(){
        peliculas.put("IT", new Peliculas("IT", "Terror", 2017)); 
        peliculas.put("El exorcista", new Peliculas("El exorcista", "Terror", 1973));
        peliculas.put("Halloween", new Peliculas("Halloween", "Terror", 1978));

        peliculas.put("Avengers", new Peliculas("Avengers", "Accion", 2015));
        peliculas.put("Terminator", new Peliculas("Terminator", "Accion", 1984));
        peliculas.put("Jhon Wick", new Peliculas("Jhon Wick", "Accion", 2014));

        peliculas.put("Son como niños", new Peliculas("Son como niños","Comedia", 2010));
        peliculas.put("Deadpool", new Peliculas("Deadpool", "Comedia", 2016));
        peliculas.put("¿Qué paso ayer?", new Peliculas("¿Qué paso ayer?", "Comedia", 2010));
    }

    public void addPeliculas(String titulo, String genero, int año){
        Peliculas pelicula = new Peliculas(titulo, genero, año);
        peliculas.put(titulo, pelicula);
    }

    public List<Peliculas> showPeliculas(String genero){
        List<Peliculas> peliculasPorGenero = new ArrayList<>();
        for (Peliculas pelicula : peliculas.values()) {
            if (pelicula.getGenero().equalsIgnoreCase(genero)) {
                peliculasPorGenero.add(pelicula);
            }
        }
        return peliculasPorGenero;
    }

    public void deletePelicula(String titulo){
        if(titulo.equalsIgnoreCase(titulo) == peliculas.containsKey(titulo)){
            peliculas.remove(titulo);
            System.out.println("Pelicula eliminada: " + titulo);
        }else{
            System.out.println("Pelicula no encontrada");
        }

    }

}
