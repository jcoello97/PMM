package com.jorch.proyecto.aulavirtual.ui;

import android.content.Intent;
import android.content.res.Configuration;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.AdapterView;

import com.jorch.proyecto.aulavirtual.R;
import com.jorch.proyecto.aulavirtual.data.AulaVirtualSQLiteHelper;
import com.jorch.proyecto.aulavirtual.ui.fragments.fragment1;
import com.jorch.proyecto.aulavirtual.ui.fragments.fragment2;
import com.jorch.proyecto.aulavirtual.utils.AdapterViewPager;
import com.jorch.proyecto.aulavirtual.utils.SesionPrefs;

public class AulaActivity extends AppCompatActivity {
    private NavigationView navigationViewAula;
    private DrawerLayout drawerLayoutAula;
    private ActionBarDrawerToggle drawerToggleAula;

    private ViewPager viewPagerAula;
    private Toolbar toolbarAula;
    private TabLayout tabLayoutAula;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AulaVirtualSQLiteHelper aulaVirtualSQLiteHelper = new AulaVirtualSQLiteHelper(this);

        if (!SesionPrefs.get(this).isLoggedIn()){
            startActivity(new Intent(this,LoginActivity.class));
            finish();
            return;
        }
        setContentView(R.layout.activity_aula);
        toolbarAula = (Toolbar) findViewById(R.id.toolbar_aula);
        tabLayoutAula = (TabLayout) findViewById(R.id.tab_layout_aula);
        viewPagerAula = (ViewPager) findViewById(R.id.viewpager_aula);
        navigationViewAula = (NavigationView) findViewById(R.id.navigationview_aula);
        drawerLayoutAula = (DrawerLayout) findViewById(R.id.drawer_layout_aula);

        setSupportActionBar(toolbarAula);
        drawerToggleAula = new ActionBarDrawerToggle(this,drawerLayoutAula,toolbarAula,R.string.open_drawer,R.string.close_drawer);
        drawerLayoutAula.addDrawerListener(drawerToggleAula);
        drawerToggleAula.syncState();

        AdapterViewPager adapterViewPager = new AdapterViewPager(getSupportFragmentManager());
        adapterViewPager.addFragmentos(new fragment1(),"CURSOS");
        adapterViewPager.addFragmentos(new fragment1(),"ALUMNOS");
        adapterViewPager.addFragmentos(new fragment2(),"EVENTOS");

        viewPagerAula.setAdapter(adapterViewPager);
        tabLayoutAula.setupWithViewPager(viewPagerAula);

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggleAula.onConfigurationChanged(newConfig);
    }
}
