package controlador;

import conexionBD.ConexionBD;
import modelo.Donacion;
import vista.VentanaEliminarDonacion;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DonacionDAO implements Runnable {
    ConexionBD conexion;
    private int filtro;

    public DonacionDAO() {
        conexion = new ConexionBD();
    }

    public boolean insertarRegistro(Donacion a) {
        boolean resultado=false;

        resultado=ConexionBD.AgregarDonacion(a);

        return resultado;
    }

    public boolean modificarDonadocion(Donacion a) {
        boolean resultado = false;
        resultado=ConexionBD.ActualizarRegistroDonacion(a);

        return resultado;
    }

    public Donacion buscar(int filtro){
        Donacion d1=new Donacion();
        String sql="SELECT * FROM Donativo WHERE ID ="+filtro+";";

        ResultSet rs=ConexionBD.ConsultarRegistro(sql);

        try {

            if(rs.next()) {
                try {
                    d1.setId(rs.getInt(1));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                d1.setDonanteId(rs.getInt(2));
                d1.setEventoId(rs.getInt(3));
                d1.setCantidadGarantizada(rs.getDouble(4));
                d1.setCantidadEnviada(rs.getDouble(5));
                d1.setFechaGarantia(rs.getString(6));
                d1.setNumeroPagos(rs.getInt(7));
                d1.setTarjetaCredito(rs.getString(8));
                d1.setCorporacionEmisora(rs.getString(9));
                d1.setDireccionCorporacion(rs.getString(10));
                d1.setNombreConyuge(rs.getString(11));
            }else {
                VentanaEliminarDonacion.bandera=0;
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }//0==no 1==si
        VentanaEliminarDonacion.bandera=1;
        return d1;
    }
    public boolean eliminarDonacion(String idEliminar) {

        String instruccion="DELETE FROM Donativo WHERE ID = '"+idEliminar+"';";
        boolean resultado = false;
        resultado = ConexionBD.EliminarRegistro(instruccion);

        return resultado;
    }

    @Override
    public void run() {
        buscar(this.filtro);

    }
    public void setFiltro(int filtro) {
        this.filtro = filtro;
    }

}
