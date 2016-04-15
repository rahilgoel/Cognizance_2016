package iit.iitrc.rahil.cognizance_2016;

import android.*;
import android.Manifest;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Contact extends AppCompatActivity implements View.OnClickListener {
    final private int REQUEST_CODE_ASK_PERMISSIONS = 123;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        SpannableString s = new SpannableString("Contact");
        s.setSpan(new TypefaceSpan(this, "MyTypeface.otf"), 0, s.length(),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        getSupportActionBar().setTitle(s);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        LinearLayout la = (LinearLayout) findViewById(R.id.a);
        LinearLayout lb = (LinearLayout) findViewById(R.id.b);
        LinearLayout lc = (LinearLayout) findViewById(R.id.c);
        LinearLayout ld = (LinearLayout) findViewById(R.id.d);
        LinearLayout le = (LinearLayout) findViewById(R.id.e);
        LinearLayout lf = (LinearLayout) findViewById(R.id.f);
        LinearLayout lg = (LinearLayout) findViewById(R.id.g);
        LinearLayout lh = (LinearLayout) findViewById(R.id.h);
        LinearLayout li = (LinearLayout) findViewById(R.id.i);
        LinearLayout lj = (LinearLayout) findViewById(R.id.j);
        LinearLayout lk = (LinearLayout) findViewById(R.id.k);
        LinearLayout ll = (LinearLayout) findViewById(R.id.l);
        la.setOnClickListener(this);
        lb.setOnClickListener(this);
        lc.setOnClickListener(this);
        ld.setOnClickListener(this);
        le.setOnClickListener(this);
        lf.setOnClickListener(this);
        lg.setOnClickListener(this);
        lh.setOnClickListener(this);
        li.setOnClickListener(this);
        lj.setOnClickListener(this);
        lk.setOnClickListener(this);
        ll.setOnClickListener(this);

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }
   /* private  boolean checkAndRequestPermissions() {
        int callpermission = ContextCompat.checkSelfPermission(this,
                Manifest.permission.CALL_PHONE);

        //int externalstoragePermission = ContextCompat.checkSelfPermission(this, android.Manifest.permission.READ_EXTERNAL_STORAGE);
       // int externalstoragewritePermission = ContextCompat.checkSelfPermission(this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE);
      *//*  List<String> listPermissionsNeeded = new ArrayList<>();
        if (camerapermission != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(android.Manifest.permission.CAMERA);
        }
        if (externalstoragePermission != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(android.Manifest.permission.READ_EXTERNAL_STORAGE);
        }

        if (externalstoragewritePermission != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(android.Manifest.permission.WRITE_EXTERNAL_STORAGE);
        }*//*
        if (!listPermissionsNeeded.isEmpty()) {
            ActivityCompat.requestPermissions(this, listPermissionsNeeded.toArray(new String[listPermissionsNeeded.size()]),REQUEST_ID_MULTIPLE_PERMISSIONS);
            return false;
        }
        return true;
    }*/
    @TargetApi(Build.VERSION_CODES.M)
    @Override

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.a:
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "+91-9897772915"));
                if (ContextCompat.checkSelfPermission(this,android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    public void requestPermissions(@NonNull String[] permissions, int requestCode)
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for Activity#requestPermissions for more details.
                    requestPermissions(new String[]{Manifest.permission.CALL_PHONE},REQUEST_CODE_ASK_PERMISSIONS
                            );
                    return;
                }
                startActivity(intent);
                break;
            case R.id.b:
                Intent intentb = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "+91-8676761361"));
                if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    public void requestPermissions(@NonNull String[] permissions, int requestCode)
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for Activity#requestPermissions for more details.
                    requestPermissions(new String[]{Manifest.permission.CALL_PHONE},REQUEST_CODE_ASK_PERMISSIONS
                    );
                    return;
                }
                startActivity(intentb);
                break;
            case R.id.c:
                Intent intentc = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "+91-8449024424"));
                if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    public void requestPermissions(@NonNull String[] permissions, int requestCode)
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for Activity#requestPermissions for more details.
                    requestPermissions(new String[]{Manifest.permission.CALL_PHONE},REQUEST_CODE_ASK_PERMISSIONS
                    );
                    return;
                }
                startActivity(intentc);
                break;
            case R.id.d:
                Intent intentd = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "+91-7060334334"));
                if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    public void requestPermissions(@NonNull String[] permissions, int requestCode)
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for Activity#requestPermissions for more details.
                    requestPermissions(new String[]{Manifest.permission.CALL_PHONE},REQUEST_CODE_ASK_PERMISSIONS
                    );
                    return;
                }
                startActivity(intentd);
                break;
            case R.id.e:
                Intent intente = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "+91-7895382673"));
                if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    public void requestPermissions(@NonNull String[] permissions, int requestCode)
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for Activity#requestPermissions for more details.
                    requestPermissions(new String[]{Manifest.permission.CALL_PHONE},REQUEST_CODE_ASK_PERMISSIONS
                    );
                    return;
                }
                startActivity(intente);
                break;
            case R.id.f:
                Intent intentf = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "+91-8439792725"));
                if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    public void requestPermissions(@NonNull String[] permissions, int requestCode)
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for Activity#requestPermissions for more details.
                    requestPermissions(new String[]{Manifest.permission.CALL_PHONE},REQUEST_CODE_ASK_PERMISSIONS
                    );
                    return;
                }
                startActivity(intentf);
                break;
            case R.id.g:
                Intent intentg = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "+91-9927524144"));
                if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    public void requestPermissions(@NonNull String[] permissions, int requestCode)
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for Activity#requestPermissions for more details.
                    requestPermissions(new String[]{Manifest.permission.CALL_PHONE},REQUEST_CODE_ASK_PERMISSIONS
                    );
                    return;
                }
                startActivity(intentg);
                break;
            case R.id.h:
                Intent intenth = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "+91-7060467068"));
                if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    public void requestPermissions(@NonNull String[] permissions, int requestCode)
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for Activity#requestPermissions for more details.
                    requestPermissions(new String[]{Manifest.permission.CALL_PHONE},REQUEST_CODE_ASK_PERMISSIONS
                    );
                    return;
                }
                startActivity(intenth);
                break;
            case R.id.i:
                Intent intenti = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "+91-8006366524"));
                if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    public void requestPermissions(@NonNull String[] permissions, int requestCode)
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for Activity#requestPermissions for more details.
                    requestPermissions(new String[]{Manifest.permission.CALL_PHONE},REQUEST_CODE_ASK_PERMISSIONS
                    );
                    return;
                }
                startActivity(intenti);
                break;
            case R.id.j:
                Intent intentj = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "+91-7060334068"));
                if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    public void requestPermissions(@NonNull String[] permissions, int requestCode)
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for Activity#requestPermissions for more details.
                    requestPermissions(new String[]{Manifest.permission.CALL_PHONE},REQUEST_CODE_ASK_PERMISSIONS
                    );
                    return;
                }
                startActivity(intentj);
                break;
            case R.id.k:
                Intent intentk = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "+91-8394954354"));
                if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    public void requestPermissions(@NonNull String[] permissions, int requestCode)
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for Activity#requestPermissions for more details.
                    requestPermissions(new String[]{Manifest.permission.CALL_PHONE},REQUEST_CODE_ASK_PERMISSIONS
                    );
                    return;
                }
                startActivity(intentk);
                break;
            case R.id.l:
                Intent intentl = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "+91-7409719007"));
                if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    public void requestPermissions(@NonNull String[] permissions, int requestCode)
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for Activity#requestPermissions for more details.
                    requestPermissions(new String[]{Manifest.permission.CALL_PHONE},REQUEST_CODE_ASK_PERMISSIONS
                    );
                    return;
                }
                startActivity(intentl);
                break;



        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CODE_ASK_PERMISSIONS:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // Permission Granted
                  Log.d("rahil","De di permission");
                } else {
                    // Permission Denied
                    Toast.makeText(Contact.this, "WRITE_CONTACTS Denied", Toast.LENGTH_SHORT)
                            .show();
                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }
}
