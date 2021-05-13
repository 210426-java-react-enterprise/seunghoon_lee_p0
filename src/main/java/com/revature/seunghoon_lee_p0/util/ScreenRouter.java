package com.revature.seunghoon_lee_p0.util;

import com.revature.seunghoon_lee_p0.screens.Screen;

/**
 * LinkedList of screens
 * Adds and removes screen
 * Navigate to specific screen by route
 */
public class ScreenRouter {

    private LinkedList<Screen> screens = new LinkedList<>();

    /**
     * Adds screen
     *
     * @param screen
     * @return ScreenRouter itself
     */
    public ScreenRouter addScreen(Screen screen) {
        screens.add(screen);
        return this;
    }

    /**
     * Removes screen
     *
     * @param screen
     * @return ScreenRouter itself
     */
    public ScreenRouter removeScreen(Screen screen) {
        screens.remove(screen);
        return this;
    }

    /**
     * Navigate to specific screen by route
     * 
     * @param route
     */
    public void navigate(String route) {
        for (int i = 0 ; i < screens.size() ; i++) {
            Screen screen = screens.get(i);
            if (screen.getRoute().equals(route)) {
                screen.render();
            }
        }
    }
}
