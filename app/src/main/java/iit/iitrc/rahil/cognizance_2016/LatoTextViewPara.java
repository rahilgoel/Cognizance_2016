package iit.iitrc.rahil.cognizance_2016;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by rahil on 2/7/2016.
 */
public class LatoTextViewPara extends TextView {
    public LatoTextViewPara(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public LatoTextViewPara(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public LatoTextViewPara(Context context) {
        super(context);
        init();
    }

    private void init() {
        if (!isInEditMode()) {
            Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/Lato-Regular.ttf");
            setTypeface(tf);
        }
    }
}
