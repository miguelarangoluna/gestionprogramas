package controlador;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.*;
import modelo.*;
import modeloDAO.*;
import test.*;

@WebServlet("/controlcalendario")
public class controlcalendario extends HttpServlet {

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
    long consultadia;
//    List<agregaservicio> agregar = new ArrayList<>();
    List<calendariotributario> agregar = new ArrayList<>();
    int consecutivo = 1;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if ("asociar".equals(accion)) {
            this.ventanacalendario(request, response);
        } else if ("limpiar".equals(accion)) {
            this.limpiartabla(request, response);
        } else if ("consultaempresa".equals(accion)) {
            this.consultafechasempresas(request, response);
        } else if ("listar".equals(accion)) {
            this.listacalendario1(request, response);
        } else if ("agenda".equals(accion)) {
            this.consultafechasempresas1(request, response);
        } else {

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String mensaje = request.getParameter("horasisetma");
        String accion = request.getParameter("accion");
        if ("agendar".equals(accion)) {
            this.agendarcalendario(request, response);
        } else if ("agregar".equals(accion)) {
            this.agendarcalendario(request, response);
        } else if ("limpiar".equals(accion)) {
            this.limpiartabla(request, response);
        } else if ("Guardar".equals(accion)) {
            this.guardarcalendario(request, response);
        } else if ("prueba".equals(accion)) {
            System.out.println(request.getParameter("horasistema"));
        } else {

        }
    }

    private void asociarservicio(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String codigo = request.getParameter("codigo");
        String concepto = request.getParameter("descripcion");
        System.out.println(codigo);
        System.out.println(concepto);
    }

    private void ventanacalendario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String ruta = "WEB-INF/calendario/registrocalendario.jsp";
        String codigo = request.getParameter("codigo");
        String concepto = request.getParameter("descripcion");
        String fecha = request.getParameter("fecha");
        request.setAttribute("codigo", codigo);
        request.setAttribute("descripcion", concepto);
        request.setAttribute("fecha", fecha);
        request.getRequestDispatcher(ruta).forward(request, response);
    }

    private void ventanacalendario1(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String ruta = "WEB-INF/calendario/registrocalendario1.jsp";
        String codigo = request.getParameter("codigo");
        String concepto = request.getParameter("descripcion");
        String fecha = request.getParameter("fecha");
        request.setAttribute("codigo", codigo);
        request.setAttribute("descripcion", concepto);
        request.setAttribute("fecha", fecha);
        request.getRequestDispatcher(ruta).forward(request, response);
    }

    private void listacalendario1(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String ruta = "WEB-INF/calendario/registrocalendario1.jsp";
        String descripcion = request.getParameter("descripcion");
        request.setAttribute("descripcion", descripcion);

        //conexion a la base de datos, extraer la información con el select y luego envia al formulario destino.
        List<calendariotributario> listacalendario = new calendariotributarioDAO().select();
        request.setAttribute("listar", listacalendario);
        calendariotributario calen = new calendariotributario();
        calen.setDescripcion(descripcion);
        System.out.println(descripcion);
        List<calendariotributario> listacal = new calendariotributarioDAO().select1(calen);

        request.setAttribute("listar", listacal);
        for (calendariotributario cl : listacalendario) {
            System.out.println("la lista del calendario es: " + cl);
        }
        request.getRequestDispatcher(ruta).forward(request, response);
    }

    private void agendarcalendario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        String codigo = request.getParameter("digito_verificacion");
        String fecha = request.getParameter("fecha");
        String descripcion = request.getParameter("descripcion");
        request.setAttribute("descripcion", descripcion);
//        agregaservicio ag = new agregaservicio();
        calendariotributario ag = new calendariotributario();
        ag.setItem(consecutivo);
        ag.setFecha(fecha);
        ag.setDigito_verificacion(Integer.parseInt(codigo));
        agregar.add(ag);
        consecutivo++;
        request.setAttribute("listar", agregar);
        System.out.println(codigo + " - " + fecha + " - " + accion);
        this.ventanacalendario1(request, response);
    }

    private void limpiartabla(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        agregar.clear();
        consecutivo = 1;
        this.ventanacalendario(request, response);
    }

    private void guardarcalendario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        calendariotributario ca = new calendariotributario();
        String codigodescripcion = request.getParameter("descripcion");
        ca.setDescripcion(codigodescripcion);
        ca = new calendariotributarioDAO().Buscarcodigoservicio(ca);
        int codigo = ca.getCodigo();
        System.out.println("el codigo del servicio es: " + codigo);
//        for (agregaservicio se : agregar) {
        for (calendariotributario se : agregar) {
            ca.setFecha(se.getFecha());
            ca.setDigito_verificacion(se.getDigito_verificacion());
            ca.setCod_servicio(codigo);
            int registrarcalendario = new calendariotributarioDAO().insert(ca);
        }
        List<calendariotributario> lis = new calendariotributarioDAO().select();
        for (calendariotributario cal : lis) {
            System.out.println(cal);
        }
        this.limpiartabla(request, response);
    }

    private void listacalendario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<calendariotributario> listacalendario = new calendariotributarioDAO().select();
        request.setAttribute("listacalendario", listacalendario);
        String ruta = "WEB-INF/calendario/muestratablacalendario.jsp";
        String descripcion = request.getParameter("descripcion");
        request.setAttribute("listarservicio", agregar);
        request.setAttribute("descripcion", descripcion);
        for (calendariotributario cl : listacalendario) {
            System.out.println("la lista del calendario es: " + cl);
        }
        request.getRequestDispatcher(ruta).forward(request, response);
    }

    private void consultafechasempresas1(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        eventothread evento = new eventothread(Integer.parseInt(request.getParameter("codigo")));
        Thread proceso = new Thread(evento);
        proceso.start();
        
        enviocorreo correo = new enviocorreo();
        Date hoy = new Date();
        String fechahoy = sdf.format(hoy);
        StringBuffer mensaje = new StringBuffer();
        consulta consul = new consulta();
        String ruta = "WEB-INF/calendario/listacalendario.jsp";
        int nit = Integer.parseInt(request.getParameter("codigo")); //Recibe el nit del formulario JSP
        System.out.println("El nit de la empresa es " + nit);
        int digitoverificacion = digitoempresa(nit); //Metodo para buscar el NIT de la empresa
        int codigo_empresa = codigoempresa(nit);
        int recordar;
        calendariotributario calendario = new calendariotributario();
        calendario.setNit(codigo_empresa);
        // Se asigna el nit al objeto y busca en la tabla los campos requeridos
        consul.setNit(nit);
        List<consulta> consultabla = new consultaDAO().select2(consul);
        request.setAttribute("listar", consultabla);
        String razonsocial = consultabla.get(0).getRazonsocial();
        request.setAttribute("razon", razonsocial);

        String fechatabla = consultabla.get(0).getFecha();

        System.out.println("La fecha de hoy es: " + fechahoy + "\n y la fecha de la consulta es: " + fechatabla);

        System.out.println("La fecha de la TABLA es: " + fechatabla);

        consul.setNit(nit);
        List<consulta> listaconsulta = new consultaDAO().select2(consul);
        for (consulta c : listaconsulta) {
            System.out.println("--- Consulta especial -----\n" + c + "\n---");
        }

        for (int i = 0; i < consultabla.size(); i++) {

            fechatabla = consultabla.get(i).getFecha();

            recordar = consultabla.get(i).getDiarecordar();

            try {

                long dif = metodosfechas(fechahoy, fechatabla);

                System.out.println("La diferencia en fecha es: \n" + dif);

                if (dif <= recordar) {
                    consultabla.get(i).setEstado("Debe pagar urgente");
                } else {
                    consultabla.get(i).setEstado("Todavia tiene tiempo");
                }
                
            } catch (ParseException e) {

                System.out.println("Revisar el siguiente error:\n " + e);

            }
        }

//        String mensaje1 = "Hola-Miguel-Arcadio-Arango-Luna";
//        
//        String[] mensaje = mensaje1.split("-");
//        
//        men.append(mensaje[0]);
        mensaje.append("Estimado proveedor; le recuerdo que debe pagar los siguientes servicios \n");

        /*
        Esta linea de codigo funciona
//        for (consulta c : consultabla) {
//            System.out.println(c);
//            if (c.getEstado().equals("Debe pagar urgente")) {
//                mensaje=mensaje.append(c.getDescripcion()+"\n");
//            } else {
//                
//            }
//        }
//
//        System.out.println("mensaje: "+mensaje);
//        mensaje.append(consultabla.get(0).getRazonsocial());
//        correosaliente(mensaje.toString());
         */
        request.setAttribute("listar", consultabla);
        request.setAttribute("fechasistema", fechahoy);
        request.setAttribute("mensaje",razonsocial);
        request.getRequestDispatcher(ruta).forward(request, response);
    }

    private void consultafechasempresas(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Date hoy = new Date();
        String fechahoy = sdf.format(hoy);
        String ruta = "WEB-INF/calendario/listacalendario.jsp";
        int nit = Integer.parseInt(request.getParameter("codigo")); //Recibe el nit del formulario JSP
        System.out.println("El nit de la empresa es " + nit);
        int digitoverificacion = digitoempresa(nit);
        int codigo_empresa = codigoempresa(nit);
        System.out.println("El codigo de la empresa en la base de dato es: " + codigo_empresa);
        calendariotributario calendario = new calendariotributario();
        calendario.setNit(codigo_empresa);
        List<calendariotributario> listaempresa = new calendariotributarioDAO().agendaempresascalendario1(calendario);
        request.setAttribute("listar", listaempresa);
        String razonsocial = buscar_razonsocial_por_nit(nit);
        request.setAttribute("razon", razonsocial);
        for (calendariotributario l : listaempresa) {
            System.out.println("la lista es: " + l);
        }

        String fechatabla = listaempresa.get(0).getFecha();
        System.out.println("la fecha de hoy es: " + fechahoy + "\n y la fecha de la consulta es: " + fechatabla);
        try {
            long dif = metodosfechas(fechahoy, fechatabla);
            System.out.println("la fecha es: " + dif);
        } catch (Exception e) {
            System.out.println(e);
        }
        consulta consul = new consulta();
        consul.setNit(nit);
        List<consulta> listaconsulta = new consultaDAO().select2(consul);
        for (consulta c : listaconsulta) {
            System.out.println("--- Consulta especial -----\n" + c + "\n---");
        }
        for (int i = 0; i < listaconsulta.size(); i++) {
            listaconsulta.get(i).getEstado();
            if ("null".equals(listaconsulta.get(i).getEstado())) {
                listaconsulta.get(i).setEstado("se encuentra vacio");
            } else {
                listaconsulta.get(i).setEstado("por vacio");
            }
            System.out.println("el estado es: " + listaconsulta.get(i).getEstado());
            String anuncio = "null".equals(listaconsulta.get(i).getEstado()) ? ("vacio") : ("completado");
        }

        for (consulta c : listaconsulta) {
            System.out.println(c);
        }
        //################ Aquí inicia la prueba del la consulta
        System.out.println("Esta es una prueba: ****----****: " + listaconsulta.get(0).getFecha());
        fechatabla = listaconsulta.get(0).getFecha();

        try {
            long dif;
            consulta con = new consulta();
            for (consulta c : listaconsulta) {
                fechatabla = c.getFecha();
                dif = convertirfechas(fechahoy, fechatabla);
                if (dif < 0) {
                    System.out.println("la fecha esta pasada por: " + dif);
                    c.setEstado("Fuera de la fecha");
                } else {
                    System.out.println("Esta vigente....");
                    c.setEstado("No ha llegado la fecha !!!!!");
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        

        //################ Aquí termina la prueba del la consulta
        request.setAttribute("listar", listaconsulta);
        String fechasistema = fechatabla;
        request.setAttribute("fechasistema", fechahoy);
        request.getRequestDispatcher(ruta).forward(request, response);
    }

    private void agendaempresa(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    /*
    Este metodo consiste en convertir las fechas del cual son tipo de String,
    las fechas provienen de las consulta que se les haga a la base de datos; el 
    tipo de dato que retorno es long.
     */
    public long metodosfechas(String fechainicio, String fechafin) throws ParseException {
//        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/MM/dd", Locale.ENGLISH);
        Date firstDate = sdf.parse(fechainicio);
        Date secondDate = sdf.parse(fechafin);
        long diff = secondDate.getTime() - firstDate.getTime();
        TimeUnit time = TimeUnit.DAYS;
        long diferencia = time.convert(diff, TimeUnit.MILLISECONDS);
//        System.out.println("The diferencia en días es: " + diferencia);
        Date hoy = new Date();
//        System.out.println("la fecha de hoy es: " + hoy);
        String fecha = sdf.format(hoy);
//        System.out.println("la fecha en formato es: " + fecha);
        return diferencia;
    }

    private int digitoempresa(int nit) {
        empresa em = new empresa();
        em.setNit(nit);
        em = new empresaDAO().find_codigo_empresa_por_nit(em);
        return em.getCodigo();
    }

    private int codigoempresa(int codigoempresa) {
        empresa em = new empresa();
        em.setNit(codigoempresa);
        em = new empresaDAO().find_codigo_empresa_por_nit(em);
        System.out.println("codigo buscado en el metodo es: " + em.getCodigo());
        return em.getCodigo();
    }

    private String buscar_razonsocial_por_nit(int nit) {
        empresa em = new empresa();
        em.setNit(nit);
        em = new empresaDAO().encontrar(em);
        return em.getRazonsocial();
    }

    public long CalcularFechas(String fechaprimera, String fechaultima) throws ParseException {
//        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
        Date firstDate = sdf.parse(fechaprimera);
        Date secondDate = sdf.parse(fechaultima);
        long diff = secondDate.getTime() - firstDate.getTime();
        TimeUnit time = TimeUnit.DAYS;
        long diferencia = time.convert(diff, TimeUnit.MILLISECONDS);
        System.out.println("The diferencia en días es: " + diferencia);
        Date hoy = new Date();
        System.out.println("la fecha de hoy es: " + hoy);
        String fecha = sdf.format(hoy);
        System.out.println("la fecha en formato es: " + fecha);
        return diferencia;
    }

    public long convertirfechas(String fechaprimera, String fechaultima) throws ParseException {
//        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
        Date firstDate = sdf.parse(fechaprimera);
        Date secondDate = sdf.parse(fechaultima);
        long diff = secondDate.getTime() - firstDate.getTime();
        TimeUnit time = TimeUnit.DAYS;
        long diferencia = time.convert(diff, TimeUnit.MILLISECONDS);
        System.out.println("The diferencia en días es: " + diferencia);
        Date hoy = new Date();
        System.out.println("la fecha de hoy es: " + hoy);
        String fecha = sdf.format(hoy);
        System.out.println("la fecha en formato es: " + fecha);
        return diferencia;
    }

    public void correosaliente(String mensaje) {
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "mail.tpdindustrial.co");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        // Datos de autenticación
        final String username = "miguel.arango@tpdindustrial.co";
        final String password = "miguel12402047";
//        final String usuariocorreo = usuario;
//        final String clave = pass;

        // Crear una sesión con autenticación
        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
//            return new PasswordAuthentication(usuariocorreo,clave);
            }
        });

        try {
            // Crear el mensaje de correo
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("miguel.arango@tpdindustrial.co"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("arcadio37@gmail.com,miguelarango3777@hotmail.com"));
            message.setSubject("Prueba para el envio de correos desde java");
            message.setText("El mensaje desde la clase prueba es: \n" + mensaje);

            // Enviar el mensaje
            Transport.send(message);

            System.out.println("Correo enviado exitosamente.");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }


}
