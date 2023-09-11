package controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.*;
import modeloDAO.*;

@WebServlet("/controlagenda")
public class controlagenda extends HttpServlet {

    List<agenda> lista_agenda = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if ("limpiar".equals(accion)) {
            this.limpiarlista(request, response);
        } else if ("xxxx".equals(accion)) {

        } else if ("xxxxx".equals(accion)) {

        } else if ("xxxxx".equals(accion)) {

        } else if ("xxxxx".equals(accion)) {

        } else {

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if ("Registrar".equals(accion)) {
            System.out.println("evento registrar");
//            this.registraragenda(request, response);
            this.registrar_agenda(request, response);
        } else if ("Agregar".equals(accion)) {
            System.out.println("evento agregar");
            this.agregaralista(request, response);
        } else if ("xxxxx".equals(accion)) {

        } else if ("xxxxx".equals(accion)) {

        } else if ("xxxxx".equals(accion)) {

        } else {

        }
    }

    private void registrar_agenda(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        registrar r = new registrar();
        for(int i=0;i<lista_agenda.size();i++){
            r.setCod_servicio(lista_agenda.get(i).getCod_servicio());
            r.setCod_empresa(lista_agenda.get(i).getCod_empresa());
            r.setDiarecordar(lista_agenda.get(i).getDiarecordar());
            int registraevento = new registrarDAO().insert(r);
        }
        lista_agenda.clear();
        this.ventanaprincipal(request, response);
//        request.setAttribute("listagenda", lista_agenda);
//        this.ventanaprincipal(request, response);
    }
    
    private void registraragenda(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String empresa = request.getParameter("listempresa");
        String servicio = request.getParameter("listservicio");
        int codigoempresa = this.buscarcodigoempresa(empresa);
        int codigoservicio = this.buscarcodigoservicio(servicio);
        int diarecordar = Integer.parseInt(request.getParameter("diarecordar"));
        List<registrar> lista = new registrarDAO().select();
        request.setAttribute("listagenda", lista);
        this.ventanaprincipal(request, response);
    }

    private void limpiarlista(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        lista_agenda.clear();
        this.ventanaprincipal(request, response);
    }

    private void agregaralista(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String empresa = request.getParameter("listempresa");
        String servicio = request.getParameter("listservicio");
        int codigoempresa = this.buscarcodigoempresa(empresa);
        int codigoservicio = this.buscarcodigoservicio(servicio);
        int diarecordar = Integer.parseInt(request.getParameter("diarecordar"));
        agenda ag = new agenda();
        ag.setCod_empresa(codigoempresa);
        ag.setCod_servicio(codigoservicio);
        ag.setDiarecordar(diarecordar);
        ag.setRazonsocial(empresa);
        ag.setServicio(servicio);
        lista_agenda.add(ag);
        request.setAttribute("listagenda", lista_agenda);
        this.ventanaprincipal(request, response);
    }

    private void ListAgenda(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String ruta = "WEB-INF/agenda/ventanagenda.jsp";
        request.getRequestDispatcher(ruta).forward(request, response);
    }

    private int buscarcodigoempresa(String empresa) {
        empresa em = new empresa();
        em.setRazonsocial(empresa);
        em = new empresaDAO().Buscarcodigoempresa(em);
        int codigo = em.getCodigo();
        return codigo;
    }

    private int buscarcodigoservicio(String servicio) {
        servicio ser = new servicio();
        ser.setDescripcion(servicio);
        ser = new servicioDAO().Buscarcodigoservicio(ser);
        int codigo = ser.getCodigo();
        return codigo;
    }

    private void ventanaprincipal(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String ruta = "WEB-INF/agenda/ventanagenda.jsp";
        List<servicio> servicios = new servicioDAO().select();
        List<empresa> empresas = new empresaDAO().select();
        request.setAttribute("listaempresas", empresas);
        request.setAttribute("listaservicios", servicios);
        request.getRequestDispatcher(ruta).forward(request, response);
    }

}
