package iit.iitrc.rahil.cognizance_2016;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rahil on 3/11/2016.
 */
public class PanelLv extends Fragment {
    List<PanelObject> list;
    ListView listView;
    Activity activity;
    PanelListAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_tab1, container, false);
        listView = (ListView) v.findViewById(R.id.notiflist);
        list=new ArrayList<PanelObject>();
        if(checkinternetservice()) {
            final ProgressBar p1 = (ProgressBar) v.findViewById(R.id.progressBar2);
            p1.setVisibility(View.VISIBLE);
            ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("Panel");
            query.findInBackground(new FindCallback<ParseObject>() {
                @Override
                public void done(final List<ParseObject> objects, ParseException e) {
                    p1.setVisibility(View.INVISIBLE);
                    if (objects.size() > 0 && e == null) {
                        for (int i = 0; i < objects.size(); i++) {
                            if(objects.get(i).getString("paneltype").equals("lv")) {
                                ParseFile fileobject = (ParseFile) objects.get(i).getParseFile("images");
                                PanelObject object = new PanelObject();
                                object.setName(objects.get(i).getString("name"));
                                object.setFile(fileobject);
                                object.setSubname(objects.get(i).getString("post"));
                                list.add(object);
                                Log.d("list size2", "" + list.size());
                            }
                        }
                        Log.d("list size3", "" + list.size());
                    }
                    Log.d("list size4", "" + list.size());
                    adapter = new PanelListAdapter(getActivity(), list);
                    listView.setAdapter(adapter);
                }

            });
        }else{
            new AlertDialog.Builder(getActivity())
                    .setTitle("oops")
                    .setMessage("you are not connected to the internet")
                    .setIcon(R.mipmap.cogni_logo)
                    .show();
        }
        adapter = new PanelListAdapter(getActivity(), list);
        listView.setAdapter(adapter);
        return v;
    }
    public boolean checkinternetservice() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }
}
