package com.example.androidrucafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

/**
 * DonutFlavorActivity class is the activity class for the donut flavor
 *
 * @author Parth Rana, Sahil Patel
 */
public class DonutFlavorActivity extends AppCompatActivity {
    /**
     * Static final variable for the YEAST_DONUT_PRICE
     */
    public static final String YEAST_DONUT_PRICE = "1.59";

    /**
     * Static final variable for the CAKE_DONUT_PRICE
     */
    public static final String CAKE_DONUT_PRICE = "1.79";

    private Donut donut;
    DecimalFormat money_format = new DecimalFormat("0.00");

    private String [] donutQuantity = {"1", "2", "3", "4", "5"};
    private ArrayAdapter<String> adapterQuantity;

    private TextView donutFlavorTextView, totalPrice;
    private Spinner quantityDonut;


    private String priceDonut;
    private String donutOption;

    /**
     * Method that creates the activity donut flavor view
     *
     * @param savedInstanceState the saved instance state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donut_flavor);
        setTitle("Order Donut");
        donutFlavorTextView = findViewById(R.id.donutFlavor);
        Intent intent = getIntent();
        donutFlavorTextView.setText(intent.getStringExtra("ITEM"));
        donutOption = intent.getStringExtra("ITEM");
        priceDonut = intent.getStringExtra("PRICE");
        totalPrice = findViewById(R.id.donutSubTotal);
        quantityDonut = findViewById(R.id.donutQuan);
        adapterQuantity = new ArrayAdapter<>(this, androidx.appcompat.R.layout.
                support_simple_spinner_dropdown_item, donutQuantity);
        quantityDonut.setAdapter(adapterQuantity);
        quantityDonut.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

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
                if(priceDonut.equals(YEAST_DONUT_PRICE)){
                    donut = new Donut("Yeast Donuts", donutOption,
                            Integer.parseInt((String) quantityDonut.getSelectedItem()));
                }
                else if(priceDonut.equals(CAKE_DONUT_PRICE)){
                    donut = new Donut("Cake Donuts", donutOption,
                            Integer.parseInt((String) quantityDonut.getSelectedItem()));
                }
                else{
                    donut = new Donut("Donut Holes", donutOption,
                            Integer.parseInt((String) quantityDonut.getSelectedItem()));
                }
                totalPrice.setText("$" + money_format.format(donut.itemPrice()));

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
     * Method to add donut to main order
     *
     * @param view the view object that is invoked when clicking
     *             the "Add to Order" button
     */
    public void addToOrder(View view){
        MainActivity.order.add(donut);
        Toast.makeText(this, "Donut added successfully!", Toast.LENGTH_SHORT).show();
        finish();
    }

}