package org.Jhomt.Formularios;

import org.Jhomt.Utils.EventosClicBotones;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Historial extends JFrame {
    private static final String archivo = "C:\\Users\\Jhon\\IdeaProjects\\ChallengeAluraLatam-ConversorG5\\src\\main\\resources\\Historial.csv";
    private DefaultTableModel modelo;
    private static Historial instancia;
    private JButton principalbtn, divisasbtn, longitodesbtn, temperaturasbtn, salirbtn;
    public Historial() {
        setTitle("Challenge Alura Latam");
        ImageIcon imageIcon = new ImageIcon("C:\\Users\\Jhon\\IdeaProjects\\ChallengeAluraLatam-ConversorG5\\src\\main\\java\\org\\Jhomt\\Imagenes\\logo.png");
        Image icono = imageIcon.getImage();
        setIconImage(icono);
        setSize(1000,850);
        Color colorFondo= new Color(8,16,46);
        getContentPane().setBackground(new Color(8,16,46));

        // Crear el modelo de la tabla
        modelo = new DefaultTableModel();
        modelo.addColumn("Tipo Convertidor");
        modelo.addColumn("Numero");
        modelo.addColumn("Tipo");
        modelo.addColumn("Equivalencia");
        modelo.addColumn("Tipo");
        leerHistorialCSV();
        JTable tabla = new JTable(modelo);
        // Configurar el layout del panel principal
        setLayout(new GridBagLayout());

        JScrollPane scrollPane = new JScrollPane(tabla);
        scrollPane.setBackground(new Color(8,16,46));
        // Configurar el layout del panel
        setLayout(new BorderLayout());
        // Establecer ancho específico a las columnas
        int anchoTabla = 1000; // Ancho deseado de la tabla en píxeles
        int alturaTabla = 450; // Mantener la altura actual de la tabla
        Dimension dimension = new Dimension(anchoTabla, alturaTabla);
        tabla.setPreferredScrollableViewportSize(dimension);

        // Agregar el JScrollPane al panel en la región central
        add(scrollPane, BorderLayout.CENTER);

        // Crear un panel para los botones y establecer su color de fondo
        JPanel panelBotones = new JPanel();
        panelBotones.setBackground(new Color(8, 16, 46));

        // Configurar el layout del panel de botones
        panelBotones.setLayout(new FlowLayout());

        // Crear y agregar los botones al panel de botones
        Color colorPanel= new Color(8,16,46);
        Color colorbotones= new Color(18,23,46);


        principalbtn = new JButton("Principal");
            principalbtn.setBackground(colorbotones);
            principalbtn.setForeground(Color.white);
        divisasbtn = new JButton("Divisas");
        divisasbtn.setBackground(colorbotones);
        divisasbtn.setForeground(Color.white);
        longitodesbtn = new JButton("Longitudes");
        longitodesbtn.setBackground(colorbotones);
        longitodesbtn.setForeground(Color.white);
        temperaturasbtn = new JButton("Temperaturas");
        temperaturasbtn.setBackground(colorbotones);
        temperaturasbtn.setForeground(Color.white);
        salirbtn = new JButton("Salir");
        salirbtn.setBackground(Color.black);
        salirbtn.setForeground(Color.white);

        panelBotones.add(principalbtn);
        panelBotones.add(divisasbtn);
        panelBotones.add(longitodesbtn);
        panelBotones.add(temperaturasbtn);
        panelBotones.add(salirbtn);


        // Agregar el panel de botones al panel en la región sur
        add(panelBotones, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        // Agregar un título al panel principal
        TitledBorder titledBorder = BorderFactory.createTitledBorder("Historial de Conversiones");
        titledBorder.setTitleJustification(TitledBorder.CENTER);
        titledBorder.setTitleColor(Color.WHITE);
        scrollPane.setBorder(titledBorder);

        // metodos a los botones
        salirbtn.addActionListener(e -> System.exit(0));
        divisasbtn.addActionListener(e -> EventosClicBotones.mostrarVentanaDivisas());
        temperaturasbtn.addActionListener(e -> EventosClicBotones.mostrarVentanaTemperatura());
        longitodesbtn.addActionListener(e -> EventosClicBotones.mostrarVentanaLongitudes());
        principalbtn.addActionListener(e -> EventosClicBotones.mostrarVentanaPrincipal());
    }
    public static Historial obtenerInstancia() {
        if (instancia == null) {
            instancia = new Historial();
        }
        return instancia;
    }

    private void leerHistorialCSV() {
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");

                if (partes.length == 5) {
                    String nombreConvertidor = partes[0].trim();
                    double entrada = Double.parseDouble(partes[1].trim());
                    String de = partes[2].trim();
                    double salida = Double.parseDouble(partes[3].trim());
                    String a = partes[4].trim();

                    modelo.addRow(new Object[]{nombreConvertidor, entrada, de, salida, a});
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void registrarConversion(String nombreConvertidor, String de, String a, double entrada, double salida) {
        // Formatear los valores de entrada y salida
        String entradaFormateada = String.format("%.2f", entrada);
        String salidaFormateada = String.format("%.2f", salida);

        // Agregar una nueva fila al modelo de la tabla
        modelo.addRow(new Object[]{nombreConvertidor, entradaFormateada,de, salidaFormateada, a});

        // Registrar los datos en el archivo CSV
        String registro = String.format("%s,%.2f,%s,%.2f,%s\n", nombreConvertidor, entrada, de, salida, a);
        try (FileWriter writer = new FileWriter(archivo, true)) {
            writer.write(registro);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
