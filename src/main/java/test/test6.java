package test;
import java.util.List;
import modeloDAO.*;

public class test6 {
    public static void main(String[] args) {
        consulta oc = new consulta();
        oc.setNit(901038244);
        List<consulta> consulta = new consultaDAO().select2(oc);
        for(consulta con :consulta){
            System.out.println(con);
        }
    }
}
