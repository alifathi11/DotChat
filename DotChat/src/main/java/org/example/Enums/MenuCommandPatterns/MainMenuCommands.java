package org.example.Enums.MenuCommandPatterns;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum MainMenuCommands implements MenuCommands {
    CHANGE_MENU("^change\\s+menu$"),
    ;

    private final String pattern;

    MainMenuCommands(String pattern) {
        this.pattern = pattern;
    }

    @Override
    public Matcher getMatcher(String input) {
        Matcher matcher = Pattern.compile(this.pattern).matcher(input);
        if (matcher.find()) return matcher;
        return null;
    }

}
