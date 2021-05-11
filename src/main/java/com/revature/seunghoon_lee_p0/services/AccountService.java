package com.revature.seunghoon_lee_p0.services;

import com.revature.seunghoon_lee_p0.daos.AccountDAO;
import com.revature.seunghoon_lee_p0.models.Customer;

public class AccountService {

    private AccountDAO accountDAO;
    private Customer currentCustomer;

    public AccountService(AccountDAO accountDAO, Customer customer) {
        this.accountDAO = accountDAO;
        this.currentCustomer = customer;
    }

    public Customer getCurrentCustomer() {
        return currentCustomer;
    }

    public void setCurrentCustomer(Customer currentCustomer) {
        this.currentCustomer = currentCustomer;
    }
}
