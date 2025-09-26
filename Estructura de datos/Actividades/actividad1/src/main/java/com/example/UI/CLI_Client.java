package com.example.UI;

import com.example.data.Peliculas;
import com.example.process.ClientManager;
import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.util.*;

public class CLI_Client {
    private ClientManager clientManager = new ClientManager();

    public void loginUser(){
        JFrame frame = new JFrame("Inicio");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);

        Font fontGrande = new Font("Arial", Font.BOLD, 30);
        Font fontTitulo = new Font("Arial", Font.PLAIN, 25);
        Font fontNormal = new Font("Arial", Font.PLAIN, 15);

        JLabel label = new JLabel("CINEMANIA");
        label.setBounds(110, 20, 300, 30);
        label.setFont(fontGrande);
        label.setForeground(Color.white);
        frame.add(label);

        JLabel label2 = new JLabel("Usuario");
        label2.setBounds(280, 90, 300, 30);
        label2.setFont(fontTitulo);
        label2.setForeground(Color.BLACK);
        frame.add(label2);

        JPanel panel2 = new JPanel(null);
        panel2.setBounds(0, 0, 90, 600);
        panel2.setBackground(Color.red);
        frame.add(panel2);

        JPanel panel = new JPanel(null);
        panel.setBounds(0,0,600,70);
        panel.setBackground(Color.blue);
        frame.add(panel);

        JLabel labelUser = new JLabel("Usuario:");
        labelUser.setBounds(165, 150, 100, 30);
        labelUser.setForeground(Color.black);
        frame.add(labelUser);

        JLabel labelPass = new JLabel("Contraseña:");
        labelPass.setBounds(150, 200, 100, 30);
        labelPass.setForeground(Color.black);
        frame.add(labelPass);

        JTextField user = new JTextField();
        user.setBounds(250, 150, 200, 30);
        frame.add(user);

        JTextField pass = new JTextField();
        pass.setBounds(250, 200, 200, 30);
        frame.add(pass);

        JButton botonAceptar = new JButton("Aceptar");
        botonAceptar.setBounds(300, 250, 100, 30);
        frame.add(botonAceptar);

        JButton botonReg = new JButton("Registrarse");
        botonReg.setBounds(170, 250, 110, 30);
        frame.add(botonReg);

        JButton botonAdmin = new JButton("Admin");
        botonAdmin.setBounds(5, 90, 80, 25);
        panel2.add(botonAdmin);
        
        JButton botonUser = new JButton("User");
        botonUser.setBounds(5, 180, 80, 25);
        panel2.add(botonUser);

        JButton botonWorker = new JButton("Worker");
        botonWorker.setBounds(5, 270, 80, 25);
        panel2.add(botonWorker);

        botonAceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = user.getText();
                String password = pass.getText();
                if (username.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Los campos no pueden estar vacios.");
                } else {
                    if (!clientManager.login(username, password)) {
                        JOptionPane.showMessageDialog(frame, "Usuario o contraseña incorrectos.");
                    } else {
                        frame.dispose();
                        //windowUser();
                    }
                }
            }
        });

        botonReg.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = user.getText();
                String password = pass.getText();
                if (username.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Los campos no pueden estar vacios.");
                } else {
                    clientManager.addClient(username, password);
                    JOptionPane.showMessageDialog(frame, "Usuario registrado exitosamente.");
                }
            }
        });

        botonAdmin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                CLI cli = new CLI();
                cli.loginAdmin();
            }
        });

        botonWorker.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CLI_Worker cli_Worker = new CLI_Worker();
                cli_Worker.loginWorker();
            }
        });

        frame.setVisible(true);
    }
}
