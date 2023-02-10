package com.techelevator;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Scanner;

public class Menu {
    private final Scanner keyboard = new Scanner(System.in);
    String userInput;
    FileReader fileReader = new FileReader();


    public void mainMenu() {
        Integer parsedInput = 0;
        fileReader.buildInventory();

        do {
            System.out.println("(1) Display Vending Machine Items");
            System.out.println("(2) Purchase");
            System.out.println("(3) Exit");
            userInput = keyboard.nextLine();
            try {
                parsedInput = Integer.parseInt(userInput);

                if (parsedInput == 1) {
                    for (String key : fileReader.getInventoryMap().keySet()) {
                        System.out.println(fileReader.getInventoryMap().get(key).getSlot() + " | "
                        + fileReader.getInventoryMap().get(key).getProductName() + " | "
                        + fileReader.getInventoryMap().get(key).getPrice() + " | QTY:"
                        + fileReader.getInventoryMap().get(key).getStock() + "\n");
                    }
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
                    for (String key : fileReader.getInventoryMap().keySet()) {
                        System.out.println(fileReader.getInventoryMap().get(key).getSlot() + " | "
                                + fileReader.getInventoryMap().get(key).getProductName() + " | "
                                + fileReader.getInventoryMap().get(key).getPrice() + " | QTY:"
                                + fileReader.getInventoryMap().get(key).getStock() + "\n");
                    }
                    System.out.println("Please select item code: ");
                    userInput = keyboard.nextLine();
                    attemptToPurchase(fileReader.getInventoryMap());
                }
                if (parsedInput == 3) {
                    getChange();
                    System.out.println("Your change is: \n" + quarters +
                            " quarters \n" + dimes + " dimes \n" + nickels + " nickels");
                    money = 0;
                    quarters = 0;
                    dimes = 0;
                    nickels = 0;
                    mainMenu();
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
            if (map.get(userInput).getStock() < 1){
                System.out.println("Sorry, someone else ate them all...");
                purchaseMenu();
            } else if (map.get(userInput).getPrice() > money) {
                System.out.println("Not enough money. Shouldn't have went to Vegas. Tsk Tsk...");
            } else {
                money -= map.get(userInput).getPrice();
                System.out.println(map.get(userInput).getProductName());
                System.out.println(map.get(userInput).getPrice());
                System.out.println(map.get(userInput).getSound());
                System.out.println("Money left: " + money);
                map.get(userInput).setStock(map.get(userInput).getStock());
                purchaseMenu();
            }
        }
}

