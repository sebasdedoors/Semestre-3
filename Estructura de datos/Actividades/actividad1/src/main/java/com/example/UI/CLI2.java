package com.example.UI;

import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import com.example.process.*;

public class CLI2 {
    private ClientManager clientManager = new ClientManager();
    private Manager manager = new Manager();
    private WorkerManager workerManager = new WorkerManager(); 

    public void window(){
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

        JLabel label2 = new JLabel("¡Bienvenido!");
        label2.setBounds(240, 180, 300, 30);
        label2.setFont(fontGrande);
        label2.setForeground(Color.WHITE);
        frame.add(label2);

        JPanel panel2 = new JPanel(null);
        panel2.setBounds(0, 0, 90, 600);
        panel2.setBackground(Color.red);
        frame.add(panel2);

        JPanel panel = new JPanel(null);
        panel.setBounds(0,0,600,70);
        panel.setBackground(Color.blue);
        frame.add(panel);

        JButton botonAdmin = new JButton("Admin");
        botonAdmin.setBounds(5, 90, 80, 25);
        panel2.add(botonAdmin);
        
        JButton botonUser = new JButton("User");
        botonUser.setBounds(5, 180, 80, 25);
        panel2.add(botonUser);

        JButton botonWorker = new JButton("Worker");
        botonWorker.setBounds(5, 270, 80, 25);
        panel2.add(botonWorker);

        botonAdmin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CLI cli = new CLI();
                cli.loginAdmin();
            }
        });

        botonUser.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CLI_Client cli_Client = new CLI_Client();
                cli_Client.loginUser();
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
