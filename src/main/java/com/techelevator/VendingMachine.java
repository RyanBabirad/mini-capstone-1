package com.techelevator;

public class VendingMachine {
    FileReader fileReader = new FileReader();
    Menu newMenu = new Menu();

    public void StartUp() {

        //Start log file
        newMenu.mainMenu();
    }
}
