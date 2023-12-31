package vista;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;



public class VentanaConsultarDonacion extends JInternalFrame implements ActionListener {
    JLabel lblLogoU,lblCriterio,lblBusqueda,lblConsultarDonativo;
    JTextField cajaBusqueda;
    JButton btnRestablecer,btnSalir,btnBuscar;
    JComboBox<String> busqueda;
    JTable tabla=new JTable();
    JScrollPane scrollTabla;

    public VentanaConsultarDonacion() {
        getContentPane().setBackground(new Color(55, 92, 170));
        getContentPane().setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(755, 646);
        setVisible(true);
        setTitle("Consultar Donacion");
        setResizable(false);

        lblConsultarDonativo = new JLabel("Consultar Donavito");
        lblConsultarDonativo.setForeground(new Color(255, 255, 255));
        lblConsultarDonativo.setFont(new Font("Arial Black", Font.PLAIN, 30));
        lblConsultarDonativo.setBounds(156, 11, 326, 57);
        getContentPane().add(lblConsultarDonativo);

        lblLogoU = new JLabel("");
        String imagePath1="/imagenes/U_nuevo.png";
        InputStream input1 =getClass().getResourceAsStream(imagePath1);
        try {
            lblLogoU.setIcon(new ImageIcon(ImageIO.read(input1)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        lblLogoU.setBounds(10, 11, 120, 112);
        getContentPane().add(lblLogoU);

        busqueda = new JComboBox<>();
        busqueda.setModel(new DefaultComboBoxModel<>(new String[] {"ID. Donativo", "ID. Donante", "ID. Evento",
                "Cantidad Garantizada", "Cantidad Enviada","Fecha", "Numero de pagos", "Tarjeta de credito",
                "Corporacion", "Direccion corporacion", "Nombre conyuge"}));
        busqueda.setBounds(198, 105, 200, 22);
        getContentPane().add(busqueda);
        busqueda.addActionListener(this);

        btnRestablecer = new JButton("Restablecer");
        btnRestablecer.setForeground(new Color(255, 255, 255));
        btnRestablecer.setBackground(new Color(238, 47, 36));
        btnRestablecer.setFont(new Font("Arial", Font.PLAIN, 11));
        btnRestablecer.setBounds(300, 443, 105, 23);
        getContentPane().add(btnRestablecer);
        btnRestablecer.addActionListener(this);

        btnSalir = new JButton("");
        String imagePath2="/imagenes/btn_salir.png";
        InputStream input2 =getClass().getResourceAsStream(imagePath2);
        try {
            btnSalir.setIcon(new ImageIcon(ImageIO.read(input2)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        btnSalir.setBackground(new Color(55, 92, 170));
        btnSalir.setBounds(690, 11, 32, 32);
        getContentPane().add(btnSalir);
        btnSalir.addActionListener(this);

        lblBusqueda = new JLabel("Ingresa criterio a buscar:");
        lblBusqueda.setForeground(new Color(255, 255, 255));
        lblBusqueda.setFont(new Font("Arial Black", Font.PLAIN, 15));
        lblBusqueda.setBounds(20, 143, 237, 28);
        getContentPane().add(lblBusqueda);

        cajaBusqueda = new JTextField();
        cajaBusqueda.setBounds(262, 147, 174, 24);
        getContentPane().add(cajaBusqueda);
        cajaBusqueda.setColumns(10);

        btnBuscar = new JButton("");
        String imagePath3="/imagenes/btn_buscar.png";
        InputStream input3 =getClass().getResourceAsStream(imagePath3);
        try {
            btnBuscar.setIcon(new ImageIcon(ImageIO.read(input3)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        btnBuscar.setBounds(450, 105, 32, 32);
        getContentPane().add(btnBuscar);
        btnBuscar.addActionListener(this);

        lblCriterio = new JLabel("Selecciona criterio de busqueda:");
        lblCriterio.setForeground(new Color(255, 255, 255));
        lblCriterio.setFont(new Font("Arial Black", Font.PLAIN, 15));
        lblCriterio.setBounds(169, 71, 303, 23);
        getContentPane().add(lblCriterio);


        actualizarTabla();
        JScrollPane scroll=new JScrollPane(tabla);
        scroll.setBounds(31, 205, 691, 196);add(scroll);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSalir) {
            setVisible(false);
        } else if (e.getSource()== btnBuscar) {
            ResultSetTableModel modeloDatos = null;

            modeloDatos = busquedaDonacion(cajaBusqueda.getText(),busqueda.getSelectedItem().toString());

            tabla.setModel(modeloDatos);

        } else if (e.getSource()== busqueda) {
            if(busqueda.getSelectedItem().toString().equals("ID. Donativo") ||busqueda.getSelectedItem().toString().equals("ID. Donante")
            || busqueda.getSelectedItem().toString().equals("ID. Evento") || busqueda.getSelectedItem().toString().equals("Numero de pagos")
            || busqueda.getSelectedItem().toString().equals("Tarjeta de credito") ){
                cajaBusqueda.addKeyListener(new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        char car = e.getKeyChar();
                        if (Character.isDigit(car)) {
                            // Permitir solo números enteros
                        } else {
                            e.consume();
                        }
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                    }
                });
            } else if (busqueda.getSelectedItem().toString().equals("Corporacion") ||
                    busqueda.getSelectedItem().toString().equals("Nombre conyuge")) {
                cajaBusqueda.addKeyListener(new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        char car = e.getKeyChar();
                        if (Character.isLetter(car)) {
                            // Permitir solo letras
                        } else {
                            e.consume();
                        }
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                    }
                });
                
            }
        }else if (e.getSource()== btnRestablecer){
            restablecer(cajaBusqueda,busqueda);
            actualizarTabla();
        }
    }

    public void restablecer(Component... ComonentesGraficos) {
        for (Component Component : ComonentesGraficos) {
            if (Component instanceof JComboBox) {
                ((JComboBox<?>) Component).setSelectedIndex(0);
            } else if (Component instanceof JTextField) {
                ((JTextField) Component).setText("");
            }
        }
    }


    public void actualizarTabla() {

        String controlador = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/Universidad";
        String consulta = "SELECT * FROM Donativo";

        ResultSetTableModel modeloDatos=null;
        try {
            modeloDatos = new ResultSetTableModel(controlador, url, consulta);
        } catch (ClassNotFoundException | SQLException e1) {
            e1.printStackTrace();
        }
        tabla.setModel(modeloDatos);

    }

    public ResultSetTableModel busquedaDonacion(String donacion, String criterio) {
        String consulta = null;
        String url = "jdbc:mysql://localhost:3306/Universidad";
        String controlador = "com.mysql.cj.jdbc.Driver";

        if (criterio.equals("ID. Donativo")) {
            Integer.parseInt(donacion);
            consulta = "SELECT * FROM Donativo WHERE ID = '" + donacion + "';";
        } else if (criterio.equals("ID. Donante")) {
            Integer.parseInt(donacion);
            consulta = "SELECT * FROM Donativo WHERE Donante_ID = '" + donacion + "';";
        } else if (criterio.equals("ID. Evento")) {
            Integer.parseInt(donacion);
            consulta = "SELECT * FROM Donativo WHERE Evento_ID  = '" + donacion + "';";
        } else if (criterio.equals("Cantidad Garantizada")) {
            Double.parseDouble(donacion);
            consulta = "SELECT * FROM Donativo WHERE CantidadGarantizada = " + donacion + ";";
        } else if (criterio.equals("Cantidad Enviada")) {
            Double.parseDouble(donacion);
            consulta = "SELECT * FROM Donativo WHERE CantidadEnviada = " + donacion + ";";
        }else if (criterio.equals("Fecha")) {
            consulta = "SELECT * FROM Donativo WHERE FechaGarantia LIKE '%" + donacion + "%';";
        } else if (criterio.equals("Numero de pagos")) {
            Integer.parseInt(donacion);
            consulta = "SELECT * FROM Donativo WHERE NumeroPagos LIKE '%" + donacion + "%';";
        } else if (criterio.equals("Tarjeta de credito")) {
            consulta = "SELECT * FROM Donativo WHERE TarjetaCredito LIKE '%" + donacion + "%';";
        } else if (criterio.equals("Corporacion")) {
            consulta = "SELECT * FROM Donativo WHERE CorporacionEmisora LIKE '%" + donacion + "%';";
        } else if (criterio.equals("Direccion corporacion")) {
            consulta = "SELECT * FROM Donativo WHERE DireccionCorporacion LIKE '%" + donacion + "%';";
        } else if (criterio.equals("Nombre conyuge")) {
            consulta = "SELECT * FROM Donativo WHERE NombreConyugue LIKE '%" + donacion + "%';";
        }

        ResultSetTableModel modeloDatos = null;
        try {
            modeloDatos = new ResultSetTableModel(controlador, url, consulta);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return modeloDatos;
    }

}
