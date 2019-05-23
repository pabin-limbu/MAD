package com.example.mvvmdemo;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.View;
import android.widget.TextView;

public class NoteDialog extends AppCompatDialogFragment {

    TextView text_title;
    TextView text_description;
    TextView text_date;
    TextView text_time;
    TextView text_priority;


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        View view = getActivity().getLayoutInflater().inflate(R.layout.note_dalog, null);

        text_title = (TextView) view.findViewById(R.id.txtTitle);
        text_description = view.findViewById(R.id.txtDescription);
        text_date = view.findViewById(R.id.txtDate);
        text_time = view.findViewById(R.id.txtTime);
        text_priority = view.findViewById(R.id.txtPriority);


        text_title.setText(getArguments().getString(MainActivity.EXTRA_TITLEs));
        text_description.setText(getArguments().getString(MainActivity.EXTRA_DESCRIPTIONs));
        text_priority.setText(Integer.toString(getArguments().getInt(MainActivity.EXTRA_PRIORITYs)));
        text_time.setText(getArguments().getString(MainActivity.EXTRA_TIMEs));
        text_date.setText(getArguments().getString(MainActivity.EXTRA_DATEs));

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(view)
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });


        return builder.create();

    }
}
