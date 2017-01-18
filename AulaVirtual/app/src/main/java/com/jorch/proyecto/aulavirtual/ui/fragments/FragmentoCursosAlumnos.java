package com.jorch.proyecto.aulavirtual.ui.fragments;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jorch.proyecto.aulavirtual.R;
import com.jorch.proyecto.aulavirtual.data.Alumno;
import com.jorch.proyecto.aulavirtual.data.AlumnoCursoDao;
import com.jorch.proyecto.aulavirtual.data.Curso;
import com.jorch.proyecto.aulavirtual.data.Profesor;
import com.jorch.proyecto.aulavirtual.ui.AulaActivity;
import com.jorch.proyecto.aulavirtual.utils.AdapterRecyclerViewCursos;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JORCH on 18/01/2017.
 */

public class FragmentoCursosAlumnos extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private FloatingActionButton fab;
    private Alumno alumno;
    private List<Curso> listaCursos = new ArrayList<Curso>();

    public static FragmentoCursosAlumnos newInstance(Alumno alumno) {
        Bundle args = new Bundle();
        args.putSerializable(AulaActivity.ALUMNO_LOGEADO,alumno);
        FragmentoCursosAlumnos fragment = new FragmentoCursosAlumnos();
        fragment.setArguments(args);
        return fragment;
    }

    public static FragmentoCursosAlumnos newInstance(Profesor profesor) {
        Bundle args = new Bundle();
        args.putSerializable(AulaActivity.PROFESOR_LOGEADO,profesor);
        FragmentoCursosAlumnos fragment = new FragmentoCursosAlumnos();
        fragment.setArguments(args);
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cursos,container,false);
        recyclerView = (RecyclerView) view.findViewById(R.id.rv_cursor);
        Bundle bundle = getArguments();
        alumno = (Alumno) bundle.getSerializable(AulaActivity.ALUMNO_LOGEADO);
        adapter = new AdapterRecyclerViewCursos(obtenerListaCursos(alumno));
        //fab = (FloatingActionButton) view.findViewById(R.id.fab_cursos);
        layoutManager = new GridLayoutManager(getContext(),2);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
        return view;
    }
    public List<Curso> obtenerListaCursos(Alumno alumno){
        Cursor cursor = AlumnoCursoDao.createInstance(getContext()).obtenerAllCursosByAlumnoId(alumno.getId());
        if (cursor.moveToFirst()){
            do {
                listaCursos.add(new Curso(cursor));
            }while (cursor.moveToNext());
        }
        return listaCursos;
    }
}