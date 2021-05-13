package com.revature.seunghoon_lee_p0.screens;

import com.revature.seunghoon_lee_p0.util.ScreenRouter;
import static com.revature.seunghoon_lee_p0.Driver.app;
import java.io.BufferedReader;

/**
 * Show main menu for customer to select
 * Navigate to selected screen
 */
public class HomeScreen extends Screen {

    private BufferedReader consoleReader;
    private ScreenRouter router;

    public HomeScreen(BufferedReader consoleReader, ScreenRouter router) {
        super("WelcomeScreen", "/home");
        this.consoleReader = consoleReader;
        this.router = router;
    }

    /**
     * Renders screen
     * to show main menu and get user selection
     */
    @Override
    public void render() {

        System.out.println("\nHome");
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Please select your choice.");
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
