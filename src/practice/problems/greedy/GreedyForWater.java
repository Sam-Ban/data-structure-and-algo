package practice.problems.greedy;
/*
You are given container full of water. Container can have limited amount of water. You also have N bottles to fill.
You need to find the maximum numbers of bottles you can fill.

Input:
First line contains one integer, T, number of test cases.
First line of each test case contains two integer, N and X, number of bottles and capacity of the container.
Second line of each test case contains N space separated integers, capacities of bottles.

Output:
For each test case print the maximum number of bottles you can fill.

Constraints:

SAMPLE INPUT:
1
5 10
8 5 4 3 2

SAMPLE OUTPUT:
3
 */

import java.util.Scanner;

public class GreedyForWater {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        int N = s.nextInt();
        int X = s.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = s.nextInt();
        System.out.println(GreedyForWater.maximizeNumberOfBottles(arr, N, X));
    }

    private static int maximizeNumberOfBottles(int[] arr, int N, int X) {
        //Sort the array in ascending order of capacity
        GreedyForWater.mergeSort(arr, 0, N - 1);
        int countBottles = 0;
        int capacitySum = 0;
        for (int i = 0; i < N; i++) {
            capacitySum += arr[i];
            if (capacitySum > X)
                break;
            countBottles++;
        }
        return countBottles;
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
