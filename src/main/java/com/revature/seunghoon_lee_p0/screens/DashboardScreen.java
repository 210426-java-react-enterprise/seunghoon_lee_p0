package com.revature.seunghoon_lee_p0.screens;

import com.revature.seunghoon_lee_p0.services.AccountService;
import com.revature.seunghoon_lee_p0.util.ScreenRouter;

import java.io.BufferedReader;

import static com.revature.seunghoon_lee_p0.Driver.app;

public class DashboardScreen extends Screen {

    private BufferedReader consoleReader;
    private ScreenRouter router;
    private AccountService accountService;

    public DashboardScreen(BufferedReader consoleReader, ScreenRouter router, AccountService accountService) {
        super("DashboardScreen", "/dashboard");
        this.consoleReader = consoleReader;
        this.router = router;
        this.accountService = accountService;
    }

    @Override
    public void render() {

        System.out.println("Please select your choice!");
        System.out.println("1) Create new account");
        System.out.println("2) Deposit");
        System.out.println("3) Withdraw");
        System.out.println("4) Log out");

        try{

            System.out.print(">> ");
            String userSelection = consoleReader.readLine();

            switch (userSelection) {

                case "1":
                    router.navigate("/createAccount");
                    break;
                case "2":
                    router.navigate("/deposit");
                    break;
                case "3":
                    router.navigate("/withdraw");
                    break;
                case "4":
                    app().finishApp();
                    break;
                default:
                    System.out.println("Invalid selection!");

            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }

    }
}
