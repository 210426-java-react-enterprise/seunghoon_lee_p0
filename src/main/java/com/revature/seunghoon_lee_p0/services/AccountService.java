package com.revature.seunghoon_lee_p0.services;

import com.revature.seunghoon_lee_p0.daos.AccountDAO;
import com.revature.seunghoon_lee_p0.models.Account;
import com.revature.seunghoon_lee_p0.models.Customer;
import com.revature.seunghoon_lee_p0.models.Transaction;
import com.revature.seunghoon_lee_p0.util.LinkedList;

public class AccountService {

    private AccountDAO accountDAO;
    private Customer currentCustomer;
    private LinkedList<Account> customerAccounts;
    private Account currentAccount;
    private boolean isLoggedIn;

    public AccountService(AccountDAO accountDAO)
    {
        this.accountDAO = accountDAO;
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public void setCurrentCustomer(Customer currentCustomer) {
        this.currentCustomer = currentCustomer;
        isLoggedIn = true;
    }

    public LinkedList<Account> getCurrentCustomerAccounts() {
        return customerAccounts;
    }

    public Customer getCurrentCustomer() {
        return currentCustomer;
    }

    public void setCustomerAccounts() {
        customerAccounts = accountDAO.getAccounts(currentCustomer.getCustomerId());
    }

    public void setCurrentAccount() {
        // need to be updated
        if(customerAccounts.peek() != null) {
            currentAccount = customerAccounts.peek();
        } else {
            currentAccount = null;
        }
    }

    public Account getCurrentAccount() {
        return currentAccount;
    }

    public void updateCurrentAccount() {
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

        boolean transactionUpdate =
            accountDAO.insertTransaction(
                    currentAccount.getAccountId(), currentCustomer.getCustomerId(), type, amount, balance
            );
        boolean accountBalanceUpdate =
            accountDAO.updateAccountBalance(
                    currentAccount.getAccountId(), balance
            );
        if (transactionUpdate && accountBalanceUpdate) {
            return true;
        }
        return false;

    }

    public LinkedList<Transaction> getTransactionHistory() {
        return accountDAO.getTransactions(currentAccount.getAccountId());
    }

    public void logOut() {
        this.currentAccount = null;
        this.customerAccounts = null;
        this.currentCustomer = null;
        isLoggedIn = false;
    }

}
