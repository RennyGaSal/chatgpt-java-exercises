package gpt.exercise.four;

public abstract class Vehicle {
    protected String make;
    protected String model;
    protected int year;
    private static final int MIN_YEAR = 1900;
    private static final int MAX_YEAR = 2025;

    public Vehicle(String make, String model, int year) {
        this.make = make;
        this.model = model;
        if (year >= MIN_YEAR && year <= MAX_YEAR) {
            this.year = year;
        } else {
            if (year < MIN_YEAR) {
                this.year = MIN_YEAR;
            }
            else{
                this.year = MAX_YEAR;
            }
        }
    }

    public abstract double calculateRange();

    @Override
    public String toString() {
        return ("Model: " + model + ", made by: " + make + " in " + year);
    }
}
