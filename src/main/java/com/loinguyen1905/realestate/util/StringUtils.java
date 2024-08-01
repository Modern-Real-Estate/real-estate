package com.loinguyen1905.realestate.util;

public final class StringUtils {
    public static Boolean isNullOrEmpty(String s) {
        return s.equals("") || s == null;
    }
    public static String convertCamelToSnake(String camelCaseString) {
        return camelCaseString
                .replaceAll("([a-z])([A-Z]+)", "$1_$2")
                .toLowerCase();
    }

    public static String convertSnakeToCame(String snakeCaseString) {
        StringBuilder camelCaseString = new StringBuilder();

        String[] parts = snakeCaseString.split("_");

        for (int i = 0; i < parts.length; i++) {
            String part = parts[i];
            if (i == 0) {
                camelCaseString.append(part.toLowerCase());
            } else {
                camelCaseString.append(part.substring(0, 1).toUpperCase());
                camelCaseString.append(part.substring(1).toLowerCase());
            }
        }

        return camelCaseString.toString();
    }

    public static String convertSnakeToCamelCase(String snakeCaseString) {
        StringBuilder camelCaseString = new StringBuilder();

        String[] parts = snakeCaseString.split("_");

        for (String part : parts) {
            if (part.length() > 0) {
                camelCaseString.append(part.substring(0, 1).toUpperCase());
                camelCaseString.append(part.substring(1).toLowerCase());
            }
        }

        return camelCaseString.toString();
    }
}