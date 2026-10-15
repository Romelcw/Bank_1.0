package com.romel.bank;

import java.util.Scanner;

public class Menu {
    protected static Scanner scanner = new Scanner(System.in);

    public static void menu() {
        System.out.println("Welcome to CR Bank");
        System.out.println("Please select the transaction you will like to make");
        System.out.println("1. Available credit");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw credit");
        System.out.println("4. Transfer credit");
        System.out.println("5. Exit System");
    }

}
