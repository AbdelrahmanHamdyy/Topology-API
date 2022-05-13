package com.company;

class Transistor extends Device {

    private String type;

    Transistor(String Name, double defaultVal, double Min, double Max, String type) {
        super(Name, defaultVal, Min, Max);
        setType(type);
    }

    Transistor() {
        super();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public void print() {
        System.out.println("Device Type: " + type);
        super.print();
    }
}