package com.company;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;

public class Nodes {

    private final HashMap<String, List<Component>> nodes = new HashMap<>();

    public HashMap<String, List<Component>> getNodes() {
        return nodes;
    }

    public void addToNodes(JSONObject json) {
        
    }
}
