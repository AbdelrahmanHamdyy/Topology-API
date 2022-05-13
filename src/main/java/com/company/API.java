package com.company;

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

    

}
