package com.example.mealcalculator;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class searchScreen extends AppCompatActivity {

    private FirebaseDatabase database;
    private DatabaseReference myRef;
    private ChildEventListener childEventListener;

    private ArrayList<Meal> mealList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_screen);

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("meals");

        mealList = new ArrayList<Meal>();
//
//        childEventListener = new ChildEventListener() {
//            @Override
//            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//                mealList.add(dataSnapshot.getValue(Meal.class));
//                // every time a meal is added to database, it is
//                // also added to the local array
//            }
//
//            @Override
//            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//
//            }
//
//            @Override
//            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
//
//            }
//
//            @Override
//            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        };
//
//        myRef.addChildEventListener(new childEventListener);
//
//
    }
//
//    public void search(View view){
//        EditText text = (EditText) findViewById(R.id.editText3);
//
//        String search = text.getText().toString();
//        boolean found = false;
//
//        for (Meal m : mealList){
//            if(m.getRestaurant().equalsIgnoreCase(search)){
//
//                EditText restaurants = (EditText) findViewById(R.id.restaurantText);
//                restaurants.setText(m.getRestaurant());
//
//                EditText dates = (EditText) findViewById(R.id.dateText);
//                dates.setText(m.getDate());
//
//                EditText total = (EditText) findViewById(R.id.totalText);
//                total.setText(m.getTotal());
//
//                found = true;
//            }
//
//
//        }
//
//        if (!found){
//
//            Toast.makeText(this, search + "not found.", Toast.LENGTH_LONG).show();
//        }
//
//        text.setText("");
//
//    }





}
