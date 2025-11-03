package PrimalityTesting.SquareRoot;

import java.lang.Math;

public class Main {
    public static void main(String[] args) {
        // test to square root
        int n = 23;
        int flag = 1;
        double squareroot = Math.sqrt(n);
        // loop from 2 to square root of n
        for (int i = 2; i < squareroot; i++) {
            // if divisible by number between 2 and square root of n, NOT prime
            if (n % i == 0) {
                flag = 0;
                break;
            }
        }
        // outputs
        if (flag == 1) {
            System.out.println(n + " is a prime number");
        } else {
            System.out.println(n + " is not a prime number");
        }
    }
}
