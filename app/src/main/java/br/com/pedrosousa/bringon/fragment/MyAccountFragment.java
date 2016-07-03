package br.com.pedrosousa.bringon.fragment;

import android.os.Bundle;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.lang.ref.WeakReference;

import br.com.pedrosousa.bringon.R;
import br.com.pedrosousa.bringon.utils.BrPhoneNumberFormatter;
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
        init(v);
        return v;
    }

    private void init(View v){
        getNavActivity().getSupportActionBar().setTitle(R.string.my_account);

        EditText editPhone = (EditText) v.findViewById(R.id.edit_phone);
        BrPhoneNumberFormatter addLineNumberFormatter = new BrPhoneNumberFormatter(new WeakReference<EditText>(editPhone));
        editPhone.addTextChangedListener(addLineNumberFormatter);

    }
}
