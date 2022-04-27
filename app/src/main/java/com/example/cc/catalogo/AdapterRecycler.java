package com.example.cc.catalogo;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Wlady on 02-11-2017.
 */

public class AdapterRecycler extends RecyclerView.Adapter<AdapterRecycler.ViewHolderCelu> implements View.OnClickListener {

    ArrayList<Celular> lstcelular;
    private View.OnClickListener listener;

    public AdapterRecycler(ArrayList<Celular> lstcelular) {
        this.lstcelular = lstcelular;
    }

    @Override
    public ViewHolderCelu onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemlistview,null,false);

        view.setOnClickListener(this);
        return new ViewHolderCelu(view);
    }


    @Override
    public void onBindViewHolder(ViewHolderCelu holder, int position) {
        holder.nombre.setText(lstcelular.get(position).getNombre());
        holder.marca.setText(lstcelular.get(position).getMarca());
        holder.imagen.setImageResource(lstcelular.get(position).getImagen());
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }

    @Override
    public int getItemCount() {
        return lstcelular.size();
    }

    @Override
    public void onClick(View view) {
        if(listener!=null){
            listener.onClick(view);
        }
    }

    public class ViewHolderCelu extends RecyclerView.ViewHolder {

        TextView nombre, marca;
        ImageView imagen;

        public ViewHolderCelu(View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.tvNombre1);
            marca =  itemView.findViewById(R.id.tvMarca1);
            imagen = itemView.findViewById(R.id.imageView1);
        }
    }
}
