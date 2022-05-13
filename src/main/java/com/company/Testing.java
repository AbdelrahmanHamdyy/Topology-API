package com.company;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Testing {

    private API app;

    Testing(API api) {
        setApp(api);
    }

    public API getApp() {
        return app;
    }

    public void setApp(API app) {
        this.app = app;
    }

    private void testReadJSON() {
        app.readJson("topology.json");
        if (!app.getMemory().isEmpty())
            System.out.println("Reading from JSON File test Successful!");
        else
            System.out.println("Reading from JSON File test failed!");
    }

    private void testWriteJSON() {
        boolean write = app.writeJSON("top1");
        if (write)
            System.out.println("Writing to JSON File test Successful!");
        else
            System.out.println("Writing to JSON File test failed!");
    }

    private void testQueryTopologies() {
        Set<String> set = app.getTopologies();
        if (set.contains("top1"))
            System.out.println("Query Topologies test Successful!");
        else
            System.out.println("Query Topologies test Failed!");
    }

    private void testDeleteTopology() {
        boolean delete = app.deleteTopology("top1");
        Set<String> set = app.getTopologies();
        if (set.contains("top1") || !delete)
            System.out.println("Deleting a topology in Memory test Failed!");
        else
            System.out.println("Deleting a topology in Memory test Successful!");
    }

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

    public void testAll() {
        System.out.println("Testing Started..\n");
        System.out.println("Testing on Topology");
        testReadJSON();
        testWriteJSON();
        testQueryTopologies();
        testQueryDevices();
        testQueryDevicesWithNetlistNode();
        testDeleteTopology();
        System.out.println("\nTesting Done\n");
    }

}
