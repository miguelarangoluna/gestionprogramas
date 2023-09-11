package modelo;

import java.io.Serializable;


public class agenda implements Serializable {
    private int codigo,cod_servicio,cod_empresa,diarecordar;
    private String razonsocial,servicio;
    
    public agenda() {
    }

    public agenda(int codigo, int cod_servicio, int cod_empresa, int diarecordar) {
        this.codigo = codigo;
        this.cod_servicio = cod_servicio;
        this.cod_empresa = cod_empresa;
        this.diarecordar = diarecordar;
    }

    public agenda(int codigo) {
        this.codigo = codigo;
    }

    public agenda(int cod_servicio, int cod_empresa, int diarecordar) {
        this.cod_servicio = cod_servicio;
        this.cod_empresa = cod_empresa;
        this.diarecordar = diarecordar;
    }

    public String getRazonsocial() {
        return razonsocial;
    }

    public void setRazonsocial(String razonsocial) {
        this.razonsocial = razonsocial;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
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
        return "agenda{" + "codigo=" + codigo + ", cod_servicio=" + cod_servicio + ", cod_empresa=" + cod_empresa + ", diarecordar=" + diarecordar + ", razonsocial=" + razonsocial + ", servicio=" + servicio + '}';
    }

}
