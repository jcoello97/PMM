package com.trabajo.jorch.tabs;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class EjemploScrollableTabs extends AppCompatActivity {
    private Toolbar toolbar;
    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejemplo_scrollable_tabs);

        toolbar = (Toolbar) findViewById(R.id.toolbar_ejemplo3);
        viewPager = (ViewPager) findViewById(R.id.viewpager_ejemplo3);
        tabLayout = (TabLayout) findViewById(R.id.tablayout_ejemplo3);

        //COLOCAMOS NUESTRO PROPIA TOOLBAR
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //INSERTAMOS LOS FRAGMENTS DE LAS TABAS EN EL ADAPTADOR
        AdaptadorViewPager adaptadorViewPager = new AdaptadorViewPager(getSupportFragmentManager());
        adaptadorViewPager.addFragment(new Fragment1(),"UNO");
        adaptadorViewPager.addFragment(new Fragment2(),"DOS");
        adaptadorViewPager.addFragment(new Fragment3(),"TRES");
        adaptadorViewPager.addFragment(new Fragment4(),"CUATRO");
        adaptadorViewPager.addFragment(new Fragment5(),"CINCO");
        adaptadorViewPager.addFragment(new Fragment6(),"SEIS");
        adaptadorViewPager.addFragment(new Fragment7(),"SIETE");
        adaptadorViewPager.addFragment(new Fragment8(),"OCHO");
        adaptadorViewPager.addFragment(new Fragment9(),"NUEVE");
        adaptadorViewPager.addFragment(new Fragment10(),"DIEZ");

        //VINCULAMOS EL ADAPTADOR CON EL VIEWPAGER
        viewPager.setAdapter(adaptadorViewPager);

        //LE INDICAMOS AL TABLAYOUT EL VIEWPAGER CON EL ADAPTADOR
        tabLayout.setupWithViewPager(viewPager);
    }
}
