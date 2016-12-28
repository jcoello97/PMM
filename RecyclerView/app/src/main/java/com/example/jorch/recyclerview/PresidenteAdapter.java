package com.example.jorch.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class PresidenteAdapter extends RecyclerView.Adapter<PresidenteAdapter.PresidenteViewHolder>{

    private List<Presidente> presidentes;

    public PresidenteAdapter(List<Presidente> presidentes){
        this.presidentes = presidentes;
    }

    public static class PresidenteViewHolder extends RecyclerView.ViewHolder{
        public TextView nombre;
        public TextView pais;
        public ImageView imagen;

        public PresidenteViewHolder(View v) {
            super(v);
            nombre = (TextView) v.findViewById(R.id.nombre_presidente);
            pais = (TextView) v.findViewById(R.id.pais_presidente);
            imagen = (ImageView) v.findViewById(R.id.imagen_presidente);
        }
    }


    @Override
    public PresidenteAdapter.PresidenteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.presidente_card,parent,false);

        return new PresidenteViewHolder(v);
    }

    @Override
    public void onBindViewHolder(PresidenteAdapter.PresidenteViewHolder holder, int position) {
        holder.nombre.setText(presidentes.get(position).getNombre());
        holder.pais.setText(presidentes.get(position).getPais());
        holder.imagen.setImageResource(presidentes.get(position).getImagen());
    }

    @Override
    public int getItemCount() {
        return presidentes.size();
    }
}
