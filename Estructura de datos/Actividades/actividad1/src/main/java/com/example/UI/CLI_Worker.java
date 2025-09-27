package com.example.UI;

import java.util.*;
import java.util.List;

import com.example.data.Task;
import com.example.data.Worker;
import com.example.process.WorkerManager;
import javax.swing.*;

import java.awt.event.*;
import com.example.process.*;
import java.awt.*;

public class CLI_Worker {
    WorkerManager workerManager = new WorkerManager();
    Worker worker;
    Font fontGrande = new Font("Arial", Font.BOLD, 30);
    Font fontTitulo = new Font("Monospaced", Font.BOLD, 25);
    Font fontNormal = new Font("Arial", Font.PLAIN, 15);

    Color fondoPrincipal = Color.decode("#1e1e2f");
    Color panelLateral = Color.decode("#2c2c3c");
    Color encabezado = Color.decode("#ff4757");
    Color boton = Color.decode("#3742fa");
    Color texto = Color.decode("#ffffff");

    public void loginWorker(){
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

        JLabel label2 = new JLabel("Trabajador");
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
        labelUser.setBounds(135, 125, 100, 30);
        labelUser.setForeground(texto);
        frame.add(labelUser);

        JLabel labelId = new JLabel("ID:");
        labelId.setBounds(170, 160, 100, 30);
        labelId.setForeground(texto);
        frame.add(labelId);

        JLabel labelDepar = new JLabel("Departamento:");
        labelDepar.setBounds(100, 195, 100, 30);
        labelDepar.setForeground(texto);
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
                            windowWorker();
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

    public void windowWorker(){
        JFrame frame = new JFrame("Trabajor");
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

        JButton botonAgregar = new JButton("Añadir Tarea");
        botonAgregar.setBackground(boton);
        botonAgregar.setForeground(texto);
        botonAgregar.setFocusPainted(false);
        panelBotones.add(botonAgregar);

        JButton botonMostrar = new JButton("Mostrar Tareas");
        botonMostrar.setBackground(boton);
        botonMostrar.setForeground(texto);
        botonMostrar.setFocusPainted(false);
        panelBotones.add(botonMostrar);

        JButton botonEliminar = new JButton("Eliminar Tareas");
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

        botonAgregar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.remove(labelBien);
                frame.repaint();

                JPanel panelAux = new JPanel(new FlowLayout(FlowLayout.CENTER));
                panelAux.setLayout(new BoxLayout(panelAux, BoxLayout.Y_AXIS));
                panelAux.setBackground(fondoPrincipal);

                JLabel nameText = new JLabel("Titulo de la Tarea");
                nameText.setForeground(texto);
                nameText.setFont(fontTitulo);
                nameText.setAlignmentX(Component.CENTER_ALIGNMENT);

                JTextField name = new JTextField(20);
                name.setMaximumSize(name.getPreferredSize());
                name.setAlignmentX(Component.CENTER_ALIGNMENT);

                JButton siguiente = new JButton("Siguiente");
                siguiente.setAlignmentX(Component.CENTER_ALIGNMENT);
                siguiente.setBackground(boton);
                siguiente.setForeground(texto);
                siguiente.setFocusPainted(false);

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
                        panelAux.setBackground(fondoPrincipal);

                        JLabel departText = new JLabel("Escriba el número de su departamento: 1(Finanzas) - 2(Inventario)");
                        departText.setForeground(texto);
                        departText.setFont(fontNormal);
                        departText.setAlignmentX(Component.CENTER_ALIGNMENT);

                        JTextField department = new JTextField(20);
                        department.setMaximumSize(department.getPreferredSize());
                        department.setAlignmentX(Component.CENTER_ALIGNMENT);

                        JButton siguiente2 = new JButton("Siguiente");
                        siguiente2.setAlignmentX(Component.CENTER_ALIGNMENT);
                        siguiente2.setBackground(boton);
                        siguiente2.setForeground(texto);
                        siguiente2.setFocusPainted(false);

                        panelAux.add(Box.createVerticalStrut(50));
                        panelAux.add(departText);
                        panelAux.add(Box.createVerticalStrut(20));
                        panelAux.add(department);
                        panelAux.add(Box.createVerticalStrut(20));
                        panelAux.add(siguiente2);

                        frame.add(panelAux, BorderLayout.CENTER);

                        frame.revalidate();
                        frame.repaint();

                        siguiente2.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                frame.remove(panelAux);
                                frame.repaint();

                                JPanel panelAux = new JPanel(new FlowLayout(FlowLayout.CENTER));
                                panelAux.setLayout(new BoxLayout(panelAux, BoxLayout.Y_AXIS));
                                panelAux.setBackground(fondoPrincipal);

                                JLabel idText = new JLabel("Escriba el ID de la tarea");
                                idText.setForeground(texto);
                                idText.setFont(fontTitulo);
                                idText.setAlignmentX(Component.CENTER_ALIGNMENT);

                                JTextField id = new JTextField(20);
                                id.setMaximumSize(id.getPreferredSize());
                                id.setAlignmentX(Component.CENTER_ALIGNMENT);

                                JButton siguiente3 = new JButton("Siguiente");
                                siguiente3.setAlignmentX(Component.CENTER_ALIGNMENT);
                                siguiente3.setBackground(boton);
                                siguiente3.setForeground(texto);
                                siguiente3.setFocusPainted(false);

                                panelAux.add(Box.createVerticalStrut(50));
                                panelAux.add(idText);
                                panelAux.add(Box.createVerticalStrut(20));
                                panelAux.add(id);
                                panelAux.add(Box.createVerticalStrut(20));
                                panelAux.add(siguiente3);

                                frame.add(panelAux, BorderLayout.CENTER);

                                frame.revalidate();
                                frame.repaint();

                                siguiente3.addActionListener(new ActionListener() {
                                    public void actionPerformed(ActionEvent e) {
                                        frame.remove(panelAux);
                                        frame.repaint();

                                        JPanel panelAux = new JPanel(new FlowLayout(FlowLayout.CENTER));
                                        panelAux.setLayout(new BoxLayout(panelAux, BoxLayout.Y_AXIS));
                                        panelAux.setBackground(fondoPrincipal);

                                        JLabel prioText = new JLabel("Escriba el nivel de prioridad: 1(Minimo) - 3(Máximo)");
                                        prioText.setForeground(texto);
                                        prioText.setFont(fontNormal);
                                        prioText.setAlignmentX(Component.CENTER_ALIGNMENT);

                                        JTextField priori = new JTextField(20);
                                        priori.setMaximumSize(priori.getPreferredSize());
                                        priori.setAlignmentX(Component.CENTER_ALIGNMENT);

                                        JButton agregar = new JButton("Agregar");
                                        agregar.setAlignmentX(Component.CENTER_ALIGNMENT);
                                        agregar.setBackground(boton);
                                        agregar.setForeground(texto);
                                        agregar.setFocusPainted(false);

                                        panelAux.add(Box.createVerticalStrut(50));
                                        panelAux.add(prioText);
                                        panelAux.add(Box.createVerticalStrut(20));
                                        panelAux.add(priori);
                                        panelAux.add(Box.createVerticalStrut(20));
                                        panelAux.add(agregar);

                                        frame.add(panelAux, BorderLayout.CENTER);

                                        frame.revalidate();
                                        frame.repaint();

                                        agregar.addActionListener(new ActionListener() {
                                            public void actionPerformed(ActionEvent e) {
                                                try {
                                                    String namE = name.getText();
                                                    String departmenT = department.getText();
                                                    String iD = id.getText();
                                                    String priority = priori.getText();

                                                    if (namE.isEmpty() || departmenT.isEmpty() || iD.isEmpty() || priority.isEmpty()) {
                                                        JOptionPane.showMessageDialog(frame, "Los campos no pueden quedar vacios.", "Error", JOptionPane.ERROR_MESSAGE);
                                                        windowWorker();
                                                    } else {
                                                        int departmeNT = Integer.parseInt(departmenT);
                                                        int iDD = Integer.parseInt(iD);
                                                        int prioritY = Integer.parseInt(priority);

                                                        if ((departmeNT <= 0 || departmeNT >= 3) || (iDD <= 0) || (prioritY <= 0 || prioritY >= 4)) {
                                                            JOptionPane.showMessageDialog(frame, "Datos invalidos", "Error", JOptionPane.ERROR_MESSAGE);
                                                            windowWorker();
                                                        } else {
                                                            if (workerManager.addTask(namE, departmeNT, iDD, prioritY)) {
                                                                JOptionPane.showMessageDialog(frame, "Tarea agregada exitosamente.");
                                                                windowWorker();
                                                            }
                                                        }
                                                    }
                                                } catch (Exception a) {
                                                    JOptionPane.showMessageDialog(frame, "Algo ha salido mal, intentalo de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
                                                    windowWorker();
                                                }
                                            }
                                        });

                                    }
                                });
                            }
                        });
                    }
                });
            }
        });

        botonEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.remove(labelBien);
                frame.repaint();

                JPanel panelAux = new JPanel(new FlowLayout(FlowLayout.CENTER));
                panelAux.setLayout(new BoxLayout(panelAux, BoxLayout.Y_AXIS));
                panelAux.setBackground(fondoPrincipal);

                JLabel idText = new JLabel("Escriba el ID de la tarea");
                idText.setForeground(texto);
                idText.setFont(fontTitulo);
                idText.setAlignmentX(Component.CENTER_ALIGNMENT);

                JTextField id = new JTextField(20);
                id.setMaximumSize(id.getPreferredSize());
                id.setAlignmentX(Component.CENTER_ALIGNMENT);

                JButton siguiente = new JButton("Siguiente");
                siguiente.setAlignmentX(Component.CENTER_ALIGNMENT);
                siguiente.setBackground(boton);
                siguiente.setForeground(texto);
                siguiente.setFocusPainted(false);

                panelAux.add(Box.createVerticalStrut(50));
                panelAux.add(idText);
                panelAux.add(Box.createVerticalStrut(20));
                panelAux.add(id);
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
                        panelAux.setBackground(fondoPrincipal);

                        JLabel departText = new JLabel("Escriba el número de su departamento: 1(Finanzas) - 2(Inventario)");
                        departText.setForeground(texto);
                        departText.setFont(fontNormal);
                        departText.setAlignmentX(Component.CENTER_ALIGNMENT);

                        JTextField department = new JTextField(20);
                        department.setMaximumSize(department.getPreferredSize());
                        department.setAlignmentX(Component.CENTER_ALIGNMENT);

                        JButton eliminar = new JButton("Eliminar");
                        eliminar.setAlignmentX(Component.CENTER_ALIGNMENT);
                        eliminar.setBackground(boton);
                        eliminar.setForeground(texto);
                        eliminar.setFocusPainted(false);

                        panelAux.add(Box.createVerticalStrut(50));
                        panelAux.add(departText);
                        panelAux.add(Box.createVerticalStrut(20));
                        panelAux.add(department);
                        panelAux.add(Box.createVerticalStrut(20));
                        panelAux.add(eliminar);

                        frame.add(panelAux, BorderLayout.CENTER);

                        frame.revalidate();
                        frame.repaint();

                        eliminar.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                try {
                            String iD = id.getText();
                            String departmenT = department.getText();

                            if (iD.isEmpty() || departmenT.isEmpty()) {
                                JOptionPane.showMessageDialog(frame, "Los campos no pueden estar vacios.", "Error", JOptionPane.ERROR_MESSAGE);
                                windowWorker();
                            } else {
                                int iDD = Integer.parseInt(iD);
                                int departmeNT = Integer.parseInt(departmenT);
                                
                                if (iDD <= 0 || (departmeNT <= 0 || departmeNT >= 3)) {
                                    JOptionPane.showMessageDialog(frame, "ID o departamento inválido.", "Error", JOptionPane.ERROR_MESSAGE);
                                    windowWorker();
                                } else {
                                    if (workerManager.removeTask(departmeNT, iDD)) {
                                        JOptionPane.showMessageDialog(frame, "Tarea removida con éxito.");
                                        windowWorker();
                                    } else {
                                        JOptionPane.showMessageDialog(frame, "Tarea no encontrada.", "Error", JOptionPane.ERROR_MESSAGE);
                                        windowWorker();
                                    }

                                }
                            }
                        } catch (Exception a) {
                            JOptionPane.showMessageDialog(frame, "Algo ha ocurrido mal, intentalo de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
                            windowWorker();
                        }
                            }
                        });
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

                JLabel prioText = new JLabel("Escriba el nivel de prioridad: 1(Minimo) - 3(Máximo)");
                prioText.setForeground(texto);
                prioText.setFont(fontNormal);
                prioText.setAlignmentX(Component.CENTER_ALIGNMENT);

                JTextField priori = new JTextField(20);
                priori.setMaximumSize(priori.getPreferredSize());
                priori.setAlignmentX(Component.CENTER_ALIGNMENT);

                JButton siguiente = new JButton("Siguiente");
                siguiente.setAlignmentX(Component.CENTER_ALIGNMENT);
                siguiente.setBackground(boton);
                siguiente.setForeground(texto);
                siguiente.setFocusPainted(false);

                panelAux.add(Box.createVerticalStrut(50));
                panelAux.add(prioText);
                panelAux.add(Box.createVerticalStrut(20));
                panelAux.add(priori);
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
                        panelAux.setBackground(fondoPrincipal);

                        JLabel depText = new JLabel("Escriba el número de su departamento: 1(Finanzas) - 2(Inventario)");
                        depText.setForeground(texto);
                        depText.setFont(fontNormal);
                        depText.setAlignmentX(Component.CENTER_ALIGNMENT);

                        JTextField dep = new JTextField(20);
                        dep.setMaximumSize(priori.getPreferredSize());
                        dep.setAlignmentX(Component.CENTER_ALIGNMENT);

                        JButton mostrar = new JButton("Mostrar");
                        mostrar.setAlignmentX(Component.CENTER_ALIGNMENT);
                        mostrar.setBackground(boton);
                        mostrar.setForeground(texto);
                        mostrar.setFocusPainted(false);

                        panelAux.add(Box.createVerticalStrut(50));
                        panelAux.add(depText);
                        panelAux.add(Box.createVerticalStrut(20));
                        panelAux.add(dep);
                        panelAux.add(Box.createVerticalStrut(20));
                        panelAux.add(mostrar);

                        frame.add(panelAux, BorderLayout.CENTER);

                        frame.revalidate();
                        frame.repaint();

                        mostrar.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                try {
                                    String priority = priori.getText();
                                    String department = dep.getText();

                                    if (priority.isEmpty() || department.isEmpty()) {
                                    JOptionPane.showMessageDialog(frame, "Los campos no pueden estar vacios.", "Error", JOptionPane.ERROR_MESSAGE);
                                    windowWorker();
                                    } else {
                                        int prioritY = Integer.parseInt(priority);
                                        int departmenT = Integer.parseInt(department);
                                
                                        if ((prioritY <= 0 || prioritY >= 4) || (departmenT <= 0 || departmenT >= 3)) {
                                            JOptionPane.showMessageDialog(frame, "Nivel de prioridad o departamento inválido.", "Error", JOptionPane.ERROR_MESSAGE);
                                            windowWorker();
                                        } else {
                                            List<Task> lista = workerManager.viewTasks(departmenT, prioritY);

                                            JTextArea area = new JTextArea();
                                            area.setEditable(false);

                                            StringBuilder sb = new StringBuilder();
                                            for (Task task : lista) {
                                                sb.append("Tarea: ").append(task.getDescription()).append("\n");
                                                sb.append("ID: ").append(task.getId()).append("\n");
                                                sb.append("Nivel de Prioridad: ").append(task.getPriority()).append("\n");
                                                sb.append("--------------------------------------\n");
                                            }
                                            area.setText(sb.toString());

                                            JScrollPane scroll = new JScrollPane(area);
                                            scroll.setPreferredSize(new Dimension(400, 200));

                                            JOptionPane.showMessageDialog(frame, scroll, "Listado de tareas:", JOptionPane.INFORMATION_MESSAGE);
                                            windowWorker();
                                        }
                                    }
                                } catch (Exception a) {
                                    a.printStackTrace();
                                    JOptionPane.showMessageDialog(frame, "Algo salio mal, intentalo de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
                                    windowWorker();
                                }
                            }
                        });
                    }
                });
            }
        });

        botonSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                int opcion = JOptionPane.showConfirmDialog(frame, "¿Desea cerrar sesión?", "Cierre de sesión", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                if (opcion == JOptionPane.YES_OPTION) {
                    frame.dispose();
                    loginWorker();
                }
            }
        });

        frame.setVisible(true);
    }
}


                       
