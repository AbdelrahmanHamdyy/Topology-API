package com.company;

class Resistor extends Device {

    Resistor(String Name, double defaultVal, double Min, double Max) {
        super(Name, defaultVal, Min, Max);
    }

    Resistor() {
        super();
    }

    @Override
    public void print() {
        System.out.println("Device Type: Resistance");
        super.print();
    }
}
