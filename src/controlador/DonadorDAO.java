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

    public boolean modificarDonador(Donador a) {
        boolean resultado = false;
        resultado=ConexionBD.ActualizarRegistro(a);

        return resultado;
    }

    public Donador buscar(int filtro){
        Donador d1=new Donador();
        String sql="SELECT * FROM Donador WHERE ID ="+filtro+";";

        ResultSet rs=ConexionBD.ConsultarRegistro(sql);

        try {

            if(rs.next()) {
                try {
                    d1.setId(rs.getInt(1));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                d1.setNombre(rs.getString(2));
                d1.setDireccion(rs.getString(3));
                d1.setTelefono(rs.getString(4));
                d1.setCategoria(rs.getString(5));
                d1.setAnioGraduacion(rs.getString(6));
                d1.setMetodoPago(rs.getString(7));
            }else {
                VentanaEliminarDonador.bandera=0;
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }//0==no 1==si
        VentanaEliminarDonador.bandera=1;
        return d1;
    }
    public boolean eliminarDonador(String idEliminar) {

        String instruccion="DELETE FROM Donador WHERE ID = '"+idEliminar+"';";
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
