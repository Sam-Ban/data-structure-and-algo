package practice.problems.hashtable;

import javafx.scene.effect.InnerShadow;
import org.omg.CORBA.INTERNAL;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

/*
Rajiv and Nitish had a fight because Rajiv was annoying Nitish with his question. Rajiv being a genius in arrays gave
Nitish an array of natural numbers A of length N with elements A1,  A2, . . ., AN. Nitish has to find the total
amount of perfect pairs in the array.

A perfect pair (Ai, Aj) is a pair where (Ai + Aj) is a perfect square or a perfect cube and i ≠ j.

Since Rajiv and Nitish are not talking with each other after the fight you have been given the question to solve and
inturn make both of them a perfect pair again.

NOTE :-  A pair (Ai, Aj) and (Aj, Ai) are same and not to be counted twice.



Input

The first line on the input contains the a single integer T denoting the number of test cases.
The first line of each test case contains a single integer N. The second line contains N space-separated integers A1,  A2, . . ., AN.

Output

For each test case, print a single line containing a single integer denoting the total number of perfect pairs.

Constraints

1 ≤  T ≤ 10
1 ≤  N ≤ 105
1 ≤  Ai ≤ 103

SAMPLE INPUT:
2
5
1 2 3 4 5
4
1 4 5 8
SAMPLE OUTPUT :
3
2
 */
public class PerfectPair {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> arr = PerfectPair.getInput(n, s);
            System.out.println(PerfectPair.countPerfectSquareOrCube(arr));
        }
    }

    private static ArrayList<Integer> getInput(int n, Scanner s) {
        int k = s.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        for (int j = 0; j < k; j++)
            arr.add(s.nextInt());
        return arr;
    }

    private static int countPerfectSquareOrCube(ArrayList<Integer> arr) {
        int count = 0;
        int j = 0;
        while (j < arr.size() - 1) {
            int x = arr.get(j);
            for (int i = j + 1; i < arr.size(); i++) {
                double y = x + arr.get(i);
                double z = Math.sqrt(y);
                double c = Math.cbrt(y);
                if (z - Math.floor(z) == 0)
                    count++;
                else if (c - Math.floor(c) == 0)
                    count++;
                else continue;
            }
            j++;
        }
        return count;
    }

}

