package com.example.soundtest.Question;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.soundtest.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;

public class GroupChatActivity extends AppCompatActivity {
    private Toolbar mtoolbar;
    private ImageButton SendMassageButtn;
    private EditText userMassageInput;
    private ScrollView mScrollView;
    private TextView displayTextMassage;

    private String currentGroupName,currentUserID,currentUserName,currentDate,currentTime;
    private FirebaseAuth mAuth;
    private DatabaseReference UsersRef,GroupNameRef,GroupMassageKeyRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_chat);

        currentGroupName = getIntent().getExtras().get("groupName").toString();
        Toast.makeText(GroupChatActivity.this, currentGroupName, Toast.LENGTH_SHORT).show();

        mAuth = FirebaseAuth.getInstance();
        currentUserID = mAuth.getCurrentUser().getUid();
        UsersRef = FirebaseDatabase.getInstance().getReference().child("Users");
        GroupNameRef = FirebaseDatabase.getInstance().getReference().child("Groups").child(currentGroupName);



        init();

        getUserInfo();

        SendMassageButtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              SaveMassageInfotoDataBase();

              userMassageInput.setText("");
                mScrollView.fullScroll(ScrollView.FOCUS_DOWN);
            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();

        GroupNameRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                if (dataSnapshot.exists()){

                    DisplayMessages(dataSnapshot);
                }

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                if (dataSnapshot.exists()){

                    DisplayMessages(dataSnapshot);
                }

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }


    private void init() {
        mtoolbar = findViewById(R.id.toolBar);
        setSupportActionBar(mtoolbar);
        getSupportActionBar().setTitle(currentGroupName);
        SendMassageButtn = findViewById(R.id.send_massage_button);
        userMassageInput = findViewById(R.id.input_group_massage);
        displayTextMassage = findViewById(R.id.group_chat_text_display);
        mScrollView = findViewById(R.id.my_scroll_view);


    }

    private void getUserInfo() {

        UsersRef.child(currentUserID).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()){

                    currentUserName = dataSnapshot.child("name").getValue().toString();

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    private void SaveMassageInfotoDataBase() {

    String massage = userMassageInput.getText().toString();
    String massageKEY = GroupNameRef.push().getKey();
    
    if (TextUtils.isEmpty(massage)){

        Toast.makeText(this, "Please write Massage First", Toast.LENGTH_SHORT).show();
    }
    else {

        Calendar calForDate=Calendar.getInstance();
        SimpleDateFormat currentDateFormate = new SimpleDateFormat("MMM dd, yyy");
        currentDate = currentDateFormate.format(calForDate.getTime());


        Calendar calForTime=Calendar.getInstance();
        SimpleDateFormat currentTimeFormat = new SimpleDateFormat("hh:mm a");
        currentTime = currentTimeFormat.format(calForTime.getTime());

        HashMap<String,Object> groupMassagheKey = new HashMap<>();
        GroupNameRef.updateChildren(groupMassagheKey);

        GroupMassageKeyRef = GroupNameRef.child(massageKEY);

        HashMap<String,Object> messageInfoMap = new HashMap<>();

        messageInfoMap.put("name",currentUserName);
        messageInfoMap.put("message",massage);
        messageInfoMap.put("date",currentDate);
        messageInfoMap.put("time",currentTime);

        GroupMassageKeyRef.updateChildren(messageInfoMap);


    }
    }
    private void DisplayMessages(DataSnapshot dataSnapshot) {


        Iterator iterator = dataSnapshot.getChildren().iterator();
        while (iterator.hasNext()){
            String chatDate = (String) ((DataSnapshot)iterator.next()).getValue();
            String chatMessage = (String) ((DataSnapshot)iterator.next()).getValue();
            String chatName = (String) ((DataSnapshot)iterator.next()).getValue();
            String chatTime = (String) ((DataSnapshot)iterator.next()).getValue();

            displayTextMassage.append(chatName +":\n"+chatMessage+"\n"+chatTime+"  "+chatDate+"\n"+"\n"+"\n");
            mScrollView.fullScroll(ScrollView.FOCUS_DOWN);
        }
    }


    }
