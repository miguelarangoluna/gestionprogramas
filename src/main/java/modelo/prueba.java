/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.Date;

/**
 *
 * @author miguelarcadioarangoluna
 */
public class prueba {
    private int codigo;
    private String fecha;
    private String fecha1;
    private String fecha2;

    public prueba() {
    }

    public prueba(int codigo, String fecha, String fecha1, String fecha2) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.fecha1 = fecha1;
        this.fecha2 = fecha2;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getFecha1() {
        return fecha1;
    }

    public void setFecha1(String fecha1) {
        this.fecha1 = fecha1;
    }

    public String getFecha2() {
        return fecha2;
    }

    public void setFecha2(String fecha2) {
        this.fecha2 = fecha2;
    }

    @Override
    public String toString() {
        return "prueba{" + "codigo=" + codigo + ", fecha=" + fecha + ", fecha1=" + fecha1 + ", fecha2=" + fecha2 + '}';
    }
    
}
