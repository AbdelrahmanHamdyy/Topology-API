package com.company;

class Device {

    private String name;
    private double defaultValue;
    private double min;
    private double max;

    Device(String Name, double defaultVal, double Min, double Max) {
        setName(Name);
        setDefaultValue(defaultVal);
        setMin(Min);
        setMax(Max);
    }

    Device() {
        setName("");
        setDefaultValue(0.0);
        setMin(0.0);
        setMax(0.0);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDefaultValue(double defaultValue) {
        this.defaultValue = defaultValue;
    }

    public void setMin(double min) {
        this.min = min;
    }


    public void setMax(double max) {
        this.max = max;
    }

    public String getName() {
        return name;
    }

    public double getMin() {
        return min;
    }

    public double getMax() {
        return max;
    }

    public double getDefaultValue() {
        return defaultValue;
    }

    // Print as a virtual Function

    public void print() {
        System.out.println("\tDevice Name: " + name);
        System.out.println("\tDefault = " + defaultValue);
        System.out.println("\tMin = " + min);
        System.out.println("\tMax = " + max);
    }
}
