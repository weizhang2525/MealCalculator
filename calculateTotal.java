package com.example.mealcalculator;

public class calculateTotal {
    private double price;


    calculateTotal(double price)
    {
        this.price = price;
    }

    calculateTotal()
    {
        this.price = 0.0;
    }

    public void addPrice(calculateTotal price2)
    {
        price += price2.getPrice();
    }

    public double getPrice()
    {
        return price;
    }


    @Override
    public String toString() {
        return Double.toString(price);
    }
}
