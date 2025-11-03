package PrimalityTesting.SieveOfEratosthenes;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter a Number: ");
        // take input from keyboard
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Loop that iterates from 1 to n.
        for (int i = 1; i <= n; i++) {
            // is current number prime
            boolean isPrime = true;
            for (int j = i - 1; j >= 2; j--) {
                // If the number can divide then it's not prime
                // then end loop
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            // If it passes the prime test, it's prime
            if (isPrime)
                System.out.print(i + " ");
        }
        sc.close();
    }
}
