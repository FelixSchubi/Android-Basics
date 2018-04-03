package com.schubi.felix.justjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int numberOfC = 2;

    public void submitOrder(View view) {
        EditText text = (EditText) findViewById(R.id.edit_text);
        String str = text.getText().toString();
        String forFree = str;
        displayPrice();
        if (str.equals("")) {
            displayMessage();
        } else {
            displayMessageForFree(forFree);
        };
    };

    private void displayMessage() {
        TextView priceTextView = (TextView) findViewById(R.id.price_text);
        String Message = "Name: Felix \nAnzahl: " + numberOfC + "\nAdded: " + wantMore + "\nTotal: " + numberOfC*2 + " Euro\nDanke!";
        priceTextView.setText(Message);
    }



    private void NodisplayMessage() {
        TextView priceTextView = (TextView) findViewById(R.id.price_text);
        priceTextView.setText("");
    }


    public void CHECKBOX (View view) {

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
        String euroPrice = number * 2 + " Euro";
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