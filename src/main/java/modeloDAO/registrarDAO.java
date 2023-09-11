package modeloDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.conexion;
import modelo.registrar;

public class registrarDAO {

    private static final String SQL_SELECT = "select * from registrar order by codigo";
    private static final String SQL_CONSULTA_DB = "select cargo, fechaingreso, salario from registrar where codigo=?";
    private static final String SQL_INSERT = "insert into registrar (cod_servicio,cod_empresa,diarecordar) values (?,?,?)";
    private static final String SQL_UPDATE = "update registrar set diarecordar=? where codigo=?";
    private static final String SQL_DELETE = "delete from registrar where codigo=?";
    private static final String SQL_CONSULTA_SERVICIOS_GENERALES = "select distinct descripcion from registrar";
    private static final String SQL_BUSCAR_EMPRESA = "select razonsocial,fecha from registrar where nit=?";
    private static final String SQL_BUSCAR_CODIGO_SERVICIO = "select codigo from registrar where service=?";
    private static final String SQL_BUSCAR_PRECIO_SERVICIO = "select precio from registrar where service=?";

    public List<registrar> select() {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        registrar emp = null;
        List<registrar> emp_registrar = new ArrayList<registrar>();
        try {
            conn = conexion.abrir();
            pst = conn.prepareStatement(SQL_SELECT);
            rs = pst.executeQuery();
            while (rs.next()) {
                int codigo = rs.getInt("codigo");
                int cod_servicio = rs.getInt("cod_servicio");
                int cod_empresa = rs.getInt("cod_empresa");
                int dia_recordar = rs.getInt("diarecordar");
                emp = new registrar();
                emp.setCodigo(codigo);
                emp.setCod_servicio(cod_servicio);
                emp.setCod_empresa(cod_empresa);
                emp.setDiarecordar(dia_recordar);
                emp_registrar.add(emp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println(ex.toString());
        } finally {
            conexion.close(conn);
            conexion.close(pst);
            conexion.close(rs);
        }
        return emp_registrar;
    }

    public List<registrar> select1() {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        registrar service;
        List<registrar> servi = new ArrayList<registrar>();
        try {
            conn = conexion.abrir();
            pst = conn.prepareStatement(SQL_CONSULTA_SERVICIOS_GENERALES);
            rs = pst.executeQuery();
            while (rs.next()) {
                int razonsocial = rs.getInt("razonsocial");
                service = new registrar();
                service.setCod_servicio(razonsocial);
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

    public registrar encontrar(registrar em) {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            conn = conexion.abrir();
            pst = conn.prepareStatement(SQL_BUSCAR_EMPRESA, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pst.setInt(1, em.getCodigo());
            rs = pst.executeQuery();
            rs.absolute(1);
            int razonsocial = rs.getInt("codigo");
            String fecha = rs.getString("fecha");
            em.setCodigo(razonsocial);
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

    public registrar Buscarcodigoregistrar(registrar ser) {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            conn = conexion.abrir();
            pst = conn.prepareStatement(SQL_BUSCAR_CODIGO_SERVICIO, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pst.setInt(1, ser.getCodigo());
            rs = pst.executeQuery();
            rs.absolute(1);
            int codigo = rs.getInt("codigo");
            ser.setDiarecordar(codigo);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            conexion.close(conn);
            conexion.close(pst);
            conexion.close(rs);
        }
        return ser;
    }

    public registrar Buscarprecioregistrar(registrar ser) {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            conn = conexion.abrir();
            pst = conn.prepareStatement(SQL_BUSCAR_PRECIO_SERVICIO, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pst.setInt(1, ser.getCodigo());// aqui era ser.getdescripcion();
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

    public int insert(registrar re) {
        Connection con = null;
        PreparedStatement insertarregistrar = null;
        int fila = 0;
        try {
            con = conexion.abrir();
            //cod_servicio,cod_empresa,diarecordar
            insertarregistrar = con.prepareStatement(SQL_INSERT);
            insertarregistrar.setInt(1, re.getCod_servicio());
            insertarregistrar.setInt(2, re.getCod_empresa());//
            insertarregistrar.setInt(3, re.getDiarecordar());
            fila = insertarregistrar.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexion.close(con);
            conexion.close(insertarregistrar);
        }
        return fila;
    }

    public int update(registrar upregis) {
        Connection con = null;
        PreparedStatement stm = null;
        int fila = 0;
        try {
            con = conexion.abrir();
//            System.out.println("actualizando campo: " + SQL_UPDATE);
            stm = con.prepareStatement(SQL_UPDATE);
            stm.setInt(1, upregis.getDiarecordar());
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

    public int delete(registrar eliminarregistrar) {
        Connection con = null;
        PreparedStatement stm = null;
        int fila = 0;
        try {
            con = conexion.abrir();
//            System.out.println("Ejecutando query: " + SQL_DELETE);
            stm = con.prepareStatement(SQL_DELETE);
            stm.setInt(1, eliminarregistrar.getCodigo());
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
