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
import com.jorch.proyecto.aulavirtual.data.ProfesorCursoDao;
import com.jorch.proyecto.aulavirtual.ui.AulaActivity;
import com.jorch.proyecto.aulavirtual.utils.AdapterRecyclerViewCursos;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JORCH on 18/01/2017.
 */

public class FragmentoCursosProfesores extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private FloatingActionButton fab;
    private Profesor profesor;
    private List<Curso> listaCursos = new ArrayList<Curso>();

    public static FragmentoCursosProfesores newInstance(Profesor profesor) {
        Bundle args = new Bundle();
        args.putSerializable(AulaActivity.PROFESOR_LOGEADO,profesor);
        FragmentoCursosProfesores fragment = new FragmentoCursosProfesores();
        fragment.setArguments(args);
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cursos,container,false);
        recyclerView = (RecyclerView) view.findViewById(R.id.rv_cursor);
        //fab = (FloatingActionButton) view.findViewById(R.id.fab_cursos);
        Bundle bundle = getArguments();
        profesor = (Profesor) bundle.getSerializable(AulaActivity.PROFESOR_LOGEADO);
        adapter = new AdapterRecyclerViewCursos(obtenerListaCursos(profesor));
        layoutManager = new GridLayoutManager(getContext(),2);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
        return view;
    }
    public List<Curso> obtenerListaCursos(Profesor profesor){
        Cursor cursor = ProfesorCursoDao.createInstance(getContext()).obtenerAllCursosByProfesorId(profesor.getId());
        if (cursor.moveToFirst()){
            do {
                listaCursos.add(new Curso(cursor));
            }while (cursor.moveToNext());
        }
        return listaCursos;
    }
}