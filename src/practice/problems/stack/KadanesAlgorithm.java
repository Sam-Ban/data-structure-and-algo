package practice.problems.stack;

import java.util.Scanner;

/*
Find out largest sub-array where sum is maximum..
O(n) time complexity
 */
public class KadanesAlgorithm {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = s.nextInt();
        System.out.println(KadanesAlgorithm.maxSum(arr, n));
    }

    private static int maxSum(int[] arr, int n) {
        int globalMax = arr[0];
        int currentMax = arr[0];
        for (int i = 1; i < n; i++) {
            currentMax = Math.max(arr[i],currentMax + arr[i]); //arr[i] > (currentMax + arr[i]) ? arr[i] : (currentMax + arr[i]);
            if (currentMax > globalMax)
                globalMax = currentMax;
        }
        return globalMax;
    }
}