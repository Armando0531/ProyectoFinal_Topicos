package vista;

import java.awt.event.*;
import java.awt.Component;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.io.IOException;
import java.io.InputStream;


import controlador.DonacionDAO;
import modelo.Donacion;

public class VentanaAgregarDonacion extends JInternalFrame implements ActionListener {
    JTextField cajaNumPagos,cajaIdEvento,cajaDonante,cajaFecha,cajaCantidadEnviada,cajaCantidadGarantizada,
            cajaNumTarjeta,cajaNomCorporacion,cajaNomConyuge,cajaDireccionCorp;
    JButton btnAgregar, btnSalir, btnRestablecer;
    JLabel lblNuevoDonativo,lblLogoU,lblIdDonante,lblIdEvento,lblFecha,lblCantidadEnviada,lblCantidadGarantizada,
            lblNumTarjeta,lblNomCorporacion,lblNomConyuge,lblDireccionCorp,lblNumeroPagos;

    JComboBox<String> comboAnio,comboMes, comboDia;
    JTable tabla=new JTable();
    DonacionDAO dO = new DonacionDAO();
    public VentanaAgregarDonacion() {
        getContentPane().setBackground(new Color(55, 92, 170));
        getContentPane().setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(580, 591);
        setVisible(true);
        setTitle("Agregar Donacion");
        setResizable(false);

        lblNuevoDonativo = new JLabel("Nuevo Donativo");
        lblNuevoDonativo.setForeground(new Color(255, 255, 255));
        lblNuevoDonativo.setFont(new Font("Arial Black", Font.PLAIN, 30));
        lblNuevoDonativo.setBounds(162, 31, 282, 57);
        getContentPane().add(lblNuevoDonativo);

        lblLogoU = new JLabel("");
        String imagePath3="/imagenes/U_nuevo.png";
        InputStream input3 =getClass().getResourceAsStream(imagePath3);
        try {
            lblLogoU.setIcon(new ImageIcon(ImageIO.read(input3)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        lblLogoU.setBounds(20, -1, 120, 112);
        getContentPane().add(lblLogoU);

        JPanel panel = new JPanel();
        panel.setBounds(46, 122, 481, 368);
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
        lblIdEvento.setBounds(10, 45, 114, 18);
        panel.add(lblIdEvento);

        cajaIdEvento = new JTextField();
        cajaIdEvento.setBounds(134, 45, 140, 24);
        panel.add(cajaIdEvento);
        cajaIdEvento.setColumns(10);

        lblFecha = new JLabel("Fecha Garantía:");
        lblFecha.setFont(new Font("Arial Black", Font.PLAIN, 15));
        lblFecha.setBounds(10, 162, 142, 14);
        panel.add(lblFecha);

        comboAnio = new JComboBox<String>();
        comboAnio.setBounds(161, 159, 60, 24);
        panel.add(comboAnio);

        comboMes = new JComboBox<String>();
        comboMes.setBounds(231, 159, 60, 24);
        panel.add(comboMes);

        comboDia = new JComboBox<String>();
        comboDia.setBounds(301, 159, 60, 24);
        panel.add(comboDia);

        java.util.Date fechaActual = new java.util.Date();
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.setTime(fechaActual);

        // Obtener el año actual y el próximo año
        int anioActual = calendar.get(java.util.Calendar.YEAR);
        int proximoAnio = anioActual + 1;
        comboAnio.addItem(String.valueOf(anioActual));
        comboAnio.addItem(String.valueOf(proximoAnio));

        // Llenar el ComboBox de mes con los valores del 01 al 12
        for (int mes = 1; mes <= 12; mes++) {
            String mesFormateado = String.format("%02d", mes);
            comboMes.addItem(mesFormateado);
        }

        // Llenar el ComboBox de día con los valores del 01 al 31
        for (int dia = 1; dia <= 31; dia++) {
            String diaFormateado = String.format("%02d", dia);
            comboDia.addItem(diaFormateado);
        }


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
        lblNumTarjeta.setBounds(10, 221, 259, 24);
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
        lblNomConyuge.setBounds(10, 333, 185, 17);
        panel.add(lblNomConyuge);

        cajaNomConyuge = new JTextField();
        cajaNomConyuge.setBounds(220, 333, 212, 24);
        panel.add(cajaNomConyuge);
        cajaNomConyuge.setColumns(10);

        lblDireccionCorp = new JLabel("Dirección de la corporación:");
        lblDireccionCorp.setFont(new Font("Arial Black", Font.PLAIN, 15));
        lblDireccionCorp.setBounds(10, 295, 259, 18);
        panel.add(lblDireccionCorp);

        cajaDireccionCorp = new JTextField();
        cajaDireccionCorp.setBounds(279, 296, 192, 24);
        panel.add(cajaDireccionCorp);
        cajaDireccionCorp.setColumns(10);

        lblNumeroPagos = new JLabel("Número de pagos:");
        lblNumeroPagos.setFont(new Font("Arial Black", Font.PLAIN, 15));
        lblNumeroPagos.setBounds(10, 194, 165, 18);
        panel.add(lblNumeroPagos);

        cajaNumPagos = new JTextField();
        cajaNumPagos.setBounds(188, 195, 120, 24);
        panel.add(cajaNumPagos);
        cajaNumPagos.setColumns(10);

        btnRestablecer = new JButton("Restablecer");
        btnRestablecer.setForeground(new Color(255, 255, 255));
        btnRestablecer.setBackground(new Color(238, 47, 36));
        btnRestablecer.setFont(new Font("Arial ", Font.PLAIN, 11));
        btnRestablecer.setBounds(261, 521, 105, 23);
        getContentPane().add(btnRestablecer);
        btnRestablecer.addActionListener(this);

        btnSalir = new JButton("");
        btnSalir.setBackground(new Color(55, 92, 170));
        String imagePath1="/imagenes/btn_salir.png";
        InputStream input1 =getClass().getResourceAsStream(imagePath1);
        try {
            btnSalir.setIcon(new ImageIcon(ImageIO.read(input1)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        btnSalir.setBounds(495, 11, 32, 32);
        getContentPane().add(btnSalir);
        btnSalir.addActionListener(this);

        btnAgregar = new JButton("");
        btnAgregar.setBounds(195, 512, 32, 32);
        String imagePath2="/imagenes/Agregar_usuario.png";
        InputStream input2 =getClass().getResourceAsStream(imagePath2);
        try {
            btnAgregar.setIcon(new ImageIcon(ImageIO.read(input2)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        getContentPane().add(btnAgregar);
        btnAgregar.addActionListener(this);

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


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSalir) {
            setVisible(false);
        } else if (e.getSource() == btnRestablecer) {
            restablecer(cajaDonante,comboDia,comboMes,comboAnio, cajaIdEvento, cajaCantidadGarantizada, cajaCantidadEnviada,
                    cajaFecha, cajaNumPagos, cajaNumTarjeta, cajaNomCorporacion, cajaDireccionCorp, cajaNomConyuge);
        } else if (e.getSource() == btnAgregar) {
            if (validarCajasVacias()) {
                String anioSeleccionado = (String) comboAnio.getSelectedItem();
                String mesSeleccionado = (String) comboMes.getSelectedItem();
                String diaSeleccionado = (String) comboDia.getSelectedItem();

                // Concatenar los valores en un formato de tipo date (YYYY-MM-DD)
                String fechaGarantia = anioSeleccionado + "-" + mesSeleccionado + "-" + diaSeleccionado;

                Donacion d = new Donacion();

                d.setDonanteId(Integer.parseInt(cajaDonante.getText()));
                d.setEventoId(Integer.parseInt(cajaIdEvento.getText()));
                d.setCantidadGarantizada(Double.parseDouble(cajaCantidadGarantizada.getText()));
                d.setCantidadEnviada(Double.parseDouble(cajaCantidadEnviada.getText()));
                d.setFechaGarantia(fechaGarantia);
                d.setNumeroPagos(Integer.parseInt(cajaNumPagos.getText()));
                d.setTarjetaCredito(cajaNumTarjeta.getText());
                d.setCorporacionEmisora(cajaNomCorporacion.getText());
                d.setDireccionCorporacion(cajaDireccionCorp.getText());
                d.setNombreConyuge(cajaNomConyuge.getText());

                System.out.println(d);
                if (dO.insertarRegistro(d)) {
                    JOptionPane.showMessageDialog(null, "Se agregó la donacion correctamente");
                    restablecer(comboAnio,comboDia,comboMes,cajaDonante, cajaIdEvento, cajaCantidadGarantizada,
                            cajaCantidadEnviada, cajaFecha, cajaNumPagos, cajaNumTarjeta, cajaNomCorporacion,
                            cajaDireccionCorp, cajaNomConyuge);
                } else {
                    JOptionPane.showMessageDialog(null, "NO SE AGREGÓ LA DONACIÓN");
                }

            }else {
                JOptionPane.showMessageDialog(null, "Debes de llenar los datos nesesarios!");
            }

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


}