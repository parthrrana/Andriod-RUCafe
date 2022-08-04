package com.example.androidrucafe;

import java.util.ArrayList;

/**
 * StoreOrders class implements Customizable and represents
 * the stores order.
 *
 * @author Parth Rana, Sahil Patel
 */
public class StoreOrders implements Customizable{

    /**
     * ArrayList of Order for the store orders
     */
    protected ArrayList<Order> store_order_list;

    private Order order;
    private int order_number;

    /**
     * Constructor to create StoreOrders object
     */
    public StoreOrders(){
        order = new Order();
        store_order_list = new ArrayList<>();
        this.order_number = 1;
    }

    /**
     * Getter method to return the arraylist of order
     *
     * @return the arraylist of order
     */
    public ArrayList<Order> getStoreOrderList() {
        return store_order_list;
    }

    /**
     * Getter method to get Order
     *
     * @param order_num the order number
     * @return the order at a specific number
     */
    public Order getOrder(int order_num) {
        for (Order value : store_order_list) {
            if (value.getOrderNumber() == order_num) {
                return value;
            }
        }
        return null;
    }

    /**
     * Getter method to return size of order
     *
     * @return the size of order
     */
    public int getStoreOrderSize(){
        return store_order_list.size();
    }

    /**
     * Method to add order to the store order
     *
     * @param obj the object we are adding
     * @return true if added, otherwise false
     */
    @Override
    public boolean add(Object obj) {
        if(obj == null){
            return false;
        }
        order = (Order) obj;
        order.setOrderNumber(order_number);
        order_number++;
        store_order_list.add(order);
        return true;
    }

    /**
     * Method to remove order from the store order
     *
     * @param obj the object we are removing
     * @return true if removed, otherwise false
     */
    @Override
    public boolean remove(Object obj) {
        if(obj == null){
            return false;
        }
        else{
            order = (Order) obj;
            store_order_list.remove(order);
            return true;
        }
    }

    /**
     * Method to return store order's information in specific format
     *
     * @return the string of store orders
     */
    @Override
    public String toString() {
        String export_string = "";
        for (Order value : store_order_list) {
            export_string += "StoreOrder{" + value.toString() + "}.\n";
        }
        return export_string;
    }
}