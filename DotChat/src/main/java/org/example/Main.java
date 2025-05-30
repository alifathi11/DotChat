package org.example;

import org.example.model.App;
import org.example.view.AppView;

public class Main {
    public static void main(String[] args) {
        AppView appView = new AppView();
        App app = App.getInstance();

        appView.run(app);
    }
}