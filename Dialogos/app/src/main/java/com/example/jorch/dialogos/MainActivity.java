package com.example.jorch.dialogos;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListaDialogosFragment listaDialogosFragment = (ListaDialogosFragment) getFragmentManager().findFragmentById(R.id.main_container);

        if (listaDialogosFragment == null){
            listaDialogosFragment = ListaDialogosFragment.newInstance();
            getFragmentManager().beginTransaction().add(R.id.main_container,listaDialogosFragment).commit();
        }
    }
}
