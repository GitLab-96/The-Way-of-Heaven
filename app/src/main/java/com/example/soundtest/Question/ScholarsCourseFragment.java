package com.example.soundtest.Question;


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
public class ScholarsCourseFragment extends Fragment {

    private TextView courseDate,courseTime;
    private EditText courseTitle,courseScholarName,scholarTitle,courseSubject;
    private Spinner courseTypeSpinner;
    private Button confirmcourseBttn;
    private FloatingActionButton courseSessionAddBttn;
    DatePickerDialog.OnDateSetListener onDateSetListener;
    public DatabaseReference RootRef;


    DatabaseReference reference;
    RecyclerView recyclerView;
    ArrayList<ScholersCourseClass> course_list;
    CourseScholerAdapter adapter;
    public ScholarsCourseFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_scholars_course, container, false);

        RootRef= FirebaseDatabase.getInstance().getReference("Course");
        courseSessionAddBttn = view.findViewById(R.id.add_course_session);

        recyclerView = view.findViewById(R.id.scholersCourseRecylerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        course_list = new ArrayList<ScholersCourseClass>();

        reference = FirebaseDatabase.getInstance().getReference().child("Course");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1:dataSnapshot.getChildren()){

                    ScholersCourseClass p = dataSnapshot1.getValue(ScholersCourseClass.class);
                    course_list.add(p);
                }
                adapter = new CourseScholerAdapter(getContext(),course_list);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Toast.makeText(getContext(), "Opps......", Toast.LENGTH_SHORT).show();
            }





        });


        AddLiveSession();


        return view;
    }
    private void AddLiveSession() {


        courseSessionAddBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder mBuilder = new AlertDialog.Builder(getContext());
                View mView = getLayoutInflater().inflate(R.layout.live_session_add,null);

                courseDate = mView.findViewById(R.id.liveDate);
                courseTime = mView.findViewById(R.id.liveTime);
                courseTitle = mView.findViewById(R.id.liveTitle);
                courseScholarName = mView.findViewById(R.id.liveScholarsName);
                scholarTitle = mView.findViewById(R.id.scholarsTitle);
                courseSubject = mView.findViewById(R.id.liveSubject);
                courseTypeSpinner = mView.findViewById(R.id.typeSpinner);
                confirmcourseBttn = mView.findViewById(R.id.confirmLiveButtn);

                TypeSpinner();
                LiveTime();
                LiveDate();



                mBuilder.setView(mView);
                final AlertDialog dialog = mBuilder.create();
                dialog.show();

                confirmcourseBttn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        String setCourseTitle = courseTitle.getText().toString();
                        String setCourseScholarsName = courseScholarName.getText().toString();
                        String setScholarTitle = scholarTitle.getText().toString();
                        String setCourseType = courseTypeSpinner.getSelectedItem().toString();
                        String setCourseTime = courseTime.getText().toString();
                        String setCourseDate = courseDate.getText().toString();
                        String setCourseSubject = courseSubject.getText().toString();



                        if (TextUtils.isEmpty(setCourseTitle)) {

                            Toast.makeText(getContext(), "Please Write Live Title First...", Toast.LENGTH_SHORT).show();
                        }

                        if (TextUtils.isEmpty(setCourseScholarsName)) {

                            Toast.makeText(getContext(), "Please Write your Name First...", Toast.LENGTH_SHORT).show();
                        }
                        else {


                            String key = RootRef.push().getKey();
                            ScholersCourseClass scholersCourseClass = new ScholersCourseClass(setCourseTitle,setCourseScholarsName,setScholarTitle,setCourseType,setCourseTime,setCourseDate,setCourseSubject);
                            RootRef.child(key).setValue(scholersCourseClass);

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
        courseTypeSpinner.setAdapter(adapter);
        courseTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(getContext(), "Sumon", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

    private void LiveTime() {

        courseTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int hour = calendar.get(Calendar.HOUR_OF_DAY);
                int minute = calendar.get(Calendar.MINUTE);
                TimePickerDialog timePickerDialog;
                timePickerDialog = new TimePickerDialog(getContext(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                        courseTime.setText(hourOfDay + ":" + minute);
                    }
                }, hour, minute, true);
                timePickerDialog.setTitle("Choose Time");
                timePickerDialog.show();
                ;
            }
        });

    }

    private void LiveDate() {

        courseDate.setOnClickListener(new View.OnClickListener() {
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
                courseDate.setText(date);
            }
        };


    }

}
