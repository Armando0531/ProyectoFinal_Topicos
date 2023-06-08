package conexionBD;

import modelo.Donacion;
import modelo.Donador;

import java.sql.*;

public class ConexionBD {
    private static Connection conexion;
    private static PreparedStatement pstm;
    private static ResultSet rs;

    static String URL;

    public ConexionBD() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            URL = "jdbc:mysql://localhost:3306/Universidad";

            conexion = DriverManager.getConnection(URL, "root", "jael0531");

        } catch (ClassNotFoundException e) {
            System.out.println("Error de DRIVER");
        } catch (SQLException e) {
            System.out.println("Error de conexion en MySQL");
        }
    }
    public static Connection getConexion(){

        if (conexion == null){
            new ConexionBD();
        }

        return conexion;
    }


    static void cerrarConexion() {
        try {
            pstm.close();
            conexion.close();
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexion");
            e.printStackTrace();
        }
    }

    public static  ResultSet ConsultarRegistro(String consulta){

        try {
            pstm = conexion.prepareStatement(consulta);
            return pstm.executeQuery();

        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
        return null;
    }

    public static boolean AgregarRegistro(Donador donador) {
        try {

            pstm = conexion.prepareStatement("INSERT INTO Donador VALUES(null,?,?,?,?,?,?)");

            pstm.setString(1,donador.getNombre());
            pstm.setString(2,donador.getDireccion());
            pstm.setString(3,donador.getTelefono());
            pstm.setString(4,donador.getCategoria());
            pstm.setString(5,donador.getAnioGraduacion());
            pstm.setString(6,donador.getMetodoPago());

            pstm.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public static boolean AgregarDonacion(Donacion donacion) {

        try {

            pstm = conexion.prepareStatement("INSERT INTO Donativo VALUES (null,?,?,?,?,?,?,?,?,?,?)");

            pstm.setInt(1, donacion.getDonanteId());
            pstm.setInt(2, donacion.getEventoId());
            pstm.setDouble(3,donacion.getCantidadGarantizada());
            pstm.setDouble(4,donacion.getCantidadEnviada());
            pstm.setString(5,donacion.getFechaGarantia());
            pstm.setInt(6, donacion.getNumeroPagos());
            pstm.setString(7,donacion.getTarjetaCredito());
            pstm.setString(8,donacion.getCorporacionEmisora());
            pstm.setString(9,donacion.getDireccionCorporacion());
            pstm.setString(10,donacion.getNombreConyuge());

            pstm.executeUpdate();

            System.out.println(pstm);
            return true;

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return false;
    }

    public static boolean EliminarRegistro(String instruccion){
        try {
            String consulta = instruccion;
            pstm = conexion.prepareStatement(consulta);
            pstm.executeUpdate();
            return true;
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
        return false;
    }

    public static boolean ActualizarRegistro(Donador donador){

        try {
            pstm = conexion.prepareStatement("UPDATE Donador SET Nombre=?, Direccion=?, Telefono=?, " +
                    "Categoria=?, AnioGraduacion=?, MetodoPago=? WHERE ID=?");

            pstm.setString(1, donador.getNombre());
            pstm.setString(2, donador.getDireccion());
            pstm.setString(3, donador.getTelefono());
            pstm.setString(4, donador.getCategoria());
            pstm.setString(5, donador.getAnioGraduacion());
            pstm.setString(6, donador.getMetodoPago());
            pstm.setInt(7, donador.getId());

            pstm.executeUpdate();

            return true;

        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
        return false;
    }
    public static boolean ActualizarRegistroDonacion(Donacion donacion){

        try {
            pstm = conexion.prepareStatement("UPDATE Donativo SET Donante_ID=? , Evento_ID=?, " +
                    "CantidadGarantizada=?, CantidadEnviada=?, FechaGarantia=?, NumeroPagos=?, TarjetaCredito=?, " +
                    "CorporacionEmisora=?, DireccionCorporacion=?, NombreConyugue=? WHERE ID=?");

            pstm.setInt(1, donacion.getDonanteId());
            pstm.setInt(2, donacion.getEventoId());
            pstm.setDouble(3,donacion.getCantidadGarantizada());
            pstm.setDouble(4,donacion.getCantidadEnviada());
            pstm.setString(5,donacion.getFechaGarantia());
            pstm.setInt(6, donacion.getNumeroPagos());
            pstm.setString(7,donacion.getTarjetaCredito());
            pstm.setString(8,donacion.getCorporacionEmisora());
            pstm.setString(9,donacion.getDireccionCorporacion());
            pstm.setString(10,donacion.getNombreConyuge());
            pstm.setInt(11, donacion.getId());

            pstm.executeUpdate();

            return true;

        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
        return false;
    }
}
