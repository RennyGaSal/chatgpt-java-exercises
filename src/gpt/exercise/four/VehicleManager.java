package gpt.exercise.four;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

enum InputType {
    TEXT,
    WHOLE_NUMBER,
    FLOAT_NUMBER
}

enum CarType {
    GASOLINE,
    ELECTRIC,
    HYBRID
}

public class VehicleManager {
    private static List<Vehicle> fleet = new ArrayList<>();
    static Scanner keyBoard = new Scanner(System.in);

    public static void start() {
        menu();
        System.out.println("Goodbye");
    }

    private static void menu() {
        int userChoice;
        boolean showMenu = true;

        System.out.println("\t\t **VEHICLE MANAGER**");
        do {
            System.out.println("\nWhat you want to do?");
            System.out.println("""
                    1. Add a new Gasoline Car
                    2. Add a new Electric Car
                    3. Add a new Hybrid Car
                    4. Show all cars and its ranges
                    5. Quit""");
            System.out.print(">> ");
            userChoice = getUserInput(InputType.WHOLE_NUMBER);

            switch (userChoice) {
                case 1 -> addCar(createCar(CarType.GASOLINE));
                case 2 -> addCar(createCar(CarType.ELECTRIC));
                case 3 -> addCar(createCar(CarType.HYBRID));
                case 4 -> showFleet();
                case 5 -> showMenu = false;
                default -> System.out.println("Invalid option");
            }
        } while (showMenu);
    }

    private static <T> T getUserInput(InputType inputType) {
        String rawInput = keyBoard.nextLine();

        switch (inputType) {
            case WHOLE_NUMBER -> {
                try {
                    return (T) Integer.valueOf(rawInput);
                } catch (NumberFormatException e) {
                    throw new RuntimeException("Please enter a valid whole number");
                }
            }
            case FLOAT_NUMBER -> {
                try {
                    Double doubleValue = Double.parseDouble(rawInput);
                    return (T) doubleValue;
                } catch (NumberFormatException e) {
                    throw new RuntimeException("Please enter a valid decimal number");
                }
            }
            case TEXT -> {
                return (T) rawInput;
            }
            default -> throw new IllegalArgumentException("Unsupported type data: " + inputType);
        }
    }

    private static Vehicle createCar(CarType carType) {
        String carMake;
        String carModel;
        int carYear;
        double carTankCapacity;
        double carConsumption;
        double carBatteryCapacity;
        double carEfficiency;
        Vehicle newCar = null;

        System.out.print("\nEnter the make of the car: ");
        carMake = getUserInput(InputType.TEXT);
        System.out.print("\nEnter the model of the car: ");
        carModel = getUserInput(InputType.TEXT);
        System.out.print("\nEnter the year of the car: ");
        carYear = getUserInput(InputType.WHOLE_NUMBER);

        switch (carType) {
            case GASOLINE -> {
                System.out.print("\nEnter the tank capacity (in liters): ");
                carTankCapacity = getUserInput(InputType.FLOAT_NUMBER);
                System.out.print("\nEnter the car consumption (liters per km): ");
                carConsumption = getUserInput(InputType.FLOAT_NUMBER);
                newCar = new GasolineCar(carMake, carModel, carYear, carTankCapacity, carConsumption);
            }
            case ELECTRIC -> {
                System.out.print("\nEnter the battery capacity (kWh): ");
                carBatteryCapacity = getUserInput(InputType.FLOAT_NUMBER);
                System.out.print("\nEnter the car efficiency (Km per kWh): ");
                carEfficiency = getUserInput(InputType.FLOAT_NUMBER);
                newCar = new ElectricCar(carMake, carModel, carYear, carBatteryCapacity, carEfficiency);
            }
            case HYBRID -> {
                System.out.print("\nEnter the tank capacity (in liters): ");
                carTankCapacity = getUserInput(InputType.FLOAT_NUMBER);
                System.out.print("\nEnter the car consumption (liters per km): ");
                carConsumption = getUserInput(InputType.FLOAT_NUMBER);
                System.out.print("\nEnter the battery capacity (kWh): ");
                carBatteryCapacity = getUserInput(InputType.FLOAT_NUMBER);
                System.out.print("\nEnter the car efficiency (Km per kWh): ");
                carEfficiency = getUserInput(InputType.FLOAT_NUMBER);
                newCar = new HybridCar(carMake, carModel, carYear,
                        carTankCapacity, carConsumption,
                        carBatteryCapacity, carEfficiency);
            }
        }
        return newCar;
    }

    private static boolean addCar(Vehicle car) {
        boolean wasAdded;
        if (car != null) {
            fleet.add(car);
            System.out.println("Car added successfully!");
            wasAdded = true;
        } else {
            System.out.println("Car not added!");
            wasAdded = false;
        }
        return wasAdded;
    }

    private static void showFleet() {
        int index = 1;

        System.out.println("\t\t-- CAR FLEET --");
        if (fleet.isEmpty()) {
            System.out.println("No cars to display");
        } else {
            for (Vehicle car : fleet) {
                System.out.println(index + ". " + car + ". Range: " + car.calculateRange() + "Km");
                index++;
            }
        }
    }
}
