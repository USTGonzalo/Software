package Models;

public class Pieza {

    private int idPieza;
    private String nombre;

    public Pieza() {
    }

    public Pieza(int idPieza, String nombre) {
        this.idPieza = idPieza;
        this.nombre = nombre;
    }

    public int getIdPieza() {
        return idPieza;
    }

    public void setIdPieza(int idPieza) {
        this.idPieza = idPieza;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}