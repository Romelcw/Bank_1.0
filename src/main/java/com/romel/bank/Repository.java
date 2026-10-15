package com.romel.bank;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


public class Repository {
    private int index;
    private static final String UserFile = "UserFile.txt";
    private static final String UserBalance = "UserBalance.txt";

    public void createUser(String user) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(UserFile, true))) {
            bw.write(user);
            bw.newLine();
        } catch (IOException e) {
            System.out.println("" + e);
        }

    }

    public boolean userExist(String user) {
        try (BufferedReader br = new BufferedReader(new FileReader(UserFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.equalsIgnoreCase(user)) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.out.println("" + e);
        }
        return false;
    }

    // create customer balance
    public void createBalance(double balance) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(UserBalance, true))) {
            bw.write(String.valueOf(balance));
            bw.newLine();
        } catch (IOException e) {
            System.out.println("" + e);
        }
    }

    // Find the user from a .txt
    public void findUserName(String name) {
        this.index = -1;
        int position = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(UserFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.equalsIgnoreCase(name)) {
                    this.index = position;
                    break;
                }
                position++;
            }
        } catch (IOException e) {
            System.out.println("" + e);
        }
    }

    //Find cx credit
    public double findUserCredit() {
        double balance = 0;
        List<String> list;
        try (BufferedReader br = new BufferedReader(new FileReader(UserBalance))) {
            list = br.lines().collect(Collectors.toList());
            balance = Double.parseDouble(list.get(this.index));
        } catch (Exception e) {
            System.out.println("" + e);
        }
        return balance;
    }

    public void updateBalance(double updatedBalance) {
        List<String> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(UserBalance))) {
            list = br.lines().collect(Collectors.toList());
            list.set(index, Double.toString(updatedBalance));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(UserBalance))) {
            for (String line : list) {
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("" + e);
        }
    }
}



