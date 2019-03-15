package com.example.mealcalculator;

import java.lang.*;

public class calculateTip {
    private double total;

    calculateTip(calculateTotal finalTotal)
    {
        this.total = finalTotal.getPrice();
    }


    void calculateFiftenTip()
    {
        total += total*.15;
    }

    void calculateEightteenTip()
    {
        total += total*.18;
    }

    void calculateTwentyTip()
    {
        total += total*0.20;
    }

    void calculateCustomTip(String tip)
    {
        double t = Double.parseDouble(tip);
        t = t*0.01;
        total += total*t;
    }

    public double getTotal()
    {
        return total;
    }

    public String toString() {
        Math.round(total);
        return Double.toString(total);
    }
}
