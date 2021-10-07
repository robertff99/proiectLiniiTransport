package server.Model;

public class Utilizator {
    private String username;
    private String parola;
    private String rol;

    @Override
    public String toString() {
        return
                " username='" + username + '\'' +
                ", parola='" + parola + '\'' +
                ", rol='" + rol + '\'';
    }

    public Utilizator(){}
    public Utilizator(String username, String parola, String rol) {
        this.username = username;
        this.parola = parola;
        this.rol = rol;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

}
