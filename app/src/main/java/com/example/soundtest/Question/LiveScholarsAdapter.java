package com.example.soundtest.Question;

import android.content.Context;
import android.content.Intent;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.soundtest.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
public class LiveScholarsAdapter extends RecyclerView.Adapter<LiveScholarsAdapter.MyViewHolder> {


    Context context;
    ArrayList<ScholarsLiveClass> liveClasses;
    private OnItemClickListener listener;
    DatabaseReference databaseReference;

    public LiveScholarsAdapter(Context c ,ArrayList<ScholarsLiveClass> p){

        context = c;
        liveClasses = p;
    }

    @NonNull
    @Override
    public LiveScholarsAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.live_scholar_demo_list,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LiveScholarsAdapter.MyViewHolder holder, int i) {


        holder.live_title.setText(liveClasses.get(i).getTitle());
        holder.live_start_time.setText(liveClasses.get(i).getLiveStartTime());
        holder.live_end_time.setText(liveClasses.get(i).getLiveEndTime());
        holder.live_date.setText(liveClasses.get(i).getLiveDate());
        holder.live_lecturer.setText(liveClasses.get(i).getSchplarName());
        holder.live_type.setText(liveClasses.get(i).getLivetType());
    }

    @Override
    public int getItemCount() {
        return liveClasses.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnCreateContextMenuListener, MenuItem.OnMenuItemClickListener {

        TextView live_title,live_start_time,live_end_time,live_date,live_lecturer,live_type;

        public MyViewHolder(@NonNull  View itemView) {
            super(itemView);

            live_title = itemView.findViewById(R.id.getTitle);
            live_start_time = itemView.findViewById(R.id.getStartTime);
            live_end_time = itemView.findViewById(R.id.getEndTime);
            live_date = itemView.findViewById(R.id.getDate);
            live_lecturer = itemView.findViewById(R.id.getLacturerName);
            live_type = itemView.findViewById(R.id.getType);

            itemView.setOnClickListener(this);
            itemView.setOnCreateContextMenuListener(this);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    int position_number = getAdapterPosition();
                    String LiveTitle = live_title.getText().toString();
                    String LiveScholarsName = live_lecturer.getText().toString();
                    String LiveStartTime = live_start_time.getText().toString();
                    String LiveEndtTime = live_end_time.getText().toString();


                    Intent intent = new Intent(v.getContext(),ScholerCallingLive.class);

                    intent.putExtra("live_title",LiveTitle);
                    intent.putExtra("live_scholer",LiveScholarsName);
                    intent.putExtra("live_start_time",LiveStartTime);
                    intent.putExtra("live_end_time",LiveEndtTime );
                    intent.putExtra("live_position",position_number);


                    v.getContext().startActivity(intent);

                    Toast.makeText(context, "position"+getAdapterPosition(), Toast.LENGTH_SHORT).show();
                }
            });


        }


        @Override
        public void onClick(View v) {

            if (listener!=null)
            {
                int position = getAdapterPosition();

                if (position!=RecyclerView.NO_POSITION) {


                    listener.onItemClick(position);
                }
            }


        }


        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

            menu.setHeaderTitle("Choose an action");
            MenuItem doAnyTask = menu.add(Menu.NONE,1,1,"Update");
            MenuItem delete = menu.add(Menu.NONE,2,2,"Delete");

            doAnyTask.setOnMenuItemClickListener(this);
            delete.setOnMenuItemClickListener(this);

        }

        @Override
        public boolean onMenuItemClick(MenuItem item) {

            if (listener!=null)
            {
                int position = getAdapterPosition();

                if (position!=RecyclerView.NO_POSITION)
                {
                    switch (item.getItemId())
                    {
                        case 1:

                            listener.onDoAnytask(position);
                            return true;

                        case 2:

                            listener.onDelete(position);
                            return true;

                    }
                }
            }

            return false;
        }

    }


    public interface OnItemClickListener extends AdapterView.OnItemClickListener {
        void onItemClick(int position);
        void onDoAnytask(int position);
        void onDelete(int position);

        @Override
        void onItemClick(AdapterView<?> parent, View view, int position, long id);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener  =  listener;
    }



}

