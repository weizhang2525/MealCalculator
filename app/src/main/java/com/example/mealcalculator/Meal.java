package com.example.mealcalculator;

public class Meal {
    String mealID;
    String total;
    String date;

    Meal(String mealID, String total, String date)
    {
        this.mealID = mealID;
        this.total = total;
        this.date = date;
    }

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
