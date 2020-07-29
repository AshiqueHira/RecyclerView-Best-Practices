package com.ashiquehira.recyclerviewbestpractice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements CardClickListner, SearchView.OnQueryTextListener {

    RecyclerView myRecyclerView;

    private ArrayList<MyModel> models = new ArrayList<>();
    private RecyclerAdapter myRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myRecyclerView = findViewById(R.id.myRecyclerView);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        myRecyclerAdapter = new RecyclerAdapter(models,this);
        myRecyclerView.setAdapter(myRecyclerAdapter);
        insertDatas();
    }

    // checking the github

    public void insertDatas(){


        MyModel m = new MyModel();
        m.setMyTitle("Apple");
        m.setMyDisc("This is an apple");
        m.setMyImg(R.drawable.apple);

        models.add(m);


        m = new MyModel();
        m.setMyTitle("Orange");
        m.setMyDisc("This is an Orange");
        m.setMyImg(R.drawable.orange);
        models.add(m);

        m = new MyModel();
        m.setMyTitle("Watermelon");
        m.setMyDisc("This is a Watermelon");
        m.setMyImg(R.drawable.watermelon);
        m.setMyuid("this is my uid");
        models.add(m);

        m = new MyModel();
        m.setMyTitle("Mango");
        m.setMyDisc("This is a Mango");
        m.setMyImg(R.drawable.mango);
        models.add(m);

        m = new MyModel();
        m.setMyTitle("Banana");
        m.setMyDisc("This is a Banana");
        m.setMyImg(R.drawable.banana);
        models.add(m);

        m = new MyModel();
        m.setMyTitle("Anar");
        m.setMyDisc("This is an Anar");
        m.setMyImg(R.drawable.anar);
        models.add(m);

        m = new MyModel();
        m.setMyTitle("Pineapple");
        m.setMyDisc("wonderful love");
        m.setMyImg(R.drawable.pinapple);
        models.add(m);

        m = new MyModel();
        m.setMyTitle("Grape");
        m.setMyDisc("This is Grape");
        m.setMyImg(R.drawable.grape);
        models.add(m);

    }

    @Override
    public void onCardClick(int position) {
        String gUid = models.get(position).getMyuid();
        Intent intent = new Intent(this,SecondActivity.class);
        intent.putExtra("uid",gUid);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        MenuItem menuItem = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setOnQueryTextListener(this);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);

        if (item.getItemId() == R.id.search) {



            return true;
        }
        return false;
    }


    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {

        String userInput = newText.toLowerCase();
        List<MyModel> newList = new ArrayList<>();

        for (MyModel name : models){
            if (name.getMyTitle().toLowerCase().contains(userInput)){
                newList.add(name);
            }else if (name.getMyDisc().toLowerCase().contains(userInput)){
                newList.add(name);
            }
        }
        myRecyclerAdapter.updateList(newList);
        return false;
    }
}