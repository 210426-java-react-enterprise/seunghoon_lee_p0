package com.revature.seunghoon_lee_p0.screens;

import com.revature.seunghoon_lee_p0.services.AccountService;
import com.revature.seunghoon_lee_p0.util.ScreenRouter;

import java.io.BufferedReader;

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

        accountService.setCustomerAccounts();
        int nAccounts = accountService.getCustomerAccounts().size();
        if( nAccounts > 0) {
            System.out.println("You have " + nAccounts + " checking account!");
            accountService.setCurrentAccount();
        } else {
            System.out.println("No account found!");
        }

        System.out.println("Please select your choice.");
        System.out.println("1) View transaction history ");
        System.out.println("2) Deposit");
        System.out.println("3) Withdraw");
        System.out.println("4) Create new account");

        try{

            System.out.print(">> ");
            String userSelection = consoleReader.readLine();

            switch (userSelection) {

                case "1":
                    router.navigate("/transaction");
                    break;
                case "2":
                    router.navigate("/deposit");
                    break;
                case "3":
                    router.navigate("/withdraw");
                    break;
                case "4":
                    router.navigate("/createAccount");
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
