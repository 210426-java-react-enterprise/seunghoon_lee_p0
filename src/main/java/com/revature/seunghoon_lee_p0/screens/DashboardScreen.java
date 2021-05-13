package com.revature.seunghoon_lee_p0.screens;

import com.revature.seunghoon_lee_p0.models.Account;
import com.revature.seunghoon_lee_p0.models.Customer;
import com.revature.seunghoon_lee_p0.models.Transaction;
import com.revature.seunghoon_lee_p0.services.AccountService;
import com.revature.seunghoon_lee_p0.util.ScreenRouter;

import java.io.BufferedReader;

public class DashboardScreen extends Screen {

    private BufferedReader consoleReader;
    private ScreenRouter router;
    private AccountService accountService;
    private Customer currentCustomer;
    private Account currentAccount;

    public DashboardScreen(BufferedReader consoleReader, ScreenRouter router, AccountService accountService) {
        super("DashboardScreen", "/dashboard");
        this.consoleReader = consoleReader;
        this.router = router;
        this.accountService = accountService;
    }

    @Override
    public void render() {

        System.out.println("\nDashboard");
        System.out.println("----------------------------------------------------------------------");

        currentCustomer = accountService.getCurrentCustomer();
        accountService.setCustomerAccounts();
        accountService.setCurrentAccount();
        currentAccount = accountService.getCurrentAccount();

        if( currentAccount != null) {
            int accountNo = currentAccount.getAccountId();
            double balance = currentAccount.getBalance();
            String title  = "| Account No | Balance    |\n";
            String line   = "+-------------------------+\n";
            String record = "| %10d | %10.2f |\n";

            System.out.format(title);
            System.out.format(line);
            System.out.format(record, accountNo, balance);
        } else {
            System.out.println("No account found!");
        }


        System.out.println("Please select your choice.");
        System.out.println("1) View transaction history ");
        System.out.println("2) Deposit");
        System.out.println("3) Withdraw");
        System.out.println("4) Create new account");
        System.out.println("5) Log out");

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
                case "5":
                    accountService.logOut();
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
