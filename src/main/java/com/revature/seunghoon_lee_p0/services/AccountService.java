package com.revature.seunghoon_lee_p0.services;

import com.revature.seunghoon_lee_p0.daos.AccountDAO;
import com.revature.seunghoon_lee_p0.models.Account;
import com.revature.seunghoon_lee_p0.models.Customer;
import com.revature.seunghoon_lee_p0.models.Transaction;

import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class AccountService {

    private AccountDAO accountDAO;
    private Customer currentCustomer;
    private Account currentAccount;
    private Transaction transaction;

    public AccountService(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    public void setCurrentCustomer(Customer currentCustomer) {
        this.currentCustomer = currentCustomer;
        updateAccount();
    }

    public void updateAccount() {
        currentAccount = accountDAO.getAccount(currentCustomer.getCustomerId());
    }

    public boolean createAccount() {
        if(accountDAO.insertAccount(currentCustomer.getCustomerId())) {
            updateAccount();
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

        if (accountDAO.insertTransaction(
                currentAccount.getAccountId(),
                currentCustomer.getCustomerId(),
                type,
                amount,
                balance)) {
            updateAccount();
            return true;
        }
        return false;

    }

}
