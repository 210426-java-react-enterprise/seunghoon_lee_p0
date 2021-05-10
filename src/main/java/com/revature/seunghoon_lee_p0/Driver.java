package com.revature.seunghoon_lee_p0;

import com.revature.seunghoon_lee_p0.util.AppState;

public class Driver {

    private static AppState app = new AppState();

    public static void main(String[] args) {

        System.out.println("Welcome to Lee Bank!");

        while(app.isRunning()) {
            app.getRouter().navigate("/welcome");
        }
        System.out.println("\n");
        System.out.println("Bye!");

    }

    public static AppState app() {
        return app;
    }

}
