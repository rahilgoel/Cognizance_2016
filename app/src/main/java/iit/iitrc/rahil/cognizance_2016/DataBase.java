package iit.iitrc.rahil.cognizance_2016;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rahil on 1/31/2016.
 */

public class DataBase extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Cogni.db";
    public static final String TABLE_NAME = "notifications";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "MESSAGE";
    public static final String COL_3 = "DATE";
    public static final String COL_4 = "TYPE";
    List<String> list = new ArrayList<String>();
    public DataBase(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "CREATE TABLE "
                        + TABLE_NAME + "(" + COL_1 + " INTEGER PRIMARY KEY AUTOINCREMENT," + COL_2
                        + " TEXT," + COL_3 + " TEXT," + COL_4 + " TEXT" + ")"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }


    public boolean addNotif(String message, String date, String type) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL_2, message);
        cv.put(COL_3, date);
        cv.put(COL_4, type);
        long result = db.insert(TABLE_NAME, null, cv);
        if (result == -1) {
            Log.d("nhi hua", "d");
            return false;

        } else {
            Log.d("hua", "d");
            return true;
        }
    }

    public List<NotifObject> getNotifExpanse() {
        ArrayList<NotifObject> result = new ArrayList<NotifObject>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, null,COL_4+"=?", new String[]{"expanse"}, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                NotifObject object = new NotifObject();
                object.setMessage(cursor.getString(1));
                object.setDate(cursor.getString(2));
                object.setType(cursor.getString(3));
                Log.d("hahah", cursor.getString(0) + " " + cursor.getInt(1) +" "+ cursor.getString(2));
                result.add(object);
            } while (cursor.moveToNext());
        }
        return result;
    }

    public List<NotifObject> getNotifEvents() {
        ArrayList<NotifObject> result = new ArrayList<NotifObject>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, null,COL_4+"=?", new String[]{"events"}, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                NotifObject object = new NotifObject();
                object.setMessage(cursor.getString(1));
                object.setDate(cursor.getString(2));
                object.setType(cursor.getString(3));
                Log.d("hahah", cursor.getString(0) + " " + cursor.getInt(1) +" "+ cursor.getString(2));
                result.add(object);
            } while (cursor.moveToNext());
        }
        return result;
    }
    public List<NotifObject> getNotifWorkshop() {
        ArrayList<NotifObject> result = new ArrayList<NotifObject>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, null,COL_4+"=?", new String[]{"workshop"}, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                NotifObject object = new NotifObject();
                object.setMessage(cursor.getString(1));
                object.setDate(cursor.getString(2));
                object.setType(cursor.getString(3));
                Log.d("hahah", cursor.getString(0) + " " + cursor.getInt(1) +" "+ cursor.getString(2));
                result.add(object);
            } while (cursor.moveToNext());
        }
        return result;
    }
    public List<NotifObject> getNotifGeneral() {
        ArrayList<NotifObject> result = new ArrayList<NotifObject>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, null,COL_4+"=?", new String[]{"general"}, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                NotifObject object = new NotifObject();
                object.setMessage(cursor.getString(1));
                object.setDate(cursor.getString(2));
                object.setType(cursor.getString(3));
                Log.d("hahah", cursor.getString(0) + " " + cursor.getInt(1) +" "+ cursor.getString(2));
                result.add(object);
            } while (cursor.moveToNext());
        }
        return result;
    }

    public ArrayList<String> getAllData() {
        ArrayList<String> names = new ArrayList<String>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(TABLE_NAME, null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                names.add(cursor.getString(1));
            } while (cursor.moveToNext());
        }
        return names;
    }
}
