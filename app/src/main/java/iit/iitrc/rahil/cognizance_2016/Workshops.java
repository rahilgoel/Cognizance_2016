package iit.iitrc.rahil.cognizance_2016;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

public class Workshops extends AppCompatActivity {
    final static CharSequence Titles[] = {"Mobile App", "Stock Hunt", "Vision Robotics"};
    final static String headings[] = {"Build an App that can run anywhere ", "Strain Your Brain", "The Code Trap", "'U' Are The Missing Ingredient"};
    final static String summary[] = {"An Application is a need of everyone but if it is Cross Platformed, then it is more reliable and scalable. During this workshop, " +
            "you will develop webpages using HTML, CSS and Java Scripts and then use these webpages to develop Cross Platform Mobile Applications. he workshop is on 18th " +
            "and 19th March(16 hours)" +
            " and fees is INR 1200 per participant. Participant will get a toolkit containing softwares and tools.",
            "It is a platform to learn about finance and stock market investments " +
            "in a very professional and competitive manner from the market experts. You will be able to understand the financial happenings and will gain the basic " +
                    "knowledge on stock market, terms & terminologies related to it along with practical experience of real time investments in live markets through " +
                    "virtual stock market challenge conducted during the workshop and this will also " +
            "certainly help you looking to choose career opportunities in finance domain and be an investment expert.",
            "Vision Robotics Workshop mainly focuses on the student eager to learn about Image Processing Tool. You will get a chance to expand their knowledge" +
                    " in the field of Robot Vision. The benefit of sophisticated vision technology includes savings, improved quality, reliability, and safety." +
                    " Along with designing of robots, you will also use Matrix Laboratory (MATLAB) for image acquisition and processing. The workshop is on " +
                    "19th and 20th March(16 hours) and fees is INR 1300 per participant. Participants will get robotic kit in a group of 5 members.",
            };
    final static String contact1[] = {"Aman: +91-8791700558", "Aman: +91-8791700558", "Aman: +91-8791700558"};
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
        SpannableString s = new SpannableString("Workshops");
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
