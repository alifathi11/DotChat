package org.example.Enums.Menus;

import org.example.controller.RegisterMenuController;
import org.example.view.AppMenu;
import org.example.view.RegisterMenuView;

public enum Menus {
    REGISTER_MENU(new RegisterMenuView(new RegisterMenuController())),
    ;

    private final AppMenu menu;

    Menus(AppMenu menu) {
        this.menu = menu;
    }

    public void handleUserInput() {
        this.menu.handleUserInput();
    }
}
