package com.example.soundtest.Question;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.soundtest.R;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

public class ApnarProshnoAdapter extends RecyclerView.Adapter<ApnarProshnoAdapter.MyViewHolder> {

    Context context;
    ArrayList<TypeQuestionClass> questions;

    public ApnarProshnoAdapter(Context c ,ArrayList<TypeQuestionClass> p){

        context = c;
        questions = p;
    }

    @NonNull
    @Override
    public ApnarProshnoAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new ApnarProshnoAdapter.MyViewHolder(LayoutInflater.from(context).inflate(R.layout.apnar_prosno_demo_list,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull ApnarProshnoAdapter.MyViewHolder holder, int position) {
        holder.user_question.setText(questions.get(position).getTypeQuestion());
        holder.user_answer.setText(questions.get(position).getTypeAnswer());
    }

    @Override
    public int getItemCount() {
        return questions.size();
    }



    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView user_question,user_answer;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            user_question = itemView.findViewById(R.id.userQuestionTV);
            user_answer = itemView.findViewById(R.id.userAnswerTV);
        }
    }
}
