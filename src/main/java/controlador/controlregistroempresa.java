package controlador;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.*;
import modeloDAO.*;

@WebServlet("/controlempresa")
public class controlregistroempresa extends HttpServlet implements acciones {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if ("ventanaempresa".equals(accion)) {
            this.registroempresa(request, response);
        } else if ("listar".equals(accion)) {
            this.listarempresa(request, response);
        } else if ("editar".equals(accion)) {
            this.ventanta_modificar_empresa(request, response);
        } else if ("eliminar".equals(accion)) {
            this.eliminarempresa(request, response);
        } else {

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if ("Registrar".equals(accion)) {
            this.registroempresa(request, response);
        } else if ("modificar".equals(accion)) {
            this.modificar_empresa(request, response);
        } else if ("xxxx".equals(accion)) {
            System.out.println("evento modificar");
        } else {
            System.out.println("evento sin llamar");
        }
    }

    private void registroempresa(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String razonsocial = request.getParameter("razonsocial");
        int nit = Integer.parseInt(request.getParameter("nit"));
        int digito = Integer.parseInt(request.getParameter("digito_verificacion"));
        int telefono = Integer.parseInt(request.getParameter("telefono"));
        String fecha = request.getParameter("nit");
        String direccion = request.getParameter("direccion");
        empresa em = new empresa(nit, digito, telefono, razonsocial, fecha, direccion);
        int insertar = new empresaDAO().insert(em);
        this.listarempresa(request, response);
    }

    private void eliminarempresa(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        empresa e = new empresa();
        String nitempresa = request.getParameter("nit");
        int nit = Integer.parseInt(nitempresa);
        e.setNit(nit);
        e = new empresaDAO().find_codigo_empresa_por_nit(e);
        System.out.println("el codigo es: " + e);
        int elimanar_empresa = new empresaDAO().delete(e);
        this.listarempresa(request, response);
    }

    private void listarempresa(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        String ruta = "WEB-INF/empresa/listarempresa.jsp";
        String ruta = "WEB-INF/empresa/listarempresa1.jsp";
        List<empresa> em = new empresaDAO().select();
        request.setAttribute("listar", em);
        request.getRequestDispatcher(ruta).forward(request, response);
    }

    private void modificar_empresa(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("evento modificar");
        int nit = Integer.parseInt(request.getParameter("nit"));
        String razonsocial = request.getParameter("razonsocial");
        String direccion = request.getParameter("direccion");
        empresa e = new empresa();
        e.setNit(nit);
        e.setRazonsocial(razonsocial);
        e.setDireccion(direccion);
        System.out.println("los datos para la empresa son: "+e);
        e = new empresaDAO().find_codigo_empresa_por_nit(e);
        int actualizar = new empresaDAO().update(e);
        System.out.println("los datos a modificar son: " + e.getNit() + " - " + e.getRazonsocial() + " - " + e.getDireccion() + " - " + e.getCodigo());
        this.listarempresa(request, response);
    }

    private void ventanta_modificar_empresa(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String ruta = "WEB-INF/empresa/editarempresa.jsp";
        int nit = Integer.parseInt(request.getParameter("nit"));
        empresa e = new empresa(nit);
        consulta(nit);
        String razonsocial = request.getParameter("razonsocial");
        String direccion = request.getParameter("direccion");
        request.setAttribute("razonsocial", razonsocial);
        request.setAttribute("direccion", direccion);
        request.setAttribute("nit", nit);
        request.getRequestDispatcher(ruta).forward(request, response);
    }

    private void consulta(int nit) {
        empresa e = new empresa(nit);
        e = new empresaDAO().encontrar(e);
        System.out.println("los datos de la empresa consultada es: " + e);
    }

    private void listarpendiente(int nit, int digitoverificacion) {
        int n = nit, digito = digitoverificacion;

    }

// proveniente de la clase acciones    
    @Override
    public String rol() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String mensaje() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void tareas() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
