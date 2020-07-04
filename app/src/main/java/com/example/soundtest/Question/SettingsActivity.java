package com.example.soundtest.Question;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.soundtest.MainActivity;
import com.example.soundtest.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.UUID;

import de.hdodenhof.circleimageview.CircleImageView;


public class SettingsActivity extends AppCompatActivity {

    private TextView setName,setEmail,setPhoneNo,setactivationTV,updateDOB,setGander,actiovation_Date,eddit_profile,set_raligion,set_nationality,updateActivationDate,setDOB;
    private EditText updateName,updateEmail,updatePhoneNo,update_raligion,update_nationality;
    private ImageButton cameraFab;
    private Spinner updateGender;
    private Button saveButtn;
    private ImageButton updateButtn;
    private CircleImageView userProfileImage;
    private String currentUserID;
    public FirebaseAuth mAuth;
    public DatabaseReference RootRef;
    public Uri uri;
    private String dounloadLink;
    public StorageReference storageReference;

    DatePickerDialog.OnDateSetListener onDateSetListener,onDateSetListener1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        init();
        mAuth=FirebaseAuth.getInstance();
        currentUserID= mAuth.getCurrentUser().getUid();
        RootRef= FirebaseDatabase.getInstance().getReference();

        storageReference = FirebaseStorage.getInstance().getReference();

        updateName.setVisibility(updateName.INVISIBLE);
        updateEmail.setVisibility(updateEmail.INVISIBLE);
        updatePhoneNo.setVisibility(updatePhoneNo.INVISIBLE);
        updateGender.setVisibility(updateGender.INVISIBLE);
        updateDOB.setVisibility(updateDOB.INVISIBLE);
        update_raligion.setVisibility(update_raligion.INVISIBLE);
        update_nationality.setVisibility(update_nationality.INVISIBLE);
        saveButtn.setVisibility(saveButtn.INVISIBLE);
        updateActivationDate.setVisibility(updateActivationDate.INVISIBLE);
        cameraFab.setVisibility(cameraFab.INVISIBLE);
        EdditButtn();
        SaveButtn();
        SetGenderSpinner();
        DateOfBirth();
        ActivationDate();
        RetreveData();
        cameraFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                intent.setType("image/*" );
                startActivityForResult(intent,0);
            }
        });

    }


    private void SaveButtn() {
        saveButtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                UpdateSettings();
                updateName.setVisibility(updateName.INVISIBLE);
                updateEmail.setVisibility(updateEmail.INVISIBLE);
                updatePhoneNo.setVisibility(updatePhoneNo.INVISIBLE);
                update_raligion.setVisibility(update_raligion.INVISIBLE);
                update_nationality.setVisibility(update_nationality.INVISIBLE);
                updateGender.setVisibility(updateGender.INVISIBLE);
                updateDOB.setVisibility(updateDOB.INVISIBLE);
                saveButtn.setVisibility(saveButtn.INVISIBLE);
                cameraFab.setVisibility(cameraFab.INVISIBLE);
                updateActivationDate.setVisibility(updateActivationDate.INVISIBLE);
                setName.setVisibility(setName.VISIBLE);
                setEmail.setVisibility(setEmail.VISIBLE);
                setPhoneNo.setVisibility(setPhoneNo.VISIBLE);
                set_raligion.setVisibility(set_raligion.VISIBLE);
                set_nationality.setVisibility(set_nationality.VISIBLE);
                setGander.setVisibility(setGander.VISIBLE);
                setDOB.setVisibility(setDOB.VISIBLE);
                actiovation_Date.setVisibility(actiovation_Date.VISIBLE);
                updateButtn.setVisibility(updateButtn.VISIBLE);
                setactivationTV.setVisibility(setactivationTV.VISIBLE);


            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK){

            if (requestCode== 0){

                uri  =data.getData();

                userProfileImage.setImageURI(uri);

            }

        }
    }

    private void UpdateSettings() {
        String setUserName = updateName.getText().toString();
        String setUserEmail = updateEmail.getText().toString();
        String setphoneNo = updatePhoneNo.getText().toString();
        String setGender = updateGender.getSelectedItem().toString();
        String setActivationdate = updateActivationDate.getText().toString();
        String setDateOfBirth = updateDOB.getText().toString();
        String setReligion = update_raligion.getText().toString();
        String setNationality = update_nationality.getText().toString();


        if (TextUtils.isEmpty(setUserName)) {

            Toast.makeText(this, "Please Write your User Name First...", Toast.LENGTH_SHORT).show();
        }

        if (TextUtils.isEmpty(setUserEmail)) {

            Toast.makeText(this, "Please Write your Email First...", Toast.LENGTH_SHORT).show();
        }
        else {


            SettingDataClass settingDataClass = new SettingDataClass(setUserName,setUserEmail,setphoneNo,setGender,setReligion,setNationality,setDateOfBirth,setActivationdate);

            RootRef.setValue(settingDataClass);


        }
    }

     private void RetreveData() {

        RootRef = FirebaseDatabase.getInstance().getReference().child("Users").child(currentUserID);
        RootRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                String retreveUsername = (String) dataSnapshot.child("name").getValue();
                String retreveUseremail = (String) dataSnapshot.child("email").getValue();
                String retreveUserPhone = (String) dataSnapshot.child("phoneNo").getValue();
                String retreveUserReligion = (String) dataSnapshot.child("religion").getValue();
                String retreveUserNationality = (String) dataSnapshot.child("nationality").getValue();
                String retreveUserActivationDate = (String) dataSnapshot.child("aplicationDate").getValue();
                String retreveUserDoB = (String) dataSnapshot.child("dob").getValue();
                String retreveUserGender = (String) dataSnapshot.child("gander").getValue();

                setName.setText(retreveUsername);
                setEmail.setText(retreveUseremail);
                setPhoneNo.setText(retreveUserPhone);
                set_raligion.setText(retreveUserReligion);
                set_nationality.setText(retreveUserNationality);
                setactivationTV.setText(retreveUserActivationDate);
                setGander.setText(retreveUserGender);
                setDOB.setText(retreveUserDoB);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



    }
    private void ActivationDate() {
        updateActivationDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(SettingsActivity.this,onDateSetListener,year,month,day);

                datePickerDialog.show();
            }
        });

        onDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                month = month+1;
                String date = dayOfMonth+"/"+month+"/"+year;
                actiovation_Date.setText(date);
                updateActivationDate.setText(date);
            }
        };

    }
    private void DateOfBirth() {

        updateDOB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(SettingsActivity.this,onDateSetListener1,year,month,day);

                datePickerDialog.show();
            }
        });

        onDateSetListener1 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                month = month+1;
                String date = dayOfMonth+"/"+month+"/"+year;
                setDOB.setText(date);
                updateDOB.setText(date);
            }
        };
    }
    private void SetGenderSpinner() {

        final ArrayList<String> Ganderlist =new ArrayList<>();

        Ganderlist.add("Male");
        Ganderlist.add("Female");
        Ganderlist.add("Others");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(SettingsActivity.this,R.layout.support_simple_spinner_dropdown_item,Ganderlist);
        updateGender.setAdapter(adapter);
        updateGender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(SettingsActivity.this, "Sumon", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    private void SendUserToMainActivity() {

        Intent mainIntent=new Intent(SettingsActivity.this, MainActivity.class);
        mainIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(mainIntent);
        finish();
    }
    private void EdditButtn() {
        updateButtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateName.setVisibility(updateName.VISIBLE);
                updateEmail.setVisibility(updateEmail.VISIBLE);
                updatePhoneNo.setVisibility(updatePhoneNo.VISIBLE);
                update_raligion.setVisibility(update_raligion.VISIBLE);
                update_nationality.setVisibility(update_nationality.VISIBLE);
                updateGender.setVisibility(updateGender.VISIBLE);
                updateDOB.setVisibility(updateDOB.VISIBLE);
                cameraFab.setVisibility(cameraFab.VISIBLE);
                updateActivationDate.setVisibility(updateActivationDate.VISIBLE);
                saveButtn.setVisibility(saveButtn.VISIBLE);
                setName.setVisibility(setName.INVISIBLE);
                setEmail.setVisibility(setEmail.INVISIBLE);
                setPhoneNo.setVisibility(setPhoneNo.INVISIBLE);
                set_raligion.setVisibility(set_raligion.INVISIBLE);
                set_nationality.setVisibility(set_nationality.INVISIBLE);
                setGander.setVisibility(setGander.INVISIBLE);
                setDOB.setVisibility(setDOB.INVISIBLE);
                actiovation_Date.setVisibility(actiovation_Date.INVISIBLE);
                updateButtn.setVisibility(updateButtn.INVISIBLE);
                setactivationTV.setVisibility(setactivationTV.VISIBLE);
            }
        });

    }

    private void init() {
        setName = findViewById(R.id.set_user_nameTV);
        setEmail = findViewById(R.id.set_user_statuseTV);
        setPhoneNo = findViewById(R.id.set_user_phone_numberTV);
        setGander = findViewById(R.id.ganderTV);
        setDOB = findViewById(R.id.setDOB);
        set_raligion = findViewById(R.id.set_user_religoinTV);
        set_nationality = findViewById(R.id.set_user_nationalityTV);
        actiovation_Date = findViewById(R.id.setActivationDate);
        updateActivationDate = findViewById(R.id.updateActivationDate);
        updateName = findViewById(R.id.set_user_nameET);
        updateEmail = findViewById(R.id.set_user_statuseET);
        updatePhoneNo = findViewById(R.id.set_user_phone_numberET);
        updateGender = findViewById(R.id.genderSpinner);
        update_raligion = findViewById(R.id.set_user_RelegionET);
        update_nationality = findViewById(R.id.set_user_nationalityET);
        updateDOB = findViewById(R.id.DOBET);
        saveButtn = findViewById(R.id.save_settings_buttn);
        updateButtn = findViewById(R.id.update_settings_buttn);
        cameraFab = findViewById(R.id.CameraFAB);
        setactivationTV = findViewById(R.id.setActivationDate);
        userProfileImage = findViewById(R.id.set_profile_image);

    }
}
