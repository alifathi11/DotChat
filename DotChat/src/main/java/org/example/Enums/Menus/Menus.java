package org.example.Enums.Menus;

import org.example.controller.ChatMenuController;
import org.example.controller.MainMenuController;
import org.example.controller.ProfileMenuController;
import org.example.controller.RegisterMenuController;
import org.example.view.*;

public enum Menus {
    REGISTER_MENU(new RegisterMenuView(new RegisterMenuController())),
    MAIN_MENU(new MainMenuView(new MainMenuController())),
    PROFILE_MENU(new ProfileMenuView(new ProfileMenuController())),
    CHAT_MENU(new ChatMenuView(new ChatMenuController())),
    ;

    private final AppMenu menu;

    Menus(AppMenu menu) {
        this.menu = menu;
    }

    public void handleUserInput() {
        this.menu.handleUserInput();
    }
}
