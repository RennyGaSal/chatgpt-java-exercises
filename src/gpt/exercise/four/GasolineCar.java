package gpt.exercise.four;

public class GasolineCar extends Vehicle{
    private double tankCapacity;
    private double consumption;
    private static final double MIN_CAPACITY = 0.01;
    private static final double MIN_CONSUMPTION = 0.01;

    public GasolineCar(String make, String model, int year, double tankCapacity, double consumption) {
        super(make, model, year);
        tankCapacity = (tankCapacity < MIN_CAPACITY) ? MIN_CAPACITY : tankCapacity;
        this.tankCapacity = tankCapacity;
        consumption = (consumption < MIN_CONSUMPTION) ? MIN_CONSUMPTION : consumption;
        this.consumption = consumption;
    }

    @Override
    public double calculateRange() {
        return tankCapacity / consumption * 100;
    }
}
