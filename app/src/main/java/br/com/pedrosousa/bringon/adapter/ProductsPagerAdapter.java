package br.com.pedrosousa.bringon.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import br.com.pedrosousa.bringon.fragment.ListProductsFragment;

/**
 * Created by pedro on 05/07/2016.
 */
public class ProductsPagerAdapter  extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public ProductsPagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                ListProductsFragment tab1 = new ListProductsFragment();
                return tab1;
            case 1:
                ListProductsFragment tab2 = new ListProductsFragment();
                return tab2;
            case 2:
                ListProductsFragment tab3 = new ListProductsFragment();
                return tab3;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
