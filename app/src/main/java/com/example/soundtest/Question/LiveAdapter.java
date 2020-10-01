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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class LiveAdapter extends RecyclerView.Adapter<LiveAdapter.MyViewHolder> {

    Context context;
    ArrayList<ScholarsLiveClass> liveClasses;

    private DatabaseReference databaseReference ;



    public LiveAdapter(Context c ,ArrayList<ScholarsLiveClass> p){

        context = c;
        liveClasses = p;
    }

    @NonNull
    @Override
    public LiveAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.live_scholar_demo_list,parent,false);
        return new LiveAdapter.MyViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull LiveAdapter.MyViewHolder holder, int i) {


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


    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView live_title,live_start_time,live_end_time,live_date,live_lecturer,live_type;

        public MyViewHolder(@NonNull  View itemView) {
            super(itemView);

            live_title = itemView.findViewById(R.id.getTitle);
            live_start_time = itemView.findViewById(R.id.getStartTime);
            live_end_time = itemView.findViewById(R.id.getEndTime);
            live_date = itemView.findViewById(R.id.getDate);
            live_lecturer = itemView.findViewById(R.id.getLacturerName);
            live_type = itemView.findViewById(R.id.getType);




            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    int position_number = getAdapterPosition();
                    String LiveTitle = live_title.getText().toString();
                    String LiveScholarsName = live_lecturer.getText().toString();
                    String LiveStartTime = live_start_time.getText().toString();
                    String LiveEndtTime = live_end_time.getText().toString();

                    Intent intent = new Intent(v.getContext(),CallingLive.class);

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
    }



    }



