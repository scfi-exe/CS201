package DynamicArray;

import java.util.*;
public class Main {
public static void main(String[] args) {
System.out.println("Hello - Welcome to Dynamic Arrays");
//Boss wants another bucket
//Create instance of DynamicArray
DynamicArray reupdatedHighScores = new DynamicArray();
reupdatedHighScores.put(15, 9000);
//Using the ArrayList Class
ArrayList<Integer> topScores = new ArrayList<Integer>();
//add items
topScores.add(0, 1000);
topScores.add(1, 1100);
topScores.add(2, 1100);
topScores.add(3, 1150);
topScores.add(4, 1220);
topScores.add(5, 1400);
for(int i = 0; i < topScores.size(); i++) {
System.out.println("Score = " + topScores.get(i));
}
}
//new class for dynamic arrays
public static class DynamicArray {
//create the array
int[] topScores;
//we'll create an array that's 1 bucket
//this is called a constructor
public DynamicArray() {
topScores = new int[1];
}
//let's pretend we have received another top score, so we'll set our position/bucket in the array to 2
int bucket = 2;
public int get(int bucket) {
if(bucket >= topScores.length) {
return 0;
} else {
return topScores[bucket];
}
}
void put(int bucket, int value) {
if(bucket >= topScores.length) {
//we're already bigger than the array allows; increase the size
int updatedSize = 2 * bucket;
int[] newScores = new int[updatedSize];
System.arraycopy(topScores, 0, newScores, 0, topScores.length);
topScores = newScores;
System.out.println("Array increased to " + updatedSize);
}
topScores[bucket] = value;
}
}
}