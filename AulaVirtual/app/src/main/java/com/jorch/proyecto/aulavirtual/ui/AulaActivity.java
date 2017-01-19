package com.jorch.proyecto.aulavirtual.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.Cursor;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.jorch.proyecto.aulavirtual.R;
import com.jorch.proyecto.aulavirtual.data.Alumno;
import com.jorch.proyecto.aulavirtual.data.AlumnoCursoDao;
import com.jorch.proyecto.aulavirtual.data.AlumnoDao;
import com.jorch.proyecto.aulavirtual.data.AulaVirtualContract;
import com.jorch.proyecto.aulavirtual.data.Curso;
import com.jorch.proyecto.aulavirtual.data.Profesor;
import com.jorch.proyecto.aulavirtual.data.ProfesorCursoDao;
import com.jorch.proyecto.aulavirtual.data.ProfesorDao;
import com.jorch.proyecto.aulavirtual.data.Usuario;
import com.jorch.proyecto.aulavirtual.dialogs.AddCursoAlumnoDialog;
import com.jorch.proyecto.aulavirtual.utils.AdapterRecyclerViewCursos;
import com.jorch.proyecto.aulavirtual.utils.AdapterViewPager;
import com.jorch.proyecto.aulavirtual.utils.SesionPrefs;

import java.util.ArrayList;
import java.util.List;

public class AulaActivity extends AppCompatActivity {
    public static final String ALUMNO_LOGEADO = "ALUMNO_LOGEADO";
    public static final String PROFESOR_LOGEADO = "PROFESOR_LOGEADO";
    private static final int REQUEST_ADD_CURSO_PROFESOR = 0;
    private Alumno alumno;
    private Profesor profesor;
    private List<Curso> listaCursos = new ArrayList<>();
    private CoordinatorLayout coordinatorLayout;
    private NavigationView navigationViewAula;
    private DrawerLayout drawerLayoutAula;
    private ActionBarDrawerToggle drawerToggleAula;
    private AdapterViewPager adapterViewPager;
    private Toolbar toolbarAula;
    private String ROL_USUARIO;
    private Intent intentLogin;
    private Bundle bundleLogin;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private com.melnykov.fab.FloatingActionButton fab;
    private SwipeRefreshLayout refreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!SesionPrefs.get(this).isLoggedIn()){
            startActivity(new Intent(this,LoginActivity.class));
            finish();
            return;
        }
        setContentView(R.layout.activity_aula);
        toolbarAula = (Toolbar) findViewById(R.id.toolbar_aula);
        navigationViewAula = (NavigationView) findViewById(R.id.navigationview_aula);
        drawerLayoutAula = (DrawerLayout) findViewById(R.id.drawer_layout_aula);
        recyclerView = (RecyclerView) findViewById(R.id.rv_cursos);
        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinator_layout_aula);
        refreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeRefreshRecyclerView);
        setSupportActionBar(toolbarAula);
        drawerToggleAula = new ActionBarDrawerToggle(this,drawerLayoutAula,toolbarAula,R.string.open_drawer,R.string.close_drawer);
        drawerLayoutAula.addDrawerListener(drawerToggleAula);
        drawerToggleAula.syncState();
        fab = (com.melnykov.fab.FloatingActionButton) findViewById(R.id.fab_cursos_añadir);
        intentLogin = getIntent();
        bundleLogin = intentLogin.getExtras();
        final Usuario usuario = (Usuario) bundleLogin.getSerializable(LoginActivity.USUARIO_LOGEADO);

        ROL_USUARIO = usuario.getRol();
        if (ROL_USUARIO.equalsIgnoreCase("ESTUDIANTE")){
            alumno = AlumnoDao.createInstance(this).obtenerAlumnoByUsuario(usuario.getId());
            adapter = new AdapterRecyclerViewCursos(obtenerListaCursos(alumno));
            layoutManager = new GridLayoutManager(this,2);
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(layoutManager);
            refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                @Override
                public void onRefresh() {
                    adapter = new AdapterRecyclerViewCursos(obtenerListaCursos(alumno));
                    recyclerView.setAdapter(adapter);
                    refreshLayout.setRefreshing(false);
                }
            });

            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AddCursoAlumnoDialog addCursoAlumnoDialog = AddCursoAlumnoDialog.newInstance(alumno);
                    getSupportFragmentManager().beginTransaction().add(addCursoAlumnoDialog,"DIALOG_AÑADIR_CURSO").commit();
                }
            });
        }
        else if(ROL_USUARIO.equalsIgnoreCase("PROFESOR")){
            profesor = ProfesorDao.createInstance(this).obtenerProfesorByUsuario(usuario.getId());
            adapter = new AdapterRecyclerViewCursos(obtenerListaCursos(profesor));
            layoutManager = new GridLayoutManager(this,2);
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(layoutManager);
            refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                @Override
                public void onRefresh() {
                    adapter = new AdapterRecyclerViewCursos(obtenerListaCursos(profesor));
                    recyclerView.setAdapter(adapter);
                    refreshLayout.setRefreshing(false);
                }
            });

            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intentCrearCursoAlumno = new Intent(AulaActivity.this,CrearCursosActivity.class);
                    Bundle bundleCrearCursoAlumno = new Bundle();
                    bundleCrearCursoAlumno.putSerializable(PROFESOR_LOGEADO,profesor);
                    intentCrearCursoAlumno.putExtras(bundleCrearCursoAlumno);
                    startActivityForResult(intentCrearCursoAlumno,REQUEST_ADD_CURSO_PROFESOR);
                }
            });
        }
    }
    public List<Curso> obtenerListaCursos(Alumno alumno){
        listaCursos = new ArrayList<Curso>(){};
        String nombre, descripcion;
        int imagen;
        Cursor cursor = AlumnoCursoDao.createInstance(this).obtenerAllCursosByAlumnoId(alumno.getId());
        if (cursor.moveToFirst()){
            do {
                nombre = cursor.getString(cursor.getColumnIndex(AulaVirtualContract.Cursos.NOMBRE));
                descripcion = cursor.getString(cursor.getColumnIndex(AulaVirtualContract.Cursos.DESCRIPCION));
                imagen = cursor.getInt(cursor.getColumnIndex(AulaVirtualContract.Cursos.FOTO_CURSO));
                Curso curso = new Curso(nombre,descripcion,imagen);
                listaCursos.add(curso);
            }while (cursor.moveToNext());
        }
        return listaCursos;
    }
    public List<Curso> obtenerListaCursos(Profesor profesor){
        listaCursos = new ArrayList<Curso>(){};
        Cursor cursor = ProfesorCursoDao.createInstance(this).obtenerAllCursosByProfesorId(profesor.getId());
        String nombre, descripcion;
        int imagen;
        if (cursor.moveToFirst()){
            do {
                nombre = cursor.getString(cursor.getColumnIndex(AulaVirtualContract.Cursos.NOMBRE));
                descripcion = cursor.getString(cursor.getColumnIndex(AulaVirtualContract.Cursos.DESCRIPCION));
                imagen = cursor.getInt(cursor.getColumnIndex(AulaVirtualContract.Cursos.FOTO_CURSO));
                Curso curso = new Curso(nombre,descripcion,imagen);
                listaCursos.add(curso);
            }while (cursor.moveToNext());
        }
        return listaCursos;
    }
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggleAula.onConfigurationChanged(newConfig);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK){
            if (requestCode == REQUEST_ADD_CURSO_PROFESOR){
                Snackbar.make(coordinatorLayout,"Curso creado.\nDesliza para refrescar",Toast.LENGTH_LONG).show();
            }
        }
        if (resultCode == RESULT_CANCELED){

        }
    }
}
