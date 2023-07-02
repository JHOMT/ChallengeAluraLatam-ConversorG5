package org.Jhomt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConvertidorTemperatura extends JFrame{

    JPanel panel1;
    private JTextField textIngreso;
    private JButton convertirbtn;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JButton atrasbtn;
    private JButton salirbtn;
    private JLabel lblResultado;

    public ConvertidorTemperatura() {
        setTitle("Challenge Alura Latam");
        ImageIcon imageIcon = new ImageIcon("C:\\Users\\Jhon\\IdeaProjects\\ChallengeAluraLatam-ConversorG5\\src\\main\\java\\org\\Jhomt\\Imagenes\\logo.png");
        Image icono = imageIcon.getImage();
        setIconImage(icono);
        setSize(500,350);
        convertirbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertir();
            }
        });
        salirbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        atrasbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                FormularioPrincipal inicioCovertidores= new FormularioPrincipal();
                inicioCovertidores.setContentPane(new FormularioPrincipal().panel1);
                inicioCovertidores.setDefaultCloseOperation(EXIT_ON_CLOSE);
                inicioCovertidores.setVisible(true);
                inicioCovertidores.setSize(500,350);
                inicioCovertidores.setVisible(true);
                inicioCovertidores.setLocationRelativeTo(null);
                inicioCovertidores.setDefaultCloseOperation(EXIT_ON_CLOSE);
                pack();
            }
        });
    }

    public void convertir() {
        String unidadOrigen = (String) comboBox1.getSelectedItem();
        String unidadDestino = (String) comboBox2.getSelectedItem();
        double valor = 0, resultado = 0.0;
        try {
            valor = Double.parseDouble(textIngreso.getText());
        } catch (NumberFormatException e) {
            lblResultado.setText("Ingrese un valor numérico válido");
            return;
        }
        if (unidadOrigen.equals("°C Celcius")) {
            if (unidadDestino.equals("°C Celcius")) {
                resultado = valor;
            } else if (unidadDestino.equals("°F Fahrenheit")) {
                resultado = (valor * 9 / 5) + 32;
            } else if (unidadDestino.equals("°K Kelvin")) {
                resultado = valor + 273.15;
            }
        } else if (unidadOrigen.equals("°F Fahrenheit")) {
            if (unidadDestino.equals("°C Celcius")) {
                resultado = (valor - 32) * 5 / 9;
            } else if (unidadDestino.equals("°F Fahrenheit")) {
                resultado = valor;
            } else if (unidadDestino.equals("°K Kelvin")) {
                resultado = (valor + 459.67) * 5 / 9;
            }
        } else if (unidadOrigen.equals("°K Kelvin")) {
            if (unidadDestino.equals("°C Celcius")) {
                resultado = valor - 273.15;
            } else if (unidadDestino.equals("°F Fahrenheit")) {
                resultado = (valor * 9 / 5) - 459.67;
            } else if (unidadDestino.equals("°K Kelvin")) {
                resultado = valor;
            }
        }
        lblResultado.setText(String.format("%.2f %s = %.2f %s %n", valor, unidadOrigen, resultado, unidadDestino));
    }
}
