package iit.iitrc.rahil.cognizance_2016;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by rahil on 1/19/2016.
 */
public class SimpleRecyclerAdapter extends RecyclerView.Adapter<SimpleRecyclerAdapter.PersonViewHolder> {
    List<ScheduleItem> list;

    public SimpleRecyclerAdapter(List<ScheduleItem> dataSet) {
        this.list = dataSet;
    }

    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.scheduleitem, parent, false);
        PersonViewHolder dataObjectHolder = new PersonViewHolder(view);
        return dataObjectHolder;
    }

    @Override
    public void onBindViewHolder(PersonViewHolder holder, int position) {
        holder.eventname.setText(list.get(position).getName());
        holder.eventtype.setText(list.get(position).getType());
        holder.eventlocation.setText(list.get(position).getLocation());
        holder.eventtim.setText(list.get(position).getDate());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public interface OnItemClickListener {
        void onItemClick(RecyclerEventObject item);
    }

    public static class PersonViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView eventname;
        TextView eventtype;
        TextView eventlocation;
        TextView eventtim;
        PersonViewHolder(View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.cv);
            eventname = (TextView) itemView.findViewById(R.id.event_name);
            eventtype = (TextView) itemView.findViewById(R.id.eventtype);
            eventlocation = (TextView) itemView.findViewById(R.id.eventlocation);
            eventtim = (TextView) itemView.findViewById(R.id.timing);

        }
    }
}
