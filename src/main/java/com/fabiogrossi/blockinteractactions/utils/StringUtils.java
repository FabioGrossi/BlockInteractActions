package com.fabiogrossi.blockinteractactions.utils;

public class StringUtils {

    private StringUtils() {}

    public static String createPhrase(String[] strings) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String string : strings) {
            stringBuilder.append(string);
            stringBuilder.append(" ");
        }
        return stringBuilder.toString().trim();
    }

}
