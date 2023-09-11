package test;

import java.util.List;
import modeloDAO.consultaDAO;

public class eventothread2 extends Thread {

    public volatile boolean estado = true;

    public eventothread2() {
        this.estado = true;
    }

    public void detener() {
        this.estado = false;
    }

    public void run() {
        while (estado) {
            consulta con = new consulta();
            con.setNit(901330424);
            List<consulta> listaconsulta = new consultaDAO().select2(con);
            for (consulta c : listaconsulta) {
                System.out.println("La lista es: " + c);
            }
            try {
                Thread.sleep(60000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Ha terminado la consulta en la base de datos");
    }

}
