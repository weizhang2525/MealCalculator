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

    Meal()
    {

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

    public void setMealID(String mealID) {
        this.mealID = mealID;
    }

    public void setRestaurant(String restaurant) {
        this.restaurant = restaurant;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
