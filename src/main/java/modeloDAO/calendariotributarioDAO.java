package modeloDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.*;

public class calendariotributarioDAO {

    private static final String SQL_SELECT = "select * from calendariotributario order by codigo";
    private static final String SQL_CONSULTA_DB = "select cargo, fechaingreso, salario from calendariotributario where codigo=?";
    private static final String SQL_INSERT = "insert into calendariotributario (fecha,digito_verificacion,cod_servicio) values (?,?,?)";
    private static final String SQL_UPDATE = "update calendariotributario set descripcion=?, precio=?, service=? where codigo=?";
    private static final String SQL_DELETE = "delete from calendariotributario where codigo=?";
    private static final String SQL_CONSULTA_SERVICIOS_GENERALES = "select distinct descripcion from calendariotributario";
    private static final String SQL_BUSCAR_SERVICIO = "select descripcion,precio from calendariotributario where codigo=?";
    private static final String SQL_BUSCAR_CODIGO_CALENDARIO = "select codigo from servicio where descripcion=?";
    private static final String SQL_BUSCAR_PRECIO_SERVICIO = "select precio from calendariotributario where service=?";
    private static final String SQL_BUSCAR_FECHAS_EMPRESAS = "select distinct ser.fecha, em.razonsocial, re.diarecordar,ser.descripcion from empresa as em "
            + "inner join registrar as re inner join servicio as ser\n"
            + "on ser.codigo = re.cod_servicio\n"
            + "on re.cod_empresa = em.codigo \n"
            + "where em.digito_verificacion=?";

    private static final String SQL_BUSCAR_FECHAS_CALENDARIO = "select distinct cal.fecha, em.razonsocial, re.diarecordar  from empresa as em "
            + "inner join registrar as re "
            + "inner join calendariotributario as cal\n"
            + "on cal.cod_servicio = re.cod_servicio\n"
            + "on re.cod_empresa = em.codigo \n"
            + "where em.digito_verificacion=?";

    private static final String SQL_PRUEBA_BASE = "select cal.fecha, reg.diarecordar, ser.descripcion from servicio as ser\n"
            + "inner join registrar as reg\n"
            + "inner join calendariotributario as cal\n"
            + "on cal.cod_servicio = reg.cod_servicio\n"
            + "on reg.cod_servicio = ser.codigo\n"
            + "where \n"
            + "reg.cod_empresa  \n"
            + "in (select emp.codigo from empresa as emp where emp.codigo=?)";

    private static final String SQL_CONSULTA_POR_SERVICIO = "select fecha, digito_verificacion from calendariotributario where cod_servicio=?";

    private static final String SQL_CONSULTA_POR_SERVICIO_1 = "select fecha,digito_verificacion from calendariotributario \n"
            + "where cod_servicio in (select codigo from servicio where descripcion=?)";

    public List<calendariotributario> select() {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        calendariotributario service = null;
        List<calendariotributario> servi = new ArrayList<calendariotributario>();
        try {//codigo,fecha,digito_verificacion,cod_servicio
            conn = conexion.abrir();
            pst = conn.prepareStatement(SQL_SELECT);
            rs = pst.executeQuery();
            while (rs.next()) {
                int codigo = rs.getInt(1);
                String fecha = rs.getString(2);
                int digito_verificacion = rs.getInt(3);
                int codigo_servicio = rs.getInt(4);
                service = new calendariotributario();
                service.setCodigo(codigo);
                service.setFecha(fecha);
                service.setDigito_verificacion(digito_verificacion);
                service.setCod_servicio(codigo_servicio);
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

    public List<calendariotributario> select1(calendariotributario cal) {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        calendariotributario service = null;
        List<calendariotributario> servi = new ArrayList<calendariotributario>();
        try {//codigo,fecha,digito_verificacion,cod_servicio
            conn = conexion.abrir();
            pst = conn.prepareStatement(SQL_CONSULTA_POR_SERVICIO_1);
            pst.setString(1, cal.getDescripcion());
            rs = pst.executeQuery();
            while (rs.next()) {
                String fecha = rs.getString(1);
                int digito_verificacion = rs.getInt(2);
                service = new calendariotributario();
                service.setFecha(fecha);
                service.setDigito_verificacion(digito_verificacion);
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

    public List<calendariotributario> agendaempresas(calendariotributario cal) {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        calendariotributario calendario;
        List<calendariotributario> listagenda = new ArrayList<calendariotributario>();
        try {
            conn = conexion.abrir();
            pst = conn.prepareStatement(SQL_BUSCAR_FECHAS_EMPRESAS);
            pst.setInt(1, cal.getDigito_verificacion());
            rs = pst.executeQuery();
            while (rs.next()) {
                int diarecordar = rs.getInt("diarecordar");
                String fecha = rs.getString("fecha");
                String razonsocial = rs.getString("razonsocial");
                String descripcion = rs.getString("descripcion");
                calendario = new calendariotributario();
                calendario.setFecha(fecha);
                calendario.setDiarecordar(diarecordar);
                calendario.setRazonsocial(razonsocial);
                calendario.setDescripcion(descripcion);
                listagenda.add(calendario);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println(ex.toString());
        } finally {
            conexion.close(conn);
            conexion.close(pst);
            conexion.close(rs);
        }
        return listagenda;
    }

    public List<calendariotributario> agendaempresascalendario(calendariotributario cal) {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        calendariotributario calendario;
        List<calendariotributario> listagenda = new ArrayList<calendariotributario>();
        try {
            conn = conexion.abrir();
            pst = conn.prepareStatement(SQL_BUSCAR_FECHAS_CALENDARIO);
            pst.setInt(1, cal.getDigito_verificacion());
            rs = pst.executeQuery();
            while (rs.next()) {
                int diarecordar = rs.getInt("diarecordar");
                String fecha = rs.getString("fecha");
                String razonsocial = rs.getString("razonsocial");
                calendario = new calendariotributario();
                calendario.setFecha(fecha);
                calendario.setDiarecordar(diarecordar);
                calendario.setRazonsocial(razonsocial);
                listagenda.add(calendario);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println(ex.toString());
        } finally {
            conexion.close(conn);
            conexion.close(pst);
            conexion.close(rs);
        }
        return listagenda;
    }

    public List<calendariotributario> agendaempresascalendario1(calendariotributario cal) {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        calendariotributario calendario;
        List<calendariotributario> listagenda = new ArrayList<calendariotributario>();
        try {
            conn = conexion.abrir();
            pst = conn.prepareStatement(SQL_PRUEBA_BASE);
            pst.setInt(1, cal.getNit());
            rs = pst.executeQuery();
            while (rs.next()) {
                int diarecordar = rs.getInt("diarecordar");
                String fecha = rs.getString("fecha");
                String descripcion = rs.getString("descripcion");
                calendario = new calendariotributario();
                calendario.setFecha(fecha);
                calendario.setDiarecordar(diarecordar);
                calendario.setDescripcion(descripcion);
                listagenda.add(calendario);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println(ex.toString());
        } finally {
            conexion.close(conn);
            conexion.close(pst);
            conexion.close(rs);
        }
        return listagenda;
    }

    public calendariotributario encontrarcalendario(calendariotributario cal) {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            conn = conexion.abrir();
            pst = conn.prepareStatement(SQL_CONSULTA_POR_SERVICIO_1, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pst.setString(1, cal.getDescripcion());
            rs = pst.executeQuery();
            rs.absolute(1);
            String fecha = rs.getString("fecha");
            int digitoverificacion = rs.getInt("digito_verificacion");
            cal.setFecha(fecha);
            cal.setDigito_verificacion(digitoverificacion);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            conexion.close(conn);
            conexion.close(pst);
            conexion.close(rs);
        }
        return cal;
    }

    public servicio find_calendario(servicio use) {
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

    public calendariotributario Buscarcodigoservicio(calendariotributario ser) {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            conn = conexion.abrir();
            pst = conn.prepareStatement(SQL_BUSCAR_CODIGO_CALENDARIO, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
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

    public int insert(calendariotributario calendario) {
        Connection con = null;
        PreparedStatement insertarservicio = null;
        int fila = 0;
        try {
            con = conexion.abrir();
            insertarservicio = con.prepareStatement(SQL_INSERT);
            insertarservicio.setString(1, calendario.getFecha());//
            insertarservicio.setInt(2, calendario.getDigito_verificacion());
            insertarservicio.setInt(3, calendario.getCod_servicio());
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
