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

@WebServlet("/controlevento")
public class control extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if ("ventanaempresa".equals(accion)) {
            this.ventanaempresa(request, response);
        } else if ("ventanaservicio".equals(accion)) {
            this.ventanaservicio(request, response);
        } else if ("ventanagenda".equals(accion)) {
            this.ventana_agenda(request, response);
        } else if ("xxxx".equals(accion)) {

        } else {

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if ("registro".equals(accion)) {

        } else if ("Ingresar".equals(accion)) {
            this.ingresousuario(request, response);
        } else {

        }
    }

    private void ventanaempresa(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        String ruta = "WEB-INF/empresa/ventanaempresa1.jsp";
        String ruta = "WEB-INF/empresa/listarempresa1.jsp";
        List<empresa> em = new empresaDAO().select();
        request.setAttribute("listar", em);
        request.getRequestDispatcher(ruta).forward(request, response);
    }

    private void ventanaservicio(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String ruta = "WEB-INF/servicio/ventanaservicio.jsp";
        List<servicio> ser = new servicioDAO().select();
        request.setAttribute("listarservicio", ser);
        request.getRequestDispatcher(ruta).forward(request, response);
    }

    private void ventana_agenda(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String ruta = "WEB-INF/agenda/ventanagenda.jsp";
        List<servicio> servicios = new servicioDAO().select();
        List<empresa> empresas = new empresaDAO().select();
        request.setAttribute("listaempresas", empresas);
        request.setAttribute("listaservicios", servicios);
        request.getRequestDispatcher(ruta).forward(request, response);
    }

    private void ingresousuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String usuario = request.getParameter("usuario");
        String contrasena = request.getParameter("contrasena");
        usuario user = new usuario();
        System.out.println(user+" "+contrasena);
        user.setUser(usuario);
        user.setContrasena(contrasena);
        user = new usuarioDAO().encontrar(user);
        System.out.println("el usuario: "+user.getEstado());
        if ("activo".equals(user.getEstado())) {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else {
            System.out.println("Usuario no admitido");
        }
    }
}
