package com.example.soundtest.Question;

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

import com.example.soundtest.R;

public class MyDialogFragment extends AppCompatDialogFragment {

    private EditText editTestEntryKey;
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_dialog,null);
        editTestEntryKey = view.findViewById(R.id.passwordET);
        builder.setView(view)
                .setTitle("Entry Key")
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                String entryKey = editTestEntryKey.getText().toString();

                if (entryKey.equals("obaidullah")){

                    startActivity(new Intent(getContext(), ScholarsAnswerActivity.class));
                }
                if (entryKey.equals("shofikullah")){
                    startActivity(new Intent(getContext(),ScholarsAnswerActivity.class));

                }
                if (entryKey.equals("jakaria")){

                    startActivity(new Intent(getContext(),ScholarsAnswerActivity.class));
                }
                if (entryKey.equals("muhibbullah")){

                    startActivity(new Intent(getContext(), ScholarsAnswerActivity.class));
                }
                if (entryKey.equals("sakhawat")){
                    startActivity(new Intent(getContext(),ScholarsAnswerActivity.class));

                }
                if (entryKey.equals("obaydullah")){

                    startActivity(new Intent(getContext(),ScholarsAnswerActivity.class));
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
