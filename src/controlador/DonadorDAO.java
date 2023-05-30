package controlador;

import conexionBD.ConexionBD;
import modelo.Donador;


public class DonadorDAO  {
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
