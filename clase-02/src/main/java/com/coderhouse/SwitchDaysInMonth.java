package com.coderhouse;

public class SwitchDaysInMonth {
    // This script uses the switch-case statements to print the number of days in a month based on the month number
    public static void main (String[] args) {
        // Declare a variable as int
        int month = 2;
        // Declare a variable of type int to store the number of days in the month
        int daysInMonth = 0;
        int year = 2024;

        // Evaluate the value of the variable month
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                daysInMonth = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                daysInMonth = 30;
                break;
            case 2:
                if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
                    daysInMonth = 29;
                } else {
                    daysInMonth = 28;
                }
                break;
            default:
                System.out.println("Invalid month");
        }
        // Print the value of the variable daysInMonth
        System.out.println("The month whose number is " + month + " has " + daysInMonth + " days");
    }
}
