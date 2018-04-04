package com.schubi.felix.justjava;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.TextView;

import static android.content.ContentValues.TAG;


public class MainActivity extends Activity implements View.OnClickListener {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button mBtn1 = (Button) findViewById(R.id.mBtn1);
        mBtn1.setOnClickListener(this);
    }
//*******************************************************/////
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.first_menu, menu);
        return true;
    }

    @Override
    public void onClick(View v) {
        Log.i("clicks","You Clicked B1");
        Intent i=new Intent(MainActivity.this, MainActivity2.class);
        saveName();
        startActivity(i);

    }

    ////******************//////////////////////////




    int numberOfC = 2;
    int price;
/*
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

        // Preis aktualisieren?
        refresh();

    };



    private void refresh () {
        displayPrice(this.numberOfC);
    //    displayMessage();
    }
*/


    private void displayMessage() {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view2);
         String Message = "Name: Felix \nAnzahl: " + numberOfC + "\nAdded: " + wantMore + "\nTotal: " + numberOfC*price + " Euro\nDanke!";
      // String Message = "Geht";
        priceTextView.setText(Message);
    }



    private void NodisplayMessage() {
        TextView priceTextView = (TextView) findViewById(R.id.price_text);
        priceTextView.setText("");
    }

    boolean wantMore;

    public void CHECKBOX (View view) {
        boolean checked = ((CheckBox) view).isChecked();
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
            price = 3;
        } else {
           price = 2 ;
        }
        String euroPrice = number * price + " Euro";
        priceView.setText(euroPrice);
    }

    private void displayPrice() {
        TextView priceView = (TextView) findViewById(R.id.price_view);
        priceView.setText("");
    }

   public void saveName (){

       EditText edTextName = (EditText) findViewById(R.id.editText);

       edTextName.setInputType(InputType.TYPE_CLASS_TEXT);

       String StringName = edTextName.getText().toString();

       bindStringName = StringName;
   }

   String bindStringName;

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

    public void logDebug(){
        Log.d(TAG, "logDebug: Das ist ein Test  ");
      //  displayMessage();
    }

}

