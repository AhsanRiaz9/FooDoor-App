package com.example.foodoorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class UserHomeScreen extends AppCompatActivity {

    ListView listView;
    ArrayList<String> foodNameArr;
    ArrayList<String> foodCateogryArr;
    ArrayList<String> foodPricecArr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_home_screen);
        listView = findViewById(R.id.listView);
        foodNameArr = new ArrayList<>();
        foodCateogryArr = new ArrayList<>();
        foodPricecArr = new ArrayList<>();
        // item 1
        foodNameArr.add("Burger");
        foodCateogryArr.add("Fast Food");
        foodPricecArr.add("400 Rs");
        // item 2
        foodNameArr.add("Zinger Burger");
        foodCateogryArr.add("Fast Food");
        foodPricecArr.add("600 Rs");
        // item 3
        foodNameArr.add("Biryani");
        foodCateogryArr.add("Home Food");
        foodPricecArr.add("300 Rs");
        MyAdapter adapter = new MyAdapter(this,foodNameArr, foodCateogryArr, foodPricecArr);
        listView.setAdapter(adapter);
    }
}