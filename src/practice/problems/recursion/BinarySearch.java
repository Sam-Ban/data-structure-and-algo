package practice.problems.recursion;

import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = s.nextInt();
        int key = s.nextInt();
      //  BinarySearch.binarySearch(arr, 0, n - 1, key);
        BinarySearch.optimizedBinarySearch(arr,0,n-1,key);
    }

    private static void binarySearch(int[] arr, int low, int high, int key) {
        int mid = low + (high - 1) / 2;
        if (low <= high) {
            if (arr[mid] == key)
                System.out.println("Found : " + key + " :at index: " + mid);
            if (key < arr[mid])
                binarySearch(arr, low, mid - 1, key);
            if (key > arr[mid])
                binarySearch(arr, mid + 1, high, key);
        } else
            System.out.println("not found");
    }

    private static void optimizedBinarySearch(int[] arr, int low, int high, int key){
        int mid = low+(high-1)/2;
        if(low<=high){
            if(arr[mid]==key || arr[low]==key || arr[high]==key)
                System.out.println("Found : " + key);
            else if (key < arr[mid])
                binarySearch(arr, low, mid - 1, key);
            else if (key > arr[mid])
                binarySearch(arr, mid + 1, high, key);
            else System.out.println();
        } else
            System.out.println("not found");
    }

}