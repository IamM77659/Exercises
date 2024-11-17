/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.forschool;

/**
 *
 * @author WIFI SERVER
 */

import java.util.*;

public class Resistors {

    public static void main(String[] args) {
        // Scanner and input handling
        Scanner A = new Scanner(System.in);
        int T = 0;
        boolean isValid = false;
        while (!isValid) {
            try {
                T = A.nextInt(); // input cases
                A.nextLine(); // Consume newline character after nextInt()
                isValid = T > 0;
            } catch (InputMismatchException e) {
                System.out.println("PLeae enter an integer.");
                System.out.println(": ");
                A.next();
            }
        }
        // colors with their bands
        String silver = "0", gold = "0", black = "0", brown = "1", red = "2",
                orange = "3", yellow = "4", green = "5", blue = "6", violet = "7",
                grey = "8", white = "9";
        // multipliers (band c)
        float row1 = 0.01f, row2 = 0.1f, row3 = 1, row4 = 10, row5 = 100, row6 = 1000,
                row7 = 10000, row8 = 100000, row9 = 1000000, row10 = 10000000, row11 = 100000000,
                row12 = 1000000000;

        // Res band storage for strings (color names)(2d arrays are utilized)
        String[][] res_bands = new String[T][3];
        /*                                          {0, 0 ,0},
                                                    {0, 0, 0}
                                                    {0, 0, 0}*/

        // Read input
        int rows = 0;

        while (rows < T) {
            String input = A.nextLine();
            String[] cols = input.split(" ");
            if (cols.length == 3) {
                for (int columns = 0; columns < 3; columns++) {
                    res_bands[rows][columns] = cols[columns];
                }
            } else {
                System.out.println("Please enter exactly 3 values for each row.");
            }
            rows++;
        }

        // Convert color names to their numeric values (Float to divide to their multilplier bands)
        int[][] numeric_bands = new int[T][3]; // specific for bands a and b
        float[][] numeric_bandsFloat = new float[T][3];// specific for band c only 

        for (int r = 0; r < T; r++) {
            for (int c = 0; c < 3; c++) {
                switch (res_bands[r][c]) {
                    case "silver" -> numeric_bandsFloat[r][c] = Float.parseFloat(silver);
                    case "gold" -> numeric_bandsFloat[r][c] = Float.parseFloat(gold);
                    case "black" -> numeric_bands[r][c] = Integer.parseInt(black);
                    case "brown" -> numeric_bands[r][c] = Integer.parseInt(brown);
                    case "red" -> numeric_bands[r][c] = Integer.parseInt(red);
                    case "orange" -> numeric_bands[r][c] = Integer.parseInt(orange);
                    case "yellow" -> numeric_bands[r][c] = Integer.parseInt(yellow);
                    case "green" -> numeric_bands[r][c] = Integer.parseInt(green);
                    case "blue" -> numeric_bands[r][c] = Integer.parseInt(blue);
                    case "violet" -> numeric_bands[r][c] = Integer.parseInt(violet);
                    case "grey" -> numeric_bands[r][c] = Integer.parseInt(grey);
                    case "white" -> numeric_bands[r][c] = Integer.parseInt(white);

                }

            }

        }
        System.out.println(""); //spacing

        //identify band C multiplier value of the Band A and B combination
        for (int r = 0; r < T; r++) {
            // Access only the third column (index 2) of each row
            switch (res_bands[r][2]) {
                case "silver":
                    numeric_bandsFloat[r][2] = row1; // Assign the value for "silver"
                    break;
                case "gold":
                    numeric_bandsFloat[r][2] = row2; // Assign the value for "gold"
                    break;
                case "black":
                    numeric_bandsFloat[r][2] = row3;
                case "brown":
                    numeric_bandsFloat[r][2] = row4;
                    break;
                case "red":
                    numeric_bandsFloat[r][2] = row5;
                    break;
                case "orange":
                    numeric_bandsFloat[r][2] = row6;
                    break;
                case "yellow":
                    numeric_bandsFloat[r][2] = row7;
                    break;
                case "green":
                    numeric_bandsFloat[r][2] = row8;
                    break;
                case "blue":
                    numeric_bandsFloat[r][2] = row9;
                    break;
                case "violet":
                    numeric_bandsFloat[r][2] = row10;
                    break;
                case "grey":
                    numeric_bandsFloat[r][2] = row11;
                    break;
                case "white":
                    numeric_bandsFloat[r][2] = row12;
                    break;
            }

        }
        //calculation iteration
        System.out.println("Result:");

        for (int r = 0; r < T; r++) {
            // combine band A and band B, then multiply to band C (multiplier band) for the current row
            String conc = numeric_bands[r][0] + "" + numeric_bands[r][1];
            int combined = Integer.parseInt(conc);
            float ohm = combined * numeric_bandsFloat[r][2];

            if (numeric_bands[r][0] == 0 || numeric_bands[r][1] == 0) {
                System.out.println("Invalid Combination");
            } else {
                System.out.println(ohm + " Ohms");
            }

        }

    }
}
