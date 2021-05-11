package com.revature.seunghoon_lee_p0.util;

import com.revature.seunghoon_lee_p0.daos.LeeBankDAO;
import com.revature.seunghoon_lee_p0.models.Customer;
import com.revature.seunghoon_lee_p0.screens.DashboardScreen;
import com.revature.seunghoon_lee_p0.screens.LoginScreen;
import com.revature.seunghoon_lee_p0.screens.RegisterScreen;
import com.revature.seunghoon_lee_p0.screens.HomeScreen;
import com.revature.seunghoon_lee_p0.services.LoginService;
import com.revature.seunghoon_lee_p0.services.RegisterService;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AppState {

    private final ScreenRouter router;
    private boolean isRunning;

    public AppState() {

        final BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        final LeeBankDAO leeBankDAO = new LeeBankDAO();
        final LoginService loginService = new LoginService(leeBankDAO);
        final RegisterService registerService = new RegisterService(leeBankDAO);

        isRunning = true;
        router = new ScreenRouter();
        router.addScreen(new HomeScreen(consoleReader, router))
              .addScreen(new LoginScreen(consoleReader, router, loginService))
              .addScreen(new RegisterScreen(consoleReader, registerService))
              .addScreen(new DashboardScreen(consoleReader, router));
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
