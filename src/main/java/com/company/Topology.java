package com.company;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Topology {

    private String id;
    private List<Component> componentList;

    private Nodes nodes;
    private JSONObject json;

    Topology(String id, List<JSONObject> components, JSONObject JSON) {
        setId(id);
        setJson(JSON);
        setComponentList(components);
        nodes.addToNodes(json);
    }

    Topology() {
        setId("");
        setComponentList(new ArrayList<JSONObject>());
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
        for (JSONObject Obj : components) {
            String type, deviceName = "";
            type = (String) Obj.get("type");
            if (type.equals("resistor"))
                deviceName = "resistance";
            else if (type.equals("nmos") || type.equals("pmos") || type.equals("cmos"))
                deviceName = "m(1)";
            JSONObject deviceObj =  (JSONObject) Obj.get("type");
            double def = (double) deviceObj.get("default");
            double min = (double) deviceObj.get("min");
            double max = (double) deviceObj.get("max");
            Device device = new Device(deviceName, def, min, max);
            HashMap<String, String> netList = (HashMap<String, String>) Obj.get("netlist");
            Component NewComponent = new Component((String) Obj.get("type"), (String) Obj.get("id"), device, netList);
            componentList.add(NewComponent);
        }
    }

    public JSONObject getJson() {
        return json;
    }

    public void setJson(JSONObject json) {
        this.json = json;
    }

    public Nodes getNodes() {
        return nodes;
    }

    public void setNodes(Nodes nodes) {
        this.nodes = nodes;
    }
}
