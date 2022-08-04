package com.example.androidrucafe;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Order class implements Customizable and represents
 * your order.
 *
 * @author Parth Rana, Sahil Patel
 */
public class Order implements Customizable{

    /**
     * Static final variable for the sales tax
     */
    public static final double SALES_TAX = 0.06625;

    /**
     * ArrayList of MenuItem for the order
     */
    protected ArrayList<MenuItem> order_list;

    DecimalFormat money_format = new DecimalFormat("0.00");

    private int order_number;
    private double subtotal;
    private double sales_tax;
    private double total;

    /**
     * Constructor to create Order object
     */
    public Order(){
        order_list = new ArrayList<>();
        this.order_number = 1;
    }

    /**
     * Getter method to get the size of the order
     *
     * @return the size of the order
     */
    public int getOrderSize(){
        return order_list.size();
    }

    /**
     * Getter method to get the menu item of the order
     *
     * @param index_of_item the index of the item we are trying to get
     * @return the String associated with the menu item
     */
    public String getMenuItem(int index_of_item){
        return order_list.get(index_of_item).toString();
    }

    /**
     * Getter method to get the subtotal of the order
     *
     * @return the subtotal of the order
     */
    public double getSubtotal(){
        return subtotal;
    }

    /**
     * Getter method to get the sales tax of the order
     *
     * @return the sales tax of the order
     */
    public double getSalesTax(){
        this.sales_tax = subtotal * SALES_TAX;
        return sales_tax;
    }

    /**
     * Getter method to get the total of the order
     *
     * @return the total of the order
     */
    public double getTotal(){
        total = sales_tax + subtotal;
        return total;
    }

    /**
     * Method to find the given menu item within the order
     *
     * @param item the menu item we need to find
     * @return the index of the menu item if found, otherwise return -1
     */
    public int find(String item){
        for(int i = 0; i < order_list.size(); i++){
            if(item.equals(order_list.get(i).toString())){
                return i;
            }
        }
        return -1;
    }

    /**
     * Setter method to set the order number
     *
     * @param order_number the order number we are setting
     */
    public void setOrderNumber(int order_number) {
        this.order_number = order_number;
    }

    /**
     * Getter method to get the order number
     *
     * @return the order number
     */
    public int getOrderNumber() {
        return order_number;
    }

    /**
     * Method to add a menu item inside the order
     *
     * @param obj the object we are adding
     * @return true if the menu item is added, otherwise false
     */
    @Override
    public boolean add(Object obj) {
        if(obj == null){
            return false;
        }
        MenuItem menuItem = (MenuItem) obj;
        order_list.add(menuItem);
        this.subtotal += menuItem.price;
        return true;
    }

    /**
     * Method to remove a menu item inside the order
     *
     * @param obj the object we are removing
     * @return true if menu item is removed, otherwise false
     */
    @Override
    public boolean remove(Object obj) {
        if(obj == null || order_list.isEmpty()){
            return false;
        }
        else{
            this.subtotal -= order_list.get(order_list.indexOf(obj)).price;
            order_list.remove(obj);
            return true;
        }
    }

    /**
     * Method to return order information in specific format
     *
     * @return the string of order
     */
    @Override
    public String toString() {
        return "Order{" +
                "order number=" + order_number +
                ", total=" + money_format.format(total) +
                "\n\torder_list=" + order_list +
                '}';
    }
}
