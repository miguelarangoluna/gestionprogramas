package test;

public class test7 {

    public static void main(String[] args) {
        eventothread evento = new eventothread();
        eventothread1 consulta = new eventothread1();
        eventothread2 consulta2 = new eventothread2();
        eventothread3 evento3 =new eventothread3();
        consulta.start();
        consulta2.start();
        Thread subproceso = new Thread(evento);
        subproceso.start();
        
        try{
            Thread.sleep(5000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        evento3.detener();
//        Thread sudproceso = new Thread(evento);
//        sudproceso.start();
        consulta2.detener();
        
//        for (int i = 0; i <= 10; i++) {
//            System.out.println("En la posicion: "+i);
//            try {
//                Thread.sleep(4000);
//            } catch (InterruptedException e) {
//                System.out.println("Error: " + e);
//            }
//        }
        
        
    }
}
