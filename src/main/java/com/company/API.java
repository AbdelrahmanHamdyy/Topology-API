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

/**
 * API
 * The API class contains all the functionalities that are available including reading a json file,
 * writing to it, query topologies, delete a topology, query devices of a topology in a given node,
 * and query devices of a topology
 * @author Abdelrahman Hamdy
 * @version 1.0.0 May 17, 2022
 */
public class API {

    // Main Memory of Topologies
    /**
     * Whole program's memory
     */
    private HashMap<String, Topology>  Memory;

    /**
     * Default API constructor
     * - Sets the memory of the API
     */
    API() {
        setMemory(new HashMap<>());
    }

    /**
     * Gets the Memory
     * @return HashMap of string and topology
     */
    public HashMap<String, Topology> getMemory() {
        return Memory;
    }

    /**
     * Sets the API's Memory
     * @param memory - Map for the memory to be set to
     */
    public void setMemory(HashMap<String, Topology> memory) {
        Memory = memory;
    }

    /**
     * Gets all Topologies
     * @return Memory keyset
     */
    public Set<String> getTopologies() {
        return Memory.keySet();
    }

    /**
     * Adds a new topology to the memory
     * @param json - JSON file that we use to get the topology's info
     */
    public void addToMemory(@NotNull JSONObject json) {
        String id = (String) json.get("id");
        List<JSONObject> objectList = (List<JSONObject>) json.get("components");
        Topology NewTopology = new Topology(id, objectList, json);
        Memory.put(id, NewTopology);
    }

    /**
     * Reads a json file and stores it in the memory
     * @param file - file passed to the function to be opened
     * @return boolean whether the file is read into memory successfully or not
     */
    public boolean readJson(String file) {
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader(file)) {
            //Read JSON file
            JSONObject obj = (JSONObject) jsonParser.parse(reader);
            addToMemory(obj);
            return true;
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Writes a json file stored along with the current directories
     * @param ID - ID to generate
     * @return boolean to check if it is successfully created
     */
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

    /**
     * Deletes a topology from the memory and exits if it's not found
     * @param ID - ID to be deleted
     * @return boolean to indicate success or failure
     */
    public boolean deleteTopology(String ID) {
        if (Memory.containsKey(ID)) {
            Memory.remove(ID);
            return true;
        }
        return false;
    }

    /**
     * Query all devices of a given Topology
     * @param ID - ID to search for
     * @return Component List containing all devices
     */
    public List<Component> queryDevices(String ID) {
        Topology T = Memory.get(ID);
        if (T != null)
            return Memory.get(ID).getComponentList();
        else
            return null;
    }

    /**
     * Query devices of a given netlist node in a specific topology
     * @param ID - Topology ID
     * @param node - Node required
     * @return a list containing the components connected
     */
    public List<Component> queryDevicesWithNetlistNode(String ID, String node) {
        if(Memory.get(ID)==null)
            return null;
        HashMap<String, List<Component>> nodes = Memory.get(ID).getNodes();
        if (nodes != null)
            return nodes.get(node);
        else
            return null;
    }

}
