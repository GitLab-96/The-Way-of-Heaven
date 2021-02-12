package com.example.soundtest.Question;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.soundtest.R;
import com.example.soundtest.Read.Read;
import com.example.soundtest.Salah.BoysFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {
    private TextView userName,userPhone,userEmail;
    private ImageView alemList;
    private CircleImageView userImage;
    private String currentUserID;
    private FirebaseAuth mAuth;
    private DatabaseReference RootRef;
    Activity context;


    ProgressBar horizontalProgressBar;
    int totalMarks=0;
    Handler handler = new Handler();

    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        context = getActivity();
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        mAuth=FirebaseAuth.getInstance();
        currentUserID= mAuth.getCurrentUser().getUid();
        userName = view.findViewById(R.id.get_user_name);
        userPhone = view.findViewById(R.id.get_user_phone_number);
        userEmail = view.findViewById(R.id.get_user_email);
        userImage = view.findViewById(R.id.get_profile_image);
        alemList = view.findViewById(R.id.alemList);
        horizontalProgressBar = view.findViewById(R.id.progressBar2);

        alemList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

             Intent intent = new Intent(context, AlemList.class);
             startActivity(intent);
            }
        });

        RetreveData();



        ProgressingTask();
      return view;
    }

    private void ProgressingTask() {

        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        if(currentUser != null){
            String currentUserID=currentUser.getUid();
            RootRef.child("Marks").child(currentUserID).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    if(dataSnapshot.exists()){
                        String Allah = dataSnapshot.child("Marks").child("AllahExam").getValue(String.class);
                        int allah =Integer.parseInt(Allah);
                        String Gunnah = dataSnapshot.child("Marks").child("GunnahExam").getValue(String.class);
                        int gunnah =Integer.parseInt(Gunnah);
                        String Horkot = dataSnapshot.child("Marks").child("HorkotExam").getValue(String.class);
                        int horkot =Integer.parseInt(Horkot);
                        String Horof = dataSnapshot.child("Marks").child("HorofExam").getValue(String.class);
                        int horof =Integer.parseInt(Horof);
                        String Kolkola = dataSnapshot.child("Marks").child("KolkolaExam").getValue(String.class);
                        int kolkolah =Integer.parseInt(Kolkola);
                        String Madd = dataSnapshot.child("Marks").child("MaddExam").getValue(String.class);
                        int modd =Integer.parseInt(Madd);
                        String Ro = dataSnapshot.child("Marks").child("RoExam").getValue(String.class);
                        int ro =Integer.parseInt(Ro);
                        String Sura = dataSnapshot.child("Marks").child("SuraExam").getValue(String.class);
                        int sura =Integer.parseInt(Sura);
                        String Tomij = dataSnapshot.child("Marks").child("TomijExam").getValue(String.class);
                        int tomij =Integer.parseInt(Tomij);
                        String Wajib =dataSnapshot.child("Marks").child("WajibExam").getValue(String.class);
                        int wajib =Integer.parseInt(Wajib);
                        totalMarks = allah+gunnah+horkot+horof+kolkolah+modd+ro+sura+tomij+wajib;



                    }
                    // Toast.makeText(MainActivity.this, TM, Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }


        // Adding colors on progress bar
        horizontalProgressBar.getProgressDrawable().setColorFilter(Color.CYAN, PorterDuff.Mode.SRC_IN);


        new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                while(totalMarks < 200)
                {
                    // intValue++;

                    handler.post(new Runnable() {

                        @Override
                        public void run() {

                            horizontalProgressBar.setProgress(totalMarks);


                        }
                    });try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                }
            }
        }).start();

    }

    private void RetreveData() {

        RootRef = FirebaseDatabase.getInstance().getReference().child("Users").child(currentUserID);
        RootRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                if (dataSnapshot.exists()){
                    String imageDb = dataSnapshot.child("image").getValue().toString();
                    String retreveUsername = dataSnapshot.child("name").getValue().toString();
                    String retreveUserPhone = dataSnapshot.child("phoneNo").getValue().toString();
                    String retreveUserEmail = dataSnapshot.child("email").getValue().toString();

                    userName.setText(retreveUsername);
                    userPhone.setText(retreveUserPhone);
                    userEmail.setText(retreveUserEmail);
                    Picasso.get().load(imageDb).placeholder(R.drawable.book11).into(userImage);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
