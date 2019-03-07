package com.example.mealcalculator;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class calculateScreen extends AppCompatActivity {

    EditText input;
    private String num;
    RadioGroup radioGroup;
    RadioButton radioButton;
    TextView text;
    Bundle b;
    calculateTip finalTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_screen);
        Intent intent = getIntent();
        b =  intent.getExtras();


        text = findViewById(R.id.totalPrice);
        text.setText("TOTAL WITHOUT TIP IS: $" + b.getString("total"));

        calculateTotal total = new calculateTotal(Double.valueOf(b.getString("total")));
        finalTotal = new calculateTip(total);

        radioGroup = findViewById(R.id.radioGroup);

    }

    public void calculateButton(View view){
        //Button to calculate with tip
        int radioId = radioGroup.getCheckedRadioButtonId();
        if(radioId == -1) {
            finalTotal.calculateCustomTip(num);
        }
        else {
            radioButton = findViewById(radioId);
            final String selected = radioButton.getText().toString();


            //FIND SELECTED RADIO BUTTON

            switch (selected) {
                case ("15%"):
                    finalTotal.calculateFiftenTip();
                    break;
                case ("18%"):
                    finalTotal.calculateEightteenTip();
                    break;
                case ("20%"):
                    finalTotal.calculateTwentyTip();
                    break;
            }

        }
        text.setText("TOTAL WITH TIP IS: $"+ finalTotal.toString());

    }

    public void checkButton(View view)
    {
        int radioId = radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(radioId);
    }

    public void customTipButton(View view)
    {
        //DIALOG BTN
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Custom Tip");
        builder.setIcon(R.drawable.ic_launcher_background);
        builder.setMessage("Please enter a percent for custom tip");


        input = new EditText(this);
        input.setInputType(InputType.TYPE_CLASS_NUMBER);
        builder.setView(input);

        //SET POSITIVE BTN
        builder.setPositiveButton("Submit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                num = input.getText().toString();
                Toast.makeText(getApplicationContext(), num, Toast.LENGTH_LONG).show();

            }
        });

        //SET NEGATIVE BTN
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        //CREATE THE DIALOG
        final AlertDialog ad = builder.create();
        ad.show();
    }



}

