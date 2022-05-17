package com.company;

import jdk.swing.interop.SwingInterOpUtils;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class component describes each component with all its parameters and
 * is what the topology consists of as a json file
 * @author Abdelrahman Hamdy
 * @version 1.0.0 May 17, 2022
 */
public class Component {

    private String type;
    private String id;
    private Device deviceType;
    private HashMap<String, String> netList;

    // Default Constructor

    /**
     * Default Component Constructor
     */
    Component() {
        setType("");
        setId("");
        setDeviceType(new Device());
        setNetList(new HashMap<>());
    }

    // Non-Default Constructor

    /**
     * Non Default Component Constructor to set its data members
     * @param Type - Component type (resistor/nmos/etc..)
     * @param ID - Unique Component ID in each topology
     * @param device - device object to set it's default, min and max
     * @param NetList - Netlist containing all the nodes within the topology and the connection of each
     *                component between them
     */
    Component(String Type, String ID, Device device, HashMap<String, String> NetList) {
        setType(Type);
        setId(ID);
        setDeviceType(device);
        setNetList(NetList);
    }

    // Setters

    /**
     * Set Component type
     * @param type - Component Type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Set Component ID
     * @param id - Component ID
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Set device type
     * @param deviceType - Device Type
     */
    public void setDeviceType(Device deviceType) {
        this.deviceType = deviceType;
    }

    /**
     * Set Netlist nodes
     * @param netList - Netlist containing all the node connections
     */
    public void setNetList(HashMap<String, String> netList) {
        this.netList = netList;
    }

    // Getters

    /**
     * Get the component type
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * Get the component ID
     * @return ID
     */
    public String getId() {
        return id;
    }

    /**
     * Get device type
     * @return device type
     */
    public Device getDeviceType() {
        return deviceType;
    }

    /**
     * Get the whole netlist
     * @return Netlist map
     */
    public HashMap<String, String> getNetList() {
        return netList;
    }

    /**
     * Print function used for output from the API's functionalities
     */
    public void print() {
        System.out.println("Component: ");
        System.out.println("ID: " + id);
        deviceType.print();
        System.out.println("Netlist: ");
        for (Map.Entry<String, String> entry : netList.entrySet()) {
            System.out.println("\"" + entry.getKey() + "\": " + "\"" + entry.getValue() + "\"");
        }
        System.out.println();
    }

}
