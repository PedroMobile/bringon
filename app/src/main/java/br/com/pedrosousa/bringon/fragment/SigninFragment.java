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
public class SigninFragment extends Fragment {

    private Unbinder unbinder;
    private String TAG = "SIGNIN_FRAGMENT";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_signin, container, false);
        unbinder = ButterKnife.bind(this, v);

        return v;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.btn_signin)
    public void signin() {
        Log.i(TAG, "SIGN IN");
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
