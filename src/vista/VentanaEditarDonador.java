package vista;
import controlador.DonadorDAO;
import modelo.Donador;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.Component;
import java.io.IOException;
import java.io.InputStream;

public class VentanaEditarDonador extends JInternalFrame implements ActionListener {
    JLabel lblUsuario, lblLogoU, lblDireccion, lblCotegoria, lblEditarDonador, lblAnioGraduacion,
            lblTelefono, lblMetodoPago, lblIdDonador;
    JTextField cajaTelefono, cajaAnioGraduacion, cajaDireccion, cajaUsuario, cajaIdDonador;
    JButton btnRestablecer, btnSalir, btnEditar, btnBuscar;
    JComboBox<String> categoria;
    JComboBox<String> metodoPago;
    public VentanaEditarDonador() {
        getContentPane().setBackground(new Color(55, 92, 170));
        getContentPane().setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(565, 548);
        setVisible(true);
        setTitle("Editar Donador");
        setResizable(false);

        lblEditarDonador = new JLabel("Editar Donador");
        lblEditarDonador.setForeground(new Color(255, 255, 255));
        lblEditarDonador.setFont(new Font("Arial Black", Font.PLAIN, 30));
        lblEditarDonador.setBounds(181, 27, 266, 57);
        getContentPane().add(lblEditarDonador);

        lblLogoU = new JLabel("");
        String imagePath11="/imagenes/U_nuevo.png";
        InputStream input11 =getClass().getResourceAsStream(imagePath11);
        try {
            lblLogoU.setIcon(new ImageIcon(ImageIO.read(input11)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        lblLogoU.setBounds(20, -1, 120, 112);
        getContentPane().add(lblLogoU);

        JPanel panel = new JPanel();
        panel.setBounds(78, 168, 386, 264);
        getContentPane().add(panel);
        panel.setLayout(null);

        lblUsuario = new JLabel("Nombre:");
        lblUsuario.setFont(new Font("Arial Black", Font.PLAIN, 15));
        lblUsuario.setBounds(10, 11, 86, 18);
        panel.add(lblUsuario);

        cajaUsuario = new JTextField();
        cajaUsuario.setBounds(98, 10, 222, 24);
        panel.add(cajaUsuario);
        cajaUsuario.setColumns(10);

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

        categoria = new JComboBox();
        categoria.setModel(new DefaultComboBoxModel(new String[] {"Amigos de la Universidad", "Graduados",
                "Alumnos", "Padres", "Personal Docente", "Administradores", "Personal Administrativo", "Corporaciones"}));
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

        metodoPago = new JComboBox();
        metodoPago.setModel(new DefaultComboBoxModel(new String[] {"Cheque", "Tarjeta de crédito"}));
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
        btnRestablecer.setBounds(247, 469, 105, 23);
        getContentPane().add(btnRestablecer);
        btnRestablecer.addActionListener(this);

        btnSalir = new JButton("");
        String imagePath12="/imagenes/btn_salir.png";
        InputStream input12 =getClass().getResourceAsStream(imagePath12);
        try {
            btnSalir.setIcon(new ImageIcon(ImageIO.read(input12)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        btnSalir.setBackground(new Color(55, 92, 170));
        btnSalir.setBounds(495, 11, 32, 32);
        getContentPane().add(btnSalir);
        btnSalir.addActionListener(this);

        btnEditar = new JButton("");
        String imagePath13="/imagenes/btn_editar.png";
        InputStream input13 =getClass().getResourceAsStream(imagePath13);
        try {
            btnEditar.setIcon(new ImageIcon(ImageIO.read(input13)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        btnEditar.setBounds(186, 460, 32, 32);
        getContentPane().add(btnEditar);
        btnEditar.addActionListener(this);

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
        String imagePath14="/imagenes/btn_buscar.png";
        InputStream input14 =getClass().getResourceAsStream(imagePath14);
        try {
            btnBuscar.setIcon(new ImageIcon(ImageIO.read(input14)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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

        cajaUsuario.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char car = e.getKeyChar();
                if (Character.isLetter(car) || Character.isSpaceChar(car)) {
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

        cajaTelefono.addKeyListener(new KeyListener() {
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
        cajaAnioGraduacion.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char car = e.getKeyChar();
                if (!Character.isDigit(car) || cajaAnioGraduacion.getText().length() >= 4) {
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
    public void actionPerformed(ActionEvent e) {
        DonadorDAO dO = new DonadorDAO();
        if (e.getSource() == btnBuscar && !cajaIdDonador.getText().isEmpty()) {
            dO.setFiltro(Integer.parseInt(cajaIdDonador.getText()));
            Donador donador = dO.buscar(Integer.parseInt(cajaIdDonador.getText()));
            if(donador!=null) {
                cajaUsuario.setText(donador.getNombre());
                cajaDireccion.setText(donador.getDireccion());
                cajaTelefono.setText(donador.getTelefono());
                categoria.setSelectedItem(donador.getCategoria());
                cajaAnioGraduacion.setText(donador.getAnioGraduacion());
                metodoPago.setSelectedItem(donador.getMetodoPago());
                btnEditar.setEnabled(true);

                cajaUsuario.setEnabled(true);
                cajaDireccion.setEnabled(true);
                cajaTelefono.setEnabled(true);
                cajaAnioGraduacion.setEnabled(true);
                categoria.setEnabled(true);
                metodoPago.setEnabled(true);

            }else {
                JOptionPane.showMessageDialog(null,"No se encontro el Donador");
            }

        } else if (e.getSource() == btnRestablecer) {
            restablecer(cajaIdDonador,cajaUsuario,cajaDireccion,cajaTelefono,categoria,cajaAnioGraduacion,metodoPago);
            btnRestablecer.setEnabled(false);
        }else if (e.getSource() == btnSalir) {
            setVisible(false);
        } else if (e.getSource() == btnEditar) {
            if (validarCajasVacias()) {
                Donador donador1 = new Donador();

                donador1.setId(Integer.parseInt(cajaIdDonador.getText()));
                donador1.setNombre(cajaUsuario.getText());
                donador1.setDireccion(cajaDireccion.getText());

                String telefono = cajaTelefono.getText().isEmpty() ? null : cajaTelefono.getText();
                donador1.setTelefono(telefono);

                donador1.setCategoria(categoria.getSelectedItem().toString());
                donador1.setAnioGraduacion(cajaAnioGraduacion.getText().isEmpty() ? null : cajaAnioGraduacion.getText());
                donador1.setMetodoPago(metodoPago.getSelectedItem().toString());

                boolean bandera = dO.modificarDonador(donador1);
                if (bandera) {
                    JOptionPane.showMessageDialog(null, "Se modifico correctamente el DONADOR");
                    restablecer(cajaIdDonador, cajaUsuario, cajaDireccion, cajaTelefono, categoria, cajaAnioGraduacion, metodoPago);
                    cajaUsuario.setEditable(false);
                    cajaDireccion.setEditable(false);
                    cajaTelefono.setEditable(false);
                    cajaAnioGraduacion.setEditable(false);
                    categoria.setEnabled(false);
                    metodoPago.setEnabled(false);
                } else {
                    JOptionPane.showMessageDialog(null, "NO se modifico el Donador");
                }
                btnEditar.setEnabled(false);

            }else {
                JOptionPane.showMessageDialog(null, "NO SE PUEDE DEJAR ALGUNOS CAMPOS VACIOS");
            }
        }
    }
    public boolean validarCajasVacias() {
        if (cajaUsuario.getText().isEmpty()) {
            return false;
        } else if (cajaDireccion.getText().isEmpty()) {
            return false;
        } else if (categoria.getSelectedItem().toString().isEmpty()) {
            return false;
        } else if (metodoPago.getSelectedItem().toString().isEmpty()) {
            return false;
        }
        return true;
    }

    public void restablecer(Component...ComonentesGraficos){

        for (Component Component : ComonentesGraficos) {
            if(Component instanceof JComboBox) {
                ((JComboBox<?>)Component).setSelectedIndex(0);
            }else if(Component instanceof JTextField) {
                ((JTextField)Component).setText("");
            }else if(Component instanceof JSpinner) {
                ((JSpinner)Component).setValue(0);;
            }
        }

    }
}