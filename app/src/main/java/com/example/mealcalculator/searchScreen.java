package com.example.mealcalculator;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class searchScreen extends AppCompatActivity {

    private FirebaseDatabase database;
    private DatabaseReference ref;
    Meal meal;
    EditText text;
    EditText restaurantText;
    EditText totalText;
    EditText dateText;
    String search;
    Button searchBTN;
    boolean found;
//    private ChildEventListener childEventListener;

//    private ArrayList<Meal> mealList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_screen);

        database = FirebaseDatabase.getInstance();
        ref = database.getReference("meals");
        meal = new Meal();
        text = findViewById(R.id.searchText);
        restaurantText = findViewById(R.id.restaurantText);
        totalText = findViewById(R.id.totalText);
        dateText = findViewById(R.id.dateText);
        searchBTN = findViewById(R.id.searchButton);
    }

    public void search(View view) {

        search = text.getText().toString();
        ref.addValueEventListener(new ValueEventListener()
        {
            public void onDataChange(DataSnapshot dataSnapshot)
            {
                for(DataSnapshot ds: dataSnapshot.getChildren()) {
                    meal = ds.getValue(Meal.class);
                    if (search.equalsIgnoreCase(meal.getRestaurant())) {
                        restaurantText.setText(meal.getRestaurant());
                        dateText.setText(meal.getDate());
                        totalText.setText(meal.getTotal());
                        found = true;
                        break;
                    }
                }
            }
            public void onCancelled(DatabaseError databaseError)
            {
            }
        });
        if(!found){
            Toast.makeText(this, search + " not found.", Toast.LENGTH_LONG).show();
        }
    }

    public void homeButton(View view)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
