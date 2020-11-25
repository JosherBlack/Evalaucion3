package com.example.evalaucion3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import Clases.Promos;

public class Promociones_act extends AppCompatActivity
{
    private Spinner sp1, sp2;
    private TextView envio, frase, resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promociones_act);

        //spinner
        sp1 = (Spinner)findViewById(R.id.fondo);
        sp2 = (Spinner)findViewById(R.id.sp2);

        //Ingresos
        envio =(TextView)findViewById(R.id.etenvio);

        // Textos
        frase =(TextView)findViewById(R.id.tv1);
        resultado=(TextView)findViewById(R.id.tv2);

        //llenado de listbox
        ArrayList<String> listaClientes = (ArrayList<String>)getIntent().getSerializableExtra("listaClientes");
        ArrayAdapter<String> adapt1 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaClientes);
        sp1.setAdapter(adapt1);

        //llenar segundo listbox

        ArrayList<String> listaPromos =  (ArrayList<String>)getIntent().getSerializableExtra("listaPromos");
        ArrayAdapter<String> adapt2 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaPromos);
        sp2.setAdapter(adapt2);

    }

    public void Calcular(View v)
    {
        String cliente = sp1.getSelectedItem().toString().toLowerCase();
        String pro     = sp2.getSelectedItem().toString().toLowerCase();

        Promos promos = new Promos();


        String env = envio.getText().toString();

        //Ramiro

        if(cliente.equals("ramiro") && pro.equals("pizzas promo") )
        {
            int valor = promos.getPizzasPromo();
            int plata = Integer.parseInt(env);

            int resulado = valor + plata;

            frase.setText("Estimado "+ cliente + " el precio final según promoción más envio es : ");
            resultado.setText("$"+ resulado);
        }

        if(cliente.equals("ramiro") && pro.equals("master pizza") )
        {
            int valor = promos.getMasterPizza();
            int plata = Integer.parseInt(env);

            int resulado = valor + plata;

            frase.setText("Estimado "+ cliente + " el precio final según promoción más envio es : ");
            resultado.setText("$"+ resulado);
        }

        if(cliente.equals("ramiro") && pro.equals("pizza max") )
        {
            int valor = promos.getPizzaMax();
            int plata = Integer.parseInt(env);

            int resulado = valor + plata;

            frase.setText("Estimado "+ cliente + " el precio final según promoción más envio es : ");
            resultado.setText("$"+ resulado);
        }

        //rosa

        if(cliente.equals("rosa") && pro.equals("pizzas promo") )
        {
            int valor = promos.getPizzasPromo();
            int plata = Integer.parseInt(env);

            int resulado = valor + plata;

            frase.setText("Estimado "+ cliente + " el precio final según promoción más envio es : ");
            resultado.setText("$"+ resulado);
        }

        if(cliente.equals("rosa") && pro.equals("master pizza") )
        {
            int valor = promos.getMasterPizza();
            int plata = Integer.parseInt(env);

            int resulado = valor + plata;

            frase.setText("Estimado "+ cliente + " el precio final según promoción más envio es : ");
            resultado.setText("$"+ resulado);
        }

        if(cliente.equals("rosa") && pro.equals("pizza max") )
        {
            int valor = promos.getPizzaMax();
            int plata = Integer.parseInt(env);

            int resulado = valor + plata;

            frase.setText("Estimado "+ cliente + " el precio final según promoción más envio es : ");
            resultado.setText("$"+ resulado);
        }

        //robert

        if(cliente.equals("robert") && pro.equals("pizzas promo") )
        {
            int valor = promos.getPizzasPromo();
            int plata = Integer.parseInt(env);

            int resulado = valor + plata;

            frase.setText("Estimado "+ cliente + " el precio final según promoción más envio es : ");
            resultado.setText("$"+ resulado);
        }

        if(cliente.equals("robert") && pro.equals("master pizza") )
        {
            int valor = promos.getMasterPizza();
            int plata = Integer.parseInt(env);

            int resulado = valor + plata;

            frase.setText("Estimado "+ cliente + " el precio final según promoción más envio es : ");
            resultado.setText("$"+ resulado);
        }

        if(cliente.equals("robert") && pro.equals("pizza max") )
        {
            int valor = promos.getPizzaMax();
            int plata = Integer.parseInt(env);

            int resulado = valor + plata;

            frase.setText("Estimado "+ cliente + " el precio final según promoción más envio es : ");
            resultado.setText("$"+ resulado);
        }
    }


}