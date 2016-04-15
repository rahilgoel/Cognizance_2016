package iit.iitrc.rahil.cognizance_2016;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    Firebase ref;

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps2);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        LayoutInflater inflater = getLayoutInflater();
        View dialoglayout = inflater.inflate(R.layout.mapdailog, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(dialoglayout);
        builder.show();
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }
    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */

    @Override
    public void onMapReady(GoogleMap googleMap) {
        Firebase.setAndroidContext(this);
        ref = new Firebase("https://cogni.firebaseio.com/");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                System.out.println("There are " + snapshot.getChildrenCount() + " blog posts");
                List<Latlong> list = new ArrayList<Latlong>();
                for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                    Latlong post = postSnapshot.getValue(Latlong.class);
                    //System.out.println(post.get() + " - " + post.getTitle());
                    Log.d("hahah",""+post.getLat()+post.getLon()+"rahil");
                    list.add(post);
                    Log.d("haha", "" + list.size());
                    Log.d("yahah to hai", "check kar le");
                    Log.d("size",""+list.size());
                    mMap.addCircle(new CircleOptions().center(new LatLng(post.getLat(), post.getLon()))
                            .radius(1)
                            .strokeColor(Color.BLUE)
                            .fillColor(Color.BLACK));
                   /* for (int i = 0; i < list.size(); i++) {
                        Log.d("check", "" + list.get(i).getLat() + list.get(i).getLon() + "rahil");

                    }*/
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                System.out.println("The read failed: " + firebaseError.getMessage());
            }
        });

        mMap = googleMap;
        // Add a marker in Sydney and move the camera
        LatLng coordinate = new LatLng(29.864692, 77.896514);
        //CameraUpdate yourLocation = CameraUpdateFactory.newLatLngZoom(coordinate, 5);
        //mMap.animateCamera(yourLocation);
        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(coordinate)      // Sets the center of the map to Mountain View
                .zoom(12)                   // Sets the zoom
                .bearing(90)                // Sets the orientation of the camera to east
                .tilt(30)                   // Sets the tilt of the camera to 30 degrees
                .build();                   // Creates a CameraPosition from the builder
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(29.865269, 77.894529))
                .title("MGCL"));
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(29.864692, 77.896544))
                .title("Main Building"));
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(29.864804, 77.894654))
                .title("DOMS"));
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(29.864042, 77.894646))
                .title("Registrations"));
    }
       /* LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));*/
}

