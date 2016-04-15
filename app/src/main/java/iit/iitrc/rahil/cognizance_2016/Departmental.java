package iit.iitrc.rahil.cognizance_2016;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by rahil on 3/7/2016.
 */
public class Departmental extends Fragment {
    Activity activity;
    Toolbar actionbar;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.activity_departmental,container);

        return v;
    }
}
