package modeloDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.*;

public class servicioDAO {

    private static final String SQL_SELECT = "select * from servicio order by codigo";
    private static final String SQL_CONSULTA_DB = "select cargo, fechaingreso, salario from servicio where codigo=?";
    private static final String SQL_INSERT = "insert into servicio (fecha,descripcion,ciudad) values (?,?,?)";
    private static final String SQL_UPDATE = "update servicio set descripcion=?, precio=?, service=? where codigo=?";
    private static final String SQL_DELETE = "delete from servicio where codigo=?";
    private static final String SQL_CONSULTA_SERVICIOS_GENERALES = "select distinct descripcion from servicio";
    private static final String SQL_BUSCAR_SERVICIO = "select descripcion,precio from servicio where codigo=?";
    private static final String SQL_BUSCAR_CODIGO_SERVICIO = "select codigo from servicio where descripcion=?";
    
    //select precio from servicio where service='Generic BL 5 ENT X1C'
    private static final String SQL_BUSCAR_PRECIO_SERVICIO = "select precio from servicio where service=?";

    public List<servicio> select() {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        servicio service = null;
        List<servicio> servi = new ArrayList<servicio>();
        try {//codigo,fecha,codigo_digitoverificacion,descripcion,ciudad
            conn = conexion.abrir();
            pst = conn.prepareStatement(SQL_SELECT);
            rs = pst.executeQuery();
            while (rs.next()) {
                int codigo = rs.getInt(1);
                String fecha = rs.getString(2);
                String descripcion = rs.getString(3);
                String ciudad = rs.getString(4);
                service = new servicio();
                service.setCodigo(codigo);
                service.setFecha(fecha);
                service.setDescripcion(descripcion);
                service.setCiudad(ciudad);
//                service.setPrecio(precio);
                servi.add(service);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println(ex.toString());
        } finally {
            conexion.close(conn);
            conexion.close(pst);
            conexion.close(rs);
        }
        return servi;
    }

    public List<servicio> select1() {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        servicio service;
        List<servicio> servi = new ArrayList<servicio>();
        try {
            conn = conexion.abrir();
            pst = conn.prepareStatement(SQL_CONSULTA_SERVICIOS_GENERALES);
            rs = pst.executeQuery();
            while (rs.next()) {
                String descripcion = rs.getString("descripcion");
                service = new servicio();
                service.setDescripcion(descripcion);
                servi.add(service);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println(ex.toString());
        } finally {
            conexion.close(conn);
            conexion.close(pst);
            conexion.close(rs);
        }
        return servi;
    }

    public servicio encontrar(servicio use) {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            conn = conexion.abrir();
            pst = conn.prepareStatement(SQL_BUSCAR_SERVICIO, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pst.setInt(1, use.getCodigo());
            rs = pst.executeQuery();
            rs.absolute(1);
            String descripcion = rs.getString("descripcion");
            double precio = rs.getDouble("precio");
            use.setDescripcion(descripcion);
//            use.setPrecio(precio);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            conexion.close(conn);
            conexion.close(pst);
            conexion.close(rs);
        }
        return use;
    }

    public servicio Buscarcodigoservicio (servicio ser) {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            conn = conexion.abrir();
            pst = conn.prepareStatement(SQL_BUSCAR_CODIGO_SERVICIO, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pst.setString(1, ser.getDescripcion());
            rs = pst.executeQuery();
            rs.absolute(1);
            int codigo = rs.getInt("codigo");
            ser.setCodigo(codigo);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            conexion.close(conn);
            conexion.close(pst);
            conexion.close(rs);
        }
        return ser;
    }
    
    public servicio Buscarprecioservicio (servicio ser) {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            conn = conexion.abrir();
            pst = conn.prepareStatement(SQL_BUSCAR_PRECIO_SERVICIO, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pst.setString(1, ser.getService());// aqui era ser.getdescripcion();
            rs = pst.executeQuery();
            rs.absolute(1);
            double precio = rs.getDouble("precio");
//            ser.setPrecio(precio);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            conexion.close(conn);
            conexion.close(pst);
            conexion.close(rs);
        }
        return ser;
    }

    public int insert(servicio service) {
        Connection con = null;
        PreparedStatement insertarservicio = null;
        int fila = 0;
        try {
            con = conexion.abrir();
            insertarservicio = con.prepareStatement(SQL_INSERT);
            insertarservicio.setString(1,service.getFecha());//
            insertarservicio.setString(2,service.getDescripcion());
            insertarservicio.setString(3,service.getCiudad());
            fila = insertarservicio.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexion.close(con);
            conexion.close(insertarservicio);
        }
        return fila;
    }

    public int update(servicio service) {
        Connection con = null;
        PreparedStatement stm = null;
        int fila = 0;
        try {
            con = conexion.abrir();
//            System.out.println("actualizando campo: " + SQL_UPDATE);
            stm = con.prepareStatement(SQL_UPDATE);
            stm.setString(1, service.getDescripcion());
//            stm.setDouble(2, service.getPrecio());
            stm.setString(3, service.getService());
            stm.setInt(4, service.getCodigo());
            fila = stm.executeUpdate();
//            System.out.println("Registros actualizados: " + fila);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexion.close(con);
            conexion.close(stm);
        }
        return fila;
    }

    public int delete(servicio eliminarservicio) {
        Connection con = null;
        PreparedStatement stm = null;
        int fila = 0;
        try {
            con = conexion.abrir();
//            System.out.println("Ejecutando query: " + SQL_DELETE);
            stm = con.prepareStatement(SQL_DELETE);
            stm.setInt(1, eliminarservicio.getCodigo());
            fila = stm.executeUpdate();
//            System.out.println("Registros eliminados: " + fila);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexion.close(con);
            conexion.close(stm);
        }
        return fila;
    }
}
