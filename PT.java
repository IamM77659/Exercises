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

public class PT {

    static int simplify_a(int a) {
        return a * a;

    }

    static int simplify_b(int b) {
        return b * b;
    }

    public static void main(String[] args) {
        System.out.println("Pythagorean Theorem"); // formula: a² + b² = c²
        Scanner A = new Scanner(System.in);
        int a = 0, b = 0;
        double C;
        // user input with error handling
        boolean Valid = false;
        while (!Valid) {
            try {
                System.out.print("Enter side a: ");
                a = A.nextInt();
                System.out.print("Enter side b: ");
                b = A.nextInt();
                Valid = true;
            } catch (InputMismatchException e) {
                System.out.println("Please enter an integer.");
                A.next();

            }

        }

        double added = simplify_a(a) + simplify_b(b);
        C = Math.sqrt(added);
        int c = (int) Math.round(C);
        System.out.println("hypotenuse is c = " + c);

    }
}
