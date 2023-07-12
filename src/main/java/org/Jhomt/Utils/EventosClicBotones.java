package org.Jhomt.Utils;
import org.Jhomt.Formularios.*;

import javax.swing.*;
public class EventosClicBotones extends JFrame {
    private static JFrame ventanaActual;

    public static void mostrarVentanaDivisas() {
        if (ventanaActual != null) {
            ventanaActual.dispose();
        }
        ConvertidorMonedas formulario = new ConvertidorMonedas();
        formulario.setContentPane(formulario.panel1);
        formulario.setVisible(true);
        formulario.setLocationRelativeTo(null);
        formulario.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventanaActual = formulario;
    }

    public static void mostrarVentanaLongitudes() {
        if (ventanaActual != null) {
            ventanaActual.dispose();
        }
        ConvertidorMedidas convertirMedidas = new ConvertidorMedidas();
        convertirMedidas.setContentPane(convertirMedidas.panel1);
        convertirMedidas.setVisible(true);
        convertirMedidas.setLocationRelativeTo(null);
        convertirMedidas.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventanaActual = convertirMedidas;
    }

    public static void mostrarVentanaTemperatura() {
        if (ventanaActual != null) {
            ventanaActual.dispose();
        }
        ConvertidorTemperatura convertidorTemperatura = new ConvertidorTemperatura();
        convertidorTemperatura.setContentPane(convertidorTemperatura.panel1);
        convertidorTemperatura.setVisible(true);
        convertidorTemperatura.setLocationRelativeTo(null);
        convertidorTemperatura.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventanaActual = convertidorTemperatura;
    }

    public static void mostrarVentanaPrincipal() {
        if (ventanaActual != null) {
            ventanaActual.dispose();
        }
        FormularioPrincipal inicioConvertidores = new FormularioPrincipal();
        inicioConvertidores.setContentPane(inicioConvertidores.panel1);
        inicioConvertidores.setVisible(true);
        inicioConvertidores.setLocationRelativeTo(null);
        inicioConvertidores.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventanaActual = inicioConvertidores;
    }
    public static void mostrarVentanaHistorial(){
        if (ventanaActual != null){
            ventanaActual.dispose();
        }
        Historial historial= new Historial();
        historial.setVisible(true);
        historial.setLocationRelativeTo(null);
        historial.setDefaultCloseOperation(EXIT_ON_CLOSE);
        ventanaActual= historial;
    }
}
