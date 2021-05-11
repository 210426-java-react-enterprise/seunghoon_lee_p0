package com.revature.seunghoon_lee_p0.screens;

import com.revature.seunghoon_lee_p0.daos.AccountDAO;
import com.revature.seunghoon_lee_p0.util.ScreenRouter;

import java.io.BufferedReader;

import static com.revature.seunghoon_lee_p0.Driver.app;

public class WithdrawScreen extends Screen {

    private BufferedReader consoleReader;
    private ScreenRouter router;
    private AccountDAO accountDAO;

    public WithdrawScreen(BufferedReader consoleReader, ScreenRouter router, AccountDAO accountDAO) {
        super("WithdrawScreen", "/withdraw");
        this.consoleReader = consoleReader;
        this.router = router;
        this.accountDAO = accountDAO;
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
