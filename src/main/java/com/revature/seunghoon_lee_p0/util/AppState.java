package com.revature.seunghoon_lee_p0.util;

import com.revature.seunghoon_lee_p0.daos.CustomerDAO;
import com.revature.seunghoon_lee_p0.screens.*;
import com.revature.seunghoon_lee_p0.services.LoginService;
import com.revature.seunghoon_lee_p0.services.RegisterService;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AppState {

    private final ScreenRouter router;
    private boolean isRunning;

    public AppState() {

        final BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        final CustomerDAO customerDAO = new CustomerDAO();
        final LoginService loginService = new LoginService(customerDAO);
        final RegisterService registerService = new RegisterService(customerDAO);

        isRunning = true;
        router = new ScreenRouter();

        router.addScreen(new HomeScreen(consoleReader, router))
              .addScreen(new RegisterScreen(consoleReader, registerService))
              .addScreen(new LoginScreen(consoleReader, router, loginService));
    }

    public void startApp() {
        System.out.println("Welcome to Lee Bank!");
        while (isRunning) {
            router.navigate("/home");
        }
    }

    public void finishApp() {
        System.out.println("Goodbye!");
        this.isRunning = false;
    }

}
