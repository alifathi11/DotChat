package org.example.controller;

import org.example.Enums.Menus.Menus;
import org.example.model.App;
import org.example.view.MainMenuView;

public class MainMenuController {

    private MainMenuView view;

    public void setView(MainMenuView view) {
        this.view = view;
    }

    public void changeMenu() {
        String menu = view.getUserResponse("Enter menu: ");

        switch (menu.toLowerCase()) {
            case "register menu" -> {
                App.getInstance().setCurrentMenu(Menus.REGISTER_MENU);
                view.showMessage("You are now in Register menu.");
            }
            case "chats menu" -> {
                App.getInstance().setCurrentMenu(Menus.CHAT_MENU);
                view.showMessage("You are now in Chat menu.");
            }
            case "profile menu" -> {
                App.getInstance().setCurrentMenu(Menus.PROFILE_MENU);
                view.showMessage("You are now in Profile menu.");
            }
        }
    }

}
