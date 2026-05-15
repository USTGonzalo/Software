package cache;

public class CacheTecnicos {

    public int idTecnico;
    private String user;
    private String password;
    private boolean admin;

    public CacheTecnicos(int aInt, String string, boolean aBoolean) {
    }

    public CacheTecnicos(int idTecnico, String user, String password, boolean admin) {
        this.idTecnico = idTecnico;
        this.user = user;
        this.password = password;
        this.admin = admin;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

}
