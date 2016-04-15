package iit.iitrc.rahil.cognizance_2016;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import iit.iitrc.rahil.cognizance_2016.DataBaseHelper;

public class DataAdapter2
{
    protected static final String TAG = "DataAdapter";

    private final Context mContext;
    private SQLiteDatabase mDb;
    private DataBaseHelper2 mDbHelper;
    private final String TABLENAME="Sheet1";

    public DataAdapter2(Context context)
    {
        this.mContext = context;
        mDbHelper = new DataBaseHelper2(mContext);
    }
    public DataAdapter2 createDatabase() throws SQLException

    {
        try
        {
            mDbHelper.createDataBase();
        }
        catch (IOException mIOException)
        {
            Log.e(TAG, mIOException.toString() + "  UnableToCreateDatabase");
            throw new Error("UnableToCreateDatabase");
        }
        return this;
    }

    public DataAdapter2 open() throws SQLException
    {
        try
        {
            mDbHelper.openDataBase();
            mDbHelper.close();
            mDb = mDbHelper.getReadableDatabase();
        }
        catch (SQLException mSQLException)
        {
            Log.e(TAG, "open >>"+ mSQLException.toString());
            throw mSQLException;
        }
        return this;
    }

    public void close()
    {
        mDbHelper.close();
    }

   /* public Cursor getTestData()
    {
        try
        {
            String sql ="SELECT * FROM cognidb";
            Cursor mCur = mDb.rawQuery(sql, null);
            if (mCur!=null)
            {
                mCur.moveToNext();
            }
            return mCur;
        }*/

      /*  catch (SQLException mSQLException)
        {
            Log.e(TAG, "getTestData >>"+ mSQLException.toString());
            throw mSQLException;
        }*/

    public List<ScheduleItem> getDay1Events() {
        List<ScheduleItem> result = new ArrayList<>();
        Cursor cursor = mDb.query(TABLENAME,new String[]{"Type","EventName","Location","Timing"},"Day"+"=?", new String[]{"1"}, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                ScheduleItem obj=new ScheduleItem();
                obj.setName(cursor.getString(1));
                obj.setType(cursor.getString(0));
                obj.setLocation(cursor.getString(2));
                obj.setDate(cursor.getString(3));
                result.add(obj);

            } while (cursor.moveToNext());
        }
        return result;
    }
    public List<ScheduleItem> getDay2Events() {
        List<ScheduleItem> result = new ArrayList<>();
        Cursor cursor = mDb.query(TABLENAME,new String[]{"Type","EventName","Location","Timing"},"Day"+"=?", new String[]{"2"}, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                ScheduleItem obj=new ScheduleItem();
                obj.setName(cursor.getString(1));
                obj.setType(cursor.getString(0));
                obj.setLocation(cursor.getString(2));
                obj.setDate(cursor.getString(3));
                result.add(obj);

            } while (cursor.moveToNext());
        }
        return result;
    }
    public List<ScheduleItem> getDay3Events() {
        List<ScheduleItem> result = new ArrayList<>();
        Cursor cursor = mDb.query(TABLENAME,new String[]{"Type","EventName","Location","Timing"},"Day"+"=?", new String[]{"3"}, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                ScheduleItem obj=new ScheduleItem();
                obj.setName(cursor.getString(1));
                obj.setType(cursor.getString(0));
                obj.setLocation(cursor.getString(2));
                obj.setDate(cursor.getString(3));
                result.add(obj);

            } while (cursor.moveToNext());
        }
        return result;
    }
}