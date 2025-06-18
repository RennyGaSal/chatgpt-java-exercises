package gpt.exercise.four;

public class HybridCar extends Vehicle{
    private double tankCapacity;
    private double consumption;
    private double batteryCapacity;
    private double efficiency;
    private static final double MIN_TANK_CAPACITY = 0.01;
    private static final double MIN_CONSUMPTION = 0.01;
    private static final double MIN_BATTERY_CAPACITY = 0.01;
    private static final double MIN_EFFICIENCY = 0.01;

    public HybridCar(String make, String model, int year, double tankCapacity, double consumption, double batteryCapacity, double efficiency) {
        super(make, model, year);
        tankCapacity = (tankCapacity < MIN_TANK_CAPACITY) ? MIN_TANK_CAPACITY : tankCapacity;
        this.tankCapacity = tankCapacity;
        consumption = (consumption < MIN_CONSUMPTION) ? MIN_CONSUMPTION : consumption;
        this.consumption = consumption;
        batteryCapacity = (batteryCapacity < MIN_BATTERY_CAPACITY) ? MIN_BATTERY_CAPACITY : batteryCapacity;
        this.batteryCapacity = batteryCapacity;
        efficiency = (efficiency < MIN_EFFICIENCY) ? MIN_EFFICIENCY : efficiency;
        this.efficiency = efficiency;
    }

    @Override
    public double calculateRange() {
        return ((tankCapacity / consumption * 100)+(batteryCapacity * efficiency));
    }
}
