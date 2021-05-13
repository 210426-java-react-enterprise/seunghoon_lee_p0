package com.revature.seunghoon_lee_p0.screens;

import com.revature.seunghoon_lee_p0.models.Transaction;
import com.revature.seunghoon_lee_p0.services.AccountService;
import com.revature.seunghoon_lee_p0.util.LinkedList;
import com.revature.seunghoon_lee_p0.util.ScreenRouter;

import java.io.BufferedReader;

public class TransactionScreen extends Screen {

    private BufferedReader consoleReader;
    private ScreenRouter router;
    private AccountService accountService;

    public TransactionScreen(BufferedReader consoleReader, ScreenRouter router, AccountService accountService) {
        super("TransactionScreen", "/transaction");
        this.consoleReader = consoleReader;
        this.router = router;
        this.accountService = accountService;
    }

    @Override
    public void render() {

        try {

            LinkedList<Transaction> transactions = accountService.getTransactionHistory();

            String title  = "| Date       | Type       | Amount     | Balance    |\n";
            String line   = "+---------------------------------------------------+\n";
            String record = "| %10s | %-10s | %10.2f | %10.2f |\n";

            System.out.format(title);
            System.out.format(line);
            do {
                Transaction t = transactions.poll();
                String date = t.getDate();
                String type = t.getType();
                double amount = t.getAmount();
                double balance = t.getBalance();
                System.out.format(record, date, type, amount, balance);
            } while(transactions.peek() != null);

            System.out.print("Press any key to go back to Dashboard.");
            consoleReader.readLine();
        } catch(Exception e) {
            e.printStackTrace();
        }

    }
}
