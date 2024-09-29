package pl.kwisek.dnd5e.utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class StringDistanceUtils {

    /**
     * Calculates distance between two string based on the Damerau–Levenshtein distance algorithm.
     * Implementation based on <a href="https://en.wikipedia.org/wiki/Damerau%E2%80%93Levenshtein_distance">pseudocode included in this article</a>
     * @param str1 First string
     * @param str2 Second string
     * @return Damerau–Levenshtein distance between str1 and str2
     */
    public static int stringDistance(String str1, String str2) {

        int[][] d = new int[str1.length() + 1][str2.length() + 1];

        for (int i1 = 0; i1 <= str1.length(); i1++) {
            d[i1][0] = i1;
        }

        for (int i2 = 0; i2 <= str2.length(); i2++) {
            d[0][i2] = i2;
        }

        for (int i1 = 1; i1 <= str1.length(); i1++) {
            for (int i2 = 1; i2 <= str2.length(); i2++) {
                d[i1][i2] = Math.min(
                    Math.min(d[i1 - 1][i2] + 1, d[i1][i2 - 1] + 1),
                    d[i1 - 1][i2 - 1] + (str1.charAt(i1 - 1) != str2.charAt(i2 - 1) ? 1 : 0)
                );

                if (i1 > 1 && i2 > 1 &&
                    str1.charAt(i1 - 1) == str2.charAt(i2 - 2) &&
                    str1.charAt(i1 - 2) == str2.charAt(i2 - 1)) {
                        d[i1][i2] = Math.min(d[i1][i2], d[i1 - 2][i2 - 2] + 1);
                }
            }
        }

        return d[str1.length()][str2.length()];
    }
}
