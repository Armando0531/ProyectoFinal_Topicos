package conexionBD;

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
}
