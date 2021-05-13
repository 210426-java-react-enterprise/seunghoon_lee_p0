package com.revature.seunghoon_lee_p0.screens;

import com.revature.seunghoon_lee_p0.services.AccountService;
import com.revature.seunghoon_lee_p0.util.ScreenRouter;

import java.io.BufferedReader;

/**
 * Gets ammount to deposit from customer
 * Save transaction data
 */
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

    /**
     * Renders screen
     * to get amount to deposit form customer and save it into transaction table
     */
    @Override
    public void render() {

        try {
            System.out.println("\nDeposit");
            System.out.println("----------------------------------------------------------------------");

            System.out.print("Amount: ");
            double amount = Double.parseDouble(consoleReader.readLine());
            if (accountService.saveTransaction("deposit", amount)) {
                System.out.println("Deposit succeeded!");
            } else {
                System.out.println("Deposit failed!");
            }

        } catch (Exception e) {
            System.out.println("Unkown Error!");
            e.printStackTrace();
        }

    }

}
