package com.jorch.proyecto.aulavirtual.ui;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.jorch.proyecto.aulavirtual.R;
import com.jorch.proyecto.aulavirtual.data.AlumnoDao;
import com.jorch.proyecto.aulavirtual.data.ProfesorDao;
import com.jorch.proyecto.aulavirtual.data.Usuario;
import com.jorch.proyecto.aulavirtual.ui.fragments.FragmentoCursosAlumnos;
import com.jorch.proyecto.aulavirtual.ui.fragments.FragmentoCursosProfesores;
import com.jorch.proyecto.aulavirtual.ui.fragments.fragment1;
import com.jorch.proyecto.aulavirtual.ui.fragments.fragment2;
import com.jorch.proyecto.aulavirtual.utils.AdapterViewPager;
import com.jorch.proyecto.aulavirtual.utils.SesionPrefs;

public class AulaActivity extends AppCompatActivity {
    public static final String ALUMNO_LOGEADO = "ALUMNO_LOGEADO";
    public static final String PROFESOR_LOGEADO = "PROFESOR_LOGEADO";

    private NavigationView navigationViewAula;
    private DrawerLayout drawerLayoutAula;
    private ActionBarDrawerToggle drawerToggleAula;
    private AdapterViewPager adapterViewPager;
    private ViewPager viewPagerAula;
    private Toolbar toolbarAula;
    private TabLayout tabLayoutAula;
    private String ROL_USUARIO;

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
        tabLayoutAula = (TabLayout) findViewById(R.id.tab_layout_aula);
        viewPagerAula = (ViewPager) findViewById(R.id.viewpager_aula);
        navigationViewAula = (NavigationView) findViewById(R.id.navigationview_aula);
        drawerLayoutAula = (DrawerLayout) findViewById(R.id.drawer_layout_aula);

        setSupportActionBar(toolbarAula);
        drawerToggleAula = new ActionBarDrawerToggle(this,drawerLayoutAula,toolbarAula,R.string.open_drawer,R.string.close_drawer);
        drawerLayoutAula.addDrawerListener(drawerToggleAula);
        drawerToggleAula.syncState();

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        Usuario usuario = (Usuario) bundle.getSerializable(LoginActivity.USUARIO_LOGEADO);

        ROL_USUARIO = usuario.getRol();
        if (ROL_USUARIO.equalsIgnoreCase("ESTUDIANTE")){
            adapterViewPager = new AdapterViewPager(getSupportFragmentManager());

            FragmentoCursosAlumnos fragmentoCursosAlumnos = FragmentoCursosAlumnos.newInstance(
                    AlumnoDao.createInstance(getApplicationContext()).obtenerAlumnoByUsuario(usuario.getId()));
            adapterViewPager.addFragmentos(fragmentoCursosAlumnos,"CURSOS");
            adapterViewPager.addFragmentos(new fragment2(),"EVENTOS");

            viewPagerAula.setAdapter(adapterViewPager);
            tabLayoutAula.setupWithViewPager(viewPagerAula);
        }
        else if(ROL_USUARIO.equalsIgnoreCase("PROFESOR")){
            adapterViewPager = new AdapterViewPager(getSupportFragmentManager());

            FragmentoCursosProfesores fragmentoCursosProfesores = FragmentoCursosProfesores.newInstance(
                    ProfesorDao.createInstance(getApplicationContext()).obtenerProfesorByUsuario(usuario.getId()));
            adapterViewPager.addFragmentos(fragmentoCursosProfesores,"CURSOS");
            adapterViewPager.addFragmentos(new fragment1(),"CONFIGURACION");
            adapterViewPager.addFragmentos(new fragment2(),"EVENTOS");

            viewPagerAula.setAdapter(adapterViewPager);
            tabLayoutAula.setupWithViewPager(viewPagerAula);
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggleAula.onConfigurationChanged(newConfig);
    }
}
