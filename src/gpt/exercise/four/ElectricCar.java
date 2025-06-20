package gpt.exercise.four;

public class ElectricCar extends Vehicle{
    private double batteryCapacity;
    private double efficiency;
    private static final double MIN_CAPACITY = 0.01;
    private static final double MIN_EFFICIENCY = 0.01;

    public ElectricCar(String make, String model, int year, double batteryCapacity, double efficiency) {
        super(make, model, year);
        batteryCapacity = (batteryCapacity < MIN_CAPACITY) ? MIN_CAPACITY : batteryCapacity;
        this.batteryCapacity = batteryCapacity;
        efficiency = (efficiency < MIN_EFFICIENCY) ? MIN_EFFICIENCY : efficiency;
        this.efficiency = efficiency;
    }


    @Override
    public double calculateRange() {
        return (batteryCapacity * efficiency);
    }
}
