package BubbleSort;

public class BubbleMySort {
    // First let's create the bubble sort using for loops
    void bubbleSort(int mySimpleArray[]) {
        int n = mySimpleArray.length;
        // first loop traverses to the end of the list
        // remember arrays start at 0!
        for (int i = 0; i < n - 1; i++) {
            // next, go to the next-to-last element
            for (int j = 0; j < n - i - 1; j++) {
                // compare.
                // if j (e.g., 11) is greater than j+1 (3)
                // then swap.
                if (mySimpleArray[j] > mySimpleArray[j + 1]) {
                    // swap mySimpleArray[j+1] and mySimpleArray[j]
                    // these steps create a temporary holding variable,
                    // then flip one to the other
                    int temp = mySimpleArray[j];
                    mySimpleArray[j] = mySimpleArray[j + 1];
                    mySimpleArray[j + 1] = temp;
                }
            }
        }
    }

    // This method prints the mySimpleArrayay
    void printMyArray(int mySimpleArray[]) {
        int n = mySimpleArray.length;
        for (int i = 0; i < n; ++i)
            System.out.print(mySimpleArray[i] + " ");
        System.out.println();
    }

    // In the main method, we'll call the print method and show the results
    public static void main(String args[]) {
        // instance of our fun little bubble sort class
        BubbleMySort bubble = new BubbleMySort();
        // setup the array
        int mySimpleArray[] = {7, 5, 19, 3, 11, 4, 88};
        // call the bubbleSort function
        bubble.bubbleSort(mySimpleArray);
        System.out.println("Sorted mySimpleArray");
        // call the print function
        bubble.printMyArray(mySimpleArray);
    }
}
