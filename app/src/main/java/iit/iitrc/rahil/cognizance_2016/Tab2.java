package iit.iitrc.rahil.cognizance_2016;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Tab2 extends Fragment {
    List<String> events;
    ListView listView;
    ArrayAdapter<String> adapter;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.tab_2, container, false);
        listView = (ListView) v.findViewById(R.id.list);
        events = new ArrayList<String>();
        events.add("Department of\nArchitecture & Planning");
        events.add("Department of\nCivil Engineering");
        events.add("Department of\nComputer Science & Engineering");
        events.add("Department of\nEarth Sciences");
        events.add("Department of\nWater Resources Development & Management");
        events.add("Department of\nChemical Engineering");
        events.add("Department of\nBiotechnology");
        events.add("Department of\nChemistry");
        events.add("Department of\nElectrical Engineering");
        events.add("Department of\nElectronics & Communication Engineering");
      //  events.add("Department of\nHumanities & Social Sciences");
        events.add("Department of\nHydrology");
        events.add("Department of\nManagement Studies");
        events.add("Department of\nMathematics");
        events.add("Department of\nMechanical & Industrial Engineering");
        events.add("Department of\nMetallurgical & Materials Engineering");
        events.add("Department of\nPaper Technology & Polymer Sciences");
        events.add("Department of\nPhysics");
        events.add("Department of\nEarthquake Engineering");
        events.add("Centre of\nExcellence in Disaster Mitigation & Management");
        events.add("Centre for\nTransportaion Systems");
        events.add("Centre of\nNanotechnology");
        events.add("Alternate\nHydro Energy Centre");
        adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_dropdown_item, events);
        adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item1);
        listView.setAdapter(adapter);
        Bundle b = new Bundle();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        Intent i = new Intent(getActivity(), tablayoutevents.class);
                        i.putExtra("which", 7);
                        startActivity(i);
                        break;
                    case 1:
                        Intent i1 = new Intent(getActivity(), tablayoutevents.class);
                        i1.putExtra("which", 8);
                        startActivity(i1);
                        break;
                    case 2:
                        Intent i2 = new Intent(getActivity(), tablayoutevents.class);
                        i2.putExtra("which", 9);
                        startActivity(i2);
                        break;
                    case 3:
                        Intent i3 = new Intent(getActivity(), tablayoutevents.class);
                        i3.putExtra("which", 10);
                        startActivity(i3);
                        break;
                    case 4:
                        Intent i4 = new Intent(getActivity(), tablayoutevents.class);
                        i4.putExtra("which", 11);
                        startActivity(i4);
                        break;
                    case 5:
                        Intent i5 = new Intent(getActivity(), tablayoutevents.class);
                        i5.putExtra("which", 12);
                        startActivity(i5);
                        break;
                    case 6:
                        Intent i6 = new Intent(getActivity(), tablayoutevents.class);
                        i6.putExtra("which", 13);
                        startActivity(i6);
                        break;
                    case 7:
                        Intent i7 = new Intent(getActivity(), tablayoutevents.class);
                        i7.putExtra("which", 14);
                        startActivity(i7);
                        break;
                    case 8:
                        Intent i8 = new Intent(getActivity(), tablayoutevents.class);
                        i8.putExtra("which", 15);
                        startActivity(i8);
                        break;
                    case 9:
                        Intent i9 = new Intent(getActivity(), tablayoutevents.class);
                        i9.putExtra("which", 16);
                        startActivity(i9);
                        break;
                    case 10:
                        Intent i10 = new Intent(getActivity(), tablayoutevents.class);
                        i10.putExtra("which", 17);
                        startActivity(i10);
                        break;
                    case 11:
                        Intent i11 = new Intent(getActivity(), tablayoutevents.class);
                        i11.putExtra("which", 18);
                        startActivity(i11);
                        break;
                    case 12:
                        Intent i12 = new Intent(getActivity(), tablayoutevents.class);
                        i12.putExtra("which", 19);
                        startActivity(i12);
                        break;
                    case 13:
                        Intent i13 = new Intent(getActivity(), tablayoutevents.class);
                        i13.putExtra("which", 20);
                        startActivity(i13);
                        break;
                    case 14:
                        Intent i14 = new Intent(getActivity(), tablayoutevents.class);
                        i14.putExtra("which", 21);
                        startActivity(i14);
                        break;
                    case 15:
                        Intent i15 = new Intent(getActivity(), tablayoutevents.class);
                        i15.putExtra("which", 22);
                        startActivity(i15);
                        break;
                    case 16:
                        Intent i16 = new Intent(getActivity(), tablayoutevents.class);
                        i16.putExtra("which", 23);
                        startActivity(i16);
                        break;
                    case 17:
                        Intent i17 = new Intent(getActivity(), tablayoutevents.class);
                        i17.putExtra("which", 24);
                        startActivity(i17);
                        break;
                    case 18:
                        Intent i18 = new Intent(getActivity(), tablayoutevents.class);
                        i18.putExtra("which",25);
                        startActivity(i18);
                        break;
                    case 19:
                        Intent i19 = new Intent(getActivity(), tablayoutevents.class);
                        i19.putExtra("which", 26);
                        startActivity(i19);
                        break;
                    case 20:
                        Intent i20 = new Intent(getActivity(), tablayoutevents.class);
                        i20.putExtra("which", 27);
                        startActivity(i20);
                        break;
                    case 21:
                        Intent i21 = new Intent(getActivity(), tablayoutevents.class);
                        i21.putExtra("which", 28);
                        startActivity(i21);
                        break;
                }
            }
        });

        return v;
    }
}
