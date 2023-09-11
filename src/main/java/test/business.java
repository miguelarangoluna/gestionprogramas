package test;
import modelo.*;

public class business {
    String razonsocial;
    String direccion;
    int nit;

    public business() {
    }

    public String getRazonsocial() {
        return razonsocial;
    }

    public void setRazonsocial(String razonsocial) {
        this.razonsocial = razonsocial;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getNit() {
        return nit;
    }

    public void setNit(int nit) {
        this.nit = nit;
    }

    @Override
    public String toString() {
        return "business{" + "razonsocial=" + razonsocial + ", direccion=" + direccion + ", nit=" + nit + '}';
    }


    
    
}
