package vista;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.Toolkit;


public class VentanaInicio extends JFrame implements ActionListener{


    JToolBar toolbar;
    JButton btnCerrarSesion;
    JMenuBar menuBar;
    JMenu menuDonadores, menuDonaciones;
    JMenuItem menuAgregarDonador, menuEliminarDonador, menuEditarDonador, menuConsultarDonador;
    JMenuItem menuAgregarDonacion, menuEliminarDonacion, menuEditarDonacion, menuConsultarDonacion;
    JDesktopPane dp = new JDesktopPane();
    private JInternalFrame ventanaActual;

    public VentanaInicio() {
        getContentPane().setLayout(new BorderLayout());
        setIconImage(Toolkit.getDefaultToolkit().getImage("./imagenes/u_universidad.png"));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("UNIVERSIDAD BETA");
        setVisible(true);
        setSize(900, 715);
        this.getContentPane().setBackground(new Color(0, 57, 152));
        setResizable(false);
        dp.setBackground(new Color(0, 57, 152));

        toolbar = new JToolBar();
        btnCerrarSesion = new JButton("Cerrar sesión");
        btnCerrarSesion.addActionListener(this);
        toolbar.add(btnCerrarSesion);
        add(toolbar, BorderLayout.NORTH);

        menuBar = new JMenuBar();

        menuDonadores = new JMenu("Donadores");

        menuAgregarDonador = new JMenuItem("Agregar Donador");
        menuAgregarDonador.addActionListener(this);

        menuEliminarDonador = new JMenuItem("Eliminar Donador");
        menuEliminarDonador.addActionListener(this);

        menuEditarDonador = new JMenuItem("Editar Donador");
        menuEditarDonador.addActionListener(this);

        menuConsultarDonador = new JMenuItem("Consultar Donador");
        menuConsultarDonador.addActionListener(this);

        menuDonadores.add(menuAgregarDonador);
        menuDonadores.add(menuEliminarDonador);
        menuDonadores.add(menuEditarDonador);
        menuDonadores.add(menuConsultarDonador);

        menuDonaciones = new JMenu("Donaciones");

        menuAgregarDonacion = new JMenuItem("Agregar Donacion");
        menuAgregarDonacion.addActionListener(this);

        menuEliminarDonacion = new JMenuItem("Eliminar Donacion");
        menuEliminarDonacion.addActionListener(this);

        menuEditarDonacion = new JMenuItem("Editar Donacion");
        menuEditarDonacion.addActionListener(this);

        menuConsultarDonacion = new JMenuItem("Consultar Donacion");
        menuConsultarDonacion.addActionListener(this);

        menuDonaciones.add(menuAgregarDonacion);
        menuDonaciones.add(menuEliminarDonacion);
        menuDonaciones.add(menuEditarDonacion);
        menuDonaciones.add(menuConsultarDonacion);


        menuBar.add(menuDonadores);
        menuBar.add(menuDonaciones);
        setJMenuBar(menuBar);

        setLocationRelativeTo(null);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if (ventanaActual != null) {
            ventanaActual.setVisible(false);
            dp.remove(ventanaActual);
        }

        if (e.getSource() == menuAgregarDonador) {//GUI completa --MYSQL
            VentanaAgregarDonador ventanaAltas = new VentanaAgregarDonador();
            ventanaActual = ventanaAltas;
            dp.add(ventanaAltas);
            ventanaAltas.setVisible(true);
            add(dp);
        } else if(e.getSource()==menuEliminarDonador) {
            VentanaEliminarDonador ventanaBajasDonador =new VentanaEliminarDonador();
            ventanaActual = ventanaBajasDonador;
            dp.add(ventanaBajasDonador);
            ventanaBajasDonador.setVisible(true);
            add(dp);
        }else if(e.getSource()==menuEditarDonador) {
            VentanaEditarDonador ventanaEdicionDonador = new VentanaEditarDonador();
            ventanaActual = ventanaEdicionDonador;
            dp.add(ventanaEdicionDonador);
            ventanaEdicionDonador.setVisible(true);
            add(dp);
        }else if(e.getSource()==menuConsultarDonador) {
            VentanaConsultarDonador ventanaConsulDonador = new VentanaConsultarDonador();
            ventanaActual = ventanaConsulDonador;
            dp.add(ventanaConsulDonador);
            ventanaConsulDonador.setVisible(true);
            add(dp);
        }else if(e.getSource()== menuAgregarDonacion) {
            VentanaAgregarDonacion ventanaAltasDonadociones = new VentanaAgregarDonacion();
            ventanaActual = ventanaAltasDonadociones;
            dp.add(ventanaAltasDonadociones);
            ventanaAltasDonadociones.setVisible(true);
            add(dp);
        }else if(e.getSource()==menuEliminarDonacion) {
            VentanaEliminarDonacion ventanaBajasDonaciones =new VentanaEliminarDonacion();
            ventanaActual = ventanaBajasDonaciones;
            dp.add(ventanaBajasDonaciones);
            ventanaBajasDonaciones.setVisible(true);
            add(dp);
        }else if(e.getSource()==menuEditarDonacion) {
            VentanaEditarDonacion ventanaEdicionDonaciones = new VentanaEditarDonacion();
            ventanaActual = ventanaEdicionDonaciones;
            dp.add(ventanaEdicionDonaciones);
            ventanaEdicionDonaciones.setVisible(true);
            add(dp);
        }else if(e.getSource()==menuConsultarDonacion) {
            VentanaConsultarDonacion ventanaConsulDonaciones = new VentanaConsultarDonacion();
            ventanaActual = ventanaConsulDonaciones;
            dp.add(ventanaConsulDonaciones);
            ventanaConsulDonaciones.setVisible(true);
            add(dp);
        }else if (e.getSource() == btnCerrarSesion) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    VentanaLogin ventanaLogin = new VentanaLogin();
                    ventanaLogin.setVisible(true);
                    dispose(); // Cierra la ventana actual
                }
            });
        }
    }

}

