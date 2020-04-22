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


public class AdapterPedido extends RecyclerView.Adapter<AdapterPedido.ViewHolder> {

    private List<Pedidos> pedidosList;
    private Context context;
    private OnItemClicListenerPedidos itemClicListener;

    public AdapterPedido(List<Pedidos> pedidosList, Context context, OnItemClicListenerPedidos itemClicListener) {
        this.pedidosList = pedidosList;
        this.context = context;
        this.itemClicListener = itemClicListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.card_pedidos, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //holder;
        //holder.bind(pedidosList.get(position),itemClicListener);
    }

    @Override
    public int getItemCount() {
        return pedidosList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView hora;
        public TextView cant;
        public TextView dire;
        public ViewHolder(View itemView) {
            super(itemView);
            hora = itemView.findViewById(R.id.horaSC);
            cant = itemView.findViewById(R.id.cantSC);
            dire = itemView.findViewById(R.id.descSC);

        }
        public void bind(final Pedidos pedidos, final OnItemClicListenerPedidos listener){
            hora.setText(pedidos.getHora());
            cant.setText(pedidos.getCantidad());
            dire.setText(pedidos.getDirecciones());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClic(pedidos,getAdapterPosition());
                }
            });
        }
    }

    public interface OnItemClicListenerPedidos{
        void onItemClic(Pedidos pedidos, int posistion);
    }
}
