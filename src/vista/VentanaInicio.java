package vista;

import java.awt.*;
import javax.swing.*;
import java.awt.Toolkit;
import java.awt.event.ActionListener;


public class VentanaInicio extends JFrame implements ActionListener {


    JToolBar toolbar;
    JButton btnCerrarSesion;
    JMenuBar menuBar;
    JMenu menuDonadores, menuDonaciones;
    JMenuItem menuAgregarDonador, menuEliminarDonador, menuEditarDonador, menuConsultarDonador;
    JMenuItem menuAgregarDonacion, menuEliminarDonacion, menuEditarDonacion, menuConsultarDonacion;
    JDesktopPane dp = new JDesktopPane();

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
}