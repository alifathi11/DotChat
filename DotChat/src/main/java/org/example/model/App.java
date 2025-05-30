package org.example.model;

import org.example.Enums.Menus.Menus;

public class App {
    private static App app;

    private boolean exitApp = false;
    private Menus currentMenu = Menus.REGISTER_MENU;

    private App() {

    }

    public static App getInstance() {
        if (app == null) {
            app = new App();
        }
        return app;
    }

    public void setCurrentMenu(Menus currentMenu) {
        this.currentMenu = currentMenu;
    }

    public Menus getCurrentMenu() {
        return currentMenu;
    }

    public void exit() {
        this.exitApp = true;
    }

    public boolean isAppFinished() {
        return exitApp;
    }
}
