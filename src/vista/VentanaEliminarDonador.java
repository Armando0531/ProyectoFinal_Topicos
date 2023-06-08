package vista;
import modelo.Donador;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import java.awt.Component;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

import controlador.DonadorDAO;

public class VentanaEliminarDonador extends JInternalFrame implements ActionListener{

    JTextField cajaIdDonador,cajaNombre,cajaDireccion,cajaTelefono,cajaAnioGraduacion;
    JLabel lblEliminarUsuario,lblLogoU,lblUsuario,lblDireccion,lblCotegoria,lblAnioGraduacion,lblMetodoPago,lblTelefono,lblIdDonador;
    JButton btnRestablecer,btnSalir,btnEliminar,btnBuscar;
    JComboBox<String> categoria;
    JComboBox<String> metodoPago;
    public static byte bandera=0;
    public VentanaEliminarDonador() {
        getContentPane().setBackground(new Color(55, 92, 170));
        getContentPane().setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(564, 520);
        setVisible(true);
        setTitle("Eliminar Donador");
        setResizable(false);

        lblEliminarUsuario = new JLabel("Eliminar Donador");
        lblEliminarUsuario.setForeground(new Color(255, 255, 255));
        lblEliminarUsuario.setFont(new Font("Arial Black", Font.PLAIN, 30));
        lblEliminarUsuario.setBounds(162, 31, 299, 57);
        getContentPane().add(lblEliminarUsuario);

        lblLogoU = new JLabel("");
        lblLogoU.setIcon(new ImageIcon("./imagenes/U_nuevo.png"));
        lblLogoU.setBounds(20, -1, 120, 112);
        getContentPane().add(lblLogoU);

        JPanel panel = new JPanel();
        panel.setBounds(78, 168, 386, 250);
        getContentPane().add(panel);
        panel.setLayout(null);

        lblUsuario = new JLabel("Nombre:");
        lblUsuario.setFont(new Font("Arial Black", Font.PLAIN, 15));
        lblUsuario.setBounds(10, 11, 86, 18);
        panel.add(lblUsuario);

        cajaNombre = new JTextField();
        cajaNombre.setBounds(98, 10, 222, 24);
        panel.add(cajaNombre);
        cajaNombre.setColumns(10);

        lblDireccion = new JLabel("Dirección:");
        lblDireccion.setFont(new Font("Arial Black", Font.PLAIN, 15));
        lblDireccion.setBounds(10, 45, 86, 24);
        panel.add(lblDireccion);

        cajaDireccion = new JTextField();
        cajaDireccion.setBounds(108, 45, 212, 24);
        panel.add(cajaDireccion);
        cajaDireccion.setColumns(10);

        lblCotegoria = new JLabel("Categoria:");
        lblCotegoria.setFont(new Font("Arial Black", Font.PLAIN, 15));
        lblCotegoria.setBounds(10, 124, 95, 18);
        panel.add(lblCotegoria);

        cajaAnioGraduacion = new JTextField();
        cajaAnioGraduacion.setBounds(192, 164, 95, 24);
        panel.add(cajaAnioGraduacion);
        cajaAnioGraduacion.setColumns(10);

        categoria = new JComboBox<>();
        categoria.setModel(new DefaultComboBoxModel<>(new String[] {"Amigos de la Universidad", "Graduados", "Alumnos", "Padres", "Personal Docente", "Administradores", "Personal Administrativo", "Corporaciones"}));
        categoria.setBounds(124, 124, 150, 22);
        panel.add(categoria);

        lblAnioGraduacion = new JLabel("Año de Graduación:");
        lblAnioGraduacion.setFont(new Font("Arial Black", Font.PLAIN, 15));
        lblAnioGraduacion.setBounds(10, 167, 188, 14);
        panel.add(lblAnioGraduacion);

        lblMetodoPago = new JLabel("Método de pago:");
        lblMetodoPago.setFont(new Font("Arial Black", Font.PLAIN, 15));
        lblMetodoPago.setBounds(10, 206, 142, 24);
        panel.add(lblMetodoPago);

        metodoPago = new JComboBox<>();
        metodoPago.setModel(new DefaultComboBoxModel<>(new String[] {"Cheque", "Tarjeta de crédito"}));
        metodoPago.setBounds(171, 209, 103, 22);
        panel.add(metodoPago);

        lblTelefono = new JLabel("Teléfono:");
        lblTelefono.setFont(new Font("Arial Black", Font.PLAIN, 15));
        lblTelefono.setBounds(10, 90, 95, 17);
        panel.add(lblTelefono);

        cajaTelefono = new JTextField();
        cajaTelefono.setBounds(118, 83, 212, 24);
        panel.add(cajaTelefono);
        cajaTelefono.setColumns(10);

        btnRestablecer = new JButton("Restablecer");
        btnRestablecer.setForeground(new Color(255, 255, 255));
        btnRestablecer.setBackground(new Color(238, 47, 36));
        btnRestablecer.setFont(new Font("Arial", Font.PLAIN, 11));
        btnRestablecer.setBounds(247, 452, 105, 23);
        getContentPane().add(btnRestablecer);
        btnRestablecer.addActionListener(this);

        btnSalir = new JButton("");
        btnSalir.setBackground(new Color(55, 92, 170));
        btnSalir.setIcon(new ImageIcon("./imagenes/btn_salir.png"));
        btnSalir.setBounds(495, 11, 32, 32);
        getContentPane().add(btnSalir);
        btnSalir.addActionListener(this);


        btnEliminar = new JButton("");
        btnEliminar.setIcon(new ImageIcon("./imagenes/btn_eliminar_usu.png"));
        btnEliminar.setBounds(190, 442, 32, 32);
        getContentPane().add(btnEliminar);
        btnEliminar.addActionListener(this);

        lblIdDonador = new JLabel("ID. Donador:");
        lblIdDonador.setForeground(new Color(255, 255, 255));
        lblIdDonador.setFont(new Font("Arial Black", Font.PLAIN, 15));
        lblIdDonador.setBounds(153, 110, 105, 23);
        getContentPane().add(lblIdDonador);

        cajaIdDonador = new JTextField();
        cajaIdDonador.setBounds(266, 113, 86, 20);
        getContentPane().add(cajaIdDonador);
        cajaIdDonador.setColumns(10);

        btnBuscar = new JButton("");
        btnBuscar.setIcon(new ImageIcon("./imagenes/btn_buscar.png"));
        btnBuscar.setBounds(389, 101, 32, 32);
        getContentPane().add(btnBuscar);
        btnBuscar.addActionListener(this);

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


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnBuscar) {
            DonadorDAO dO = new DonadorDAO();
            if(!cajaIdDonador.getText().isEmpty()) {
                dO.setFiltro(Integer.parseInt(cajaIdDonador.getText()));
                Thread hilo=new Thread(dO);
                hilo.start();
                Donador donador = dO.buscar(Integer.parseInt(cajaIdDonador.getText()));
                if(bandera==1 || donador!=null) {
                    bandera=0;
                    donador = dO.buscar(Integer.parseInt(cajaIdDonador.getText()));
                    cajaNombre.setText(donador.getNombre());
                    cajaDireccion.setText(donador.getDireccion());
                    cajaTelefono.setText(donador.getTelefono());
                    categoria.setSelectedItem(donador.getCategoria());
                    cajaAnioGraduacion.setText(String.valueOf(donador.getAnioGraduacion()));
                    metodoPago.setSelectedItem(donador.getMetodoPago());
                    btnEliminar.setEnabled(true);
                    cajaNombre.setEditable(false);
                    cajaDireccion.setEditable(false);
                    cajaTelefono.setEditable(false);
                    cajaAnioGraduacion.setEditable(false);
                    categoria.setEnabled(false);
                    metodoPago.setEnabled(false);
                }else {
                    JOptionPane.showMessageDialog(null,"No se encontro el Donador");
                }
            }
        } else if (e.getSource() == btnEliminar) {
            if(JOptionPane.showConfirmDialog(null, "Si eliminas un donador tambien se eliminaran sus referencias"
                    + " ten encuenta que esta accion no se puede revertir ¿Deseas continuar?")==0) {
                DonadorDAO dO =new DonadorDAO();
                if(dO.eliminarDonador(cajaIdDonador.getText())) {
                    boolean bandera=dO.eliminarDonador(cajaIdDonador.getText());
                    if(bandera) {
                        JOptionPane.showMessageDialog(null,"Se elimino el registro correctamente");
                        restablecer(cajaIdDonador,cajaNombre,cajaDireccion,cajaTelefono,categoria,cajaAnioGraduacion,metodoPago);
                    }else {
                        JOptionPane.showMessageDialog(null,"No se pudo eliminar");
                        restablecer(cajaIdDonador,cajaNombre,cajaDireccion,cajaTelefono,categoria,cajaAnioGraduacion,metodoPago);
                    }
                }
            }else {
                JOptionPane.showConfirmDialog(null,"Accion cancelada");
                btnEliminar.setEnabled(false);
                restablecer(cajaIdDonador,cajaNombre,cajaDireccion,cajaTelefono,categoria,cajaAnioGraduacion,metodoPago);
            }

            btnEliminar.setEnabled(false);
        } else if (e.getSource() == btnRestablecer) {
            restablecer(cajaIdDonador,cajaNombre,cajaDireccion,cajaTelefono,categoria,cajaAnioGraduacion,metodoPago);
        } else if (e.getSource() == btnSalir) {
            setVisible(false);
        }
    }
    public void restablecer(Component...ComonentesGraficos){

        for (Component Component : ComonentesGraficos) {
            if(Component instanceof JComboBox) {
                ((JComboBox<?>)Component).setSelectedIndex(0);
            }else if(Component instanceof JTextField) {
                ((JTextField)Component).setText("");
            }
        }
        btnEliminar.setEnabled(false);

    }

}

