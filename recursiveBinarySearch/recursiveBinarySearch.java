package recursiveBinarySearch;

public class recursiveBinarySearch {

    public static int BinarySearch(int[] sortedArray, int begin, int end, int key) {
        if (begin < end) {
            int middle = begin + (end - begin) / 2;

            if (key < sortedArray[middle]) {
                return BinarySearch(sortedArray, begin, middle, key);
            } else if (key > sortedArray[middle]) {
                return BinarySearch(sortedArray, middle + 1, end, key);
            } else {
                return middle;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] sortedArr = {1, 53, 62, 133, 384, 553, 605, 897, 1035, 1234};
        int searchIndex = BinarySearch(sortedArr, 0, sortedArr.length, 605);
        System.out.println("I Found 605 at index " + searchIndex);
    }
}
