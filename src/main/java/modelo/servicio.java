package modelo;

public class servicio {

    int codigo, dig_verificacion;
    String service, fecha, descripcion,ciudad;

    public servicio() {
    }

    public servicio(int codigo, int dig_verificacion, String service, String fecha, String descripcion, String ciudad) {
        this.codigo = codigo;
        this.dig_verificacion = dig_verificacion;
        this.service = service;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.ciudad = ciudad;
    }

    public servicio(int dig_verificacion, String service, String fecha, String descripcion, String ciudad) {
        this.dig_verificacion = dig_verificacion;
        this.service = service;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.ciudad = ciudad;
    }

    public servicio(String fecha, String descripcion, String ciudad) {
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.ciudad = ciudad;
    }

    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getDig_verificacion() {
        return dig_verificacion;
    }

    public void setDig_verificacion(int dig_verificacion) {
        this.dig_verificacion = dig_verificacion;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public String toString() {
        return "servicio{" + "codigo=" + codigo + ", dig_verificacion=" + dig_verificacion + ", service=" + service + ", fecha=" + fecha + ", descripcion=" + descripcion + ", ciudad=" + ciudad + '}';
    }

    
    
    

}
