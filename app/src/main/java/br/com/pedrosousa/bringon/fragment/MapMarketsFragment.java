package br.com.pedrosousa.bringon.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import br.com.pedrosousa.bringon.R;
import butterknife.ButterKnife;

/**
 * Created by pedrohenrique on 29/06/16.
 */
public class MapMarketsFragment extends BaseNavFragment implements OnMapReadyCallback {
    private String TAG = "MapMarketsFragment";
    MapFragment mapFragment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_map_markets, container, false);
        unbinder = ButterKnife.bind(this, v);
        init();
        return v;
    }

    private void init(){
        getNavActivity().getSupportActionBar().setTitle(R.string.markets);

        mapFragment = (MapFragment) getActivity().getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap map) {
        LatLng sydney = new LatLng(-33.867, 151.206);

        //map.setMyLocationEnabled(true);
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 13));

        map.addMarker(new MarkerOptions()
                .title("Sydney")
                .snippet("The most populous city in Australia.")
                .position(sydney));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        getActivity().getFragmentManager().beginTransaction()
                .remove(mapFragment).commit();
    }
}
