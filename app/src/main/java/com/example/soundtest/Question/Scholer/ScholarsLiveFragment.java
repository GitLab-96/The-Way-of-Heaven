package com.example.soundtest.Question.Scholer;


import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.soundtest.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 */
public class ScholarsLiveFragment extends Fragment {

    private TextView liveDate,liveStartTime,liveEndingTime,LiveDay;
    private EditText liveTitle,liveScholarName,scholarTitle,liveSubject;
    private Spinner liveTypeSpinner;
    private Button confirmLiveBttn;
    private FloatingActionButton liveSessionAddBttn;
    DatePickerDialog.OnDateSetListener onDateSetListener;

    public DatabaseReference RootRefLiveInUser,RootefLive;
    private String currentUserID;
    public FirebaseAuth mAuth;

    DatabaseReference reference;
    RecyclerView recyclerView;
    ArrayList<ScholarsLiveClass> live_list;
    LiveScholarsAdapter adapter;

    public ScholarsLiveFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_scholars_live, container, false);


        liveSessionAddBttn = view.findViewById(R.id.add_live_session);
        recyclerView = view.findViewById(R.id.scholersLiveRecylerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        mAuth= FirebaseAuth.getInstance();
        currentUserID= mAuth.getCurrentUser().getUid();
        RootRefLiveInUser = FirebaseDatabase.getInstance().getReference().child("Users").child(currentUserID);
        RootefLive = FirebaseDatabase.getInstance().getReference().child("Live");


        live_list = new ArrayList<>();

        reference = FirebaseDatabase.getInstance().getReference().child("Users").child(currentUserID);

        reference.child("Live").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                live_list.clear();
                for (DataSnapshot dataSnapshot1:dataSnapshot.getChildren()){

                    ScholarsLiveClass p = dataSnapshot1.getValue(ScholarsLiveClass.class);
                    p.setKey(dataSnapshot1.getKey());
                    live_list.add(p);
                }
                adapter = new LiveScholarsAdapter(getContext(),live_list);
                recyclerView.setAdapter(adapter);

                adapter.setOnItemClickListener(new LiveScholarsAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(int position) {

                        String text = live_list.get(position).getSchplarName();
                        Toast.makeText(getContext(), text+" is Selected"+position, Toast.LENGTH_SHORT).show();
                    }


                    @Override
                    public void onDoAnytask(int position) {


                        ScholarsLiveClass selectedItem = live_list.get(position);
                        final  String key1 = selectedItem.getKey();



                        DatabaseReference retreveRef = FirebaseDatabase.getInstance().getReference().child("Live");
                        retreveRef.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                                if (dataSnapshot.exists()){

                                    String retreveDate = (String) dataSnapshot.child(key1).child("liveDate").getValue();
                                    String retreveDay = (String) dataSnapshot.child(key1).child("liveDay").getValue();
                                    String retreveStartTime= (String) dataSnapshot.child(key1).child("liveStartTime").getValue();
                                    String retreveEndTime = (String) dataSnapshot.child(key1).child("liveEndTime").getValue();
                                    String retreveTitle = (String) dataSnapshot.child(key1).child("title").getValue();
                                    String retreveName = (String) dataSnapshot.child(key1).child("schplarName").getValue();
                                    String retreveSubject = (String) dataSnapshot.child(key1).child("liveSubject").getValue();
                                    String retreveScholerTitle = (String) dataSnapshot.child(key1).child("scholarTitle").getValue();

                                    liveDate.setText(retreveDate);
                                    LiveDay.setText(retreveDay);
                                    liveStartTime.setText(retreveStartTime);
                                    liveEndingTime.setText(retreveEndTime);
                                    liveTitle.setText(retreveTitle);
                                    liveScholarName.setText(retreveName);
                                    liveSubject.setText(retreveSubject);
                                    scholarTitle.setText(retreveScholerTitle);


                                }else {

                                    Toast.makeText(getContext(), "Opps.....", Toast.LENGTH_SHORT).show();
                                }

                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {

                                Toast.makeText(getContext(), "Opps....."+databaseError, Toast.LENGTH_SHORT).show();

                            }
                        });



















                        AlertDialog.Builder mBuilder = new AlertDialog.Builder(getContext());
                        View mView = getLayoutInflater().inflate(R.layout.live_session_add,null);

                        liveDate = mView.findViewById(R.id.liveDate);
                        liveStartTime = mView.findViewById(R.id.StartTime);
                        liveEndingTime = mView.findViewById(R.id.EndTime);
                        LiveDay = mView.findViewById(R.id.liveDay);

                        liveTitle = mView.findViewById(R.id.liveTitle);
                        liveScholarName = mView.findViewById(R.id.liveScholarsName);
                        scholarTitle = mView.findViewById(R.id.scholarsTitle);
                        liveSubject = mView.findViewById(R.id.liveSubject);
                        liveTypeSpinner = mView.findViewById(R.id.typeSpinner);
                        confirmLiveBttn = mView.findViewById(R.id.confirmLiveButtn);


                        TypeSpinner();
                        LiveStartTime();
                        LiveEndTime();
                        LiveDate();
                        mBuilder.setView(mView);
                        final AlertDialog dialog = mBuilder.create();
                        dialog.show();

                        confirmLiveBttn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {


                                String setLiveTitle = liveTitle.getText().toString();
                                String setLiveScholarsName = liveScholarName.getText().toString();
                                String setScholarTitle = scholarTitle.getText().toString();
                                String setLiveType = liveTypeSpinner.getSelectedItem().toString();
                                String setLiveStartTime = liveStartTime.getText().toString();
                                String setLiveEndTime = liveEndingTime.getText().toString();
                                String setLiveDay = LiveDay.getText().toString();
                                String setLiveDate = liveDate.getText().toString();
                                String setLiveSubject = liveSubject.getText().toString();






                                ScholarsLiveClass scholarsLiveClass = new ScholarsLiveClass(setLiveTitle,setLiveScholarsName,setScholarTitle,setLiveType,setLiveStartTime,setLiveEndTime,setLiveDay,setLiveDate,setLiveSubject);

                                RootRefLiveInUser.child("Live").child(key1).setValue(scholarsLiveClass);

                                RootefLive.child(key1).setValue(scholarsLiveClass);

                                Toast.makeText(getContext(), "Your Live Session Created..", Toast.LENGTH_SHORT).show();

                                dialog.dismiss();

                            }

                        });
                        Toast.makeText(getContext(), "Update Your Live Info..", Toast.LENGTH_SHORT).show();


                    }

                    @Override
                    public void onDelete(int position) {

                        ScholarsLiveClass selectedItem = live_list.get(position);
                        final  String key = selectedItem.getKey();

                        DatabaseReference ItemRef = FirebaseDatabase.getInstance().getReference().child("Users").child(currentUserID).child("Live");

                        DatabaseReference liveItemRef = FirebaseDatabase.getInstance().getReference().child("Live");

                        liveItemRef.child(key).removeValue();


                        ItemRef.child(key).removeValue();


                    }

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    }
                });
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Toast.makeText(getContext(), "Opps......"+databaseError, Toast.LENGTH_SHORT).show();
            }

        });


        AddLiveSession();

        return view;
    }



    private void AddLiveSession() {


        liveSessionAddBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder mBuilder = new AlertDialog.Builder(getContext());
                View mView = getLayoutInflater().inflate(R.layout.live_session_add,null);

                liveDate = mView.findViewById(R.id.liveDate);
                liveStartTime = mView.findViewById(R.id.StartTime);
                liveEndingTime = mView.findViewById(R.id.EndTime);
                LiveDay = mView.findViewById(R.id.liveDay);

                liveTitle = mView.findViewById(R.id.liveTitle);
                liveScholarName = mView.findViewById(R.id.liveScholarsName);
                scholarTitle = mView.findViewById(R.id.scholarsTitle);
                liveSubject = mView.findViewById(R.id.liveSubject);
                liveTypeSpinner = mView.findViewById(R.id.typeSpinner);
                confirmLiveBttn = mView.findViewById(R.id.confirmLiveButtn);

                TypeSpinner();
                LiveStartTime();
                LiveEndTime();
                LiveDate();
                mBuilder.setView(mView);
                final AlertDialog dialog = mBuilder.create();
                dialog.show();

                confirmLiveBttn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String setLiveTitle = liveTitle.getText().toString();
                        String setLiveScholarsName = liveScholarName.getText().toString();
                        String setScholarTitle = scholarTitle.getText().toString();
                        String setLiveType = liveTypeSpinner.getSelectedItem().toString();
                        String setLiveStartTime = liveStartTime.getText().toString();
                        String setLiveEndTime = liveEndingTime.getText().toString();
                        String setLiveDay = LiveDay.getText().toString();
                        String setLiveDate = liveDate.getText().toString();
                        String setLiveSubject = liveSubject.getText().toString();



                        if (TextUtils.isEmpty(setLiveTitle)) {

                            Toast.makeText(getContext(), "Please Write Live Title First...", Toast.LENGTH_SHORT).show();
                        }

                        if (TextUtils.isEmpty(setLiveScholarsName)) {

                            Toast.makeText(getContext(), "Please Write your Name First...", Toast.LENGTH_SHORT).show();
                        }
                        else {


                            String key = RootRefLiveInUser.push().getKey();

                            ScholarsLiveClass scholarsLiveClass = new ScholarsLiveClass(setLiveTitle,setLiveScholarsName,setScholarTitle,setLiveType,setLiveStartTime,setLiveEndTime,setLiveDay,setLiveDate,setLiveSubject);
                            RootRefLiveInUser.child("Live").child(key).setValue(scholarsLiveClass);

                            RootefLive.child(key).setValue(scholarsLiveClass);

                            Toast.makeText(getContext(), "Your Live Session Created..", Toast.LENGTH_SHORT).show();

                            dialog.dismiss();
                        }

                    }

                });




            }
        });




    }

    private void TypeSpinner() {

        final ArrayList<String> LivetypeList =new ArrayList<>();

        LivetypeList.add("One Way");
        LivetypeList.add("Multiple Way");


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),R.layout.support_simple_spinner_dropdown_item,LivetypeList);
        liveTypeSpinner.setAdapter(adapter);
        liveTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(getContext(), "Sumon", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

    private void LiveStartTime() {

        liveStartTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int hour = calendar.get(Calendar.HOUR_OF_DAY);
                int minute = calendar.get(Calendar.MINUTE);
                TimePickerDialog timePickerDialog;
                timePickerDialog = new TimePickerDialog(getContext(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                        liveStartTime.setText(hourOfDay + ":" + minute);
                    }
                }, hour, minute, true);
                timePickerDialog.setTitle("Choose Time");
                timePickerDialog.show();
                ;
            }
        });

    }
    private void LiveEndTime() {

        liveEndingTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int hour = calendar.get(Calendar.HOUR_OF_DAY);
                int minute = calendar.get(Calendar.MINUTE);
                TimePickerDialog timePickerDialog;
                timePickerDialog = new TimePickerDialog(getContext(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                        liveEndingTime.setText(hourOfDay + ":" + minute);
                    }
                }, hour, minute, true);
                timePickerDialog.setTitle("Choose Time");
                timePickerDialog.show();
                ;
            }
        });

    }

    private void LiveDate() {

        liveDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(),onDateSetListener,year,month,day);
                datePickerDialog.show();
            }
        });
        onDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month+1;
                String date = dayOfMonth +"/"+month+"/"+year;
                liveDate.setText(date);
            }
        };


    }

}
