package com.revature.seunghoon_lee_p0.services;

import com.revature.seunghoon_lee_p0.daos.LeeBankDAO;
import com.revature.seunghoon_lee_p0.exceptions.InvalidRequestException;
import com.revature.seunghoon_lee_p0.exceptions.ResourcePersistenceException;
import com.revature.seunghoon_lee_p0.models.Customer;

public class RegisterService {

    private LeeBankDAO leeBankDao;

    public RegisterService(LeeBankDAO leeBankDao) {
        this.leeBankDao = leeBankDao;
    }

    public Customer register(Customer newCustomer) throws InvalidRequestException, ResourcePersistenceException {
        if (!isUserValid(newCustomer)) {
            throw new InvalidRequestException("Invalid data provided for new customer!");
        }

        if (!leeBankDao.isUsernameAvailable(newCustomer.getUsername())) {
            throw new ResourcePersistenceException("The provided username is already taken!");
        }

        if (!leeBankDao.isEmailAvailable(newCustomer.getEmail())) {
            throw new ResourcePersistenceException("The provided email is already taken!");
        }

        return leeBankDao.save(newCustomer);
    }

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
