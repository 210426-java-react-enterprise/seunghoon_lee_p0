package com.revature.seunghoon_lee_p0.services;

import com.revature.seunghoon_lee_p0.daos.CustomerDAO;
import com.revature.seunghoon_lee_p0.exceptions.InvalidRequestException;
import com.revature.seunghoon_lee_p0.exceptions.ResourcePersistenceException;
import com.revature.seunghoon_lee_p0.models.Customer;

/**
 * Validates customer inputs
 * Calls methods to register customer through interaction with database
 */
public class RegisterService {

    private CustomerDAO customerDao;

    public RegisterService(CustomerDAO customerDao) {
        this.customerDao = customerDao;
    }

    /**
     * Validates user input to register new customer
     *
     * @param newCustomer
     * @return
     * @throws InvalidRequestException
     * @throws ResourcePersistenceException
     */
    public Customer register(Customer newCustomer) throws InvalidRequestException, ResourcePersistenceException {
        if (!isUserValid(newCustomer)) {
            throw new InvalidRequestException("Invalid data provided for new customer!");
        }

        if (!customerDao.isUsernameAvailable(newCustomer.getUsername())) {
            throw new ResourcePersistenceException("The provided username is already taken!");
        }

        if (!customerDao.isEmailAvailable(newCustomer.getEmail())) {
            throw new ResourcePersistenceException("The provided email is already taken!");
        }

        return customerDao.save(newCustomer);
    }

    /**
     * Validation check
     * @param customer
     * @return
     */
    public boolean isUserValid(Customer customer) {

        if (customer == null) return false;
        if (customer.getUsername() == null || customer.getUsername().trim().isEmpty() || customer.getUsername().length() > 25) return false;
        if (customer.getPassword() == null || customer.getPassword().trim().isEmpty() || customer.getPassword().length() > 255) return false;
        if (customer.getFirstName() == null || customer.getFirstName().trim().isEmpty() || customer.getFirstName().length() > 25) return false;
        if (customer.getLastName() == null || customer.getLastName().trim().isEmpty() || customer.getLastName().length() > 25) return false;
        if (customer.getEmail() == null || customer.getEmail().trim().isEmpty() || customer.getEmail().length() > 25) return false;

        return true;
    }
}
