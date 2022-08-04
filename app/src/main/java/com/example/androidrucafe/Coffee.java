package com.example.androidrucafe;

/**
 * Coffee class extends MenuItem and implements
 * Customizable. The class represents Coffee menu item.
 *
 * @author Parth Rana, Sahil Patel
 */
public class Coffee extends MenuItem implements Customizable{
    /**
     * Static final variable for SHORT_COFFEE_PRICE
     */
    public static final double SHORT_COFFEE_PRICE = 1.69;

    /**
     * Static final variable for TALL_COFFEE_PRICE
     */
    public static final double TALL_COFFEE_PRICE = 2.06;

    /**
     * Static final variable for GRANDE_COFFEE_PRICE
     */
    public static final double GRANDE_COFFEE_PRICE = 2.49;

    /**
     * Static final variable for VENTI_COFFEE_PRICE
     */
    public static final double VENTI_COFFEE_PRICE= 2.89;

    /**
     * Static final variable for ADD_IN_PRICE
     */
    public static final double ADD_IN_PRICE = 0.3;


    private String coffee_size;
    private boolean cream_add_in, syrup_add_in, milk_add_in, caramel_add_in, whipped_cream_add_in;
    private int quantity;
    private int num_add_in;

    /**
     * Constructor to create a coffee object
     *
     * @param coffee_size the size of the coffee
     * @param quantity the quantity of the coffee
     */
    public Coffee(String coffee_size, int quantity){
        super();
        this.coffee_size = coffee_size;
        this.quantity = quantity;
        num_add_in = 0;
        cream_add_in = false;
        syrup_add_in = false;
        milk_add_in = false;
        caramel_add_in = false;
        whipped_cream_add_in = false;
    }

    /**
     * Method increase or decrease number of add-ins based on
     * cream selection
     *
     * @param cream_add_in true if cream is selected, false otherwise
     */
    public void setCreamAddIn(boolean cream_add_in){
        if(cream_add_in){
            num_add_in++;
        }
        else{
            num_add_in--;
        }
    }

    /**
     * Method increase or decrease number of add-ins based on
     * syrup selection
     *
     * @param syrup_add_in true if syrup is selected, false otherwise
     */
    public void setSyrupAddIn(boolean syrup_add_in){
        if(syrup_add_in){
            num_add_in++;
        }
        else{
            num_add_in--;
        }
    }

    /**
     * Method increase or decrease number of add-ins based on
     * milk selection
     *
     * @param milk_add_in true if milk is selected, false otherwise
     */
    public void setMilkAddIn(boolean milk_add_in){
        if(milk_add_in){
            num_add_in++;
        }
        else{
            num_add_in--;
        }
    }

    /**
     * Method increase or decrease number of add-ins based on
     * caramel selection
     *
     * @param caramel_add_in true if caramel is selected, false otherwise
     */
    public void setCaramelAddIn(boolean caramel_add_in){
        if(caramel_add_in){
            num_add_in++;
        }
        else{
            num_add_in--;
        }
    }

    /**
     * Method increase or decrease number of add-ins based on
     * whipped cream selection
     *
     * @param whipped_cream_add_in true if whipped cream is selected, false otherwise
     */
    public void setWhippedCreamAddIn(boolean whipped_cream_add_in){
        if(whipped_cream_add_in){
            num_add_in++;
        }
        else{
            num_add_in--;
        }
    }

    /**
     * Setter method to set quantity of coffee
     *
     * @param quantity the quantity of coffee
     */
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    /**
     * Setter method to set the size of coffee
     *
     * @param coffee_size the coffee size
     */
    public void setCoffeeSize(String coffee_size){
        this.coffee_size = coffee_size;
    }

    /**
     * Method to add the add-ins based on selection
     *
     * @param obj the string object that represents each add-in
     * @return true if add-in is added, false otherwise
     */
    @Override
    public boolean add(Object obj){
        String add_ins = (String) obj;
        switch (add_ins){
            case "Cream":
                cream_add_in = true;
                break;
            case "Syrup":
                syrup_add_in = true;
                break;
            case "Milk":
                milk_add_in = true;
                break;
            case "Caramel":
                caramel_add_in = true;
                break;
            case "Whipped Cream":
                whipped_cream_add_in = true;
                break;
            default:
                return false;
        }
        return true;
    }

    /**
     * Method to remove the add-ins based on selection
     *
     * @param obj the string object that represents each add-in
     * @return true is add-in is removed, false otherwise
     */
    @Override
    public boolean remove(Object obj) {
        String add_ins = (String) obj;
        switch (add_ins){
            case "Cream":
                cream_add_in = false;
                break;
            case "Syrup":
                syrup_add_in = false;
                break;
            case "Milk":
                milk_add_in = false;
                break;
            case "Caramel":
                caramel_add_in = false;
                break;
            case "Whipped Cream":
                whipped_cream_add_in = false;
                break;
            default:
                return false;
        }
        return true;
    }

    /**
     * Method to calculate price of the coffee
     *
     * @return the price of the coffee
     */
    public double itemPrice(){
        switch (coffee_size){
            case "Short":
                price = (SHORT_COFFEE_PRICE + (num_add_in * ADD_IN_PRICE)) * quantity ;
                break;
            case "Tall":
                price = (TALL_COFFEE_PRICE + (num_add_in * ADD_IN_PRICE))* quantity;
                break;
            case "Grande":
                price = (GRANDE_COFFEE_PRICE + (num_add_in * ADD_IN_PRICE))* quantity;
                break;
            default:
                price = (VENTI_COFFEE_PRICE + (num_add_in * ADD_IN_PRICE)) * quantity;
                break;
        }
        return price;
    }

    /**
     * Method to return coffee information in given format
     *
     * @return string in given format
     */
    @Override
    public String toString() {
        String coffee_string = "Coffee(" + this.quantity + ") " + coffee_size;
        if(num_add_in != 0) {
            coffee_string += "[";
            if (cream_add_in) {
                coffee_string += "Cream,";
            }
            if (syrup_add_in) {
                coffee_string += "Syrup,";
            }
            if (milk_add_in) {
                coffee_string += "Milk,";
            }
            if (caramel_add_in) {
                coffee_string += "Caramel,";
            }
            if (whipped_cream_add_in){
                coffee_string += "Whipped Cream,";
            }
            coffee_string = coffee_string.substring(0,coffee_string.length()-1);
            coffee_string += "]";
        }
        return coffee_string;
    }
}