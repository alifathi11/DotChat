package org.example.view;

import org.example.model.App;

public class AppView {
    public void run(App app) {

        while (!app.isAppFinished()) {
            app.getCurrentMenu().handleUserInput();
        }

    }
}
