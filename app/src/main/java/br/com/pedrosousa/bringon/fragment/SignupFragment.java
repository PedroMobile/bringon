package br.com.pedrosousa.bringon.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.gms.signin.internal.SignInResponse;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;

import br.com.pedrosousa.bringon.R;
import br.com.pedrosousa.bringon.SigninSignupActivity;
import br.com.pedrosousa.bringon.modal.User;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by pedro on 26/06/2016.
 */
public class SignupFragment extends Fragment implements DatabaseReference.CompletionListener {

    private Unbinder unbinder;
    private String TAG = "SIGNIN_FRAGMENT";

    private FirebaseAuth auth;
    private FirebaseAuth.AuthStateListener authStateListener;

    @BindView(R.id.edt_email)
    EditText edt_email;

    @BindView(R.id.edt_nome)
    EditText edt_nome;

    @BindView(R.id.edt_senha)
    EditText edt_senha;

    @BindView(R.id.radio_cliente)
    RadioButton radio_cliente;

    @BindView(R.id.radio_store)
    RadioButton radio_store;

    private User user;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_signup, container, false);
        unbinder = ButterKnife.bind(this, v);

        user = new User();

        auth = FirebaseAuth.getInstance();
        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();

                if(firebaseUser == null || user.getId() != null){
                    return;
                }
                user.setId(firebaseUser.getUid());
                user.saveBd(SignupFragment.this);
            }
        };



        return v;
    }
    @Override
    public void onStop(){
        super.onStart();
        if(authStateListener != null){
            auth.removeAuthStateListener(authStateListener);
        }
    }

    @Override
    public void onStart(){
        super.onStart();
        auth.addAuthStateListener(authStateListener);
    }

    private void saveUser(){
        user.setEmail(edt_email.getText().toString());
        user.setNome(edt_nome.getText().toString());
        user.setSenha(edt_senha.getText().toString());
        if(radio_cliente.isChecked()){
            user.setTipoUser(radio_cliente.getText().toString());
        }else {
            user.setTipoUser(radio_store.getText().toString());
        }

    }

    private void createUserWithEmailAndPassword(){
        saveUser();
        auth.createUserWithEmailAndPassword(user.getEmail(), user.getSenha()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(!task.isSuccessful()){

                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
        auth.signOut();
        Toast.makeText(getActivity(), getResources().getString(R.string.conta_criada), Toast.LENGTH_LONG).show();
        getActivity().getFragmentManager().popBackStack();
    }


    @OnClick(R.id.btn_signup)
    public void signup() {
        Log.i(TAG, "SIGN UP");
        createUserWithEmailAndPassword();
    }

    @OnClick(R.id.btn_signup_facebook)
    public void signupFacebook() {
        Log.i(TAG, "SIGN UP Facebook");
    }

    @OnClick(R.id.txt_go_signin)
    public void goSignin() {
        SigninSignupActivity activity = (SigninSignupActivity) getActivity();
        activity.openFragment(new SigninFragment());
    }
}
