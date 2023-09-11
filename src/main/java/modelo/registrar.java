package modelo;


public class registrar {
    private int codigo,cod_empresa,cod_servicio,diarecordar;

    public registrar() {
    }

    public registrar(int codigo, int cod_servicio, int cod_empresa, int diarecordar) {
        this.codigo = codigo;
        this.cod_servicio = cod_servicio;
        this.cod_empresa = cod_empresa;
        this.diarecordar = diarecordar;
    }

    public registrar(int cod_servicio, int cod_empresa, int diarecordar) {
        this.cod_servicio = cod_servicio;
        this.cod_empresa = cod_empresa;
        this.diarecordar = diarecordar;
    }

    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCod_servicio() {
        return cod_servicio;
    }

    public void setCod_servicio(int cod_servicio) {
        this.cod_servicio = cod_servicio;
    }

    public int getCod_empresa() {
        return cod_empresa;
    }

    public void setCod_empresa(int cod_empresa) {
        this.cod_empresa = cod_empresa;
    }

    public int getDiarecordar() {
        return diarecordar;
    }

    public void setDiarecordar(int diarecordar) {
        this.diarecordar = diarecordar;
    }

    @Override
    public String toString() {
        return "registrar{" + "codigo=" + codigo + ", cod_empresa=" + cod_empresa + ", cod_servicio=" + cod_servicio + ", diarecordar=" + diarecordar + '}';
    }

  

    
}
