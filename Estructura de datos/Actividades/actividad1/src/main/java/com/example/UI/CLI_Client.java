package com.example.UI;

import com.example.*;
import com.example.data.Client;
import com.example.data.Peliculas;
import com.example.process.ClientManager;
import com.example.process.Manager;

import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.awt.*;
import java.util.List;
import java.util.*;

public class CLI_Client {
    private ClientManager clientManager = new ClientManager();
    private Client client;
    private Manager manager = new Manager();

    Font fontGrande = new Font("Arial", Font.BOLD, 30);
    Font fontTitulo = new Font("Monospaced", Font.BOLD, 25);
    Font fontNormal = new Font("Arial", Font.PLAIN, 15);

    Color fondoPrincipal = Color.decode("#1e1e2f");
    Color panelLateral = Color.decode("#2c2c3c");
    Color encabezado = Color.decode("#ff4757");
    Color boton = Color.decode("#3742fa");
    Color texto = Color.decode("#ffffff");

    public void loginUser(){
        JFrame frame = new JFrame("Inicio");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.getContentPane().setBackground(fondoPrincipal);

        JLabel label = new JLabel("CINEMANIA");
        label.setBounds(110, 20, 300, 30);
        label.setFont(fontGrande);
        label.setForeground(texto);
        frame.add(label);

        JLabel label2 = new JLabel("Usuario");
        label2.setBounds(280, 90, 300, 30);
        label2.setFont(fontTitulo);
        label2.setForeground(texto);
        frame.add(label2);

        JPanel panel2 = new JPanel(null);
        panel2.setBounds(0, 0, 90, 600);
        panel2.setBackground(panelLateral);
        frame.add(panel2);

        JPanel panel = new JPanel(null);
        panel.setBounds(0,0,600,70);
        panel.setBackground(encabezado);
        frame.add(panel);

        JLabel labelUser = new JLabel("Usuario:");
        labelUser.setBounds(165, 150, 100, 30);
        labelUser.setForeground(texto);
        frame.add(labelUser);

        JLabel labelPass = new JLabel("Contraseña:");
        labelPass.setBounds(150, 200, 100, 30);
        labelPass.setForeground(texto);
        frame.add(labelPass);

        JTextField user = new JTextField();
        user.setBounds(250, 150, 200, 30);
        frame.add(user);

        JTextField pass = new JTextField();
        pass.setBounds(250, 200, 200, 30);
        frame.add(pass);

        JButton botonAceptar = new JButton("Aceptar");
        botonAceptar.setBounds(300, 250, 100, 30);
        botonAceptar.setBackground(boton);
        botonAceptar.setForeground(texto);
        botonAceptar.setFocusPainted(false);
        frame.add(botonAceptar);

        JButton botonReg = new JButton("Registrarse");
        botonReg.setBounds(170, 250, 110, 30);
        botonReg.setBackground(boton);
        botonReg.setForeground(texto);
        botonReg.setFocusPainted(false);
        frame.add(botonReg);

        JButton botonAdmin = new JButton("Admin");
        botonAdmin.setBounds(5, 90, 80, 25);
        botonAdmin.setBackground(boton);
        botonAdmin.setForeground(texto);
        botonAdmin.setFocusPainted(false);
        panel2.add(botonAdmin);
        
        JButton botonUser = new JButton("User");
        botonUser.setBounds(5, 180, 80, 25);
        botonUser.setBackground(boton);
        botonUser.setForeground(texto);
        botonUser.setFocusPainted(false);
        panel2.add(botonUser);

        JButton botonWorker = new JButton("Worker");
        botonWorker.setBounds(5, 270, 80, 25);
        botonWorker.setBackground(boton);
        botonWorker.setForeground(texto);
        botonWorker.setFocusPainted(false);
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
                        windowUser();
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

    public void windowUser(){
        JFrame frame = new JFrame("Cliente.");
        frame.setSize(600, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(fondoPrincipal);

        JLabel labelBien = new JLabel("Bienvenido", SwingConstants.CENTER);
        labelBien.setFont(fontGrande);
        labelBien.setForeground(texto);
        frame.add(labelBien);

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelBotones.setBackground(encabezado);

        JButton botonComprar = new JButton("Comprar");
        botonComprar.setBackground(boton);
        botonComprar.setForeground(texto);
        botonComprar.setFocusPainted(false);
        panelBotones.add(botonComprar);

        JButton botonMostrar = new JButton("Ver Películas");
        botonMostrar.setBackground(boton);
        botonMostrar.setForeground(texto);
        botonMostrar.setFocusPainted(false);
        panelBotones.add(botonMostrar);

        JButton botonCarrito = new JButton("Ver Carrito");
        botonCarrito.setBackground(boton);
        botonCarrito.setForeground(texto);
        botonCarrito.setFocusPainted(false);
        panelBotones.add(botonCarrito);

        JButton botonEliminar = new JButton("Eliminar");
        botonEliminar.setBackground(boton);
        botonEliminar.setForeground(texto);
        botonEliminar.setFocusPainted(false);
        panelBotones.add(botonEliminar);

        JButton botonSalir = new JButton("Cerrar Sesión");
        botonSalir.setBackground(boton);
        botonSalir.setForeground(texto);
        botonSalir.setFocusPainted(false);
        panelBotones.add(botonSalir);

        frame.add(panelBotones, BorderLayout.NORTH);

        botonComprar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.remove(labelBien);
                frame.repaint();

                JPanel panelAux = new JPanel(new FlowLayout(FlowLayout.CENTER));
                panelAux.setLayout(new BoxLayout(panelAux, BoxLayout.Y_AXIS));
                panelAux.setBackground(fondoPrincipal);

                JLabel nameText = new JLabel("Titulo de la película");
                nameText.setForeground(texto);
                nameText.setFont(fontTitulo);
                nameText.setAlignmentX(Component.CENTER_ALIGNMENT);

                JTextField name = new JTextField(20);
                name.setMaximumSize(name.getPreferredSize());
                name.setAlignmentX(Component.CENTER_ALIGNMENT);

                JButton agregar = new JButton("Agregar");
                agregar.setAlignmentX(Component.CENTER_ALIGNMENT);
                agregar.setBackground(boton);
                agregar.setForeground(texto);
                agregar.setFocusPainted(false);

                panelAux.add(Box.createVerticalStrut(50));
                panelAux.add(nameText);
                panelAux.add(Box.createVerticalStrut(20));
                panelAux.add(name);
                panelAux.add(Box.createVerticalStrut(20));
                panelAux.add(agregar);

                frame.add(panelAux, BorderLayout.CENTER);

                frame.revalidate();
                frame.repaint();

                agregar.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String namE = name.getText();

                        try {
                            if (namE.isEmpty()) {
                                JOptionPane.showMessageDialog(frame, "Los campos no deben estar vacios.", "Error", JOptionPane.ERROR_MESSAGE);
                                windowUser();
                            } else {
                                if (clientManager.addToCart(namE)) {
                                    JOptionPane.showMessageDialog(frame, "La pelicula se agregó con exito.");
                                    windowUser();
                                } else {
                                    JOptionPane.showMessageDialog(frame, "Película no encontrada.");
                                    windowUser();
                                }
                            }
                        } catch (Exception a) {
                            JOptionPane.showMessageDialog(frame, "Algo ha ocurrido mal, intentalo de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
                            windowUser();
                        }
                    }
                });
            }
        });

        botonCarrito.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                List<Peliculas> lista = clientManager.viewCart();

                DefaultListModel<String> model = new DefaultListModel<>();
                for (Peliculas p : lista) {
                    model.addElement(p.getTitulo() + " - " + p.getGenero() + " - " + p.getAño());
                }

                JList<String> jlist = new JList<>(model);
                jlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                jlist.setVisibleRowCount(10);

                JScrollPane scrollPane = new JScrollPane(jlist);
                scrollPane.setPreferredSize(new Dimension(500, 200));

                JOptionPane.showMessageDialog(frame, scrollPane, "Listado de Peliculas:", JOptionPane.PLAIN_MESSAGE);
                windowUser();
            }
        });

        botonEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.remove(labelBien);
                frame.repaint();

                JPanel panelAux = new JPanel(new FlowLayout(FlowLayout.CENTER));
                panelAux.setLayout(new BoxLayout(panelAux, BoxLayout.Y_AXIS));
                panelAux.setBackground(fondoPrincipal);

                JLabel nameText = new JLabel("Titulo de la película");
                nameText.setForeground(texto);
                nameText.setFont(fontTitulo);
                nameText.setAlignmentX(Component.CENTER_ALIGNMENT);

                JTextField name = new JTextField(20);
                name.setMaximumSize(name.getPreferredSize());
                name.setAlignmentX(Component.CENTER_ALIGNMENT);

                JButton eliminar = new JButton("Eliminar");
                eliminar.setAlignmentX(Component.CENTER_ALIGNMENT);
                eliminar.setBackground(boton);
                eliminar.setForeground(texto);
                eliminar.setFocusPainted(false);

                panelAux.add(Box.createVerticalStrut(50));
                panelAux.add(nameText);
                panelAux.add(Box.createVerticalStrut(20));
                panelAux.add(name);
                panelAux.add(Box.createVerticalStrut(20));
                panelAux.add(eliminar);

                frame.add(panelAux, BorderLayout.CENTER);

                frame.revalidate();
                frame.repaint();

                eliminar.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String namE = name.getText();

                        try {
                            if (namE.isEmpty()) {
                            JOptionPane.showMessageDialog(frame, "Los espacios no pueden estar vacios.", "Error", JOptionPane.ERROR_MESSAGE);
                            windowUser();
                            } else {
                                if (clientManager.removeFromCart(namE)) {
                                    JOptionPane.showMessageDialog(frame, "La pelicula fue removida con exito.");
                                    windowUser();
                                } else {
                                    JOptionPane.showMessageDialog(frame, "La pelicula no fue encontrada.");
                                    windowUser();
                                }
                            }
                        } catch (Exception a) {
                            JOptionPane.showMessageDialog(frame, "Algo ha salido mal, intentalo de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
                            windowUser();
                        }
                    }
                });
            }
        });

        botonMostrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.remove(labelBien);
                frame.repaint();

                JPanel panelAux = new JPanel(new FlowLayout(FlowLayout.CENTER));
                panelAux.setLayout(new BoxLayout(panelAux, BoxLayout.Y_AXIS));
                panelAux.setBackground(fondoPrincipal);

                JLabel generText = new JLabel("Género por buscar.");
                generText.setForeground(texto);
                generText.setFont(fontTitulo);
                generText.setAlignmentX(Component.CENTER_ALIGNMENT);

                JTextField gener = new JTextField(20);
                gener.setMaximumSize(gener.getPreferredSize());
                gener.setAlignmentX(Component.CENTER_ALIGNMENT);

                JButton siguiente = new JButton("Buscar.");
                siguiente.setAlignmentX(Component.CENTER_ALIGNMENT);
                siguiente.setBackground(boton);
                siguiente.setForeground(texto);
                siguiente.setFocusPainted(false);

                panelAux.add(Box.createVerticalStrut(50));
                panelAux.add(generText);
                panelAux.add(Box.createVerticalStrut(20));
                panelAux.add(gener);
                panelAux.add(Box.createVerticalStrut(20));
                panelAux.add(siguiente);

                frame.add(panelAux, BorderLayout.CENTER);

                frame.revalidate();
                frame.repaint();

                siguiente.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        try {
                            frame.remove(panelAux);
                            frame.repaint();

                            String geneR = gener.getText();

                            if (geneR.isEmpty()) {
                                JOptionPane.showMessageDialog(frame, "El campo no puede estar vacio.");
                                windowUser();
                            } else {
                                List<Peliculas> lista = manager.showPeliculas(geneR);

                                if (lista.isEmpty()) {
                                    JOptionPane.showMessageDialog(frame, "Género no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
                                    windowUser();
                                } else {

                                JTextArea area = new JTextArea();
                                area.setEditable(false);

                                StringBuilder sb = new StringBuilder();
                                for (Peliculas p : lista) {
                                    sb.append("Titulo: ").append(p.getTitulo()).append("\n");
                                    sb.append("Género: ").append(p.getGenero()).append("\n");
                                    sb.append("Año: ").append(p.getAño()).append("\n");
                                    sb.append("----------------------------\n");
                                }
                                area.setText(sb.toString());

                                JScrollPane scroll = new JScrollPane(area);
                                scroll.setPreferredSize(new Dimension(400, 200));

                                JOptionPane.showMessageDialog(frame, scroll, "Listado de películas de género " + geneR, JOptionPane.INFORMATION_MESSAGE);
                                windowUser();
                            }}
                        } catch (Exception a) {
                            JOptionPane.showMessageDialog(frame, "Algo ha ocurrido mal, intentalo de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
                            windowUser();
                        }
                    }
                });
            }
        });

        botonSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int opcion = JOptionPane.showConfirmDialog(frame, "¿Desea cerrar sesión?", "Cierre de sesión", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                if (opcion == JOptionPane.YES_OPTION) {
                    frame.dispose();
                    loginUser();
                }
            }
        });

        frame.setVisible(true);
    }
}
