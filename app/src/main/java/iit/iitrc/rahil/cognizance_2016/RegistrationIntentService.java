package iit.iitrc.rahil.cognizance_2016;

import android.app.IntentService;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.RingtoneManager;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.google.android.gms.iid.InstanceID;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.SaveCallback;

public class RegistrationIntentService extends IntentService {

    private static final String TAG = "RegIntentService";
    private static final String[] TOPICS = {"global"};
    static Integer id = 0;
    String number = "";
    SharedPreferences prefs;
    SharedPreferences.Editor editor;

    public RegistrationIntentService() {
        super(TAG);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        try {
            prefs = getSharedPreferences("my data", Context.MODE_PRIVATE);
            editor = prefs.edit();
            InstanceID instanceID = InstanceID.getInstance(this);
            String token = instanceID.getToken("312124452963",
                    GoogleCloudMessaging.INSTANCE_ID_SCOPE, null);
            Log.d("rahil", token);
            Log.i(TAG, "GCM Registration Token: " + token);
            sharedPreferences.edit().putString("token", token).apply();
            number = sharedPreferences.getString("numberreg", "");
            String tokenval = sharedPreferences.getString("token", null);
            sendRegistrationToServer(token);
            sharedPreferences.edit().putBoolean(QuickstartPreferences.SENT_TOKEN_TO_SERVER, true).apply();
        } catch (Exception e) {
            Log.d(TAG, "Failed to complete token refresh", e);
            sharedPreferences.edit().putBoolean(QuickstartPreferences.SENT_TOKEN_TO_SERVER, false).apply();
        }
        Intent registrationComplete = new Intent(QuickstartPreferences.REGISTRATION_COMPLETE);
        LocalBroadcastManager.getInstance(this).sendBroadcast(registrationComplete);
    }

    private void sendNotification(String message) {
        Intent switchIntent = new Intent(this, HomeScreen.class);
        PendingIntent pendingSwitchIntent = PendingIntent.getBroadcast(this, 0,
                switchIntent, 0);
        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(this)
                        .setAutoCancel(true)
                        .setSmallIcon(R.mipmap.cogni_logo)
                        .setContentTitle("Cognizance")
                        .setSound(defaultSoundUri)
                        .setStyle(new NotificationCompat.BigTextStyle().bigText(message))
                        .setContentText(message)
                      ;
        Intent resultIntent = new Intent(this, HomeScreen.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(HomeScreen.class);
        stackBuilder.addNextIntent(resultIntent);
        PendingIntent resultPendingIntent =
                stackBuilder.getPendingIntent(
                        0,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );
        mBuilder.setContentIntent(resultPendingIntent);
        NotificationManager mNotificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(id++, mBuilder.build());
    }
    private void sendRegistrationToServer(final String token) {
        ParseObject object = new ParseObject("Regid");
        object.put("reg_id", token);
        object.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if (e != null) {
                    Log.d("error", e.toString());
                } else {
                    Log.d("reg token", token);
                    editor.putBoolean("checknew", true);
                    editor.commit();
                    Toast.makeText(getApplicationContext(), "done", Toast.LENGTH_LONG);
                    Toast.makeText(RegistrationIntentService.this, "Congratulations..you have registered for Cognizance'16", Toast.LENGTH_SHORT).show();
                    sendNotification("Welcome to Cognizance");
                }
            }
        });
    }
}