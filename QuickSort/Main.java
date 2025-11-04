package QuickSort;

public class Main {
    // we need a function to partition an element
    int partition(int a[], int start, int end) {
        // our pivot element
        int pivot = a[end];
        int i = (start - 1);
        for (int j = start; j <= end - 1; j++) {
            // if current is smaller than pivot
            if (a[j] < pivot) {
                i++;
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }
        int t = a[i + 1];
        a[i + 1] = a[end];
        a[end] = t;
        return (i + 1);
    }

    // perform the quicksort using a recursive method
    void quicksort(int a[], int start, int end) {
        if (start < end) {
            int p = partition(a, start, end);
            quicksort(a, start, p - 1);
            quicksort(a, p + 1, end);
        }
    }

    // print out the list
    private void printList(int a[], int n) {
        int i;
        for (i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
    }

    // main
    public static void main(String args[]) {
        int a[] = {24, 2, 45, 20, 56, 75, 16, 56, 99, 53, 12};
        int len = a.length;
        System.out.println("Below is the unsorted list.");
        System.out.println();
        Main qs = new Main();
        qs.printList(a, len);
        qs.quicksort(a, 0, len - 1);
        System.out.println();
        System.out.println("Below is the sorted list.");
        System.out.println();
        qs.printList(a, len);
        System.out.println();
    }
}
