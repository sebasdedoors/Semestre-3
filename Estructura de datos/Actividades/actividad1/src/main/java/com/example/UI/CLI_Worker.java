package com.example.UI;

import java.util.*;
import com.example.data.Task;
import com.example.process.WorkerManager;
import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import com.example.process.*;

public class CLI_Worker {
    public void loginWorker(){
        WorkerManager workerManager = new WorkerManager();

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

        JLabel label2 = new JLabel("Trabajador");
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
        labelUser.setBounds(135, 125, 100, 30);
        labelUser.setForeground(Color.black);
        frame.add(labelUser);

        JLabel labelId = new JLabel("ID:");
        labelId.setBounds(170, 160, 100, 30);
        labelId.setForeground(Color.black);
        frame.add(labelId);

        JLabel labelDepar = new JLabel("Departamento:");
        labelDepar.setBounds(100, 195, 100, 30);
        labelDepar.setForeground(Color.BLACK);
        frame.add(labelDepar);

        JTextField user = new JTextField();
        user.setBounds(195, 132, 100, 20);
        frame.add(user);

        JTextField idField = new JTextField();
        idField.setBounds(195, 167, 100, 20);
        frame.add(idField);

        JTextField deparField = new JTextField();
        deparField.setBounds(195, 201, 100, 20);
        frame.add(deparField);

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
                String idText = idField.getText();
                String departmentText = deparField.getText();

                if (username.isEmpty() || idText.isEmpty() || departmentText.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Los campos no pueden estar vacios.");
                } else {
                    int id = Integer.parseInt(idText);
                    int department = Integer.parseInt(departmentText);
                    if (id <= 0 || (department <= 0 && department >= 3)) {
                        JOptionPane.showMessageDialog(frame, "ID o departamento invalido.");
                    } else {
                        if (!workerManager.login(username, department, id)) {
                            JOptionPane.showMessageDialog(frame, "Usuario no encontrado.");
                        } else {
                            frame.dispose();
                            //windowWorker();
                        }
                    }

                }
            }
        });

        botonReg.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = user.getText();
                String idText = idField.getText();
                String departmentText = deparField.getText();

                if (username.isEmpty() || idText.isEmpty() || departmentText.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Los campos no pueden estar vacios.");
                }else {
                    int id = Integer.parseInt(idText);
                    int department = Integer.parseInt(departmentText);
                    
                    if (id <= 0 || (department <= 0 && department >= 3)) {
                        JOptionPane.showMessageDialog(frame, "El ID o departamento son invalidos.");
                    } else {
                        workerManager.addWorker(username, department, id);
                        JOptionPane.showMessageDialog(frame, "Usuario registrado exitosamente.");
                    }
                }
            }
        });

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

        frame.setVisible(true);
    }
}
