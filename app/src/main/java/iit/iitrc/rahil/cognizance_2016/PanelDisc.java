package iit.iitrc.rahil.cognizance_2016;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.SpannableString;
import android.view.MenuItem;
import android.widget.RelativeLayout;

public class PanelDisc extends AppCompatActivity {
    ViewPager pager;
    PanelTabLayoutAdapter adapter;
    SlidingTabLayout tabs;
    CharSequence Titles[] = {"Ballistics of Tactics", "Let's Venture", "Digital India Camp"};
    int Numboftabs = 3;
    RelativeLayout main;
    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.panel_discussion);
        adapter = new PanelTabLayoutAdapter(getSupportFragmentManager(), Titles, Numboftabs);
        pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(adapter);
        SpannableString s = new SpannableString("Panel Discussion");
        s.setSpan(new TypefaceSpan(this, "MyTypeface.otf"), 0, s.length(),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        getSupportActionBar().setTitle(s);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        tabs = (SlidingTabLayout) findViewById(R.id.tabs);
        tabs.setDistributeEvenly(true); // To make the Tabs Fixed set this true, This makes the tabs Space Evenly in Available width
        //final ImageView search = (ImageView) findViewById(R.id.search);
        tabs.setViewPager(pager);

        //tabs.setViewPager(pager);
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
}