package com.example.andrestapiero.lab3fruitworl2.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.example.andrestapiero.lab3fruitworl2.models.Fruit;
import com.example.andrestapiero.lab3fruitworl2.adapters.MyAdapter;
import com.example.andrestapiero.lab3fruitworl2.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Fruit> fruits;
    private RecyclerView mRecyclewView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Metodo que me traera todas las peliculas
        fruits = this.getAllFruits();
        mRecyclewView = findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(this);

        // asocio el adaptador al recyclerview que tengo en el layout
        mAdapter = new MyAdapter(fruits, R.layout.recycler_view_item,this, new MyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Fruit fruit, int position) {
                fruit.addQuantity(1);
                mAdapter.notifyItemChanged(position);
            }
        });
        //mejora de performance
        mRecyclewView.setHasFixedSize(true);
        //Efecto
        mRecyclewView.setItemAnimator(new DefaultItemAnimator());
        //Enlazo el layout Manager y adaptador directo al recyclerView
        mRecyclewView.setLayoutManager(mLayoutManager);
        mRecyclewView.setAdapter(mAdapter);
    }

    // Metodo para llamar el menu de agregar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_fruit:
            this.addFruit(fruits.size());
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private List<Fruit> getAllFruits() {
        return new ArrayList<Fruit>() {{
            add(new Fruit("Strawberry", R.drawable.strawberry_bg, "Strawberry description",0));
            add(new Fruit("Orange", R.drawable.orange_bg, "Orange description", 0));
            add(new Fruit("Apple", R.drawable.apple_bg, "Apple description", 0));
            add(new Fruit("Banana", R.drawable.banana_bg, "Banana description", 0));
            add(new Fruit("Cherry", R.drawable.cherry_bg, "Cherry description", 0));
            add(new Fruit("Pear",R.drawable.pear_bg, "Pear description", 0));
            add(new Fruit("Raspberry",R.drawable.raspberry_bg, "Raspberry description", 0));

        }};
    }

    private  void addFruit (int position){
        fruits.add(position, new Fruit("Plum "+(++counter), R.drawable.plum_bg, "Fruit added by the user", 0));
        // Notifico al adaptador el nuevo item
        mAdapter.notifyItemInserted(position);
        // Hace scroll hacia donde se posiciona el nuevo elemento
        mLayoutManager.scrollToPosition(position);
    }

}
