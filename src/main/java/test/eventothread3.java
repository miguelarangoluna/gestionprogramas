package test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class eventothread3 implements Runnable {

    public volatile boolean estado;
    
    SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
    
    String fecha;
    public eventothread3() {
        this.estado = true;
    }
    
    @Override
    public void run() {
        while (estado) {
            Date fechahoy = new Date();
            fecha = sdf.format(fechahoy);
            System.out.println("la fecha es: "+fecha);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Estado terminado");
    }

    
    
    public void detener(){
        this.estado=false;
    }
}
