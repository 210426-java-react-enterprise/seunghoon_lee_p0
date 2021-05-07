package com.revature.seunghoon_lee_p0.util;

import com.revature.seunghoon_lee_p0.screens.LoginScreen;
import com.revature.seunghoon_lee_p0.screens.RegisterScreen;
import com.revature.seunghoon_lee_p0.screens.WelcomeScreen;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AppState {
    private BufferedReader consoleReader;
    private ScreenRouter router;
    private boolean isRunning = true;

    public AppState() {

        isRunning = true;
        consoleReader = new BufferedReader(new InputStreamReader(System.in));

        router = new ScreenRouter();
        router.addScreen(new WelcomeScreen(consoleReader, router))
              .addScreen(new LoginScreen())
              .addScreen(new RegisterScreen());
    }

    public ScreenRouter getRouter() {
        return router;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void setIsRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }
}
