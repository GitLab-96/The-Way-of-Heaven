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

import com.example.soundtest.Question.Scholer.ScholarsLiveClass;
import com.example.soundtest.Question.Scholer.ScholersCourseClass;
import com.example.soundtest.R;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.MyViewHolder> {

    Context context;
    ArrayList<ScholersCourseClass> courseClasses;
    private DatabaseReference databaseReference ;

    public CourseAdapter(Context c ,ArrayList<ScholersCourseClass> p){

        context = c;
        courseClasses = p;
    }

    @NonNull
    @Override
    public CourseAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.live_scholar_demo_list,parent,false);
        return new CourseAdapter.MyViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull CourseAdapter.MyViewHolder holder, int i) {


        holder.live_title.setText(courseClasses.get(i).getTitle());
        holder.live_start_time.setText(courseClasses.get(i).getCourseStartTime());
        holder.live_end_time.setText(courseClasses.get(i).getCourseEndTime());
        holder.live_date.setText(courseClasses.get(i).getCourseDate());
        holder.live_lecturer.setText(courseClasses.get(i).getSchplarName());
        holder.live_type.setText(courseClasses.get(i).getCoursetType());
    }

    @Override
    public int getItemCount() {
        return courseClasses.size();
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

                    Intent intent = new Intent(v.getContext(),CallingCourse.class);

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
