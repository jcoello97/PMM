package com.trabajo.jorch.navigationview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button buttonEjemplo1, buttonEjemplo2;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonEjemplo1 = (Button) findViewById(R.id.buttonEjemplo1);
        buttonEjemplo2 = (Button) findViewById(R.id.buttonEjemplo2);

        buttonEjemplo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 intent = new Intent(MainActivity.this,NavigationEjemplo1.class);
                startActivity(intent);
            }
        });

        buttonEjemplo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MainActivity.this,NavigationEjemplo2.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_principal,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.itemAcercaDe:
                DialogoAcercaDe dialogo = new DialogoAcercaDe();
                dialogo.show(getSupportFragmentManager(),"acercade");
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }
}
