package com.example.androidrucafe;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * OrderActivity class is the activity class for your order
 *
 * @author Parth Rana, Sahil Patel
 */
public class OrderActivity extends AppCompatActivity {

    private static final int NOT_SELECTED = -1;

    private ArrayList<String> item_list = new ArrayList<>();
    private ArrayAdapter<String> adapter;

    DecimalFormat money_format = new DecimalFormat("0.00");

    private int index = NOT_SELECTED;

    private TextView subtotal;
    private TextView salesTax;
    private TextView total;
    private ListView all_order;

    /**
     * Method that creates the activity your order view
     *
     * @param savedInstanceState the saved instance state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        setTitle("Your Order");

        subtotal = findViewById(R.id.sub_total);
        salesTax = findViewById(R.id.sales_tax);
        total = findViewById(R.id.total);
        all_order = findViewById(R.id.allOrder);


        for(int i = 0; i < MainActivity.order.getOrderSize(); i++){
            item_list.add(MainActivity.order.getMenuItem(i));
        }

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                item_list);
        all_order.setAdapter(adapter);

        subtotal.setText("$" + money_format.format(MainActivity.order.getSubtotal()));
        salesTax.setText("$" + money_format.format(MainActivity.order.getSalesTax()));
        total.setText("$" + money_format.format(MainActivity.order.getTotal()));

        all_order.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            /**
             * Method that is invoked when a list item is clicked
             *
             * @param adapterView contains the view clicked
             * @param view the view that was clicked
             * @param i the position the view is in the adapter view
             * @param l the row id representing the view
             */
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                for(int j = 0; j < all_order.getCount(); j++){
                    if(j == i){
                        index = i;
                        Toast.makeText(getApplicationContext(), "Selected item at position: "
                                + i, Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    /**
     * Method to remove a menu item for the order
     *
     * @param view the view object that is invoked when clicking
     *             the "Remove Item" button
     */
    public void removeItem(View view){
        if(all_order.getCount() == 0){
            Toast.makeText(this, "No menu item to remove", Toast.LENGTH_SHORT).show();
        }
        else if(index == NOT_SELECTED){
            Toast.makeText(this, "No menu item selected to remove", Toast.LENGTH_SHORT)
                    .show();
        }
        else{
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("Remove Item");
            alert.setMessage("Do you want to remove selected item?");
            alert.setPositiveButton("yes", new DialogInterface.OnClickListener() {

                /**
                 * Inner class method to handle the onClick event of YES
                 *
                 * @param dialogInterface the dialogInterface
                 * @param i the position
                 */
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    MenuItem item_to_remove = MainActivity.order.order_list.get(index);
                    MainActivity.order.remove(item_to_remove);
                    item_list.remove(index);
                    adapter.notifyDataSetChanged();
                    subtotal.setText("$" + money_format.format(MainActivity.order.getSubtotal()));
                    salesTax.setText("$" + money_format.format(MainActivity.order.getSalesTax()));
                    total.setText("$" + money_format.format(MainActivity.order.getTotal()));
                    index = NOT_SELECTED;
                    Toast.makeText(getApplicationContext(), "Menu item removed successfully!",
                            Toast.LENGTH_SHORT).show();
                }
            }).setNegativeButton("no", new DialogInterface.OnClickListener() {

                /**
                 * Inner class method to handle the onClick event of NO
                 *
                 * @param dialogInterface the dialogInterface
                 * @param i the position
                 */
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Toast.makeText(getApplicationContext(), "Menu item not removed!",
                            Toast.LENGTH_SHORT).show();
                }
            });
            AlertDialog dialog = alert.create();
            dialog.show();


        }
    }

    /**
     * Method to place the order and add it to the Store orders
     *
     * @param view the view object that is invoked when clicking
     *             the "Place Order" button
     */
    public void placeOrder(View view){
        if(all_order.getCount() == 0){
            Toast.makeText(this, "The order is empty", Toast.LENGTH_SHORT).show();
        }
        else{
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("Place Order");
            alert.setMessage("Do you want to place order?");
            alert.setPositiveButton("yes", new DialogInterface.OnClickListener() {

                /**
                 * Inner class method to handle the onClick event of YES
                 *
                 * @param dialogInterface the dialogInterface
                 * @param i the position
                 */
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    MainActivity.storeOrders.add(MainActivity.order);
                    item_list.clear();
                    adapter.notifyDataSetChanged();
                    subtotal.setText("$0.00");
                    salesTax.setText("$0.00");
                    total.setText("$0.00");
                    MainActivity.order = new Order();
                    Toast.makeText(getApplicationContext(), "Order placed successfully!",
                            Toast.LENGTH_SHORT).show();
                    finish();
                }
            }).setNegativeButton("no", new DialogInterface.OnClickListener() {

                /**
                 * Inner class method to handle the onClick event of NO
                 *
                 * @param dialogInterface the dialogInterface
                 * @param i the position
                 */
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Toast.makeText(getApplicationContext(), "Order is not placed!",
                            Toast.LENGTH_SHORT).show();
                }
            });
            AlertDialog dialog = alert.create();
            dialog.show();
        }
    }

}