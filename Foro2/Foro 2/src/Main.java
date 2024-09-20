import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Main {
    // Listas para almacenar los diferentes tipos de equipos
    private static ArrayList<Desktop> desktops = new ArrayList<>();
    private static ArrayList<Laptop> laptops = new ArrayList<>();
    private static ArrayList<Tablet> tablets = new ArrayList<>();

    // Modelos de las tablas para cada tipo de equipo
    private static DefaultTableModel desktopTableModel;
    private static DefaultTableModel laptopTableModel;
    private static DefaultTableModel tabletTableModel;

    public static void main(String[] args) {
        // Ejecutar la interfaz gráfica en el hilo de eventos de Swing
        SwingUtilities.invokeLater(Main::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        // Crear la ventana principal
        JFrame frame = new JFrame("Registro de Equipos---TODOPC");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());

        // Crear las tablas para cada tipo de equipo
        desktopTableModel = new DefaultTableModel(new String[]{"Fabricante", "Modelo", "Microprocesador", "Memoria", "Tarjeta Gráfica", "Tamaño Torre", "Capacidad Disco Duro"}, 0);
        JTable desktopTable = new JTable(desktopTableModel);

        laptopTableModel = new DefaultTableModel(new String[]{"Fabricante", "Modelo", "Microprocesador", "Memoria", "Tamaño Pantalla", "Capacidad Disco Duro"}, 0);
        JTable laptopTable = new JTable(laptopTableModel);

        tabletTableModel = new DefaultTableModel(new String[]{"Fabricante", "Modelo", "Microprocesador", "Tamaño Diagonal Pantalla", "Tipo Pantalla", "Memoria NAND", "Sistema Operativo"}, 0);
        JTable tabletTable = new JTable(tabletTableModel);

        // Crear el JTabbedPane para mostrar las diferentes tablas
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Desktops", new JScrollPane(desktopTable));
        tabbedPane.addTab("Laptops", new JScrollPane(laptopTable));
        tabbedPane.addTab("Tablets", new JScrollPane(tabletTable));

        frame.add(tabbedPane, BorderLayout.CENTER);

        // Crear el panel de botones
        JPanel buttonPanel = new JPanel();
        JButton btnRegisterDesktop = new JButton("Registrar Desktop");
        JButton btnRegisterLaptop = new JButton("Registrar Laptop");
        JButton btnRegisterTablet = new JButton("Registrar Tablet");
        JButton btnExit = new JButton("Salir");

        // Añadir botones al panel
        buttonPanel.add(btnRegisterDesktop);
        buttonPanel.add(btnRegisterLaptop);
        buttonPanel.add(btnRegisterTablet);
        buttonPanel.add(btnExit);

        frame.add(buttonPanel, BorderLayout.SOUTH);

        // Acción para registrar Desktop
        btnRegisterDesktop.addActionListener(e -> registerDesktop());

        // Acción para registrar Laptop
        btnRegisterLaptop.addActionListener(e -> registerLaptop());

        // Acción para registrar Tablet
        btnRegisterTablet.addActionListener(e -> registerTablet());

        // Acción para salir
        btnExit.addActionListener(e -> System.exit(0));

        // Establecer el enfoque en el primer campo al abrir la ventana
        frame.setVisible(true);
    }

    private static void registerDesktop() {
        while (true) {
            // Crear los campos de entrada
            JTextField fabricanteField = new JTextField();
            JTextField modeloField = new JTextField();
            JTextField microprocesadorField = new JTextField();
            JTextField memoriaField = new JTextField();
            JTextField tarjetaGraficaField = new JTextField();
            JTextField tamañoTorreField = new JTextField();
            JTextField capacidadDiscoDuroField = new JTextField();

            // Agrupar los campos en un JOptionPane
            Object[] fields = {
                    "Fabricante:", fabricanteField,
                    "Modelo:", modeloField,
                    "Microprocesador:", microprocesadorField,
                    "Memoria:", memoriaField,
                    "Tarjeta Gráfica:", tarjetaGraficaField,
                    "Tamaño Torre:", tamañoTorreField,
                    "Capacidad Disco Duro:", capacidadDiscoDuroField
            };

            // Crear el JOptionPane
            int option = JOptionPane.showConfirmDialog(null, fields, "Registrar Desktop", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

            // Si el usuario cancela, salir del bucle
            if (option == JOptionPane.CANCEL_OPTION) {
                return;
            }

            // Validar la entrada de datos
            if (validateFields(fabricanteField, modeloField, microprocesadorField, memoriaField, tarjetaGraficaField, tamañoTorreField, capacidadDiscoDuroField)) {
                // Crear un nuevo objeto Desktop y añadirlo a la lista y la tabla
                Desktop desktop = new Desktop(
                        fabricanteField.getText(),
                        modeloField.getText(),
                        microprocesadorField.getText(),
                        memoriaField.getText(),
                        tarjetaGraficaField.getText(),
                        tamañoTorreField.getText(),
                        capacidadDiscoDuroField.getText()
                );
                desktops.add(desktop);
                desktopTableModel.addRow(desktop.getDatos());
                break; // Salir del bucle si el registro es exitoso
            }
        }
    }

    private static void registerLaptop() {
        while (true) {
            JTextField fabricanteField = new JTextField();
            JTextField modeloField = new JTextField();
            JTextField microprocesadorField = new JTextField();
            JTextField memoriaField = new JTextField();
            JTextField tamañoPantallaField = new JTextField();
            JTextField capacidadDiscoDuroField = new JTextField();

            Object[] fields = {
                    "Fabricante:", fabricanteField,
                    "Modelo:", modeloField,
                    "Microprocesador:", microprocesadorField,
                    "Memoria:", memoriaField,
                    "Tamaño Pantalla:", tamañoPantallaField,
                    "Capacidad Disco Duro:", capacidadDiscoDuroField
            };

            int option = JOptionPane.showConfirmDialog(null, fields, "Registrar Laptop", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

            if (option == JOptionPane.CANCEL_OPTION) {
                return;
            }

            if (validateFields(fabricanteField, modeloField, microprocesadorField, memoriaField, tamañoPantallaField, capacidadDiscoDuroField)) {
                Laptop laptop = new Laptop(
                        fabricanteField.getText(),
                        modeloField.getText(),
                        microprocesadorField.getText(),
                        memoriaField.getText(),
                        tamañoPantallaField.getText(),
                        capacidadDiscoDuroField.getText()
                );
                laptops.add(laptop);
                laptopTableModel.addRow(laptop.getDatos());
                break;
            }
        }
    }

    private static void registerTablet() {
        while (true) {
            JTextField fabricanteField = new JTextField();
            JTextField modeloField = new JTextField();
            JTextField microprocesadorField = new JTextField();
            JTextField tamañoDiagonalField = new JTextField();
            JTextField tipoPantallaField = new JTextField();
            JTextField memoriaNANDField = new JTextField();
            JTextField sistemaOperativoField = new JTextField();

            Object[] fields = {
                    "Fabricante:", fabricanteField,
                    "Modelo:", modeloField,
                    "Microprocesador:", microprocesadorField,
                    "Tamaño Diagonal Pantalla:", tamañoDiagonalField,
                    "Tipo Pantalla (Capacitiva/Resistiva):", tipoPantallaField,
                    "Memoria NAND:", memoriaNANDField,
                    "Sistema Operativo:", sistemaOperativoField
            };

            int option = JOptionPane.showConfirmDialog(null, fields, "Registrar Tablet", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

            if (option == JOptionPane.CANCEL_OPTION) {
                return;
            }

            if (validateFields(fabricanteField, modeloField, microprocesadorField, tamañoDiagonalField, tipoPantallaField, memoriaNANDField, sistemaOperativoField)) {
                Tablet tablet = new Tablet(
                        fabricanteField.getText(),
                        modeloField.getText(),
                        microprocesadorField.getText(),
                        tamañoDiagonalField.getText(),
                        tipoPantallaField.getText(),
                        memoriaNANDField.getText(),
                        sistemaOperativoField.getText()
                );
                tablets.add(tablet);
                tabletTableModel.addRow(tablet.getDatos());
                break;
            }
        }
    }

    private static boolean validateFields(JTextField... fields) {
        for (JTextField field : fields) {
            if (field.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
                field.requestFocus(); // Establecer el enfoque en el campo vacío
                return false;
            }
        }
        return true;
    }
}
