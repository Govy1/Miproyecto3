package com.example.miproyecto2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.miproyecto2.Adaptadores.GridViewAvatares;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //datos
    public static Contacto micontacto;
    public static ArrayList<Contacto> miscontactos = new ArrayList<Contacto>();
    public static Contacto contactoactual = null;

    //componentes
    public static int contador=1;
    Button btnagregar, btnirA2, btnirA3;
    TextView lblnombre, lblalias;
    GridViewAvatares gridviewavatares;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Menu Principal");
//        getSupportActionBar().hide(); //comando para quitar barra de estado
        gridviewavatares = new GridViewAvatares(this);
        miscontactos.add(new Contacto( "Juan", "alias1", contador++, gridviewavatares.avataresArray[contador++]));
        miscontactos.add(new Contacto( "Carlos", "alias2", contador++, gridviewavatares.avataresArray[contador++]));
        miscontactos.add(new Contacto( "Maria", "alias3", contador++, gridviewavatares.avataresArray[contador++]));
        miscontactos.add(new Contacto( "Jose", "alias4", contador++, gridviewavatares.avataresArray[contador++]));
        miscontactos.add(new Contacto( "Luis", "alias5", contador++, gridviewavatares.avataresArray[contador++]));
        miscontactos.add(new Contacto( "Franco", "alias6", contador++, gridviewavatares.avataresArray[contador++]));

        micontacto = new Contacto();
        btnagregar = (Button) findViewById(R.id.btnagregar);
        btnirA2 = (Button) findViewById(R.id.btnirA2);
        btnirA3 = (Button) findViewById(R.id.btnirA3);
        lblnombre = (TextView) findViewById(R.id.lblnombre);
        lblalias = (TextView) findViewById(R.id.lblalias);

        lblnombre.setVisibility(View.INVISIBLE);
        lblalias.setVisibility(View.INVISIBLE);

        //botones
        btnagregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4 = new Intent(MainActivity.this, AgregarContacto.class);
                startActivity(intent4);
            }
        });
        btnirA2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(MainActivity.this, Actividad2.class);
                startActivity(intent2);
            }
        });
        btnirA3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(MainActivity.this, Actividad3.class);
                startActivity(intent3);
            }
        });


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mimenu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.mnuirA2:
                Intent intent2 = new Intent(MainActivity.this, Actividad2.class);
                startActivity(intent2);
                break;
            case R.id.mnuirA3:
                Intent intent3 = new Intent(MainActivity.this, Actividad3.class);
                startActivity(intent3);
                break;
            case R.id.mnuagregar:
                Intent intent4 = new Intent(MainActivity.this, AgregarContacto.class);
                startActivity(intent4);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
