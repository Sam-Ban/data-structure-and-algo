package practice.problems.linearsearch;

import java.util.Scanner;

/*
You have  rectangles. A rectangle is golden if the ratio of its sides is in between , both inclusive.
Your task is to find the number of golden rectangles.

Input format

First line: Integer  denoting the number of rectangles
Each of the  following lines: Two integers  denoting the width and height of a rectangle
Output format

Print the answer in a single line.
Constraints



SAMPLE INPUT
5
10 1
165 100
180 100
170 100
160 100

SAMPLE OUTPUT
3
Explanation
There are three golden rectangles: (165, 100), (170, 100), (160, 100).
 */
public class GoldenRectangles {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        double[] arr1 = new double[n];
        double[] arr2 = new double[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = s.nextDouble();
            arr2[i] = s.nextDouble();
        }
        System.out.println(GoldenRectangles.countGoldenRectangles(arr1, arr2, n));
    }

    private static int countGoldenRectangles(double[] arr1, double[] arr2, int n) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (((arr1[i] / arr2[i]) >= 1.6 && (arr1[i] / arr2[i]) <= 1.7) || ((arr2[i] / arr1[i]) >= 1.6 && (arr2[i] / arr1[i]) <= 1.7))
                count++;
        }
        return count;
    }
}
