package controlador;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexionBD.ConexionBD;
import modelo.Usuario;

public class UsuarioDAO {

    public ArrayList<Usuario> buscar(String nombre, String contrasena) {

        ArrayList<Usuario> listaUsuarios = new ArrayList<>();
        String sql = "SELECT * FROM Usuarios WHERE Nombre = '" + nombre + "' AND Contrasena = '" + contrasena + "';";

        ResultSet rs = ConexionBD.ConsultarRegistro(sql);

        try {
            if (rs.next()) {
                do {
                    listaUsuarios.add(new Usuario(rs.getString(1), rs.getString(2)));
                } while (rs.next());
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaUsuarios;
    }
}
