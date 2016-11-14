package com.example.mati.ejerlayout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    protected Button btnEjer1,btnEjer2,btnEjer3,btnEjer4;
    protected Intent miIntento = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        menu ();
    }

    public void menu()
    {
        btnEjer1 = (Button) findViewById(R.id.btn1);

        btnEjer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                miIntento = new Intent(MainActivity.this,LayoutEjercicio1.class);
                startActivity(miIntento);
            }
        });

        btnEjer2 = (Button) findViewById(R.id.btn2);
        btnEjer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                miIntento = new Intent(MainActivity.this,LayoutEjercicio2.class);
                startActivity(miIntento);
            }
        });
    }
}
