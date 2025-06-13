package gpt.exercise.two;

import java.util.Scanner;

public class TemperatureConverter {

    static Scanner keyBoard = new Scanner(System.in);

    // A method that starts the converter
    public static void start() {
        boolean hasQuit;

        System.out.println("Welcome to the Temperature Converter!");
        do {
            hasQuit = menu();
        } while (!hasQuit);
        keyBoard.close();
    }

    // Method for show main menu and execute its options
    private static boolean menu() {
        char userChoice;
        double userTemperature;
        double result;

        System.out.println("""
                What would you like to do?
                    Type 'C' to convert from Celsius to Fahrenheit
                    Type 'F' to convert from Fahrenheit to Celsius
                    Type 'Q' to quit""");
        System.out.print(">> ");
        userChoice = getUserConversionChoice();


        switch (userChoice) {
            case 'Q' -> {
                System.out.println("Quitting...");
                return true;
            }
            case 'C' -> {
                System.out.println("Enter the temperature in Fahrenheit:");
            }
            case 'F' -> {
                System.out.println("Enter the temperature in Celsius:");
            }
            default -> {
                System.out.println("Invalid option");
                return false;
            }
        }
        System.out.print(">> ");
        userTemperature = getUserTemperature();
        result = calculateTemperature(userTemperature, userChoice);
        showResult(result, userTemperature, userChoice);
        return false;
    }

    //A method used to obtain a choice from the user (desired conversion)
    private static char getUserConversionChoice() {
        String input = keyBoard.nextLine();
        char choice;

        if (input.equalsIgnoreCase("Q") || input.equalsIgnoreCase("Quit")) {
            choice = 'Q';
        }else if (input.equalsIgnoreCase("C") || input.equalsIgnoreCase("Celsius")) {
            choice = 'C';
        } else if (input.equalsIgnoreCase("F") || input.equalsIgnoreCase("Fahrenheit")) {
            choice = 'F';
        } else {
            choice = 'E';
        }
        return choice;
    }

    //A method used to obtain the temperature to convert from the user
    private static double getUserTemperature() {
        final double MIN_DOUBLE = Double.MIN_VALUE;
        final double MAX_DOUBLE = Double.MAX_VALUE;
        double tempValue = keyBoard.nextDouble();
        keyBoard.nextLine();
        if (tempValue < MIN_DOUBLE || tempValue > MAX_DOUBLE) {
            System.out.println("Value out of range");
            return 0;
        }
        return tempValue;
    }

    //A method that converts the temperature based on the selected choice
    private static double calculateTemperature(double userTemperature, char userChoice) {
        double calculatedTemperature;
        switch (userChoice) {
            case 'C': {
                calculatedTemperature = ((userTemperature - 32) * ((double) 5 / 9));
                break;
            }
            case 'F': {
                calculatedTemperature = ((userTemperature * ((double) 9 / 5)) + 32);
                break;
            }
            default: {
                calculatedTemperature = 0.00;
                break;
            }
        }
        return calculatedTemperature;
    }

    //A method to show the result of the conversion
    private static void showResult(double result, double userTemperature, char userChoice) {
        String originalUnit;
        String conversionUnit;

        if (userChoice == 'C') {
            originalUnit = "Fahrenheit";
            conversionUnit = "Celsius";
        } else if (userChoice == 'F') {
            originalUnit = "Celsius";
            conversionUnit = "Fahrenheit";
        } else {
            return;
        }
        System.out.printf("%.2f degrees %s is %.2f degrees %s\n\n", userTemperature, originalUnit, result, conversionUnit);
    }
}
