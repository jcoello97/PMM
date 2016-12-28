package com.example.jorch.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //INICIALIZAMOS ALGUNOS PRESIDENTES
        List<Presidente> presidentes = new ArrayList<>();
        presidentes.add(new Presidente("François Hollande","FRANCIA",R.drawable.presidentefrancia));
        presidentes.add(new Presidente("Xi Jinping","CHINA",R.drawable.presidentechina));
        presidentes.add(new Presidente("Juan Manual Santos","COLOMBIA",R.drawable.presidentecolombia));
        presidentes.add(new Presidente("Rafael Correa","ECUADOR",R.drawable.presidenteecuador));
        presidentes.add(new Presidente("Rodrigo Duterte","FILIPINAS",R.drawable.presidentefilipinas));
        presidentes.add(new Presidente("Enrique Peña Nieto","MEXICO",R.drawable.presidentemexico));
        presidentes.add(new Presidente("Vladimir Putin","RUSIA",R.drawable.presidenterusia));
        presidentes.add(new Presidente("Recep Tyyip Erdogan","TURQUIA",R.drawable.presidenteturquia));
        presidentes.add(new Presidente("Nicolas Maduro","VENEZUELA",R.drawable.presidentevenezuela));
        presidentes.add(new Presidente("Barack Obama","ESTADOS UNIDOS DE AMERICA",R.drawable.presidienteestadosunidos));


        recyclerView = (RecyclerView) findViewById(R.id.rv_presidentes);
        adapter = new PresidenteAdapter(presidentes);
        layoutManager = new LinearLayoutManager(this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);

    }
}
