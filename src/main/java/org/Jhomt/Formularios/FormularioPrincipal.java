package org.Jhomt.Formularios;

import org.Jhomt.Utils.EventosClicBotones;

import javax.swing.*;
import java.awt.*;

public class FormularioPrincipal extends JFrame{
     public JPanel panel1;
    private JButton monedasbtn;
    private JButton temperaturabtn;
    private JButton medidasbtn;
    private JButton salirButton;
    private JTextPane bienvenidosALaAppTextPane;
    private JButton historialbtn;

    public FormularioPrincipal() {
        setTitle("Challenge Alura Latam");
        ImageIcon imageIcon = new ImageIcon("C:\\Users\\Jhon\\IdeaProjects\\ChallengeAluraLatam-ConversorG5\\src\\main\\java\\org\\Jhomt\\Imagenes\\logo.png");
        Image icono = imageIcon.getImage();
        setIconImage(icono);
        setSize(1000,550);
        monedasbtn.addActionListener(e -> EventosClicBotones.mostrarVentanaDivisas());
        salirButton.addActionListener(e -> System.exit(0));
        medidasbtn.addActionListener(e -> EventosClicBotones.mostrarVentanaLongitudes());
        temperaturabtn.addActionListener(e -> EventosClicBotones.mostrarVentanaTemperatura());
        historialbtn.addActionListener(e -> EventosClicBotones.mostrarVentanaHistorial());
    }
    public static void main(String[] args) {
        FormularioPrincipal inicioCovertidores= new FormularioPrincipal();
        inicioCovertidores.setContentPane(new FormularioPrincipal().panel1);
        inicioCovertidores.setDefaultCloseOperation(EXIT_ON_CLOSE);
        inicioCovertidores.setVisible(true);
        inicioCovertidores.setSize(1000,550);
        inicioCovertidores.setVisible(true);
        inicioCovertidores.setLocationRelativeTo(null);
    }
}