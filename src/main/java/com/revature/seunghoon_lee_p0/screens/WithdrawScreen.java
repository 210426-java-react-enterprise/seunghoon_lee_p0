package com.revature.seunghoon_lee_p0.screens;

import com.revature.seunghoon_lee_p0.services.AccountService;
import com.revature.seunghoon_lee_p0.util.ScreenRouter;

import java.io.BufferedReader;


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
