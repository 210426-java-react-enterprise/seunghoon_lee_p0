package com.revature.seunghoon_lee_p0.screens;

import com.revature.seunghoon_lee_p0.exceptions.InvalidRequestException;
import com.revature.seunghoon_lee_p0.exceptions.ResourcePersistenceException;
import com.revature.seunghoon_lee_p0.models.Customer;
import com.revature.seunghoon_lee_p0.services.RegisterService;

import java.io.BufferedReader;

import static com.revature.seunghoon_lee_p0.Driver.app;

/**
 * Gets customer information
 * Validate customer inputs
 * Register the customer if inputs are validated
 */
public class RegisterScreen extends Screen {

    private BufferedReader consoleReader;
    private RegisterService registerService;

    public RegisterScreen(BufferedReader consoleReader, RegisterService registerService) {
        super("RegisterScreen", "/register");
        this.consoleReader = consoleReader;
        this.registerService = registerService;
    }

    /**
     * Renders screen
     * to get customer information to register
     */
    @Override
    public void render() {

        String username;
        String password;
        String firstName;
        String lastName;
        String email;

        try {

            System.out.println("\nRegister");
            System.out.println("----------------------------------------------------------------------");

            System.out.println("Please enter your information.");

            System.out.print("Username: ");
            username = consoleReader.readLine();
            System.out.print("Password: ");
            password = consoleReader.readLine();
            System.out.print("First name: ");
            firstName = consoleReader.readLine();
            System.out.print("Last name: ");
            lastName = consoleReader.readLine();
            System.out.print("Email: ");
            email = consoleReader.readLine();

            Customer newCustomer = new Customer(username, password, firstName, lastName, email);
            registerService.register(newCustomer);
            System.out.println("Successfully registered!");

        } catch(InvalidRequestException e) {
            System.out.println(e.getMessage());
        } catch(ResourcePersistenceException e) {
            System.out.println(e.getMessage());
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
