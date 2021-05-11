package com.revature.seunghoon_lee_p0.screens;

import com.revature.seunghoon_lee_p0.daos.AccountDAO;
import com.revature.seunghoon_lee_p0.exceptions.AuthenticationException;
import com.revature.seunghoon_lee_p0.exceptions.InvalidRequestException;
import com.revature.seunghoon_lee_p0.models.Customer;
import com.revature.seunghoon_lee_p0.services.LoginService;
import com.revature.seunghoon_lee_p0.util.ScreenRouter;

import java.io.BufferedReader;

public class LoginScreen extends Screen {

    private BufferedReader consoleReader;
    private ScreenRouter router;
    private LoginService loginService;
    private Customer currentCustomer;
    private AccountDAO accountDAO;

    public LoginScreen(BufferedReader consoleReader, ScreenRouter router, LoginService loginService) {
        super("LoginScreen", "/login");
        this.consoleReader = consoleReader;
        this.router = router;
        this.loginService = loginService;
    }

    @Override
    public void render() {

        try {

            String username;
            String password;

            System.out.println("Please enter your username and password.");

            System.out.print("Username: ");
            username = consoleReader.readLine();
            System.out.print("Password: ");
            password = consoleReader.readLine();

            currentCustomer = loginService.authenticate(username, password);
            if(currentCustomer != null) {

                System.out.println("Login Successful!");
                accountDAO = new AccountDAO(currentCustomer);

                router.addScreen(new DashboardScreen(consoleReader, router, accountDAO))
                      .addScreen(new CreateAccountScreen(consoleReader, router, accountDAO))
                      .addScreen(new DepositScreen(consoleReader, router, accountDAO))
                      .addScreen(new WithdrawScreen(consoleReader, router, accountDAO));

                router.navigate("/dashboard");

            }

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
