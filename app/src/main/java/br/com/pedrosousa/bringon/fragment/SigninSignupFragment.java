package br.com.pedrosousa.bringon.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.pedrosousa.bringon.R;
import br.com.pedrosousa.bringon.SigninSignupActivity;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by pedro on 26/06/2016.
 */
public class SigninSignupFragment extends Fragment {

    private Unbinder unbinder;
    public static String TAG = "SigninSignup";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_signin_signup, container, false);
        unbinder = ButterKnife.bind(this, v);

        return v;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.btn_login)
    public void login() {
        SigninSignupActivity activity = (SigninSignupActivity) getActivity();
        activity.openFragment(new SigninFragment());
    }

    @OnClick(R.id.btn_signup)
    public void signup() {
        SigninSignupActivity activity = (SigninSignupActivity) getActivity();
        activity.openFragment(new SignupFragment());
    }
}
