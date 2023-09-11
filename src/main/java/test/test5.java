package test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.*;
import modeloDAO.*;

public class test5 {

    public static void main(String[] args) {
        enviocorreo correo = new enviocorreo();
        String mensaje;
//        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd-HH-mm-ss");
//        
//        Date fecha = new Date();
//        
//        String fechahoy = sdf.format(fecha);
//        
//        prueba pr = new prueba();
//        
//        pr.setFecha(JOptionPane.showInputDialog(null,"Digite la fecha: "));    
//        
//        System.out.println("la fecha1 es: "+fechahoy);
//        
//        pr.setFecha1(fechahoy);
//        
//        pr.setFecha2(JOptionPane.showInputDialog(null,"Digite la fecha2"));
//        
//        int insertarfecha = new pruebaDAO().insert(pr);

        List<prueba> listaprueba = new pruebaDAO().select();
        mensaje ="la informacion de la consulta es: \n";
        for (prueba pre : listaprueba) {
            System.out.println("los datos son: " + pre);
            mensaje=pre.getFecha()+mensaje;
        }
        System.out.println(mensaje);
        correo.correosaliente(mensaje);
        System.out.println("la fecha es: "+listaprueba.get(0).getFecha1());

        restarhora1(11,10);
        String fini = listaprueba.get(1).getFecha1();
        String ffin = listaprueba.get(1).getFecha1();
        
        System.out.println("la fecha es:--- "+fini+" y "+ffin);
        int suma = descomprimirfecha(fini);
        
        
        
        
        
    }

    public static void restarhora() {
        Calendar cal = Calendar.getInstance();
        int horainicial = cal.get(Calendar.HOUR_OF_DAY);
        int horafin = cal.get(Calendar.MINUTE);
        cal.add(Calendar.HOUR_OF_DAY, -1);
        System.out.println("la hora es: " + cal.get(Calendar.HOUR_OF_DAY));
    }

    public static void restarhora1(int hora_ini, int hora_fin) {
        Calendar cal = Calendar.getInstance();
        int horainicial = hora_ini;
        int horafin = hora_fin;
        cal.add(horainicial,horafin);
        System.out.println("la hora es: " + cal.get(Calendar.HOUR_OF_DAY));
    }
    
    public static int descomprimirfecha (String fecha){
        String fechatodo = fecha;
        System.out.println("la fecha dentro del metodo es: "+fechatodo);
        String [] fecha1 = fechatodo.split("-");
        System.out.println("la fecha recibida es: "+fecha);
        int horai = Integer.parseInt(fecha1[0]);
        System.out.println("en la posicion 0 es: "+horai);
        System.out.println("el tamaño es: "+fecha1.length);
        int horaf = Integer.parseInt(fecha1[2]);
        System.out.println("en la posicion 0 es: "+horaf);
        int suma = horai+horaf;
        System.out.println("la diferencia en hora es: "+suma);
        return suma;
    }
}
