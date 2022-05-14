package com.company;

import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Topology {

    private String id;
    private List<Component> componentList;
    private Nodes NodeMap;
    private JSONObject json;

    Topology(String id, List<JSONObject> components, JSONObject JSON) {
        setId(id);
        setJson(JSON);
        setComponentList(components);
        setNodes(new Nodes());
        NodeMap.addToNodes(json);
    }

    Topology() {
        setId("");
        setComponentList(new ArrayList<>());
        setNodes(new Nodes());
        setJson(new JSONObject());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Component> getComponentList() {
        return componentList;
    }

    public void setComponentList(List<JSONObject> components) {
        componentList = new ArrayList<>();
        for (JSONObject Obj : components) {
            Component NewComponent = getComponent(Obj);
            componentList.add(NewComponent);
        }
    }

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

    public JSONObject getJson() {
        return json;
    }

    public void setJson(JSONObject json) {
        this.json = json;
    }

    public HashMap<String, List<Component>> getNodes() {
        return NodeMap.getNodes();
    }

    public void setNodes(Nodes nodes) {
        this.NodeMap = nodes;
    }
}
