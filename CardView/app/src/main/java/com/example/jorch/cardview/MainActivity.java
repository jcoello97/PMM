package com.example.jorch.cardview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private CardView cardViewElevation, cardViewCornerRadius, cardViewCompleto;
    private SeekBar seekBarElevation, seekBarCornerRadius, sbElevation, sbCornerRadius;
    private TextView textViewValorElevation, textViewValorCornerRadius, tvValorElevation,tvValorCornerRadius;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cardViewElevation = (CardView) findViewById(R.id.cardview_elevation);
        cardViewCornerRadius = (CardView) findViewById(R.id.cardview_cornerradius);
        cardViewCompleto = (CardView) findViewById(R.id.cardview_completo);

        seekBarElevation = (SeekBar) findViewById(R.id.sb_cardelevation);
        seekBarCornerRadius = (SeekBar) findViewById(R.id.sb_cardcornerradius);
        sbElevation = (SeekBar) findViewById(R.id.sb_completo_cardelevation);
        sbCornerRadius = (SeekBar) findViewById(R.id.sb_completo_cardcornerradius);

        textViewValorElevation = (TextView) findViewById(R.id.tv_sb_cardelevation_valor);
        textViewValorCornerRadius = (TextView) findViewById(R.id.tv_sb_cardcornerraidus_valor);
        tvValorElevation = (TextView) findViewById(R.id.tv_sb_completo_cardelevation_valor);
        tvValorCornerRadius = (TextView) findViewById(R.id.tv_sb_completo_cardcornerraidus_valor);

        seekBarElevation.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                cardViewElevation.setCardElevation(progress);
                textViewValorElevation.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekBarCornerRadius.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                cardViewCornerRadius.setRadius(progress);
                textViewValorCornerRadius.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //CARD VIEW COMPLETO
        sbElevation.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                cardViewCompleto.setCardElevation(progress);
                tvValorElevation.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        sbCornerRadius.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                cardViewCompleto.setRadius(progress);
                tvValorCornerRadius.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
