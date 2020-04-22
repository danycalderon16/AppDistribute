
package com.calderon.distribute.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.calderon.distribute.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private Button vendedor;
    private Button cliente;
    private Button repartidor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        vendedor = findViewById(R.id.btn_vendedor);
        cliente = findViewById(R.id.btn_clientes);
        repartidor = findViewById(R.id.btn_rep);

        vendedor.setOnClickListener(this);
        cliente.setOnClickListener(this);
        repartidor.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.btn_vendedor:
                intent = new Intent(this,VendedorActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_clientes:
                intent = new Intent(this,ClienteActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_rep:
                intent = new Intent(this,RepartidorActivity.class);
                startActivity(intent);
                break;
            default:
                Toast.makeText(this,"Seleccione una opción",Toast.LENGTH_SHORT).show();
        }
    }
}
