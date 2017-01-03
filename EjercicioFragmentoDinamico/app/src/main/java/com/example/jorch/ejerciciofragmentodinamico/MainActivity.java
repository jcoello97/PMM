package com.example.jorch.ejerciciofragmentodinamico;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button button;
    int posicion = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.bttn_añadir_nuevo_fragment);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addFragment();
            }
        });

        if (savedInstanceState == null){
            SimpleFragment  fragment = SimpleFragment.newInstance(posicion);
            getFragmentManager().beginTransaction().add(R.id.container_fragment,fragment).commit();
        }else {
            posicion = savedInstanceState.getInt("POSITION");
        }
    }

    private void addFragment() {
        posicion++;
        SimpleFragment newFragment = SimpleFragment.newInstance(posicion);
        android.app.FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.container_fragment, newFragment);
        transaction.setTransition(android.app.FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        transaction.addToBackStack(null);
        transaction.commit();

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("POSITION",posicion);
    }
}
