package org.example.view;

import java.util.regex.Matcher;

public interface AppMenu {
    void handleUserInput();
    void showMessage(String message);
    String getUserResponse(String prompt);
}
