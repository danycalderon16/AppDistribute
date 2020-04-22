package com.calderon.distribute.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.calderon.distribute.Adapters.AdapterTiendas;
import com.calderon.distribute.Models.Tienda;
import com.calderon.distribute.R;
import com.calderon.distribute.Utils.Util;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class ClienteActivity extends AppCompatActivity {

    private List<Tienda> tiendaList;

    private RecyclerView mRecyclerView;
    // Puede ser declarado como 'RecyclerView.Adapter' o como nuetra clase adaptador 'MyAdapter'
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private SharedPreferences spTiendas;
    private  FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ClienteActivity.this, SolicitarConductor.class);
                startActivity(intent);
            }
        });

        spTiendas = getSharedPreferences("tiendas",MODE_PRIVATE);
        tiendaList = Util.loadDataFromTienda(spTiendas);

        mRecyclerView =  findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(this);

        mAdapter = new AdapterTiendas(tiendaList,this, new AdapterTiendas.OnItemClickListener() {
            @Override
            public void onItemClick(Tienda tienda, int position) {
                Snackbar.make(fab,tienda.getNombre(),Snackbar.LENGTH_LONG).show();
            }
        });

        // Lo usamos en caso de que sepamos que el layout no va a cambiar de tamaño, mejorando la performance
        mRecyclerView.setHasFixedSize(true);
        // Añade un efecto por defecto, si le pasamos null lo desactivamos por completo
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        // Enlazamos el layout manager y adaptor directamente al recycler view
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
