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
 * Created by pedro on 02/07/2016.
 */
public class RowView extends RelativeLayout{

    LayoutInflater mInflater;

    public RowView(Context context) {
        super(context);

        init(context);
    }

    public RowView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public RowView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public RowView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs);
    }

    private void init(Context context){
        mInflater = LayoutInflater.from(context);

        View v = mInflater.inflate(R.layout.view_row, this, true);

    }

    private void init(Context context, AttributeSet attrs){
        mInflater = LayoutInflater.from(context);
        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.RowView,
                0, 0);



        View v = mInflater.inflate(R.layout.view_row, this, true);
        TextView txtTitle = (TextView) v.findViewById(R.id.txt_title);
        ImageView icon = (ImageView) v.findViewById(R.id.icon);
        try {
            String label = a.getString(R.styleable.RowView_label);
            int id_img = a.getResourceId(R.styleable.RowView_icon_row, R.mipmap.ic_account_black_24dp);
            txtTitle.setText(label);
            icon.setImageResource(id_img);
        } finally {
            a.recycle();
        }


    }
}
