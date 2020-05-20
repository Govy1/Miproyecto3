package com.example.miproyecto2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.miproyecto2.Adaptadores.GridViewAvatares;

public class Actividad4 extends AppCompatActivity {
    GridView gvavatar;
    GridViewAvatares gridviewavatares;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad4);
        getSupportActionBar().setTitle("Seleccionar Avatar");
        gvavatar = (GridView) findViewById(R.id.gvavatar);
        gvavatar.setAdapter(new GridViewAvatares(this));
        gvavatar.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                gridviewavatares = new GridViewAvatares(Actividad4.this);

                MainActivity.contactoactual.setImagen(gridviewavatares.avataresArray[position]);
                //Toast.makeText(getApplicationContext(),""+avt, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), AgregarContacto.class);
                intent.putExtra("idavatar", position);
                startActivity(intent);
            }
        });
    }
}


