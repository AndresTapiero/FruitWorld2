package com.example.andrestapiero.lab3fruitworl2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Fruit> fruits;
    private RecyclerView mRecyclewView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view_item);

        //Metodo que me traera todas las peliculas
        fruits = this.getAllFruits();

        mRecyclewView = findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(this);



        //Enlazo el layout Manager y adaptador directo al recyclerView
     //   mRecyclewView.setLayoutManager(mLayoutManager);
     //   mRecyclewView.setAdapter(mAdapter);
    }

    // Metodo para llamar el menu de agregar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_fruit:

            return true;
            default:
                return super.onOptionsItemSelected(item);

        }

    }

    private List<Fruit> getAllFruits() {
        return new ArrayList<Fruit>(){{
           add(new Fruit("Strawberry", R.drawable.strawberry_bg));
           add( new Fruit("Orange",R.drawable.orange_bg));

        }};
    }



}
