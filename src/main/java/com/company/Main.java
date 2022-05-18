package com.company;

import java.util.*;

/**
 * The Main class is the application manager of the program.
 * It contains the infinite loop which keeps running until the user exits.
 * Otherwise he will choose between the functionalities to perform
 * @author Abdelrahman Hamdy
 * @version 1.0.0 May 17, 2022
 */
public class Main {

    /**
     * Object from the API class to call the API's functions
     */
    private static final API app = new API();

    /**
     * Main function (Application Manager)
     * @param args - Args
     */
    public static void main(String[] args) {
        Run();
    }

    /**
     * This is the execution function of the whole API. It shows the main screen
     * and prompts the user for input as his functionality choice. Then it calls
     * the corresponding function from the API class.
     */
    public static void Run() {
        Scanner Input = new Scanner(System.in);
        System.out.println("\n********************* TOPOLOGY API *********************\n");
        // Main Loop
        while (true) {
            int option = 0;
            String confirm;
            String ID;
            // Provided functionalities
            System.out.println("Choose one of the below functionalities:");
            System.out.println("(1) Read a topology from a given JSON file and store it in the memory.");
            System.out.println("(2) Write a given topology from the memory to a JSON file.");
            System.out.println("(3) Query about which topologies are currently in the memory.");
            System.out.println("(4) Delete a given topology from memory.");
            System.out.println("(5) Query about which devices are in a given topology.");
            System.out.println("(6) Query about which devices are connected to a given netlist node in a given topology.");
            System.out.println("(7) Sample Tests");
            System.out.println("(8) Exit");
            System.out.println("--------------------------------------------------------");
            System.out.print("Choice: ");
            option = Input.nextInt(); // Get input
            switch (option) {
                case 1 -> {
                    System.out.println("Enter File Name: ");
                    String file = Input.next();
                    boolean flag = app.readJson(file);
                    if (flag)
                        System.out.println("Successfully read file " + file);
                    else
                        System.out.println("Error in Read");
                }
                case 2 -> {
                    System.out.println("Topology ID: ");
                    ID = Input.next();
                    boolean flag = app.writeJSON(ID);
                    if (flag)
                        System.out.println("Successfully written to file " + ID + ".json");
                    else
                        System.out.println("Error in Write");
                }
                case 3 -> {
                    System.out.println("Topologies: ");
                    Set<String> Topologies = app.getTopologies();
                    if (Topologies.isEmpty())
                        System.out.println("No Topologies Found!");
                    else
                        System.out.println(Topologies);
                }
                case 4 -> {
                    System.out.println("Topology ID: ");
                    ID = Input.next();
                    System.out.println("Are you sure you want to delete this topology? (y/n)");
                    confirm = Input.next();
                    confirm = confirm.toLowerCase(Locale.ROOT);
                    if (confirm.equals("y")) {
                        boolean flag = app.deleteTopology(ID);
                        if (flag)
                            System.out.println("Successfully Deleted!");
                        else
                            System.out.println("Deletion Failed!");
                    }
                }
                case 5 -> {
                    System.out.println("Topology ID: ");
                    ID = Input.next();
                    List<Component> devices = app.queryDevices(ID);
                    if (devices != null) {
                        for (Component comp : devices)
                            comp.print();
                    } else
                        System.out.println("Topology Not Found!");
                }
                case 6 -> {
                    System.out.println("Topology ID: ");
                    ID = Input.next();
                    System.out.println("Node: ");
                    String node = Input.next();
                    List<Component> nodes = app.queryDevicesWithNetlistNode(ID, node);
                    if (nodes != null) {
                        for (Component comp : nodes)
                            comp.print();
                    } else
                        System.out.println("Topology/Node Not Found!");
                }
                case 7 -> {
                    Testing Test = new Testing(app);
                    Test.testAll();
                    return;
                }
                case 8 -> {
                    System.out.println("\nExiting..");
                    return;
                }
                default -> System.out.println("Invalid Option!");
            }
        }
    }
}
