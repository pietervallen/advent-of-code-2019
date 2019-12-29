package net.vallen.advent;

import org.hamcrest.MatcherAssert;
import org.javatuples.Pair;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static net.vallen.advent.Day3.getPairListFromLine;
import static org.hamcrest.core.Is.is;

public class Day3Test {

//--- Day 3: Crossed Wires ---
//The gravity assist was successful, and you're well on your way to the Venus refuelling station. During the rush back on Earth, the fuel management system wasn't completely installed, so that's next on the priority list.
//
//Opening the front panel reveals a jumble of wires. Specifically, two wires are connected to a central port and extend outward on a grid. You trace the path each wire takes as it leaves the central port, one wire per line of text (your puzzle input).
//
//The wires twist and turn, but the two wires occasionally cross paths. To fix the circuit, you need to find the intersection point closest to the central port. Because the wires are on a grid, use the Manhattan distance for this measurement. While the wires do technically cross right at the central port where they both start, this point does not count, nor does a wire count as crossing with itself.
//
//For example, if the first wire's path is R8,U5,L5,D3, then starting from the central port (o), it goes right 8, up 5, left 5, and finally down 3:
//
//...........
//...........
//...........
//....+----+.
//....|....|.
//....|....|.
//....|....|.
//.........|.
//.o-------+.
//...........
//Then, if the second wire's path is U7,R6,D4,L4, it goes up 7, right 6, down 4, and left 4:
//
//...........
//.+-----+...
//.|.....|...
//.|..+--X-+.
//.|..|..|.|.
//.|.-X--+.|.
//.|..|....|.
//.|.......|.
//.o-------+.
//...........
//These wires cross at two locations (marked X), but the lower-left one is closer to the central port: its distance is 3 + 3 = 6.
//
//Here are a few more examples:
//
//R75,D30,R83,U83,L12,D49,R71,U7,L72
//U62,R66,U55,R34,D71,R55,D58,R83 = distance 159
//R98,U47,R26,D63,R33,U87,L62,D20,R33,U53,R51
//U98,R91,D20,R16,D67,R40,U7,R15,U6,R7 = distance 135
//What is the Manhattan distance    from the central port to the closest intersection?

    @Test
    public void calculatePath() {
        String  path1 = "R8,U5,L5,D3";
        Integer totalSteps = 0;
        Coordinate start = new Coordinate(0,0, totalSteps);
        List<Coordinate> result = new ArrayList<>();
        //R8
        result.add(new Coordinate(start.getX()+ 1, start.getY(), ++totalSteps));
        result.add(new Coordinate(start.getX()+ 2, start.getY(), ++totalSteps));
        result.add(new Coordinate(start.getX()+ 3, start.getY(), ++totalSteps));
        result.add(new Coordinate(start.getX()+ 4, start.getY(), ++totalSteps));
        result.add(new Coordinate(start.getX()+ 5, start.getY(), ++totalSteps));
        result.add(new Coordinate(start.getX()+ 6, start.getY(), ++totalSteps));
        result.add(new Coordinate(start.getX()+ 7, start.getY(), ++totalSteps));
        result.add(new Coordinate(start.getX()+ 8, start.getY(), ++totalSteps));
        //U5
        start=result.get(result.size()-1);
        result.add(new Coordinate(start.getX(), start.getY() + 1, ++totalSteps));
        result.add(new Coordinate(start.getX(), start.getY() + 2, ++totalSteps));
        result.add(new Coordinate(start.getX(), start.getY() + 3, ++totalSteps));
        result.add(new Coordinate(start.getX(), start.getY() + 4, ++totalSteps));
        result.add(new Coordinate(start.getX(), start.getY() + 5, ++totalSteps));
        //L5
        start=result.get(result.size()-1);
        result.add(new Coordinate(start.getX()- 1, start.getY(), ++totalSteps));
        result.add(new Coordinate(start.getX()- 2, start.getY(), ++totalSteps));
        result.add(new Coordinate(start.getX()- 3, start.getY(), ++totalSteps));
        result.add(new Coordinate(start.getX()- 4, start.getY(), ++totalSteps));
        result.add(new Coordinate(start.getX()- 5, start.getY(), ++totalSteps));
        //D3
        start=result.get(result.size()-1);
        result.add(new Coordinate(start.getX(), start.getY() - 1, ++totalSteps));
        result.add(new Coordinate(start.getX(), start.getY() - 2, ++totalSteps));
        result.add(new Coordinate(start.getX(), start.getY() - 3, ++totalSteps));

        Collections.sort(result);
        MatcherAssert.assertThat(Day3.calculatePath(getPairListFromLine(path1)), is(result));

    }
    @Test
    public void day3Example1() {
        String  wire1 = "R8,U5,L5,D3";
        String  wire2 = "U7,R6,D4,L4";
        MatcherAssert.assertThat(Day3.manhattenDistance(wire1, wire2), is(new Pair<>(6,30)));
    }
}
