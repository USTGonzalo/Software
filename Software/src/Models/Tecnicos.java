/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author usuario
 */
public class Tecnicos {

    private int idTecnico;
    private String user;
    private boolean isAdmin;

    public Tecnicos(int idTecnico, String user, boolean isAdmin) {
        this.idTecnico = idTecnico;
        this.user = user;
        this.isAdmin = isAdmin;
    }

    public Tecnicos() {
    }

    public int getIdTecnico() {
        return idTecnico;
    }

    public void setIdTecnico(int idTecnico) {
        this.idTecnico = idTecnico;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public boolean IsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    @Override
    public String toString() {
        return "Id del tecnico: " + idTecnico + " Usuario: " + user;
    }
}
