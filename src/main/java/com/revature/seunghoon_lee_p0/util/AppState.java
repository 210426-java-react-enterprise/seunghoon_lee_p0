package com.revature.seunghoon_lee_p0.util;

import com.revature.seunghoon_lee_p0.daos.AccountDAO;
import com.revature.seunghoon_lee_p0.daos.CustomerDAO;
import com.revature.seunghoon_lee_p0.screens.*;
import com.revature.seunghoon_lee_p0.services.AccountService;
import com.revature.seunghoon_lee_p0.services.LoginService;
import com.revature.seunghoon_lee_p0.services.RegisterService;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Creates screen router
 * Check the state of app to start and finish and to control the flow of screen
 */
public class AppState {

    private final ScreenRouter router;
    private boolean isRunning;
    private boolean isLoggedIn;

    public AppState() {

        final BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        final CustomerDAO customerDAO = new CustomerDAO();
        final AccountDAO accountDAO = new AccountDAO();
        final LoginService loginService = new LoginService(customerDAO);
        final RegisterService registerService = new RegisterService(customerDAO);
        final AccountService accountService = new AccountService(accountDAO);

        isRunning = true;
        router = new ScreenRouter();

        router.addScreen(new HomeScreen(consoleReader, router))
              .addScreen(new RegisterScreen(consoleReader, registerService))
              .addScreen(new LoginScreen(consoleReader, router, loginService, accountService))
              .addScreen(new DashboardScreen(consoleReader, router, accountService))
              .addScreen(new TransactionScreen(consoleReader, router, accountService))
              .addScreen(new CreateAccountScreen(consoleReader, router, accountService))
              .addScreen(new DepositScreen(consoleReader, router, accountService))
              .addScreen(new WithdrawScreen(consoleReader, router, accountService));
    }

    /**
     * Starts app from home screen and controls the flow
     */
    public void startApp() {
        System.out.println("\nWelcome to Lee Bank!");
        while (isRunning) {
            router.navigate("/home");
        }
    }

    /**
     * Finishes app
     */
    public void finishApp() {
        System.out.println("\nGoodbye!");
        this.isRunning = false;
    }

}
