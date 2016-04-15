package iit.iitrc.rahil.cognizance_2016;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.SpannableString;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class NotifList extends AppCompatActivity {
    final static CharSequence Titles[] = {"Expanse", "Events", "General"};
    final static int Numboftabs = 3;
    static List<NotifObject> expanselist;
    static List<NotifObject> eventslist;
    static List<NotifObject> generallist;
    static NotifListAdapter notifListAdapterexpanse;
    static NotifListAdapter notifListAdapterlist;
    static NotifListAdapter notifListAdaptergeneral;
    ViewPager pager;
    SectionsPagerAdapter adapter;
    DataBase db;
    iit.iitrc.rahil.cognizance_2016.SlidingTabLayout tabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zones);
        adapter = new SectionsPagerAdapter(getSupportFragmentManager());
        pager = (ViewPager) findViewById(R.id.viewpager);
        pager.setAdapter(adapter);
        db = new DataBase(this);
        expanselist = db.getNotifExpanse();
///        Log.d("checknotif", expanselist.get(0).getMessage());
        eventslist = db.getNotifEvents();
        generallist = db.getNotifGeneral();
        notifListAdapterexpanse = new NotifListAdapter(this, expanselist);
        notifListAdapterlist = new NotifListAdapter(this, eventslist);
        notifListAdaptergeneral = new NotifListAdapter(this, generallist);
        SpannableString s = new SpannableString("Notifications");
        Log.d("sd", "sd");
        s.setSpan(new TypefaceSpan(this, "MyTypeface.otf"), 0, s.length(),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        getSupportActionBar().setTitle(s);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        tabs = (iit.iitrc.rahil.cognizance_2016.SlidingTabLayout) findViewById(R.id.sliding_tabs);
        tabs.setDistributeEvenly(true); // To make the Tabs Fixed set this true, This makes the tabs Space Evenly in Available width
        tabs.setCustomTabColorizer(new iit.iitrc.rahil.cognizance_2016.SlidingTabLayout.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {
                return getResources().getColor(R.color.colorPrimary);
            }
        });
        tabs.setViewPager(pager);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            super.onBackPressed();
            return true;
        }
        switch (item.getItemId()) {
            case R.id.expanse:
                startActivity(new Intent(this, Expanse.class));
                break;
            case R.id.spon:
                startActivity(new Intent(this, Sponors.class));
                break;
            case R.id.contact:
                startActivity(new Intent(this, Contact.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String heading = "heading";
        private static final String summaryn = "summary";
        private static final String contact1n = "contact1";
        private static final String contact2n = "contact2";

        public PlaceholderFragment() {
        }
        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        static final public PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
           /* args.putString(heading, headings[sectionNumber]);
            args.putString(summaryn, summary[sectionNumber]);
            args.putString(contact1n, contact1[sectionNumber]);
            args.putString(contact2n, contact2[sectionNumber]);*/
            switch (sectionNumber) {
                case 0:
                    args.putInt(heading, 0);
                    break;
                case 1:
                    args.putInt(heading, 1);
                    break;
                case 2:
                    args.putInt(heading, 2);
                    break;
            }
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_tab1, container, false);
            ListView listView = (ListView) rootView.findViewById(R.id.notiflist);
            TextView no = (TextView) rootView.findViewById(R.id.nonotif);
            if (getArguments().getInt(heading) == 0) {
                if (expanselist.size() == 0) {
                    no.setVisibility(View.VISIBLE);
                }
                listView.setAdapter(notifListAdapterexpanse);

            }
            if (getArguments().getInt(heading) == 1) {
                if (eventslist.size() == 0) {
                    no.setVisibility(View.VISIBLE);
                }
                listView.setAdapter(notifListAdapterlist);
            }
            if (getArguments().getInt(heading) == 2) {
                if (generallist.size() == 0) {
                    no.setVisibility(View.VISIBLE);
                }
                listView.setAdapter(notifListAdaptergeneral);
            }
            return rootView;
        }
    }

    public static class SectionsPagerAdapter extends FragmentStatePagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return Titles[position];
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return Numboftabs;
        }
    }
}

