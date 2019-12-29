package net.vallen.advent;

public class Coordinate implements Comparable<Coordinate>{
    private int x;
    private int y;
    private int steps;

    Coordinate(int x, int y, int steps) {
        this.x = x;
        this.y = y;
        this.steps = steps;
    }

    Integer getX() {
        return x;
    }

    Integer getY() {
        return y;
    }

    Integer getSteps() {
        return steps;
    }

    @Override
    public String toString() {
        return "Coordinate: (" + x + "," + y + "), Steps: " + steps;
    }

    @Override
    public int compareTo(Coordinate coordinate) {
        return Integer.compare(Math.abs(getX())+Math.abs(getY()),  Math.abs(coordinate.getX())+Math.abs(coordinate.getY()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return x == that.x &&
                y == that.y;
    }

    @Override
    public int hashCode() {
        return com.google.common.base.Objects.hashCode(x, y);
    }
}
