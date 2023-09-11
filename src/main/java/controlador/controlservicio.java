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

@WebServlet("/controlservicio")
public class controlservicio extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if ("listar".equals(accion)) {
//            System.out.println("Ha entrado en registrar");
            this.listarservicio(request, response);
        } else if ("eliminar".equals(accion)) {
            this.eliminarservicio(request, response);
        } else if ("xxxx".equals(accion)) {

        } else {

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if ("Registrar".equals(accion)) {
            System.out.println("Ha entrado en registrar");
            this.registrarservicio(request, response);
        } else if ("listar".equals(accion)) {
            this.listarservicio(request, response);
        } else if ("xxxx".equals(accion)) {

        } else {

        }
    }

    
    private void registrarservicio(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String ciudad = request.getParameter("ciudad");
        String fecha = request.getParameter("fecha");
        String descripcion = request.getParameter("descripcion");
        servicio s = new servicio(fecha, descripcion, ciudad);
        int insertarservicio = new servicioDAO().insert(s);
        
        List<servicio> ser = new servicioDAO().select();
        for (servicio se : ser) {
            System.out.println(se);
        }
        
        request.setAttribute("listarservicio", ser);
        this.ventanaservicio(request, response);
    }

    
    private void listarservicio(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String ruta = "WEB-INF/servicio/listarservicio.jsp";
        List<servicio> ser = new servicioDAO().select();
        request.setAttribute("listarservicio", ser);
        request.getRequestDispatcher(ruta).forward(request, response);
    }

    private void eliminarservicio(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        servicio s = new servicio();
        int codigo = Integer.parseInt(request.getParameter("codigo"));
        s.setCodigo(codigo);
        int eli = new servicioDAO().delete(s);
        this.listarservicio(request, response);
    }
    
    private void ventanaservicio(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String ruta = "WEB-INF/servicio/ventanaservicio.jsp";
        request.getRequestDispatcher(ruta).forward(request, response);
    }
    
}
