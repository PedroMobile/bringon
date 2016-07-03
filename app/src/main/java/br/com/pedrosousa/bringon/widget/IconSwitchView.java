package br.com.pedrosousa.bringon.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/**
 * Created by pedro on 03/07/2016.
 */
public class IconSwitchView extends RelativeLayout {
    public IconSwitchView(Context context) {
        super(context);
    }

    public IconSwitchView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public IconSwitchView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public IconSwitchView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
}
