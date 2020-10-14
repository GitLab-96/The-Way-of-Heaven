package com.example.soundtest.Question.Scholer;

import android.content.Context;
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

import java.util.ArrayList;

public class CourseScholerAdapter extends RecyclerView.Adapter<CourseScholerAdapter.MyViewHolder> {

    Context context;
    ArrayList<ScholersCourseClass> courseClasses;
    private OnItemClickListener listener;
    DatabaseReference databaseReference;

    public CourseScholerAdapter(Context c ,ArrayList<ScholersCourseClass> p){

        context = c;
        courseClasses = p;
    }


    @NonNull
    @Override
    public CourseScholerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {


        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.live_scholar_demo_list,parent,false);
        return new MyViewHolder(view);
         }


    @Override
    public void onBindViewHolder(@NonNull CourseScholerAdapter.MyViewHolder holder, int position) {


        holder.course_title.setText(courseClasses.get(position).getTitle());
        holder.cours_start_time.setText(courseClasses.get(position).getCourseStartTime());
        holder.cours_end_time.setText(courseClasses.get(position).getCourseEndTime());
        holder.cours_date.setText(courseClasses.get(position).getCourseDate());
        holder.cours_lecturer.setText(courseClasses.get(position).getSchplarName());
        holder.cours_type.setText(courseClasses.get(position).getCoursetType());
    }

    @Override
    public int getItemCount() {
        return courseClasses.size();
    }




    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnCreateContextMenuListener, MenuItem.OnMenuItemClickListener {

        TextView course_title,cours_start_time,cours_end_time,cours_date,cours_lecturer,cours_type;

        public MyViewHolder(@NonNull final View itemView) {
            super(itemView);

            course_title = itemView.findViewById(R.id.getTitle);
            cours_start_time = itemView.findViewById(R.id.getStartTime);
            cours_date = itemView.findViewById(R.id.getDate);
            cours_lecturer = itemView.findViewById(R.id.getLacturerName);
            cours_type = itemView.findViewById(R.id.getType);
            cours_end_time = itemView.findViewById(R.id.getEndTime);


            itemView.setOnClickListener(this);
            itemView.setOnCreateContextMenuListener(this);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    Toast.makeText(itemView.getContext(), "position"+getAdapterPosition(), Toast.LENGTH_SHORT).show();
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
