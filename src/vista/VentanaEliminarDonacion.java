package vista;
import controlador.DonacionDAO;
import modelo.Donacion;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.io.InputStream;

public class VentanaEliminarDonacion extends JInternalFrame implements ActionListener {
    JLabel lblLogoU,lblIdDonativo,lblIdDonante, lblIdEvento,lblFecha,lblCantidadEnviada,lblCantidadGarantizada,lblNumTarjeta,lblNomCorporacion,lblNomConyuge,lblDireccionCorp,lblNumeroPagos,lblEliminarDonativo;
    JTextField cajaNumPagos,cajaIdDonativo,cajaDonante,cajaFecha,cajaEvento,cajaCantidadEnviada,cajaCantidadGarantizada,cajaNumTarjeta,cajaNomCorporacion,cajaNomConyuge,cajaDireccionCorp;
    JButton btnRestablecer,btnEliminar,btnSalir,btnBuscar;
    public static byte bandera=0;
    public VentanaEliminarDonacion() {
        getContentPane().setBackground(new Color(55, 92, 170));
        getContentPane().setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(645, 646);
        setVisible(true);
        setTitle("Eliminar Donacion");
        setResizable(false);

        lblEliminarDonativo = new JLabel("Eliminar Donavito");
        lblEliminarDonativo.setForeground(new Color(255, 255, 255));
        lblEliminarDonativo.setFont(new Font("Arial Black", Font.PLAIN, 30));
        lblEliminarDonativo.setBounds(162, 31, 311, 57);
        getContentPane().add(lblEliminarDonativo);

        lblLogoU = new JLabel("");
        String imagePath14="/imagenes/U_nuevo.png";
        InputStream input14 =getClass().getResourceAsStream(imagePath14);
        try {
            lblLogoU.setIcon(new ImageIcon(ImageIO.read(input14)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        lblLogoU.setBounds(10, 11, 120, 112);
        getContentPane().add(lblLogoU);

        JPanel panel = new JPanel();
        panel.setBounds(75, 165, 481, 368);
        getContentPane().add(panel);
        panel.setLayout(null);

        lblIdDonante = new JLabel("ID. Donante:");
        lblIdDonante.setFont(new Font("Arial Black", Font.PLAIN, 15));
        lblIdDonante.setBounds(10, 11, 114, 18);
        panel.add(lblIdDonante);

        cajaDonante = new JTextField();
        cajaDonante.setBounds(134, 10, 174, 24);
        panel.add(cajaDonante);
        cajaDonante.setColumns(10);

        lblIdEvento = new JLabel("ID. Evento:");
        lblIdEvento.setFont(new Font("Arial Black", Font.PLAIN, 15));
        lblIdEvento.setBounds(10, 45, 114, 24);
        panel.add(lblIdEvento);

        cajaEvento = new JTextField();
        cajaEvento.setBounds(134, 45, 140, 24);
        panel.add(cajaEvento);
        cajaEvento.setColumns(10);

        lblFecha = new JLabel("Fecha Garantía:");
        lblFecha.setFont(new Font("Arial Black", Font.PLAIN, 15));
        lblFecha.setBounds(10, 162, 142, 14);
        panel.add(lblFecha);

        cajaFecha = new JTextField();
        cajaFecha.setBounds(161, 159, 113, 24);
        panel.add(cajaFecha);
        cajaFecha.setColumns(10);

        lblCantidadEnviada = new JLabel("Cantidad Enviada:");
        lblCantidadEnviada.setFont(new Font("Arial Black", Font.PLAIN, 15));
        lblCantidadEnviada.setBounds(10, 131, 165, 14);
        panel.add(lblCantidadEnviada);

        cajaCantidadEnviada = new JTextField();
        cajaCantidadEnviada.setBounds(185, 128, 142, 24);
        panel.add(cajaCantidadEnviada);
        cajaCantidadEnviada.setColumns(10);

        lblCantidadGarantizada = new JLabel("Cantidad Garantizada:");
        lblCantidadGarantizada.setFont(new Font("Arial Black", Font.PLAIN, 15));
        lblCantidadGarantizada.setBounds(10, 91, 198, 14);
        panel.add(lblCantidadGarantizada);

        cajaCantidadGarantizada = new JTextField();
        cajaCantidadGarantizada.setBounds(207, 88, 155, 24);
        panel.add(cajaCantidadGarantizada);
        cajaCantidadGarantizada.setColumns(10);

        cajaNumTarjeta = new JTextField();
        cajaNumTarjeta.setBounds(279, 221, 192, 24);
        panel.add(cajaNumTarjeta);
        cajaNumTarjeta.setColumns(10);

        lblNumTarjeta = new JLabel("Numeros de tarjeta de crédito:");
        lblNumTarjeta.setFont(new Font("Arial Black", Font.PLAIN, 15));
        lblNumTarjeta.setBounds(10, 221, 259, 27);
        panel.add(lblNumTarjeta);

        lblNomCorporacion = new JLabel("Corporación emisora:");
        lblNomCorporacion.setFont(new Font("Arial Black", Font.PLAIN, 15));
        lblNomCorporacion.setBounds(10, 259, 192, 14);
        panel.add(lblNomCorporacion);

        cajaNomCorporacion = new JTextField();
        cajaNomCorporacion.setBounds(207, 258, 174, 24);
        panel.add(cajaNomCorporacion);
        cajaNomCorporacion.setColumns(10);

        lblNomConyuge = new JLabel("Nombre del Cónyuge:");
        lblNomConyuge.setFont(new Font("Arial Black", Font.PLAIN, 15));
        lblNomConyuge.setBounds(10, 333, 176, 17);
        panel.add(lblNomConyuge);

        cajaNomConyuge = new JTextField();
        cajaNomConyuge.setBounds(201, 333, 212, 20);
        panel.add(cajaNomConyuge);
        cajaNomConyuge.setColumns(10);

        lblDireccionCorp = new JLabel("Dirección de la corporación:");
        lblDireccionCorp.setFont(new Font("Arial Black", Font.PLAIN, 15));
        lblDireccionCorp.setBounds(10, 295, 259, 18);
        panel.add(lblDireccionCorp);

        cajaDireccionCorp = new JTextField();
        cajaDireccionCorp.setBounds(265, 296, 206, 24);
        panel.add(cajaDireccionCorp);
        cajaDireccionCorp.setColumns(10);

        lblNumeroPagos = new JLabel("Número de pagos:");
        lblNumeroPagos.setFont(new Font("Arial Black", Font.PLAIN, 15));
        lblNumeroPagos.setBounds(10, 194, 165, 18);
        panel.add(lblNumeroPagos);

        cajaNumPagos = new JTextField();
        cajaNumPagos.setBounds(188, 195, 120, 20);
        panel.add(cajaNumPagos);
        cajaNumPagos.setColumns(10);

        btnRestablecer = new JButton("Restablecer");
        btnRestablecer.setForeground(new Color(255, 255, 255));
        btnRestablecer.setBackground(new Color(238, 47, 36));
        btnRestablecer.setFont(new Font("Arial", Font.PLAIN, 11));
        btnRestablecer.setBounds(314, 560, 105, 23);
        getContentPane().add(btnRestablecer);
        btnRestablecer.addActionListener(this);

        btnSalir = new JButton("");
        String imagePath1="/imagenes/btn_salir.png";
        InputStream input1 =getClass().getResourceAsStream(imagePath1);
        try {
            btnSalir.setIcon(new ImageIcon(ImageIO.read(input1)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        btnSalir.setBackground(new Color(55, 92, 170));
        btnSalir.setBounds(540, 11, 32, 32);
        getContentPane().add(btnSalir);
        btnSalir.addActionListener(this);

        btnEliminar = new JButton("");
        String imagePath2="/imagenes/btn_Eliminar_Dona.png";
        InputStream input2 =getClass().getResourceAsStream(imagePath2);
        try {
            btnEliminar.setIcon(new ImageIcon(ImageIO.read(input2)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        btnEliminar.setBounds(221, 551, 32, 32);
        getContentPane().add(btnEliminar);
        btnEliminar.addActionListener(this);

        lblIdDonativo = new JLabel("ID. Donativo:");
        lblIdDonativo.setForeground(new Color(255, 255, 255));
        lblIdDonativo.setFont(new Font("Arial Black", Font.PLAIN, 15));
        lblIdDonativo.setBounds(172, 104, 120, 28);
        getContentPane().add(lblIdDonativo);

        cajaIdDonativo = new JTextField();
        cajaIdDonativo.setBounds(302, 110, 95, 20);
        getContentPane().add(cajaIdDonativo);
        cajaIdDonativo.setColumns(10);

        btnBuscar = new JButton("");
        String imagePath3="/imagenes/btn_buscar.png";
        InputStream input3 =getClass().getResourceAsStream(imagePath3);
        try {
            btnBuscar.setIcon(new ImageIcon(ImageIO.read(input3)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        btnBuscar.setBounds(440, 99, 32, 32);
        getContentPane().add(btnBuscar);
        btnBuscar.addActionListener(this);

        cajaIdDonativo.addKeyListener(new KeyListener() {
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
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnBuscar) {
            DonacionDAO dO = new DonacionDAO();
            if(!cajaIdDonativo.getText().isEmpty()) {
                dO.setFiltro(Integer.parseInt(cajaIdDonativo.getText()));
                Thread hilo=new Thread(dO);
                hilo.start();
                Donacion donacion = dO.buscar(Integer.parseInt(cajaIdDonativo.getText()));
                if(bandera==1 || donacion!=null) {
                    bandera=0;
                    donacion = dO.buscar(Integer.parseInt(cajaIdDonativo.getText()));

                    cajaDonante.setText(String.valueOf(donacion.getDonanteId()));
                    cajaEvento.setText(String.valueOf(donacion.getEventoId()));
                    cajaCantidadGarantizada.setText(String.valueOf(donacion.getCantidadGarantizada()));
                    cajaCantidadEnviada.setText(String.valueOf(donacion.getCantidadEnviada()));
                    cajaFecha.setText(donacion.getFechaGarantia());
                    cajaNumPagos.setText(String.valueOf(donacion.getNumeroPagos()));
                    cajaNumTarjeta.setText(donacion.getTarjetaCredito());
                    cajaNomCorporacion.setText(donacion.getCorporacionEmisora());
                    cajaDireccionCorp.setText(donacion.getDireccionCorporacion());
                    cajaNomConyuge.setText(donacion.getNombreConyuge());
                    btnEliminar.setEnabled(true);

                    cajaDonante.setEnabled(false);
                    cajaEvento.setEnabled(false);
                    cajaCantidadGarantizada.setEnabled(false);
                    cajaCantidadEnviada.setEnabled(false);
                    cajaFecha.setEnabled(false);
                    cajaNumPagos.setEnabled(false);
                    cajaNumTarjeta.setEnabled(false);
                    cajaNomCorporacion.setEnabled(false);
                    cajaDireccionCorp.setEnabled(false);
                    cajaNomConyuge.setEnabled(false);
                }else {
                    JOptionPane.showMessageDialog(null,"No se encontro el Donador");
                }
            }
        } else if (e.getSource() == btnEliminar) {
            if(JOptionPane.showConfirmDialog(null, "Si eliminas una DONACION tambien se eliminaran sus referencias"
                    + " ten encuenta que esta accion no se puede revertir ¿Deseas continuar?")==0) {
                DonacionDAO dO =new DonacionDAO();
                if(dO.eliminarDonacion(cajaIdDonativo.getText())) {
                    boolean bandera=dO.eliminarDonacion(cajaIdDonativo.getText());
                    if(bandera) {
                        JOptionPane.showMessageDialog(null,"Se elimino el registro correctamente");
                        restablecer(cajaIdDonativo,cajaDonante, cajaEvento, cajaCantidadGarantizada, cajaCantidadEnviada, cajaFecha, cajaNumPagos, cajaNumTarjeta, cajaNomCorporacion, cajaDireccionCorp, cajaNomConyuge);
                    }else {
                        JOptionPane.showMessageDialog(null,"No se pudo eliminar");
                        restablecer(cajaDonante, cajaEvento, cajaCantidadGarantizada, cajaCantidadEnviada, cajaFecha, cajaNumPagos, cajaNumTarjeta, cajaNomCorporacion, cajaDireccionCorp, cajaNomConyuge);
                    }
                }
            }else {
                JOptionPane.showConfirmDialog(null,"Accion cancelada");
                btnEliminar.setEnabled(false);
                restablecer(cajaDonante, cajaEvento, cajaCantidadGarantizada, cajaCantidadEnviada, cajaFecha, cajaNumPagos,
                        cajaNumTarjeta, cajaNomCorporacion, cajaDireccionCorp, cajaNomConyuge);
            }

            btnEliminar.setEnabled(false);
        } else if (e.getSource() == btnRestablecer) {
            restablecer(cajaIdDonativo,cajaDonante, cajaEvento, cajaCantidadGarantizada, cajaCantidadEnviada, cajaFecha,
                    cajaNumPagos, cajaNumTarjeta, cajaNomCorporacion, cajaDireccionCorp, cajaNomConyuge);
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
