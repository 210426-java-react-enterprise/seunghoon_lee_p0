package com.revature.seunghoon_lee_p0.services;

import com.revature.seunghoon_lee_p0.daos.AccountDAO;
import com.revature.seunghoon_lee_p0.exceptions.InvalidRequestException;
import com.revature.seunghoon_lee_p0.exceptions.NegativeAmountTransactionException;
import com.revature.seunghoon_lee_p0.exceptions.OverdarftException;
import com.revature.seunghoon_lee_p0.models.Account;
import com.revature.seunghoon_lee_p0.models.Customer;
import com.revature.seunghoon_lee_p0.models.Transaction;
import com.revature.seunghoon_lee_p0.util.LinkedList;

/**
 * Validates customer inputs
 * Calls methods to communicate with tables related to account and transaction in database
 * Holds current authenticated customer information during login
 */
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

    /**
     * Tells if the customer logged in
     *
     * @return Boolean
     */
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

    /**
     * Gets account information from database and sets Account
     */
    public void setCustomerAccounts() {
        customerAccounts = accountDAO.getAccounts(currentCustomer.getCustomerId());
    }

    public Account getCurrentAccount() {
        return currentAccount;
    }

    /**
     * Sets current account among customers multiple accounts
     * Currently not implemented
     * Need to be updated
     */
    public void setCurrentAccount() {
        // need to be updated
        if(customerAccounts.peek() != null) {
            currentAccount = customerAccounts.peek();
        } else {
            currentAccount = null;
        }
    }

    /**
     * Inserts new account into account table in database
     *
     * @return Boolean which tells the insertion succeeded or not
     */
    public boolean createAccount() {
        if(accountDAO.insertAccount(currentCustomer.getCustomerId())) {
            setCurrentAccount();
            return true;
        }
        return false;
    }

    /**
     * Validates customer input
     * Inserts new transaction record into transactions table in database
     *
     * @param type
     * @param amount
     * @return Boolean which tells the insertion succeeded or not
     */
    public boolean saveTransaction(String type, double amount) {

        if(amount < 0) {
            throw new NegativeAmountTransactionException("Transaction failed! Negative amount is not allowed!");
        }
        double balance = currentAccount.getBalance();
        switch(type) {
            case "deposit" :
                balance = balance + amount;
                break;
            case "withdraw" :
                balance = balance - amount;
                break;
        }
        if(balance < 0) {
            throw new OverdarftException("Transaction failed! Overdraft is not allowed!");
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

    /**
     * Gets transaction records based on current account_id
     *
     * @return LinkedList<Transaction>
     */
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
