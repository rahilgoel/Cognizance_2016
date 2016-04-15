package iit.iitrc.rahil.cognizance_2016;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rahil on 1/19/2016.
 */
public class DummyFragment extends Fragment {
    public TextView mTextView;
    int color;
    int pos;
    List<ScheduleItem> eventList;
    Context activity;
    DataAdapter2 mDbHelper;

    private RecyclerView mRecyclerView;
    private SimpleRecyclerAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    static final public DummyFragment newInstance(int color, int pos) {
        DummyFragment fragment = new DummyFragment();
        Bundle args = new Bundle();
        args.putInt("color", color);
        args.putInt("pos", pos);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dummy_fragment, container, false);
        color = getArguments().getInt("color");
        pos = getArguments().getInt("pos");
        final FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.frag_bg);
        frameLayout.setBackgroundColor(color);
        mDbHelper = new DataAdapter2(getActivity());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity().getBaseContext());
        mRecyclerView = (RecyclerView) view.findViewById(R.id.my_recycler_view);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setHasFixedSize(true);
        activity = getContext();
        eventList = new ArrayList<ScheduleItem>();
        switch (pos) {
            case 1:
                mDbHelper.createDatabase();
                mDbHelper.open();
                eventList = mDbHelper.getDay1Events();
                mDbHelper.close();
                break;

            case 2:
                mDbHelper.createDatabase();
                mDbHelper.open();
                eventList = mDbHelper.getDay2Events();
                mDbHelper.close();
                break;
            case 3:
                mDbHelper.createDatabase();
                mDbHelper.open();
                eventList = mDbHelper.getDay3Events();
                mDbHelper.close();
                break;

        }
        mRecyclerView = (RecyclerView) view.findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mAdapter = new SimpleRecyclerAdapter(eventList);
        mRecyclerView.setAdapter(mAdapter);
        return view;
    }
}
