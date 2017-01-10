package com.trabajo.jorch.tabs;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class EjemploTabsIconsAndText extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    private int[] tabIcons = new int[]
            {
                    R.drawable.ic_action_android,
                    R.drawable.ic_action_bandera,
                    R.drawable.ic_action_bug,
                    R.drawable.ic_action_candado,
                    R.drawable.ic_action_contacto,
                    R.drawable.ic_action_corazon,
                    R.drawable.ic_action_escudo,
                    R.drawable.ic_action_notamusical,
                    R.drawable.ic_action_sombrero,
                    R.drawable.ic_action_tarta
            };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejemplo_tabs_icons_and_text);

        toolbar = (Toolbar) findViewById(R.id.toolbar_ejemplo4);
        viewPager = (ViewPager) findViewById(R.id.viewpager_ejemplo4);
        tabLayout = (TabLayout) findViewById(R.id.tablayout_ejemplo4);

        //COLOCAMOS NUESTRO PROPIA TOOLBAR
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //INSERTAMOS LOS FRAGMENTS DE LAS TABAS EN EL ADAPTADOR
        AdaptadorViewPager adaptadorViewPager = new AdaptadorViewPager(getSupportFragmentManager());
        adaptadorViewPager.addFragment(new Fragment1(),"UNO");
        adaptadorViewPager.addFragment(new Fragment2(),"DOS");
        adaptadorViewPager.addFragment(new Fragment3(),"TRES");
        adaptadorViewPager.addFragment(new Fragment4(),"CUATRO");

        //VINCULAMOS EL ADAPTADOR CON EL VIEWPAGER
        viewPager.setAdapter(adaptadorViewPager);

        //LE INDICAMOS AL TABLAYOUT EL VIEWPAGER CON EL ADAPTADOR
        tabLayout.setupWithViewPager(viewPager);

        //COLOCAMOS LOS ICONOS EN CADA TAB SEGUN LA POSICION
        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
        tabLayout.getTabAt(2).setIcon(tabIcons[2]);
        tabLayout.getTabAt(3).setIcon(tabIcons[3]);
    }
}
