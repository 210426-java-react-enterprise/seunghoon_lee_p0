package com.revature.seunghoon_lee_p0.screens;

import com.revature.seunghoon_lee_p0.util.ScreenRouter;

import java.io.BufferedReader;

public class WelcomeScreen extends Screen {

    private BufferedReader consoleReader;
    private ScreenRouter router;

    public WelcomeScreen(BufferedReader consoleReader, ScreenRouter router) {
        super("WelcomeScreen", "/welcome");
        this.consoleReader = consoleReader;
        this.router = router;
    }

    @Override
    public void render() {
        System.out.println("Welcome to Lee Bank!");
        System.out.println("1) Login");
        System.out.println("2) Register");
        System.out.println("3) Exit");
    }
}
