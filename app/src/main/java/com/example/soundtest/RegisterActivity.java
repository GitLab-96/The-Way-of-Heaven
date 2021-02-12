package com.example.soundtest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.soundtest.Question.SettingsActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class RegisterActivity extends AppCompatActivity {

    private Button crateAccountButn;
    private EditText userEmail,userPassword;
    private TextView AlreadyHaveanAccountLink;
    private FirebaseAuth mAuth;
    private ProgressDialog loadingBar;
    private DatabaseReference RootRef,RootRefMarks;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        init();

        mAuth=FirebaseAuth.getInstance();


        RootRef = FirebaseDatabase.getInstance().getReference();

        AlreadyHaveanAccountLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SendUserToLoginActivity();


            }
        });

        crateAccountButn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreateNewAccount();



            }
        });
    }

    private void CreateNewAccount() {

        String email = userEmail.getText().toString();
        String password = userPassword.getText().toString();

        if (TextUtils.isEmpty(email)) {

            Toast.makeText(this, "Please Enter Email......", Toast.LENGTH_SHORT).show();
        }
        if (TextUtils.isEmpty(password)) {

            Toast.makeText(this, "Please Enter password......", Toast.LENGTH_SHORT).show();
        }
        else {
            loadingBar.setTitle("Create New Account");
            loadingBar.setMessage("Please wait,while we are creating new Account For You...");
            loadingBar.setCanceledOnTouchOutside(true);
            loadingBar.show();

            mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {


                    if (task.isSuccessful()){

                        String currentUserID= mAuth.getCurrentUser().getUid();
                        SendUserToSettingActivity();
                        Toast.makeText(RegisterActivity.this, "Account Created Succesfully", Toast.LENGTH_SHORT).show();
                        loadingBar.dismiss();

                        RootRefMarks = FirebaseDatabase.getInstance().getReference().child("Marks").child(currentUserID).child("Marks");





                        RootRefMarks.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                                RootRefMarks.child("HorofExam").setValue("0");
                                RootRefMarks.child("TomijExam").setValue("0");
                                RootRefMarks.child("HorkotExam").setValue("0");
                                RootRefMarks.child("KolkolaExam").setValue("0");
                                RootRefMarks.child("WajibExam").setValue("0");
                                RootRefMarks.child("MaddExam").setValue("0");
                                RootRefMarks.child("GunnahExam").setValue("0");
                                RootRefMarks.child("RoExam").setValue("0");
                                RootRefMarks.child("AllahExam").setValue("0");
                                RootRefMarks.child("SuraExam").setValue("0");

                        //        Toast.makeText(RegisterActivity.this, "Marks Added", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {

                            }
                        });


                    }
                    else {
                        String massage = task.getException().toString();
                        Toast.makeText(RegisterActivity.this, "Error:"+massage, Toast.LENGTH_SHORT).show();
                        loadingBar.dismiss();
                    }
                }
            });
        }


    }

    private void SendUserToSettingActivity() {
        Intent mainIntent=new Intent(RegisterActivity.this,SettingsActivity.class);

        mainIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(mainIntent);
        finish();

    }

    private void SendUserToMainActivity() {

        Intent mainIntent=new Intent(RegisterActivity.this,MainActivity.class);

       mainIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(mainIntent);
        finish();
    }

    private void init() {

        crateAccountButn = findViewById(R.id.register_buttn);
        userEmail = findViewById(R.id.registerEmail);
        userPassword = findViewById(R.id.registerPassword);
        AlreadyHaveanAccountLink = findViewById(R.id.alreadyAccountLink);
        loadingBar = new ProgressDialog(this);
    }

    private void SendUserToLoginActivity() {

        startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
    }
}
