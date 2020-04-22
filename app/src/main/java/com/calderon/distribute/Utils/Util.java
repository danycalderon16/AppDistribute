package com.calderon.distribute.Utils;

import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.TextView;
import android.widget.TimePicker;

import com.calderon.distribute.Models.Pedidos;
import com.calderon.distribute.Models.Tienda;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Util {

    public static void getTime(Context context, final TextView textView){
        Calendar c = Calendar.getInstance();
        final int mHour = c.get(Calendar.HOUR_OF_DAY);
        int mMin = c.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog =  new TimePickerDialog(context, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                textView.setText(hourOfDay +":"+minute);
            }
        },mHour,mMin,false);

        timePickerDialog.show();

    }

    public static void nextScreen(Context context,Class<?> anyClass ){
        Intent intent = new Intent(context,anyClass);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(intent);
    }

    public static List<Tienda> loadDataFromTienda(SharedPreferences preferences) {
        Gson gson = new Gson();
        String json = preferences.getString("Lista de Tiendas", null);
        Type type = new TypeToken<ArrayList<Tienda>>() {
        }.getType();
        List<Tienda> tiendaList = gson.fromJson(json, type);

        if (tiendaList == null) {
            tiendaList = new ArrayList<>();
        }

        return tiendaList;
    }

    public static List<Pedidos> loadDataFromPedidos(SharedPreferences preferences) {
        Gson gson = new Gson();
        String json = preferences.getString("Lista de pedidos", null);
        Type type = new TypeToken<ArrayList<Tienda>>() {
        }.getType();
        List<Pedidos> pedidos = gson.fromJson(json, type);

        if (pedidos == null) {
            pedidos = new ArrayList<>();
        }

        return pedidos;
    }

    public static void saveDataTiendas(SharedPreferences preferences, List<Tienda> tiendaList) {
        SharedPreferences.Editor editor = preferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(tiendaList);
        editor.putString("Lista de Tiendas", json);
        editor.apply();
    }

    public static void saveDataPedidos(SharedPreferences preferences, List<Pedidos> pedidos) {
        SharedPreferences.Editor editor = preferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(pedidos);
        editor.putString("Lista de pedidos", json);
        editor.apply();
    }

}

