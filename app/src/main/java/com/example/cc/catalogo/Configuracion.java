package com.example.cc.catalogo;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class Configuracion extends AppCompatActivity {

    RelativeLayout rlconfig;
    TextView tvtema;
    Button español;
    Button ingles;
    ArrayList<Celular> lstCelular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion);
        rlconfig = findViewById(R.id.config);
        tvtema = findViewById(R.id.tvTema);
        español = findViewById(R.id.btnespañol);
        ingles = findViewById(R.id.btningles);
        if(getIntent().getSerializableExtra("lstCelular")!=null){
            lstCelular = (ArrayList<Celular>)getIntent().getSerializableExtra("lstCelular");
        }

        español.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Locale idioma_es = new Locale("es");
                Locale.setDefault(idioma_es);
                Configuration config_es = new Configuration();
                config_es.locale = idioma_es;
                getBaseContext().getResources().updateConfiguration(config_es,getBaseContext().getResources().getDisplayMetrics());
                Intent ies = new Intent(getApplicationContext(),Configuracion.class);
                Bundle b = new Bundle();
                b.putSerializable("lstCelular",lstCelular);
                ies.putExtras(b);
                startActivity(ies);
            }
        });

        ingles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Locale idioma_en = new Locale("en");
                Locale.setDefault(idioma_en);
                Configuration config_en = new Configuration();
                config_en.locale = idioma_en;
                getBaseContext().getResources().updateConfiguration(config_en,getBaseContext().getResources().getDisplayMetrics());
                Intent ien = new Intent(getApplicationContext(),Configuracion.class);
                Bundle b = new Bundle();
                b.putSerializable("lstCelular",lstCelular);
                ien.putExtras(b);
                startActivity(ien);
            }
        });
    }

    public void onclick(View view){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(Configuracion.this);
        alertDialog.setMessage(R.string.duda);
        alertDialog.setTitle(R.string.Elimina);
        alertDialog.setIcon(android.R.drawable.ic_dialog_alert);
        alertDialog.setCancelable(false);
        alertDialog.setPositiveButton(R.string.si, new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface dialog, int which)
            {
                lstCelular.clear();
                Toast.makeText(getApplicationContext(),R.string.sib,Toast.LENGTH_LONG).show();

            }
        });
        alertDialog.setNegativeButton(R.string.no, new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface dialog, int which)
            {
                Toast.makeText(getApplicationContext(),R.string.nob,Toast.LENGTH_LONG).show();
            }
        });
        alertDialog.show();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Intent i = new Intent(Configuracion.this,MainActivity.class);
        Bundle b = new Bundle();
        b.putSerializable("lstCelular",lstCelular);
        i.putExtras(b);
        startActivity(i);

    }
}
