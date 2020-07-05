package com.example.soundtest.Question;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.soundtest.R;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;
    ArrayList<TypeQuestionClass> questions;

    public MyAdapter(Context c ,ArrayList<TypeQuestionClass> p){

        context = c;
        questions = p;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.question_list,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.userQuestion.setText(questions.get(position).getTypeQuestion());
    }

    @Override
    public int getItemCount() {
        return questions.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder
{

    TextView userQuestion;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);

        userQuestion = itemView.findViewById(R.id.userQuestion);
    }
}

}
