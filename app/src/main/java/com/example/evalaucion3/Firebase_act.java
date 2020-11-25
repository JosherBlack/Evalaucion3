package com.example.evalaucion3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class Firebase_act extends AppCompatActivity
{
    private Spinner sp1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_act);

        sp1 = (Spinner)findViewById(R.id.sp1);

        ArrayList<String> listaPromos =  (ArrayList<String>)getIntent().getSerializableExtra("listaPromos");
        ArrayAdapter<String> adapt2 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaPromos);
        sp1.setAdapter(adapt2);


    }
}