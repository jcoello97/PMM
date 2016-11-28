package com.trabajo.jorch.probandonavigationview;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

/**
 * Created by Jorch on 27/11/2016.
 */

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    ActionBarDrawerToggle actionBarDrawerToggle;
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.navigation);
        setSupportActionBar(toolbar);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.drawer_menu_item1:
                        Snackbar.make(drawerLayout,"ANDROID",Snackbar.LENGTH_SHORT).show();
                        break;
                    case R.id.drawer_menu_item2:
                        Snackbar.make(drawerLayout,"BUG",Snackbar.LENGTH_SHORT).show();
                        break;
                    case R.id.drawer_menu_item3:
                        Snackbar.make(drawerLayout,"CANDADO",Snackbar.LENGTH_SHORT).show();
                        break;
                    case R.id.drawer_menu_item4:
                        Snackbar.make(drawerLayout,"CLIP",Snackbar.LENGTH_SHORT).show();
                        break;
                    case R.id.drawer_menu_item5:
                        Snackbar.make(drawerLayout,"CONTACTO",Snackbar.LENGTH_SHORT).show();
                        break;
                    case R.id.drawer_menu_item6:
                        Snackbar.make(drawerLayout,"CORAZON",Snackbar.LENGTH_SHORT).show();
                        break;
                    case R.id.drawer_menu_item7:
                        Snackbar.make(drawerLayout,"ESCUDO",Snackbar.LENGTH_SHORT).show();
                        break;
                    case R.id.drawer_menu_item8:
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
