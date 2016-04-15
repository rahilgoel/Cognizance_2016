package iit.iitrc.rahil.cognizance_2016;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
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
import android.widget.ImageView;

public class Zones extends AppCompatActivity {
    static String heading[] = {"DELHI", "JAIPUR", "DEHRADUN", "LUCKNOW", "BHOPAL", "CHANDIGARH"};
    static String date[] = {"5th February", "6th February", "30th January", "13th February", "13th February", "31st January"};
    static String college[] = {"IGDTUW", "Arya College of Engineering and I.T.", "Graphic Era University", "Integral University", "UIT-RGPV", "Chandigarh Group of Colleges Landran"};
    ViewPager pager;
    SectionsPagerAdapter adapter;
    iit.iitrc.rahil.cognizance_2016.SlidingTabLayout tabs;
    CharSequence Titles[] = {"DELHI", "JAIPUR", "DEHRADUN", "LUCKNOW", "BHOPAL", "CHANDIGARH"};
    static final int images[]={R.mipmap.delhi,R.mipmap.jaipur,R.mipmap.dehradun,R.mipmap.lucknow,R.mipmap.bhopall,R.mipmap.chandigarh};
    int Numboftabs = 6;
    static ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zones);
        adapter = new SectionsPagerAdapter(getSupportFragmentManager());
        pager = (ViewPager) findViewById(R.id.viewpager);
        pager.setPageTransformer(true, new ParallaxPageTransformer());
        pager.setAdapter(adapter);
        SpannableString s = new SpannableString("Zones");
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
        private static final String cityn = "cityn";
        private static final String daten = "daten";
        private static final String collegen = "collegen";
        private static final String imagen = "imagen";


        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        static final public PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putString(cityn, heading[sectionNumber]);
            args.putString(daten, date[sectionNumber]);
            args.putString(collegen, college[sectionNumber]);
            args.putInt(imagen, images[sectionNumber]);
            fragment.setArguments(args);
            return fragment;
        }

        @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            View rootView = inflater.inflate(R.layout.fragment_zones, container, false);
           iv=(ImageView) rootView.findViewById(R.id.image);
            iv.setBackground(getResources().getDrawable(getArguments().getInt(imagen)));
            iit.iitrc.rahil.cognizance_2016.LatoHeading textView = (iit.iitrc.rahil.cognizance_2016.LatoHeading) rootView.findViewById(R.id.city);
            textView.setText(getArguments().getString(cityn));
            iit.iitrc.rahil.cognizance_2016.LatoHeading textView2 = (iit.iitrc.rahil.cognizance_2016.LatoHeading) rootView.findViewById(R.id.date);
            textView2.setText(getArguments().getString(daten));
            iit.iitrc.rahil.cognizance_2016.LatoHeading textView3 = (iit.iitrc.rahil.cognizance_2016.LatoHeading) rootView.findViewById(R.id.college);
            textView3.setText(getArguments().getString(collegen));
           /* TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));*/
            return rootView;
        }
    }

    public class SectionsPagerAdapter extends FragmentStatePagerAdapter {

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
    public class ParallaxPageTransformer implements ViewPager.PageTransformer {

        public void transformPage(View view, float position) {

            int pageWidth = view.getWidth();

            if (position < -1) { // [-Infinity,-1)
                // This page is way off-screen to the left.
                view.setAlpha(1);

            } else if (position <= 1) { // [-1,1]

                iv.setTranslationX(-position * (pageWidth / 2)); //Half the normal speed

            } else { // (1,+Infinity]
                // This page is way off-screen to the right.
                view.setAlpha(1);
            }


        }
    }

}
