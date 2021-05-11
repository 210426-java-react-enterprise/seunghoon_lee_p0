package com.revature.seunghoon_lee_p0.screens;

import com.revature.seunghoon_lee_p0.daos.AccountDAO;
import com.revature.seunghoon_lee_p0.util.ScreenRouter;

import java.io.BufferedReader;

import static com.revature.seunghoon_lee_p0.Driver.app;

public class CreateAccountScreen extends Screen {

    private BufferedReader consoleReader;
    private ScreenRouter router;
    private AccountDAO accountDAO;

    public CreateAccountScreen(BufferedReader consoleReader, ScreenRouter router, AccountDAO accountDAO) {
        super("CreateAccountScreen", "/createAccount");
        this.consoleReader = consoleReader;
        this.router = router;
        this.accountDAO = accountDAO;
    }

    @Override
    public void render() {

        try {

            System.out.println("Please select your choice.");
            System.out.println("1) Checking account");
            System.out.println("2) Saving account");
            System.out.print(">> ");
            String userSelection = consoleReader.readLine();

            switch (userSelection) {
                case "1" :
                    if(accountDAO.createAccount()) {
                        System.out.println("New account created!");
                    } else {
                        System.out.println("Failed to create an account!");
                    }
                    break;
                case "2" :
                    System.out.println("Under construction!");
                    break;
            }
            router.navigate("/dashboard");

        } catch (Exception e) {
            System.out.println("Unknown Error!");
            app().finishApp();
            //e.printStackTrace();
        }

    }
}
