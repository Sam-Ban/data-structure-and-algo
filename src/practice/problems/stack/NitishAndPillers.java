package practice.problems.stack;

import java.util.Scanner;

/*
Nitish is a short hieghted person. He is standing facing N pillars of different heights with ith pillar having height hi.
He tries to see all the possible pillars. He wants to know that how many buildings will he be able to see in the range [L, R]
both inclusive.

Input

The first line contains an integer N denoting the number of pillars.
Next line contains N integers denoting height of ith pillar.
Next line contains a single integer Q.
Next Q lines contain pairs L and R respectively.


Output

For every Q queries print the number of buildings visible in the range [L, R].



Constraints

1<=N, Q<=105

1<=L<=R<=N

1<=h<=109

SAMPLE INPUT :
7
5 2 3 7 9 8 11
4
0 6
1 5
2 6
3 4
SAMPLE OUTPUT :
4
4
4
2
Explanation
In query 1 5, 7, 9, 11 pillars are visible so answer is 4.

In query 2 2, 3, 7, 9 are visible so answer is 4.
 */
public class NitishAndPillers {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }
        int q = n;
        for (int i = 0; i < q; i++) {
            int l = s.nextInt();
            int r = s.nextInt();
            //Call function
            System.out.println(NitishAndPillers.getNumberOfVisiblePillers(arr, n, q, l, r));
        }
    }

    private static int getNumberOfVisiblePillers(int[] arr, int n, int q, int l, int r) {
        int count = 0;
        int height = Integer.MIN_VALUE;
        int i = l;
        while (i <= r) {
            if (arr[i] > height) {
                height = arr[i];
                count++;
            }
            i++;
        }
        return count;
    }
}
