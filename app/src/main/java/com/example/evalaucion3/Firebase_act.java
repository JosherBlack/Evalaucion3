package com.example.evalaucion3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;



import java.util.ArrayList;


public class Firebase_act extends AppCompatActivity
{
    private Spinner sp;

    EditText etnombre, etdestino;
    String etpromo;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_act);

        sp = (Spinner)findViewById(R.id.sp3);

        ArrayList<String> listaPromos2 = (ArrayList<String>)getIntent().getSerializableExtra("listaPromos2");
        ArrayAdapter<String> adapt3 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaPromos2);
        sp.setAdapter(adapt3);

       etnombre  = (EditText)findViewById(R.id.etnombre);
       etdestino = (EditText)findViewById(R.id.etdestino);
       etpromo   = sp.getSelectedItem().toString().toLowerCase();

    }

    public void listado(View v)
    {
        Intent i = new Intent(this, ListadoClientes_act.class);
        startActivity(i);
    }
}