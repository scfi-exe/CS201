package PrimalityTesting.MillerRabinTest;

class Main {
    // Return (x ^ y) % p to perform modulo exponentiation
    static int power(int x, int y, int p) {
        int res = 1;
        // set x equal to x modulo p
        x = x % p;
        while (y > 0) {
            // If y is odd, multiply x with result
            if ((y & 1) == 1)
                res = (res * x) % p;
            // set y to even
            y = y / 2;
            x = (x * x) % p;
        }
        return res;
    }

    // C all the MillerTest function for k number of runs
    // If n is composite: False
    // If n is probably prime: False
    // d is an odd number
    static boolean MillerTest(int d, int n) {
        // Pick a random number from 2 to n - 2
        // make sure n is larger than 4
        int a = 2 + (int) (Math.random() % (n - 4));
        // Compute a^d % n
        int x = power(a, d, n);
        if (x == 1 || x == n - 1)
            return true;
        // Square x until the following is false
        // d <> n - 1
        // x ^ 2 % n is not 1
        // x ^ 2 % n isn't n - 1
        while (d != n - 1) {
            x = (x * x) % n;
            d *= 2;
            if (x == 1)
                return false;
            if (x == n - 1)
                return true;
        }
        return false;
    }

    // Return FALSE is n is composite
    // Return TRUE if n is probably a prime number
    // Remember: The higher the value of k, the more likely it's prime
    static boolean isPrime(int n, int k) {
        // Corner cases
        if (n <= 1 || n == 4)
            return false;
        if (n <= 3)
            return true;
        // Find r where: n = 2^d * r + 1 for some r >= 1
        int d = n - 1;
        while (d % 2 == 0)
            d /= 2;
        // Iterate k times
        for (int i = 0; i < k; i++)
            if (!MillerTest(d, n))
                return false;
        return true;
    }

    // ***************************
    // ********** MAIN ***********
    // ***************************
    public static void main(String args[]) {
        // Number of iterations
        int k = 4;
        System.out.println("All primes smaller than 1000: ");
        for (int n = 1; n < 1000; n++)
            if (isPrime(n, k))
                System.out.print(n + " ");
    }
}
