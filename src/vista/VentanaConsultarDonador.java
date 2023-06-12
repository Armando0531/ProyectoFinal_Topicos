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
import vista.ResultSetTableModel;
import conexionBD.ConexionBD;

public class VentanaConsultarDonador extends JInternalFrame implements ActionListener {
    JLabel  lblConsultar, lblBusqueda , lblLogoU, lblSelecciona,lblIdDonador;
    JButton btnRestablecer, btnSalir, btnBuscar;
    JTextField cajaBusqueda, cajaIdDonador;
    JRadioButton rbIdDonador, rbBusqueda;
    JTable tabla=new JTable();
    byte seleccion=0;
    ConexionBD conexion = new ConexionBD();
    public VentanaConsultarDonador() {
        getContentPane().setBackground(new Color(55, 92, 170));
        getContentPane().setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(670, 528);
        setVisible(true);
        setTitle("Consultar Donador");
        setResizable(false);

        lblConsultar = new JLabel("Consultar Donador");
        lblConsultar.setForeground(new Color(255, 255, 255));
        lblConsultar.setFont(new Font("Arial Black", Font.PLAIN, 30));
        lblConsultar.setBounds(162, 24, 323, 57);
        getContentPane().add(lblConsultar);

        lblLogoU = new JLabel("");
        String imagePath4="/imagenes/U_nuevo.png";
        InputStream input4 =getClass().getResourceAsStream(imagePath4);
        try {
            lblLogoU.setIcon(new ImageIcon(ImageIO.read(input4)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        lblLogoU.setBounds(20, -1, 120, 112);
        getContentPane().add(lblLogoU);

        lblBusqueda = new JLabel("Búsqueda avanzada:");
        lblBusqueda.setForeground(new Color(255, 255, 255));
        lblBusqueda.setFont(new Font("Arial Black", Font.PLAIN, 15));
        lblBusqueda.setBounds(69, 181, 179, 18);
        getContentPane().add(lblBusqueda);

        cajaBusqueda = new JTextField();
        cajaBusqueda.setBounds(258, 180, 222, 24);
        getContentPane().add(cajaBusqueda);
        cajaBusqueda.setColumns(10);

        lblIdDonador = new JLabel("ID. Donador:");
        lblIdDonador.setForeground(new Color(255, 255, 255));
        lblIdDonador.setFont(new Font("Arial Black", Font.PLAIN, 15));
        lblIdDonador.setBounds(162, 121, 105, 23);
        getContentPane().add(lblIdDonador);

        cajaIdDonador = new JTextField();
        cajaIdDonador.setBounds(283, 124, 86, 20);
        getContentPane().add(cajaIdDonador);
        cajaIdDonador.setColumns(10);

        btnRestablecer = new JButton("Restablecer");
        btnRestablecer.setForeground(new Color(255, 255, 255));
        btnRestablecer.setBackground(new Color(238, 47, 36));
        btnRestablecer.setFont(new Font("Arial", Font.PLAIN, 11));
        btnRestablecer.setBounds(223, 457, 105, 23);
        getContentPane().add(btnRestablecer);
        btnRestablecer.addActionListener(this);

        btnSalir = new JButton("");
        String imagePath5="/imagenes/btn_salir.png";
        InputStream input5 =getClass().getResourceAsStream(imagePath5);
        try {
            btnSalir.setIcon(new ImageIcon(ImageIO.read(input5)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        btnSalir.setBackground(new Color(55, 92, 170));
        btnSalir.setBounds(495, 11, 32, 32);
        getContentPane().add(btnSalir);
        btnSalir.addActionListener(this);

        btnBuscar = new JButton("");
        String imagePath6="/imagenes/btn_buscar.png";
        InputStream input6 =getClass().getResourceAsStream(imagePath6);
        try {
            btnBuscar.setIcon(new ImageIcon(ImageIO.read(input6)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        btnBuscar.setBounds(437, 124, 32, 32);
        getContentPane().add(btnBuscar);
        btnBuscar.addActionListener(this);

        rbIdDonador = new JRadioButton("");
        rbIdDonador.setBounds(134, 124, 21, 23);
        getContentPane().add(rbIdDonador);

        rbBusqueda = new JRadioButton("");
        rbBusqueda.setBounds(31,180,21,23);
        getContentPane().add(rbBusqueda);

        rbIdDonador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cajaIdDonador.setEnabled(true);
                cajaBusqueda.setEnabled(false);
                cajaBusqueda.setText("");
            }
        });

        rbBusqueda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cajaIdDonador.setEnabled(false);
                cajaBusqueda.setEnabled(true);
                cajaIdDonador.setText("");
            }
        });

        lblSelecciona = new JLabel("Selecciona criterio de busqueda:");
        lblSelecciona.setForeground(new Color(255, 255, 255));
        lblSelecciona.setFont(new Font("Arial Black", Font.PLAIN, 15));
        lblSelecciona.setBounds(172, 76, 287, 31);
        getContentPane().add(lblSelecciona);

        cajaIdDonador.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char car = e.getKeyChar();
                if(Character.isDigit(car)){
                }else{
                    e.consume();
                }
            }
            @Override public void keyPressed(KeyEvent e) {}
            @Override public void keyReleased(KeyEvent e) {}
        });

        actualizarTabla();
        JScrollPane scroll=new JScrollPane(tabla);
        scroll.setBounds(25, 233, 600, 198);add(scroll);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSalir) {
            setVisible(false);
        } else if (e.getSource() == btnBuscar) {
            ResultSetTableModel modeloDatos = null;

            if (cajaBusqueda.isEnabled()) {
                seleccion = 2;
                actualizarTabla();
            } else if (cajaIdDonador.isEnabled()) {
                seleccion = 1;
                actualizarTabla();
            }
            if (modeloDatos != null) {
                tabla.setModel(modeloDatos);
            }
        } else if (e.getSource()== btnRestablecer) {
            actualizarTabla();
            restablecer(cajaBusqueda,cajaIdDonador);
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
        String consulta = "SELECT * FROM Donador";

        ResultSetTableModel modeloDatos=null;

        if(seleccion==1) {
            int id= 0;
            if(cajaIdDonador.getText()!="") {
                id=Integer.parseInt(cajaIdDonador.getText());
            }
            consulta = "SELECT * FROM Donador WHERE ID = " + id;
        }else if (seleccion == 2) {
            String donador = cajaBusqueda.getText();
            if (cajaBusqueda.getText()!=""){
                consulta = "SELECT * FROM Donador WHERE Nombre LIKE '%" + donador + "%' OR Direccion LIKE '%" + donador + "%'" +
                        " OR Telefono LIKE '%" + donador + "%' OR Categoria LIKE '%" + donador + "%'" +
                        " OR AnioGraduacion LIKE '%" + donador + "%' OR MetodoPago LIKE '%" + donador + "%';";

            }
        }
        try {
            modeloDatos = new ResultSetTableModel(controlador, url, consulta);
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        tabla.setModel(modeloDatos);

    }
}
