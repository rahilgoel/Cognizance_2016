package iit.iitrc.rahil.cognizance_2016;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.SpannableString;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

public class Expanse extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expanse);
        LinearLayout events, worskshops, zones,aboutus;
        events = (LinearLayout) findViewById(R.id.expanseevents);
        worskshops = (LinearLayout) findViewById(R.id.workshops);
        zones = (LinearLayout) findViewById(R.id.zones);
        aboutus = (LinearLayout) findViewById(R.id.aboutus);
        events.setOnClickListener(this);
        worskshops.setOnClickListener(this);
        SpannableString s = new SpannableString("Expanse 2016");
        s.setSpan(new TypefaceSpan(this, "MyTypeface.otf"), 0, s.length(),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        getSupportActionBar().setTitle(s);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        aboutus.setOnClickListener(this);
        zones.setOnClickListener(this);
         getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setTitle(s);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.expanseevents:
                startActivity(new Intent(Expanse.this, ExpanseEvents.class));
                break;
            case R.id.workshops:
                startActivity(new Intent(Expanse.this, Workshops.class));
                break;
            case R.id.zones:
                startActivity(new Intent(Expanse.this, Zones.class));
                break;
            case R.id.aboutus:
                startActivity(new Intent(Expanse.this, AboutUs.class));
                break;
        }
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

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }*/

}
