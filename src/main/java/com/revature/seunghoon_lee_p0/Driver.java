package com.revature.seunghoon_lee_p0;

import com.revature.seunghoon_lee_p0.util.AppState;

public class Driver {

    private static AppState app = new AppState();

    public static void main(String[] args) {
        app.startApp();
    }

    public static AppState app() {
        return app;
    }

}
