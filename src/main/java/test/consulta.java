package test;


public class consulta {
    protected int nit,digito_verificacion,diarecordar;
    protected String fecha,razonsocial,descripcion;
    protected String estado;
    
    public consulta() {
    }

    public consulta(int nit, int digito_verificacion, int diarecordar, String fecha, String razonsocial, String descripcion) {
        this.nit = nit;
        this.digito_verificacion = digito_verificacion;
        this.diarecordar = diarecordar;
        this.fecha = fecha;
        this.razonsocial = razonsocial;
        this.descripcion = descripcion;
    }

    public int getNit() {
        return nit;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setNit(int nit) {
        this.nit = nit;
    }

    public int getDigito_verificacion() {
        return digito_verificacion;
    }

    public void setDigito_verificacion(int digito_verificacion) {
        this.digito_verificacion = digito_verificacion;
    }

    public int getDiarecordar() {
        return diarecordar;
    }

    public void setDiarecordar(int diarecordar) {
        this.diarecordar = diarecordar;
    }

    public String getFecha() { 
        return fecha;
    }
    

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getRazonsocial() {
        return razonsocial;
    }

    public void setRazonsocial(String razonsocial) {
        this.razonsocial = razonsocial;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "consulta{" + "nit=" + nit + ", digito_verificacion=" + digito_verificacion + ", diarecordar=" + diarecordar + ", fecha=" + fecha + ", razonsocial=" + razonsocial + ", descripcion=" + descripcion + ", estado=" + estado + '}';
    }

    
    
}
