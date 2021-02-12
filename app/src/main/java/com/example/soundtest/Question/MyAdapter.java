package com.example.soundtest.Question;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.soundtest.MainActivity;
import com.example.soundtest.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import static com.example.soundtest.Question.Scholer.App.CHANNEL_1_ID;
import static com.example.soundtest.R.id.questionLinearLayout;

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

        final NotificationManagerCompat notificationManager= NotificationManagerCompat.from(context);

        holder.userQuestion.setText(questions.get(position).getTypeQuestion());
        holder.sendAnswerButtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                answer = holder.typeAnswerET.getText().toString();

                Intent activityIntent = new Intent(context, HomeQuestionActivity.class);
                PendingIntent contentIntent = PendingIntent.getActivity(context,
                        0, activityIntent, 0);

                Intent broadcastIntent = new Intent(context, HomeQuestionActivity.class);

                PendingIntent actionIntent = PendingIntent.getBroadcast(context ,
                        0, broadcastIntent, PendingIntent.FLAG_UPDATE_CURRENT);

                Notification notification = new NotificationCompat.Builder(context, CHANNEL_1_ID)
                        .setSmallIcon(R.drawable.ic_launcher_background)
                        .setContentTitle(answer)
                        .setPriority(NotificationCompat.PRIORITY_HIGH)
                        .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                        .setColor(Color.BLUE)
                        .setContentIntent(contentIntent)
                        .setAutoCancel(true)
                        .setOnlyAlertOnce(true)
                        .addAction(R.mipmap.ic_launcher, "Your Answer", actionIntent)
                        .build();
                notificationManager.notify(1, notification);

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

    class MyViewHolder extends RecyclerView.ViewHolder {

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
