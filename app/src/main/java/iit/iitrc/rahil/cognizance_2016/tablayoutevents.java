package iit.iitrc.rahil.cognizance_2016;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.SpannableString;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rahil on 3/10/2016.
 */
public class tablayoutevents extends AppCompatActivity {

    static List<CharSequence> Titles;
    static List<String> headings;
    static List<String> summary;
    static List<String> contact1;
    static List<String> contact2;
    static int Numboftabs;
    ViewPager pager;
    List<CharSequence> titles;
    List<CogniEventObject> eventlist;
    int position;
    SectionsPagerAdapter adapter;
    DataAdapter mDbHelper;
    private final String temp="abcd";
    iit.iitrc.rahil.cognizance_2016.SlidingTabLayout tabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zones);
        Titles = new ArrayList<CharSequence>();
        headings = new ArrayList<String>();
        summary = new ArrayList<String>();
        contact1 = new ArrayList<String>();
        contact2 = new ArrayList<String>();
        mDbHelper = new DataAdapter(this);
        position = getIntent().getIntExtra("which", 0);
        switch (position) {
            case 0:
                mDbHelper.createDatabase();
                mDbHelper.open();
                Numboftabs = mDbHelper.getFuzzyLogixEvents().size();
                for (int i = 0; i < mDbHelper.getFuzzyLogixEvents().size(); i++) {
                    Titles.add(mDbHelper.getFuzzyLogixEvents().get(i).getName());
                    String s=mDbHelper.getFuzzyLogixEvents().get(i).getDes();
                    String r= s.replaceAll("\\<.*?\\>\\n?", "");
                    String t=r.replaceAll("\\n","");
                    summary.add(t);
                    contact1.add(mDbHelper.getFuzzyLogixEvents().get(i).getContactname());
                    contact2.add(mDbHelper.getFuzzyLogixEvents().get(i).getContact());
                    headings.add(mDbHelper.getFuzzyLogixEvents().get(i).getTagline());
                }
                Log.d("check", mDbHelper.getFuzzyLogixEvents().get(0).getName());
                mDbHelper.close();
                break;
            case 1:
                mDbHelper.createDatabase();
                mDbHelper.open();
                Numboftabs = mDbHelper.getRoboticsEvents().size();
                for (int i = 0; i < mDbHelper.getRoboticsEvents().size(); i++) {
                    Titles.add(mDbHelper.getRoboticsEvents().get(i).getName());
                    String s=mDbHelper.getRoboticsEvents().get(i).getDes();
                    String r= s.replaceAll("\\<.*?\\>\\n?", "");
                    String t=r.replaceAll("\\n","");
                    summary.add(t);
                    contact1.add(mDbHelper.getRoboticsEvents().get(i).getContactname());
                    contact2.add(mDbHelper.getRoboticsEvents().get(i).getContact());
                    headings.add(mDbHelper.getRoboticsEvents().get(i).getTagline());

                }
                mDbHelper.close();
                break;
            case 2:
                mDbHelper.createDatabase();
                mDbHelper.open();
                Numboftabs = mDbHelper.getThemeEvents().size();
                for (int i = 0; i < mDbHelper.getThemeEvents().size(); i++) {
                    Titles.add(mDbHelper.getThemeEvents().get(i).getName());
                    String s=mDbHelper.getThemeEvents().get(i).getDes();
                    String r= s.replaceAll("\\<.*?\\>\\n?", "");
                    String t=r.replaceAll("\\n","");
                    summary.add(t);
                    contact1.add(mDbHelper.getThemeEvents().get(i).getContactname());
                    contact2.add(mDbHelper.getThemeEvents().get(i).getContact());
                    headings.add(mDbHelper.getThemeEvents().get(i).getTagline());
                }
                mDbHelper.close();
                break;
            case 3:
                mDbHelper.createDatabase();
                mDbHelper.open();
                Numboftabs = mDbHelper.getShellEventsEvents().size();
                for (int i = 0; i < mDbHelper.getShellEventsEvents().size(); i++) {
                    Titles.add(mDbHelper.getShellEventsEvents().get(i).getName());
                    String s=mDbHelper.getShellEventsEvents().get(i).getDes();
                    String r= s.replaceAll("\\<.*?\\>\\n?", "");
                    String t=r.replaceAll("\\n","");
                    summary.add(t);
                    contact1.add(mDbHelper.getShellEventsEvents().get(i).getContactname());
                    contact2.add(mDbHelper.getShellEventsEvents().get(i).getContact());
                    headings.add(mDbHelper.getShellEventsEvents().get(i).getTagline());
                }
                mDbHelper.close();
                break;
            case 4:
                mDbHelper.createDatabase();
                mDbHelper.open();
                Numboftabs = mDbHelper.getCompetitionsEvents().size();
                for (int i = 0; i < mDbHelper.getCompetitionsEvents().size(); i++) {
                    Titles.add(mDbHelper.getCompetitionsEvents().get(i).getName());
                    String s=mDbHelper.getCompetitionsEvents().get(i).getDes();
                    String r= s.replaceAll("\\<.*?\\>\\n?", "");
                    String t=r.replaceAll("\\n","");
                    summary.add(t);
                    contact1.add(mDbHelper.getCompetitionsEvents().get(i).getContactname());
                    contact2.add(mDbHelper.getCompetitionsEvents().get(i).getContact());
                    headings.add(mDbHelper.getCompetitionsEvents().get(i).getTagline());
                }
                mDbHelper.close();
                break;

            case 5:

                mDbHelper.createDatabase();
                mDbHelper.open();
                Numboftabs = mDbHelper.getOnlineEvents().size();
                for (int i = 0; i < mDbHelper.getOnlineEvents().size(); i++) {
                    Titles.add(mDbHelper.getOnlineEvents().get(i).getName());
                    String s=mDbHelper.getOnlineEvents().get(i).getDes();
                    String r= s.replaceAll("\\<.*?\\>\\n?", "");
                    String t=r.replaceAll("\\n","");
                    summary.add(t);
                    contact1.add(mDbHelper.getOnlineEvents().get(i).getContactname());
                    contact2.add(mDbHelper.getOnlineEvents().get(i).getContact());
                    headings.add(mDbHelper.getOnlineEvents().get(i).getTagline());
                }
                mDbHelper.close();
                break;

            case 6:
                mDbHelper.createDatabase();
                mDbHelper.open();
                Numboftabs = mDbHelper.getLiterarioEvents().size();
                for (int i = 0; i < mDbHelper.getLiterarioEvents().size(); i++) {
                    Titles.add(mDbHelper.getLiterarioEvents().get(i).getName());
                    String s=mDbHelper.getLiterarioEvents().get(i).getDes();
                    String r= s.replaceAll("\\<.*?\\>\\n?", "");
                    String t=r.replaceAll("\\n","");
                    summary.add(t);
                    contact1.add(mDbHelper.getLiterarioEvents().get(i).getContactname());
                    contact2.add(mDbHelper.getLiterarioEvents().get(i).getContact());
                    headings.add(mDbHelper.getLiterarioEvents().get(i).getTagline());
                }
                mDbHelper.close();
                break;
            case 7:
                mDbHelper.createDatabase();
                mDbHelper.open();
                Numboftabs = mDbHelper.getArchitectureandPlanning().size();
                for (int i = 0; i < mDbHelper.getArchitectureandPlanning().size(); i++) {
                    Titles.add(mDbHelper.getArchitectureandPlanning().get(i).getName());
                    String s=mDbHelper.getArchitectureandPlanning().get(i).getDes();
                    String r= s.replaceAll("\\<.*?\\>\\n?", "");
                    String t=r.replaceAll("\\n","");
                    summary.add(t);
                    contact1.add(mDbHelper.getArchitectureandPlanning().get(i).getContactname());
                    contact2.add(mDbHelper.getArchitectureandPlanning().get(i).getContact());
                    headings.add(mDbHelper.getArchitectureandPlanning().get(i).getTagline());
                }
                mDbHelper.close();
                break;
            case 8:
                mDbHelper.createDatabase();
                mDbHelper.open();
                Numboftabs = mDbHelper.getCivilEngineeringEvents().size();
                for (int i = 0; i < mDbHelper.getCivilEngineeringEvents().size(); i++) {
                    Titles.add(mDbHelper.getCivilEngineeringEvents().get(i).getName());
                    String s=mDbHelper.getCivilEngineeringEvents().get(i).getDes();
                    String r= s.replaceAll("\\<.*?\\>\\n?", "");
                    String t=r.replaceAll("\\n","");
                    summary.add(t);
                    contact1.add(mDbHelper.getCivilEngineeringEvents().get(i).getContactname());
                    contact2.add(mDbHelper.getCivilEngineeringEvents().get(i).getContact());
                    headings.add(mDbHelper.getCivilEngineeringEvents().get(i).getTagline());
                }
                mDbHelper.close();

                break;
            case 9:
                mDbHelper.createDatabase();
                mDbHelper.open();
                Numboftabs = mDbHelper.getComputerScienceEvents().size();
                for (int i = 0; i < mDbHelper.getComputerScienceEvents().size(); i++) {
                    Titles.add(mDbHelper.getComputerScienceEvents().get(i).getName());
                    String s=mDbHelper.getComputerScienceEvents().get(i).getDes();
                    String r= s.replaceAll("\\<.*?\\>\\n?", "");
                    String t=r.replaceAll("\\n","");
                    summary.add(t);
                    contact1.add(mDbHelper.getComputerScienceEvents().get(i).getContactname());
                    contact2.add(mDbHelper.getComputerScienceEvents().get(i).getContact());
                    headings.add(mDbHelper.getComputerScienceEvents().get(i).getTagline());
                }
                mDbHelper.close();

                break;
            case 10:
                mDbHelper.createDatabase();
                mDbHelper.open();
                Numboftabs = mDbHelper.getDepartmentofEarthScienceEvents().size();
                for (int i = 0; i < mDbHelper.getDepartmentofEarthScienceEvents().size(); i++) {
                    Titles.add(mDbHelper.getDepartmentofEarthScienceEvents().get(i).getName());
                    String s=mDbHelper.getDepartmentofEarthScienceEvents().get(i).getDes();
                    String r= s.replaceAll("\\<.*?\\>\\n?", "");
                    String t=r.replaceAll("\\n","");
                    summary.add(t);
                    contact1.add(mDbHelper.getDepartmentofEarthScienceEvents().get(i).getContactname());
                    contact2.add(mDbHelper.getDepartmentofEarthScienceEvents().get(i).getContact());
                    headings.add(mDbHelper.getDepartmentofEarthScienceEvents().get(i).getTagline());
                }
                mDbHelper.close();

                break;
            case 11:
                mDbHelper.createDatabase();
                mDbHelper.open();
                Numboftabs = mDbHelper.getWaterResourceEvents().size();
                for (int i = 0; i < mDbHelper.getWaterResourceEvents().size(); i++) {
                    Titles.add(mDbHelper.getWaterResourceEvents().get(i).getName());
                    String s=mDbHelper.getWaterResourceEvents().get(i).getDes();
                    String r= s.replaceAll("\\<.*?\\>\\n?", "");
                    String t=r.replaceAll("\\n","");
                    summary.add(t);
                    contact1.add(mDbHelper.getWaterResourceEvents().get(i).getContactname());
                    contact2.add(mDbHelper.getWaterResourceEvents().get(i).getContact());
                    headings.add(mDbHelper.getWaterResourceEvents().get(i).getTagline());
                }
                mDbHelper.close();

                break;
            case 12:
                mDbHelper.createDatabase();
                mDbHelper.open();
                Numboftabs = mDbHelper.getChemicalEngineeringEvents().size();
                for (int i = 0; i < mDbHelper.getChemicalEngineeringEvents().size(); i++) {
                    Titles.add(mDbHelper.getChemicalEngineeringEvents().get(i).getName());
                    String s=mDbHelper.getChemicalEngineeringEvents().get(i).getDes();
                    String r= s.replaceAll("\\<.*?\\>\\n?", "");
                    String t=r.replaceAll("\\n","");
                    summary.add(t);
                    contact1.add(mDbHelper.getChemicalEngineeringEvents().get(i).getContactname());
                    contact2.add(mDbHelper.getChemicalEngineeringEvents().get(i).getContact());
                    headings.add(mDbHelper.getChemicalEngineeringEvents().get(i).getTagline());
                }
                mDbHelper.close();

                break;
            case 13:
                mDbHelper.createDatabase();
                mDbHelper.open();
                Numboftabs = mDbHelper.getBiotechnologyEvents().size();
                for (int i = 0; i < mDbHelper.getBiotechnologyEvents().size(); i++) {
                    Titles.add(mDbHelper.getBiotechnologyEvents().get(i).getName());
                    String s=mDbHelper.getBiotechnologyEvents().get(i).getDes();
                    String r= s.replaceAll("\\<.*?\\>\\n?", "");
                    String t=r.replaceAll("\\n","");
                    summary.add(t);
                    contact1.add(mDbHelper.getBiotechnologyEvents().get(i).getContactname());
                    contact2.add(mDbHelper.getBiotechnologyEvents().get(i).getContact());
                    headings.add(mDbHelper.getBiotechnologyEvents().get(i).getTagline());
                }
                mDbHelper.close();
                break;

            case 14:
                mDbHelper.createDatabase();
                mDbHelper.open();
                Numboftabs = mDbHelper.getChemistryEvents().size();
                for (int i = 0; i < mDbHelper.getChemistryEvents().size(); i++) {
                    Titles.add(mDbHelper.getChemistryEvents().get(i).getName());
                    String s= mDbHelper.getChemistryEvents().get(i).getDes();
                    String r= s.replaceAll("\\<.*?\\>\\n?", "");
                    String t=r.replaceAll("\\n","");
                    summary.add(t);

                    contact1.add(mDbHelper.getChemistryEvents().get(i).getContactname());
                    contact2.add(mDbHelper.getChemistryEvents().get(i).getContact());
                    headings.add(mDbHelper.getChemistryEvents().get(i).getTagline());
                }
                mDbHelper.close();

                break;
            case 15:
                mDbHelper.createDatabase();
                mDbHelper.open();
                Numboftabs = mDbHelper.getElectricalEngineeringEvents().size();
                for (int i = 0; i < mDbHelper.getElectricalEngineeringEvents().size(); i++) {
                    Titles.add(mDbHelper.getElectricalEngineeringEvents().get(i).getName());
                    String s=mDbHelper.getElectricalEngineeringEvents().get(i).getDes();
                    String r= s.replaceAll("\\<.*?\\>\\n?", "");
                    String t=r.replaceAll("\\n","");
                    summary.add(t);
                    contact1.add(mDbHelper.getElectricalEngineeringEvents().get(i).getContactname());
                    contact2.add(mDbHelper.getElectricalEngineeringEvents().get(i).getContact());
                    headings.add(mDbHelper.getElectricalEngineeringEvents().get(i).getTagline());
                }
                mDbHelper.close();
                break;

            case 16:
                mDbHelper.createDatabase();
                mDbHelper.open();
                Numboftabs = mDbHelper.getElectronicsandCommunicationEngineeringEvents().size();
                for (int i = 0; i < mDbHelper.getElectronicsandCommunicationEngineeringEvents().size(); i++) {
                    Titles.add(mDbHelper.getElectronicsandCommunicationEngineeringEvents().get(i).getName());
                    String s=mDbHelper.getElectronicsandCommunicationEngineeringEvents().get(i).getDes();
                    String r= s.replaceAll("\\<.*?\\>\\n?", "");
                    String t=r.replaceAll("\\n","");
                    summary.add(t);

                    contact1.add(mDbHelper.getElectronicsandCommunicationEngineeringEvents().get(i).getContactname());
                    contact2.add(mDbHelper.getElectronicsandCommunicationEngineeringEvents().get(i).getContact());
                    headings.add(mDbHelper.getElectronicsandCommunicationEngineeringEvents().get(i).getTagline());
                }
                mDbHelper.close();

                break;
            case 17:
                mDbHelper.createDatabase();
                mDbHelper.open();
                Numboftabs = mDbHelper.getDepartmentofHydrologyEvents().size();
                for (int i = 0; i < mDbHelper.getDepartmentofHydrologyEvents().size(); i++) {
                    Titles.add(mDbHelper.getDepartmentofHydrologyEvents().get(i).getName());
                    String s=mDbHelper.getDepartmentofHydrologyEvents().get(i).getDes();
                    String r= s.replaceAll("\\<.*?\\>\\n?", "");
                    String t=r.replaceAll("\\n","");
                    summary.add(t);
                    contact1.add(mDbHelper.getDepartmentofHydrologyEvents().get(i).getContactname());
                    contact2.add(mDbHelper.getDepartmentofHydrologyEvents().get(i).getContact());
                    headings.add(mDbHelper.getDepartmentofHydrologyEvents().get(i).getTagline());
                }
                mDbHelper.close();

                break;
            case 18:
                mDbHelper.createDatabase();
                mDbHelper.open();
                Numboftabs = mDbHelper.getDepartmentofManagementStudiesEvents().size();
                for (int i = 0; i < mDbHelper.getDepartmentofManagementStudiesEvents().size(); i++) {
                    Titles.add(mDbHelper.getDepartmentofManagementStudiesEvents().get(i).getName());
                    String s=mDbHelper.getDepartmentofManagementStudiesEvents().get(i).getDes();
                    String r= s.replaceAll("\\<.*?\\>\\n?", "");
                    String t=r.replaceAll("\\n","");
                    summary.add(t);

                    contact1.add(mDbHelper.getDepartmentofManagementStudiesEvents().get(i).getContactname());
                    contact2.add(mDbHelper.getDepartmentofManagementStudiesEvents().get(i).getContact());
                    headings.add(mDbHelper.getDepartmentofManagementStudiesEvents().get(i).getTagline());
                }
                mDbHelper.close();

                break;
            case 19:
                mDbHelper.createDatabase();
                mDbHelper.open();
                Numboftabs = mDbHelper.getMathematicsEvents().size();
                for (int i = 0; i < mDbHelper.getMathematicsEvents().size(); i++) {
                    Titles.add(mDbHelper.getMathematicsEvents().get(i).getName());
                    String s=mDbHelper.getMathematicsEvents().get(i).getDes();
                    String r= s.replaceAll("\\<.*?\\>\\n?", "");
                    String t=r.replaceAll("\\n","");
                    summary.add(t);

                    contact1.add(mDbHelper.getMathematicsEvents().get(i).getContactname());
                    contact2.add(mDbHelper.getMathematicsEvents().get(i).getContact());
                    headings.add(mDbHelper.getMathematicsEvents().get(i).getTagline());
                }
                mDbHelper.close();

                break;
            case 20:
                mDbHelper.createDatabase();
                mDbHelper.open();
                Numboftabs = mDbHelper.getMechanicalEvents().size();
                for (int i = 0; i < mDbHelper.getMechanicalEvents().size(); i++) {
                    Titles.add(mDbHelper.getMechanicalEvents().get(i).getName());
                    String s=mDbHelper.getMechanicalEvents().get(i).getDes();
                    String r= s.replaceAll("\\<.*?\\>\\n?", "");
                    String t=r.replaceAll("\\n","");
                    summary.add(t);
                    contact1.add(mDbHelper.getMechanicalEvents().get(i).getContactname());
                    contact2.add(mDbHelper.getMechanicalEvents().get(i).getContact());
                    headings.add(mDbHelper.getMechanicalEvents().get(i).getTagline());
                }
                mDbHelper.close();

                break;
            case 21:
                mDbHelper.createDatabase();
                mDbHelper.open();
                Numboftabs = mDbHelper.getMetallurgicalEvents().size();
                for (int i = 0; i < mDbHelper.getMetallurgicalEvents().size(); i++) {
                    Titles.add(mDbHelper.getMetallurgicalEvents().get(i).getName());
                    String s=mDbHelper.getMetallurgicalEvents().get(i).getDes();
                    String r= s.replaceAll("\\<.*?\\>\\n?", "");
                    String t=r.replaceAll("\\n","");
                    summary.add(t);

                    contact1.add(mDbHelper.getMetallurgicalEvents().get(i).getContactname());
                    contact2.add(mDbHelper.getMetallurgicalEvents().get(i).getContact());
                    headings.add(mDbHelper.getMetallurgicalEvents().get(i).getTagline());
                }
                mDbHelper.close();
                break;
            case 22:
                mDbHelper.createDatabase();
                mDbHelper.open();
                Numboftabs = mDbHelper.getDepartmentofPaperTechnologyEvents().size();
                for (int i = 0; i < mDbHelper.getDepartmentofPaperTechnologyEvents().size(); i++) {
                    Titles.add(mDbHelper.getDepartmentofPaperTechnologyEvents().get(i).getName());
                    String s=mDbHelper.getDepartmentofPaperTechnologyEvents().get(i).getDes();
                    String r= s.replaceAll("\\<.*?\\>\\n?", "");
                    String t=r.replaceAll("\\n","");
                    summary.add(t);

                    contact1.add(mDbHelper.getDepartmentofPaperTechnologyEvents().get(i).getContactname());
                    contact2.add(mDbHelper.getDepartmentofPaperTechnologyEvents().get(i).getContact());
                    headings.add(mDbHelper.getDepartmentofPaperTechnologyEvents().get(i).getTagline());
                }
                mDbHelper.close();

                break;
            case 23:
                mDbHelper.createDatabase();
                mDbHelper.open();
                Numboftabs = mDbHelper.getDepartmentofPhysicsEvents().size();
                for (int i = 0; i < mDbHelper.getDepartmentofPhysicsEvents().size(); i++) {
                    Titles.add(mDbHelper.getDepartmentofPhysicsEvents().get(i).getName());
                    String s=mDbHelper.getDepartmentofPhysicsEvents().get(i).getDes();
                    String r= s.replaceAll("\\<.*?\\>\\n?", "");
                    String t=r.replaceAll("\\n","");
                    summary.add(t);

                    contact1.add(mDbHelper.getDepartmentofPhysicsEvents().get(i).getContactname());
                    contact2.add(mDbHelper.getDepartmentofPhysicsEvents().get(i).getContact());
                    headings.add(mDbHelper.getDepartmentofPhysicsEvents().get(i).getTagline());
                }
                mDbHelper.close();

                break;
            case 24:
                mDbHelper.createDatabase();
                mDbHelper.open();
                Numboftabs = mDbHelper.getEarthquakeEngineeringEvents().size();
                for (int i = 0; i < mDbHelper.getEarthquakeEngineeringEvents().size(); i++) {
                    Titles.add(mDbHelper.getEarthquakeEngineeringEvents().get(i).getName());
                    String s=mDbHelper.getEarthquakeEngineeringEvents().get(i).getDes();
                    String r= s.replaceAll("\\<.*?\\>\\n?", "");
                    String t=r.replaceAll("\\n","");
                    summary.add(t);

                    contact1.add(mDbHelper.getEarthquakeEngineeringEvents().get(i).getContactname());
                    contact2.add(mDbHelper.getEarthquakeEngineeringEvents().get(i).getContact());
                    headings.add(mDbHelper.getEarthquakeEngineeringEvents().get(i).getTagline());
                }
                mDbHelper.close();

                break;
            case 25:
                mDbHelper.createDatabase();
                mDbHelper.open();
                Numboftabs = mDbHelper.getCOEDMMEvents().size();
                for (int i = 0; i < mDbHelper.getCOEDMMEvents().size(); i++) {
                    Titles.add(mDbHelper.getCOEDMMEvents().get(i).getName());
                    String s=mDbHelper.getCOEDMMEvents().get(i).getDes();
                    String r= s.replaceAll("\\<.*?\\>\\n?", "");
                    String t=r.replaceAll("\\n","");
                    summary.add(t);

                    contact1.add(mDbHelper.getCOEDMMEvents().get(i).getContactname());
                    contact2.add(mDbHelper.getCOEDMMEvents().get(i).getContact());
                    headings.add(mDbHelper.getCOEDMMEvents().get(i).getTagline());
                }
                mDbHelper.close();
                break;
            case 26:
                mDbHelper.createDatabase();
                mDbHelper.open();
                Numboftabs = mDbHelper.getCenterofTransportationSystemsEvents().size();
                for (int i = 0; i < mDbHelper.getCenterofTransportationSystemsEvents().size(); i++) {
                    Titles.add(mDbHelper.getCenterofTransportationSystemsEvents().get(i).getName());
                    String s=mDbHelper.getCenterofTransportationSystemsEvents().get(i).getDes();
                    String r= s.replaceAll("\\<.*?\\>\\n?", "");
                    String t=r.replaceAll("\\n","");
                    summary.add(t);

                    contact1.add(mDbHelper.getCenterofTransportationSystemsEvents().get(i).getContactname());
                    contact2.add(mDbHelper.getCenterofTransportationSystemsEvents().get(i).getContact());
                    headings.add(mDbHelper.getCenterofTransportationSystemsEvents().get(i).getTagline());
                }
                mDbHelper.close();
                break;
            case 27:
                mDbHelper.createDatabase();
                mDbHelper.open();
                Numboftabs = mDbHelper.getNanotechEvents().size();
                for (int i = 0; i < mDbHelper.getNanotechEvents().size(); i++) {
                    Titles.add(mDbHelper.getNanotechEvents().get(i).getName());
                    String s=mDbHelper.getNanotechEvents().get(i).getDes();
                    String r= s.replaceAll("\\<.*?\\>\\n?", "");
                    String t=r.replaceAll("\\n","");
                    summary.add(t);
                    contact1.add(mDbHelper.getNanotechEvents().get(i).getContactname());
                    contact2.add(mDbHelper.getNanotechEvents().get(i).getContact());
                    headings.add(mDbHelper.getNanotechEvents().get(i).getTagline());
                }
                mDbHelper.close();
                break;
            case 28:
                mDbHelper.createDatabase();
                mDbHelper.open();
                Numboftabs = mDbHelper.getAlternateHydroEnergyCentreEvents().size();
                for (int i = 0; i < mDbHelper.getAlternateHydroEnergyCentreEvents().size(); i++) {
                    Titles.add(mDbHelper.getAlternateHydroEnergyCentreEvents().get(i).getName());
                    String s=mDbHelper.getAlternateHydroEnergyCentreEvents().get(i).getDes();
                    String r= s.replaceAll("\\<.*?\\>\\n?", "");
                    String t=r.replaceAll("\\n","");
                    summary.add(t);
                    contact1.add(mDbHelper.getAlternateHydroEnergyCentreEvents().get(i).getContactname());
                    contact2.add(mDbHelper.getAlternateHydroEnergyCentreEvents().get(i).getContact());
                    headings.add(mDbHelper.getAlternateHydroEnergyCentreEvents().get(i).getTagline());
                }
                mDbHelper.close();
                break;
        }
        adapter = new SectionsPagerAdapter(getSupportFragmentManager());
        pager = (ViewPager) findViewById(R.id.viewpager);
        pager.setAdapter(adapter);
        SpannableString s = new SpannableString("Events");
        s.setSpan(new TypefaceSpan(this, "MyTypeface.otf"), 0, s.length(),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        getSupportActionBar().setTitle(s);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        tabs = (iit.iitrc.rahil.cognizance_2016.SlidingTabLayout) findViewById(R.id.sliding_tabs);
       // tabs.setDistributeEvenly(true); // To make the Tabs Fixed set this true, This makes the tabs Space Evenly in Available width
        tabs.setCustomTabColorizer(new iit.iitrc.rahil.cognizance_2016.SlidingTabLayout.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {
                return getResources().getColor(R.color.colorPrimary);
            }
        });
        tabs.setViewPager(pager);
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

 /*   @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }*/

    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String heading = "heading";
        private static final String summaryn = "summary";
        private static final String contact1n = "contact1";
        private static final String contact2n = "contact2";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        static final public PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putString(heading, headings.get(sectionNumber));
            args.putString(summaryn, summary.get(sectionNumber));
            args.putString(contact1n, contact1.get(sectionNumber));
            args.putString(contact2n, contact2.get(sectionNumber));
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.activity_expanse_event, container, false);
            String sum = getArguments().getString(summaryn);
            //String con = getArguments().getString(contact1n, "").replaceAll("\\<.*?\\>\\n", "");
            //String sum=getArguments().getString(summaryn).replaceAll("\\<.*?\\>\\n", "");
            iit.iitrc.rahil.cognizance_2016.LatoHeading textView = (iit.iitrc.rahil.cognizance_2016.LatoHeading) rootView.findViewById(R.id.heading);
             textView.setText(getArguments().getString(heading));
            iit.iitrc.rahil.cognizance_2016.LatoHeading textView2 = (iit.iitrc.rahil.cognizance_2016.LatoHeading) rootView.findViewById(R.id.info);
            textView2.setText(sum);
            iit.iitrc.rahil.cognizance_2016.LatoHeading textView3 = (iit.iitrc.rahil.cognizance_2016.LatoHeading) rootView.findViewById(R.id.contact1);
            textView3.setText(getArguments().getString(contact1n));
            iit.iitrc.rahil.cognizance_2016.LatoHeading textView4 = (iit.iitrc.rahil.cognizance_2016.LatoHeading) rootView.findViewById(R.id.contact2);
            textView4.setText(getArguments().getString(contact2n));
            return rootView;
        }
    }

    public static class SectionsPagerAdapter extends FragmentStatePagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        public static String getHeading(int position) {
            return headings.get(position);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return Titles.get(position);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return Numboftabs;
        }
    }
}
