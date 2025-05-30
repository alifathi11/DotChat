package org.example.view;

import org.example.Enums.MenuCommandPatterns.ChatMenuCommands;
import org.example.Enums.MenuCommandPatterns.MainMenuCommands;
import org.example.controller.ChatMenuController;
import org.example.controller.MainMenuController;

import java.util.Scanner;

public class ChatMenuView implements AppMenu {

    private final ChatMenuController controller;
    private final Scanner scanner;

    public ChatMenuView(ChatMenuController controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);

        controller.setView(this);
    }

    @Override
    public void handleUserInput() {
        String input = scanner.nextLine().trim();
        boolean matched = false;

        for (ChatMenuCommands command : ChatMenuCommands.values()) {
            if (command.getMatcher(input) != null) {
                execute(command);
                matched = true;
                break;
            }
        }
        if (!matched) System.out.println("Invalid command. Please try again.");
    }

    private void execute(ChatMenuCommands command) {
        switch (command) {
            case SEND_MESSAGE -> controller.sendMessage();
            default -> System.out.println("Unknown error.");
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
