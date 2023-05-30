package controlador;

import conexionBD.ConexionBD;
import modelo.Donador;
import vista.VentanaEliminarDonador;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DonadorDAO implements Runnable {
    ConexionBD conexion;
    private int filtro;

    public DonadorDAO() {
        conexion = new ConexionBD();
    }

    public boolean insertarDonador(Donador a) {
        boolean resultado=false;

        resultado=ConexionBD.AgregarRegistro(a);

        return resultado;
    }


}
