package iit.iitrc.rahil.cognizance_2016;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

public class Sponors extends AppCompatActivity {
    List<PanelObject> list;
    ListView listView;
    PanelListAdapter adapter;
    Activity activity;
    TextView text;
    public boolean checkinternetservice() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sponors);
        listView = (ListView) findViewById(R.id.list);
        text=(TextView) findViewById(R.id.comingsoon);
        text.setVisibility(View.INVISIBLE);
        SpannableString s = new SpannableString("Sponsors");
        s.setSpan(new TypefaceSpan(this, "MyTypeface.otf"), 0, s.length(),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        getSupportActionBar().setTitle(s);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        if(checkinternetservice()) {
            final ProgressBar p1 = (ProgressBar) findViewById(R.id.progressBar2);
            p1.setVisibility(View.VISIBLE);
            ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("sponsors");
            list = new ArrayList<PanelObject>();
            query.findInBackground(new FindCallback<ParseObject>() {
                @Override
                public void done(final List<ParseObject> objects, ParseException e) {
                    p1.setVisibility(View.INVISIBLE);
                    if (objects.size() > 0 && e == null) {
                        for (int i = 0; i < objects.size(); i++) {
                            ParseFile fileobject = (ParseFile) objects.get(i).getParseFile("images");
                            PanelObject object = new PanelObject();
                            object.setName(objects.get(i).getString("name"));
                            object.setFile(fileobject);
                            object.setSubname(objects.get(i).getString("sub"));
                            list.add(object);
                            Log.d("list size2", "" + list.size());
                        }
                        Log.d("list size3", "" + list.size());
                    }else if(objects.size()==0){
                        text.setVisibility(View.VISIBLE);
                    }
                    Log.d("list size4", "" + list.size());
                    adapter = new PanelListAdapter(Sponors.this, list);
                    listView.setAdapter(adapter);
                }

            });
        }else{
            new AlertDialog.Builder(Sponors.this)
                    .setTitle("oops")
                    .setMessage("you are not connected to the internet")
                    .setIcon(R.mipmap.cogni_logo)
                    .show();
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
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
