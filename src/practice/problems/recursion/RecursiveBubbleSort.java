package practice.problems.recursion;

import java.util.Scanner;

public class RecursiveBubbleSort {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = s.nextInt();
        RecursiveBubbleSort.bubbleSort(arr, n);
        for (int i = 0; i < n; i++)
            System.out.println(arr[i]);
    }

    private static void bubbleSort(int[] arr, int n) {
        if (n == 1)
            return;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                RecursiveBubbleSort.swap(arr, i, i + 1);
            }
        }
        bubbleSort(arr, n - 1);
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
