package practice.problems.recursion;

import java.util.Scanner;

/*
Given an array of ints, compute recursively the number of times that the value 11 appears in the array.
We'll use the convention of considering only the part of the array that begins at the given index.
In this way, a recursive call can pass index+1 to move down the array. The initial call will pass in index as 0.

array11([1, 2, 11], 0) → 1
array11([11, 11], 0) → 2
array11([1, 2, 3, 4], 0) → 0
 */
public class Array11 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = s.nextInt();
        System.out.println(Array11.array11(arr, 0, 0));
    }

    private static int array11(int[] arr, int index, int count) {
        if (index > arr.length - 1) {
            return count;
        } else {
            if (arr[index] == 11)
                count++;
            index++;
            return array11(arr, index, count);
        }
    }
}
