package gpt.exercise.one;

import java.util.Scanner;

public class FutureAgeCalculator {
    //Creates the scanner for keyboard inputs from user
    static Scanner keyBoard = new Scanner(System.in);

    //Method for start the app
    public static void start() {
        System.out.print("\nPlease, tell me your name: ");
        String name = keyBoard.nextLine();
        System.out.print("\nPlease, tell me your age: ");
        int age = keyBoard.nextInt();
        System.out.printf("\nHi, %s! Currently you have %d years old.", name, age);
        System.out.printf("\nIn five years you will have %d years old.", age + 5);
        keyBoard.close();
    }
}
