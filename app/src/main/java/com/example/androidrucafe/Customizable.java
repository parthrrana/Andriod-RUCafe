package com.example.androidrucafe;

/**
 * Customizable is an interface class that has an
 * add and a remove method
 *
 * @author Parth Rana, Sahil Patel
 */
public interface Customizable {

    /**
     * Method add to be implemented by other classes.
     *
     * @param obj the object to be added
     * @return true if object is added, false otherwise
     */
    boolean add(Object obj);

    /**
     * Method remove to be implemented by other classess.
     *
     * @param obj the object to be removed
     * @return true if object is removed, false otherwise
     */
    boolean remove(Object obj);
}

