package com.example.mealcalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addButton(View view)
    {
        Intent intent = new Intent(this, addScreen.class);
        startActivity(intent);
    }

    public void searchButton(View view)
    {
        Intent intent = new Intent(this, searchScreen.class);
        startActivity(intent);
    }

    public void deleteButton(View view)
    {
        Intent intent = new Intent(this, deleteScreen.class);
        startActivity(intent);
    }

    public void viewButton(View view)
    {
        Intent intent = new Intent(this, viewScreen.class);
        startActivity(intent);

    }
}
