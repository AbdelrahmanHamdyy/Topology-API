package com.company;

import java.util.ArrayList;
import java.util.List;

public class Topology {

    private String id;
    private List<Component> componentList;

    Topology(String id, List<Component> components) {
        setId(id);
        setComponentList(components);
    }

    Topology() {
        setId("");
        setComponentList(new ArrayList<Component>());
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
}
