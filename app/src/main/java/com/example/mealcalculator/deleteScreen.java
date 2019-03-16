package com.example.mealcalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class deleteScreen extends AppCompatActivity {

    DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
    Button deleteButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_screen);

        deleteButton = findViewById(R.id.deleteBTN);

        deleteButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                Toast.makeText(getApplicationContext(), "Delete is Clicked", Toast.LENGTH_LONG);
//                deleteButton.setText("Hello");
//                deleteEntry();
            }
        });
    }



    void homeButton(View view)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


    void deleteEntry()
    {
        String restaurantText = findViewById(R.id.restaurantText).toString();
        Query mealsQuery = ref.child("meals").orderByChild("restaurant").equalTo(restaurantText);

        mealsQuery.addListenerForSingleValueEvent(new ValueEventListener()
        {
            public void onDataChange(DataSnapshot dataSnapshot)
            {
                for(DataSnapshot mealSnapshot: dataSnapshot.getChildren())
                {
                    mealSnapshot.getRef().removeValue();
                }
            }

            public void onCancelled(DatabaseError databaseError)
            {

            }
        });
    }

}
