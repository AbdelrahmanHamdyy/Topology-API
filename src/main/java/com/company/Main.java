package com.company;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;

public class Main {

    private static final API app = new API();

    public static void main(String[] args) {
        Scanner Input = new Scanner(System.in);
        System.out.println("********************* TOPOLOGY API *********************");
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
            option = Input.nextInt(); // Get input
            switch(option) {
                case 1:
                    System.out.println("Enter File Name: ");
                    String file = Input.next();
                    app.readJson(file);
                    break;

                case 2:
                    System.out.println("Topology ID: ");
                    ID = Input.next();
                    app.writeJSON(ID);
                    break;
                case 3:
                    System.out.println("Topologies: ");
                    Set<String> Topologies = app.getTopologies();
                    System.out.println(Topologies);
                    break;
                case 4:
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
                    break;
                case 5:
                    System.out.println("Topology ID: ");
                    ID = Input.next();
                    List<Component> devices = app.queryDevices(ID);
                    for (Component comp : devices)
                        comp.print();
                    break;
                case 6:
                    System.out.println("Topology ID: ");
                    ID = Input.next();
                    System.out.println("Node: ");
                    String node = Input.next();
                    System.out.println(app.queryDevicesWithNetlistNode(ID, node));
                    break;
                case 7:

                    break;
                case 8:
                    System.out.println("Exiting..");
                    return;
                default:
                    System.out.println("Invalid");
            }
            System.out.println("--------------------------------------------------------");
        }
    }
}
