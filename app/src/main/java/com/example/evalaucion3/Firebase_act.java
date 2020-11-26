package com.example.evalaucion3;

import androidx.annotation.NonNull;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


import com.google.firebase.FirebaseApp;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;


import java.util.ArrayList;
import java.util.UUID;

import Clases.Clientes;


public class Firebase_act extends AppCompatActivity
{
    FirebaseDatabase firebase;
    DatabaseReference databaseReference;

    private Spinner sp;

    EditText etnombre, etdestino;
    String etpromo;
    Button Boton1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_act);

        ini();

        sp = (Spinner)findViewById(R.id.sp3);

        ArrayList<String> listaPromos2 = (ArrayList<String>)getIntent().getSerializableExtra("listaPromos2");
        ArrayAdapter<String> adapt3 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaPromos2);
        sp.setAdapter(adapt3);

        Boton1 = (Button)findViewById(R.id.Boton1);
       etnombre  = (EditText)findViewById(R.id.etnombre);
       etdestino = (EditText)findViewById(R.id.etdestino);
       etpromo   = sp.getSelectedItem().toString().toLowerCase();



        Boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!etnombre.equals(""))
                {
                    Clientes c = new Clientes();

                    c.setId(UUID.randomUUID().toString());
                    c.setNombre(etnombre.getText().toString());
                    c.setDestino(etdestino.getText().toString());
                    c.setPromocion(etpromo);

                    databaseReference.child("Clientes").child(c.getId()).setValue(c);

                    Toast.makeText(getBaseContext(), "Se Ha Registrado Un Cliente", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getBaseContext(), "Error Al Registrar Cliente", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void listado(View v)
    {
        Intent i = new Intent(this, ListadoClientes_act.class);
        startActivity(i);
    }


    public void ini()
    {
        FirebaseApp.initializeApp(this);
        firebase = FirebaseDatabase.getInstance();
        databaseReference = firebase.getReference();
    }


}