package com.company;

/**
 * Class device is within Component but does not inherit from it.
 * It is what the component looks like from a numbers wise
 * @author Abdelrahman Hamdy
 * @version 1.0.0 May 17, 2022
 */
class Device {

    protected String name;
    protected double defaultValue;
    protected double min;
    protected double max;

    /**
     * Non Default constructor to set the device parameters
     * @param Name - Unique name that identifies each device uniquely
     * @param defaultVal - Default Value
     * @param Min - Minimum Value
     * @param Max - Maximum Value
     */
    Device(String Name, double defaultVal, double Min, double Max) {
        setName(Name);
        setDefaultValue(defaultVal);
        setMin(Min);
        setMax(Max);
    }

    /**
     * Default Device Constructor
     */
    Device() {
        setName("");
        setDefaultValue(0.0);
        setMin(0.0);
        setMax(0.0);
    }

    // Setters

    /**
     * Set Device Name
     * @param name - Unique Name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Set Default Value
     * @param defaultValue - Default Value
     */
    public void setDefaultValue(double defaultValue) {
        this.defaultValue = defaultValue;
    }

    /**
     * Set Minimum Value
     * @param min - Minimum Value
     */
    public void setMin(double min) {
        this.min = min;
    }

    /**
     * Set Maximum Value
     * @param max - Maximum Value
     */
    public void setMax(double max) {
        this.max = max;
    }

    // Getters

    /**
     * Get the unique name for each device
     * @return - String(Name)
     */
    public String getName() {
        return name;
    }

    /**
     * Get the Minimum Value
     * @return double(Min)
     */
    public double getMin() {
        return min;
    }

    /**
     * Get the Maximum Value
     * @return double(Max)
     */
    public double getMax() {
        return max;
    }

    /**
     * Get Default Value
     * @return double(Default) for each device
     */
    public double getDefaultValue() {
        return defaultValue;
    }

    // Print as a virtual Function (Polymorphism)

    /**
     * Print function that is overriden by the device's children.
     * It is used to print the required details when querying the topology
     */
    public void print() {
        System.out.println("\tDevice Name: " + name);
        System.out.println("\tDefault = " + defaultValue);
        System.out.println("\tMin = " + min);
        System.out.println("\tMax = " + max);
    }
}
