package br.com.pedrosousa.bringon.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import br.com.pedrosousa.bringon.R;
import br.com.pedrosousa.bringon.SigninSignupActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by pedro on 26/06/2016.
 */
public class SignupFragment extends Fragment {

    private Unbinder unbinder;
    private String TAG = "SIGNIN_FRAGMENT";

    @BindView(R.id.edt_email)
    EditText edt_email;

    @BindView(R.id.edt_nome)
    EditText edt_nome;

    @BindView(R.id.edt_senha)
    EditText edt_senha;

    

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_signup, container, false);
        unbinder = ButterKnife.bind(this, v);

        email = edt_email.getText().toString();
        nome = edt_nome.getText().toString();
        senha = edt_senha.getText().toString();

        return v;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.btn_signup)
    public void signup() {
        Log.i(TAG, "SIGN UP");
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
