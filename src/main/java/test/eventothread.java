package test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import modeloDAO.*;
import modelo.*;

public class eventothread implements Runnable {

    Date hoy = new Date();
    String fecha;
    SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
    consulta consul = new consulta();

    public eventothread() {
    }

    public eventothread(int nit) {
        consul.setNit(nit);
    }

    @Override
    public void run() {
        fecha = sdf.format(hoy);
        List<consulta> consultabla = new consultaDAO().select2(consul);
        for(consulta c: consultabla){
            System.out.println("los datos son: "+c);
        }
        System.out.println("Mensaje del eventothread es: \n" + fecha);
        List<consulta> listaconsulta = new consultaDAO().select2(consul);
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            System.out.println("Error: " + e);
        }
        System.out.println("ha finalizado el evento");
    }

}
