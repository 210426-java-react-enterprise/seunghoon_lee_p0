package com.revature.seunghoon_lee_p0.services;

import com.revature.seunghoon_lee_p0.daos.LeeBankDAO;
import com.revature.seunghoon_lee_p0.exceptions.AuthenticationException;
import com.revature.seunghoon_lee_p0.exceptions.InvalidRequestException;
import com.revature.seunghoon_lee_p0.models.Customer;

public class LoginService {

    private LeeBankDAO leeBankDAO;

    public LoginService(LeeBankDAO leeBankDAO) {
        this.leeBankDAO = leeBankDAO;
    }

    public Customer authenticate(String username, String password) {

        if (username == null || username.trim().isEmpty() || password == null || password.trim().isEmpty()) {
            throw new InvalidRequestException("Invalid username or password!");
        }

        Customer customer = leeBankDAO.findCustomerByUsernameAndPassword(username, password);
        if (customer == null) {
            throw new AuthenticationException("Could not find that username and password!");
        }

        return customer;

    }
}
