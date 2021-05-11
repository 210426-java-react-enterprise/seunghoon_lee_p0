package com.revature.seunghoon_lee_p0.screens;

import com.revature.seunghoon_lee_p0.daos.AccountDAO;
import com.revature.seunghoon_lee_p0.exceptions.AuthenticationException;
import com.revature.seunghoon_lee_p0.exceptions.InvalidRequestException;
import com.revature.seunghoon_lee_p0.models.Customer;
import com.revature.seunghoon_lee_p0.services.AccountService;
import com.revature.seunghoon_lee_p0.services.LoginService;
import com.revature.seunghoon_lee_p0.util.ScreenRouter;

import java.io.BufferedReader;

public class LoginScreen extends Screen {

    private BufferedReader consoleReader;
    private ScreenRouter router;
    private LoginService loginService;
    private Customer currentCustomer;
    private AccountDAO accountDAO;
    private AccountService accountService;

    public LoginScreen(BufferedReader consoleReader, ScreenRouter router, LoginService loginService) {
        super("LoginScreen", "/login");
        this.consoleReader = consoleReader;
        this.router = router;
        this.loginService = loginService;
        accountDAO = new AccountDAO();
        accountService = new AccountService(accountDAO, null);
    }

    @Override
    public void render() {

        try {

            String username;
            String password;

            System.out.println("Please enter your username and password!");

            System.out.print("Username: ");
            username = consoleReader.readLine();
            System.out.print("Password: ");
            password = consoleReader.readLine();

            currentCustomer = loginService.authenticate(username, password);
            if(currentCustomer != null) {

                System.out.println("Login Successful!");
                accountService.setCurrentCustomer(currentCustomer);
                router.addScreen(new DashboardScreen(consoleReader, router, accountService))
                      .addScreen(new CreateAccountScreen(consoleReader, router, accountService))
                      .addScreen(new DepositScreen(consoleReader, router, accountService))
                      .addScreen(new WithdrawScreen(consoleReader, router, accountService));

                router.navigate("/dashboard");

            }

        } catch (InvalidRequestException e) {
            System.out.println("Invalid username or password!");
            //e.printStackTrace();
        } catch (AuthenticationException e) {
            System.out.println("Could not find that username or password");
            //e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
