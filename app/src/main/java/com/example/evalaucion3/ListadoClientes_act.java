package com.example.evalaucion3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import Clases.Clientes;

public class ListadoClientes_act extends AppCompatActivity
{
    private ListView list;
    private List<Clientes> listClientes = new ArrayList<Clientes>();

    FirebaseDatabase firebase;
    DatabaseReference databaseReference;

    Clientes ClientesSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_clientes_act);

        inicializar();

        list = (ListView) findViewById(R.id.lv1);

        databaseReference.child("Clientes").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot objSnapshot : snapshot.getChildren()) {
                    Clientes c = objSnapshot.getValue(Clientes.class);
                    listClientes.add(c);

                    ArrayAdapter adap = new ArrayAdapter(getBaseContext(), android.R.layout.simple_list_item_1, listClientes);
                    list.setAdapter(adap);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        list.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                ClientesSelected = (Clientes) parent.getItemAtPosition(position);
            }
        });




    }



    public void eliminar(View v)
    {
        Clientes c = new Clientes();
        c.setId(ClientesSelected.getId());
        databaseReference.child("Clientes").child(c.getId()).removeValue();
        Toast.makeText(this, "Cliente Ha Sido Eliminado", Toast.LENGTH_LONG).show();
    }





    public void inicializar()
    {
        FirebaseApp.initializeApp(this);
        firebase = FirebaseDatabase.getInstance();
        databaseReference = firebase.getReference();
    }

}