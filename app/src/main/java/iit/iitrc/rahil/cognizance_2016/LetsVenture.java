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
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

public class LetsVenture extends AppCompatActivity {
    final static CharSequence Titles[] = {"Crowd Pitch", "Inverstor's Hat", "Startup Expo","Zero In"};
    final static String headings[] = {"An Idea Pitching Competition", "It's not a salary it's an investment habit","Your Dose of Great Ideas","Venturing Marketing"};
    final static String summary[] = {"All the forces in the world are not as powerful as an idea whose time has come. –Victor Hugo Every" +
            " idea has a fascinating tale behind it. Every success story has a hard way leading to it. Crowd Pitch is a meeting place of" +
            " promethean ideas, imaginative people, together bound by right guidance from renown mentors. We provide a platform for" +
            " startups to pitch their ideas infront of leading venture capitalists and investors. They will be judged " +
            "and the winning ideas will have the chance to receive incubation and funding by our partnering investors.",
            "“It’s not your salary that makes you rich, it’s your investment habit.”Investor’s Hat is all about making right decisions while" +
                    " investing in a company. You will be given a case study of a start-up (how the company works, its principles etc.) and the" +
                    " event seeks the participants to make an investment plan for the same " +
                    "giving proper reasons and logic behind why or why would you not invest in the start-up company.","The best way to predict the" +
            " future is definitely to create it. Startup expo is an innovative platform from Cognizance 16 to help participants connect with " +
            "investors, learn about incubators and to pitch in their ideas. This is an open platform for startups to showcase their work " +
            "and to pitch their ideas in front of leading investors and other entrepreneurs. We invite you to lend your ears " +
            "to entrepreneurship endeavors, meet the cowboys of startup space and discuss the trends and future opportunities.",
            "Marketing is " +
            "a necessary component of every business that often becomes a huge expense with seemingly negligible results. Staffing companies" +
            " spend outrageous amounts on four-color brochures and high-gloss marketing materials that many times never get read or worse, become " +
            "obsolete before they are even used. Zero-cost trading strategies can be used with a variety of investment types, including equities," +
            " commodities and options. A zero-cost business strategy might be to improve sales prospects for a home by de-cluttering all the rooms," +
            " packing excess belongings into boxes and moving the boxes to the garage. Zero-cost strategies help reduce risk by eliminating " +
            "upfront costs. The event seeks zero cost marketing ideas from the participants in a given situation."

    };
    final static String contact1[] = {"Kartik Hajela: 8791787434", "Kartik Hajela: 8791787434", "Kartik Hajela: 8791787434"};
    // final static String contact2[] = {"Saurabh Anand: +91-7060467047", "Saurabh Anand: +91-7060467047", "Saurabh Anand: +91-7060467047", "Saurabh Anand: +91-7060467047"};
    final static int Numboftabs = 3;
    ViewPager pager;
    SectionsPagerAdapter adapter;
    iit.iitrc.rahil.cognizance_2016.SlidingTabLayout tabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zones);
        adapter = new SectionsPagerAdapter(getSupportFragmentManager());
        pager = (ViewPager) findViewById(R.id.viewpager);
        pager.setAdapter(adapter);
        SpannableString s = new SpannableString("Lets Venture");
        s.setSpan(new TypefaceSpan(this, "MyTypeface.otf"), 0, s.length(),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        getSupportActionBar().setTitle(s);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        tabs = (iit.iitrc.rahil.cognizance_2016.SlidingTabLayout) findViewById(R.id.sliding_tabs);
        // tabs.setDistributeEvenly(true); // To make the Tabs Fixed set this true, This makes the tabs Space Evenly in Available width
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

   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }
*/
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
            args.putString(heading, headings[sectionNumber]);
            args.putString(summaryn, summary[sectionNumber]);
            args.putString(contact1n, contact1[sectionNumber]);
            //args.putString(contact2n, contact2[sectionNumber]);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.activity_expanse_event, container, false);
            iit.iitrc.rahil.cognizance_2016.LatoHeading textView = (iit.iitrc.rahil.cognizance_2016.LatoHeading) rootView.findViewById(R.id.heading);
            textView.setText(getArguments().getString(heading));
            iit.iitrc.rahil.cognizance_2016.LatoHeading textView2 = (iit.iitrc.rahil.cognizance_2016.LatoHeading) rootView.findViewById(R.id.info);
            textView2.setText(getArguments().getString(summaryn));
            iit.iitrc.rahil.cognizance_2016.LatoHeading textView3 = (iit.iitrc.rahil.cognizance_2016.LatoHeading) rootView.findViewById(R.id.contact1);
            textView3.setText(getArguments().getString(contact1n));
            iit.iitrc.rahil.cognizance_2016.LatoHeading textView4 = (iit.iitrc.rahil.cognizance_2016.LatoHeading) rootView.findViewById(R.id.contact2);
            textView4.setText(getArguments().getString(contact2n));
            return rootView;
        }
    }

    public static class SectionsPagerAdapter extends FragmentStatePagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        public static String getHeading(int position) {
            return headings[position];
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
