package com.company;

import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * This class is used by the topology to instantiate an object from it in order to set all
 * nodes contained in the netlist and the components linked to it so that it can be easily retrieved
 * when chosen as a query.
 * @author Abdelrahman Hamdy
 * @version 1.0.0 May 17, 2022
 */
public class Nodes {

    private final HashMap<String, List<Component>> nodes = new HashMap<>();

    /**
     * Function that gets all nodes in a given topology
     * @return Node Map consisting of the node and its list of components
     */
    public HashMap<String, List<Component>> getNodes() {
        return nodes;
    }

    /**
     * This function extracts each node from the netlist of a given topology and adds it to the map.
     * It will be called by the topology class when parsing the json file
     * @param json - JSON file
     */
    public void addToNodes(JSONObject json) {
        for (JSONObject component : (List<JSONObject>) json.get("components")) {
            JSONObject netList = (JSONObject) component.get("netlist");
            Set<String> keys = (Set<String>) netList.keySet();
            for (String key : keys) {
                String node = (String) netList.get((String) key);
                if (!nodes.containsKey(node)) {
                    List<Component> list = new ArrayList<>();
                    nodes.put(node, list);
                }
                Component comp = Topology.getComponent(component);
                nodes.get(node).add(comp);
            }
        }
    }
}
