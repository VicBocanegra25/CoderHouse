package com.coderhouse;

public class UsingMathRandom {
    // Using the Math.random() to generate doubles between 0 and 1
    public static void main(String[] args) {
        // Call the method generateRandomNumbers
        generateRandomNumbers();

        System.out.println("\nThe next set of random numbers will be between 1 and 10\n");

        // Call the method generateRandomNumbersBetween with the arguments 1 and 10
        generateRandomNumbersBetween(1, 10);

    }


    // An auxiliary method used to generate five random numbers between 0 and 1
    private static void generateRandomNumbers() {
        // Declare a variable as double
        double random = 0.0;

        // Generating 5 random numbers and printing them
        for (int i = 0; i < 5; i++) {
            random = Math.random();
            System.out.println("The value of the variable random is: " + random);
        }
    }

    // An auxiliary method used to generate a number between a range (min and max are passed as arguments)
    private static void generateRandomNumbersBetween(int min, int max) {
        // Declare a variable as int
        int range = max - min + 1;
        int random = 0;

        // Generating 5 random numbers and printing them
        for (int i = 0; i < 5; i++) {
            random = (int) (Math.random() * range) + min;
            System.out.println("The value of the variable random is: " + random);
        }
    }
}
