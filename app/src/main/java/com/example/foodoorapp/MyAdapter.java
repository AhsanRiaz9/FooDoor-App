package com.example.foodoorapp;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends ArrayAdapter<String> {
    private final Activity context;
    private final ArrayList<String> foodNameArr;
    private final ArrayList<String> foodCategoryArr;
    private final ArrayList<String> foodPriceArr;
    public MyAdapter(Activity context, ArrayList<String> foodNameArr, ArrayList<String> foodCategoryArr, ArrayList<String> foodPriceArr ) {
        super(context, R.layout.food_item, foodNameArr);
        this.context = context;
        this.foodNameArr = foodNameArr;
        this.foodCategoryArr = foodCategoryArr;
        this.foodPriceArr = foodPriceArr;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.food_item,null , true);
        TextView foodNameText = rowView.findViewById(R.id.foodNameText);
        TextView foodCategoryText= rowView.findViewById(R.id.foodCategoryText);
        TextView foodPriceText = rowView.findViewById(R.id.foodPriceText);
        foodNameText.setText(foodNameArr.get(position));
        foodCategoryText.setText("Category: " + foodCategoryArr.get(position));
        foodPriceText.setText("Price: " + foodPriceArr.get(position));
        return rowView;
    }
}