package com.ashiquehira.recyclerviewbestpractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements CardClickListner{

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
        m.setMyDisc("This is a Pineapple");
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
    // write some code here
}