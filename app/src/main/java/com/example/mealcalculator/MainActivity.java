package com.example.mealcalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    public static FirebaseDatabase dataBase = FirebaseDatabase.getInstance();
    public static DatabaseReference mealEntry;

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

    public void calculateButton(View view){
        Intent intent = new Intent(this, IntroMenu.class);
        startActivity(intent);
    }
}
