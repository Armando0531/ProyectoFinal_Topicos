package controlador;

import conexionBD.ConexionBD;
import modelo.Donacion;


public class DonacionDAO  {
    ConexionBD conexion;

    public DonacionDAO() {
        conexion = new ConexionBD();
    }

    public boolean insertarRegistro(Donacion a) {
        boolean resultado=false;

        resultado=ConexionBD.AgregarDonacion(a);

        return resultado;
    }


}
