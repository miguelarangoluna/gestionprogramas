package modelo;


//@Data
public class calendariotributario {
    int codigo,digito_verificacion,cod_servicio,diarecordar,nit,item;
    String fecha,descripcion,razonsocial;

    public calendariotributario() {
    }

    public int getNit() {
        return nit;
    }

    public void setNit(int nit) {
        this.nit = nit;
    }

    
    
    public calendariotributario(int codigo, int digito_verificacion, int cod_servicio, String fecha) {
        this.codigo = codigo;
        this.digito_verificacion = digito_verificacion;
        this.cod_servicio = cod_servicio;
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    
    public int getCodigo() {
        return codigo;
    }

    public String getRazonsocial() {
        return razonsocial;
    }

    public void setRazonsocial(String razonsocial) {
        this.razonsocial = razonsocial;
    }

    
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getDigito_verificacion() {
        return digito_verificacion;
    }

    public void setDigito_verificacion(int digito_verificacion) {
        this.digito_verificacion = digito_verificacion;
    }

    public int getCod_servicio() {
        return cod_servicio;
    }

    public void setCod_servicio(int cod_servicio) {
        this.cod_servicio = cod_servicio;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getDiarecordar() {
        return diarecordar;
    }

    public void setDiarecordar(int diarecordar) {
        this.diarecordar = diarecordar;
    }

    @Override
    public String toString() {
        return "calendariotributario{" + "codigo=" + codigo + ", digito_verificacion=" + digito_verificacion + ", cod_servicio=" + cod_servicio + ", diarecordar=" + diarecordar + ", nit=" + nit + ", item=" + item + ", fecha=" + fecha + ", descripcion=" + descripcion + ", razonsocial=" + razonsocial + '}';
    }



    
}
