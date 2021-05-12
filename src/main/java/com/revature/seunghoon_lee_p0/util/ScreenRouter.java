package com.revature.seunghoon_lee_p0.util;

import com.revature.seunghoon_lee_p0.screens.Screen;
import com.revature.seunghoon_lee_p0.util.LinkedList;

public class ScreenRouter {

    private LinkedList<Screen> screens = new LinkedList<>();

    public ScreenRouter addScreen(Screen screen) {
        screens.add(screen);
        return this;
    }

    public ScreenRouter removeScreen(Screen screen) {
        screens.remove(screen);
        return this;
    }

    public void navigate(String route) {
        for (int i = 0 ; i < screens.size() ; i++) {
            Screen screen = screens.get(i);
            if (screen.getRoute().equals(route)) {
                screen.render();
            }
        }
    }
}
