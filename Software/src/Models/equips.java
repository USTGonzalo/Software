package Models;

public class equips {

    private int idEquipo;
    private String modelo;
    private String numeroSerie;

    public equips() {
    }

    public equips(int idEquipo, String modelo, String numeroSerie) {
        this.idEquipo = idEquipo;
        this.modelo = modelo;
        this.numeroSerie = numeroSerie;
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    @Override
    public String toString() {

        return idEquipo + " | "
                + modelo + " | "
                + numeroSerie;
    }
}