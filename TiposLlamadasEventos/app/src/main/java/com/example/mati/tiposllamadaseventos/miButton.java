package com.example.mati.tiposllamadaseventos;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by jorch on 10/10/16.
 */
public class miButton extends Button implements View.OnClickListener
{

    public miButton(Context context) {
        super(context);
        this.setOnClickListener(this);
    }

    public miButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setOnClickListener(this);
    }

    public miButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        Toast.makeText(getContext(),"TERCER BOTON",Toast.LENGTH_SHORT).show();
    }
}
