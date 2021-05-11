package com.revature.seunghoon_lee_p0.models;

public class Account {

    private int accountId;
    private int customerId;
    private double balance;

    public Account(int customerId, double balance) {
        this.customerId = customerId;
        this.balance = balance;
    }
    public Account(int accountId, int customerId, double balance) {
        this(customerId, balance);
        this.accountId = accountId;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getCustomerId() { return customerId; }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double fund) {
        balance = balance + fund;
    };

    public boolean withdraw(double fund) {

        if(balance >= fund) {
            balance = balance - fund;
            return true;
        }
        return false;
    };

}
