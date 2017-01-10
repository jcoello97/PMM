package com.trabajo.jorch.tabs;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public class EjemploTabsOnlyIcons extends AppCompatActivity {
    private Toolbar toolbar;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejemplo_tabs_only_icons);

        toolbar = (Toolbar) findViewById(R.id.toolbar_ejemplo5);
        viewPager = (ViewPager) findViewById(R.id.viewpager_ejemplo5);
        tabLayout = (TabLayout) findViewById(R.id.tablayout_ejemplo5);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        AdaptadorViewPagerOnlyIcons adaptadorViewPager = new AdaptadorViewPagerOnlyIcons(getSupportFragmentManager());
        adaptadorViewPager.addFragment(new Fragment1());
        adaptadorViewPager.addFragment(new Fragment2());
        adaptadorViewPager.addFragment(new Fragment3());
        adaptadorViewPager.addFragment(new Fragment4());
        adaptadorViewPager.addFragment(new Fragment5());
        adaptadorViewPager.addFragment(new Fragment6());
        adaptadorViewPager.addFragment(new Fragment7());
        adaptadorViewPager.addFragment(new Fragment8());
        adaptadorViewPager.addFragment(new Fragment9());
        adaptadorViewPager.addFragment(new Fragment10());

        viewPager.setAdapter(adaptadorViewPager);

        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_action_android);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_action_bandera);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_action_bug);
        tabLayout.getTabAt(3).setIcon(R.drawable.ic_action_candado);
        tabLayout.getTabAt(4).setIcon(R.drawable.ic_action_clip);
        tabLayout.getTabAt(5).setIcon(R.drawable.ic_action_contacto);
        tabLayout.getTabAt(6).setIcon(R.drawable.ic_action_escudo);
        tabLayout.getTabAt(7).setIcon(R.drawable.ic_action_notamusical);
        tabLayout.getTabAt(8).setIcon(R.drawable.ic_action_sombrero);
        tabLayout.getTabAt(9).setIcon(R.drawable.ic_action_tarta);

    }
}
