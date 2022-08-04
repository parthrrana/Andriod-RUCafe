package com.example.androidrucafe;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * StoreOrdersActivity class is the activity class for
 * the store orders.
 *
 * @author Parth Rana, Sahil Patel
 */
public class StoreOrdersActivity extends AppCompatActivity {

    private static final int NOT_SELECTED = -1;

    private ArrayList<Integer> store_order_list_number = new ArrayList<>();
    private ArrayAdapter<Integer> adapter_store_order_list_number;

    private ArrayList<String> store_order_list_show = new ArrayList<>();
    private ArrayAdapter<String> adapter_store_order_list_show;

    DecimalFormat money_format = new DecimalFormat("0.00");

    private int index = NOT_SELECTED;

    private ListView all_order;
    private Spinner order_number;
    private TextView total_all;

    /**
     * Method that creates the activity store order view
     *
     * @param savedInstanceState the saved instance state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_orders);
        setTitle("Store Order");

        all_order = findViewById(R.id.storeOrder);
        order_number = findViewById(R.id.orderNumberSpinner);
        total_all = findViewById(R.id.total_all);


        for(int i = 0; i < MainActivity.storeOrders.getStoreOrderSize(); i++){
            store_order_list_number.add(MainActivity.storeOrders.getStoreOrderList().get(i).
                    getOrderNumber());
        }

        adapter_store_order_list_number = new ArrayAdapter<>(this, android.R.layout.
                simple_spinner_item, store_order_list_number);
        order_number.setAdapter(adapter_store_order_list_number);

        order_number.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            /**
             * Method that is used when an spinner item is selected
             *
             * @param adapterView contains the view clicked
             * @param view the view that was clicked
             * @param i the position the view is in the adapter view
             * @param l the row id representing the view
             */
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                index = (int) order_number.getSelectedItem();
                Order order = MainActivity.storeOrders.getOrder(index);
                store_order_list_show.clear();
                for(int k = 0; k < order.getOrderSize(); k++){
                    store_order_list_show.add(order.getMenuItem(k));
                }
                adapter_store_order_list_show = new ArrayAdapter<>(getApplicationContext(),
                        android.R.layout.simple_list_item_1, store_order_list_show);
                all_order.setAdapter(adapter_store_order_list_show);
                total_all.setText("$" + money_format.format(order.getTotal()));
            }

            /**
             * Skeleton of a method that is not going to be used
             *
             * @param adapterView contains no selected items
             */
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    /**
     * Method to cancel the entire order
     *
     * @param view the view object that is invoked when clicking
     *             the "Cancel Order" button
     */
    public void cancelOrder(View view){
        if(index == NOT_SELECTED){
            Toast.makeText(this, "No order to cancel", Toast.LENGTH_SHORT).show();
        }
        else{
            Order order = MainActivity.storeOrders.getOrder(index);
            MainActivity.storeOrders.remove(order);
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("Cancel Order");
            alert.setMessage("Do you want to cancel the order?");
            alert.setPositiveButton("yes", new DialogInterface.OnClickListener() {

                /**
                 * Inner class method to handle the onClick event of YES
                 *
                 * @param dialogInterface the dialogInterface
                 * @param i the position
                 */
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    store_order_list_number.clear();
                    adapter_store_order_list_number.notifyDataSetChanged();
                    store_order_list_show.clear();
                    adapter_store_order_list_show.notifyDataSetChanged();
                    if(MainActivity.storeOrders.getStoreOrderSize() == 0){
                        total_all.setText("$0.00");
                    }
                    else{
                        for(int k = 0; k < MainActivity.storeOrders.getStoreOrderSize(); k++){
                            store_order_list_number.add(MainActivity.storeOrders.getStoreOrderList()
                                    .get(k).getOrderNumber());
                        }
                        adapter_store_order_list_number = new ArrayAdapter<>(getApplicationContext()
                                , android.R.layout.simple_spinner_item, store_order_list_number);
                        order_number.setAdapter(adapter_store_order_list_number);
                    }
                    Toast.makeText(getApplicationContext(), "Order cancelled successfully!",
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
                    Toast.makeText(getApplicationContext(), "Order is not canceled!",
                            Toast.LENGTH_SHORT).show();
                }
            });
            AlertDialog dialog = alert.create();
            dialog.show();
        }
    }

}