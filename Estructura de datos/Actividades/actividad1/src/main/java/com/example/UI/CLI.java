package com.example.UI;

import com.example.process.Manager;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.*;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import com.example.data.Peliculas;

public class CLI {
    private Manager manager = new Manager();
    Font fontGrande = new Font("Arial", Font.BOLD, 30);
    Font fontTitulo = new Font("Monospaced", Font.BOLD, 25);
    Font fontNormal = new Font("Arial", Font.PLAIN, 15);

    public void loginAdmin(){
        JFrame frame = new JFrame("Inicio");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);

        JLabel label = new JLabel("CINEMANIA");
        label.setBounds(110, 20, 300, 30);
        label.setFont(fontGrande);
        label.setForeground(Color.white);
        frame.add(label);

        JLabel label2 = new JLabel("Administrador");
        label2.setBounds(240, 90, 200, 30);
        label2.setFont(fontTitulo);
        label2.setForeground(Color.black);
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
                if(username.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Los datos no pueden estar vacios.");
                    
                } else {
                    if (!username.equals("admin") || !password.equals("admin123")) {
                        JOptionPane.showMessageDialog(frame, "Usuario o contraseña incorrecta.");
                    } else {
                        frame.dispose();
                        windowAdmin();
                    }
                }
            }
        });

        botonUser.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                frame.dispose();
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

    public void windowAdmin(){
        JFrame frame = new JFrame("Administrador");
        frame.setSize(600, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);

        JLabel labelBien = new JLabel("Bienvenido Administrador.", SwingConstants.CENTER);
        labelBien.setFont(fontGrande);
        frame.add(labelBien);

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelBotones.setBackground(Color.RED);

        JButton botonAgregar = new JButton("Agregar Películas.");
        panelBotones.add(botonAgregar);

        JButton botonMostrar = new JButton("Mostrar Películas.");
        panelBotones.add(botonMostrar);

        JButton botonEliminar = new JButton("Eliminar Película.");
        panelBotones.add(botonEliminar);

        JButton botonSalir = new JButton("Cerrar Sesión.");
        panelBotones.add(botonSalir);

        frame.add(panelBotones, BorderLayout.NORTH);

        botonAgregar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.remove(labelBien);
                frame.repaint();

                JPanel panelAux = new JPanel(new FlowLayout(FlowLayout.CENTER));
                panelAux.setLayout(new BoxLayout(panelAux, BoxLayout.Y_AXIS));
                panelAux.setBackground(Color.LIGHT_GRAY);

                JLabel nameText = new JLabel("Titulo de la película.");
                nameText.setForeground(Color.BLACK);
                nameText.setFont(fontTitulo);
                nameText.setAlignmentX(Component.CENTER_ALIGNMENT);
                //


                JTextField name = new JTextField(20);
                name.setMaximumSize(name.getPreferredSize());
                name.setAlignmentX(Component.CENTER_ALIGNMENT);
                //

                JButton siguiente = new JButton("Siguiente");
                siguiente.setAlignmentX(Component.CENTER_ALIGNMENT);
                //

                panelAux.add(Box.createVerticalStrut(50));
                panelAux.add(nameText);
                panelAux.add(Box.createVerticalStrut(20));
                panelAux.add(name);
                panelAux.add(Box.createVerticalStrut(20));
                panelAux.add(siguiente);

                frame.add(panelAux, BorderLayout.CENTER);

                frame.revalidate();
                frame.repaint();

                siguiente.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        frame.remove(panelAux);
                        frame.repaint();

                        JPanel panelAux = new JPanel(new FlowLayout(FlowLayout.CENTER));
                        panelAux.setLayout(new BoxLayout(panelAux, BoxLayout.Y_AXIS));
                        panelAux.setBackground(Color.LIGHT_GRAY);

                        JLabel generoText = new JLabel("Género de la pelicula.");
                        generoText.setForeground(Color.BLACK);
                        generoText.setFont(fontTitulo);
                        generoText.setAlignmentX(Component.CENTER_ALIGNMENT);

                        JTextField gener = new JTextField(20);
                        gener.setMaximumSize(gener.getPreferredSize());
                        gener.setAlignmentX(Component.CENTER_ALIGNMENT);

                        panelAux.add(Box.createVerticalStrut(50));
                        panelAux.add(generoText);
                        panelAux.add(Box.createVerticalStrut(20));
                        panelAux.add(gener);
                        panelAux.add(Box.createVerticalStrut(20));
                        panelAux.add(siguiente);

                        frame.add(panelAux, BorderLayout.CENTER);

                        frame.revalidate();
                        frame.repaint();

                        siguiente.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                frame.remove(panelAux);
                                frame.repaint();

                                JPanel panelAux = new JPanel(new FlowLayout(FlowLayout.CENTER));
                                panelAux.setLayout(new BoxLayout(panelAux, BoxLayout.Y_AXIS));
                                panelAux.setBackground(Color.LIGHT_GRAY);

                                JLabel yearText = new JLabel("Año de la pelicula.");
                                yearText.setForeground(Color.BLACK);
                                yearText.setFont(fontTitulo);
                                yearText.setAlignmentX(Component.CENTER_ALIGNMENT);

                                JTextField year = new JTextField(20);
                                year.setMaximumSize(gener.getPreferredSize());
                                year.setAlignmentX(Component.CENTER_ALIGNMENT);

                                JButton agregar = new JButton("Agregar Película");
                                agregar.setAlignmentX(Component.CENTER_ALIGNMENT);

                                panelAux.add(Box.createVerticalStrut(50));
                                panelAux.add(yearText);
                                panelAux.add(Box.createVerticalStrut(20));
                                panelAux.add(year);
                                panelAux.add(Box.createVerticalStrut(20));
                                panelAux.add(agregar);

                                frame.add(panelAux, BorderLayout.CENTER);

                                frame.revalidate();
                                frame.repaint();

                                agregar.addActionListener(new ActionListener() {
                                    public void actionPerformed(ActionEvent e) {
                                        try {
                                            String namE = name.getText();
                                            String geneR = gener.getText();
                                            String yeaR = year.getText();

                                            if (namE.isEmpty() || geneR.isEmpty() || yeaR.isEmpty()) {
                                                JOptionPane.showMessageDialog(frame, "Ninguno de los campos pueden estar vacios.");
                                                windowAdmin();
                                            } else {
                                                int yeAR = Integer.parseInt(yeaR);
                                                if (yeAR <= 0) {
                                                    JOptionPane.showMessageDialog(frame, "El año debe ser un número positivo.");
                                                    windowAdmin();
                                                } else {
                                                    manager.addPeliculas(namE, geneR, yeAR);
                                                    JOptionPane.showMessageDialog(frame, "Película agregada con exito.");
                                                    windowAdmin();
                                                }
                                            }
                                        } catch (Exception a) {
                                            JOptionPane.showMessageDialog(frame, a);
                                            windowAdmin();
                                        }
                                    }
                                });
                            }
                        });
                    }
                });
            }
        });

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        CLI cli = new CLI();
        cli.windowAdmin();
    }
}
