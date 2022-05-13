package com.company;

import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;

public class API {

    private HashMap<String, Topology>  Memory;

    API() {
        setMemory(new HashMap<>());
    }

    public HashMap<String, Topology> getMemory() {
        return Memory;
    }

    public void setMemory(HashMap<String, Topology> memory) {
        Memory = memory;
    }

    public void addToMemory(@NotNull String id, Topology NewTopology) {
        Memory.put(id, NewTopology);
    }

    public void readJson(@NotNull JSONObject json) {
        String id = (String) json.get("id");
        List<JSONObject> objectList = (List<JSONObject>) json.get("components");
        Topology topology = new Topology(id, objectList, json);
        addToMemory(id, topology);
    }

}
