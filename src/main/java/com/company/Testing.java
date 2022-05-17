package com.company;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * This class is responsible for testing the API library that we have created
 * It contains a test function for each functionality and prints whether it's
 * successful or not by checking the memory (Topologies) and making a decision
 * @author Abdelrahman Hamdy
 * @version 1.0.0 May 17, 2022
 */
public class Testing {

    private API app;

    /**
     * Non Default Testing Constructor
     * @param api - API object passed from the main class
     */
    Testing(API api) {
        setApp(api);
    }

    /**
     * Get API
     * @return API Object
     */
    public API getApp() {
        return app;
    }

    /**
     * Sets API
     * @param app - application
     */
    public void setApp(API app) {
        this.app = app;
    }

    /**
     * Tests Reading a JSON File and getting its topology then
     * storing it in the memory. We check whether it is actually stored or not
     * then print the result
     */
    private void testReadJSON() {
        boolean read = app.readJson("topology.json");
        if (!app.getMemory().isEmpty() && read)
            System.out.println("Reading from JSON File test Successful!");
        else
            System.out.println("Reading from JSON File test failed!");
    }

    /**
     * Tests Writing to a JSON file a certain topology by setting its name
     * as ID.json
     */
    private void testWriteJSON() {
        boolean write = app.writeJSON("top1");
        File file = new File("top1.json");
        if (write && file.exists())
            System.out.println("Writing to JSON File test Successful!");
        else
            System.out.println("Writing to JSON File test failed!");
    }

    /**
     * Tests querying a certain topology
     */
    private void testQueryTopologies() {
        Set<String> set = app.getTopologies();
        if (set.contains("top1"))
            System.out.println("Query Topologies test Successful!");
        else
            System.out.println("Query Topologies test Failed!");
    }

    /**
     * Tests the deletion of a given topology and checking if it's correct or not
     * from the memory. The topology shouldn't be found
     */
    private void testDeleteTopology() {
        boolean delete = app.deleteTopology("top1");
        Set<String> set = app.getTopologies();
        if (set.contains("top1") || !delete)
            System.out.println("Deleting a topology in Memory test Failed!");
        else
            System.out.println("Deleting a topology in Memory test Successful!");
    }

    /**
     * Tests querying the devices from a topology
     */
    private void testQueryDevices() {
        List<Component> list = app.queryDevices("top1");
        HashMap<String, Topology> Memory = app.getMemory();
        Topology T = Memory.get("top1");
        List<Component> TopList = T.getComponentList();
        if (list == TopList)
            System.out.println("Query Devices of a given topology test Successful!");
        else
            System.out.println("Query Devices of a given topology test Failed!");
    }

    /**
     * Tests querying devices from a certain node in a given topology
     */
    private void testQueryDevicesWithNetlistNode() {
        List<Component> list = app.queryDevicesWithNetlistNode("top1","n1");
        HashMap<String, Topology> Memory = app.getMemory();
        Topology T = Memory.get("top1");
        List<Component> NodeComponent = T.getNodes().get("n1");
        if (list == NodeComponent)
            System.out.println("Query Devices with NetList node Successful!");
        else
            System.out.println("Query Devices with NetList node Failed!");
    }

    /**
     * Calls all the testing functions
     */
    public void testAll() {
        System.out.println("\nTesting Started..\n");
        System.out.println("Testing on Topology with ID \"top1\" and Netlist node \"n1\"");
        testReadJSON();
        testWriteJSON();
        testQueryTopologies();
        testQueryDevices();
        testQueryDevicesWithNetlistNode();
        testDeleteTopology();
        System.out.println("\nTesting Done\n");
    }
}
