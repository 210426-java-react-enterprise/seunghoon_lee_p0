package com.revature.seunghoon_lee_p0.models;

public class Transaction {

    private int transactionId;
    private String date;
    private int accountId;
    private int customerId;
    private String type;
    private double amount;
    private double balance;

    public Transaction(int transactionId, String date, int accountId, int customerId, String type, double amount, double balance) {
        this.transactionId = transactionId;
        this.date = date;
        this.accountId = accountId;
        this.customerId = customerId;
        this.type = type;
        this.amount = amount;
        this.balance = balance;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return '{' + '\"' +
                transactionId + "\", \"" +
                date + "\", \"" +
                accountId + "\", \"" +
                customerId + "\", \"" +
                type + "\", \"" +
                amount + "\", \"" +
                balance + '\"' +
                '}';
    }

}
