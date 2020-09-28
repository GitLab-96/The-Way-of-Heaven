package com.example.soundtest.Question;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.soundtest.R;
import com.google.firebase.database.DatabaseReference;
import java.util.ArrayList;
public class LiveScholarsAdapter extends RecyclerView.Adapter<LiveScholarsAdapter.MyViewHolder> {


    Context context;
    ArrayList<ScholarsLiveClass> liveClasses;
    DatabaseReference databaseReference;

    public LiveScholarsAdapter(Context c ,ArrayList<ScholarsLiveClass> p){

        context = c;
        liveClasses = p;
    }

    @NonNull
    @Override
    public LiveScholarsAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new LiveScholarsAdapter.MyViewHolder(LayoutInflater.from(context).inflate(R.layout.live_scholar_demo_list,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull LiveScholarsAdapter.MyViewHolder holder, int position) {


        holder.live_title.setText(liveClasses.get(position).getTitle());
        holder.live_start_time.setText(liveClasses.get(position).getLiveStartTime());
        holder.live_end_time.setText(liveClasses.get(position).getLiveEndTime());
        holder.live_date.setText(liveClasses.get(position).getLiveDate());
        holder.live_lecturer.setText(liveClasses.get(position).getSchplarName());
        holder.live_type.setText(liveClasses.get(position).getLivetType());
    }

    @Override
    public int getItemCount() {
        return liveClasses.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView live_title,live_start_time,live_end_time,live_date,live_lecturer,live_type;

        public MyViewHolder(@NonNull final View itemView) {
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
                    Toast.makeText(itemView.getContext(), "position"+getAdapterPosition(), Toast.LENGTH_SHORT).show();
                }
            });


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    int position_number = getAdapterPosition();
                    String LiveTitle = live_title.getText().toString();
                    String LiveScholarsName = live_lecturer.getText().toString();
                    String LiveStartTime = live_start_time.getText().toString();
                    String LiveEndtTime = live_end_time.getText().toString();


                    Intent intent = new Intent(v.getContext(),CallingLive.class);
                    intent.putExtra("Position",position_number);
                    intent.putExtra("Title",LiveTitle);
                    intent.putExtra("ScholersName",LiveScholarsName);
                    intent.putExtra("StartTime",LiveStartTime);
                    intent.putExtra("EndTime",LiveEndtTime);


                    v.getContext().startActivity(intent);

                    Toast.makeText(itemView.getContext(), "position"+getAdapterPosition(), Toast.LENGTH_SHORT).show();
                }
            });


        }
    }
}

