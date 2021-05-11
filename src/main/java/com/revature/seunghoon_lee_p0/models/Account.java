package com.revature.seunghoon_lee_p0.models;

public abstract class Account {

    private static int count = 0;
    private int accountNumber;
    private double balance;

    public Account(double balance) {
        this.balance = balance;
        this.accountNumber = count++;
    }

    public static int getCount() {
        return count;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public abstract void deposit(double fund);
    public abstract void withdraw(double fund);

}
