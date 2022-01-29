package com.example.foodoorapp.Models;

public class Food {
    private String foodName;
    private String foodCategory;
    private double foodPrice;
    private int foodQuantity;

    public Food()
    {

    }

    public Food(String foodName, String foodCategory, double foodPrice, int foodQuantity) {
        this.foodName = foodName;
        this.foodCategory = foodCategory;
        this.foodPrice = foodPrice;
        this.foodQuantity = foodQuantity;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodCategory() {
        return foodCategory;
    }

    public void setFoodCategory(String foodCategory) {
        this.foodCategory = foodCategory;
    }

    public double getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(double foodPrice) {
        this.foodPrice = foodPrice;
    }

    public int getFoodQuantity() {
        return foodQuantity;
    }

    public void setFoodQuantity(int foodQuantity) {
        this.foodQuantity = foodQuantity;
    }
}
