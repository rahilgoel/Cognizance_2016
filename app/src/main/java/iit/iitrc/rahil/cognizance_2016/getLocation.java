package iit.iitrc.rahil.cognizance_2016;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.firebase.client.Firebase;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rahil on 3/9/2016.
 */
public class getLocation extends AppCompatActivity{

    Button btnShowLocation;
    // GPSTracker class
    GPSTracker gps;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.getlocation);
        Firebase.setAndroidContext(this);
        findViewById(R.id.maps).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getLocation.this,MapsActivity.class));
            }
        });
        final Firebase myFirebaseRef = new Firebase("https://cogni.firebaseio.com/");
        btnShowLocation = (Button) findViewById(R.id.btnShowLocation);
        // show location button click event
        btnShowLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // create class object
                gps = new GPSTracker(getLocation.this);
                // check if GPS enabled
                if(gps.canGetLocation()){
                    double latitude = gps.getLatitude();
                    double longitude = gps.getLongitude();
                    // \n is for new line
                    Map<String, Double> first = new HashMap<String, Double>();
                    first.put("lat", latitude);
                    first.put("lon", longitude);
                    Map<String, Map<String, Double>> cogni= new HashMap<String, Map<String, Double>>();
                    cogni.put("first", first);
                    myFirebaseRef.push().setValue(first);
                    Map<String, Double> second = new HashMap<String, Double>();
                    first.put("lat", latitude);
                    first.put("lon", latitude);
                    Map<String, Map<String, String>> cogni2= new HashMap<String, Map<String, String>>();
                    cogni.put("second", second);
                    myFirebaseRef.push().setValue(second);
                    Toast.makeText(getApplicationContext(), "Your Location is - \nLat: " + latitude + "\nLong: " + longitude, Toast.LENGTH_LONG).show();
                }else{
                    // can't get location
                    // GPS or Network is not enabled
                    // Ask user to enable GPS/network in settings
                    gps.showSettingsAlert();
                }
            }
        });
    }
}
