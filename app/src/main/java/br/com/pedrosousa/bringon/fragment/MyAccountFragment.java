package br.com.pedrosousa.bringon.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.pedrosousa.bringon.R;
import butterknife.ButterKnife;

/**
 * Created by pedrohenrique on 01/07/16.
 */
public class MyAccountFragment extends BaseNavFragment{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_my_account, container, false);
        unbinder = ButterKnife.bind(this, v);
        init();
        return v;
    }

    private void init(){
        getNavActivity().getSupportActionBar().setTitle(R.string.my_account);

    }
}
