package practice.problems.stack;

import java.util.Scanner;

/*
Given a permutation of number from 1 to N. Among all the subarrays, find the number of unique pairs (a,b) such that
  a!=b and a is maximum and b is second maximum in that subarray.

Input:
First line contains an integer, N(1<=N<=10^5) . Second line contains N space separated distinct integers, Ai (1<=Ai<=N),
denoting the permutation.

Output:
Print the required answer.

SAMPLE INPUT:
5
1 2 3 4 5

SAMPLE OUTPUT:
4

Explanation:
All the possible subarrays are:

1
1 2
1 2 3
1 2 3 4
1 2 3 4 5
2
2 3
2 3 4
2 3 4 5
3
3 4
3 4 5
4
4 5
5

The 4 unique pairs are:
(2,1)
(3,2)
(4,3)
(5,4)
 */
public class LittleShinoAndPairs {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];
        LittleShinoAndPairs.getInput(arr, n, s);
        LittleShinoAndPairs.permute(0, arr);
    }

    private static void getInput(int[] arr, int n, Scanner s) {
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }
    }

    private static void permute(int start, int[] input) {
        if (start == input.length) {
            //System.out.println(input);
            for (int x : input) {
                System.out.print(x);
            }
            System.out.println("");
            return;
        }
        for (int i = start; i < input.length; i++) {
            // swapping
            int temp = input[i];
            input[i] = input[start];
            input[start] = temp;
            // swap(input[i], input[start]);

            permute(start + 1, input);
            // swap(input[i],input[start]);

            int temp2 = input[i];
            input[i] = input[start];
            input[start] = temp2;
        }
    }
}
