package com.company;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Component {

    private String type;
    private String id;
    private Device deviceType;
    private HashMap<String, String> netList;

    // Default Constructor

    Component() {
        setType("");
        setId("");
        setDeviceType(new Device());
        setNetList(new HashMap<>());
    }

    // Non-Default Constructor

    Component(String Type, String ID, Device device, HashMap<String, String> NetList) {
        setType(Type);
        setId(ID);
        setDeviceType(device);
        setNetList(NetList);
    }

    // Setters

    public void setType(String type) {
        this.type = type;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDeviceType(Device deviceType) {
        this.deviceType = deviceType;
    }

    public void setNetList(HashMap<String, String> netList) {
        this.netList = netList;
    }

    // Getters

    public String getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    public Device getDeviceType() {
        return deviceType;
    }

    public HashMap<String, String> getNetList() {
        return netList;
    }

    public void print() {
        System.out.println("Component: ");
        System.out.println("Type: " + deviceType);
        System.out.println("ID: " + id);
        for (Map.Entry<String, String> entry : netList.entrySet()) {
            System.out.println("\"" + entry.getKey() + "\":" + "\"" + entry.getValue() + "\"");
        }
        System.out.println("-------------------------------------");
    }

}
