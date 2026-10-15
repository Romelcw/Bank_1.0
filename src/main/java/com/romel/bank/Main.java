package com.romel.bank;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankAccount bank = new BankAccount();
        Repository repository = new Repository();
        double balance;
        String name;
        while (true) {
            System.out.println("Do you have an account 'y,n'");
            String account = scanner.nextLine();

            if (account.equalsIgnoreCase("n")) {
                System.out.println("Please enter your name");
                name = scanner.nextLine();
                bank.createUser(name);
                System.out.println("Please enter your balance");
                balance = Double.parseDouble(scanner.nextLine());
                bank.createBalance(balance);
            } else {
                System.out.println("Please enter your name");
                name = scanner.nextLine();
                if (!repository.userExist(name)) {
                    System.out.println("User was not found");
                    return;
                } else {
                    bank.findUser(name);
                }
            }

            while (true) {
                Menu.menu();
                int option = Integer.parseInt(scanner.nextLine());
                switch (option) {
                    case 1:
                        System.out.println("Your credit is from: " + bank.showBalance());
                        break;
                    case 2:
                        System.out.println("Please enter then amount you will like lo deposit:");
                        balance = Double.parseDouble(scanner.nextLine());
                        bank.deposit(balance);
                        System.out.println("Your full balance is from:" + bank.showBalance() + "\n");
                        break;
                    case 3:
                        System.out.println("Please enter then amount you will like lo withdraw:");
                        balance = Double.parseDouble(scanner.nextLine());
                        bank.withdraw(balance);
                        System.out.println("Your full balance  is from:" + bank.showBalance() + "\n");
                        break;
                    case 4:
                        System.out.println("Please enter the name of the user you will like to make a transfer: ");
                        String userTwoName = scanner.nextLine();
                        System.out.println("Please enter the amount you will like to transfer: ");
                        double transferAmount = Double.parseDouble(scanner.nextLine());
                        System.out.println("This is your current balance: " + bank.transferMoney(name, userTwoName, transferAmount));
                        break;
                    case 5:
                        System.out.println("Goodbye!");
                        scanner.close();
                        return;
                }

            }
        }
    }
}
