package com.example.jorch.dialogos;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.icu.util.Calendar;
import android.os.Bundle;

/**
 * Created by JORCH on 31/12/2016.
 */

public class DialogoDatePicker extends DialogFragment {

    public static DialogoDatePicker newInstance() {

        Bundle args = new Bundle();

        DialogoDatePicker fragment = new DialogoDatePicker();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Calendar calendar = Calendar.getInstance();
        int año = calendar.get(Calendar.YEAR);
        int mes = calendar.get(Calendar.MONTH);
        int dia = calendar.get(Calendar.DAY_OF_MONTH);

        return new DatePickerDialog(getActivity(),(DatePickerDialog.OnDateSetListener) getActivity(),año,mes,dia);
    }
}
