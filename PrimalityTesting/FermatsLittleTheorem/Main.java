package PrimalityTesting.FermatsLittleTheorem;

public class Main {
    // Iterative Function to calculate
    // (a^n)%p in O(logy)
    static int power(int a, int n, int p) {
        // Initialize result
        int res = 1;
        // Update 'a' if 'a' >= p
        // using the modulo
        a = a % p;
        while (n > 0) {
            // If n is odd, multiply 'a' with result
            if ((n & 1) == 1)
                res = (res * a) % p;
            // n must be even now
            n = n >> 1; // n = n/2
            a = (a * a) % p;
        }
        return res;
    }

    // Method to check Prime
    // If n is prime, then return true,
    // If n is composite then return false: means high probability as k increases
    static boolean isPrime(int n, int k) {
        // Edge cases
        if (n <= 1 || n == 4)
            return false;
        if (n <= 3)
            return true;
        // Try k times
        while (k > 0) {
            // Pick a random number in [2..n-2]
            // Above corner cases make sure that n > 4
            int a = 2 + (int) (Math.random() % (n - 4));
            // Fermat's little theorem
            if (power(a, n - 1, n) != 1) {
                return false;
            }
            k--;
        }
        return true;
    }

    // *****************************************
    // ************ Main ***********************
    // *****************************************
    public static void main(String args[]) {
        int k = 131414059;
        // check the formula
        // higher values of k indicate higher probability
        System.out.println("Probability of Prime for k = 11 = " + isPrime(11, k));
        System.out.println("Probability of Prime for k = 15 = " + isPrime(15, k));
        System.out.println("Result of k modulo 2: " + k % 2);
    }
}
