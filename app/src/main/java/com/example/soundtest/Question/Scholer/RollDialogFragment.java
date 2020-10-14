package com.example.soundtest.Question.Scholer;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.example.soundtest.Question.CourseVideoActivity;
import com.example.soundtest.R;

public class RollDialogFragment extends AppCompatDialogFragment {

    private EditText editTextEntryKey;
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_roll_dialog,null);
        editTextEntryKey = view.findViewById(R.id.rollET);
        builder.setView(view)
                .setTitle("Please Enter Your Roll Number")
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                String entryKey = editTextEntryKey.getText().toString();

                if (entryKey.equals("123456")){

                    startActivity(new Intent(getContext(), CourseVideoActivity.class));
                }


            }
        });



        return builder.create();

    }

    @Override
    public void onAttach(@NonNull Context context) {

        super.onAttach(context);

        try {

        }catch (ClassCastException e){

            throw new ClassCastException(context.toString()+"Must Implement Example Dialog");
        }

    }


}
