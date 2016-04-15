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

import com.parse.GetDataCallback;
import com.parse.ParseException;
import com.parse.ParseFile;

import java.util.List;

/**
 * Created by rahil on 3/11/2016.
 */
public class PanelListAdapter  extends BaseAdapter {
    Activity activity;
    List<PanelObject> list;
    private LayoutInflater inflater;

    PanelListAdapter(Activity a, List<PanelObject> notilist) {
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
            convertView = inflater.inflate(R.layout.panelobject, null);
        iit.iitrc.rahil.cognizance_2016.LatoHeading name= (iit.iitrc.rahil.cognizance_2016.LatoHeading) convertView.findViewById(R.id.panelistname);
        iit.iitrc.rahil.cognizance_2016.LatoLight post = (iit.iitrc.rahil.cognizance_2016.LatoLight) convertView.findViewById(R.id.panelistsub);
        final ImageView iv=(ImageView) convertView.findViewById(R.id.panelistimage);
        name.setText(list.get(position).getName());
        post.setText(list.get(position).getSubname());
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
        return convertView;
    }
}
