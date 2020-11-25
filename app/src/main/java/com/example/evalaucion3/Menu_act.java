package com.example.evalaucion3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

import java.util.ArrayList;

public class Menu_act extends AppCompatActivity
{
    private VideoView vv;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_act);

        // inicio video
        vv = (VideoView)findViewById(R.id.vv);
        String ruta = "android.resource://" + getPackageName() + "/" + R.raw.video;
        Uri uri = Uri.parse(ruta);
        vv.setVideoURI(uri);
        MediaController media = new MediaController(this) ;
        vv.setMediaController(media);
        // fin video
    }

    public void gestion(View v)
    {
        ArrayList<String> promos = new ArrayList<String>();
        promos.add("Pizzas Promo");
        promos.add("Master Pizza");
        promos.add("Pizza Max");

        Intent i = new Intent(getBaseContext(), Firebase_act.class);

        i.putExtra("listaPromos", promos);

        startActivity(i);
    }

    public void promos(View v)
    {
        //listbox 1

        ArrayList<String> clientes = new ArrayList<String>();
        clientes.add("Ramiro");
        clientes.add("Rosa");
        clientes.add("Robert");

        //listbox2

        ArrayList<String> promos = new ArrayList<String>();
        promos.add("Pizzas Promo");
        promos.add("Master Pizza");
        promos.add("Pizza Max");

        Intent i = new Intent(getBaseContext(), Promociones_act.class);

        // envio de spinners

        i.putExtra("listaClientes", clientes);
        i.putExtra("listaPromos", promos);

        startActivity(i);
    }
}