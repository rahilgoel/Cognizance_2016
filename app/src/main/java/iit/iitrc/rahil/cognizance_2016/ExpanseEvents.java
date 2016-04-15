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

public class ExpanseEvents extends AppCompatActivity {
    final static CharSequence Titles[] = {"CYBORGSAP", "QUIZZOTICA", "MIND SWEEPER", "PROJECT HUNGER"};
    final static String headings[] = {"Where Robots Replace Humans ", "Strain Your Brain", "The Code Trap", "'U' Are The Missing Ingredient"};
    final static String summary[] = {"A unique invention by mankind that eased the performing of tasks was Robots. " +
            "Bots automated and programmed by human mind are a boon to the today's ever growing world. " +
            "Their utility multiplies the efficiency of any task manifold. Cognizance, being a technical fest " +
            "recognises the value of robots in today's world. Therefore, we invite people with magnificent bot " +
            "making and running abilities to come and " +
            "showcase their talent on our platform. May the best bot win", "The event presents a medley of" +
            " well gleaned questions to test the intellectual capabilities of both reader and author to limits." +
            " If Archie was the first and Backrub became Google, the advent of search engines and internet has " +
            "meant that answers to anything are just a click away. However it is not going to get so easy in here " +
            "where teams fight to gain the ultimate glory", "Mindsweeper is a coding challenge where you showcase your code writing skills on our platform where competitors from " +
            "all over India participate. It is an open challenge to the genius minds in the world of Coding to prove their mettle " +
            "and decipher the answers to the puzzle presented to them. Come code your way through the challenge to win big", "One of the unevenly distributed resource is " +
            "food. Each year ends with a chunk of population dying of hunger. This year cognizance attempts to bring this issue " +
            "to the forefront and invites decisive solutions" +
            " in the form of Case study for making food universally accessible and eradicating hunger from the country",};
    final static String contact1[] = {"Aayush Nigam: +91-9506954610", "Aayush Nigam: +91-9506954610", "Aayush Nigam: +91-9506954610", "Aayush Nigam: +91-9506954610"};
    final static String contact2[] = {"Saurabh Anand: +91-7060467047", "Saurabh Anand: +91-7060467047", "Saurabh Anand: +91-7060467047", "Saurabh Anand: +91-7060467047"};
    final static int Numboftabs = 4;
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
        SpannableString s = new SpannableString("Events");
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
        }switch (item.getItemId()){
            case R.id.expanse:
                startActivity(new Intent(this,Expanse.class));
                break;
            case R.id.spon:
                startActivity(new Intent(this,Sponors.class));
                break;
            case R.id.contact:
                startActivity(new Intent(this,Contact.class));
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
            args.putString(heading, headings[sectionNumber]);
            args.putString(summaryn, summary[sectionNumber]);
            args.putString(contact1n, contact1[sectionNumber]);
            args.putString(contact2n, contact2[sectionNumber]);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.expanse_layout, container, false);
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
