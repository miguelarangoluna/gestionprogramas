package modelo;

public class agregaservicio {

    int digitoverificacion, item,diarecordar;
    String fecha,descripcion;

    public agregaservicio() {
    }

    public agregaservicio(int item, String fecha) {
        this.item = item;
        this.fecha = fecha;
    }

    public agregaservicio(int digitoverificacion, int item, String fecha) {
        this.digitoverificacion = digitoverificacion;
        this.item = item;
        this.fecha = fecha;
    }

    public int getDigitoverificacion() {
        return digitoverificacion;
    }

    public int getDiarecordar() {
        return diarecordar;
    }

    public void setDiarecordar(int diarecordar) {
        this.diarecordar = diarecordar;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setDigitoverificacion(int digitoverificacion) {
        this.digitoverificacion = digitoverificacion;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "agregaservicio{" + "digitoverificacion=" + digitoverificacion + ", item=" + item + ", diarecordar=" + diarecordar + ", fecha=" + fecha + ", descripcion=" + descripcion + '}';
    }


}
