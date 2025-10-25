package ExponentialSearch;

import java.util.Arrays;

public class ExponentialSearch {

    public static void main(String[] args) {
        int[] array = {5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55, 60};
        int searchValue = 50;

        int result = expSearch(array, array.length, searchValue);
        if (result >= 0) {
            System.out.println("Element is present at index: " + result);
        } else {
            System.out.println("Element not found.");
        }
    }

    // <-- This method must be OUTSIDE main()
    static int expSearch(int[] array, int n, int searchValue) {
        // value at position 0?
        if (array[0] == searchValue) {
            return 0;
        }

        // find the range for binary search (array must be sorted!)
        int i = 1;
        while (i < n && array[i] <= searchValue) {
            i *= 2;
        }

        // Arrays.binarySearch: fromIndex inclusive, toIndex exclusive
        int idx = Arrays.binarySearch(array, i / 2, Math.min(i, n), searchValue);
        return idx; // >= 0 if found; negative if not found
    }
}
