package com.techelevator;

import java.util.Scanner;

public class Menu {
    private final Scanner keyboard = new Scanner(System.in);

    public void mainMenu() {

        String userInput;
        Integer parsedInput = 0;

        do {
            System.out.println("(1) Display Vending Machine Items");
            System.out.println("(2) Purchase");
            System.out.println("(3) Exit");
            userInput = keyboard.nextLine();
            try {
                parsedInput = Integer.parseInt(userInput);

                if (parsedInput == 1) {
                    FileReader fileReader = new FileReader();
                    fileReader.readTheFile();
                }
                if (parsedInput == 2) {
                    purchaseMenu();
                }
                if (parsedInput == 3) {
                    System.exit(0);
                }
                if (parsedInput > 3 || parsedInput < 1) {
                    System.out.println("Sorry, not an option...");
                }
            } catch (NumberFormatException e) {
                System.out.println("Sorry, not an option...");
                }
        }
        while (parsedInput != 3);
    }


    double money = 0.00;

    public void purchaseMenu() {
        int parsedInput = 0;
        String userInput;

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
                    purchaseMenu();
                }
                if (parsedInput == 3) {
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

    public void addMoney(){
        String userInput = keyboard.nextLine();
        int parsedInteger = 0;

        try {
            parsedInteger = Integer.parseInt(userInput);
            if (parsedInteger < 0){
                System.out.println("This is not an ATM!!!");
                purchaseMenu();
            }
        } catch (NumberFormatException e) {
            System.out.println("Sorry, try again...");
        }
        money += parsedInteger;
    }
}

