package com.revature.seunghoon_lee_p0.services;

import com.revature.seunghoon_lee_p0.daos.CustomerDAO;
import com.revature.seunghoon_lee_p0.exceptions.AuthenticationException;
import com.revature.seunghoon_lee_p0.exceptions.InvalidRequestException;
import com.revature.seunghoon_lee_p0.models.Customer;

/**
 * Validates customer inputs
 * Calls methods to authenticate customer through interaction with database
 */
public class LoginService {

    private CustomerDAO customerDAO;

    public LoginService(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    /**
     * Validates user input to login
     *
     * @param username
     * @param password
     * @return Customer
     */
    public Customer authenticate(String username, String password) {

        if (username == null || username.trim().isEmpty() || password == null || password.trim().isEmpty()) {
            throw new InvalidRequestException("Invalid username or password!");
        }

        Customer customer = customerDAO.findCustomerByUsernameAndPassword(username, password);
        if (customer == null) {
            throw new AuthenticationException("Could not find that username and password!");
        }

        return customer;

    }
}
