package com.example.mati.myapplication;


        import android.app.Activity;
        import android.content.Context;
        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.TextView;
        import android.widget.Toast;


public class HolaMundo1 extends Activity {
    public static int COD_RESPUESTA=0;
    TextView elSaludo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_holamundo1);

        final EditText campoTexto = (EditText) findViewById(R.id.miTxt);
        final Button botonEnviar = (Button) findViewById(R.id.miBtn);
        elSaludo = (TextView) findViewById(R.id.miLbl);

        campoTexto.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                campoTexto.setText("");
            }
        });

        botonEnviar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (campoTexto.getText().toString().isEmpty() | campoTexto.getText().toString().equals("Escribe tu nombre aqui."))
                {
                    mostrarTostadas("Escriba algo por favor.");
                }
                else
                {
                    String mensaje = "Saludos "+campoTexto.getText()+"!!";

                    Intent miIntent = new Intent(HolaMundo1.this,HolaMundo2.class);
                    Bundle miBundle = new Bundle();

                    miBundle.putString("Respuesta",mensaje);

                    miIntent.putExtras(miBundle);

                    startActivityForResult(miIntent,COD_RESPUESTA);

                }
            }

        });
    }

    protected void mostrarTostadas(CharSequence texto)
    {
        Context contexto = getApplicationContext();
        int tiempo = Toast.LENGTH_SHORT;
        Toast toast=Toast.makeText(contexto,texto,tiempo);
        toast.show();
    }
    public void onActivityResult(int cod_resp, int cod_result,Intent intent){
        if (cod_result== RESULT_OK) {
            Bundle otroBundle = intent.getExtras();
            elSaludo.setText(otroBundle.getString("Devuelto"));
        }
    }

    //METODOS

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this,"Iniciando HolaMundo1", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this,"Resumen HolaMundo1", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onPause() {
        Toast.makeText(this,"En pausa HolaMundo1", Toast.LENGTH_SHORT).show();
        super.onPause();
    }
    @Override
    protected void onStop() {
        super.onStop();

        Toast.makeText(this,"Saliendo HolaMundo1", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this,"Volviendo a HolaMundo1", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onDestroy() {
        Toast.makeText(this,"Destruyendo  HolaMundo1", Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }
}
