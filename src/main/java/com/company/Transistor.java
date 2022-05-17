package com.company;
/**
 * This class represents the transistor as a device since it inherits from the device class
 * and sets its corresponding default value, minimum and maximum as well as an extra
 * data member called type which indicates whether it was a nmos / pmos / cmos
 * @author Abdelrahman Hamdy
 * @version 1.0.0 May 17, 2022
 */
class Transistor extends Device {

    private String type;
    /**
     * Non Default Transistor Constructor
     * @param Name - Unique Name
     * @param defaultVal -Default Value
     * @param Min - Minimum Value
     * @param Max - Maximum Value
     * @param type - Transistor type (nmos / pmos)
     */
    Transistor(String Name, double defaultVal, double Min, double Max, String type) {
        super(Name, defaultVal, Min, Max);
        setType(type);
    }

    /**
     * Default Transistor Constructor
     */
    Transistor() {
        super();
    }

    /**
     * Gets the transistor type
     * @return type as string
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the transistor type
     * @param type - Type
     */
    public void setType(String type) {
        this.type = type;
    }
    /**
     * Print function overriden from the device class and the parent function is called
     * after the device type as transistor is set
     */
    @Override
    public void print() {
        System.out.println("Device Type: " + type);
        super.print();
    }
}