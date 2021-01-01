package practice.problems.greedy;

import java.util.Scanner;

/*
Kadane's Algorithm :
Simple idea of the Kadane’s algorithm is to look for all positive contiguous segments of the array
(max_ending_here is used for this). And keep track of maximum sum contiguous segment among all positive segments
(max_so_far is used for this). Each time we get a positive sum compare it with max_so_far and update max_so_far if
it is greater than max_so_far
 */
public class LargestSumContigiousSubarrayKadane {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = s.nextInt();
        System.out.println(LargestSumContigiousSubarrayKadane.kadane(arr, n));
    }

    private static int kadane(int[] arr, int n) {
        int max_ending_here = 0;
        int max_so_far = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max_ending_here += arr[i];
            if (max_so_far < max_ending_here)
                max_so_far = max_ending_here;
            if (max_ending_here < 0)
                max_ending_here = 0;
        }
        return max_so_far;
    }
}

