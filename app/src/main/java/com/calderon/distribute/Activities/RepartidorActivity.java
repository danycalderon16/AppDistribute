package com.calderon.distribute.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import com.calderon.distribute.Adapters.AdaptadorPedidos;
import com.calderon.distribute.Adapters.AdapterPedido;
import com.calderon.distribute.Models.Pedidos;
import com.calderon.distribute.R;
import com.calderon.distribute.Utils.Util;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class RepartidorActivity extends AppCompatActivity {

    private List<Pedidos> pedidosList;

    private RecyclerView mRecyclerView;
    // Puede ser declarado como 'RecyclerView.Adapter' o como nuetra clase adaptador 'MyAdapter'
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private SharedPreferences spPedidos;
    private FloatingActionButton fab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repartidor);

        spPedidos = getSharedPreferences("pedidos",MODE_PRIVATE);
        pedidosList = Util.loadDataFromPedidos(spPedidos);

        Toast.makeText(this,pedidosList.toString(),Toast.LENGTH_SHORT).show();

    }
}
