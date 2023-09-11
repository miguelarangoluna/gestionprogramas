package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import modeloDAO.*;
import modelo.*;

public class test1 {

    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd",Locale.ENGLISH);
    static long consultadia;
    public static void main(String[] args) {
//        AÑO-MES-DIA
//        (int nit, int digitoverificacion, int telefono, String razonsocial, String fecha, String direccion)
//        empresa e = new empresa(802901238,8,3851884,"INDUTRONICA DEL CARIBE","2023-12-23","Carrera 46#80-74");
//        int registrar = new empresaDAO().insert(e);
//int dig_verificacion, String service, String fecha, String descripcion, String ciudad
//        servicio se = new servicio(4, "Renta grandes contribuyentes", "2023-12-20", "empresa", "Barranquilla");
//        int s = new servicioDAO().insert(se);
//(int cod_servicio, int cod_nit, int diarecordar)
//        registrar r = new registrar();
//        r.setCod_empresa(1);
//        r.setCod_servicio(1);
//        r.setDiarecordar(7);
//        int insertaregistro = new registrarDAO().insert(r);
        List<registrar> listare=new registrarDAO().select();
        for (registrar registrarlista :listare){
            System.out.println(registrarlista);
        }
        List<empresa> lista = new empresaDAO().select();

        for (empresa em : lista) {
            System.out.println(em);
        }

        List<servicio> listas = new servicioDAO().select();
        for (servicio ser : listas) {
            System.out.println(ser);
        }
        
        Date hoy = new Date();
        String fechaservicio = sdf.format(hoy);
        System.out.println("la fecha convertidad es "+fechaservicio);
//        String fechaserviciofinal = sdf.format(listas.get())
        
        String fechainicio = listas.get(1).getFecha();
        System.out.println("la lista en la posicion 1 es: "+listas.get(1).getFecha());
        System.out.println(fechaservicio+"---"+fechainicio);
        try{
            long diferencia = metodosfechas(fechaservicio,fechainicio);
            consultadia=diferencia;
        }catch(Exception e){
            System.out.println("El erro es: "+e);
        }
        
        if(consultadia<=listare.get(0).getDiarecordar()){
            System.out.println("Esta por vencer");
        }else{
            System.out.println("Aun a tiempo");
        }

    }
    
    public static long metodosfechas(String fechainicio, String fechafin) throws ParseException{
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/MM/dd", Locale.ENGLISH);
        Date firstDate = sdf.parse(fechainicio);
        Date secondDate = sdf.parse(fechafin);
        long diff = secondDate.getTime() - firstDate.getTime();
        TimeUnit time = TimeUnit.DAYS; 
        long diferencia = time.convert(diff, TimeUnit.MILLISECONDS);
        System.out.println("The diferencia en días es: "+diferencia);
        Date hoy = new Date();
        System.out.println("la fecha de hoy es: "+hoy);
        String fecha = sdf.format(hoy);
        System.out.println("la fecha en formato es: "+fecha);
        return diferencia;
    }
}
