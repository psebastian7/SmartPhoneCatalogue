package com.example.cc.catalogo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Datos_item extends AppCompatActivity {
    ArrayList<Celular> lstCelular;
    TextView Nombre;
    TextView Marca;
    TextView Modelo;
    TextView Version;
    TextView Pantalla;
    ImageView Imagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_item);
        if(getIntent().getSerializableExtra("lstCelular")!=null){
            lstCelular = (ArrayList<Celular>) getIntent().getSerializableExtra("lstCelular");
        }
        Nombre = findViewById(R.id.tvNombre);
        Marca = findViewById(R.id.tvMarca);
        Modelo = findViewById(R.id.tvModelo);
        Version = findViewById(R.id.tvVersion);
        Pantalla = findViewById(R.id.tvTamano);
        Imagen = findViewById(R.id.Img);
        Intent a = getIntent();
        Bundle b = a.getExtras();

        if (b!=null){
            int pos = (Integer) b.get("posicion");
            String txtnombre = lstCelular.get(pos).getNombre().toString();
            String txtmarca = lstCelular.get(pos).getMarca().toString();
            String txtmodelo = lstCelular.get(pos).getModelo().toString();
            String txtversion = lstCelular.get(pos).getVersion().toString();
            String txttamano = lstCelular.get(pos).getPantalla().toString();
            Nombre.setText(txtnombre);
            Marca.setText(txtmarca);
            Modelo.setText(txtmodelo);
            Version.setText(txtversion);
            Pantalla.setText(txttamano);
            Imagen.setImageResource(lstCelular.get(pos).getImagen());
        }
    }
}
