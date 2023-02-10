package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.NumberFormat;
import java.util.*;

public class FileReader {

    private String filePathAsString = "vendingmachine.csv";
    private List<Product> products = new ArrayList<>();
    private Map<String, Product> inventoryMap = new HashMap<>();

    private File filePath = new File(filePathAsString);

    public void buildInventory() {

        try (Scanner scanner = new Scanner(filePath)) {

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] splitsky = line.split("\\|");
                String slotValue = splitsky[0];
                String productName = splitsky[1];
                double productPrice = Double.parseDouble(splitsky[2]);
                Product newProduct = null;
                if (splitsky[3].equals("Chip")){
                    newProduct = new Chip(productName, productPrice, slotValue);
                    products.add(newProduct);
                    inventoryMap.put(slotValue, newProduct);
                } else if (splitsky[3].equals("Drink")){
                    newProduct = new Drink(productName, productPrice, slotValue);
                    products.add(newProduct);
                    inventoryMap.put(slotValue, newProduct);
                }else if (splitsky[3].equals("Candy")){
                    newProduct = new Candy(productName, productPrice, slotValue);
                    products.add(newProduct);
                    inventoryMap.put(slotValue, newProduct);
                }else if (splitsky[3].equals("Gum")){
                    newProduct = new Gum(productName, productPrice, slotValue);
                    products.add(newProduct);
                    inventoryMap.put(slotValue, newProduct);
                }
                //System.out.println(slotValue + " | " + productName + " | "
                       // + String.format("%.2f", productPrice) + " | QTY:" + newProduct.getStock()) ;
            }
            //System.out.println("\n");

        } catch (FileNotFoundException e) {
            System.out.println("Sorry buddy, no-go on the file!");
        }
    }

        public String getSound() {
            return null;
        }

    public Map<String, Product> getInventoryMap() {
        return inventoryMap;
    }

    public void setInventoryMap(Map<String, Product> inventoryMap) {
        this.inventoryMap = inventoryMap;
    }

    public List<Product> getProducts() {
        return products;
    }
}
