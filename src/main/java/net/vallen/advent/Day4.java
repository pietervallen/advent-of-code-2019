package net.vallen.advent;

import static java.lang.System.out;
import static java.util.stream.IntStream.range;

public class Day4 {

    public static void main(String[] args) {
        out.println("The result is: "+ getNumberofCombinations(123257,647015));
    }

    private static Long getNumberofCombinations(int start, int end) {
        return range(start, end)
                .filter(combination -> containsDoubles(combination) && isIncremental(combination))
                .count();
    }

    static boolean isIncremental(int combination) {
        char[] chars = ("" + combination).toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            if ((int) chars[i + 1] < (int) chars[i]) {
                return false;
            }
        }
        return true;
    }

    static boolean containsDoubles(int combination) {
        char[] chars = ("" + combination).toCharArray();
        int counter = 1;
        char pendingNumber;
        char previousNumber = '0';
        boolean doubleFound = false;
        for (int i = 0; i < chars.length; i++) {
            pendingNumber = chars[i];
            if (pendingNumber != previousNumber) {
                if (counter==2) doubleFound = true;
                counter = 1;
            }
            if (i + 2 == chars.length) {
                // 2 characters match
                if (Integer.valueOf(chars[i + 1]).equals((int) pendingNumber)) counter++;
                return counter == 2  || doubleFound;
            }                               // no more characters left return true is count = 2
            else // 2 characters match
                if (Integer.valueOf(chars[i + 1]).equals((int) pendingNumber)) counter++;
            previousNumber = pendingNumber;
        }
        return counter == 2;
    }
}
