package com.calderon.distribute.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.DialogFragment;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.calderon.distribute.Models.Tienda;
import com.calderon.distribute.R;
import com.calderon.distribute.Utils.TimePickerFragment;
import com.calderon.distribute.Utils.Util;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class VendedorActivity extends AppCompatActivity implements View.OnClickListener{

    private Toolbar toolbar;
    private TextView horaAP;
    private TextView horaCl;
    private TextView nombreT;
    private TextView tipoT;
    private FloatingActionButton fab;
    private SharedPreferences spTiendas;
    private Button button;

    private List<Tienda> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendedor);
        setToolbar();

        horaAP = findViewById(R.id.txt_hora_ap);
        horaAP.setOnClickListener(this);

        horaCl = findViewById(R.id.txt_hora_cl);
        horaCl.setOnClickListener(this);

        fab = findViewById(R.id.fab_vendedor);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(VendedorActivity.this,SolicitarConductor.class));
            }
        });

        button = findViewById(R.id.button);
        button.setOnClickListener(this);

        spTiendas = getSharedPreferences("tiendas",MODE_PRIVATE);

        list = Util.loadDataFromTienda(spTiendas);

        tipoT = findViewById(R.id.edit_tipo);
        nombreT = findViewById(R.id.edit_nombre);
    }

    private void setToolbar() {
        toolbar = findViewById(R.id.toolbar_vendedor);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_home);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.txt_hora_ap:
                Util.getTime(VendedorActivity.this,horaAP);
                break;
            case R.id.txt_hora_cl:
                Util.getTime(VendedorActivity.this,horaCl);
                break;
            case R.id.button:
                addTienda();
                break;
            case R.id.fab_vendedor:
                break;
        }
    }

    private void addTienda(){
        String nombre = nombreT.getText().toString();
        String tipo = tipoT.getText().toString();
        String hp = horaAP.getText().toString();
        String hc = horaCl.getText().toString();
        if(nombre==null || tipo == null || horaCl == null || horaAP == null) return;
        list.add(new Tienda(nombre,tipo,hp+" - "+hc));

        Util.saveDataTiendas(spTiendas,list);
        nombreT.setText("");
        tipoT.setText("");
        horaAP.setText("--");
        horaCl.setText("--");
        hideKeyboard(this);
        Snackbar.make(fab,"Tienda Agregada",Snackbar.LENGTH_LONG).show();

    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
         switch (item.getItemId()) {
             case R.id.home:
                 Util.nextScreen(VendedorActivity.this, LoginActivity.class);
                 return true;
             default:
                 return super.onOptionsItemSelected(item);
         }
    }

    public static void hideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        //Find the currently focused view, so we can grab the correct window token from it.
        View view = activity.getCurrentFocus();
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = new View(activity);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
