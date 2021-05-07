package com.revature.seunghoon_lee_p0.screens;

import com.revature.seunghoon_lee_p0.util.ScreenRouter;
import static com.revature.seunghoon_lee_p0.Driver.app;
import java.io.BufferedReader;

public class WelcomeScreen extends Screen {

    private BufferedReader consoleReader;
    private ScreenRouter router;

    public WelcomeScreen(BufferedReader consoleReader, ScreenRouter router) {
        super("WelcomeScreen", "/welcome");
        this.consoleReader = consoleReader;
        this.router = router;
    }

    @Override
    public void render() {

        System.out.println("Welcome to Lee Bank!");
        System.out.println("1) Login");
        System.out.println("2) Register");
        System.out.println("3) Exit");

        try{

            System.out.print(">> ");
            String userSelection = consoleReader.readLine();

            switch (userSelection) {

                case "1":
                    router.navigate("/login");
                    break;

                case "2":
                    router.navigate("/register");
                    break;
                case "3":
                    app().setIsRunning(false);
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
