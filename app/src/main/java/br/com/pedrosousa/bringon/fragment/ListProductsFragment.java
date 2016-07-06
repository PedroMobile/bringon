package br.com.pedrosousa.bringon.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.pedrosousa.bringon.R;

/**
 * Created by pedro on 05/07/2016.
 */
public class ListProductsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tab_products, container, false);
    }
}
