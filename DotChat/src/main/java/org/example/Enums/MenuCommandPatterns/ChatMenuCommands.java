package org.example.Enums.MenuCommandPatterns;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum ChatMenuCommands implements MenuCommands {
    SEND_MESSAGE("^send\\s+message$"),
    ;

    private final String pattern;

    ChatMenuCommands(String pattern) {
        this.pattern = pattern;
    }

    @Override
    public Matcher getMatcher(String input) {
        Matcher matcher = Pattern.compile(this.pattern).matcher(input);
        if (matcher.find()) return matcher;
        return null;
    }

}
