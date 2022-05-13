package com.company;

import org.jetbrains.annotations.NotNull;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class API {

    private HashMap<String, Topology>  Memory;

    API() {
        setMemory(new HashMap<>());
    }

    public HashMap<String, Topology> getMemory() {
        return Memory;
    }

    public Set<String> getTopologies() {
        return Memory.keySet();
    }

    public void setMemory(HashMap<String, Topology> memory) {
        Memory = memory;
    }

    public void addToMemory(@NotNull JSONObject json) {
        String id = (String) json.get("id");
        List<JSONObject> objectList = (List<JSONObject>) json.get("components");
        Topology NewTopology = new Topology(id, objectList, json);
        Memory.put(id, NewTopology);
    }

    public void readJson(String file) {
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader(file)) {
            //Read JSON file
            JSONObject obj = (JSONObject) jsonParser.parse(reader);
            addToMemory(obj);
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean writeJSON(String ID) {
        try (FileWriter file = new FileWriter(ID + ".json")) {
            Topology T = Memory.get(ID);
            if (T != null) {
                file.write(T.getJson().toJSONString());
                file.flush();
                return true;
            }
        } catch (IOException e) {
            System.out.println("Error (IOException)");
            e.printStackTrace();
        } catch (NullPointerException e){
            System.out.println("Key not found");
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteTopology(String ID) {
        if (Memory.containsKey(ID)) {
            Memory.remove(ID);
            return true;
        }
        return false;
    }

    public List<Component> queryDevices(String ID) {
        Topology T = Memory.get(ID);
        if (T != null)
            return Memory.get(ID).getComponentList();
        else
            return null;
    }

    public List<Component> queryDevicesWithNetlistNode(String ID, String node) {
        HashMap<String, List<Component>> nodes = Memory.get(ID).getNodes();
        if (nodes != null)
            return nodes.get(node);
        else
            return null;
    }

}
