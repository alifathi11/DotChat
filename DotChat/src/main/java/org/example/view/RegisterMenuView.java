package org.example.view;

import org.example.Enums.MenuCommandPatterns.RegisterMenuCommands;
import org.example.controller.RegisterMenuController;

import java.util.Scanner;

public class RegisterMenuView implements AppMenu {

    private final RegisterMenuController controller;
    private final Scanner scanner;

    public RegisterMenuView(RegisterMenuController controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);

        controller.setView(this);
    }

    @Override
    public void handleUserInput() {
        String input = scanner.nextLine().trim();
        boolean matched = false;

        for (RegisterMenuCommands command : RegisterMenuCommands.values()) {
            if (command.getMatcher(input) != null) {
                execute(command);
                matched = true;
                break;
            }
        }
        if (!matched) System.out.println("Invalid command. Please try again.");
    }

    private void execute(RegisterMenuCommands command) {
        switch (command) {
            case LOGIN -> controller.login();
            case SIGNUP -> controller.signup();
            case FORGET_PASSWORD -> controller.forgetPassword();
            case EXIT -> controller.exit();
            default -> System.out.println("Unknown Error.");
        }
    }

    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }

    @Override
    public String getResponse(String prompt) {
        System.out.println(prompt);
        return scanner.nextLine();
    }
}
