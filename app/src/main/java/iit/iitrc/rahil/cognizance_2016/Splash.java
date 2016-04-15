package iit.iitrc.rahil.cognizance_2016;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import com.firebase.client.Firebase;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Splash extends AppCompatActivity {
SharedPreferences prefs;
    SharedPreferences.Editor editor;
    GPSTracker gps;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        Firebase.setAndroidContext(this);
        final Firebase myFirebaseRef = new Firebase("https://cogni.firebaseio.com/");
        boolean check=false;
        prefs=getSharedPreferences("mydata",Context.MODE_PRIVATE);
        editor=prefs.edit();
       // editor.putBoolean("check",check).commit();
        setContentView(R.layout.activity_splash);
        if (checkinternetservice() && prefs.getBoolean("check", false)==false ) {
            editor.putBoolean("check",true).commit();
            startService(new Intent(this,RegistrationIntentService.class));
        }
       // editor.putString("latlon","abcd").commit();
        gps = new GPSTracker(Splash.this);
        // check if GPS enabled
        if(gps.canGetLocation()){
            double latitude = gps.getLatitude();
            double longitude = gps.getLongitude();
            // \n is for new line
            if(prefs.getString("latlon","abcd")=="abcd") {
                Map<String, Double> first = new HashMap<String, Double>();
                first.put("lat", latitude);
                first.put("lon", longitude);
                Map<String, Map<String, Double>> cogni = new HashMap<String, Map<String, Double>>();
                cogni.put("first", first);
                myFirebaseRef.push().setValue(first);
                //Toast.makeText(getApplicationContext(), "Your Location is - \nLat: " + latitude + "\nLong: " + longitude, Toast.LENGTH_LONG).show();
                String postId = myFirebaseRef.push().getKey();
                editor.putString("latlon",postId).commit();
                Log.d("id",prefs.getString("latlon","abcd"));
            }else{
                //update at that postId
                final Firebase myFirebaseRef2 = new Firebase("https://cogni.firebaseio.com/"+prefs.getString("latlon","abcd"));
                Firebase change=myFirebaseRef.child(prefs.getString("latlon","abcd"));
                Map<String, Object> nickname = new HashMap<String, Object>();
                nickname.put("lat",latitude);
                nickname.put("lon",longitude);
                change.updateChildren(nickname);
            }
        }else{
            // can't get location
            // GPS or Network is not enabled
            // Ask user to enable GPS/network in settings

            gps.showSettingsAlert();
        }
        ImageView imageView = (ImageView) findViewById(R.id.image);
        final Animation animation = AnimationUtils.loadAnimation(this, R.anim.rotate);
        imageView.startAnimation(animation);
        new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */
            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                    Intent i = new Intent(Splash.this, RsSplash.class);
                    startActivity(i);
                    // close this activity
                    finish();
                }
        }, 4000);
    }
    public boolean checkinternetservice() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null;
    }
}
