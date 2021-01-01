package practice.problems.linearsearch;

import java.util.Random;
import java.util.Scanner;

/*
Given A Series Of N Positive Integers a1,a2,a3........an. , Find The Minimum And Maximum Values That Can Be Calculated By
Summing Exactly N-1 Of The N Integers. Then Print The Respective Minimum And Maximum Values As A Single Line Of Two Space-Separated
Long Integers.

Input Format

First Line Take Input Value Of N

Second Line Take Input N Space Separated Integer Value

Output Format

Two Space Separated Value ( One Maximum Sum And One Minimum Sum )

Constraints

0 < N < 100001
0 <= ai < 1013
SAMPLE INPUT
5
1 2 3 4 5
SAMPLE OUTPUT
10 14
Explanation
Our initial numbers are 1,2,3,4 and 5. We can calculate the following sums using four of the five integers:

If we sum everything except 1, our sum is 2+3+4+5=14 .
If we sum everything except 2, our sum is 1+3+4+5=13 .
If we sum everything except 3, our sum is 1+2+4+5=12 .
If we sum everything except 4, our sum is 1+3+4+5=11 .
If we sum everything except 5, our sum is 1+2+3+4=10 .
As you can see, the minimal sum is 1+2+3+4=10 and the maximal sum is 2+3+4+5=14. Thus, we print these minimal and maximal
sums as two space-separated integers on a new line.
 */
public class MinMax {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }
        MinMax.quickSort(arr, 0, n - 1);
        MinMax.determineMinMax(arr, n);
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
        arr[low] = pivot;
        arr[high] = temp;
        return low;
    }

    private static void determineMinMax(int[] arr, int n) {
        int minSum = 0;
        int maxSum = 0;
        for (int i = 0; i < n - 1; i++)
            minSum += arr[i];
        for (int i = 1; i < n; i++)
            maxSum += arr[i];
        System.out.println(minSum + " " + maxSum);
    }
}
