package com.revature.seunghoon_lee_p0.screens;

import com.revature.seunghoon_lee_p0.services.AccountService;
import com.revature.seunghoon_lee_p0.util.ScreenRouter;

import java.io.BufferedReader;

import static com.revature.seunghoon_lee_p0.Driver.app;

public class DepositScreen extends Screen {

    private BufferedReader consoleReader;
    private ScreenRouter router;
    private AccountService accountService;

    public DepositScreen(BufferedReader consoleReader, ScreenRouter router, AccountService accountService) {
        super("DepositScreen", "/deposit");
        this.consoleReader = consoleReader;
        this.router = router;
        this.accountService = accountService;
    }

    @Override
    public void render() {

        try {


        } catch (Exception e) {
            System.out.println("Unkown Error!");
            app().finishApp();
            //e.printStackTrace();
        }

    }


}
