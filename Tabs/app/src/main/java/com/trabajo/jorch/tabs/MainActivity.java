package com.trabajo.jorch.tabs;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button bttnEjemploFixedTabs, bttnEjemploCenterAlignTabs, bttnEjemploScrollableTabs, bttnEjemploTabsIconsText, bttnEjemploTabsOnlyIcons;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bttnEjemploFixedTabs = (Button) findViewById(R.id.bttn_fixedtabs);
        bttnEjemploCenterAlignTabs = (Button) findViewById(R.id.bttn_centeralignedtabs);
        bttnEjemploScrollableTabs = (Button) findViewById(R.id.bttn_scrollabletabs);
        bttnEjemploTabsIconsText = (Button) findViewById(R.id.bttn_tabsiconstext);
        bttnEjemploTabsOnlyIcons = (Button) findViewById(R.id.bttn_tabsonlyicons);

        bttnEjemploFixedTabs.setOnClickListener(this);
        bttnEjemploCenterAlignTabs.setOnClickListener(this);
        bttnEjemploScrollableTabs.setOnClickListener(this);
        bttnEjemploTabsIconsText.setOnClickListener(this);
        bttnEjemploTabsOnlyIcons.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bttn_fixedtabs:
                Intent mIntent1 = new Intent(MainActivity.this,EjemploFixedTabs.class);
                startActivity(mIntent1);
                break;
            case R.id.bttn_centeralignedtabs:
                Intent mIntent2 = new Intent(MainActivity.this,EjemploCenterAlignedTabs.class);
                startActivity(mIntent2);
                break;
            case R.id.bttn_scrollabletabs:
                Intent mIntent3 =  new Intent(MainActivity.this,EjemploScrollableTabs.class);
                startActivity(mIntent3);
                break;
            case R.id.bttn_tabsiconstext:
                Intent mIntent4 = new Intent(MainActivity.this,EjemploTabsIconsAndText.class);
                startActivity(mIntent4);
                break;
            case R.id.bttn_tabsonlyicons:
                Intent mIntent5 = new Intent(MainActivity.this,EjemploTabsOnlyIcons.class);
                startActivity(mIntent5);
                break;
        }
    }
}
