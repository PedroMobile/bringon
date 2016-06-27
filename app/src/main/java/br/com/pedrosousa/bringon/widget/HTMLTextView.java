package br.com.pedrosousa.bringon.widget;

import android.content.Context;
import android.text.Html;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by pedro on 26/06/2016.
 */
public class HTMLTextView extends TextView {
    public HTMLTextView(Context context) {
        super(context);
        init();
    }

    public HTMLTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public HTMLTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        setText(Html.fromHtml(getText().toString()));
    }
}
