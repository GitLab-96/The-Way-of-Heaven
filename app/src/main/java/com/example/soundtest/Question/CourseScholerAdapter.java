package com.example.soundtest.Question;

import android.content.Context;
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

public class CourseScholerAdapter extends RecyclerView.Adapter<CourseScholerAdapter.MyViewHolder> {

    Context context;
    ArrayList<ScholersCourseClass> courseClasses;
    DatabaseReference databaseReference;

    public CourseScholerAdapter(Context c ,ArrayList<ScholersCourseClass> p){

        context = c;
        courseClasses = p;
    }


    @NonNull
    @Override
    public CourseScholerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new CourseScholerAdapter.MyViewHolder(LayoutInflater.from(context).inflate(R.layout.live_scholar_demo_list,parent,false));
    }


    @Override
    public void onBindViewHolder(@NonNull CourseScholerAdapter.MyViewHolder holder, int position) {


        holder.course_title.setText(courseClasses.get(position).getTitle());
        holder.cours_start_time.setText(courseClasses.get(position).getCourseTime());
        holder.cours_end_time.setText(courseClasses.get(position).getCourseTime());
        holder.cours_date.setText(courseClasses.get(position).getCourseDate());
        holder.cours_lecturer.setText(courseClasses.get(position).getSchplarName());
        holder.cours_type.setText(courseClasses.get(position).getCoursetType());
    }

    @Override
    public int getItemCount() {
        return courseClasses.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView course_title,cours_id,cours_start_time,cours_end_time,cours_date,cours_lecturer,cours_type;

        public MyViewHolder(@NonNull final View itemView) {
            super(itemView);

            course_title = itemView.findViewById(R.id.getTitle);
            cours_start_time = itemView.findViewById(R.id.getStartTime);
            cours_date = itemView.findViewById(R.id.getDate);
            cours_lecturer = itemView.findViewById(R.id.getLacturerName);
            cours_type = itemView.findViewById(R.id.getType);
            cours_end_time = itemView.findViewById(R.id.getEndTime);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(itemView.getContext(), "position"+getAdapterPosition(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
