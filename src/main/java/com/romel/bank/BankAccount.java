package com.romel.bank;

// Bank logic
public class BankAccount {

    private final Repository repository = new Repository();

    //deposit method
    public void deposit(double amount) {
        double updatedBalance = 0;
        double balance = repository.findUserCredit();
        if (amount <= 0) {
            System.out.println("Please enter a number higher than 0 ");
        } else {
            updatedBalance = balance + amount;
            repository.updateBalance(updatedBalance);
        }
    }

    //withdraw method
    public double withdraw(double amount) {
        double updatedBalance = 0;
        double balance = repository.findUserCredit();
        if (amount > balance) {
            System.out.println("That amount is higher than your current balance ");
        } else if (amount <= 0) {
            System.out.println("Please enter a valid number over '0' ");
        } else {
            updatedBalance = balance - amount;
            repository.updateBalance(updatedBalance);
        }
        return updatedBalance;
    }

    // create Balance method
    public void createBalance(double amount) {
        if (amount <= 0) {
            System.out.println("Please enter a valid number over '0' ");
        } else {
            repository.createBalance(amount);
        }

    }

    //show balance method
    public double showBalance() {
        return repository.findUserCredit();
    }

    public String createUser(String name) {
        repository.createUser(name);
        return name;
    }

    public void findUser(String name) {
        repository.findUserName(name);
    }

    public double transferMoney(String userOne, String userTwo, double amount) {
        if (amount <= 0) {
            System.out.println("Please try again with a valid amount");
            return 0;
        }
        findUser(userOne);
        double balanceUserOne = repository.findUserCredit();
        double balanceUserTwo;

        if (balanceUserOne <= 0 || balanceUserOne < amount) {
            System.out.println("Your balance is not enough: " + balanceUserOne);
            return 0;
        } else {

        }
        balanceUserOne -= amount;
        repository.updateBalance(balanceUserOne);

        if (!repository.userExist(userTwo)) {
            System.out.println("User was not found");
            return 0;
        } else {
            findUser(userTwo);
            balanceUserTwo = repository.findUserCredit();
            repository.updateBalance(balanceUserTwo + amount);
        }


        return balanceUserOne;
    }

}
