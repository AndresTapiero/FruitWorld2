package com.example.andrestapiero.lab3fruitworl2.adapters;


import android.app.Activity;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.andrestapiero.lab3fruitworl2.R;
import com.example.andrestapiero.lab3fruitworl2.models.Fruit;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {


    private List<Fruit> fruits;
    private Activity activity;
    private int layout;
    private OnItemClickListener listener;


    public  MyAdapter (List<Fruit> fruits, int layout, Activity activity, OnItemClickListener listener ){
        this.fruits = fruits;
        this.layout = layout;
        this.activity = activity;
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder (ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(activity).inflate(layout,parent,false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    holder.bind(fruits.get(position) ,listener);
    }

    @Override
    public int getItemCount() {
        //Número de items que vamos a tener
        return fruits.size();
    }


    public class ViewHolder extends  RecyclerView.ViewHolder implements View.OnCreateContextMenuListener, MenuItem.OnMenuItemClickListener{

        public TextView textViewName;
        public ImageView imageViewFruit;
        public TextView textViewDescription;
        public TextView textViewCounte;



        public ViewHolder(View itemView){
            super(itemView);
            textViewName = itemView.findViewById(R.id.nameFruit);
            imageViewFruit = itemView.findViewById(R.id.imageViewFruit);
            textViewDescription = itemView.findViewById(R.id.textViewDescription);
            textViewCounte = itemView.findViewById(R.id.textViewCount);
            // añadimos al view listener para el context menu, en vez de hacerlo en
            //el activity mediante el metodo registerForContextMenu
            itemView.setOnCreateContextMenuListener(this);

        }

        public void bind (final Fruit fruit, final OnItemClickListener listener){
            textViewName.setText(fruit.getName());
            textViewDescription.setText(fruit.getDescription());
            textViewCounte.setText(fruit.getCount()+"");

            //Logica para limitar la cantidad en cada fruta
            if (fruit.getCount()==Fruit.LIMIT_QUANTITY){
                textViewCounte.setTextColor(ContextCompat.getColor(activity, R.color.ColorAlert));
                textViewCounte.setTypeface(null, Typeface.BOLD);
            }else {
                textViewCounte.setTextColor(ContextCompat.getColor(activity, R.color.ColorDefault));
                textViewCounte.setTypeface(null, Typeface.NORMAL);
            }

            Picasso.get().load(fruit.getPoster()).fit().into(imageViewFruit);

            //imageViewFruit.setImageResource(fruit.getPoster());

            this.imageViewFruit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(fruit,getAdapterPosition());
                }
            });

        }

         public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo menuInfo) {
        // Recogemos la posicion con el metodo getAdapterposition
            Fruit fruitSelected = fruits.get(this.getAdapterPosition());
            //Establecemos titulo e icono para cada elemento, mirando sus propiedades
            contextMenu.setHeaderTitle(fruitSelected.getName());
            contextMenu.setHeaderIcon(fruitSelected.getPoster());

            //Inflamos el menu
            MenuInflater inflater = activity.getMenuInflater();
            inflater.inflate(R.menu.actions, contextMenu);

            //condición para poder añadir los onMenuItemClick a cada elemento
             for (int i = 0; i < contextMenu.size(); i++)
                 contextMenu.getItem(i).setOnMenuItemClickListener(this);

    }

        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()){
                case R.id.delete_item:
                    fruits.remove(getAdapterPosition());
                    notifyItemRemoved(getAdapterPosition());
                    return  true;

                case R.id.reset_quantity:
                    fruits.get(getAdapterPosition()).resetQuantity();
                    notifyItemChanged(getAdapterPosition());
                    return true;
                default:
                    return false;
            }
        }
    }
    //Implemento mi propio OnClickListener
    public interface  OnItemClickListener {
        void onItemClick(Fruit fruit, int position);
    }

}
