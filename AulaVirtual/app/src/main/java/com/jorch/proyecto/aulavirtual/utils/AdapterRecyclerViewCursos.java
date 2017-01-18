package com.jorch.proyecto.aulavirtual.utils;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jorch.proyecto.aulavirtual.R;
import com.jorch.proyecto.aulavirtual.data.Alumno;
import com.jorch.proyecto.aulavirtual.data.AulaVirtualContract;
import com.jorch.proyecto.aulavirtual.data.Curso;
import com.jorch.proyecto.aulavirtual.data.Profesor;

import java.util.List;

/**
 * Created by JORCH on 18/01/2017.
 */

public class AdapterRecyclerViewCursos extends RecyclerView.Adapter<AdapterRecyclerViewCursos.CursosViewHolder> {
    private List<Curso> listaCursos;
    public AdapterRecyclerViewCursos(List<Curso> listaCursos){
        this.listaCursos = listaCursos;
    }
    public class  CursosViewHolder extends RecyclerView.ViewHolder{
        public ImageView imageCurso;
        public TextView nombreCurso;
        public TextView descripcionCurso;
        public CursosViewHolder(View itemView) {
            super(itemView);
            imageCurso = (ImageView) itemView.findViewById(R.id.cv_curso_imagen);
            nombreCurso = (TextView) itemView.findViewById(R.id.cv_curso_nombre);
            descripcionCurso = (TextView) itemView.findViewById(R.id.cv_curso_descripcion);
        }
    }

    @Override
    public void onBindViewHolder(CursosViewHolder holder, int position) {
        holder.imageCurso.setImageResource(listaCursos.get(position).getFoto_curso());
        holder.nombreCurso.setText(listaCursos.get(position).getNombre());
        holder.descripcionCurso.setText(listaCursos.get(position).getDescripcion());
        //TODO FALTA FECHA INICO FECHA FINAL
    }

    @Override
    public CursosViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_curso,parent,false);
        return new CursosViewHolder(v);
    }

    @Override
    public int getItemCount() {
        return listaCursos.size();
    }
}
