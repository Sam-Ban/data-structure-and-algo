package practice.problems.hashtable;
/*
You have been given an integer array A and a number K. Now, you need to find out whether any two different elements of the array A
sum to the number K. Two elements are considered to be different if they lie at different positions in the array.
If there exists such a pair of numbers, print "YES" (without quotes), else print "NO" without quotes.

Input Format:

The first line consists of two integers N, denoting the size of array A and K. The next line consists of N space separated integers
denoting the elements of the array A.

Output Format:

Print the required answer on a single line.

SAMPLE INPUT :
5 9
1 2 3 4 5

SAMPLE OUTPUT :
YES

Explanation : A[4]+A[5] = 9
Here, . So, the answer is YES.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class PairSums {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int r = s.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++)
            arr.add(s.nextInt());

       System.out.println(PairSums.matchedPair(arr, r));

    }

    private static String matchedPair(ArrayList<Integer> arr, int r) {
        boolean flag = false;
        for (int i = 0; i < arr.size(); i++) {
            int target = r-arr.remove(i);
            if (arr.contains(target)) {
                flag = true;
                break;
            }
            else
                flag = false;
        }
        if (flag == true)
            return "YES";
        else return "NO";
    }
}
