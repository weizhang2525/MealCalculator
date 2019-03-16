package com.example.mealcalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class viewScreen extends AppCompatActivity {

    ListView listView;
    FirebaseDatabase database;
    DatabaseReference ref;
    ArrayList <String> list;
    ArrayAdapter<String> adapter;
    Meal meal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_screen);

        meal = new Meal();
        listView = findViewById(R.id.listView);
        database = FirebaseDatabase.getInstance();
        ref = database.getReference("meals");
        list = new ArrayList<>();
        adapter = new ArrayAdapter<String>(this, R.layout.meal_info, R.id.mealInfo, list);
        ref.addValueEventListener(new ValueEventListener() {
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()) {

                    meal = ds.getValue(Meal.class);
                    list.add("Restaurant: " + meal.getRestaurant() + "\nDate: " + meal.getDate() + "\nTotal: $" + meal.getTotal());
                }

                listView.setAdapter(adapter);
            }

            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }

    public void homeButton(View view)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


}
