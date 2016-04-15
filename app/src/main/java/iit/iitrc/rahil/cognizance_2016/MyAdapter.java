package iit.iitrc.rahil.cognizance_2016;

import android.app.Activity;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.parse.GetDataCallback;
import com.parse.ParseException;
import com.parse.ParseFile;

import java.util.List;

/**
 * Created by rahil on 2/9/2016.
 */

public class MyAdapter extends BaseAdapter {
    Activity aactivity;
    private LayoutInflater inflater;
    List<SponorObject> list;
    MyAdapter(Activity a, List<SponorObject> mylist) {
        this.aactivity = a;
        this.list = mylist;
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
            inflater = (LayoutInflater) aactivity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.spon_list_object, null);
        iit.iitrc.rahil.cognizance_2016.LatoHeading tv=(iit.iitrc.rahil.cognizance_2016.LatoHeading) convertView.findViewById(R.id.sponsorname);
        final ImageView iv=(ImageView) convertView.findViewById(R.id.sponsorimage);
        ParseFile fileobject=list.get(position).getFile();
                 fileobject.getDataInBackground(new GetDataCallback() {
                            @Override
                            public void done(byte[] data, ParseException e) {
                                if (e == null) {
                                    iv.setImageBitmap(BitmapFactory
                                            .decodeByteArray(
                                                    data, 0,
                                                    data.length));

                                    Log.d("rahil", list.get(0).getName().toString());
                                    Log.d("test",
                                            "We've got data in data.");

                                } else {
                                    Log.d("test",
                                            "There was a problem downloading the data.");
                                }
                            }

                        });
        tv.setText(list.get(position).getName());
       // iv.setImageBitmap(list.get(position).getBitmap());
        return convertView;
    }
}
