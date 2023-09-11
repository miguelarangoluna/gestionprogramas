package modelo;

public class empresa {
    int nit,digitoverificacion,telefono,codigo;
    String razonsocial,fecha,direccion;

    public empresa() {
    }

    public empresa(int nit){
        this.nit = nit;
    }
    public empresa(int nit, int digitoverificacion, int telefono, String razonsocial, String fecha, String direccion) {
        this.nit = nit;
        this.digitoverificacion = digitoverificacion;
        this.telefono = telefono;
        this.razonsocial = razonsocial;
        this.fecha = fecha;
        this.direccion = direccion;
    }

    public int getNit() {
        return nit;
    }

    public void setNit(int nit) {
        this.nit = nit;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getDigitoverificacion() {
        return digitoverificacion;
    }

    public void setDigitoverificacion(int digitoverificacion) {
        this.digitoverificacion = digitoverificacion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getRazonsocial() {
        return razonsocial;
    }

    public void setRazonsocial(String razonsocial) {
        this.razonsocial = razonsocial;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "empresa{" + "nit=" + nit + ", digitoverificacion=" + digitoverificacion + ", telefono=" + telefono + ", codigo=" + codigo + ", razonsocial=" + razonsocial + ", fecha=" + fecha + ", direccion=" + direccion + '}';
    }

    
}
