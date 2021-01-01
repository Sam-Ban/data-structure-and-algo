package practice.problems.debojit;

import java.util.Scanner;

public class OneZeroProblem {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = s.nextInt();
        System.out.println(OneZeroProblem.countOneZero(arr));
    }

    private static int countOneZero(int[] arr) {
        int count = 0;
        int x = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (x != arr[i]) {
                count++;
                x = arr[i];
            }
        }
        return count;
    }
}
