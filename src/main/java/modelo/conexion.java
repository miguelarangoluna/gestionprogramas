package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class conexion {
    
    public static Connection conn;
    private static final String JDBC_URL = "jdbc:postgresql://192.168.1.16:5432/CalendarioTributarioAcountiservice";
    private static final String JDBC_USER = "postgres";
    private static final String JDBC_CLAVE = "1234";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_CLAVE);
    }
    
    public static Connection abrir (){
        try{
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_CLAVE);
        }catch(Exception e){
            System.out.println("Error de conexion");
            e.printStackTrace();
        }
        return conn;
    }

    public static void close(ResultSet rs) {
        try {
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error: no se pudo cerrar");
            e.printStackTrace(System.out);
        }
    }

    public static void close(PreparedStatement stm) {
        try {
            stm.close();
        } catch (SQLException e) {
            System.out.println("Error: no se pudo cerrar");
            e.printStackTrace(System.out);
        }
    }

    public static void close(Connection con) {
        try {
            con.close();
        } catch (SQLException e) {
            System.out.println("Error: no se pudo cerrar");
            e.printStackTrace(System.out);
        }
    }
}
