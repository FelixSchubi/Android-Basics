package com.schubi.felix.justjava;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinnerTest = findViewById(R.id.spinnerView);

        ArrayAdapter <CharSequence> adapterTest = ArrayAdapter.createFromResource
                (this,R.array.spinner_A, android.R.layout.simple_spinner_item);

        spinnerTest.setAdapter(adapterTest);
    }





    int numberOfC = 2;
    int price;

    public void submitOrder(View view) {
        /*
        EditText text = (EditText) findViewById(R.id.edit_text);
        String str = text.getText().toString();
        String forFree = str;
        displayPrice();
        if (str.equals("")) {
            displayMessage();
        } else {
            displayMessageForFree(forFree);
        };
        */
        // Preis aktualisieren?
        refresh();

    };


    private void refresh () {
        displayPrice(this.numberOfC);
        displayMessage();
    }

    private void displayMessage() {
        TextView priceTextView = (TextView) findViewById(R.id.price_text);
        String Message = "Name: Felix \nAnzahl: " + numberOfC + "\nAdded: " + wantMore + "\nTotal: " + numberOfC*price + " Euro\nDanke!";
        priceTextView.setText(Message);
    }



    private void NodisplayMessage() {
        TextView priceTextView = (TextView) findViewById(R.id.price_text);
        priceTextView.setText("");
    }

    boolean wantMore;

    public void CHECKBOX (View view) {
        boolean checked = (( CheckBox) view).isChecked();
        Context context = getApplicationContext();
        switch (view.getId()) {
            case R.id.checkBox:
                if(checked){
                    wantMore = true;
                    CharSequence text = "With Whipped Cream ✔";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();

                    

                }
                else {
                    wantMore = false;
                    CharSequence text = "Without Whipped Cream  ✘";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
        }
        displayPrice(this.numberOfC);
    }


    private void displayMessageForFree(String forFree) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text);
        priceTextView.setText(forFree);
    }


    private void display(int number) {
        TextView quantity = (TextView) findViewById(R.id.quantity_view);
        quantity.setText("" + number);
    }

    private void displayPrice(int number) {
        TextView priceView = (TextView) findViewById(R.id.price_view);

        if(wantMore == true){
            price = 5;
        } else {
           price = 3;
        }
        String euroPrice = number * price + " Euro";
        priceView.setText(euroPrice);
    }

    private void displayPrice() {
        TextView priceView = (TextView) findViewById(R.id.price_view);
        priceView.setText("");
    }


    public void increment(View view) {
        numberOfC++;
        display(numberOfC);
        displayPrice(numberOfC);

        NodisplayMessage();
    }

    public void decrement(View view) {
        if (numberOfC == 0) {
            return;
        }
        numberOfC--;
        display(numberOfC);
        displayPrice(numberOfC);
        NodisplayMessage();

    }



}

