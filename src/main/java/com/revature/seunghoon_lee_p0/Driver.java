package com.revature.seunghoon_lee_p0;

import com.revature.seunghoon_lee_p0.util.AppState;

/**
 * Lee Bank
 * Revature 2104-java-react-enterprise Project 0
 *
 * @author Seunghoon Lee
 * @version 1.0
 * @since 05/05/2021
 */
public class Driver {

    private static AppState app = new AppState();

    public static void main(String[] args) {
        app.startApp();
    }

    public static AppState app() {
        return app;
    }

}
