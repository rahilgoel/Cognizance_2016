package iit.iitrc.rahil.cognizance_2016;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by rahil on 2/7/2016.
 */

public class NotifListAdapter extends BaseAdapter {
    Activity activity;
    List<NotifObject> list;
    private LayoutInflater inflater;

    NotifListAdapter(Activity a, List<NotifObject> notilist) {
        this.activity = a;
        this.list = notilist;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.noti_list_object, null);
        iit.iitrc.rahil.cognizance_2016.LatoLight notif = (iit.iitrc.rahil.cognizance_2016.LatoLight) convertView.findViewById(R.id.notif);
        iit.iitrc.rahil.cognizance_2016.LatoLight date = (iit.iitrc.rahil.cognizance_2016.LatoLight) convertView.findViewById(R.id.date);
        notif.setText(list.get(position).getMessage());
        date.setText(list.get(position).getDate());
        return convertView;
    }
}
