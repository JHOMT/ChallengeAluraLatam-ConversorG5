package org.Jhomt.Formularios;

import org.Jhomt.Utils.Convertidor;
import org.Jhomt.Utils.EventosClicBotones;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConvertidorMonedas extends JFrame implements Convertidor {
    public JPanel panel1;
    private JLabel lblTitulo;
    private JComboBox<String> lblMonedas1;
    private JComboBox<String> lblMonedas2;
    private JButton convertirbtn;
    private JTextField txtIngreso;
    private JPanel PanelControl;
    private JLabel lblSalida;
    private JButton salirButton;
    private JButton longitudesButton;
    private JButton temperaturasButton;
    private JButton pricipalButton;
    private JButton historialbtn;


    public ConvertidorMonedas() {
        setTitle("Challenge Alura Latam");
        ImageIcon imageIcon = new ImageIcon("C:\\Users\\Jhon\\IdeaProjects\\ChallengeAluraLatam-ConversorG5\\src\\main\\java\\org\\Jhomt\\Imagenes\\logo.png");
        Image icono = imageIcon.getImage();
        setIconImage(icono);
        setSize(1000,550);

        convertirbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertir();

            }
        });
        salirButton.addActionListener(e -> System.exit(0));
        longitudesButton.addActionListener(e -> EventosClicBotones.mostrarVentanaLongitudes());
        temperaturasButton.addActionListener(e -> EventosClicBotones.mostrarVentanaTemperatura());
        pricipalButton.addActionListener(e -> EventosClicBotones.mostrarVentanaPrincipal());
        historialbtn.addActionListener(e -> EventosClicBotones.mostrarVentanaHistorial());
    }
    @Override
    public void convertir(){
        String unidadOrigen = (String) lblMonedas1.getSelectedItem();
        String unidadDestino = (String) lblMonedas2.getSelectedItem();
        double valor = 0, resultado=0.0;
        try{
            valor= Integer.parseInt(txtIngreso.getText());
        }catch (NumberFormatException e){
            lblSalida.setText("Ingrese un valor numerico válido");
            return;
        }
        if (unidadOrigen.equals("S/ Sol Peruano")){
            if (unidadDestino.equals("$ Dólar")) {
                resultado = valor * 3.63;
            } else if (unidadDestino.equals("£ Libras Esterlinas")) {
                resultado = valor * 4.58;
            } else if (unidadDestino.equals("€ Euros")) {
                resultado = valor * 3.93;
            } else if (unidadDestino.equals("¥ Yen Japones")) {
                resultado = valor * 0.025;
            }else if (unidadDestino.equals("₩ Won sul-coreano")){
                resultado= valor*0.0027;
            }else {
                resultado=valor;
            }
        }else if (unidadOrigen.equals("$ Dólar")){
            if (unidadDestino.equals("S/ Sol Peruano")) {
                resultado = valor * 3.62;
            } else if (unidadDestino.equals("£ Libras Esterlinas")) {
                resultado = valor * 1.26;
            } else if (unidadDestino.equals("€ Euros")) {
                resultado = valor * 1.09;
            } else if (unidadDestino.equals("¥ Yen Japones")) {
                resultado = valor * 0.0069;
            }else if (unidadDestino.equals("₩ Won sul-coreano")){
                resultado= valor*0.00076;
            }else {
                resultado=valor;
            }
        }else if (unidadOrigen.equals("£ Libras Esterlinas")){
            if (unidadDestino.equals("S/ Sol Peruano")) {
                resultado = valor * 0.22;
            } else if (unidadDestino.equals("$ Dólar")) {
                resultado = valor * 0.79;
            } else if (unidadDestino.equals("€ Euros")) {
                resultado = valor * 0.86;
            } else if (unidadDestino.equals("¥ Yen Japones")) {
                resultado = valor * 54.65;
            }else if (unidadDestino.equals("₩ Won sul-coreano")){
                resultado= valor*0.00060;
            }else {
                resultado=valor;
            }
        }else if (unidadOrigen.equals("€ Euros")){
            if (unidadDestino.equals("S/ Sol Peruano")) {
                resultado = valor * 0.22;
            } else if (unidadDestino.equals("$ Dólar")) {
                resultado = valor * 0.79;
            } else if (unidadDestino.equals("£ Libras Esterlinas")) {
                resultado = valor * 1.16;
            } else if (unidadDestino.equals("¥ Yen Japones")) {
                resultado = valor * 0.0064;
            }else if (unidadDestino.equals("₩ Won sul-coreano")){
                resultado= valor*0.00070;
            }else {
                resultado=valor;
            }
        }else if (unidadOrigen.equals("¥ Yen Japones")){
            if (unidadDestino.equals("S/ Sol Peruano")) {
                resultado = valor * 39.81;
            } else if (unidadDestino.equals("$ Dólar")) {
                resultado = valor * 144.31;
            } else if (unidadDestino.equals("€ Euros")) {
                resultado = valor * 157.47;
            } else if (unidadDestino.equals("£ Libras Esterlinas")) {
                resultado = valor * 183.32;
            }else if (unidadDestino.equals("₩ Won sul-coreano")){
                resultado= valor*0.11;
            }else {
                resultado=valor;
            }
        }else if (unidadOrigen.equals("₩ Won sul-coreano")){
            if (unidadDestino.equals("S/ Sol Peruano")) {
                resultado = valor * 363.39;
            } else if (unidadDestino.equals("$ Dólar")) {
                resultado = valor * 1317.17;
            } else if (unidadDestino.equals("€ Euros")) {
                resultado = valor * 1437.43;
            } else if (unidadDestino.equals("£ Libras Esterlinas")) {
                resultado = valor * 1673.07;
            }else if (unidadDestino.equals("¥ Yen Japones")){
                resultado= valor*9.13;
            }else {
                resultado=valor;
            }
        }
        lblSalida.setText(String.format("%.2f %s = %.2f %s %n", valor, unidadOrigen, resultado, unidadDestino));
        Historial historialApp = Historial.obtenerInstancia();
        historialApp.registrarConversion("Divisas",unidadOrigen,unidadDestino,valor,resultado);
    }

}
