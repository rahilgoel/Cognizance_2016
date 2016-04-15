package iit.iitrc.rahil.cognizance_2016;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by rahil on 2/7/2016.
 */
public class LatoLight extends TextView {
    public LatoLight(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }
    public LatoLight(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public LatoLight(Context context) {
        super(context);
        init();
    }

    private void init() {
        if (!isInEditMode()) {
            Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/Lato-Light.ttf");
            setTypeface(tf);
        }
    }
}
