package com.example.soundtest.Question;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.soundtest.MainActivity;
import com.example.soundtest.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;
    ArrayList<TypeQuestionClass> questions;
    String answer;
    DatabaseReference databaseReference;

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
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {

        holder.userQuestion.setText(questions.get(position).getTypeQuestion());
        holder.sendAnswerButtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                answer = holder.typeAnswerET.getText().toString();
                String postKey = questions.get(position).getKey();
                databaseReference =FirebaseDatabase.getInstance().getReference();
                databaseReference.child("Question").child(postKey).child("typeAnswer").setValue(answer)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if(task.isSuccessful()){
                                    Toast.makeText(context, "Thank you for your answer.", Toast.LENGTH_SHORT).show();
                                }
                                else {
                                    Toast.makeText(context, "Error: "+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });
    }

    @Override
    public int getItemCount() {
        return questions.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder
{

    EditText typeAnswerET;
    private ImageView sendAnswerButtn;
    TextView userQuestion;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);

        userQuestion = itemView.findViewById(R.id.userQuestion);
        typeAnswerET = itemView.findViewById(R.id.typeAnswerET);
        sendAnswerButtn = itemView.findViewById(R.id.sendAnswernBttn);
    }
}

}
