package net.vallen.advent;

import org.hamcrest.MatcherAssert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

public class Day4Test {

//--- Day 4: Secure Container ---
//You arrive at the Venus fuel depot only to discover it's protected by a password. The Elves had written the password
// on a sticky note, but someone threw it out.
//
//However, they do remember a few key facts about the password:
//
//It is a six-digit number.
//The value is within the range given in your puzzle input.
//Two adjacent digits are the same (like 22 in 122345).
//Going from left to right, the digits never decrease; they only ever increase or stay the same (like 111123 or 135679).
//Other than the range rule, the following are true:
//
//111111 meets these criteria (double 11, never decreases).
//223450 does not meet these criteria (decreasing pair of digits 50).
//123789 does not meet these criteria (no double).
//How many different passwords within the range given in your puzzle input meet these criteria?
//
//Your puzzle input is 123257-647015.
    //--- Part Two ---
    //An Elf just remembered one more important detail: the two adjacent matching digits are not part of a larger group of matching digits.
    //
    //Given this additional criterion, but still ignoring the range rule, the following are now true:
    //
    //112233 meets these criteria because the digits never decrease and all repeated digits are exactly two digits long.
    //123444 no longer meets the criteria (the repeated 44 is part of a larger group of 444).
    //111122 meets the criteria (even though 1 is repeated more than twice, it still contains a double 22).


    @Test
    public void testIsIncremental() {
        MatcherAssert.assertThat(Day4.isIncremental(1234), is(true));
    }

    @Test
    public void testIsNotIncremental() {
        MatcherAssert.assertThat(Day4.isIncremental(1224), is(true));
    }

    @Test
    public void testContainsNoDoubles() {
        MatcherAssert.assertThat(Day4.containsDoubles(1234), is(false));
    }

    @Test
    public void testContainsNoDoublesButTriples() {
        MatcherAssert.assertThat(Day4.containsDoubles(2224), is(false));
    }

    @Test
    public void testContainsNoDoublesButQuadruples() {
        MatcherAssert.assertThat(Day4.containsDoubles(22224), is(false));
    }

    @Test
    public void testContainsTripleAndDouble() {
        MatcherAssert.assertThat(Day4.containsDoubles(22244), is(true));
    }

    @Test
    public void testContainsDoubles() {
        MatcherAssert.assertThat(Day4.containsDoubles(1224), is(true));
    }

    @Test
    public void testPuzzelExample() {
        MatcherAssert.assertThat(Day4.containsDoubles(111111)&&Day4.isIncremental(111111), is(false));
        MatcherAssert.assertThat(Day4.containsDoubles(223450)&&Day4.isIncremental(223450), is(false));
        MatcherAssert.assertThat(Day4.containsDoubles(123789)&&Day4.isIncremental(123789), is(false));

        MatcherAssert.assertThat(Day4.containsDoubles(112233)&&Day4.isIncremental(112233), is(true));
        MatcherAssert.assertThat(Day4.containsDoubles(123444)&&Day4.isIncremental(123444), is(false));
        MatcherAssert.assertThat(Day4.containsDoubles(111122)&&Day4.isIncremental(111122), is(true));

        //123345
        MatcherAssert.assertThat(Day4.containsDoubles(123345), is(true));
        MatcherAssert.assertThat(Day4.isIncremental(123345), is(true));

    }

}
