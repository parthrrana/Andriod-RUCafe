package com.example.androidrucafe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

/**
 * DonutActivity class is the activity class where the RecyclerView is used
 *
 * @author Parth Rana, Sahil Patel
 */
public class DonutActivity extends AppCompatActivity {

    /**
     * Static final variable for the YEAST_DONUT_PRICE
     */
    public static final String YEAST_DONUT_PRICE = "1.59";

    /**
     * Static final variable for the CAKE_DONUT_PRICE
     */
    public static final String CAKE_DONUT_PRICE = "1.79";

    /**
     * Static final variable for the DONUT_HOLES_PRICE
     */
    public static final String DONUT_HOLES_PRICE = "0.39";

    private ArrayList<Donut> donuts = new ArrayList<>();

    private int [] itemIamges = {R.drawable.jelly, R.drawable.glazed, R.drawable.chocolatefrosted,
            R.drawable.lemonfilled, R.drawable.sugar, R.drawable.strawberryfrosted,
            R.drawable.cinnamonsugar, R.drawable.oldfashion, R.drawable.blueberry,
            R.drawable.glazedholes, R.drawable.jellyholes, R.drawable.cinnamonsugarholes};

    /**
     * Method to get the references of all instances of Views defined in the layout file,
     * set up the list of items to be display in the RecyclerView.
     * @param savedInstanceState the saved instance state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donut);
        setTitle("Order Donut");
        RecyclerView rcview = findViewById(R.id.rcView_donut);
        setupDonutItems();
        DonutFlavorAdapter adapter = new DonutFlavorAdapter(this, donuts);
        rcview.setAdapter(adapter);
        rcview.setLayoutManager(new LinearLayoutManager(this));

    }

    /**
     * Helper method to set up the data
     */
    private void setupDonutItems(){
        String[] donutFlavors = getResources().getStringArray(R.array.donutFlavors);

        for(int i = 0; i < donutFlavors.length; i++){
            if(i < 6){
                donuts.add(new Donut(donutFlavors[i], itemIamges[i], YEAST_DONUT_PRICE));
            }
            else if(i < 9){
                donuts.add(new Donut(donutFlavors[i], itemIamges[i], CAKE_DONUT_PRICE));
            }
            else{
                donuts.add(new Donut(donutFlavors[i], itemIamges[i], DONUT_HOLES_PRICE));
            }
        }
    }
}