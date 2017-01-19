package com.jorch.proyecto.aulavirtual.ui;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import com.jorch.proyecto.aulavirtual.R;
import com.jorch.proyecto.aulavirtual.data.Curso;
import com.jorch.proyecto.aulavirtual.data.Profesor;
import com.jorch.proyecto.aulavirtual.data.ProfesorCursoDao;
import com.jorch.proyecto.aulavirtual.utils.AdapterSpinnerImagenes;

import java.util.ArrayList;
import java.util.List;

public class CrearCursosActivity extends AppCompatActivity{
    public static final String CURSO_CREADO = "CURSO_CREADO";
    private Profesor profesor;
    private EditText editTextNombreCurso, editTextDescripcion;
    private Spinner spinnerImagenCurso;
    private List<Integer> list = new ArrayList<Integer>(){};
    private String nombre, descripcion;
    private int imagen;
    private Bundle bundle;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_cursos);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("CREAR NUEVO CURSO");
        intent = getIntent();
        bundle = intent.getExtras();
        profesor = (Profesor) bundle.getSerializable(AulaActivity.PROFESOR_LOGEADO);
        profesor = (Profesor) getIntent().getExtras().getSerializable(AulaActivity.PROFESOR_LOGEADO);
        llenarLista();
        editTextNombreCurso = (EditText) findViewById(R.id.et_crear_curso_nombre);
        editTextDescripcion = (EditText) findViewById(R.id.et_crear_curso_descripcion);
        spinnerImagenCurso = (Spinner) findViewById(R.id.spinner_imagen_curso);

        spinnerImagenCurso.setAdapter(new AdapterSpinnerImagenes(this,list));
        spinnerImagenCurso.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                imagen = list.get(position);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_crear_cursos,menu);
        return true;
    }

    @Override
    public boolean onNavigateUp() {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case android.R.id.home:
                onBackPressed();
                break;
            case R.id.menu_crear_curso_item_guardar:
                boolean error = false;
                nombre = editTextNombreCurso.getText().toString();
                descripcion = editTextDescripcion.getText().toString();
                if (TextUtils.isEmpty(nombre)) {
                    error = true;
                    editTextNombreCurso.setError("Falta el nombre del curso");
                }
                if (TextUtils.isEmpty(descripcion)) {
                    error = true;
                    editTextDescripcion.setError("Falta la descripcion del curso");
                }
                if (error) {
                    return false;
                }
                Curso curso = new Curso(nombre, descripcion, imagen);
                ProfesorCursoDao.createInstance(getApplicationContext()).insertarCurso(curso, profesor.getId());
                bundle.putSerializable(CURSO_CREADO,curso);
                intent.putExtras(bundle);
                setResult(RESULT_OK,intent);
                finish();
                break;
        }
        return true;
    }

    public void llenarLista(){
        list.add(R.drawable.header_amarillo);
        list.add(R.drawable.header_amarillo_oscuro);
        list.add(R.drawable.header_azul);
        list.add(R.drawable.header_celeste);
        list.add(R.drawable.header_marron);
        list.add(R.drawable.header_marron_oscuro);
        list.add(R.drawable.header_morado);
        list.add(R.drawable.header_naranja);
        list.add(R.drawable.header_negro);
        list.add(R.drawable.header_rojo);
        list.add(R.drawable.header_rosa);
        list.add(R.drawable.header_verde);
    }

}
