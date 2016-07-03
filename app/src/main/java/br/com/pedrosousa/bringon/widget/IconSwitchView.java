package br.com.pedrosousa.bringon.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import br.com.pedrosousa.bringon.R;

/**
 * Created by pedro on 03/07/2016.
 */
public class IconSwitchView extends RelativeLayout {

    LayoutInflater mInflater;

    public IconSwitchView(Context context) {
        super(context);
        init(context);
    }

    public IconSwitchView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public IconSwitchView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public IconSwitchView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs);
    }

    private View init(Context context){
        mInflater = LayoutInflater.from(context);
        return mInflater.inflate(R.layout.view_icon_switch, this, true);
    }

    private void init(Context context, AttributeSet attrs){
        View v = init(context);
        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.IconSwitchView,
                0, 0);

        TextView txtTitle = (TextView) v.findViewById(R.id.txt_label);
        ImageView icon = (ImageView) v.findViewById(R.id.icon);
        try {
            String label = a.getString(R.styleable.IconSwitchView_isv_label);
            int id_img = a.getResourceId(R.styleable.IconSwitchView_isv_icon, R.mipmap.ic_account_grey600_24dp);
            txtTitle.setText(label);
            icon.setImageResource(id_img);
        } finally {
            a.recycle();
        }
    }
}
