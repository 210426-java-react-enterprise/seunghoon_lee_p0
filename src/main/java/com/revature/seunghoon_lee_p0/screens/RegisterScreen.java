package com.revature.seunghoon_lee_p0.screens;

import com.revature.seunghoon_lee_p0.exceptions.InvalidRequestException;
import com.revature.seunghoon_lee_p0.exceptions.ResourcePersistenceException;
import com.revature.seunghoon_lee_p0.models.Customer;
import com.revature.seunghoon_lee_p0.services.RegisterService;

import java.io.BufferedReader;

import static com.revature.seunghoon_lee_p0.Driver.app;

public class RegisterScreen extends Screen {

    private BufferedReader consoleReader;
    private RegisterService registerService;

    public RegisterScreen(BufferedReader consoleReader, RegisterService registerService) {
        super("RegisterScreen", "/register");
        this.consoleReader = consoleReader;
        this.registerService = registerService;
    }

    @Override
    public void render() {

        String username;
        String password;
        String firstName;
        String lastName;
        String email;

        try {
            System.out.println("Register for a new account.");

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
            System.out.println("Invalid input!");
            //e.printStackTrace();
        } catch(ResourcePersistenceException e) {
            System.out.println("Username or Email already in use!");
            //e.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
        }

    }
}
