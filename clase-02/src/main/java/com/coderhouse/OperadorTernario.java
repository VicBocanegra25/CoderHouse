package com.coderhouse;

public class OperadorTernario {
    // Using the tenrary operator to assign a value to a variable
    public static void main(String[] args) {
        // Declare a variable as int
        int value1 = 1;
        int value2 = 2;
        int result;

        // Declare a boolean which will be used to evaluate the condition
        boolean condition = randomBoolean();

        // Using the ternary operator to assign a value to the variable result
        result = condition ? value1 : value2;

        // Print the value of the variable result
        System.out.println("The value of the variable result is: " + result);


}

    // An auxiliary method which uses the random module to generate a random boolean
    private static boolean randomBoolean() {
        return Math.random() < 0.5;
    }

}
