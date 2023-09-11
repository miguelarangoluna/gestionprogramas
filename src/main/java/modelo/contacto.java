package modelo;


public class contacto {
    int cedula,cod_nit,celular;
    String nombre,apellido;

    public contacto() {
    }

    public contacto(int cedula, int cod_nit, int celular, String nombre, String apellido) {
        this.cedula = cedula;
        this.cod_nit = cod_nit;
        this.celular = celular;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public int getCod_nit() {
        return cod_nit;
    }

    public void setCod_nit(int cod_nit) {
        this.cod_nit = cod_nit;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return "contacto{" + "cedula=" + cedula + ", cod_nit=" + cod_nit + ", celular=" + celular + ", nombre=" + nombre + ", apellido=" + apellido + '}';
    }
    
}
