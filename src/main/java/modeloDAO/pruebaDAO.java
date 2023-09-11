/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeloDAO;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.*;


/**
 *
 * @author miguelarcadioarangoluna
 */
public class pruebaDAO {
    private static final String SQL_SELECT = "select * from prueba order by codigo";
    private static final String SQL_CONSULTA_DB = "select cargo, fechaingreso, salario from servicio where codigo=?";
    private static final String SQL_INSERT = "insert into prueba (fecha,fecha1,fecha2) values (?,?,?)";
    private static final String SQL_UPDATE = "update empresa set descripcion=?, precio=?, service=? where codigo=?";
    private static final String SQL_DELETE = "delete from servicio where codigo=?";
    private static final String SQL_CONSULTA_SERVICIOS_GENERALES = "select distinct descripcion from servicio";
    private static final String SQL_BUSCAR_EMPRESA = "select razonsocial,fecha from empresa where nit=?";
    private static final String SQL_BUSCAR_CODIGO_EMPRESA = "select codigo from empresa where razonsocial=?";
    private static final String SQL_DIGITO_VERIFICACION = "select digito_verificacion from empresa where nit=?";
    //select precio from servicio where service='Generic BL 5 ENT X1C'
    private static final String SQL_BUSCAR_PRECIO_SERVICIO = "select precio from servicio where service=?";
    
    private static final String SQL_BUSCAR_EMPRESA_POR_NIT ="select codigo from empresa where nit =? ";
    
    public List<prueba> select() {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        prueba pr = null;
        List<prueba> listaprueba = new ArrayList<prueba>();
        try {
            conn = conexion.abrir();
            pst = conn.prepareStatement(SQL_SELECT);
            rs = pst.executeQuery();
            while (rs.next()) {
                int codigo = rs.getInt("codigo");
                String fecha = rs.getString("fecha");
                String fecha1 = rs.getString("fecha1");
                String fecha2 = rs.getString("fecha2");
                pr = new prueba();
                pr.setCodigo(codigo);
                pr.setFecha(fecha);
                pr.setFecha1(fecha1);
                pr.setFecha2(fecha2);
                listaprueba.add(pr);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println(ex.toString());
        } finally {
            conexion.close(conn);
            conexion.close(pst);
            conexion.close(rs);
        }
        return listaprueba;
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

    public empresa encontrar(empresa em) {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            conn = conexion.abrir();
            pst = conn.prepareStatement(SQL_BUSCAR_EMPRESA, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pst.setInt(1, em.getNit());
            rs = pst.executeQuery();
            rs.absolute(1);
            String razonsocial = rs.getString("razonsocial");
            String fecha = rs.getString("fecha");
            em.setRazonsocial(razonsocial);
            em.setFecha(fecha);
//            use.setPrecio(precio);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            conexion.close(conn);
            conexion.close(pst);
            conexion.close(rs);
        }
        return em;
    }
    
    public empresa find_digito_verificacion (empresa em){
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            conn = conexion.abrir();
            pst = conn.prepareStatement(SQL_DIGITO_VERIFICACION, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pst.setInt(1,em.getNit());
            rs = pst.executeQuery();
            rs.absolute(1);
            int digitoverificacion = rs.getInt("digito_verificacion");
            em.setDigitoverificacion(digitoverificacion);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            conexion.close(conn);
            conexion.close(pst);
            conexion.close(rs);
        }
        return em;
    }
    
    public empresa find_codigo_empresa_por_nit (empresa em){
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            conn = conexion.abrir();
            pst = conn.prepareStatement(SQL_BUSCAR_EMPRESA_POR_NIT, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pst.setInt(1,em.getNit());
            rs = pst.executeQuery();
            rs.absolute(1);
            int codigoempresa = rs.getInt("codigo");
            em.setCodigo(codigoempresa);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            conexion.close(conn);
            conexion.close(pst);
            conexion.close(rs);
        }
        return em;
    }
    

    public empresa Buscarcodigoempresa (empresa em) {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            conn = conexion.abrir();
            pst = conn.prepareStatement(SQL_BUSCAR_CODIGO_EMPRESA, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pst.setString(1, em.getRazonsocial());
            rs = pst.executeQuery();
            rs.absolute(1);
            int codigo = rs.getInt("codigo");
            em.setCodigo(codigo);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            conexion.close(conn);
            conexion.close(pst);
            conexion.close(rs);
        }
        return em;
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
//(fecha,fecha1,fecha2)
    public int insert(prueba prue) {
        Connection con = null;
        PreparedStatement insertarprueba = null;
        int fila = 0;
        try {
            con = conexion.abrir();
            insertarprueba = con.prepareStatement(SQL_INSERT);
            insertarprueba.setString(1, prue.getFecha());
            insertarprueba.setString(2, prue.getFecha1());
            insertarprueba.setString(3, prue.getFecha2());
            fila = insertarprueba.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexion.close(con);
            conexion.close(insertarprueba);
        }
        return fila;
    }

    public int update(empresa emp) {
        Connection con = null;
        PreparedStatement stm = null;
        int fila = 0;
        try {
            con = conexion.abrir();
//            System.out.println("actualizando campo: " + SQL_UPDATE);
            stm = con.prepareStatement(SQL_UPDATE);
            stm.setString(1, emp.getDireccion());
//            stm.setDouble(2, service.getPrecio());
            stm.setString(3, emp.getFecha());
            stm.setString(4, emp.getRazonsocial());
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
