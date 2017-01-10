package com.trabajo.jorch.tabs;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public class EjemploFixedTabs extends AppCompatActivity {
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejemplo_fixed_tabs);

        toolbar = (Toolbar) findViewById(R.id.toolbar_ejemplo1);
        viewPager = (ViewPager) findViewById(R.id.viewpager_ejemplo1);
        tabLayout = (TabLayout) findViewById(R.id.tablayout_ejemplo1);

        //COLOCAMOS NUESTRO PROPIA TOOLBAR
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //INSERTAMOS LOS FRAGMENTS DE LAS TABAS EN EL ADAPTADOR
        AdaptadorViewPager adaptadorViewPager = new AdaptadorViewPager(getSupportFragmentManager());
        adaptadorViewPager.addFragment(new Fragment1(),"UNO");
        adaptadorViewPager.addFragment(new Fragment2(),"DOS");
        adaptadorViewPager.addFragment(new Fragment3(),"TRES");

        //VINCULAMOS EL ADAPTADOR CON EL VIEWPAGER
        viewPager.setAdapter(adaptadorViewPager);

        //LE INDICAMOS AL TABLAYOUT EL VIEWPAGER CON EL ADAPTADOR
        tabLayout.setupWithViewPager(viewPager);
    }
}
