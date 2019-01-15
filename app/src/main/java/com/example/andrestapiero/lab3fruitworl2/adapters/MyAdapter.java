package com.example.andrestapiero.lab3fruitworl2.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {


    private List<String> names;
    private int layout;
    private OnItemClickListener itemClickListener;

    public  MyAdapter (List<String> names, int layout, OnItemClickListener listener ){
    this.names = names;
    this.layout = layout;
    this.itemClickListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder (ViewGroup parent, int i) {

        View v = LayoutInflater.from(parent.getContext()).inflate(layout,parent,false);


        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        //Número de items que vamos a tener
        return names.size();
    }

    public static class ViewHolder extends  RecyclerView.ViewHolder{

       public TextView name;

       public ViewHolder(View itemView){
           super(itemView);
          //  this.name = itemView.findViewById(R.id.textViewName);
       }

   }
    //Implemento mi propio OnClickListener
    public interface  OnItemClickListener {
        void onItemClick(String name, int position);
    }


}
