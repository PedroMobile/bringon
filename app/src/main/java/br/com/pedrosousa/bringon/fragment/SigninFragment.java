package br.com.pedrosousa.bringon.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.crash.FirebaseCrash;

import br.com.pedrosousa.bringon.NavigationActivity;
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
public class SigninFragment extends Fragment {

    private Unbinder unbinder;
    private String TAG = "SIGNIN_FRAGMENT";

    @BindView(R.id.edt_email)
    EditText email;

    @BindView(R.id.edt_senha)
    EditText senha;

    FirebaseAuth firebaseAuth;

    private String user, password;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_signin, container, false);
        unbinder = ButterKnife.bind(this, v);
        firebaseAuth = FirebaseAuth.getInstance();
        return v;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    private void setUser(){
        user = email.getText().toString();
        password = senha.getText().toString();
    }

    @OnClick(R.id.btn_signin)
    public void signin() {
        setUser();
        if(user != null && password != null) {
            firebaseAuth.signInWithEmailAndPassword(user, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Intent intent = new Intent(getActivity(), NavigationActivity.class);
                        startActivity(intent);
                        Log.i(TAG, "SIGN IN");
                    }
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    FirebaseCrash.report(e);
                    Toast.makeText(getActivity(), e.getMessage().toString(), Toast.LENGTH_LONG).show();
                }
            });
        }
    }

    @OnClick(R.id.btn_facebook)
    public void signinFacebook() {
        Log.i(TAG, "SIGN IN Facebook");
    }

    @OnClick(R.id.txt_signup)
    public void openSignup() {
        SigninSignupActivity activity = (SigninSignupActivity) getActivity();
        activity.openFragment(new SignupFragment());
    }



}
