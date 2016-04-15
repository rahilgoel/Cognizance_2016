package iit.iitrc.rahil.cognizance_2016;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by rahil on 2/8/2016.
 */
public class ChampageFont extends TextView {
    public ChampageFont(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public ChampageFont(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ChampageFont(Context context) {
        super(context);
        init();
    }

    private void init() {
        if (!isInEditMode()) {
            Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/Champagne_Limousines.ttf");
            setTypeface(tf);
        }
    }
}