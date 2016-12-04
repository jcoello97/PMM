package com.trabajo.jorch.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

public class EstaticoFragment extends Fragment {
    private TextView textViewProgressStatus;
    private ProgressBar progressBar;
    private int progessStatus= 0;

    /*Utilizo un handler para poder utilizar los componentes view (TextView) del hilo principal (EstaticoFragment),
    * en otro hilo.*/
    private Handler handler = new Handler();

    public EstaticoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_estatico,container,false);
        progressBar = (ProgressBar) view.findViewById(R.id.progressBar_FragEst);
        textViewProgressStatus = (TextView) view.findViewById(R.id.tv_FragEst_progessStatus);

        comenzarProgressBar();


        return view;
    }

    private void comenzarProgressBar() {
        progessStatus = 0;
        //CREO UN NUEVO HILO
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (progessStatus<100){
                    progessStatus += 1;
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            progressBar.setProgress(progessStatus);
                            textViewProgressStatus.setText("Estado:"+progessStatus+"%");

                        }
                    });
                    try {
                        Thread.sleep(50);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        }).start();

    }


}
