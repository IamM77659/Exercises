
package com.mycompany.forschool;
import java.util.*;

public class SDRC_Verginiza {
    
    public static String decimalToRoman(int line) { // decimal to roman numerals method
        // Arrays for decimals and their corresponding roman numerals symbols
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        String roman = "";  // To build the Roman numeral string

        // Loop through the values array
        for (int i = 0; i < values.length; i++) {

            while (line >= values[i]) {
                roman += symbols[i];  // concatenate Roman numeral 
                line -= values[i];    // Subtract the value from the number
            }
        }

        return roman;  // Return the final Roman numeral string
    }

    public static void main(String[] args) {
        Scanner A = new Scanner(System.in);

        // user input with checking to avoid input mismatch errors
        int line = 0;
        boolean isValid = false;
        while (!isValid) {
            try {
                System.out.print("Enter Lines: ");
                line = A.nextInt();

                // Check if the number of lines is <= 20
                if (line <= 20) {
                    isValid = true; // Valid input within range
                } else {
                    System.out.println("Exceeded 20. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a number.");
                A.next(); // Clear the invalid input
            }
        }

        // Initialize the array with the correct size
        int[] arr = new int[line];

        // Loop to collect numbers and avoid input mismatch errors
        int index = 0;
        boolean valid = false; // Set the flag to false initially

        while (!valid) {
            try {
                for (index = 0; index < line; index++) {
                    System.out.print("Enter a number: ");
                    arr[index] = A.nextInt();  // Read and assign to the array
                }
                valid = true; // If all inputs are valid, exit the loop
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter numbers only.");
                A.next(); // Clear the invalid input
                // Reset the index to 0 to re-enter all values
                index = 0;
            }
        }

        System.out.println(""); // spacing

        // Loop to print Roman numerals
        for (index = 0; index < line; index++) {
            String roman = decimalToRoman(arr[index]);  // Call the roman numeral converter
            System.out.println(roman);  // Print the converted Roman numeral
        }

    }
}
