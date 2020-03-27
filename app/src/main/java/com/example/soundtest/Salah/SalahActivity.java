package com.example.soundtest.Salah;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.soundtest.R;
import com.example.soundtest.Salah.BoysFragment;
import com.example.soundtest.Salah.GirlsFragment;

public class SalahActivity extends AppCompatActivity {
    String[] mode;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salah);

        init();
        ModeSelection();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,mode);
        spinner.setAdapter(adapter);
   }

   private void init() {
        mode = getResources().getStringArray(R.array.mode);
        spinner = findViewById(R.id.speener);
    }

    private void ModeSelection() {
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if(position==0){
                    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.framLayout,new BoysFragment());
                    ft.commit();



                }
                else if(position==1){
                    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.framLayout,new GirlsFragment());
                    ft.commit();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }


}
