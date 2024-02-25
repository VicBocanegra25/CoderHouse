package com.coderhouse;

public class DeclaracionIf {
    public static void main(String[] args) {
        /* This script is trying to show that if a randomly generated numebr is larger than 1, we'll see it's value
         printed twice (after it's been modified). */

        // Declare variables as int
        int min = -128, max = 10, range = max - min + 1;

        // We initialize a random number and store it in a variable
        int random = (int) (Math.random() * range) + min;

        // Decrease the variable by 1
        random --;

        // Declare a condition inside an if statement
        if (random >= 1) {
            System.out.println("The value of the variable is: " + random);
        } else {
            System.out.println("The value of the variable is less than 1. Random: " + random + " ");

        }

        // Now we increase the number of the variable by 1 and print the new value
        random ++;

        System.out.println("The value of the variable (after decreasing it by 1) is: " + random);

    }
}