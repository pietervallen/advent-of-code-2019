package net.vallen.advent;

import org.assertj.core.util.Lists;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import java.util.List;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.core.Is.*;

public class Day1Test {

//    A module of mass 14 requires 2 fuel. This fuel requires no further fuel (2 divided by 3 and rounded down is 0,
//    which would call for a negative fuel), so the total fuel required is still just 2.
//    At first, a module of mass 1969 requires 654 fuel. Then, this fuel requires 216 more fuel (654 / 3 - 2). 216 then
//    requires 70 more fuel, which requires 21 fuel, which requires 5 fuel, which requires no further fuel. So, the
//    total fuel required for a module of mass 1969 is 654 + 216 + 70 + 21 + 5 = 966.
//    The fuel required by a module of mass 100756 and its fuel is: 33583 + 11192 + 3728 + 1240 + 411 + 135 + 43 + 12 + 2 = 50346.

    @Test
    public void testCalculateFuelForMassDay1() {
        Integer FuelForMass12 = Day1.calculateFuelForMass(12);
        Integer FuelForMass14 = Day1.calculateFuelForMass(14);
        Integer FuelForMass1969 = Day1.calculateFuelForMass(1969);
        Integer FuelForMass100756 = Day1.calculateFuelForMass(100756);

        assertThat(FuelForMass12, is(2));
        assertThat(FuelForMass14, is(2));
        assertThat(FuelForMass1969, is(654));
        assertThat(FuelForMass100756, is(33583));
    }

    @Test
    public void testCalculateFuelForFuelDay1() {
        Integer FuelForMass12 = Day1.calculateFuelForMass(12);
        Integer FuelForMass14 = Day1.calculateFuelForMass(14);
        Integer FuelForMass1969 = Day1.calculateFuelForMass(1969);
        Integer FuelForMass100756 = Day1.calculateFuelForMass(100756);

        MatcherAssert.assertThat(Day1.calculateFuelForFuel(FuelForMass12), is(0));
        MatcherAssert.assertThat(Day1.calculateFuelForFuel(FuelForMass14), is(0));
        MatcherAssert.assertThat(Day1.calculateFuelForFuel(FuelForMass1969), is(966-654));
        MatcherAssert.assertThat(Day1.calculateFuelForFuel(FuelForMass100756), is(50346-33583));
    }

    @Test
    public void testCalculateFuelForListOfMassesDay1() {
        List<Integer>  masses = List.of(0, 12, 14, 1969, 100756);
        MatcherAssert.assertThat(Day1.calculateFuel(masses), is(2 + 2 + 966 + 50346 ));
    }
}
