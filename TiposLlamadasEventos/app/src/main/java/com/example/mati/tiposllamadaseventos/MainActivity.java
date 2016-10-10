package com.example.mati.tiposllamadaseventos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    protected Button button1;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = (Button) findViewById(R.id.button1);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("PRIMER BOTON");
            }
        });


    }

    public void onClickButton2(View v)
    {
        showToast("SEGUNDO BOTON");
    }

    protected void showToast(String texto)
    {
        Toast toast = Toast.makeText(getApplicationContext(),texto,Toast.LENGTH_SHORT);
        toast.show();
    }
}
