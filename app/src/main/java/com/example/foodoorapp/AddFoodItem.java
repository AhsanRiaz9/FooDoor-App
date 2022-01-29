package com.example.foodoorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.foodoorapp.Models.Food;
import com.google.firebase.database.FirebaseDatabase;

public class AddFoodItem extends AppCompatActivity {

    Button registerFoodBtn;
    TextView foodNameInput;
    TextView foodCategoryInput;
    TextView foodPriceInput;
    TextView foodQuantityInput;
    private FirebaseDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_food_item);
        db = FirebaseDatabase.getInstance();
        registerFoodBtn = findViewById(R.id.registerFoodBtn);
        foodNameInput = findViewById(R.id.foodNameInput);
        foodCategoryInput = findViewById(R.id.foodCategoryInput);
        foodPriceInput = findViewById(R.id.foodPriceInput);
        foodQuantityInput = findViewById(R.id.foodQuantityInput);
        registerFoodBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    String foodName = foodNameInput.getText().toString();
                    String foodCategory = foodCategoryInput.getText().toString();
                    double foodPrice = Double.parseDouble(foodPriceInput.getText().toString());
                    int foodQuantity = Integer.parseInt(foodQuantityInput.getText().toString());
                    Food food = new Food(foodName,foodCategory,foodPrice,foodQuantity);
                    if(isValidFoodDetail(food)==true)
                    {
                        String key = db.getReference("Food").push().getKey();
                        db.getReference().child("Food").child(key).setValue(food);
                        clearFormData();
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "Invalid Food Detail", Toast.LENGTH_SHORT).show();
                    }

                }
                catch (Exception e)
                {
                    Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
    private boolean isValidFoodDetail(Food fd)
    {
        return true;
    }
    private void clearFormData()
    {
        foodNameInput.setText("");
        foodCategoryInput.setText("");
        foodPriceInput.setText("");
        foodQuantityInput.setText("");
    }
}