package com.techelevator;

import java.util.HashMap;
import java.util.Map;

public class Inventory {

    Map<String, Integer> inventoryMap = new HashMap<>();

    public void addToMap(){
        inventoryMap.put("A1", 5);
        inventoryMap.put("A2", 5);
        inventoryMap.put("A3", 5);
        inventoryMap.put("A4", 5);
        inventoryMap.put("B1", 5);
        inventoryMap.put("B2", 5);
        inventoryMap.put("B3", 5);
        inventoryMap.put("B4", 5);
        inventoryMap.put("C1", 5);
        inventoryMap.put("C2", 5);
        inventoryMap.put("C3", 5);
        inventoryMap.put("C4", 5);
        inventoryMap.put("D1", 5);
        inventoryMap.put("D2", 5);
        inventoryMap.put("D3", 5);
        inventoryMap.put("D4", 5);


        inventoryMap.put("A1", inventoryMap.get("A1") - 1);


    }



}
