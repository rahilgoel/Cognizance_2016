package iit.iitrc.rahil.cognizance_2016;


import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.util.Log;

import com.google.android.gms.gcm.GcmListenerService;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;

public class MyGcmListenerService extends GcmListenerService {

    private static final String TAG = "MyGcmListenerService";
    static Integer id = 0;
    ParseObject p1;
    String message1;
    String type1;
    String date1;
    DataBase db;

    @Override
    public void onMessageReceived(String from, Bundle data) {
        db = new DataBase(getApplicationContext());
        String message = data.getString("type");
        Log.d("notifs", data.getString("message") + "bc");
        Log.d("notifs", data.getString("owner") + " " + data.getString("id") + " " + data.getString("group") + " " + data.getString("amount") + " bc");
        String type = data.getString("type");
        message1 = data.getString("number", "");
        type1 = data.getString("amount", "");
        date1 = data.getString("type", "");
        Log.d("chut", type1);
        sendNotification("check new events at cognizance 2016");
        db.addNotif(message1, date1, type1);
    }

    private void notifyNewExpenseDetails(String finalPersons1, String finalShares1, final String id, final String username, final String eventname) {
        String peoples[] = finalPersons1.split(",");
        final String shares[] = finalShares1.split(",");
        for (int i = 0; i < peoples.length - 1; i++) {
            ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("Regid");
            query.whereEqualTo("name", "cognizance");
            final int finalI = i;
            query.findInBackground(new FindCallback<ParseObject>() {
                @Override
                public void done(final List<ParseObject> list, ParseException e) {
                    if (e == null && list.size() > 0) {
                        new AsyncTask<String, Void, String>() {
                            @Override
                            protected String doInBackground(String... params) {
                                InputStream inputStream = null;
                                HttpURLConnection urlConnection = null;
                                Integer result = 0;
                                try {
                                    String url = "http://www.letscontree.com/send.php?API_KEY=AIzaSyDQNdraUDMMDe-WEUyv7pymJDdcv_hrT6M";
                                    String regId = list.get(0).getString("reg_id");
                                    url += "&to=" + regId;
                                    url += "&type=expense&type1=newexpense&id=" + id + "&grp=" + username + "&owner=" + eventname + "&amt=";
                                    url += shares[finalI];
                                    url += "&number=" + ParseUser.getCurrentUser().getUsername();
                                    URL newurl = new URL(url);
                                    urlConnection = (HttpURLConnection) newurl.openConnection();
                                    urlConnection.setRequestProperty("Content-Type", "application/json");
                                    urlConnection.setRequestProperty("Accept", "application/json");
                                    urlConnection.setRequestMethod("GET");
                                    Log.d("url", url);
                                } catch (MalformedURLException e1) {
                                    e1.printStackTrace();
                                } catch (ProtocolException e1) {
                                    e1.printStackTrace();
                                } catch (IOException e1) {
                                    e1.printStackTrace();
                                }
                                return null;
                            }

                            @Override
                            protected void onPostExecute(String s) {
                                super.onPostExecute(s);
                            }
                        }

                                .execute();
                    }
                }
            });
        }
    }
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private void sendNotification(String message) {
        Intent switchIntent = new Intent(this, HomeScreen.class);
        PendingIntent pendingSwitchIntent = PendingIntent.getBroadcast(this, 0,
                switchIntent, 0);
        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(this)
                        .setAutoCancel(true)
                        .setSmallIcon(R.mipmap.app)
                        .setContentTitle("Cognizance")
                        .setStyle(new NotificationCompat.BigPictureStyle().bigPicture(BitmapFactory.decodeResource(this.getResources(),
                                R.mipmap.chandigarh)))
                        .setLargeIcon(BitmapFactory.decodeResource(this.getResources(),
                                R.drawable.cogni_logo))
                        .setSound(defaultSoundUri)
                        .setContentText(message);
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
}