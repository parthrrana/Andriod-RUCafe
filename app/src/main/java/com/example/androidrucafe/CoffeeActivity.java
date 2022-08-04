package com.example.androidrucafe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

/**
 * CoffeeActivity class is the activity class for ordering coffee.
 *
 * @author Parth Rana, Sahil Patel
 */
public class CoffeeActivity extends AppCompatActivity{

    private Coffee coffee;
    DecimalFormat money_format = new DecimalFormat("0.00");

    private Spinner sizeSpinner;
    private Spinner quantitySpinner;
    private TextView subtotalTextView;
    private CheckBox cream;
    private CheckBox syrup;
    private CheckBox milk;
    private CheckBox caramel;
    private CheckBox whippedCream;

    private ArrayAdapter<String> adapter;
    private String [] coffeeSize = {"Short", "Tall", "Grande", "Venti"};
    private String [] coffeeQuantity = {"1", "2", "3", "4", "5"};

    /**
     * Method that creates the activity coffee view
     *
     * @param savedInstanceState the saved instance state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee);
        setTitle("Order Coffee");


        coffee = new Coffee("Short", 1);
        subtotalTextView = findViewById(R.id.subtotal);
        cream = findViewById(R.id.cream);
        syrup = findViewById(R.id.syrup);
        milk = findViewById(R.id.milk);
        caramel = findViewById(R.id.caramel);
        whippedCream = findViewById(R.id.whippedCream);

        sizeSpinner = findViewById(R.id.sizeCoffee);
        adapter = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.
                support_simple_spinner_dropdown_item, coffeeSize);
        sizeSpinner.setAdapter(adapter);

        sizeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

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
                coffee.setCoffeeSize((String) sizeSpinner.getSelectedItem());
                subtotalTextView.setText("$" + money_format.format(coffee.itemPrice()));
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

        quantitySpinner = findViewById(R.id.quantityCoffee);
        adapter = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.
                support_simple_spinner_dropdown_item, coffeeQuantity);
        quantitySpinner.setAdapter(adapter);
        quantitySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

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
                coffee.setQuantity(Integer.parseInt((String) quantitySpinner.getSelectedItem()));
                subtotalTextView.setText("$" + money_format.format(coffee.itemPrice()));
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

        subtotalTextView.setText("$" + money_format.format(coffee.itemPrice()));
    }

    /**
     * Method to add/remove and set/unset cream add-in
     *
     * @param view the view object that is invoked when clicking
     *             the cream checkbox
     */
    public void creamCheckBox(View view){
        if(cream.isChecked()){
            coffee.setCreamAddIn(true);
            coffee.add(cream.getText());
        }
        else{
            coffee.setCreamAddIn(false);
            coffee.remove(cream.getText());
        }
        subtotalTextView.setText("$" + money_format.format(coffee.itemPrice()));
    }

    /**
     * Method to add/remove and set/unset syrup add-in
     *
     * @param view the view object that is invoked when clicking
     *             the syrup checkbox
     */
    public void syrupCheckBox(View view){
        if(syrup.isChecked()){
            coffee.setSyrupAddIn(true);
            coffee.add(syrup.getText());
        }
        else{
            coffee.setSyrupAddIn(false);
            coffee.remove(syrup.getText());
        }
        subtotalTextView.setText("$" + money_format.format(coffee.itemPrice()));
    }

    /**
     * Method to add/remove and set/unset milk add-in
     *
     * @param view the view object that is invoked when clicking
     *             the milk checkbox
     */
    public void milkCheckBox(View view){
        if(milk.isChecked()){
            coffee.setMilkAddIn(true);
            coffee.add(milk.getText());
        }
        else{
            coffee.setMilkAddIn(false);
            coffee.remove(milk.getText());
        }
        subtotalTextView.setText("$" + money_format.format(coffee.itemPrice()));
    }

    /**
     * Method to add/remove and set/unset caramel add-in
     *
     * @param view the view object that is invoked when clicking
     *             the caramel checkbox
     */
    public void caramelCheckBox(View view){
        if(caramel.isChecked()){
            coffee.setCaramelAddIn(true);
            coffee.add(caramel.getText());
        }
        else{
            coffee.setCaramelAddIn(false);
            coffee.remove(caramel.getText());
        }
        subtotalTextView.setText("$" + money_format.format(coffee.itemPrice()));
    }

    /**
     * Method to add/remove and set/unset whipped cream add-in
     *
     * @param view the view object that is invoked when clicking
     *             the whipped cream checkbox
     */
    public void whippedCreamCheckBox(View view){
        if(whippedCream.isChecked()){
            coffee.setWhippedCreamAddIn(true);
            coffee.add(whippedCream.getText());
        }
        else{
            coffee.setWhippedCreamAddIn(false);
            coffee.remove(whippedCream.getText());
        }
        subtotalTextView.setText("$" + money_format.format(coffee.itemPrice()));
    }

    /**
     * Method to add the coffee to the main order
     *
     * @param view the view object that is invoked when clicking
     *             the "Add to Order" button
     */
    public void addToOrder(View view){
        MainActivity.order.add(coffee);
        coffee = new Coffee("Short", 1);

        Toast.makeText(this, "Coffee added successfully", Toast.LENGTH_SHORT).show();
        this.finish();

    }
}