package actividad3.ui;

import actividad3.process.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CLI {
    JFrame frame = new JFrame("Actividad3");
    Operator operator = new Operator();
    
    public void start(){
        window1();
    }

    public void window1(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(null);

        JButton botonS = new JButton("Sudoku");
        botonS.setBounds(35, 60, 100, 30);
        frame.add(botonS);

        JButton botonF = new JButton("Fibonacci");
        botonF.setBounds(250, 60, 100, 30);
        frame.add(botonF);

        JLabel label = new JLabel("Seleccione una opción:");
        label.setBounds(120, 20, 200, 30);
        frame.add(label);

        botonS.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                windowS();
            }
        });

        botonF.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                windowF();
            }
        });

        frame.setVisible(true);
    }

    public void windowS(){
        JFrame frameS = new JFrame("Sudoku");
        frameS.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameS.setSize(400, 200);
        frameS.setLayout(null);

        JLabel label = new JLabel("Ingrese dos numeros del 1 al 9:");
        label.setBounds(100, 20, 200, 30);
        frameS.add(label);

        JTextField num1 = new JTextField();
        num1.setBounds(100, 50, 50, 30);
        frameS.add(num1);

        JTextField num2 = new JTextField();
        num2.setBounds(230, 50, 50, 30);
        frameS.add(num2);

        JButton boton = new JButton("Aceptar");
        boton.setBounds(130, 100, 100, 30);
        frameS.add(boton);

        JButton boton2 = new JButton("Atras");
        boton2.setBounds(10, 10, 70, 20);
        frameS.add(boton2);

        boton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                while (true) {
                try {
                    int n1 = Integer.parseInt(num1.getText());
                    int n2 = Integer.parseInt(num2.getText());
                    if (n1 < 1 || n1 > 9 || n2 < 1 || n2 > 9) {
                        JOptionPane.showMessageDialog(frameS, "Ingrese numeros del 1 al 9");
                        break;
                    } else {
                        int[][] board = operator.sudokuBoard(n1, n2);
                        boolean sudokuSolver = operator.sudokuSolver(board);
                        if (sudokuSolver) {
                            StringBuilder result = new StringBuilder("El Sudoku tiene solucion:\n");
                            for (int[] row : board) {
                                for (int num : row) {
                                    result.append(num).append(" ");
                                }
                                result.append("\n");
                            }
                            JOptionPane.showMessageDialog(frameS, result.toString());
                        } else {
                            JOptionPane.showMessageDialog(frameS, "El Sudoku no tiene solucion.");
                        }
                        break;
                    }

                    
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frameS, "El numero que ingreso no es valido.");
                    return;
                }
            }
        }
        });

        boton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frameS.dispose();
                start();
            }
        });


        frameS.setVisible(true);
    }

    public void windowF() {
        JFrame frameF = new JFrame("Fibonacci");
        frameF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameF.setSize(400, 200);
        frameF.setLayout(null);

        JLabel label = new JLabel("Ingrese un numero:");
        label.setBounds(130, 20, 200, 30);
        frameF.add(label);

        JTextField num = new JTextField();
        num.setBounds(160, 50, 50, 30);
        frameF.add(num);

        JButton boton = new JButton("Aceptar");
        boton.setBounds(130, 100, 100, 30);
        frameF.add(boton);

        JButton boton2 = new JButton("Atras");
        boton2.setBounds(10, 10, 70, 20);
        frameF.add(boton2);

        boton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                while (true) {
                    try {
                        int n = Integer.parseInt(num.getText());
                        if (n < 0) {
                            JOptionPane.showMessageDialog(frameF,"Ingrese un numero positivo.");
                            break;
                        } else {
                            int fib = operator.fibonacci(n);
                            JOptionPane.showMessageDialog(frameF, "El numero Fibonacci en la posicion " + n + " es: " + fib);
                            break;
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(frameF, "El numero que ingreso no es valido.");
                        return;
                    }
                }
            }
        });

        boton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frameF.dispose();
                start();
            }
        });

        frameF.setVisible(true);
    }
}
