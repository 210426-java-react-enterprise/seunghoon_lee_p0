package com.revature.seunghoon_lee_p0.screens;

import com.revature.seunghoon_lee_p0.exceptions.AuthenticationException;
import com.revature.seunghoon_lee_p0.exceptions.InvalidRequestException;
import com.revature.seunghoon_lee_p0.models.Customer;
import com.revature.seunghoon_lee_p0.services.LoginService;
import com.revature.seunghoon_lee_p0.util.ScreenRouter;

import java.io.BufferedReader;

public class LoginScreen extends Screen {

    private BufferedReader consoleReader;
    private ScreenRouter router;
    private LoginService loginService;

    public LoginScreen(BufferedReader consoleReader, ScreenRouter router, LoginService loginService) {
        super("LoginScreen", "/login");
        this.consoleReader = consoleReader;
        this.router = router;
    }

    @Override
    public void render() {


        try {

            String username;
            String password;

            System.out.println("Please enter your username and password!");

            System.out.print("Username: ");
            username = consoleReader.readLine();
            System.out.print("Password: ");
            password = consoleReader.readLine();

            Customer authenticatedCustomer = loginService.authenticate(username, password);
            if(authenticatedCustomer != null) {
                router.navigate("/dashboard");
            }

        } catch (InvalidRequestException e) {
            System.out.println("Invalid username or password!");
            //e.printStackTrace();
        } catch (AuthenticationException e) {
            System.out.println("Could not find that username or password");
            //e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
