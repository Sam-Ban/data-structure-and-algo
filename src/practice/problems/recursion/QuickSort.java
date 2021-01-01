package practice.problems.recursion;

import java.util.Scanner;

public class QuickSort {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = s.nextInt();
        QuickSort.quickSort(arr, 0, n - 1);
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            System.out.println("Current pivot : " + pi);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        System.out.println("Initial pivot is :"+pivot);
        for (int i = low; i < high; i++) {
            if (arr[i] < pivot) {
                System.out.println("swap is happening between :"+arr[low]+" : "+arr[i]);
                int temp = arr[low];
                arr[low] = arr[i];
                arr[i] = temp;
                low++;
            }
        }
        int temp = arr[low];
        System.out.println("temp : "+temp);
        arr[low] = pivot;
        System.out.println("arr[low] : "+arr[low]);
        arr[high] = temp;
System.out.println("arr[low] : "+arr[low]+" arr[high] : "+arr[high]);
        return low;
    }
}
