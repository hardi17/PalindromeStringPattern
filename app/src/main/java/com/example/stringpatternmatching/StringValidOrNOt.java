package com.example.stringpatternmatching;

public class StringValidOrNOt {

    public static String regex1 = "[a-z]*";
    public static String regex2 = "[a-z]+\\[.*\\]+[a-z]*";

    public static boolean isValidOrNotLowecase(String str) {
        if (str.matches(regex1)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isValidOrNotLowecaseSquareBracket(String str) {
        if (str.matches(regex2)) {
            return true;
        } else {
            return false;
        }
    }
}
