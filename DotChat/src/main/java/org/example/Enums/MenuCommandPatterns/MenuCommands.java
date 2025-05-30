package org.example.Enums.MenuCommandPatterns;

import java.util.regex.Matcher;

public interface MenuCommands {
    Matcher getMatcher(String input);
}
