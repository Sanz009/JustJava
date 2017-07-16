package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    int numbero = 1;

    /**
     * Calculates the price of the order based on the current quantity.
     *
     * @return the price
     */

    public String createOrderSummary(int price, boolean rr1, boolean rr2,Editable name) {
        String priceMessage = "Name:"+name+" \n";
        priceMessage = priceMessage + "Add Whipped Cream ?:" + rr1;
        priceMessage = priceMessage + "\nAdd Chocolate ?:" + rr2;
        priceMessage = priceMessage + "\nQuantity: " + numbero;
        priceMessage = priceMessage + "\nTotal :" + price + "\nThankYou!";
        return priceMessage;

    }

    private int calculatePrice(int quantity,boolean r1,boolean r2) {
        int base=5;
        if(r1)
        {
            base+=2;
        }
        if(r2)
        {
            base +=1;

        }
        int price = quantity * base;
        return price;
    }

    public void submitOrder(View view) {
        CheckBox ch1 = (CheckBox) findViewById(R.id.notify_me_checkbox1);
        boolean r1 = ch1.isChecked();
        CheckBox ch2 = (CheckBox) findViewById(R.id.notify_me_checkbox2);
        boolean r2 = ch2.isChecked();
        EditText txt1=(EditText) findViewById(R.id.edit_text_view);
        Editable name=txt1.getText();
        int price = calculatePrice(numbero,r1,r2);
        String priceMessage = createOrderSummary(price, r1, r2,name);
        displayMessage(priceMessage);




    }

    public void increment(View view) {
        if(numbero<10)
            numbero = numbero + 1;
        displayQuantity(numbero);


    }

    public void decrement(View view) {
        if (numbero > 1&&numbero<= 10)
            numbero = numbero - 1;
        displayQuantity(numbero);


    }


    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
        ;

    }


    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

}