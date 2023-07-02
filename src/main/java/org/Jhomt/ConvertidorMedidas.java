package org.Jhomt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConvertidorMedidas extends JFrame{
    JPanel panel1;
    private JButton convertirButton;
    private JButton atrasbtn;
    private JButton salitbtn;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JTextField txtIngreso;
    private JLabel lblResultado;

    public ConvertidorMedidas() {
        setTitle("Challenge Alura Latam");
        ImageIcon imageIcon = new ImageIcon("C:\\Users\\Jhon\\IdeaProjects\\ChallengeAluraLatam-ConversorG5\\src\\main\\java\\org\\Jhomt\\Imagenes\\logo.png");
        Image icono = imageIcon.getImage();
        setIconImage(icono);
        setSize(500,350);
        convertirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertir();
            }
        });
        salitbtn.addActionListener(new ActionListener() {
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
            valor = Double.parseDouble(txtIngreso.getText());
        } catch (NumberFormatException e) {
            lblResultado.setText("Ingrese un valor numérico válido");
            return;
        }

        if (unidadOrigen.equals("Km  Kilometros")) {
            if (unidadDestino.equals("Km  Kilometros")) {
                resultado = valor;
            } else if (unidadDestino.equals("Hm  Hectometros")) {
                resultado = valor * 10;
            } else if (unidadDestino.equals("Dam Dametros")) {
                resultado = valor * 100;
            } else if (unidadDestino.equals("m  Metros")) {
                resultado = valor * 1000;
            } else if (unidadDestino.equals("Dm  Decímetros")) {
                resultado = valor * 10000;
            } else if (unidadDestino.equals("cm  Centímetros")) {
                resultado = valor * 100000;
            } else if (unidadDestino.equals("mm  Milímetros")) {
                resultado = valor * 1000000;
            }
        } else if (unidadOrigen.equals("Hm  Hectometros")) {
            if (unidadDestino.equals("Km  Kilometros")) {
                resultado = valor * 0.1;
            } else if (unidadDestino.equals("Hm  Hectometros")) {
                resultado = valor;
            } else if (unidadDestino.equals("Dam Dametros")) {
                resultado = valor * 10;
            } else if (unidadDestino.equals("m  Metros")) {
                resultado = valor * 100;
            } else if (unidadDestino.equals("Dm  Decímetros")) {
                resultado = valor * 1000;
            } else if (unidadDestino.equals("cm  Centímetros")) {
                resultado = valor * 10000;
            } else if (unidadDestino.equals("mm  Milímetros")) {
                resultado = valor * 100000;
            }
        } else if (unidadOrigen.equals("Dam")) {
            if (unidadDestino.equals("Km  Kilometros")) {
                resultado = valor * 0.01;
            } else if (unidadDestino.equals("Hm  Hectometros")) {
                resultado = valor * 0.1;
            } else if (unidadDestino.equals("Dam Dametros")) {
                resultado = valor;
            } else if (unidadDestino.equals("m  Metros")) {
                resultado = valor * 10;
            } else if (unidadDestino.equals("Dm  Decímetros")) {
                resultado = valor * 100;
            } else if (unidadDestino.equals("cm  Centímetros")) {
                resultado = valor * 1000;
            } else if (unidadDestino.equals("mm  Milímetros")) {
                resultado = valor * 10000;
            }
        } else if (unidadOrigen.equals("m  Metros")) {
            if (unidadDestino.equals("Km  Kilometros")) {
                resultado = valor * 0.001;
            } else if (unidadDestino.equals("Hm  Hectometros")) {
                resultado = valor * 0.01;
            } else if (unidadDestino.equals("Dam Dametros")) {
                resultado = valor * 0.1;
            } else if (unidadDestino.equals("m  Metros")) {
                resultado = valor;
            } else if (unidadDestino.equals("Dm  Decímetros")) {
                resultado = valor * 10;
            } else if (unidadDestino.equals("cm  Centímetros")) {
                resultado = valor * 100;
            } else if (unidadDestino.equals("mm  Milímetros")) {
                resultado = valor * 1000;
            }
        } else if (unidadOrigen.equals("Dm  Decímetros")) {
            if (unidadDestino.equals("Km  Kilometros")) {
                resultado = valor * 0.0001;
            } else if (unidadDestino.equals("Hm  Hectometros")) {
                resultado = valor * 0.001;
            } else if (unidadDestino.equals("Dam Dametros")) {
                resultado = valor * 0.01;
            } else if (unidadDestino.equals("m  Metros")) {
                resultado = valor * 0.1;
            } else if (unidadDestino.equals("Dm  Decímetros")) {
                resultado = valor;
            } else if (unidadDestino.equals("cm  Centímetros")) {
                resultado = valor * 10;
            } else if (unidadDestino.equals("mm  Milímetros")) {
                resultado = valor * 100;
            }
        } else if (unidadOrigen.equals("cm  Centímetros")) {
            if (unidadDestino.equals("Km  Kilometros")) {
                resultado = valor * 0.00001;
            } else if (unidadDestino.equals("Hm  Hectometros")) {
                resultado = valor * 0.0001;
            } else if (unidadDestino.equals("Dam Dametros")) {
                resultado = valor * 0.001;
            } else if (unidadDestino.equals("m  Metros")) {
                resultado = valor * 0.01;
            } else if (unidadDestino.equals("Dm  Decímetros")) {
                resultado = valor * 0.1;
            } else if (unidadDestino.equals("cm  Centímetros")) {
                resultado = valor;
            } else if (unidadDestino.equals("mm  Milímetros")) {
                resultado = valor * 10;
            }
        } else if (unidadOrigen.equals("mm  Milímetros")) {
            if (unidadDestino.equals("Km  Kilometros")) {
                resultado = valor * 0.000001;
            } else if (unidadDestino.equals("Hm  Hectometros")) {
                resultado = valor * 0.00001;
            } else if (unidadDestino.equals("Dam Dametros")) {
                resultado = valor * 0.0001;
            } else if (unidadDestino.equals("m  Metros")) {
                resultado = valor * 0.001;
            } else if (unidadDestino.equals("Dm  Decímetros")) {
                resultado = valor * 0.01;
            } else if (unidadDestino.equals("cm  Centímetros")) {
                resultado = valor * 0.1;
            } else if (unidadDestino.equals("mm  Milímetros")) {
                resultado = valor;
            }
        }
        lblResultado.setText(String.format("%.3f %s = %.3f %s %n", valor, unidadOrigen, resultado, unidadDestino));
    }
}
