package com.example.mealcalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class IntroMenu extends AppCompatActivity {

    private calculateTotal total = new calculateTotal();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_menu);
    }

    public void calculateButton(View view)
    {
        EditText textNum1 = findViewById(R.id.item1);
        EditText textNum2 = findViewById(R.id.item2);
        EditText textNum3 = findViewById(R.id.item3);
        EditText textNum4 = findViewById(R.id.item4);
        EditText textNum5 = findViewById(R.id.item5);
        EditText textNum6 = findViewById(R.id.item6);
        EditText textNum7 = findViewById(R.id.item7);
        double entry1 = checkEmptyField(textNum1.getText().toString());
        double entry2 = checkEmptyField(textNum2.getText().toString());
        double entry3 = checkEmptyField(textNum3.getText().toString());
        double entry4 = checkEmptyField(textNum4.getText().toString());
        double entry5 = checkEmptyField(textNum5.getText().toString());
        double entry6 = checkEmptyField(textNum6.getText().toString());
        double entry7 = checkEmptyField(textNum7.getText().toString());
        findSumPrice(entry1);
        findSumPrice(entry2);
        findSumPrice(entry3);
        findSumPrice(entry4);
        findSumPrice(entry5);
        findSumPrice(entry6);
        findSumPrice(entry7);
        Bundle b = new Bundle();
        b.putString("total", total.toString());
        Intent intent = new Intent(this, calculateScreen.class);
        intent.putExtras(b);
        startActivity(intent);
    }

    public double checkEmptyField(String entry)
    {
        if(entry.length() == 0)
            return 0.0;
        return Double.valueOf(entry);
    }

    public void findSumPrice(double entry)
    {
        calculateTotal price = new calculateTotal(entry);
        total.addPrice(price);
    }
}

