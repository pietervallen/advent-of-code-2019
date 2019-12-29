package net.vallen.advent;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

import static net.vallen.advent.TestData.inputDay2;

public class Day2 {

    public static void main(String[] args) {
        List<Integer> result = List.of(0);
        while (result.get(0) != 19690720) {
            Random r1 = new Random();
            Random r2 = new Random();
            int low = 0;
            int high = 99;
            int noun = r1.nextInt(high - low) + low;
            int verb = r2.nextInt(high - low) + low;

            List<Integer> listFromString = getIntegerListFromLine(inputDay2);
            listFromString.set(1, noun);
            listFromString.set(2, verb);
            System.out.println("Noun: " + noun + ", Verb: " + verb);
            result = processList(listFromString);
            if (result.get(0) == 6568671) {
                System.out.println("The result of Day 2b: " + result.get(1) + "-" + result.get(2));
            }
        }
    }

    private static final String COMMA_DELIMITER = ",";

    static List<Integer> getIntegerListFromLine(String line) {
        List<Integer> values = new ArrayList<>();
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(COMMA_DELIMITER);
            while (rowScanner.hasNext()) {
                values.add(Integer.valueOf(rowScanner.next()));
            }
        }
        return values;
    }

    static List<Integer> processList(List<Integer> values) {
        List<Integer> sequenceCollection;
        List<Integer> sequenceCollectionRest = values;
        for (int i = 1; i <= values.size() / 4; i++) {
            sequenceCollection = sequenceCollectionRest.stream()
                    .limit(4)
                    .collect(Collectors.toList());
            if (sequenceCollection.get(0) != 99) {
                calculate(sequenceCollection, values);
            }

            sequenceCollectionRest = sequenceCollectionRest.stream()
                    .skip(4)
                    .collect(Collectors.toList());
        }
        return values;
    }

    private static void calculate(List<Integer> sequence, List<Integer> values) {
        if (sequence.get(0) == 1) {
            values.set(sequence.get(3), values.get(sequence.get(1)) + values.get(sequence.get(2)));
        } else if (sequence.get(0) == 2) {
            values.set(sequence.get(3), values.get(sequence.get(1)) * values.get(sequence.get(2)));
        }
    }
}

