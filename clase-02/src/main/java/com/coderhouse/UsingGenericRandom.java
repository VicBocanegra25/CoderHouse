package com.coderhouse;

import java.util.Random;

public class UsingGenericRandom {
    // Using the Random() class to choose a number from between the items of a list

    public static void main(String[] args) {
        // Declare a list of strings
        String[] items = {"apple", "banana", "cherry", "date", "elderberry", "fig", "grape", "honeydew", "kiwi", "lemon"};

        // Call the method chooseRandomItem with the list of strings as an argument
        chooseRandomItem(items);


    }

    public static String chooseRandomItem(String[] items) {
        // Declare a variable as int
        int randomIndex = 0;
        // Declare a variable of type String to store the chosen item
        String randomItem;

        // Create an instance of the Random() class
        Random random = new Random();

        // Generate a random number between 0 and the length of the list
        randomIndex = random.nextInt(items.length);

        // Assign the value of the item at the random index to the variable randomItem
        randomItem = items[randomIndex];

        // Print the value of the variable randomItem
        System.out.println("The random item is: " + randomItem);

        return randomItem;
    }

}
