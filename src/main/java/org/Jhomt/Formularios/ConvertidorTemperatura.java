package org.Jhomt.Formularios;

import org.Jhomt.Utils.*;

import javax.swing.*;
import java.awt.*;

public class ConvertidorTemperatura extends JFrame implements Convertidor {

    public JPanel panel1;
    private JTextField textIngreso;
    private JButton convertirbtn;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JButton salirbtn;
    private JLabel lblResultado;
    private JButton divisasButton;
    private JButton longitudesButton;
    private JButton principalButton;
    private JButton historialbtn;

    public ConvertidorTemperatura() {
        setTitle("Challenge Alura Latam");
        ImageIcon imageIcon = new ImageIcon("C:\\Users\\Jhon\\IdeaProjects\\ChallengeAluraLatam-ConversorG5\\src\\main\\java\\org\\Jhomt\\Imagenes\\logo.png");
        Image icono = imageIcon.getImage();
        setIconImage(icono);
        setSize(1000,550);
        salirbtn.addActionListener(e -> System.exit(0));
        longitudesButton.addActionListener(e -> EventosClicBotones.mostrarVentanaLongitudes());
        principalButton.addActionListener(e -> EventosClicBotones.mostrarVentanaPrincipal());
        historialbtn.addActionListener(e -> EventosClicBotones.mostrarVentanaHistorial());
        convertirbtn.addActionListener(e -> convertir());
        divisasButton.addActionListener(e -> EventosClicBotones.mostrarVentanaDivisas());
    }
    @Override
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
        switch (unidadOrigen) {
            case "°C Celcius":
                switch (unidadDestino) {
                    case "°C Celcius":resultado = valor;break;
                    case "°F Fahrenheit":resultado = (valor * 9 / 5) + 32;break;
                    case "°K Kelvin":resultado = valor + 273.15;break;
                }
                break;
            case "°F Fahrenheit":
                switch (unidadDestino) {
                    case "°C Celcius":resultado = (valor - 32) * 5 / 9;break;
                    case "°F Fahrenheit":resultado = valor;break;
                    case "°K Kelvin":resultado = (valor + 459.67) * 5 / 9;break;
                }
                break;
            case "°K Kelvin":
                switch (unidadDestino) {
                    case "°C Celcius":resultado = valor - 273.15;break;
                    case "°F Fahrenheit":resultado = (valor * 9 / 5) - 459.67;break;
                    case "°K Kelvin":resultado = valor;break;
                }
                break;
        }
        lblResultado.setText(String.format("%.2f %s = %.2f %s %n", valor, unidadOrigen, resultado, unidadDestino));
        Historial historialApp = Historial.obtenerInstancia();
        historialApp.registrarConversion("Temperatura",unidadOrigen,unidadDestino,valor,resultado);
    }
}
