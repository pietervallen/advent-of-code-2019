package net.vallen.advent;

import org.javatuples.Pair;

import java.time.Duration;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;

import static net.vallen.advent.TestData.inputDay3firstWire;
import static net.vallen.advent.TestData.inputDay3secondWire;

public class Day3 {
    private static final String COMMA_DELIMITER = ",";

    public static void main(String[] args) {
        System.out.println("The Manhattan distance is: " + manhattenDistance(inputDay3firstWire, inputDay3secondWire));
    }

    public static Pair<Integer, Integer> manhattenDistance(String path1, String path2) {
        List<Coordinate> beenTherePath1;
        List<Coordinate> beenTherePath2;

        beenTherePath1 = calculatePath(getPairListFromLine(path1));
        beenTherePath2 = calculatePath(getPairListFromLine(path2));

        LocalTime start = LocalTime.now();
        Coordinate closestCoordinate = beenTherePath1.stream()
                .filter(beenTherePath2::contains)
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("No match"));
        LocalTime finish = LocalTime.now();
        System.out.println("Closest coordinate duration (ms): " + Duration.between(start, finish).toMillis());

        start = LocalTime.now();
        List<Integer> combinedDistances = beenTherePath1.stream()
                .map(c1 -> {
                    Coordinate c2 = beenTherePath2.stream().filter(c -> c.equals(c1))
                            .findFirst().orElse(new Coordinate(0, 0, 99999999));
                    return c1.getSteps() + c2.getSteps();
                })
                .sorted()
                .collect(Collectors.toList());
        finish = LocalTime.now();
        System.out.println("Shortest distance duration (ms): " + Duration.between(start, finish).toMillis());

        return new Pair<>(Math.abs(closestCoordinate.getX()+closestCoordinate.getY()), combinedDistances.get(0));
    }

    static List<Coordinate> calculatePath(List<Pair<Character, Integer>> path) {
        int totalSteps = 0;
        Coordinate position = new Coordinate(0,0, totalSteps);
        List<Coordinate> result = new ArrayList<>();
        for(Pair<Character, Integer> pair :  path) {
            Character direction = pair.getValue0();
            Integer steps =pair.getValue1();
            if (direction == 'U') {
                for (int step = 1; step <= steps; step++) {
                    result.add(new Coordinate(position.getX(), position.getY()+step, ++totalSteps));
                }
                position=result.get(result.size()-1);
            }
            if (direction == 'D') {
                for (int step = 1; step <= steps; step++) {
                    result.add(new Coordinate(position.getX(), position.getY()-step, ++totalSteps));
                }
                position=result.get(result.size()-1);
            }
            if (direction == 'L') {
                for (int step = 1; step <= steps; step++) {
                    result.add(new Coordinate(position.getX()-step, position.getY(),++totalSteps));
                }
                position=result.get(result.size()-1);
            }
            if (direction == 'R') {
                for (int step = 1; step <= steps; step++) {
                    result.add(new Coordinate(position.getX()+step, position.getY(), ++totalSteps));
                }
                position=result.get(result.size()-1);
            }
        }
        Collections.sort(result);
        return result;
    }

    static List<Pair<Character, Integer>> getPairListFromLine(String line) {
        List<Pair<Character, Integer>> values = new ArrayList<>();
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(COMMA_DELIMITER);
            while (rowScanner.hasNext()) {
                String item = rowScanner.next();
                Pair<Character, Integer> pair = new Pair<>(item.charAt(0), Integer.parseInt(item.substring(1)));
                values.add(pair);
            }
        }
        return values;
    }
}
