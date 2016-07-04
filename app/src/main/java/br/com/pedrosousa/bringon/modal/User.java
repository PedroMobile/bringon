package br.com.pedrosousa.bringon.modal;

import com.google.firebase.database.DatabaseReference;

import br.com.pedrosousa.bringon.services.FirebaseManager;

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

    public void saveBd(DatabaseReference.CompletionListener... listener){
        DatabaseReference firebase = FirebaseManager.getDatabaseReference();

        if(listener.length == 0){
            firebase.setValue(this);
        }
        else{
            firebase.setValue(this, listener[0]);
        }

    }

}
