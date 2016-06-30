package br.com.pedrosousa.bringon.modal;

/**
 * Created by pedro on 26/06/2016.
 */
public class User {
    private String email;
    private String senha;
    private String tipoUser;

    public User() {
        
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTipoUser() {
        return tipoUser;
    }

    public void setTipoUser(String tipoUser) {
        this.tipoUser = tipoUser;
    }
}
