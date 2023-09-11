package modelo;

public class usuario {
    private String user;
    private String estado;
    private String contrasena;
    private int codigo;

    public usuario() {
    }

    public usuario(String user, String estado, int codigo) {
        this.user = user;
        this.estado = estado;
        this.codigo = codigo;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "usuario{" + "user=" + user + ", estado=" + estado + ", contrasena=" + contrasena + ", codigo=" + codigo + '}';
    }

    
}
