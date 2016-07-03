package br.com.pedrosousa.bringon.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import br.com.pedrosousa.bringon.R;

/**
 * Created by pedro on 03/07/2016.
 */
public class IconTextInputLayout  extends RelativeLayout {

    LayoutInflater mInflater;
    EditText editText;

    public IconTextInputLayout(Context context) {
        super(context);
        init(context);
    }

    public IconTextInputLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public IconTextInputLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public IconTextInputLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs);
    }

    private View init(Context context){
        mInflater = LayoutInflater.from(context);
        View v = mInflater.inflate(R.layout.view_icon_text_input, this, true);
        editText = (EditText) v.findViewById(R.id.txt);
        return v;
    }

    private void init(Context context, AttributeSet attrs){
        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.IconTextInputLayout,
                0, 0);

        View v = init(context);
        TextInputLayout txtInput = (TextInputLayout) v.findViewById(R.id.txt_input);

        ImageView icon = (ImageView) v.findViewById(R.id.icon);
        try {
            String label = a.getString(R.styleable.IconTextInputLayout_txt_hint);
            int id_img = a.getResourceId(R.styleable.IconTextInputLayout_icon_txt_input, R.mipmap.ic_account_black_24dp);
            txtInput.setHint(label);
            icon.setImageResource(id_img);
        } finally {
            a.recycle();
        }
    }

    public EditText getEditText() {
        return editText;
    }
}
