package iit.iitrc.rahil.cognizance_2016;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.List;

/**
 * Created by rahil on 2/7/2016.
 */
public class Tab1 extends Fragment {
    List<NotifObject> list;
    ListView listView;
    Activity activity;
    DataBase db;
    NotifListAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_tab1, container, false);
        listView = (ListView) v.findViewById(R.id.notiflist);
        db = new DataBase(getActivity());
        list = db.getNotifExpanse();
        adapter = new NotifListAdapter(getActivity(), list);
        listView.setAdapter(adapter);
        return v;

    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }
}
