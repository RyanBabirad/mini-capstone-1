package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {

    private String filePathAsString = "vendingmachine.csv";
    private Product product = new Product();
    private List<String[]> allItems = new ArrayList<>();
    private List<Product> products = new ArrayList<>();

    private File filePath = new File(filePathAsString);

    public void readTheFile() {

        try (Scanner scanner = new Scanner(filePath)) {

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] splitsky = line.split("\\|");
                allItems.add(splitsky);

                System.out.println(line + "| " + );// Stock(From map?)
            }
            System.out.println("\n");


        } catch (FileNotFoundException e) {
            System.out.println("Sorry buddy, no-go on the file!");
        }
    }

    public void makeListOfProducts(){
        try (Scanner scanner = new Scanner(filePath)) {

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] splitsky = line.split("\\|");

            }


        } catch (FileNotFoundException e) {
            System.out.println("Sorry buddy, no-go on the file!");
        }
    }


}
