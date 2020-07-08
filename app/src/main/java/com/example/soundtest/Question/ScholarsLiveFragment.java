package com.example.soundtest.Question;


import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 */
public class ScholarsLiveFragment extends Fragment {

    private TextView liveDate,liveTime;
    private EditText liveTitle,liveScholarName,scholarTitle,liveSubject;
    private Spinner liveTypeSpinner;
    private Button confirmLiveBttn;
    DatePickerDialog.OnDateSetListener onDateSetListener;
    public DatabaseReference RootRef;

    public ScholarsLiveFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_scholars_live, container, false);

        RootRef= FirebaseDatabase.getInstance().getReference("Live");
        liveDate = view.findViewById(R.id.liveDate);
        liveTime = view.findViewById(R.id.liveTime);
        liveTitle = view.findViewById(R.id.liveTitle);
        liveScholarName = view.findViewById(R.id.liveScholarsName);
        scholarTitle = view.findViewById(R.id.scholarsTitle);
        liveSubject = view.findViewById(R.id.liveSubject);
        liveTypeSpinner = view.findViewById(R.id.typeSpinner);
        confirmLiveBttn = view.findViewById(R.id.confirmLiveButtn);

        TypeSpinner();
        LiveTime();
        LiveDate();

        confirmLiveBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String setLiveTitle = liveTitle.getText().toString();
                String setLiveScholarsName = liveScholarName.getText().toString();
                String setScholarTitle = scholarTitle.getText().toString();
                String setLiveType = liveTypeSpinner.getSelectedItem().toString();
                String setLiveTime = liveTime.getText().toString();
                String setLiveDate = liveDate.getText().toString();
                String setLiveSubject = liveSubject.getText().toString();



                if (TextUtils.isEmpty(setLiveTitle)) {

                    Toast.makeText(getContext(), "Please Write Live Title First...", Toast.LENGTH_SHORT).show();
                }

                if (TextUtils.isEmpty(setLiveScholarsName)) {

                    Toast.makeText(getContext(), "Please Write your Name First...", Toast.LENGTH_SHORT).show();
                }
                else {


                    String key = RootRef.push().getKey();
                    ScholarsLiveClass scholarsLiveClass = new ScholarsLiveClass(setLiveTitle,setLiveScholarsName,setScholarTitle,setLiveType,setLiveTime,setLiveDate,setLiveSubject);
                    RootRef.child(key).setValue(scholarsLiveClass);

                    Toast.makeText(getContext(), "Your Live Session Created..", Toast.LENGTH_SHORT).show();

                }

            }
        });


        return view;
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

    private void LiveTime() {

        liveTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int hour = calendar.get(Calendar.HOUR_OF_DAY);
                int minute = calendar.get(Calendar.MINUTE);
                TimePickerDialog timePickerDialog;
                timePickerDialog = new TimePickerDialog(getContext(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                        liveTime.setText(hourOfDay + ":" + minute);
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
