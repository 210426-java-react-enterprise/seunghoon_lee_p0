package com.revature.seunghoon_lee_p0.screens;

import com.revature.seunghoon_lee_p0.services.AccountService;
import com.revature.seunghoon_lee_p0.util.ScreenRouter;

import java.io.BufferedReader;

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

            System.out.println("\nCreate new Account");
            System.out.println("----------------------------------------------------------------------");

            System.out.println("Please select your choice.");
            System.out.println("1) Checking account");
            System.out.println("2) Saving account");
            System.out.print(">> ");
            String userSelection = consoleReader.readLine();

            switch (userSelection) {
                case "1" :
                    if(accountService.createAccount()) {
                        System.out.println("New account created!");
                    } else {
                        System.out.println("Failed to create an account!");
                    }
                    break;
                case "2" :
                    System.out.println("Under construction!");
                    break;
                default :
                    System.out.println("Invalid selection!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
