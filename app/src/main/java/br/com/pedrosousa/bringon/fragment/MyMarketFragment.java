package br.com.pedrosousa.bringon.fragment;

import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.lang.ref.WeakReference;

import br.com.pedrosousa.bringon.R;
import br.com.pedrosousa.bringon.utils.BrPhoneNumberFormatter;
import br.com.pedrosousa.bringon.widget.IconTextInputLayout;
import butterknife.ButterKnife;

/**
 * Created by pedrohenrique on 30/06/16.
 */
public class MyMarketFragment extends BaseNavFragment{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_my_market, container, false);
        unbinder = ButterKnife.bind(this, v);
        init(v);
        return v;
    }

    private void init(View v){
        getNavActivity().getSupportActionBar().setTitle(R.string.my_market);

        IconTextInputLayout inputName = (IconTextInputLayout) v.findViewById(R.id.input_name);
        IconTextInputLayout inputEmail = (IconTextInputLayout) v.findViewById(R.id.input_email);
        IconTextInputLayout inputPhone = (IconTextInputLayout) v.findViewById(R.id.input_phone);

        inputName.getEditText().setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_FLAG_CAP_WORDS);
        inputEmail.getEditText().setInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
        inputPhone.getEditText().setInputType(InputType.TYPE_CLASS_PHONE);

        BrPhoneNumberFormatter addLineNumberFormatter = new BrPhoneNumberFormatter(new WeakReference<EditText>(inputPhone.getEditText()));
        inputPhone.getEditText().addTextChangedListener(addLineNumberFormatter);
    }
}
