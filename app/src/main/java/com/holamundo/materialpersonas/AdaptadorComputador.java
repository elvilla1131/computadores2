package com.holamundo.materialpersonas;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by android on 30/04/2018.
 */

public class AdaptadorComputador extends RecyclerView.Adapter<AdaptadorComputador.ComputadorViewHolder> {

    private ArrayList<Computador> computadores;
    private onComputadorClickListener clickListener;


    public AdaptadorComputador(ArrayList<Computador> computadores, onComputadorClickListener clickListener){
        this.computadores = computadores;
        this.clickListener = clickListener;
    }

    @Override
    public ComputadorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_computador,parent,false);
        return new ComputadorViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ComputadorViewHolder holder, int position) {
        final Computador c = computadores.get(position);
        holder.foto.setImageResource(c.getFoto());
        holder.marca.setText(c.getMarca());
        holder.ram.setText(c.getRam());
        holder.color.setText(c.getColor());
        holder.tipo.setText(c.getTipo());
        holder.so.setText(c.getSo());



        holder.v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListener.onComputadorClick(c);
            }
        });

    }

    @Override
    public int getItemCount() {
        return computadores.size();
    }

    public static class ComputadorViewHolder extends RecyclerView.ViewHolder{
        private ImageView foto;
        private TextView marca;
        private TextView ram;
        private TextView color;
        private TextView tipo;
        private TextView so;
        private View v;

        public ComputadorViewHolder(View itemView){
            super(itemView);
            v = itemView;
            foto = v.findViewById(R.id.imgFoto);
            marca = v.findViewById(R.id.texMarca);
            ram = v.findViewById(R.id.texRam);
            color = v.findViewById(R.id.texColor);
            tipo = v.findViewById(R.id.texTipo);
            so = v.findViewById(R.id.texSo);
        }

    }
    public interface onComputadorClickListener {
        void onComputadorClick(Computador p);
    }
}
