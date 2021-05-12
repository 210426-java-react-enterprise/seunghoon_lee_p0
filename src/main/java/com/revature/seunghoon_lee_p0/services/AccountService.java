package com.revature.seunghoon_lee_p0.services;

import com.revature.seunghoon_lee_p0.daos.AccountDAO;
import com.revature.seunghoon_lee_p0.models.Account;
import com.revature.seunghoon_lee_p0.models.Customer;
import com.revature.seunghoon_lee_p0.models.Transaction;
import com.revature.seunghoon_lee_p0.util.LinkedList;
import sun.awt.image.ImageWatched;

public class AccountService {

    private AccountDAO accountDAO;
    private Customer currentCustomer;
    private LinkedList<Account> customerAccounts;
    private Account currentAccount;

    public AccountService(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    public void setCurrentCustomer(Customer currentCustomer) {
        this.currentCustomer = currentCustomer;
    }

    public LinkedList<Account> getCustomerAccounts() {
        return customerAccounts;
    }

    public void setCustomerAccounts() {
        this.customerAccounts = accountDAO.getAccounts(currentCustomer.getCustomerId());
    }

    public boolean setCurrentAccount() {
        // need to be updated
        currentAccount = customerAccounts.get(0);

        return true;
    }

    public void updateAccount() {
        currentAccount = accountDAO.getAccount(currentAccount.getAccountId());
    }

    public boolean createAccount() {
        if(accountDAO.insertAccount(currentCustomer.getCustomerId())) {
            setCurrentAccount();
            return true;
        }
        return false;
    }

    public boolean saveTransaction(String type, double amount) {

        double balance = currentAccount.getBalance();
        switch(type) {
            case "deposit" :
                balance = balance + amount;
                break;
            case "withdraw" :
                balance = balance - amount;
                break;
        }

        boolean result =
            accountDAO.insertTransaction(
                    currentAccount.getAccountId(), currentCustomer.getCustomerId(), type, amount, balance
            );
        if (result) {
            updateAccount();
            return true;
        }
        return false;

    }

    public LinkedList<Transaction> getTransactionHistory() {

        return accountDAO.getTransactions(currentAccount.getAccountId());

    }

    public void logOut() {
        this.currentAccount = null;
        this.currentCustomer = null;
    }

}
