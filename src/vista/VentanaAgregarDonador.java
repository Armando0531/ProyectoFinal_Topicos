package vista;

import java.awt.event.ActionListener;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import controlador.DonadorDAO;


public class VentanaAgregarDonador extends JInternalFrame implements ActionListener{

    JTextField cajaTelefono,cajaAnioGraduacion, cajaDireccion,cajaUsuario;
    JButton btnAgregar,btnSalir, btnRestablecer;
    JLabel lblTelefono, lblMetodoPago, lblAnioGraduacion, lblCotegoria, lblDireccion,lblUsuario,lblLogoU,lblNuevoUsuario;
    JComboBox<String> categoria;
    JComboBox<String> metodoPago;

    DonadorDAO dao = new DonadorDAO();

    public VentanaAgregarDonador() {
        getContentPane().setBackground(new Color(55, 92, 170));
        getContentPane().setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(511, 599);
        setVisible(true);
        setTitle("Agregar Donador");
        setResizable(false);

        lblNuevoUsuario = new JLabel("Nuevo Donador");
        lblNuevoUsuario.setForeground(new Color(255, 255, 255));
        lblNuevoUsuario.setFont(new Font("Arial Black", Font.PLAIN, 36));
        lblNuevoUsuario.setBounds(106, 0, 304, 57);
        getContentPane().add(lblNuevoUsuario);

        lblLogoU = new JLabel("");
        lblLogoU.setIcon(new ImageIcon("./imagenes/logo_2.png"));
        lblLogoU.setBounds(134, 42, 226, 213);
        getContentPane().add(lblLogoU);

        JPanel panel = new JPanel();
        panel.setBounds(63, 243, 371, 235);
        getContentPane().add(panel);
        panel.setLayout(null);

        lblUsuario = new JLabel("Nombre:");
        lblUsuario.setFont(new Font("Arial Black", Font.PLAIN, 15));
        lblUsuario.setBounds(10, 11, 86, 18);
        panel.add(lblUsuario);

        cajaUsuario = new JTextField();
        cajaUsuario.setBounds(87, 10, 222, 24);
        panel.add(cajaUsuario);
        cajaUsuario.setColumns(10);

        lblDireccion = new JLabel("Dirección:");
        lblDireccion.setFont(new Font("Arial Black", Font.PLAIN, 15));
        lblDireccion.setBounds(10, 45, 86, 24);
        panel.add(lblDireccion);

        cajaDireccion = new JTextField();
        cajaDireccion.setBounds(106, 45, 212, 24);
        panel.add(cajaDireccion);
        cajaDireccion.setColumns(10);

        lblCotegoria = new JLabel("Categoria:");
        lblCotegoria.setFont(new Font("Arial Black", Font.PLAIN, 15));
        lblCotegoria.setBounds(10, 122, 95, 18);
        panel.add(lblCotegoria);

        cajaAnioGraduacion = new JTextField();
        cajaAnioGraduacion.setBounds(189, 154, 95, 24);
        panel.add(cajaAnioGraduacion);
        cajaAnioGraduacion.setColumns(10);

        categoria = new JComboBox<>();
        categoria.setModel(new DefaultComboBoxModel<>(new String[] {"Amigos de la Universidad",
                "Graduados", "Alumnos", "Padres", "Personal Docente", "Administradores",
                "Personal Administrativo", "Corporacion"}));
        categoria.setBounds(134, 122, 170, 22);
        panel.add(categoria);

        lblAnioGraduacion = new JLabel("Año de Graduación:");
        lblAnioGraduacion.setFont(new Font("Arial Black", Font.PLAIN, 15));
        lblAnioGraduacion.setBounds(10, 157, 188, 14);
        panel.add(lblAnioGraduacion);

        lblMetodoPago = new JLabel("Método de pago:");
        lblMetodoPago.setFont(new Font("Arial Black", Font.PLAIN, 15));
        lblMetodoPago.setBounds(10, 189, 142, 24);
        panel.add(lblMetodoPago);

        metodoPago = new JComboBox<>();
        metodoPago.setModel(new DefaultComboBoxModel<>(new String[] {"Cheque", "Tarjeta de crédito"}));
        metodoPago.setBounds(166, 192, 120, 22);
        panel.add(metodoPago);

        lblTelefono = new JLabel("Teléfono:");
        lblTelefono.setFont(new Font("Arial Black", Font.PLAIN, 15));
        lblTelefono.setBounds(10, 80, 86, 24);
        panel.add(lblTelefono);

        cajaTelefono = new JTextField();
        cajaTelefono.setBounds(106, 80, 203, 24);
        panel.add(cajaTelefono);
        cajaTelefono.setColumns(10);

        btnRestablecer = new JButton("Restablecer");
        btnRestablecer.setForeground(new Color(255, 255, 255));
        btnRestablecer.setBackground(new Color(238, 47, 36));
        btnRestablecer.setFont(new Font("Arial", Font.PLAIN, 11));
        btnRestablecer.setBounds(255, 499, 105, 23);
        getContentPane().add(btnRestablecer);
        btnRestablecer.addActionListener(this);

        btnSalir = new JButton("");
        btnSalir.setBackground(new Color(55, 92, 170));
        btnSalir.setIcon(new ImageIcon("./imagenes/btn_salir.png"));
        btnSalir.setBounds(452, 11, 32, 32);
        getContentPane().add(btnSalir);
        btnSalir.addActionListener(this);

        btnAgregar = new JButton("");
        btnAgregar.setBounds(190, 499, 32, 32);
        getContentPane().add(btnAgregar);
        btnAgregar.setIcon(new ImageIcon("./imagenes/Agregar_usuario.png"));
        btnAgregar.addActionListener(this);


    }



}
