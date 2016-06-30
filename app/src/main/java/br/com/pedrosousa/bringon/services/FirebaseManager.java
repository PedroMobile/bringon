package br.com.pedrosousa.bringon.services;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by pedro on 26/06/2016.
 */
public class FirebaseManager {

    public static String PREF = "br.com.pedrosousa.bringon";
    private static DatabaseReference databaseReference;

    private FirebaseManager(){}

    public static DatabaseReference getDatabaseReference(){
        if(databaseReference == null){
            databaseReference = FirebaseDatabase.getInstance().getReference();
        }
        return databaseReference;
    }


}
