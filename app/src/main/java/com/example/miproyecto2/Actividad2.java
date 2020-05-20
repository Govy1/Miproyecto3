package com.example.miproyecto2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Actividad2 extends AppCompatActivity {
    TextView lbldatos;
    ListView lvmiscontactos;
    Button btnmostrar;
    private static ArrayList<Contacto> miscontactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad2);
        getSupportActionBar().hide();
        //declaracion de componentes
        lbldatos = (TextView) findViewById(R.id.lbldatos);
        lvmiscontactos = (ListView) findViewById(R.id.lvmiscontactos);
        btnmostrar = (Button) findViewById(R.id.btnmostrar);
        miscontactos = MainActivity.miscontactos;

        btnmostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyAdaptador myAdaptador = new MyAdaptador( Actividad2.this);
                lvmiscontactos.setAdapter(myAdaptador);
            }
        });

        //acciones de ListView
        lvmiscontactos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Contacto c = MainActivity.miscontactos.get(position);
                String nombre = c.getNombre();
                String alias = c.getAlias();
                String mensaje = "Nombre: "+nombre+" Alias: "+alias;
                lbldatos.setText(mensaje);
                Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_SHORT).show();


            }
        });
        lvmiscontactos.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Actividad2.this);
                builder.setTitle("Accion deseas?");
                String nombre = miscontactos.get(position).getNombre();
                String alias = miscontactos.get(position).getAlias();
                String mensaje = nombre+" "+alias;
                builder.setMessage(mensaje);
                builder.setPositiveButton("Eliminar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        miscontactos.remove(position);
                        Toast.makeText(getApplicationContext(), "Eliminado", Toast.LENGTH_SHORT).show();
                        finish();
                        Intent intent = new Intent(Actividad2.this,Actividad2.class);
                        startActivity(intent);
                    }
                });
                builder.setNegativeButton("Modifica", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        MainActivity.contactoactual = miscontactos.get(position);
                        Intent intent = new Intent(Actividad2.this,AgregarContacto.class);
                        startActivity(intent);
                    }
                });
                builder.setNeutralButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
                return false;
            }
        });




    }
    //clase adaptador
    class MyAdaptador extends BaseAdapter{
        Context context;
        MyAdaptador(Context c){
            context = c;
        }
        //cantidad de elementos
        @Override
        public int getCount() {
            return miscontactos.size();
        }

        @Override
        public Object getItem(int position) {
            return miscontactos.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater layoutInflater=(LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View fila=null;
            if (convertView==null){
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                fila = inflater.inflate(R.layout.misfilas,null);
            }else {
                fila = convertView;
            }
            TextView txtminombre = fila.findViewById(R.id.txtminombre);
            TextView txtmialias = fila.findViewById(R.id.txtmialias);
            txtminombre.setText(miscontactos.get(position).getNombre());
            txtmialias.setText(miscontactos.get(position).getAlias());
            return fila;
        }
    }
}
