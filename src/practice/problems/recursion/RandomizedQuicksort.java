package practice.problems.recursion;

import java.util.Random;
import java.util.Scanner;

public class RandomizedQuicksort {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = s.nextInt();
        RandomizedQuicksort.quickSort(arr,0,n-1);
        for(int i=0;i<n;i++)
            System.out.print(arr[i]+" ");
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = randomPartition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int randomPartition(int[] arr, int low, int high) {
        Random r = new Random();
        int rNumber = r.nextInt((high - low) + 1) + low;
        int temp = arr[rNumber];
        arr[rNumber] = arr[high];
        arr[high] = temp;
        return partition(arr, low, high);
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        for (int i = low; i < high; i++) {
            if (arr[i] < pivot) {
                int temp = arr[low];
                arr[low] = arr[i];
                arr[i] = temp;
                low++;
            }
        }
        int temp = arr[low];
        System.out.println("temp :"+temp);
        arr[low] = pivot;
        System.out.println("new arr[low] : "+arr[low]);
        arr[high] = temp;
        return low;
    }
}
