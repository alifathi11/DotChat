package org.example.view;

import org.example.Enums.MenuCommandPatterns.MainMenuCommands;
import org.example.Enums.MenuCommandPatterns.RegisterMenuCommands;
import org.example.controller.MainMenuController;
import org.example.controller.RegisterMenuController;

import java.util.Scanner;

public class MainMenuView implements AppMenu {

    private final MainMenuController controller;
    private final Scanner scanner;

    public MainMenuView(MainMenuController controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);

        controller.setView(this);
    }

    @Override
    public void handleUserInput() {
        String input = scanner.nextLine().trim();
        boolean matched = false;

        for (MainMenuCommands command : MainMenuCommands.values()) {
            if (command.getMatcher(input) != null) {
                execute(command);
                matched = true;
                break;
            }
        }
        if (!matched) System.out.println("Invalid command. Please try again.");
    }

    private void execute(MainMenuCommands command) {
        switch (command) {
            case CHANGE_MENU -> controller.changeMenu();
            default -> System.out.println("Unknown Error.");
        }
    }

    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }

    @Override
    public String getUserResponse(String prompt) {
        System.out.println(prompt);
        return scanner.nextLine();
    }
}
