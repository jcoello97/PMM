package com.example.jorch.ejerciciofragmentodinamico;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements MyDialogFragment.OnMyDialogFragmentListener{
    private Button buttonNuevoFragment, buttonDialogo, buttonDialogoFragment;
    int posicion = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonNuevoFragment = (Button) findViewById(R.id.bttn_añadir_nuevo_fragment);
        buttonNuevoFragment.setOnClickListener(new View.OnClickListener() {
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

        buttonDialogo = (Button) findViewById(R.id.bttn_mostrar_dialogo_normal);
        buttonDialogoFragment = (Button) findViewById(R.id.bttn_mostrar_dialogo_fragment);

        buttonDialogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialogo().show();
            }
        });
        buttonDialogoFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialogFragment();
            }
        });
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

    private AlertDialog showDialogo() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Selecciona una accion a realizar")
                .setPositiveButton("Nuevo", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        addFragment();
                    }
                })
                .setNeutralButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                })
                .setNeutralButton("Atras", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        getFragmentManager().popBackStack();
                    }
                });
        return builder.create();
    }
    private void showDialogFragment(){
        MyDialogFragment dialogFragment = MyDialogFragment.newInstance("CADENA");
        dialogFragment.show(getFragmentManager(),"DIALOGO");
    }

    @Override
    public void buttonNuevo() {
        addFragment();
    }
}
