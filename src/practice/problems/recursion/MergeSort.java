package practice.problems.recursion;

/*
MergeSort : Time Complexity : O(nlogn) -- Base 2
 */

import java.util.Scanner;

public class MergeSort {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = s.nextInt();
        MergeSort.mergeSort(arr, 0, n - 1);
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }

    private static void mergeSort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    private static void merge(int[] arr, int low, int mid, int high) {

        int[] split1 = new int[mid - low + 1];
        int[] split2 = new int[high - mid];
        for (int i = 0; i < split1.length; i++)
            split1[i] = arr[low + i];
        for (int i = 0; i < split2.length; i++)
            split2[i] = arr[mid + 1 + i];
        int i = 0;
        int j = 0;
        int k = low;
        while (i < split1.length && j < split2.length) {
            if (split1[i] < split2[j])
                arr[k++] = split1[i++];
            else
                arr[k++] = split2[j++];
        }
        for (; i < split1.length; i++)
            arr[k++] = split1[i];
        for (; j < split2.length; j++)
            arr[k++] = split2[j];
    }
}