package practice.problems.linearsearch;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/*
Given a List of N number a1,a2,a3........an, You have to find smallest number from the List that is repeated in the List exactly K number of times.

Input Format

First Line of Input Contain Single Value N, Size of List
Second Line of Input Contain N Space Separated Integers
Third Line of Input Contain Single Value K

Output Format

Smallest Integer Value That is Repeated Exactly K Number of Time

Constraints

0 < N < 100001
0 <= K < 100001
0 <= ai < 100001
NOTE
There Will Be Atleast One Variable Which Is Repeated K Times

SAMPLE INPUT
5
2 2 1 3 1
2
SAMPLE OUTPUT
1
 */
public class RepeatedKTimes {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = s.nextInt();
        int k = s.nextInt();
        System.out.println(RepeatedKTimes.minimumKey(arr, n, k));
    }

    private static int minimumKey(int[] arr, int n, int k) {
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            if (tm.containsKey(arr[i])) {
                tm.put(arr[i], tm.get(arr[i]) + 1);
            } else {
                tm.put(arr[i], 1);
            }
        }
        int key = 0;
        for (Map.Entry e : tm.entrySet()) {
           if ((Integer) e.getValue() == k) {
               key = (Integer) e.getKey();
               break;
           }
        }
        return key;
    }
}
