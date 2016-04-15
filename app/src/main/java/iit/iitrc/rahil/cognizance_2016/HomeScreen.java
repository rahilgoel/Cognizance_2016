package iit.iitrc.rahil.cognizance_2016;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.Spannable;
import android.text.SpannableString;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class HomeScreen extends AppCompatActivity implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener {

    DataBase db;
    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    DataBaseHelper db2;
    List<RecyclerEventObject> eventList;
    private SliderLayout mDemoSlider;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private StaggeredGridLayoutManager gaggeredGridLayoutManager;
    public class SpacesItemDecoration extends RecyclerView.ItemDecoration {
        private final int mSpace;
        public SpacesItemDecoration(int space) {
            this.mSpace = space;
        }
        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            outRect.left = mSpace;
            outRect.right = mSpace;
            outRect.bottom = mSpace;
            // Add top margin only for the first item to avoid double space between items
            if (parent.getChildAdapterPosition(view) == 0)
                outRect.top = mSpace;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        mDemoSlider = (SliderLayout) findViewById(R.id.slider);
        HashMap<String, String> url_maps = new HashMap<String, String>();
        eventList = new ArrayList<RecyclerEventObject>();
        RecyclerEventObject object1 = new RecyclerEventObject();
        RecyclerEventObject object2 = new RecyclerEventObject();
        RecyclerEventObject object3 = new RecyclerEventObject();
        RecyclerEventObject object4 = new RecyclerEventObject();
        RecyclerEventObject object5 = new RecyclerEventObject();
        RecyclerEventObject object6 = new RecyclerEventObject();
        RecyclerEventObject object7 = new RecyclerEventObject();
        RecyclerEventObject object8 = new RecyclerEventObject();
        RecyclerEventObject object9 = new RecyclerEventObject();
        RecyclerEventObject object10 = new RecyclerEventObject();
        RecyclerEventObject object11 = new RecyclerEventObject();
     //   RecyclerEventObject object12 = new RecyclerEventObject();
        object1.setName("Events");
        object1.setPic(R.mipmap.eventsv2);
        object2.setName("Workshops");
        object2.setPic(R.mipmap.workshops);
        object3.setName("Social Initiatives");
        object3.setPic(R.mipmap.siv2);
        object4.setName("Exhibitions");
        object4.setPic(R.mipmap.exhibitexibitionv2);
        object5.setName("Expanse");
        object5.setPic(R.mipmap.expanse);
        object6.setName("Let's Venture");
        object6.setPic(R.mipmap.lvv2);
        object7.setName("Schedule");
        object7.setPic(R.mipmap.schedule);
        object8.setName("Contact");
        object8.setPic(R.mipmap.contact);
        object9.setName("Sponsorship");
        object9.setPic(R.mipmap.sponsorship);
        object10.setName("Map");
        object10.setPic(R.mipmap.mapicon);
        object11.setName("Panel Discussion");
        object11.setPic(R.mipmap.pdv2);
      /*  object12.setName("Techtainment");
        object12.setPic(R.mipmap.pdv2);*/
        eventList.add(object1);
        eventList.add(object2);
        eventList.add(object3);
        eventList.add(object4);
        eventList.add(object5);
        eventList.add(object6);
        eventList.add(object7);
        eventList.add(object8);
        eventList.add(object9);
        eventList.add(object10);
        eventList.add(object11);
    //    eventList.add(object12);
        //url_maps.put("Welcome to Cognizance 2016", "http://files.parsetfss.com/b55e1e96-e192-4253-a5d9-d236f8816980/tfss-14e0382d-16d5-477a-a0f6-1d0d86b5bc6e-main-page-graphic.png");
        url_maps.put("At Ballistics of Tactics", "http://files.parsetfss.com/b55e1e96-e192-4253-a5d9-d236f8816980/tfss-089be395-9c1a-45c2-a8bb-567ac81e1810-slider1.png");
        url_maps.put("Vh1 Super Sonic Campus 101", "http://files.parsetfss.com/b55e1e96-e192-4253-a5d9-d236f8816980/tfss-2eb24ed5-59b0-48d5-bdc7-5e4336eb92ac-slider2.png");
        url_maps.put("See The World Differently", "http://files.parsetfss.com/b55e1e96-e192-4253-a5d9-d236f8816980/tfss-aa660fff-6019-458c-ba37-12e734a57b19-slider3.png");
        url_maps.put("Connect To The Surroundings ", "http://files.parsetfss.com/b55e1e96-e192-4253-a5d9-d236f8816980/tfss-92effb38-652b-4635-9fe6-c25fe80caa08-slider4.png");
        url_maps.put("Into the Space", "http://files.parsetfss.com/b55e1e96-e192-4253-a5d9-d236f8816980/tfss-78347bc1-2aff-436c-a82f-badc75ff8cac-slider5.png");
        url_maps.put("Cheif Guest", "http://files.parsetfss.com/b55e1e96-e192-4253-a5d9-d236f8816980/tfss-4cd60fe0-9494-4666-a71f-d89aaa73d1ba-slider6.png");
       /* HashMap<String, Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("text1", R.mipmap.homed);
        file_maps.put("text2", R.drawable.slider1);
        file_maps.put("text3", R.drawable.slider2);
        file_maps.put("text4", R.drawable.slider3);
        file_maps.put("text5", R.drawable.slider4);
        file_maps.put("text6", R.drawable.slider5);
        file_maps.put("text7", R.drawable.slider6);*/
        for (String name : url_maps.keySet()) {
            TextSliderView textSliderView = new TextSliderView(this);
            // initialize a SliderLayout
            textSliderView
                    .description(name)
                    .image(url_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);
            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra", name);
            mDemoSlider.addSlider(textSliderView);
        }
        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Tablet);
        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mDemoSlider.setCustomAnimation(new DescriptionAnimation());
        mDemoSlider.setDuration(4000);
        mDemoSlider.addOnPageChangeListener(this);
        prefs = getSharedPreferences("my data", Context.MODE_PRIVATE);
        editor = prefs.edit();
        //startService(new Intent(HomeScreen.this, RegistrationIntentService.class));
        LinearLayout spons, expanse, event, workshop, contact, venture, social, live;
        DataAdapter mDbHelper = new DataAdapter(this);
        mDbHelper.createDatabase();
      /*  final ScrollView main = (ScrollView) findViewById(R.id.sv);
        main.post(new Runnable() {
            public void run() {
                main.scrollTo(0, 0);
            }
        });*/

        //focusOnView();
        mDbHelper.open();
        Log.d("check", "" + mDbHelper.getCenterStageCat().size());
        Object[] arr = mDbHelper.getCenterStageCat().toArray();
        Log.d("check2", arr[0].toString());
        Log.d("check2", arr[1].toString());
        Log.d("check2", arr[2].toString());
        Log.d("check2", arr[3].toString());
        Log.d("check2", arr[4].toString());
        Log.d("check2", arr[5].toString());
        Log.d("check2", arr[6].toString());
        mDbHelper.close();
        SpannableString s = new SpannableString("  Cognizance 2016");
        s.setSpan(new TypefaceSpan(this, "MyTypeface.otf"), 0, s.length(),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        getSupportActionBar().setTitle(s);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.cogni_logo);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setTitle(s);
        String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        SpacesItemDecoration decoration = new SpacesItemDecoration(-2);
        mRecyclerView.addItemDecoration(decoration);
        gaggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(gaggeredGridLayoutManager);
      //  mRecyclerView.setHasFixedSize(true);
      /*  mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);*/
        mAdapter = new MyRecyclerViewAdapter(eventList);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
        switch (position){
            case 0:
                startActivity(new Intent(HomeScreen.this,Tablayout.class));
                break;
            case 1:
                startActivity(new Intent(HomeScreen.this,Workshops.class));
                break;
            case 2:
                startActivity(new Intent(HomeScreen.this,SocialInitiativeTabs.class));
                break;
            case 3:
                startActivity(new Intent(HomeScreen.this,Exhibitions.class));
                break;
            case 4:
                startActivity(new Intent(HomeScreen.this,Expanse.class));
                break;
            case 5:
                startActivity(new Intent(HomeScreen.this,LetsVenture.class));
                break;
            case 6:
                startActivity(new Intent(HomeScreen.this,MyTabLayout.class));
                break;
            case 7:
                startActivity(new Intent(HomeScreen.this,Contact.class));
                break;
            case 8:
                startActivity(new Intent(HomeScreen.this,Sponors.class));
                break;
            case 9:
                startActivity(new Intent(HomeScreen.this,MapsActivity.class));
                break;
            case 10:
                startActivity(new Intent(HomeScreen.this,PanelDisc.class));
                break;
          /*  case 11:
                startActivity(new Intent(HomeScreen.this,Techtainment.class));
                break;*/
        }
            }
        }));
    }
   /* private final void focusOnView(){
        Display mdisp = getWindowManager().getDefaultDisplay();
        Point mdispSize = new Point();
        mdisp.getSize(mdispSize);
        final int maxX = mdispSize.x;
        final int maxY = mdispSize.y;
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                findViewById(R.id.sv).scrollTo(maxX,maxY);
            }
        });
    }*/
    public String giveDate() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("EEE, MMM d, yyyy");
        return sdf.format(cal.getTime());
    }

    public boolean checkinternetservice() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onSliderClick(BaseSliderView slider) {

    }
}
