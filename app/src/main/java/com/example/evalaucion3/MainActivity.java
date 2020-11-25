package com.example.evalaucion3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{

    private TextView usuario;
    private TextView contra;

    private String nombre1 = "android";
    private String contra1 = "123";


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usuario = (TextView) findViewById(R.id.etusuario);
        contra = (TextView) findViewById(R.id.etcontra);
    }


    public void iniciar(View v)
    {
        if (usuario.getText().toString().toLowerCase().equals(nombre1))
        {
            if (contra.getText().toString().toLowerCase().equals(contra1))
            {
                Intent i = new Intent(getBaseContext(), Menu_act.class);
                startActivity(i);
            }
            else
                {
                contra.setText("Contraseña Inválida");
                }
        }
        else
            {
                usuario.setText("Nombre Inválido");
            }
    }
}