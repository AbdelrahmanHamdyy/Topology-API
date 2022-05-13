package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner Input = new Scanner(System.in);
        System.out.println("--------------------- TOPOLOGY API ---------------------");
        // Main Loop
        while (true) {
            int option = 0;
            // Provided functionalities
            System.out.println("Choose one of the below functionalities:");
            System.out.println("(1) Read a topology from a given JSON file and store it in the memory.");
            System.out.println("(2) Write a given topology from the memory to a JSON file.");
            System.out.println("(3) Query about which topologies are currently in the memory.");
            System.out.println("(4) Delete a given topology from memory.");
            System.out.println("(5) Query about which devices are in a given topology.");
            System.out.println("(6) Query about which devices are connected to a given netlist node in\n" +
                    "a given topology.");
            System.out.println("(7) Sample Tests");
            System.out.println("(8) Exit");
            option = Input.nextInt(); // Get input

        }
    }
}
