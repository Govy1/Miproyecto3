package com.example.miproyecto2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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
        getSupportActionBar().setTitle("Actividad 3");//titulo de barra
        //getSupportActionBar().hide();//ocultar barra

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
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menuactividad3, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.mnactivdad2:
                Intent intent3 = new Intent(Actividad3.this, Actividad2.class);
                startActivity(intent3);
                break;
            case R.id.mnagregarC:
                Intent intent4 = new Intent(Actividad3.this, AgregarContacto.class);
                startActivity(intent4);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
