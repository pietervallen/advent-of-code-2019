package net.vallen.advent;

import java.util.List;
import static net.vallen.advent.TestData.masses;

public class Day1 {

    public static void main(String[] args) {
        System.out.println("The sum of the fuel requirements for all of the modules on your spacecraft: " + calculateFuel(masses));
    }

    static Integer calculateFuelForMass(Integer fuel) {
        return Math.max(0, fuel / 3 - 2);
    }

    static Integer calculateFuel(List<Integer> masses) {
        return masses.stream()
                .map(fuel -> {
                    Integer fuelForMass = calculateFuelForMass(fuel);
                    Integer fuelForFuel = calculateFuelForFuel(fuelForMass);
                    return fuelForMass + fuelForFuel;
                })
                .reduce(0, Integer::sum);
    }

    static Integer calculateFuelForFuel(Integer fuel) {
        Integer fuelForFuel = calculateFuelForMass(fuel);
        if (fuel > 0) {
            return fuelForFuel + calculateFuelForFuel(fuelForFuel);
        } else {
            return fuel;
        }
    }
}
