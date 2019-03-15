package com.example.mealcalculator;

public class Meal {
    String mealID;
    String restaurant;
    String total;
    String date;


    Meal(String mealID, String restaurant, String total, String date)
    {
        this.restaurant = restaurant;
        this.mealID = mealID;
        this.total = total;
        this.date = date;
    }

    public String getRestaurant() {return restaurant;}
    public String getMealID() {
        return mealID;
    }

    public String getTotal() {
        return total;
    }

    public String getDate() {
        return date;
    }
}
