package com.coderhouse;

public class EjemploSwitch {
    // Using switch to evaluate the month of the year based on a number passed as argument

    public static void main(String[] args) {
        // Declare a variable as int
        int month = 2;
        // Declare a variable of type String to store the name of the month
        String monthString;

        // Evaluate the value of the variable month
        switch (month) {
            case 1:  monthString = "January";
                     break;
            case 2:  monthString = "February";
                     break;
            case 3:  monthString = "March";
                     break;
            case 4:  monthString = "April";
                     break;
            case 5:  monthString = "May";
                     break;
            case 6:  monthString = "June";
                     break;
            case 7:  monthString = "July";
                     break;
            case 8:  monthString = "August";
                     break;
            case 9:  monthString = "September";
                     break;
            case 10: monthString = "October";
                     break;
            case 11: monthString = "November";
                     break;
            case 12: monthString = "December";
                     break;
            default: monthString = "Invalid month";
                     break;
        }
        // Print the value of the variable monthString
        System.out.println("The month whose number is " + month + " is: " + monthString);
        }
    }


