package org.example.Enums.MenuCommandPatterns;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum RegisterMenuCommands implements MenuCommands {
    LOGIN("^login$"),
    SIGNUP("^signup$"),
    FORGET_PASSWORD("^forget\\s+password$"),
    EXIT("^exit$"),
    ;

    private final String pattern;

    RegisterMenuCommands(String pattern) {
        this.pattern = pattern;
    }

    @Override
    public Matcher getMatcher(String input) {
        Matcher matcher = Pattern.compile(this.pattern).matcher(input);
        if (matcher.find()) return matcher;
        return null;
    }
}
