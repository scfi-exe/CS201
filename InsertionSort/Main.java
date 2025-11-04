package InsertionSort;

public class Main {
    public static void main(String[] args) {
        int[] steps = {1, 7, 9, 11, 4};
        System.out.println("Before Sort: ");
        for (int i = 0; i < steps.length; i++) {
            System.out.print(steps[i] + " ");
        }
        System.out.println();
        // time check before sorting
        long startTime = System.nanoTime();
        // call insertion sort method
        sortRecipe(steps);
        // time check after sorting
        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println("After Sort:");
        for (int i = 0; i < steps.length; i++) {
            System.out.print(steps[i] + " ");
        }
        System.out.println();
        System.out.println("Time taken: " + totalTime + "ns");
    }

    // sortRecipe method
    public static void sortRecipe(int sortArray[]) {
        int len = sortArray.length;
        // Start looping through the array
        for (int j = 1; j < len; j++) {
            // use a temp variable to keep track
            int temp = sortArray[j];
            // we are shifting down, so subtract 1
            int i = j - 1;
            // if we are at -1, we went past the beginning
            // as long as j is > 0 and current bucket of the array
            // is less than the temp variable, shift elements
            while ((i > -1) && (sortArray[i] > temp)) {
                sortArray[i + 1] = sortArray[i];
                i--;
            }
            sortArray[i + 1] = temp;
        }
    }
}
