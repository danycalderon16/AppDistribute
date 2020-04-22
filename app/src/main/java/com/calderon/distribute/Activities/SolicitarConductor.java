package com.calderon.distribute.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.calderon.distribute.Models.Pedidos;
import com.calderon.distribute.R;
import com.calderon.distribute.Utils.Util;

import java.util.List;

public class SolicitarConductor extends AppCompatActivity {


    private List<Pedidos> pedidosList;
    private Button button;
    private TextView hour;
    private TextView dir;
    private TextView cant;
    private SharedPreferences spPedidos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitar_conductor);

        VideoView videoView = findViewById(R.id.viedo_map);
        String videoPath = "android.resource://"+getPackageName()+"/"+R.raw.map;
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);

        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);

        dir = findViewById(R.id.desc);
        hour = findViewById(R.id.hour);
        cant = findViewById(R.id.cant);

        spPedidos = getSharedPreferences("pedidos",MODE_PRIVATE);
        pedidosList = Util.loadDataFromPedidos(spPedidos);

        button = findViewById(R.id.buttonSC);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String direc =dir.getText().toString();
                String hora = hour.getText().toString();
                int count = Integer.parseInt(cant.getText().toString());
                pedidosList.add(new Pedidos(hora,count,direc,true));
                Util.saveDataPedidos(spPedidos,pedidosList);
                Toast.makeText(SolicitarConductor.this, "Consuctor solicitado", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

