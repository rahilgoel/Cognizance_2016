package iit.iitrc.rahil.cognizance_2016;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.SpannableString;
import android.view.MenuItem;
import android.view.View;

/**
 * Created by rahil on 3/12/2016.
 */
public class SocialInitiativeTabs extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.socialinit);
        SpannableString s = new SpannableString("Social Initiatives");
        s.setSpan(new TypefaceSpan(this, "MyTypeface.otf"), 0, s.length(),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        getSupportActionBar().setTitle(s);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        findViewById(R.id.cv1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(SocialInitiativeTabs.this,SocialInit.class);
                i.putExtra("whichs",0);
                startActivity(i);
            }
        });
        findViewById(R.id.cv2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(SocialInitiativeTabs.this,SocialInit.class);
                i.putExtra("whichs",1);
                startActivity(i);
            }
        });
        findViewById(R.id.cv3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(SocialInitiativeTabs.this,SocialInit.class);
                i.putExtra("whichs",2);
                startActivity(i);
            }
        });

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            super.onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}