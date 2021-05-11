package com.revature.seunghoon_lee_p0.screens;

import com.revature.seunghoon_lee_p0.util.ScreenRouter;

import java.io.BufferedReader;

public class DashboardScreen extends Screen {

    private BufferedReader consoleReader;
    private ScreenRouter router;

    public DashboardScreen(BufferedReader consoleReader, ScreenRouter router) {
        super("DashboardScreen", "/dashboard");
        this.consoleReader = consoleReader;
        this.router = router;
    }

    @Override
    public void render() {

        System.out.println("Please select your choice!");
        System.out.println("1) Create new account");
        System.out.println("2) Deposit");
        System.out.println("3) Withdraw");
        System.out.println("4) Log out");

    }
}
