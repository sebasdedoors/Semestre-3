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

    public void start(){
        window();
    }

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
                frame.remove(label2);
                frame.repaint();
                
                JLabel labelAdmin = new JLabel("Administrador");
                labelAdmin.setBounds(240, 90, 200, 30);
                labelAdmin.setFont(fontTitulo);
                labelAdmin.setForeground(Color.black);
                frame.add(labelAdmin);

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

                botonAceptar.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String username = user.getText();
                        String password = pass.getText();
                        if(username.equals("admin") && password.equals("admin123")) {
                            frame.dispose();
                            loginAdmin();
                        } else {
                            JOptionPane.showMessageDialog(frame, "Usuario o contraseña incorrecta.");
                        }
                    }
                });
            }
        });

        botonUser.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.remove(label2);
                frame.repaint();

                JLabel label = new JLabel("Usuario");
                label.setBounds(240, 90, 200, 30);
                label.setFont(fontTitulo);
                label.setForeground(Color.black);
                frame.add(label);

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

                botonAceptar.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String username = user.getText();
                        String password = pass.getText();
                        if (clientManager.login(username, password)) {
                            frame.dispose();
                            loginUser();
                        } else {
                            JOptionPane.showMessageDialog(frame, "Usuario o contraseña incorrecta.");
                        }
                        
                    }
                });

                botonReg.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String name = user.getText();
                        String password = pass.getText();
                        while (true) {
                            try {
                                if (name.isEmpty() || password.isEmpty()) {
                                    JOptionPane.showMessageDialog(frame, "Los campos no pueden quedar vacios.");
                                    break;
                                } else {
                                    clientManager.addClient(name, password);
                                    JOptionPane.showMessageDialog(frame, "Usuario registrado con exito.");
                                    loginUser();
                                    break;
                                }
                            } catch (Exception ex) {
                                JOptionPane.showMessageDialog(frame, "Error al registrar el usuario.");
                                break;
                            }
                        }
                    }
                });
            }
        });

        botonWorker.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.remove(label2);
                frame.repaint();

                JLabel label = new JLabel("Trabajador");
                label.setBounds(240, 90, 200, 30);
                label.setFont(fontTitulo);
                label.setForeground(Color.black);
                frame.add(label);

                JLabel labelUser = new JLabel("Usuario:");
                labelUser.setBounds(100, 150, 70, 30);
                labelUser.setForeground(Color.black);
                frame.add(labelUser);

                JLabel labelPass = new JLabel("ID:");
                labelPass.setBounds(100, 200, 100, 30);
                labelPass.setForeground(Color.black);
                frame.add(labelPass);

                JLabel labelDepart = new JLabel("Departamento (1 - Finanzas, 2 - Inventario):");
                labelDepart.setBounds(310, 150, 300, 30);
                labelDepart.setForeground(Color.black);
                frame.add(labelDepart);

                JTextField user = new JTextField();
                user.setBounds(160, 150, 100, 30);
                frame.add(user);

                JTextField id = new JTextField();
                id.setBounds(180, 200, 100, 30);
                frame.add(id);

                JTextField depart = new JTextField();
                depart.setBounds(400, 180, 50, 30);
                frame.add(depart);

                JButton botonAceptar = new JButton("Aceptar");
                botonAceptar.setBounds(300, 250, 100, 30);
                frame.add(botonAceptar);

                JButton botonReg = new JButton("Registrarse");
                botonReg.setBounds(170, 250, 110, 30);
                frame.add(botonReg);

                botonAceptar.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String username = user.getText();
                        int idd = Integer.parseInt(id.getText());
                        int department = Integer.parseInt(depart.getText());
                        try {
                            if (workerManager.login(username, department, idd)) {
                                frame.dispose();
                                //windowWorker();
                            } else {
                                JOptionPane.showMessageDialog(frame, "Usuario, departamento o id incorrectos.");
                            }
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(frame, "Datos ingresados no validos.");
                        }
                    }
                });
            }
        });

        frame.setVisible(true);
    }

    public void loginAdmin(){
        JFrame frame = new JFrame("Admin");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);

        Font fontGrande = new Font("Arial", Font.BOLD, 30);

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

        frame.setVisible(true);
    }

    public void loginUser(){
                JFrame frame = new JFrame("Admin");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);

        Font fontGrande = new Font("Arial", Font.BOLD, 30);

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

        frame.setVisible(true);
    }


    public static void main(String[] args) {
        CLI2 cli2 = new CLI2();
        cli2.loginAdmin();
    }
}
