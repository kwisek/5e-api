package pl.kwisek.dnd5e.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringDistanceUtilsTest {

    @Test
    public void compareIdenticalStrings() {

        // given
        int expected = 0;
        String str1 = "abc";
        String str2 = "abc";

        // when
        int actual = StringDistanceUtils.stringDistance(str1, str2);

        // then
        assertEquals(expected, actual, "Distance between identical strings should be 0");
    }

    @Test
    public void compareCompletelyDifferentStrings() {

        // given
        int expected = 3;
        String str1 = "abc";
        String str2 = "xyz";

        // when
        int actual = StringDistanceUtils.stringDistance(str1, str2);

        // then
        assertEquals(expected, actual, "Distance between completely different strings should be equal to the length of the strings");
    }

    @Test
    public void compareTransposedCharacters() {

        // given
        int expected = 1;
        String str1 = "abc";
        String str2 = "bac";

        // when
        int actual = StringDistanceUtils.stringDistance(str1, str2);

        // then
        assertEquals(expected, actual, "Distance between strings with transposed characters should be 1");
    }

    @Test
    public void compareStringsOfDifferentLengths() {

        // given
        int expected = 6;
        String str1 = "hello";
        String str2 = "hello world";

        // when
        int actual = StringDistanceUtils.stringDistance(str1, str2);

        // then
        assertEquals(expected, actual, "Distance between strings of different lengths should be the difference in length");
    }

    @Test
    public void compareEmptyStrings() {

        // given
        int expected = 0;
        String str1 = "";
        String str2 = "";

        // when
        int actual = StringDistanceUtils.stringDistance(str1, str2);

        // then
        assertEquals(expected, actual, "Distance between two empty strings should be 0");
    }

    @Test
    public void compareEmptyAndNonEmptyString() {

        // given
        int expected = 4;
        String str1 = "";
        String str2 = "test";

        // when
        int actual = StringDistanceUtils.stringDistance(str1, str2);

        // then
        assertEquals(expected, actual, "Distance between empty string and non-empty string should be the length of the non-empty string");
    }

    @Test
    public void compareOneCharacterDifference() {

        // given
        int expected = 1;
        String str1 = "test";
        String str2 = "tent";

        // when
        int actual = StringDistanceUtils.stringDistance(str1, str2);

        // then
        assertEquals(expected, actual, "Distance between two strings with one character difference should be 1");
    }

    @Test
    public void compareStringsWithTranspositions() {

        // given
        int expected = 2;
        String str1 = "abcdef";
        String str2 = "abcfde";

        // when
        int actual = StringDistanceUtils.stringDistance(str1, str2);

        // then
        assertEquals(expected, actual, "Distance should account for transpositions correctly");
    }
}