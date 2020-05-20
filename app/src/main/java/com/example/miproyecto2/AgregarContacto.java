package com.example.miproyecto2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AgregarContacto extends AppCompatActivity {
    EditText txtnombrecontacto, txtaliascontacto;
    Button btnagregarcontacto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_contacto);
        getSupportActionBar().setTitle("Agregar Contactos");

        txtnombrecontacto = (EditText) findViewById(R.id.txtnombre);
        txtaliascontacto = (EditText) findViewById(R.id.txtalias);
        btnagregarcontacto = (Button) findViewById(R.id.btnagregarcontacto);

        if (MainActivity.contactoactual != null){
            txtnombrecontacto.setText(MainActivity.contactoactual.getNombre());
            txtaliascontacto.setText(MainActivity.contactoactual.getAlias());
            btnagregarcontacto.setText("Modificar");
        }

        btnagregarcontacto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = txtnombrecontacto.getText().toString();
                String alias = txtaliascontacto.getText().toString();
                if (btnagregarcontacto.getText().equals("Modificar")){
                    for (int i=0; i<MainActivity.miscontactos.size(); i++){
                        Contacto c = MainActivity.miscontactos.get(i);
                        if(c.getNombre().equals(MainActivity.contactoactual.getNombre()) && c.getAlias().equals(MainActivity.contactoactual.getAlias())){
                            Contacto cm = new Contacto(nombre, alias, i);
                            MainActivity.miscontactos.set(i, cm);
                            MainActivity.contactoactual = null;
                            break;
                        }
                    }
                    Toast.makeText(getApplicationContext(), "Modificado", Toast.LENGTH_SHORT).show();
                }else{
                    int id = MainActivity.miscontactos.size();
                    MainActivity.miscontactos.add(new Contacto(nombre, alias, id));
                    Toast.makeText(getApplicationContext(), "Agregado", Toast.LENGTH_SHORT).show();
                }

                Intent intent = new Intent(AgregarContacto.this,Actividad2.class);
                startActivity(intent);
            }
        });

    }
}
