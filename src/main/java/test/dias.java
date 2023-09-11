package test;

public enum dias {
    DOMINGO(1),LUNES(2),MARTES(3),MIERCOLES(4),JUEVES(5),VIERNES(6),SABADO(7);

    private final int DIAS;

    public int getDIAS() {
        return this.DIAS;
    }
    
    dias(int dia){
        this.DIAS=dia;
    }
}
