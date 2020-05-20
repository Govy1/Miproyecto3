package com.example.miproyecto2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Actividad3 extends AppCompatActivity {
    TextView lblactividad3;
     ListView lvcontactos;
     //crear arreglo de contactos
    String nombres[] = new String[MainActivity.miscontactos.size()];
    String alias[] = new String[MainActivity.miscontactos.size()];
    String ids[] = new String[MainActivity.miscontactos.size()];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad3);
        getSupportActionBar().hide();

        lblactividad3 = (TextView) findViewById(R.id.lblactividad3);
        lvcontactos = (ListView) findViewById(R.id.lvcontactos);
        for(int i = 0; i<MainActivity.miscontactos.size(); i++){
            Contacto c = MainActivity.miscontactos.get(i);
            nombres[i] = c.getNombre();
            alias[i] = c.getAlias();
            ids[i] = ""+c.getIdcontacto();
        }

        lvcontactos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String mensaje = "Alias: "+alias[position];
                lblactividad3.setText(mensaje);
                Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_SHORT).show();
            }
        });

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_activated_1,nombres);
        lvcontactos.setAdapter(adapter);

    }
}
