/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author miguelarcadio
 */
@WebServlet("/capturadatos")
public class controlcapturadatos extends HttpServlet{
    
    @Override
    protected void doGet (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        String accion = request.getParameter("accion");
        System.out.println("el nombre recibido es: "+accion);
        String latitud = request.getParameter("latitud");
        String longitud = request.getParameter("longitud");
        System.out.println("los datos recibidos son:"+latitud+" - "+longitud);
    }
}
