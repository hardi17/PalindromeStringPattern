package com.example.stringpatternmatching;

import java.util.ArrayList;

/*
* Used for getting palindrome string in a length of 4,
*  e.g, hjjh[pqrs] : output -> [hjjh]
* */

public class PalindromeString {

    public static ArrayList<String> longestPalindromeString(String s) {
        ArrayList<String> list = new ArrayList<>();
        String longest = s.substring(0, 1);
        for (int i = 0; i < s.length() - 1; i++) {
            //even cases like rttr
            String palindrome = intermediatePalindrome(s, i, i + 1);
            if (palindrome.length() >= longest.length() && palindrome.length() == 4) {
                if (palindrome.charAt(1) != palindrome.charAt(0) && palindrome.charAt(1) != palindrome.charAt(palindrome.length() - 1)
                        && palindrome.charAt(2) != palindrome.charAt(0) && palindrome.charAt(2) != palindrome.charAt(palindrome.length() - 1)) {
                    longest = palindrome;
                    list.add(longest);
                }
            }
        }

        return list;
    }

    public static String intermediatePalindrome(String s, int left, int right) {
        if (left > right) return null;
        while (left >= 0 && right < s.length()
                && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }
}
