package com.ashiquehira.recyclerviewbestpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        String userid = intent.getStringExtra("uid");
        Toast.makeText(this, userid, Toast.LENGTH_LONG).show();
    }
}
