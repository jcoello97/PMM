package com.example.jorch.ejerciciofragmentodinamico;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by JORCH on 03/01/2017.
 */

public class MyDialogFragment extends DialogFragment {

    private Button buttonNuevo, buttonCancelar, buttonAtras;
    private OnMyDialogFragmentListener listener;

    public static MyDialogFragment newInstance(String nombre) {

        Bundle args = new Bundle();
        args.putString("NOMBRE",nombre);
        MyDialogFragment fragment = new MyDialogFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public interface OnMyDialogFragmentListener{
        void buttonNuevo();
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        LayoutInflater inflater = getActivity().getLayoutInflater();

        View view = inflater.inflate(R.layout.dialogo_frament,null);
        builder.setView(view);

        buttonNuevo = (Button) view.findViewById(R.id.bttn_new_fragment);
        buttonAtras = (Button) view.findViewById(R.id.bttn_back_fragment);
        buttonCancelar = (Button) view.findViewById(R.id.bttn_cancel_fragment);

        buttonNuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.buttonNuevo();
            }
        });
        buttonAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().popBackStack();
            }
        });
        buttonCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        return builder.create();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            listener = (OnMyDialogFragmentListener) activity;
        }catch (ClassCastException e){
            e.printStackTrace();
        }
    }
}
