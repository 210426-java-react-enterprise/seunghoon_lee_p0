package com.revature.seunghoon_lee_p0.screens;

import com.revature.seunghoon_lee_p0.models.Account;
import com.revature.seunghoon_lee_p0.services.AccountService;
import com.revature.seunghoon_lee_p0.services.LoginService;
import com.revature.seunghoon_lee_p0.util.ScreenRouter;

import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;

import static com.revature.seunghoon_lee_p0.Driver.app;

public class CreateAccountScreen extends Screen {

    private BufferedReader consoleReader;
    private ScreenRouter router;
    private AccountService accountService;

    public CreateAccountScreen(BufferedReader consoleReader, ScreenRouter router, AccountService accountService) {
        super("CreateAccountScreen", "/createAccount");
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
