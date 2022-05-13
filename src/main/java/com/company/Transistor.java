package com.company;

class Transistor extends Device {

    Transistor(String Name, double defaultVal, double Min, double Max) {
        super(Name, defaultVal, Min, Max);
    }

    Transistor() {
        super();
    }

    @Override
    public void print() {
        System.out.println("----> Device Type: Transistor");
        super.print();
    }
}