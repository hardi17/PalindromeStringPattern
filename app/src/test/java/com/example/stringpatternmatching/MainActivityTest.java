package com.example.stringpatternmatching;


import static junit.framework.TestCase.assertEquals;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainActivityTest{

    /*check string have lowercase letter*/
    @Test
    public void testYourStringValid() {
        String input ="asdfgh";
        assertEquals(true,StringValidOrNOt.isValidOrNotLowecase(input));
    }/*check string have lowercase letter*/

    @Test
    public void testYourStringNotValid() {
        String input = "ASDFasdd";
        assertEquals(false, StringValidOrNOt.isValidOrNotLowecase(input));
    }

    /*check string have lowercase letter or squarebracket like rttr[mnop]qrst*/
    @Test
    public void testYourStringWithBrackret() {
        String input = "rttr[mnop]qrst";
        assertEquals(true,StringValidOrNOt.isValidOrNotLowecaseSquareBracket(input));
    }

    /*nested square bracket or bracket not open or close*/
    @Test
    public void testNestedBracket() {
        String input = "ab]cd[ef[gh[ij]kl]";
        assertEquals(false,StringValidOrNOt.isValidOrNotLowecaseSquareBracket(input));
    }

    /*check string is match with patter like "rttr" and also only outside bracket string is valid not inside*/
    @Test
    public void testValidPAttern() {
        String input = "rttr[mnop}qrst";
        List<String> expectedOutput =Arrays.asList("rttr");
        ArrayList<String> actualArrayList =  PalindromeString.longestPalindromeString(input);
        assertEquals(expectedOutput,actualArrayList);
    }

    /*input : baabcddc, output : ["baab","cddc"]*/
    @Test
    public void testMoreValidPAttern() {
        String input = "baabcddc";
        List<String> expectedOutput1 = Arrays.asList("baab","cddc");
        ArrayList<String> actualArrayList1 = PalindromeString.longestPalindromeString(input);
        assertEquals(expectedOutput1, actualArrayList1);
    }

    /*input : bbbb, output : []*/
    @Test
    public void testNotValidPAttern() {
        String input = "bbbb";
        List<String> expectedOutput1 = Arrays.asList();
        ArrayList<String> actualArrayList1 = PalindromeString.longestPalindromeString(input);
        assertEquals(expectedOutput1, actualArrayList1);
    }
}