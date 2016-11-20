package com.trabajo.jorch.animacionesbasicas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity{

    private Button buttonRotate, buttonAlpha,buttonTranslate, buttonScale;
    private ImageView imageViewMundo;
    private Animation animation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageViewMundo = (ImageView) findViewById(R.id.imageViewMundo);

        buttonRotate = (Button) findViewById(R.id.buttonRotate);
        buttonAlpha = (Button) findViewById(R.id.buttonAlpha);
        buttonScale = (Button) findViewById(R.id.buttonScale);
        buttonTranslate = (Button) findViewById(R.id.buttonTranslate);

        buttonRotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animation = AnimationUtils.loadAnimation(getBaseContext(),R.anim.rotate);
                imageViewMundo.startAnimation(animation);
            }
        });
        buttonAlpha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animation = AnimationUtils.loadAnimation(getBaseContext(),R.anim.alpha);
                imageViewMundo.startAnimation(animation);
            }
        });
        buttonScale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animation = AnimationUtils.loadAnimation(getBaseContext(),R.anim.scale);
                imageViewMundo.startAnimation(animation);
            }
        });
        buttonTranslate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animation = AnimationUtils.loadAnimation(getBaseContext(),R.anim.translate);
                imageViewMundo.startAnimation(animation);
            }
        });
    }
}
