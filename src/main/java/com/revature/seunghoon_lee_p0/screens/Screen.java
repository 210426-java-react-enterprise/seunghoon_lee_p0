package com.revature.seunghoon_lee_p0.screens;

/**
 * Parent class for all screen classes
 * Has abstract method, render()
 */
public abstract class Screen {

    protected String name;
    protected String route;

    public Screen(String name, String route) {
        this.name = name;
        this.route = route;
    }

    public String getName() {
        return name;
    }

    public String getRoute() {
        return route;
    }

    public abstract void render();
}
