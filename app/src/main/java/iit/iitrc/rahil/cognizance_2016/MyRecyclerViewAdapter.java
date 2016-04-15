package iit.iitrc.rahil.cognizance_2016;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rahil on 3/10/2016.
 */
public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.PersonViewHolder> {
    List<RecyclerEventObject> list;

    public interface OnItemClickListener {
        void onItemClick(RecyclerEventObject item);
    }
    public MyRecyclerViewAdapter(List<RecyclerEventObject> dataSet) {
        this.list = dataSet;
    }

    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardviewobject, parent, false);
        PersonViewHolder dataObjectHolder = new PersonViewHolder(view);
        return dataObjectHolder;
    }

    @Override
    public void onBindViewHolder(PersonViewHolder holder, int position) {
        holder.eventname.setText(list.get(position).getName());
        holder.eventphoto.setImageResource(list.get(position).getPic());
    }
    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class PersonViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView eventname;
        ImageView eventphoto;


        PersonViewHolder(View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.cv);
            eventname = (TextView) itemView.findViewById(R.id.event_name);
            eventphoto = (ImageView) itemView.findViewById(R.id.event_pic);
        }
    }
}
