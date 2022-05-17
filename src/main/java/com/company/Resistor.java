package com.company;

/**
 * This class represents the resistor as a device since it inherits from the device class
 * and sets its corresponding default value, minimum and maximum
 * @author Abdelrahman Hamdy
 * @version 1.0.0 May 17, 2022
 */
class Resistor extends Device {

    /**
     * Non Default Resistor Constructor
     * @param Name - Unique Name
     * @param defaultVal -Default Value
     * @param Min - Minimum Value
     * @param Max - Maximum Value
     */
    Resistor(String Name, double defaultVal, double Min, double Max) {
        super(Name, defaultVal, Min, Max);
    }

    /**
     * Default Resistor Constructor
     */
    Resistor() {
        super();
    }

    /**
     * Print function overriden from the device class and the parent function is called
     * after the device type as resistance is set
     */
    @Override
    public void print() {
        System.out.println("Device Type: Resistance");
        super.print();
    }
}
