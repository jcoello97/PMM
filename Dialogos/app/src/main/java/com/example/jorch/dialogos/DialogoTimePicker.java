package com.example.jorch.dialogos;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.support.design.widget.BottomSheetDialog;

/**
 * Created by JORCH on 31/12/2016.
 */

public class DialogoTimePicker extends DialogFragment {
    public static DialogoTimePicker newInstance() {

        Bundle args = new Bundle();

        DialogoTimePicker fragment = new DialogoTimePicker();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Calendar calendar =Calendar.getInstance();
        int hora = calendar.get(Calendar.HOUR_OF_DAY);
        int minutos = calendar.get(Calendar.MINUTE);
        int segundos = calendar.get(Calendar.SECOND);
        return new TimePickerDialog(getContext(),(TimePickerDialog.OnTimeSetListener) getActivity(),hora,minutos,true);
    }

}
