package com.example.cc.catalogo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class Agregar extends AppCompatActivity {

    ArrayList<Celular> lstCelular;
    Button agregar;
    EditText Nombre;
    EditText Marca;
    EditText Modelo;
    EditText Version;
    EditText Tamaño;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);

        lstCelular = new ArrayList<>();

        agregar = (Button)findViewById(R.id.BtnAgregar);

        if(getIntent().getSerializableExtra("lstCelular")!=null){
            lstCelular = (ArrayList<Celular>) getIntent().getSerializableExtra("lstCelular");
        }

    }
    public void Agregar(View view){
        Nombre = findViewById(R.id.EtNombre);
        Marca = findViewById(R.id.EtMarca);
        Modelo = findViewById(R.id.EtModelo);
        Version = findViewById(R.id.EtVersion);
        Tamaño = findViewById(R.id.EtTamano);

        String txtNombre = Nombre.getText().toString();
        String txtMarca = Marca.getText().toString();
        String txtModelo = Modelo.getText().toString();
        String txtVersion = Version.getText().toString();
        String txtTamano = Tamaño.getText().toString();


            Celular celu = new Celular(lstCelular.size() + 1, txtNombre, txtMarca, txtModelo, txtVersion, txtTamano, R.drawable.celu2);
            lstCelular.add(celu);

            Intent a = new Intent(Agregar.this, MainActivity.class);
            Bundle b = new Bundle();
            b.putSerializable("lstCelular", lstCelular);
            a.putExtras(b);
            startActivity(a);



    }

    /*public void recorrer(){
        for(int x = 0; x < lstCelular.size(); x++) {
            Toast.makeText(getApplicationContext(),lstCelular.get(x).getNombre(), Toast.LENGTH_LONG).show();
        };

    } */
    public void onBackPressed() {
        super.onBackPressed();

        Intent i = new Intent(Agregar.this,MainActivity.class);
        Bundle b = new Bundle();
        b.putSerializable("lstCelular",lstCelular);
        i.putExtras(b);
        startActivity(i);

    }

}
