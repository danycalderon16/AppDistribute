package com.calderon.distribute.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.calderon.distribute.Models.Pedidos;
import com.calderon.distribute.R;

import java.util.List;

public class AdaptadorPedidos extends RecyclerView.Adapter<AdaptadorPedidos.ViewHolder> {

    private List<Pedidos> pedidosList;
    private Context context;
    private OnItemClicListenerPedidos itemClicListener;

    public AdaptadorPedidos(List<Pedidos> pedidos, Context context, OnItemClicListenerPedidos itemClickListener) {
        this.pedidosList = pedidos;
        this.context = context;
        this.itemClicListener = itemClickListener;
    }

    public AdaptadorPedidos(List<Pedidos> pedidosList, Context context) {
        this.pedidosList = pedidosList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_pedidos, parent, false);
        context = parent.getContext();
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorPedidos.ViewHolder holder, int position) {
       // holder.bind(pedidosList.get(position));
    }


    @Override
    public int getItemCount() {
        return pedidosList.size();
    }

    // Declaramos nuestra interfaz con el/los método/s a implementar
    public interface OnItemClickListener {
        void onItemClick(Pedidos pedidos, int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView hora;
        public TextView cant;
        public TextView dire;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            hora = itemView.findViewById(R.id.horaSC);
            cant = itemView.findViewById(R.id.cantSC);
            dire = itemView.findViewById(R.id.descSC);
        }

        public void bind(final Pedidos pedidos){
            hora.setText(pedidos.getHora());
            cant.setText(pedidos.getCantidad());
            dire.setText(pedidos.getDirecciones());
           /* itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClic(pedidos,getAdapterPosition());
                }
            });*/
        }
    }

    // Declaramos nuestra interfaz con el/los método/s a implementar

    public interface OnItemClicListenerPedidos{
        void onItemClic(Pedidos pedidos, int posistion);
    }

}