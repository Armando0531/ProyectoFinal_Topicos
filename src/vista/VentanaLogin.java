package vista;

import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.ArrayList;

import conexionBD.ConexionBD;
import modelo.Usuario;
import controlador.UsuarioDAO;

public class VentanaLogin extends JFrame {
    JButton btnIngresar;
    private JPasswordField cajaContrasena;
    JLabel lblSesion, lblContrasena, lblUsuario, lblLogo,lblTitulo;
    private JTextField cajaUsuario;
    JPanel contentPane;

    public VentanaLogin() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(100, 100, 350, 532);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(55, 92, 170));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);

        lblTitulo = new JLabel("UNIVERSIDAD BETA");
        lblTitulo.setBounds(28, 40, 275, 36);
        lblTitulo.setForeground(new Color(255, 255, 255));
        lblTitulo.setFont(new Font("Arial Black", Font.PLAIN, 25));
        contentPane.add(lblTitulo);

        lblLogo = new JLabel("");
        lblLogo.setIcon(new ImageIcon("./imagenes/logo_2.png"));
        lblLogo.setBounds(57, 79, 209, 190);
        contentPane.add(lblLogo);

        JPanel panel = new JPanel();
        panel.setBounds(37, 248, 266, 183);
        contentPane.add(panel);
        panel.setLayout(null);

        lblSesion = new JLabel("Iniciar Sesión");
        lblSesion.setFont(new Font("Arial Black", Font.PLAIN, 26));
        lblSesion.setBounds(33, 22, 209, 37);
        panel.add(lblSesion);

        lblUsuario = new JLabel("Usuario:");
        lblUsuario.setFont(new Font("Arial Black", Font.PLAIN, 16));
        lblUsuario.setBounds(33, 61, 84, 23);
        panel.add(lblUsuario);

        cajaUsuario = new JTextField();
        cajaUsuario.setBounds(33, 85, 192, 24);
        panel.add(cajaUsuario);
        cajaUsuario.setColumns(10);

        lblContrasena = new JLabel("Contraseña:");
        lblContrasena.setFont(new Font("Arial Black", Font.PLAIN, 16));
        lblContrasena.setBounds(33, 117, 113, 23);
        panel.add(lblContrasena);

        cajaContrasena = new JPasswordField();
        cajaContrasena.setBounds(33, 148, 192, 24);
        panel.add(cajaContrasena);

        btnIngresar = new JButton("Ingresar");
        btnIngresar.setBackground(new Color(0, 0, 255));
        btnIngresar.setForeground(new Color(255, 255, 255));
        btnIngresar.setFont(new Font("Arial Black", Font.PLAIN, 14));
        btnIngresar.setBounds(111, 453, 119, 29);
        contentPane.add(btnIngresar);

        cajaUsuario.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isLetterOrDigit(c) && c != KeyEvent.VK_BACK_SPACE) {
                    e.consume();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {}

            @Override
            public void keyReleased(KeyEvent e) {}
        });

        cajaContrasena.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isLetterOrDigit(c) && c != KeyEvent.VK_BACK_SPACE) {
                    e.consume();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {}

            @Override
            public void keyReleased(KeyEvent e) {}
        });

        btnIngresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Connection a = ConexionBD.getConexion();
                UsuarioDAO uDAO = new UsuarioDAO();

                ArrayList<Usuario> listaUsuarios = new ArrayList<>();
                listaUsuarios = uDAO.buscar(cajaUsuario.getText(), cajaContrasena.getText());

                if (listaUsuarios != null) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            new VentanaInicio();
                            setVisible(false);
                        }
                    });
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario inexistente o contraseña incorrecta");
                }
            }
        });



    }

    public static void main(String[] args) {
        VentanaLogin login = new VentanaLogin();
        login.setVisible(true);
    }
}
