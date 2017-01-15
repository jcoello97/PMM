package com.jorch.proyecto.sharepreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button;
    EditText editText;
    TextView textView;
    CheckBox checkBox;

    SharedPreferences preferences;
    String valorEditText;
    boolean valorCheckBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        preferences = getSharedPreferences("PREF", Context.MODE_PRIVATE);

        button = (Button) findViewById(R.id.bttn_enviar);
        editText = (EditText) findViewById(R.id.et_campo);
        textView = (TextView) findViewById(R.id.tv_title);
        checkBox = (CheckBox) findViewById(R.id.checkBoxPrueba);

        //BUSCO SI HAY ALGUNA PREFERENCIA GUARDADA OSINO PONGO LOS VALORES POR DEFECTO
        checkBox.setSelected(preferences.getBoolean("VALOR_BOOLEAN",false));
        editText.setText(preferences.getString("VALOR_TEXT","Nombre defecto"));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //GUARDO VALORES DE PREFERENCIAS
                valorEditText = editText.getText().toString();
                valorCheckBox = checkBox.isChecked();
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("VALOR_TEXT",valorEditText);
                editor.putBoolean("VALOR_BOOLEAN",valorCheckBox);
                editor.apply();
                Toast.makeText(getApplicationContext(),"funciona",Toast.LENGTH_LONG).show();
            }
        });

    }
}
