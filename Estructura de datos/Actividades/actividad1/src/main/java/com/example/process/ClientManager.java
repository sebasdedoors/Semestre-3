package com.example.process;

import com.example.data.Client;
import com.example.data.Peliculas;
import java.util.*;

public class ClientManager {
    List<Client> clients = new ArrayList<>();
    List<Peliculas> cart = new ArrayList<>();
    Manager manager = new Manager();

    public ClientManager(){
        clients.add(new Client("Victor", "1234"));
        clients.add(new Client("Sebastian", "1234"));
        clients.add(new Client("Daniela", "1234"));
        clients.add(new Client("Michel", "1234"));
    }

    public boolean login(String name, String password){
        for (Client client : clients){
            if (client.getName().equals(name) && client.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }

    public boolean addToCart(String titulo){
        for (Peliculas pelicula : manager.peliculas.values()){
            if (pelicula.getTitulo().equalsIgnoreCase(titulo)){
                cart.add(pelicula);
                return true;
            } 
        }
        return false;
    }

    public List<Peliculas> viewCart(){
        return cart;
    }

    public boolean removeFromCart(String titulo){
        for(Peliculas pelicula : cart){
            if(pelicula.getTitulo().equalsIgnoreCase(titulo)){
                cart.remove(pelicula);
                return true;
            }
        }
        return false;
    }

    public void addClient(String name, String password){
        clients.add(new Client(name, password));
    }
}
