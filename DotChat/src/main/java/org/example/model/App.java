package org.example.model;

import org.example.Enums.Menus.Menus;

import java.util.ArrayList;

public class App {
    private static App app;

    private boolean exitApp;
    private Menus currentMenu;
    private User currentUser;

    private App() {
        this.exitApp = false;
        this.currentMenu = Menus.REGISTER_MENU;
        this.currentUser = null;
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

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

}
