package com.example.mealcalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class addScreen extends AppCompatActivity {

    FirebaseDatabase databaseMeals = FirebaseDatabase.getInstance();
    Meal meal;
    EditText editMealName;
    EditText editMealTotal;
    EditText dateText;
    DatabaseReference mealEntry;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_screen);
        editMealName = findViewById(R.id.editMealName);
        editMealTotal = findViewById(R.id.editMealTotal);
        dateText = findViewById(R.id.dateText);

        mealEntry = databaseMeals.getReference("meals");
    }

    public void addButton(View view)
    {

    addMeal();

    }

    public void homeButton(View view)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void addMeal(){

    String name = editMealName.getText().toString().trim();
    String total = editMealTotal.getText().toString().trim();
    String date = dateText.getText().toString().trim();

    if( TextUtils.isEmpty(name) || TextUtils.isEmpty(total) || TextUtils.isEmpty(date) ){
        Toast.makeText(this, "You must fill in all fields", Toast.LENGTH_LONG) .show();


    }else{

        String id = mealEntry.push().getKey();
        Meal meal = new Meal(id, name, total, date);

        mealEntry.child(id).setValue(meal);
        Toast.makeText(this, "Meal Added!", Toast.LENGTH_LONG) .show();
    }


    }
}
