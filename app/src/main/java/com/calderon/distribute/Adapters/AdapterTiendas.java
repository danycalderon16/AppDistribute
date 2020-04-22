package com.calderon.distribute.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.calderon.distribute.Models.Tienda;
import com.calderon.distribute.R;

import java.util.List;

public class AdapterTiendas extends RecyclerView.Adapter<AdapterTiendas.ViewHolder> {

    private List<Tienda> tiendas;
    private Context context;
    private OnItemClickListener itemClickListener;

    public AdapterTiendas(List<Tienda> tiendas, Context context, OnItemClickListener itemClickListener) {
        this.tiendas = tiendas;
        this.context = context;
        this.itemClickListener = itemClickListener;
    }

    public AdapterTiendas(List<Tienda> tiendas, Context context) {
        this.tiendas = tiendas;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflamos el layout y se lo pasamos al constructor del ViewHolder, donde manejaremos
        // toda la lógica como extraer los datos, referencias...
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_lugares, parent, false);
        context = parent.getContext();
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterTiendas.ViewHolder holder, int position) {
        holder.bind(tiendas.get(position),itemClickListener);
    }

    @Override
    public int getItemCount() {
        return tiendas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView nombre;
        public TextView tipo;
        public TextView horario;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.nombre);
            tipo = itemView.findViewById(R.id.tipo);
            horario = itemView.findViewById(R.id.horario);
        }

        public void bind(final Tienda tienda, final OnItemClickListener listener){
            nombre.setText(tienda.getNombre());
            tipo.setText(tienda.getTipo());
            horario.setText(tienda.getHorario());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(tienda, getAdapterPosition());
                }
            });
        }
    }

    // Declaramos nuestra interfaz con el/los método/s a implementar
    public interface OnItemClickListener{
        void onItemClick(Tienda tienda, int position);
    }
}
