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

public class DataAdapter
{
    protected static final String TAG = "DataAdapter";

    private final Context mContext;
    private SQLiteDatabase mDb;
    private DataBaseHelper mDbHelper;
    private final String TABLENAME="eventsdes";

    public DataAdapter(Context context)
    {
        this.mContext = context;
        mDbHelper = new DataBaseHelper(mContext);
    }

    public DataAdapter createDatabase() throws SQLException
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

    public DataAdapter open() throws SQLException
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

      public HashSet<String> getCenterStageCat() {
          HashSet<String> result = new HashSet<String>();
          Cursor cursor = mDb.query(TABLENAME,new String[]{"sub"},"category"+"=?", new String[]{"Centerstage"}, null, null, null);
          if (cursor.moveToFirst()) {
              do {
                  result.add(cursor.getString(0));
              } while (cursor.moveToNext());
          }
          return result;
      }

    public HashSet<String> getCenterStageEvents() {
        HashSet<String> result = new HashSet<String>();
        Cursor cursor = mDb.query(TABLENAME,new String[]{"sub"},"category"+"=?", new String[]{"Centerstage"}, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                result.add(cursor.getString(0));
            } while (cursor.moveToNext());
        }
        return result;
    }
    public List<EventObject> getThemeEvents(){
        List<EventObject> result=new ArrayList<EventObject>();
        Cursor cursor=mDb.query(TABLENAME,new String[]{"title","description","id","mobile","person","tagline"},"sub"+"=?",new String[]{"Theme"},null,null,null);
        if (cursor.moveToFirst()) {
            do {
                EventObject object=new EventObject();
                object.setName(cursor.getString(0));
                object.setDes(cursor.getString(1));
                object.setTagline(cursor.getString(5));
                object.setContact(cursor.getString(3));
                object.setContactname(cursor.getString(4));
                result.add(object);
            } while (cursor.moveToNext());
        }
        return result;
    }
    public List<EventObject> getShellEventsEvents(){
        List<EventObject> result=new ArrayList<EventObject>();
        Cursor cursor=mDb.query(TABLENAME,new String[]{"title","description","id","mobile","person","tagline"},"sub"+"=?",new String[]{"ShellEvents"},null,null,null);
        if (cursor.moveToFirst()) {
            do {
                EventObject object=new EventObject();
                object.setName(cursor.getString(0));
                object.setDes(cursor.getString(1));
                object.setTagline(cursor.getString(5));
                object.setContact(cursor.getString(3));
                object.setContactname(cursor.getString(4));
                result.add(object);
            } while (cursor.moveToNext());
        }
        return result;
    }

    public List<EventObject> getFuzzyLogixEvents(){
        List<EventObject> result=new ArrayList<EventObject>();
        Cursor cursor=mDb.query(TABLENAME,new String[]{"title","description","id","mobile","person","tagline"},"sub"+"=?",new String[]{"FuzzyLogix"},null,null,null);
        if (cursor.moveToFirst()) {
            do {
                EventObject object=new EventObject();
                object.setName(cursor.getString(0));
                object.setDes(cursor.getString(1));
                object.setTagline(cursor.getString(5));
                object.setContact(cursor.getString(3));
                object.setContactname(cursor.getString(4));
                result.add(object);
            } while (cursor.moveToNext());
        }
        return result;
    }

    public List<EventObject> getLiterarioEvents(){
        List<EventObject> result=new ArrayList<EventObject>();
        Cursor cursor=mDb.query(TABLENAME,new String[]{"title","description","title","mobile","person","tagline"},"sub"+"=?",new String[]{"Literario"},null,null,null);
        if (cursor.moveToFirst()) {
            do {
                EventObject object=new EventObject();
                object.setName(cursor.getString(0));
                object.setDes(cursor.getString(1));
                object.setTagline(cursor.getString(5));
                object.setContact(cursor.getString(3));
                object.setContactname(cursor.getString(4));
                result.add(object);
            } while (cursor.moveToNext());
        }
        return result;
    }
    public List<EventObject> getOnlineEvents(){
        List<EventObject> result=new ArrayList<EventObject>();
        Cursor cursor=mDb.query(TABLENAME,new String[]{"title","description","title","mobile","person","tagline"},"sub"+"=?",new String[]{"Online"},null,null,null);
        if (cursor.moveToFirst()) {
            do {
                EventObject object=new EventObject();
                object.setName(cursor.getString(0));
                object.setDes(cursor.getString(1));
                object.setTagline(cursor.getString(5));
                object.setContact(cursor.getString(3));
                object.setContactname(cursor.getString(4));
                result.add(object);
            } while (cursor.moveToNext());
        }
        return result;
    }
    public List<EventObject> getCompetitionsEvents(){
        List<EventObject> result=new ArrayList<EventObject>();
        Cursor cursor=mDb.query(TABLENAME,new String[]{"title","description","title","mobile","person","tagline"},"sub"+"=?",new String[]{"Competitions"},null,null,null);
        if (cursor.moveToFirst()) {
            do {
                EventObject object=new EventObject();
                object.setName(cursor.getString(0));
                object.setDes(cursor.getString(1));
                object.setTagline(cursor.getString(5));
                object.setContact(cursor.getString(3));
                object.setContactname(cursor.getString(4));
                result.add(object);
            } while (cursor.moveToNext());
        }
        return result;
    }
    public List<EventObject> getRoboticsEvents(){
        List<EventObject> result=new ArrayList<EventObject>();
        Cursor cursor=mDb.query(TABLENAME,new String[]{"title","description","title","mobile","person","tagline"},"sub"+"=?",new String[]{"Robotics"},null,null,null);
        if (cursor.moveToFirst()) {
            do {
                EventObject object=new EventObject();
                object.setName(cursor.getString(0));
                object.setDes(cursor.getString(1));
                object.setTagline(cursor.getString(5));
                object.setContact(cursor.getString(3));
                object.setContactname(cursor.getString(4));
                result.add(object);
            } while (cursor.moveToNext());
        }
        return result;
    }
    public List<EventObject> getNanotechEvents(){
        List<EventObject> result=new ArrayList<EventObject>();
        Cursor cursor=mDb.query(TABLENAME,new String[]{"title","description","title","mobile","person","tagline"},"sub"+"=?",new String[]{"Nanotechnology"},null,null,null);
        if (cursor.moveToFirst()) {
            do {
                EventObject object=new EventObject();
                object.setName(cursor.getString(0));
                object.setDes(cursor.getString(1));
                object.setTagline(cursor.getString(5));
                object.setContact(cursor.getString(3));
                object.setContactname(cursor.getString(4));
                result.add(object);
            } while (cursor.moveToNext());
        }
        return result;
    }
    public List<EventObject> getMetallurgicalEvents(){
        List<EventObject> result=new ArrayList<EventObject>();
        Cursor cursor=mDb.query(TABLENAME,new String[]{"title","description","title","mobile","person","tagline"},"sub"+"=?",new String[]{"Metallurgical and Materials Engineering"},null,null,null);
        if (cursor.moveToFirst()) {
            do {
                EventObject object=new EventObject();
                object.setName(cursor.getString(0));
                object.setDes(cursor.getString(1));
                object.setTagline(cursor.getString(5));
                object.setContact(cursor.getString(3));
                object.setContactname(cursor.getString(4));
                result.add(object);
            } while (cursor.moveToNext());
        }
        return result;
    }
    public List<EventObject> getMechanicalEvents(){
        List<EventObject> result=new ArrayList<EventObject>();
        Cursor cursor=mDb.query(TABLENAME,new String[]{"title","description","title","mobile","person","tagline"},"sub"+"=?",new String[]{"Mechanical and Industrial Engineering"},null,null,null);
        if (cursor.moveToFirst()) {
            do {
                EventObject object=new EventObject();
                object.setName(cursor.getString(0));
                object.setDes(cursor.getString(1));
                object.setTagline(cursor.getString(5));
                object.setContact(cursor.getString(3));
                object.setContactname(cursor.getString(4));
                result.add(object);
            } while (cursor.moveToNext());
        }
        return result;
    }
    public List<EventObject> getMathematicsEvents(){
        List<EventObject> result=new ArrayList<EventObject>();
        Cursor cursor=mDb.query(TABLENAME,new String[]{"title","description","title","mobile","person","tagline"},"sub"+"=?",new String[]{"Mathematics"},null,null,null);
        if (cursor.moveToFirst()) {
            do {
                EventObject object=new EventObject();
                object.setName(cursor.getString(0));
                object.setDes(cursor.getString(1));
                object.setTagline(cursor.getString(5));
                object.setContact(cursor.getString(3));
                object.setContactname(cursor.getString(4));
                result.add(object);
            } while (cursor.moveToNext());
        }
        return result;
    }
    public List<EventObject> getElectronicsandCommunicationEngineeringEvents(){
        List<EventObject> result=new ArrayList<EventObject>();
        Cursor cursor=mDb.query(TABLENAME,new String[]{"title","description","title","mobile","person","tagline"},"sub"+"=?",new String[]{"Electronics and Communication Engineering"},null,null,null);
        if (cursor.moveToFirst()) {
            do {
                EventObject object=new EventObject();
                object.setName(cursor.getString(0));
                object.setDes(cursor.getString(1));
                object.setTagline(cursor.getString(5));
                object.setContact(cursor.getString(3));
                object.setContactname(cursor.getString(4));
                result.add(object);
            } while (cursor.moveToNext());
        }
        return result;
    }
    public List<EventObject> getElectricalEngineeringEvents(){
    List<EventObject> result=new ArrayList<EventObject>();
    Cursor cursor=mDb.query(TABLENAME,new String[]{"title","description","title","mobile","person","tagline"},"sub"+"=?",new String[]{"Electrical Engineering"},null,null,null);
    if (cursor.moveToFirst()) {
        do {
            EventObject object=new EventObject();
            object.setName(cursor.getString(0));
            object.setDes(cursor.getString(1));
            object.setTagline(cursor.getString(5));
            object.setContact(cursor.getString(3));
            object.setContactname(cursor.getString(4));
            result.add(object);
        } while (cursor.moveToNext());
    }
    return result;
    }
    public List<EventObject> getEarthquakeEngineeringEvents(){
    List<EventObject> result=new ArrayList<EventObject>();
    Cursor cursor=mDb.query(TABLENAME,new String[]{"title","description","title","mobile","person","tagline"},"sub"+"=?",new String[]{"Earthquake Engineering"},null,null,null);
    if (cursor.moveToFirst()) {
        do {
            EventObject object=new EventObject();
            object.setName(cursor.getString(0));
            object.setDes(cursor.getString(1));
            object.setTagline(cursor.getString(5));
            object.setContact(cursor.getString(3));
            object.setContactname(cursor.getString(4));
            result.add(object);
        } while (cursor.moveToNext());
    }
    return result;
    }
    public List<EventObject> getDepartmentofPhysicsEvents(){
        List<EventObject> result=new ArrayList<EventObject>();
        Cursor cursor=mDb.query(TABLENAME,new String[]{"title","description","title","mobile","person","tagline"},"sub"+"=?",new String[]{"Department of Physics"},null,null,null);
        if (cursor.moveToFirst()) {
            do {
                EventObject object=new EventObject();
                object.setName(cursor.getString(0));
                object.setDes(cursor.getString(1));
                object.setTagline(cursor.getString(5));
                object.setContact(cursor.getString(3));
                object.setContactname(cursor.getString(4));
                result.add(object);
            } while (cursor.moveToNext());
        }
        return result;
    }
    public List<EventObject> getDepartmentofPaperTechnologyEvents(){
        List<EventObject> result=new ArrayList<EventObject>();
        Cursor cursor=mDb.query(TABLENAME,new String[]{"title","description","title","mobile","person","tagline"},"sub"+"=?",new String[]{"Department of Paper Technology"},null,null,null);
        if (cursor.moveToFirst()) {
            do {
                EventObject object=new EventObject();
                object.setName(cursor.getString(0));
                object.setDes(cursor.getString(1));
                object.setTagline(cursor.getString(5));
                object.setContact(cursor.getString(3));
                object.setContactname(cursor.getString(4));
                result.add(object);
            } while (cursor.moveToNext());
        }
        return result;
    }
    public List<EventObject> getDepartmentofManagementStudiesEvents(){
        List<EventObject> result=new ArrayList<EventObject>();
        Cursor cursor=mDb.query(TABLENAME,new String[]{"title","description","title","mobile","person","tagline"},"sub"+"=?",new String[]{"Department of Management Studies"},null,null,null);
        if (cursor.moveToFirst()) {
            do {
                EventObject object=new EventObject();
                object.setName(cursor.getString(0));
                object.setDes(cursor.getString(1));
                object.setTagline(cursor.getString(5));
                object.setContact(cursor.getString(3));
                object.setContactname(cursor.getString(4));
                result.add(object);
            } while (cursor.moveToNext());
        }
        return result;
    }
    public List<EventObject> getDepartmentofHydrologyEvents(){
        List<EventObject> result=new ArrayList<EventObject>();
        Cursor cursor=mDb.query(TABLENAME,new String[]{"title","description","title","mobile","person","tagline"},"sub"+"=?",new String[]{"Department of Hydrology"},null,null,null);
        if (cursor.moveToFirst()) {
            do {
                EventObject object=new EventObject();
                object.setName(cursor.getString(0));
                object.setDes(cursor.getString(1));
                object.setTagline(cursor.getString(5));
                object.setContact(cursor.getString(3));
                object.setContactname(cursor.getString(4));
                result.add(object);
            } while (cursor.moveToNext());
        }
        return result;
    }
    public List<EventObject> getDepartmentofEarthScienceEvents(){
        List<EventObject> result=new ArrayList<EventObject>();
        Cursor cursor=mDb.query(TABLENAME,new String[]{"title","description","title","mobile","person","tagline"},"sub"+"=?",new String[]{"Department of Earth Science"},null,null,null);
        if (cursor.moveToFirst()) {
            do {
                EventObject object=new EventObject();
                object.setName(cursor.getString(0));
                object.setDes(cursor.getString(1));
                object.setTagline(cursor.getString(5));
                object.setContact(cursor.getString(3));
                object.setContactname(cursor.getString(4));
                result.add(object);
            } while (cursor.moveToNext());
        }
        return result;
    }
    public List<EventObject> getComputerScienceEvents(){
        List<EventObject> result=new ArrayList<EventObject>();
        Cursor cursor=mDb.query(TABLENAME,new String[]{"title","description","title","mobile","person","tagline"},"sub"+"=?",new String[]{"Computer Science"},null,null,null);
        if (cursor.moveToFirst()) {
            do {
                EventObject object=new EventObject();
                object.setName(cursor.getString(0));
                object.setDes(cursor.getString(1));
                object.setTagline(cursor.getString(5));
                object.setContact(cursor.getString(3));
                object.setContactname(cursor.getString(4));
                result.add(object);
            } while (cursor.moveToNext());
        }
        return result;
    }
    public List<EventObject> getCivilEngineeringEvents(){
        List<EventObject> result=new ArrayList<EventObject>();
        Cursor cursor=mDb.query(TABLENAME,new String[]{"title","description","title","mobile","person","tagline"},"sub"+"=?",new String[]{"Civil Engineering"},null,null,null);
        if (cursor.moveToFirst()) {
            do {
                EventObject object=new EventObject();
                object.setName(cursor.getString(0));
                object.setDes(cursor.getString(1));
                object.setTagline(cursor.getString(5));
                object.setContact(cursor.getString(3));
                object.setContactname(cursor.getString(4));
                result.add(object);
            } while (cursor.moveToNext());
        }
        return result;
    }
    public List<EventObject> getChemistryEvents(){
        List<EventObject> result=new ArrayList<EventObject>();
        Cursor cursor=mDb.query(TABLENAME,new String[]{"title","description","title","mobile","person","tagline"},"sub"+"=?",new String[]{"Chemistry"},null,null,null);
        if (cursor.moveToFirst()) {
            do {
                EventObject object=new EventObject();
                object.setName(cursor.getString(0));
                object.setDes(cursor.getString(1));
                object.setTagline(cursor.getString(5));
                object.setContact(cursor.getString(3));
                object.setContactname(cursor.getString(4));
                result.add(object);
            } while (cursor.moveToNext());
        }
        return result;
    }
    public List<EventObject> getChemicalEngineeringEvents(){
        List<EventObject> result=new ArrayList<EventObject>();
        Cursor cursor=mDb.query(TABLENAME,new String[]{"title","description","title","mobile","person","tagline"},"sub"+"=?",new String[]{"Chemical Engineering"},null,null,null);
        if (cursor.moveToFirst()) {
            do {
                EventObject object=new EventObject();
                object.setName(cursor.getString(0));
                object.setDes(cursor.getString(1));
                object.setTagline(cursor.getString(5));
                object.setContact(cursor.getString(3));
                object.setContactname(cursor.getString(4));
                result.add(object);
            } while (cursor.moveToNext());
        }
        return result;
    }
    public List<EventObject> getCenterofTransportationSystemsEvents(){
        List<EventObject> result=new ArrayList<EventObject>();
        Cursor cursor=mDb.query(TABLENAME,new String[]{"title","description","title","mobile","person","tagline"},"sub"+"=?",new String[]{"Center of Transportation Systems"},null,null,null);
        if (cursor.moveToFirst()) {
            do {
                EventObject object=new EventObject();
                object.setName(cursor.getString(0));
                object.setDes(cursor.getString(1));
                object.setTagline(cursor.getString(5));
                object.setContact(cursor.getString(3));
                object.setContactname(cursor.getString(4));
                result.add(object);
            } while (cursor.moveToNext());
        }
        return result;
    }
    public List<EventObject> getCOEDMMEvents(){
        Cursor cursor=mDb.query(TABLENAME,new String[]{"title","description","title","mobile","person","tagline"},"sub"+"=?",new String[]{"COEDMM"},null,null,null);
        List<EventObject> result=new ArrayList<EventObject>();
        if (cursor.moveToFirst()) {
            do {
                EventObject object=new EventObject();
                object.setName(cursor.getString(0));
                object.setDes(cursor.getString(1));
                object.setTagline(cursor.getString(5));
                object.setContact(cursor.getString(3));
                object.setContactname(cursor.getString(4));
                result.add(object);
            } while (cursor.moveToNext());
        }
        return result;
    }
    public List<EventObject> getBiotechnologyEvents(){
        List<EventObject> result=new ArrayList<EventObject>();
        Cursor cursor=mDb.query(TABLENAME,new String[]{"title","description","title","mobile","person","tagline"},"sub"+"=?",new String[]{"Biotechnology"},null,null,null);
        if (cursor.moveToFirst()) {
            do {
                EventObject object=new EventObject();
                object.setName(cursor.getString(0));
                object.setDes(cursor.getString(1));
                object.setTagline(cursor.getString(5));
                object.setContact(cursor.getString(3));
                object.setContactname(cursor.getString(4));
                result.add(object);
            } while (cursor.moveToNext());
        }
        return result;
    }
    public List<EventObject> getArchitectureandPlanning(){
        List<EventObject> result=new ArrayList<EventObject>();
        Cursor cursor=mDb.query(TABLENAME,new String[]{"title","description","title","mobile","person","tagline"},"sub"+"=?",new String[]{"Architecture and Planning"},null,null,null);
        if (cursor.moveToFirst()) {
            do {
                EventObject object=new EventObject();
                object.setName(cursor.getString(0));
                object.setDes(cursor.getString(1));
                object.setTagline(cursor.getString(5));
                object.setContact(cursor.getString(3));
                object.setContactname(cursor.getString(4));
                result.add(object);
            } while (cursor.moveToNext());
        }
        return result;
    }
    public List<EventObject> getAlternateHydroEnergyCentreEvents(){
        List<EventObject> result=new ArrayList<EventObject>();
        Cursor cursor=mDb.query(TABLENAME,new String[]{"title","description","title","mobile","person","tagline"},"sub"+"=?",new String[]{"Alternate Hydro Energy Centre"},null,null,null);
        if (cursor.moveToFirst()) {
            do {
                EventObject object=new EventObject();
                object.setName(cursor.getString(0));
                object.setDes(cursor.getString(1));
                object.setTagline(cursor.getString(5));
                object.setContact(cursor.getString(3));
                object.setContactname(cursor.getString(4));
                result.add(object);
            } while (cursor.moveToNext());
        }
        return result;
    }
    public List<EventObject> getWaterResourceEvents(){
        List<EventObject> result=new ArrayList<EventObject>();
        Cursor cursor=mDb.query(TABLENAME,new String[]{"title","description","title","mobile","person","tagline"},"sub"+"=?",new String[]{"Water Resources Development and Management"},null,null,null);
        if (cursor.moveToFirst()) {
            do {
                EventObject object=new EventObject();
                object.setName(cursor.getString(0));
                object.setDes(cursor.getString(1));
                object.setTagline(cursor.getString(5));
                object.setContact(cursor.getString(3));
                object.setContactname(cursor.getString(4));
                result.add(object);
            } while (cursor.moveToNext());
        }
        return result;
    }
    }