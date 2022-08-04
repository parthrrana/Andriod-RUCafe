package com.example.androidrucafe;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

/**
 * DonutFlavorAdapter class is used to to be used to instantiate an adapter for the RecyclerView.
 *
 * @author Parth Rana, Sahil Patel
 */
public class DonutFlavorAdapter extends RecyclerView.Adapter<DonutFlavorAdapter.ItemsHolder> {
    private Context context;
    private ArrayList<Donut> donuts;

    /**
     * Default constructor to create DonutFlavorAdapter
     *
     * @param context the context to inflate the layout
     * @param donuts the data of donut binding to each row of RecyclerView
     */
    public DonutFlavorAdapter(Context context, ArrayList<Donut> donuts){
        this.context = context;
        this.donuts = donuts;
    }

    /**
     * Method to inflate the row layout for the items in the RecyclerView
     *
     * @param parent the parent
     * @param viewType the viewType
     *
     * @return the ItemsHolder
     */
    @NonNull
    @Override
    public DonutFlavorAdapter.ItemsHolder onCreateViewHolder(@NonNull ViewGroup parent,
                                                             int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row_view, parent, false);

        return new ItemsHolder(view);
    }

    /**
     * Method to assign data values for each row according to their "position" (index)
     * when the item becomes visible on the screen.
     *
     * @param holder the instance of ItemsHolder
     * @param position the index of the item in the list of items
     */
    @Override
    public void onBindViewHolder(@NonNull DonutFlavorAdapter.ItemsHolder holder, int position) {
        holder.donut_flavor.setText(donuts.get(position).getDonutFlavor());
        holder.donut_price.setText(donuts.get(position).getUnitPrice());
        holder.im_item.setImageResource(donuts.get(position).getImage());
    }

    /**
     * Getter method to return the number of items in the Arraylist
     *
     * @return the number of items in the list
     */
    @Override
    public int getItemCount() {
        return donuts.size();
    }

    /**
     * Static class to get the views from the row layout file, similar to the onCreate() method
     */
    public static class ItemsHolder extends RecyclerView.ViewHolder{
        private TextView donut_flavor, donut_price;
        private ImageView im_item;
        private Button btn_add;
        private ConstraintLayout parentLayout;

        /**
         * Constructor to create ItemsHolder obeect
         *
         * @param itemView the item view
         */
        public ItemsHolder(@NonNull View itemView) {
            super(itemView);
            donut_price = itemView.findViewById(R.id.donut_price2);
            donut_flavor = itemView.findViewById(R.id.donut_fla);
            im_item = itemView.findViewById(R.id.im_item);
            parentLayout = itemView.findViewById(R.id.rowLayout);

            parentLayout.setOnClickListener(new View.OnClickListener() {
                /**
                 * Method to navigate to "DonutFlavorActivity"
                 *
                 * @param view the view
                 */
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(itemView.getContext(), DonutFlavorActivity.class);
                    intent.putExtra("ITEM", donut_flavor.getText());
                    intent.putExtra("PRICE", donut_price.getText());
                    itemView.getContext().startActivity(intent);
                }
            });
        }
    }
}