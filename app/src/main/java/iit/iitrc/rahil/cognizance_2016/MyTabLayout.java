package iit.iitrc.rahil.cognizance_2016;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;


/**nds
 * Created by rahil on 1/19/2016.
 */

public class MyTabLayout extends AppCompatActivity {
int pos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout);
        final CollapsingToolbarLayout toolbar = (CollapsingToolbarLayout) findViewById(R.id.htab_collapse_toolbar);
        //setSupportActionBar(toolbar);
        final ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.htab_tabs);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            ImageView iv = (ImageView) findViewById(R.id.htab_header);

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                switch (tab.getPosition()) {
                    case 0:
                      //  showToast("One");
                        //add day1 list
                        pos = 1;
                        iv.setImageResource(R.mipmap.day1);
                        break;
                    case 1:
                      //  showToast("Two");
                        //add day2list
                        pos = 2;
                        iv.setImageResource(R.mipmap.day2);
                        break;
                    case 2:
                      //  showToast("Three");
                        //add day3 list
                        pos = 3;
                        iv.setImageResource(R.mipmap.day3);
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }


            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }

        });

        switch (pos){
            case 1:
                Bitmap myBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.day1);
                Palette.from(myBitmap).generate(new Palette.PaletteAsyncListener() {
                    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
                    @SuppressWarnings("ResourceType")
                    @Override
                    public void onGenerated(Palette palette) {
                        Palette.Swatch vibrant = palette.getVibrantSwatch();
                        int vibrantColor = palette.getVibrantColor(R.color.colorPrimary);
                        int vibrantDarkColor = palette.getDarkVibrantColor(R.color.colorPrimaryDark);
                        int mutedColor = palette.getMutedColor(R.attr.colorPrimary);
                        toolbar.setContentScrimColor(vibrantColor);
                        Window window = getWindow();
                        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

                        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                        window.setStatusBarColor(getResources().getColor(vibrantDarkColor));
               /* toolbar.setContentScrimColor(vibrant.getRgb());
                toolbar.setStatusBarScrimColor(vibrant.getTitleTextColor());*/
                    }
                });
                break;

            case 2:
                Bitmap myBitmap2 = BitmapFactory.decodeResource(getResources(), R.drawable.day2);
                Palette.from(myBitmap2).generate(new Palette.PaletteAsyncListener() {
                    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
                    @SuppressWarnings("ResourceType")
                    @Override
                    public void onGenerated(Palette palette) {
                        Palette.Swatch vibrant = palette.getVibrantSwatch();
                        int vibrantColor = palette.getVibrantColor(R.color.colorPrimary);
                        int vibrantDarkColor = palette.getDarkVibrantColor(R.color.colorPrimaryDark);
                        int mutedColor = palette.getMutedColor(R.attr.colorPrimary);
                        toolbar.setContentScrimColor(vibrantColor);
                        Window window = getWindow();
                        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                        window.setStatusBarColor(getResources().getColor(vibrantDarkColor));

             /*   toolbar.setContentScrimColor(vibrant.getRgb());
                toolbar.setStatusBarScrimColor(vibrant.getTitleTextColor());*/
                    }
                });
                break;
            case 3:
                Bitmap myBitmap3 = BitmapFactory.decodeResource(getResources(), R.drawable.day3);
                Palette.from(myBitmap3).generate(new Palette.PaletteAsyncListener() {
                    @SuppressWarnings("ResourceType")
                    @Override
                    public void onGenerated(Palette palette) {
                        Palette.Swatch vibrant = palette.getVibrantSwatch();
                        int vibrantColor = palette.getVibrantColor(R.color.colorPrimary);
                        int vibrantDarkColor = palette.getDarkVibrantColor(R.color.colorPrimaryDark);
                        int mutedColor = palette.getMutedColor(R.attr.colorPrimary);
                        toolbar.setContentScrimColor(mutedColor);
               /* toolbar.setContentScrimColor(vibrant.getRgb());
                toolbar.setStatusBarScrimColor(vibrant.getTitleTextColor());*/
                    }
                });
                break;
        }
    }


    public void showToast(String text){
        Toast.makeText(getApplicationContext(),text,Toast.LENGTH_SHORT).show();
    }

    private void setupViewPager(ViewPager viewPager) {
        MyViewPagerAdapter adapter = new MyViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(DummyFragment.newInstance(getResources().getColor(R.color.rahil),1), "Day 1");
        adapter.addFrag(DummyFragment.newInstance(getResources().getColor(R.color.rahil),2), "Day 2");
        adapter.addFrag(DummyFragment.newInstance(getResources().getColor(R.color.rahil),3), "Day 3");
        viewPager.setAdapter(adapter);
    }
}
