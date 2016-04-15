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

import java.util.ArrayList;
import java.util.List;

public class SocialInit extends AppCompatActivity {

    final static int Numboftabs = 2;
    static List<CharSequence> Titles;
    static List<String> headings;
    static List<String> summary;
    static List<String> contact1;
    int position;
    //final static String contact2[] = {"Saurabh Anand: +91-7060467047", "Saurabh Anand: +91-7060467047", "Saurabh Anand: +91-7060467047", "Saurabh Anand: +91-7060467047"};
    ViewPager pager;
    SectionsPagerAdapter adapter;
    iit.iitrc.rahil.cognizance_2016.SlidingTabLayout tabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zones);
        Titles = new ArrayList<CharSequence>();
        headings = new ArrayList<String>();
        summary = new ArrayList<String>();
        contact1 = new ArrayList<String>();
        position = getIntent().getIntExtra("whichs", 0);
        switch(position){
            case 0:
                Titles.add("Digital Empowerment Campaign");
                Titles.add("Idee Fixe");
                headings.add("Safeguarding with DigiLocker");
                headings.add("Rural Education through Digitization");
                summary.add("Cognizance 2016 in association with Unnat Bharat Abhiyaan Campaign by the Ministry of Human Resource Development(MHRD) organized a Digital Empowerment Campaign cum Workshop on Digital Locker at Chharba , a village of Dehradun in Uttarakhand. A Science Exhibition for the school children from nearby villages, along with Digital Empowerment Campaign under the Digital India initiative by the Ministry of Communications and IT was undertaken by Cognizance 2016. Under the Identified Champions concept, we identified 15 strategic point of contacts of Chharba, who were further responsible for DigiLocker Registration of 50 people each. Further, computers acquired from the Institute Computer Centre at IIT Roorkee have been donated to 5 villages of Uttarakhand namely Chharba, Chandpur, Mirpur, Mohund and Beladi Salapur further promoting the cause of Digital Literacy in Rural India. Also, a play was performed by the students of IIT Roorkee at Chharba under the aegis of Cognizance to spread awareness about the issues faced due to digital illiteracy.");
                summary.add("Idee Fixe The Digital India initiative is a giant leap towards transforming India into a digitally-empowered economy, a concerted digital push to all projects in the country and a game changer. But thinking big has its own challenges. Idee Fixe is a platform to get involved in one of the biggest initiatives in the country, to design and decide the digital future.");
                contact1.add("Siddhant Tripathy: +91-9897663264");
                contact1.add("Siddhant Tripathy: +91-9897663264");
                break;
            case 1:
                Titles.add("Paradigm");
                Titles.add("Abhigamyatva");
                headings.add("Online Poster Making Competition");
                headings.add("Rural Disaster Mitigation for the Differently-Abled");
                summary.add("The current Indian government has attempted for the idea of a country which eyes unity, growth and progress in all the sectors will not reach fruition unless there was enough consideration for the people with certain physical limitations. The ‘Accessible India’ campaign, aims to make at least half of the government buildings and offices in the nation’s capital, New Delhi, and in all the other state-capitals accessible to the specially-abled citizens of the nation Cognizance, in an effort to assist this rather welcome initiative by the parliament, is hosting an event that hopes to spread the word about the idea in a rather unique way. The contest, that goes by the name of ‘Paradigm’, is a Mascot Making competition through sketching, with it’s theme centered around the ‘Accessible India’ campaign. To win, design keeping simple features in minds & get to feature in the Official Comic of Cognizance, the Cogni Chucklers.(Pre-fest Event)");
                summary.add("The earth that shakes beneath our feet, the waves that rock our shores, the clouds that floods our lands are all but the childishness of the boisterous Nature. But when all men flee, there are some that are left behind unwanted, frightened and helpless. The fact that they are differently abled makes these men no less adept. In fact, including them to the equations often help in solving a problem from the worst case scenario. Through this understanding, let us join hands in making the world a safer place to live in.");
                contact1.add("Siddhant Tripathy: +91-9897663264");
                contact1.add("Siddhant Tripathy: +91-9897663264");
                break;
            case 2:
                Titles.add("National Signature Dish");
                Titles.add("Project Hunger");
                headings.add("Your Unique Recipe");
                headings.add("Thought for food");
                summary.add("Cognizance 2016 proudly presents the National Signature Dish Competition, the flagship Masterchef Competition of IIT Roorkee.The event is being conducted under the official patronage of the International Year of Pulses (IYP 2016) and FAO(Food and Agricultural Organisation) and aims at enhancing the nutritional and environmental benefit of pulses. We invite participants to come with innovative recipes with an Indian subcontinental touch and pulses/legume as a key ingredient of the dish.The Host of NDTV Good Times Chakh Le India Series, Aditya Bal is our NSD Judge.");
                summary.add("India is a diverse country where people of all economic class coexist. The coexistence is accompanied with a variety in the type of living conditions of the population. A country which houses a large population density the demand for the basic necessities is also likely to be more. In such a case only an organised system of management and supply chain can ensure an even distribution of the resources. One of the unevenly distributed resource is food. Each year ends with a chunk of population dying of hunger. This year cognizance attempts to bring this issue to the forefront and invites decisive solutions in the form of Case study for making food universally accessible and eradicating hunger from the country.");
                contact1.add("Siddhant Tripathy: +91-9897663264");
                contact1.add("Siddhant Tripathy: +91-9897663264");
                break;
        }

        adapter = new SectionsPagerAdapter(getSupportFragmentManager());
        pager = (ViewPager) findViewById(R.id.viewpager);
        pager.setAdapter(adapter);
        SpannableString s = new SpannableString("Social Initiatives");
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
            args.putString(heading, headings.get(sectionNumber));
            args.putString(summaryn, summary.get(sectionNumber));
            args.putString(contact1n, contact1.get(sectionNumber));
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
            return headings.get(position);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position);
        }


        @Override
        public CharSequence getPageTitle(int position) {
            return Titles.get(position);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return Numboftabs;
        }
    }
}
