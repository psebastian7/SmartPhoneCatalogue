package com.example.cc.catalogo;

import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;

import java.util.ArrayList;

    public class MainActivity extends AppCompatActivity {
    ListView listacelulares;
    Button agregar;
    ArrayList<Celular> lstCelular;
    AdapterRecycler adapter;
    Button config;
    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //listacelulares = findViewById(R.id.lstview);
        lstCelular = new ArrayList<Celular>();
        rv = findViewById(R.id.rvCelus);
        if(getIntent().getSerializableExtra("lstCelular")!=null){
            lstCelular = (ArrayList<Celular>)getIntent().getSerializableExtra("lstCelular");
        }
        loadSwipe();

        rv.setLayoutManager(new LinearLayoutManager(this));


        adapter = new AdapterRecycler(lstCelular);

        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(MainActivity.this,Datos_item.class);
                Bundle b = new Bundle();
                b.putSerializable("lstCelular",lstCelular);
                a.putExtras(b);
                a.putExtra("posicion",rv.getChildAdapterPosition(view));
                startActivity(a);
            }
        });

        rv.setAdapter(adapter);




        config = (Button)findViewById(R.id.btnConfig);
        agregar = (Button)findViewById(R.id.btnAgregar);

        config.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Configuracion.class);
                Bundle b = new Bundle();
                b.putSerializable("lstCelular",lstCelular);
                i.putExtras(b);
                startActivity(i);
            }
        });

        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,Agregar.class);
                Bundle b = new Bundle();
                b.putSerializable("lstCelular",lstCelular);
                i.putExtras(b);
                startActivity(i);
            }
        });






    }

    public void loadSwipe(){
        ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT|ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return true;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                lstCelular.remove(viewHolder.getAdapterPosition());
                adapter.notifyDataSetChanged();
            }


        };
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(rv);
    }






}
