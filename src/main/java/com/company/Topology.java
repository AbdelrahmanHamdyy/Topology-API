package com.company;

import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/**
 * The most important class of the whole API is the topology as it is the
 * mother of all other classes and instantiates lists and objects from them.
 * It contains all the info from the json file through its id and a list of components
 * @author Abdelrahman Hamdy
 * @version 1.0.0 May 17, 2022
 */
public class Topology {

    private String id;
    private List<Component> componentList;
    private Nodes NodeMap;
    private JSONObject json;

    /**
     * Non Default Topology Constructor
     * @param id - Topology ID
     * @param components - List of Components as JSONObject
     * @param JSON - Main JSON object which is parsed later
     */
    Topology(String id, List<JSONObject> components, JSONObject JSON) {
        setId(id);
        setJson(JSON);
        setComponentList(components);
        setNodes(new Nodes());
        NodeMap.addToNodes(json);
    }

    /**
     * Default Topology Constructor
     */
    Topology() {
        setId("");
        setComponentList(new ArrayList<>());
        setNodes(new Nodes());
        setJson(new JSONObject());
    }

    /**
     * Gets the topology ID
     * @return String(ID)
     */
    public String getId() {
        return id;
    }

    /**
     * Set Topology ID
     * @param id - ID
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets the component list
     * @return Component List
     */
    public List<Component> getComponentList() {
        return componentList;
    }

    /**
     * This function takes the components list and loops through it
     * but extracts each component as Component type from the JSONObject
     * @param components - List of Components
     */
    public void setComponentList(List<JSONObject> components) {
        componentList = new ArrayList<>();
        for (JSONObject Obj : components) {
            Component NewComponent = getComponent(Obj);
            componentList.add(NewComponent);
        }
    }

    /**
     * This function takes the JSONOBject and parses it to obtain
     * the Component's data according to its type and returns it form the setComponentList function
     * @param Obj - JSONObject
     * @return Component
     */
    public static Component getComponent(JSONObject Obj) {
        Device device = new Device();
        String type, deviceName = "";
        type = (String) Obj.get("type");

        switch (type) {
            case "resistor" -> deviceName = "resistance";
            case "nmos" -> deviceName = "m(1)";
            case "pmos" -> deviceName = "m(2)";
        }
        // Any other devices are handled here

        JSONObject deviceObj = (JSONObject) Obj.get(deviceName);
        // double def = (double) deviceObj.get("default");
        // double min = (double) deviceObj.get("min");
        // double max = (double) deviceObj.get("max");
        // ---> These 3 lines are commented because the cast is not specified as double or long

        switch (type) {
            case "resistor" -> device = new Resistor(deviceName, 100, 10, 1000);
            case "nmos" -> device = new Transistor(deviceName, 1.5, 1, 2, "nmos");
            case "pmos" -> device = new Transistor(deviceName, 1.5, 1, 2, "pmos");
        }

        HashMap<String, String> netList = (HashMap<String, String>) Obj.get("netlist");
        Component NewComponent = new Component((String) Obj.get("type"), (String) Obj.get("id"), device, netList);
        return NewComponent;
    }

    /**
     * Get JSON
     * @return JSONObject
     */
    public JSONObject getJson() {
        return json;
    }

    /**
     * Set JSON
     * @param json - JSONObject
     */
    public void setJson(JSONObject json) {
        this.json = json;
    }

    /**
     * Get nodes from the NodeMap
     * @return Nodes in the topology
     */
    public HashMap<String, List<Component>> getNodes() {
        return NodeMap.getNodes();
    }

    /**
     * Sets nthe topology nodes
     * @param nodes - Nodes
     */
    public void setNodes(Nodes nodes) {
        this.NodeMap = nodes;
    }
}
