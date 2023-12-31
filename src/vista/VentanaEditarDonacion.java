package vista;


import controlador.DonacionDAO;
import modelo.Donacion;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.InputStream;


public class VentanaEditarDonacion extends JInternalFrame implements ActionListener {
    JTextField cajaDonante,cajaIdEvento,cajaFecha,cajaCantidadGarantizada,cajaCantidadEnviada,
            cajaDireccionCorp,cajaNumTarjeta,cajaNumPagos,cajaNomCorporacion,cajaNomConyuge,cajaIdDonativo;
    JButton btnRestablecer,btnSalir,btnEditar,btnBuscar;
    JLabel lblLogoU,lblIdDonante,lblIdEvento,lblFecha,lblEditarDonativo,lblCantidadEnviada,
            lblCantidadGarantizada,lblNumTarjeta,lblNomCorporacion,lblNomConyuge,lblIdDonativo,lblDireccionCorp,lblNumeroPagos;
    public VentanaEditarDonacion() {
        getContentPane().setBackground(new Color(55, 92, 170));
        getContentPane().setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(645, 646);
        setVisible(true);
        setTitle("Editar Donacion");
        setResizable(false);

        lblEditarDonativo = new JLabel("Editar Donavito");
        lblEditarDonativo.setForeground(new Color(255, 255, 255));
        lblEditarDonativo.setFont(new Font("Arial Black", Font.PLAIN, 30));
        lblEditarDonativo.setBounds(192, 32, 268, 57);
        getContentPane().add(lblEditarDonativo);

        lblLogoU = new JLabel("");
        String imagePath7="/imagenes/U_nuevo.png";
        InputStream input7 =getClass().getResourceAsStream(imagePath7);
        try {
            lblLogoU.setIcon(new ImageIcon(ImageIO.read(input7)));
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

        cajaIdEvento = new JTextField();
        cajaIdEvento.setBounds(134, 45, 140, 24);
        panel.add(cajaIdEvento);
        cajaIdEvento.setColumns(10);

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
        String imagePath8="/imagenes/btn_salir.png";
        InputStream input8 =getClass().getResourceAsStream(imagePath8);
        try {
            btnSalir.setIcon(new ImageIcon(ImageIO.read(input8)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        btnSalir.setBackground(new Color(55, 92, 170));
        btnSalir.setBounds(540, 11, 32, 32);
        getContentPane().add(btnSalir);
        btnSalir.addActionListener(this);

        btnEditar = new JButton("");
        String imagePath9="/imagenes/btn_editar.png";
        InputStream input9 =getClass().getResourceAsStream(imagePath9);
        try {
            btnEditar.setIcon(new ImageIcon(ImageIO.read(input9)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        btnEditar.setBounds(221, 551, 32, 32);
        getContentPane().add(btnEditar);
        btnEditar.addActionListener(this);

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
        String imagePath10="/imagenes/btn_buscar.png";
        InputStream input10 =getClass().getResourceAsStream(imagePath10);
        try {
            btnBuscar.setIcon(new ImageIcon(ImageIO.read(input10)));
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

        cajaNumTarjeta.addKeyListener(new KeyListener() {
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

        cajaCantidadEnviada.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char car = e.getKeyChar();
                if (!Character.isDigit(car) && car != '.' && car != KeyEvent.VK_BACK_SPACE) {
                    e.consume();
                }
            }
        });

        cajaCantidadGarantizada.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char car = e.getKeyChar();
                if (!Character.isDigit(car) && car != '.' && car != KeyEvent.VK_BACK_SPACE) {
                    e.consume();
                }
            }
        });

        cajaNomCorporacion.addKeyListener(new KeyListener() {
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

        cajaNomConyuge.addKeyListener(new KeyListener() {
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

        cajaIdEvento.addKeyListener(new KeyListener() {
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

        cajaDonante.addKeyListener(new KeyListener() {
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

        cajaNumPagos.addKeyListener(new KeyListener() {
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

        cajaFecha.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char car = e.getKeyChar();
                String text = cajaFecha.getText();

                // Permitir solo dígitos, guión y tecla de retroceso
                if (!Character.isDigit(car) && car != '-' && car != KeyEvent.VK_BACK_SPACE) {
                    e.consume();
                    return;
                }

                // Verificar longitud máxima de cada parte de la fecha
                if (text.length() >= 10 && car != KeyEvent.VK_BACK_SPACE) {
                    e.consume();
                    return;
                }

                // Verificar formato "yyyy-mm-dd"
                if (car != KeyEvent.VK_BACK_SPACE && (text.length() == 4 || text.length() == 7)) {
                    cajaFecha.setText(text + "-");
                }
            }
        });


    }

    public void actionPerformed(ActionEvent e) {
        DonacionDAO dN = new DonacionDAO();
        if (e.getSource() == btnBuscar && !cajaIdDonativo.getText().isEmpty()) {
            dN.setFiltro(Integer.parseInt(cajaIdDonativo.getText()));
            Donacion donacion = dN.buscar(Integer.parseInt(cajaIdDonativo.getText()));
            if(donacion!=null) {
                cajaDonante.setText(String.valueOf(donacion.getDonanteId()));
                cajaIdEvento.setText(String.valueOf(donacion.getEventoId()));
                cajaCantidadGarantizada.setText(String.valueOf(donacion.getCantidadGarantizada()));
                cajaCantidadEnviada.setText(String.valueOf(donacion.getCantidadEnviada()));
                cajaFecha.setText(donacion.getFechaGarantia());
                cajaNumPagos.setText(String.valueOf(donacion.getNumeroPagos()));
                cajaNumTarjeta.setText(donacion.getTarjetaCredito());
                cajaNomCorporacion.setText(donacion.getCorporacionEmisora());
                cajaDireccionCorp.setText(donacion.getDireccionCorporacion());
                cajaNomConyuge.setText(donacion.getNombreConyuge());
                btnEditar.setEnabled(true);

                cajaDonante.setEnabled(true);
                cajaIdEvento.setEnabled(true);
                cajaCantidadGarantizada.setEnabled(true);
                cajaCantidadEnviada.setEnabled(true);
                cajaFecha.setEnabled(true);
                cajaNumPagos.setEnabled(true);
                cajaNumTarjeta.setEnabled(true);
                cajaNomCorporacion.setEnabled(true);
                cajaDireccionCorp.setEnabled(true);
                cajaNomConyuge.setEnabled(true);

            }else {
                JOptionPane.showMessageDialog(null,"No se encontro el Donativo");
            }

        }else if (e.getSource() == btnRestablecer) {
            restablecer(cajaIdDonativo,cajaDonante, cajaIdEvento, cajaCantidadGarantizada, cajaCantidadEnviada,
                    cajaFecha, cajaNumPagos, cajaNumTarjeta, cajaNomCorporacion, cajaDireccionCorp, cajaNomConyuge);
            btnRestablecer.setEnabled(false);
        } else if (e.getSource() == btnSalir) {
            setVisible(false);
        } else if (e.getSource()==btnEditar) {
            if (validarCajasVacias()) {
                Donacion donacion1 = new Donacion();

                donacion1.setId(Integer.parseInt(cajaIdDonativo.getText()));
                donacion1.setDonanteId(Integer.parseInt(cajaDonante.getText()));
                donacion1.setEventoId(Integer.parseInt(cajaIdEvento.getText()));
                donacion1.setCantidadGarantizada(Double.parseDouble(cajaCantidadGarantizada.getText()));
                donacion1.setCantidadEnviada(Double.parseDouble(cajaCantidadEnviada.getText()));
                donacion1.setFechaGarantia(cajaFecha.getText());
                donacion1.setNumeroPagos(Integer.parseInt(cajaNumPagos.getText()));
                donacion1.setTarjetaCredito(cajaNumTarjeta.getText());
                donacion1.setCorporacionEmisora(cajaNomCorporacion.getText());
                donacion1.setDireccionCorporacion(cajaDireccionCorp.getText());
                donacion1.setNombreConyuge(cajaNomConyuge.getText());

                boolean bandera = dN.modificarDonadocion(donacion1);
                if (bandera) {
                    JOptionPane.showMessageDialog(null, "Se modifico correctamente la donacion");
                    restablecer(cajaIdDonativo, cajaDonante, cajaIdEvento, cajaCantidadGarantizada, cajaCantidadEnviada,
                            cajaFecha, cajaNumPagos, cajaNumTarjeta, cajaNomCorporacion, cajaDireccionCorp, cajaNomConyuge);
                    cajaDonante.setEnabled(false);
                    cajaIdEvento.setEnabled(false);
                    cajaCantidadGarantizada.setEnabled(false);
                    cajaCantidadEnviada.setEnabled(false);
                    cajaFecha.setEnabled(false);
                    cajaNumPagos.setEnabled(false);
                    cajaNumTarjeta.setEnabled(false);
                    cajaNomCorporacion.setEnabled(false);
                    cajaDireccionCorp.setEnabled(false);
                    cajaNomConyuge.setEnabled(false);

                } else {
                    JOptionPane.showMessageDialog(null, "NO se modifico La donacion");
                }
                btnEditar.setEnabled(false);
            }else {
                JOptionPane.showMessageDialog(null, "NO SE PUEDE DEJAR ALGUNOS CAMPOS VACIOS");
            }
        }
    }
    public boolean validarCajasVacias() {
        if (cajaIdEvento.getText().isEmpty()) {
            return false;
        } else if (cajaDonante.getText().isEmpty()) {
            return false;
        } else if (cajaCantidadGarantizada.getText().isEmpty()) {
            return false;
        } else if (cajaCantidadEnviada.getText().isEmpty()) {
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
            }
        }

    }

}
