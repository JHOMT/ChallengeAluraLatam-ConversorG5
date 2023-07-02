package org.Jhomt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class FormularioPrincipal extends JFrame{
     JPanel panel1;
    private JButton monedasbtn;
    private JButton temperaturabtn;
    private JButton medidasbtn;
    private JButton salirButton;

    public FormularioPrincipal() {
        frameInit();
        setTitle("Challenge Alura Latam");
        ImageIcon imageIcon = new ImageIcon("C:\\Users\\Jhon\\IdeaProjects\\ChallengeAluraLatam-ConversorG5\\src\\main\\java\\org\\Jhomt\\Imagenes\\logo.png");
        Image icono = imageIcon.getImage();
        setIconImage(icono);
        JLabel image= new JLabel(new ImageIcon(imageIcon.getImage())) ;

        add(image);


        monedasbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                ConvertidorMonedas formulario= new ConvertidorMonedas();
                formulario.setContentPane(new ConvertidorMonedas().panel1);
                formulario.setVisible(true);
                formulario.setLocationRelativeTo(null);
            }
        });
        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        medidasbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                ConvertidorMedidas convertirMedidas= new ConvertidorMedidas();
                convertirMedidas.setContentPane(new ConvertidorMedidas().panel1);
                convertirMedidas.setVisible(true);
                convertirMedidas.setLocationRelativeTo(null);
            }
        });
        temperaturabtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                ConvertidorTemperatura convertidorTemperatura= new ConvertidorTemperatura();
                convertidorTemperatura.setContentPane(new ConvertidorTemperatura().panel1);
                convertidorTemperatura.setVisible(true);
                convertidorTemperatura.setLocationRelativeTo(null);
            }
        });
    }


    public static void main(String[] args) {
        FormularioPrincipal inicioCovertidores= new FormularioPrincipal();
        inicioCovertidores.setContentPane(new FormularioPrincipal().panel1);
        inicioCovertidores.setDefaultCloseOperation(EXIT_ON_CLOSE);
        inicioCovertidores.setVisible(true);
        inicioCovertidores.setSize(500,350);
        inicioCovertidores.setVisible(true);
        inicioCovertidores.setLocationRelativeTo(null);
        inicioCovertidores.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
}
