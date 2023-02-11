package com.techelevator;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Scanner;

public class Menu {
    private final Scanner keyboard = new Scanner(System.in);
    String userInput;
    FileReader fileReader;


    public void mainMenu(FileReader fileReader) {
            Integer parsedInput = 0;
            this.fileReader = fileReader;
            do {
                System.out.println("(1) Display Vending Machine Items");
                System.out.println("(2) Purchase");
                System.out.println("(3) Exit");
                userInput = keyboard.nextLine();
                try {
                    parsedInput = Integer.parseInt(userInput);

                    if (parsedInput == 1) {
                        for (int i = 0; i < fileReader.getProducts().size(); i++) {
                            String currentSlot = fileReader.getProducts().get(i).getSlot();
                            System.out.println(fileReader.getProducts().get(i).getSlot() + " | "
                                    + fileReader.getProducts().get(i).getProductName() + " | "
                                    +String.format("%.2f", fileReader.getProducts().get(i).getPrice()) + " | QTY:"
                                    + fileReader.getInventoryMap().get(currentSlot).getStock());
                        }
                        System.out.println("\n");
                    }
                    if (parsedInput == 2) {
                        purchaseMenu();
                    }
                    if (parsedInput == 3) {
                        System.exit(0);
                    }
                    if (parsedInput > 3 || parsedInput < 1) {
                        System.out.println("Sorry, not an option...loser");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Sorry, not an option...loser");
                }
            }
            while (parsedInput != 3);
    }

    double money = 0.00;
    int quarters = 0;
    int dimes = 0;
    int nickels = 0;

    public void purchaseMenu() {
        int parsedInput = 0;

        do {
            System.out.print("Current Money Provided: ");
            System.out.printf("%.2f", money);
            System.out.println("\n(1) Feed Money");
            System.out.println("(2) Select Product");
            System.out.println("(3) Finish Transaction");
            userInput = keyboard.nextLine();

            try {
                parsedInput = Integer.parseInt(userInput);

                if (parsedInput == 1) {
                    System.out.println("How much money are you adding?");
                    addMoney();
                }
                if (parsedInput == 2) {
                    for (int i = 0; i < fileReader.getProducts().size(); i++) {
                        String currentSlot = fileReader.getProducts().get(i).getSlot();
                        System.out.println(fileReader.getProducts().get(i).getSlot() + " | "
                                + fileReader.getProducts().get(i).getProductName() + " | "
                                + String.format("%.2f", fileReader.getProducts().get(i).getPrice()) + " | QTY:"
                                + fileReader.getInventoryMap().get(currentSlot).getStock());
                    }
                    System.out.println("Please select item code: ");
                    userInput = keyboard.nextLine();
                    attemptToPurchase(fileReader.getInventoryMap());
                }
                if (parsedInput == 3) {
                    getChange();
                    System.out.println("Your change is: \n" + quarters +
                            " quarters \n" + dimes + " dimes \n" + nickels + " nickels");
                    System.out.println("\n");
                    money = 0;
                    quarters = 0;
                    dimes = 0;
                    nickels = 0;
                    mainMenu(fileReader);
                }
                if (parsedInput > 3 || parsedInput < 1) {
                    System.out.println("Sorry, not an option...");
                }
            } catch (NumberFormatException e) {
                System.out.println("Sorry, not an option...");
            }
        } while (parsedInput != 3);
    }

    public void addMoney() {
        String userInput = keyboard.nextLine();
        int parsedInteger = 0;

        try {
            parsedInteger = Integer.parseInt(userInput);
            if (parsedInteger < 0) {
                System.out.println("This is not an ATM!!!");
                purchaseMenu();
            }
        } catch (NumberFormatException e) {
            System.out.println("Sorry, try again...");
        }
        money += parsedInteger;
    }

    public void getChange() {
        money = money * 100;
        quarters = (int) money / 25;
        dimes = (int) (money % 25) / 10;
        nickels = (int) ((money % 25) % 10) / 5;
    }

    public void attemptToPurchase(Map<String, Product> map) {
        for (String key : map.keySet()) {
            if (!map.containsKey(userInput)) {
                System.out.println("Nice try idiot, try again...");
                purchaseMenu();
            }
        }
        if (map.get(userInput).getStock() < 1) {
            System.out.println("Sorry, someone else ate them all...");
            purchaseMenu();
        } else if (map.get(userInput).getPrice() > money) {
            System.out.println("Not enough money. Shouldn't have went to Vegas. Tsk Tsk...");
        } else {
            money -= map.get(userInput).getPrice();
            System.out.println(map.get(userInput).getProductName());
            System.out.println(String.format("%.2f",map.get(userInput).getPrice()));
            System.out.println(map.get(userInput).getSound());
            System.out.println("Money left: " + String.format("%.2f", money));
            map.get(userInput).setStock(map.get(userInput).getStock());
            System.out.println("\n");
            purchaseMenu();
        }
    }
}

