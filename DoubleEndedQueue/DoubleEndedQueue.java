package DoubleEndedQueue;

import java.util.*;
public class DoubleEndedQueue {
public static void main(String[] args) {
Deque<String> workQueue = new LinkedList<>();
workQueue.add("widget 001");
workQueue.add("widget 002");
workQueue.add("widget 003");
workQueue.add("widget 004");
workQueue.add("widget 005");
System.out.println(workQueue);
System.out.println("Inspecting " + workQueue.peek());
// Simulated processing of widgets
int status = 1;
if (status == 1) { //passed inspection - remove from queue
workQueue.removeFirst();
System.out.println("Widget passed inspection; removed from deque.");
} else if (status == 0) { //minor work required
System.out.println("Widget left at head of deque for minor work.");
} else if (status == -1) { //failed inspection - send to end of queue
String inspectionItem = workQueue.pollFirst();
workQueue.addLast(inspectionItem);
System.out.println("Widget moved to tail of deque for major work.");
}
System.out.println(workQueue);
workQueue.addFirst("Priority Widget 319");
System.out.println(workQueue);
}
}