package br.com.pedrosousa.bringon.fragment;

import android.support.v4.app.Fragment;

import br.com.pedrosousa.bringon.NavigationActivity;
import butterknife.Unbinder;

/**
 * Created by pedrohenrique on 29/06/16.
 */
public class BaseNavFragment extends Fragment {

    protected Unbinder unbinder;

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    protected NavigationActivity getNavActivity(){
        return (NavigationActivity)getActivity();
    }

}
