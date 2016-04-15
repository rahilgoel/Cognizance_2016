package iit.iitrc.rahil.cognizance_2016;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

public class tabcenterstage extends Fragment {
    List<String> events;
    ListView listView;
    ArrayAdapter<String> adapter;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.tab_2, container, false);
        listView=(ListView) v.findViewById(R.id.list);
        DataAdapter mDbHelper = new DataAdapter(getContext());
        mDbHelper.createDatabase();
        mDbHelper.open();
        Log.d("check", "" + mDbHelper.getCenterStageCat().size());
        events = new ArrayList<String>(mDbHelper.getCenterStageCat());
        mDbHelper.close();
        adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_dropdown_item, events);
        adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item1);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        Intent i = new Intent(getActivity(), tablayoutevents.class);
                        i.putExtra("which", 0);
                        startActivity(i);
                        break;
                    case 1:
                        Intent i1 = new Intent(getActivity(), tablayoutevents.class);
                        i1.putExtra("which", 1);
                        startActivity(i1);
                        break;
                    case 2:
                        Intent i2 = new Intent(getActivity(), tablayoutevents.class);
                        i2.putExtra("which", 2);
                        startActivity(i2);
                        break;
                    case 3:
                        Intent i3 = new Intent(getActivity(), tablayoutevents.class);
                        i3.putExtra("which", 3);
                        startActivity(i3);
                        break;
                    case 4:
                        Intent i4 = new Intent(getActivity(), tablayoutevents.class);
                        i4.putExtra("which", 4);
                        startActivity(i4);
                        break;
                    case 5:
                        Intent i5 = new Intent(getActivity(), tablayoutevents.class);
                        i5.putExtra("which", 5);
                        startActivity(i5);
                        break;
                    case 6:
                        Intent i6 = new Intent(getActivity(), tablayoutevents.class);
                        i6.putExtra("which", 6);
                        startActivity(i6);
                        break;
                }
            }
        });
        return v;
    }
}
