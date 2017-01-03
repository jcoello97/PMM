package com.example.jorch.ejerciciofragmentodinamico;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by JORCH on 03/01/2017.
 */

public class SimpleFragment extends Fragment {

    int posicionFragment;
    private TextView textView = null;

    public static SimpleFragment newInstance(int position) {

        Bundle args = new Bundle();
        args.putInt("POSITION",position);

        SimpleFragment fragment = new SimpleFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //TODO PROBAR saveInstanceState.getInt();
        posicionFragment = getArguments().getInt("POSITION");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = null;
         //SI ES PAR
        if (posicionFragment % 2 == 0){
            view = inflater.inflate(R.layout.fragment_simple_1,container,false);
            textView = (TextView) view.findViewById(R.id.tv_fragment_1);

        }else {
            view = inflater.inflate(R.layout.fragment_simple_2,container,false);
            textView = (TextView) view.findViewById(R.id.tv_fragment_2);
        }

        textView.setText("FRAGMENTO NUMERO #"+posicionFragment);

        return view;
    }
}
