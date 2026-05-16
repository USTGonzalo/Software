package Models;

public class Software {

    private int idSoftware;
    private String nombre;

    public Software() {
    }

    public Software(int idSoftware, String nombre) {
        this.idSoftware = idSoftware;
        this.nombre = nombre;
    }

    public int getIdSoftware() {
        return idSoftware;
    }

    public void setIdSoftware(int idSoftware) {
        this.idSoftware = idSoftware;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return idSoftware + " | " + nombre;
    }
}