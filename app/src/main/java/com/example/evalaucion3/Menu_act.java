package com.example.evalaucion3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

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
        Intent i = new Intent(getBaseContext(), Firebase_act.class);
        startActivity(i);
    }

    public void promos(View v)
    {
        Intent i = new Intent(getBaseContext(), Promociones_act.class);
        startActivity(i);
    }
}