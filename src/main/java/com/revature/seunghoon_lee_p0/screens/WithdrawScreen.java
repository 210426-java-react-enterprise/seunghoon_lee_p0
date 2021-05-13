package com.revature.seunghoon_lee_p0.screens;

import com.revature.seunghoon_lee_p0.services.AccountService;
import com.revature.seunghoon_lee_p0.util.ScreenRouter;

import java.io.BufferedReader;

/**
 * Gets ammount to withdraw from customer
 * Save transaction data
 */
public class WithdrawScreen extends Screen {

    private BufferedReader consoleReader;
    private ScreenRouter router;
    private AccountService accountService;

    public WithdrawScreen(BufferedReader consoleReader, ScreenRouter router, AccountService accountService) {
        super("WithdrawScreen", "/withdraw");
        this.consoleReader = consoleReader;
        this.router = router;
        this.accountService = accountService;
    }

    /**
     * Renders screen
     * to get amount to withdraw form customer and save it into transaction table
     */
    @Override
    public void render() {

        try {

            System.out.println("\nWithdraw");
            System.out.println("----------------------------------------------------------------------");

            System.out.print("Amount: ");
            double amount = Double.parseDouble(consoleReader.readLine());
            if (accountService.saveTransaction("withdraw", amount)) {
                System.out.println("Withdraw succeeded!");
            } else {
                System.out.println("Withdraw failed!");
            }

        } catch (Exception e) {
            System.out.println("Unkown Error!");
            e.printStackTrace();
        }

    }

}
