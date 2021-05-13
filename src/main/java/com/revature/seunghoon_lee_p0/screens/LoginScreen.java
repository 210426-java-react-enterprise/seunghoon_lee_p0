package com.revature.seunghoon_lee_p0.screens;

import com.revature.seunghoon_lee_p0.exceptions.AuthenticationException;
import com.revature.seunghoon_lee_p0.exceptions.InvalidRequestException;
import com.revature.seunghoon_lee_p0.models.Customer;
import com.revature.seunghoon_lee_p0.services.AccountService;
import com.revature.seunghoon_lee_p0.services.LoginService;
import com.revature.seunghoon_lee_p0.util.ScreenRouter;

import java.io.BufferedReader;

/**
 * Gets customer input to log in
 * Validate user credentials
 * Navigate to dashboard screen if the customer is authenticated
 */
public class LoginScreen extends Screen {

    private BufferedReader consoleReader;
    private ScreenRouter router;
    private LoginService loginService;
    private AccountService accountService;
    private Customer currentCustomer;

    public LoginScreen(BufferedReader consoleReader, ScreenRouter router, LoginService loginService, AccountService accountService) {
        super("LoginScreen", "/login");
        this.consoleReader = consoleReader;
        this.router = router;
        this.loginService = loginService;
        this.accountService = accountService;
        this.currentCustomer = null;
    }

    /**
     * Renders screen
     * to get customer credentials to login and navigate to dashboard screen
     */
    @Override
    public void render() {

        try {

            String username;
            String password;

            System.out.println("\nLog In");
            System.out.println("----------------------------------------------------------------------");

            System.out.println("Please enter your username and password.");

            System.out.print("Username: ");
            username = consoleReader.readLine();
            System.out.print("Password: ");
            password = consoleReader.readLine();

            currentCustomer = loginService.authenticate(username, password);
            if(currentCustomer != null) {
                accountService.setCurrentCustomer(currentCustomer);
                System.out.println("Login Successful!");
            }

            while(accountService.isLoggedIn()) {
                router.navigate("/dashboard");
            }

            currentCustomer = null;

        } catch (InvalidRequestException e) {
            System.out.println("Invalid username or password!");
            //e.printStackTrace();
        } catch (AuthenticationException e) {
            System.out.println("Could not find that username or password!");
            //e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
