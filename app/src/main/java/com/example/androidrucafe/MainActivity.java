package com.example.androidrucafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * MainActivity is the class for the main menu of the
 * AndroidRUCafe
 *
 * @author Parth Rana, Sahil Patel
 */
public class MainActivity extends AppCompatActivity {

    static Order order = new Order();
    static StoreOrders storeOrders = new StoreOrders();

    /**
     * Method that creates the activity main view
     *
     * @param savedInstanceState the saved instance state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Method to launch the "Order Donut"
     *
     * @param view the view object that is invoked when clicking
     *             the "Order Donut" button
     */
    public void donutClick(View view){
        Intent intent = new Intent(this, DonutActivity.class);
        this.startActivity(intent);
    }

    /**
     * Method to launch the "Order Coffee"
     *
     * @param view the view object that is invoked when clicking
     *             the "Order Coffee" button
     */
    public void coffeeClick(View view){
        Intent intent = new Intent(this, CoffeeActivity.class);
        this.startActivity(intent);
    }

    /**
     * Method to launch the "Your Order"
     *
     * @param view the view object that is invoked when clicking
     *             the "Your Order" button
     */
    public void yourOrder(View view){
        Intent intent = new Intent(this, OrderActivity.class);
        this.startActivity(intent);
    }

    /**
     * Method to launch the "Store Order"
     *
     * @param view the view object that is invoked when clicking
     *             the "Store Order" button
     */
    public void storeOrder(View view){
        Intent intent = new Intent(this, StoreOrdersActivity.class);
        this.startActivity(intent);
    }



}