package modeloDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.*;
import test.*;

public class consultaDAO {

    private static final String SQL_SELECT = "select * from empresa order by codigo";
    private static final String SQL_CONSULTA_DB = "select cargo, fechaingreso, salario from servicio where codigo=?";
    private static final String SQL_INSERT = "insert into empresa (nit,razonsocial,digito_verificacion,telefono,direccion,fecha) values (?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "update empresa set descripcion=?, precio=?, service=? where codigo=?";
    private static final String SQL_DELETE = "delete from servicio where codigo=?";
    private static final String SQL_CONSULTA_SERVICIOS_GENERALES = "select distinct descripcion from servicio";
    private static final String SQL_BUSCAR_EMPRESA = "select razonsocial,fecha from empresa where nit=?";
    private static final String SQL_BUSCAR_CODIGO_EMPRESA = "select codigo from empresa where razonsocial=?";
    private static final String SQL_DIGITO_VERIFICACION = "select digito_verificacion from empresa where nit=?";
    //select precio from servicio where service='Generic BL 5 ENT X1C'
    private static final String SQL_BUSCAR_PRECIO_SERVICIO = "select precio from servicio where service=?";

    private static final String SQL_BUSCAR_EMPRESA_POR_NIT = "select codigo from empresa where nit =? ";

    private static final String SQL_CONSULTA_ESPECIFICA = "select distinct\n"
            + "ser.fecha,emp.digito_verificacion, emp.razonsocial,ser.descripcion,reg.diarecordar \n"
            + "from calendariotributario as cal\n"
            + "inner join servicio as ser\n"
            + "inner join registrar as reg\n"
            + "inner join empresa as emp\n"
            + "on emp.codigo = reg.cod_empresa\n"
            + "on reg.cod_servicio = ser.codigo\n"
            + "on ser.codigo = cal.cod_servicio\n"
            + "where \n"
            + "cal.digito_verificacion = emp.digito_verificacion \n"
            + "and emp.nit=?";

    public List<empresa> select() {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        empresa emp = null;
        List<empresa> emp_empresa = new ArrayList<empresa>();
        try {
            conn = conexion.abrir();
            pst = conn.prepareStatement(SQL_SELECT);
            rs = pst.executeQuery();
            while (rs.next()) {
                int codigo = rs.getInt("codigo");
                int nit = rs.getInt("nit");
                int digito = rs.getInt("digito_verificacion");
                String razonsocial = rs.getString("razonsocial");
                int telefono = rs.getInt("telefono");
                String direccion = rs.getString("direccion");
                String fecha = rs.getString("fecha");
                emp = new empresa();
                emp.setCodigo(codigo);
                emp.setNit(nit);
                emp.setRazonsocial(razonsocial);
                emp.setTelefono(telefono);
                emp.setDireccion(direccion);
                emp.setFecha(fecha);
                emp.setDigitoverificacion(digito);
                emp_empresa.add(emp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println(ex.toString());
        } finally {
            conexion.close(conn);
            conexion.close(pst);
            conexion.close(rs);
        }
        return emp_empresa;
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

    public List<consulta> select2(consulta consul) {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        consulta con;
        List<consulta> listconsulta = new ArrayList<consulta>();
        try {
            conn = conexion.abrir();
            pst = conn.prepareStatement(SQL_CONSULTA_ESPECIFICA);
            pst.setInt(1, consul.getNit());
            rs = pst.executeQuery();
            while (rs.next()) {
                String fecha = rs.getString("fecha");
                String razonsocial = rs.getString("razonsocial");
                int diarecordar = rs.getInt("diarecordar");
                String descripcion = rs.getString("descripcion");
                con = new consulta();
                con.setFecha(fecha);
                con.setDiarecordar(diarecordar);
                con.setRazonsocial(razonsocial);
                con.setDescripcion(descripcion);
                listconsulta.add(con);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println(ex.toString());
        } finally {
            conexion.close(conn);
            conexion.close(pst);
            conexion.close(rs);
        }
        return listconsulta;
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

    public empresa find_digito_verificacion(empresa em) {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            conn = conexion.abrir();
            pst = conn.prepareStatement(SQL_DIGITO_VERIFICACION, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pst.setInt(1, em.getNit());
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

    public empresa find_codigo_empresa_por_nit(empresa em) {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            conn = conexion.abrir();
            pst = conn.prepareStatement(SQL_BUSCAR_EMPRESA_POR_NIT, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pst.setInt(1, em.getNit());
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

    public empresa Buscarcodigoempresa(empresa em) {
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

    public servicio Buscarprecioservicio(servicio ser) {
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
//(nit,razonsocial,digito_verificacion,telefono,direccion,fecha)

    public int insert(empresa em) {
        Connection con = null;
        PreparedStatement insertarservicio = null;
        int fila = 0;
        try {
            con = conexion.abrir();
            insertarservicio = con.prepareStatement(SQL_INSERT);
            insertarservicio.setInt(1, em.getNit());
            insertarservicio.setString(2, em.getRazonsocial());//
            insertarservicio.setInt(3, em.getDigitoverificacion());
            insertarservicio.setInt(4, em.getTelefono());
            insertarservicio.setString(5, em.getDireccion());
            insertarservicio.setString(6, em.getFecha());
            fila = insertarservicio.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexion.close(con);
            conexion.close(insertarservicio);
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
