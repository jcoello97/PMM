package com.trabajo.jorch.navigationview;

import android.content.res.Configuration;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class NavigationEjemplo1 extends AppCompatActivity {

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    private ActionBarDrawerToggle actionBarDrawerToggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_ejemplo1);

        toolbar = (Toolbar) findViewById(R.id.toolbarEjemplo1);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayoutEjemplo1);
        navigationView = (NavigationView) findViewById(R.id.navigationEjemplo1);

        setSupportActionBar(toolbar); //ASIGNAMOS NUESTRO TOOLBAR PROPIO
        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.draweropen,R.string.drawerclose);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.drawermenu_item1_Ejemplo1:
                        Snackbar.make(drawerLayout,"ANDROID",Snackbar.LENGTH_SHORT).show();
                        break;
                    case R.id.drawermenu_item2_Ejemplo1:
                        Snackbar.make(drawerLayout,"BUG",Snackbar.LENGTH_SHORT).show();
                        break;
                    case R.id.drawermenu_item3_Ejemplo1:
                        Snackbar.make(drawerLayout,"CANDADO",Snackbar.LENGTH_SHORT).show();
                        break;
                    case R.id.drawermenu_item4_Ejemplo1:
                        Snackbar.make(drawerLayout,"CLIP",Snackbar.LENGTH_SHORT).show();
                        break;
                    case R.id.drawermenu_item5_Ejemplo1:
                        Snackbar.make(drawerLayout,"CONTACTO",Snackbar.LENGTH_SHORT).show();
                        break;
                    case R.id.drawermenu_item6_Ejemplo1:
                        Snackbar.make(drawerLayout,"CORAZON",Snackbar.LENGTH_SHORT).show();
                        break;
                    case R.id.drawermenu_item7_Ejemplo1:
                        Snackbar.make(drawerLayout,"ESCUDO",Snackbar.LENGTH_SHORT).show();
                        break;
                    case R.id.drawermenu_item8_Ejemplo1:
                        Snackbar.make(drawerLayout,"SOMBRERO",Snackbar.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        actionBarDrawerToggle.onConfigurationChanged(newConfig);
    }
}
