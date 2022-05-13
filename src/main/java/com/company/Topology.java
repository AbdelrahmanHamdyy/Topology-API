package com.company;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Topology {

    private String id;
    private List<Component> componentList;

    private JSONObject json;

    Topology(String id, List<Component> components, JSONObject JSON) {
        setId(id);
        setComponentList(components);
        setJson(JSON);
    }

    Topology() {
        setId("");
        setComponentList(new ArrayList<Component>());
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

    public void setComponentList(List<Component> componentList) {
        this.componentList = componentList;
    }

    public JSONObject getJson() {
        return json;
    }

    public void setJson(JSONObject json) {
        this.json = json;
    }
}
