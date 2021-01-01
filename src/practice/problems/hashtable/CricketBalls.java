package practice.problems.hashtable;
/*
Daksh has 'N' boxes of cricket balls and each box has certain number of cricket balls (non-zero) in it. The boxes are numbered from 1 to N.

Now, Daksh has to go for practicing to cricket ground to compete in the upcoming fest URJA.
Daksh wants to carry exactly K number of cricket balls to ground and he can carry only 2 boxes. Can you tell him the
number of ways in which he can select 2 boxes such that total number of cricket balls in them is K.

Input :

First line of the input is the number of test cases T.
Each test case has 3 lines. First line is the number of boxes N.
Next line has N space separated integers where the ith integer is the number of cricket balls in the ith box.
3rd line of each test case contains value of K.
Output:

For each test case, output a single number, the number of ways in which Daksh can select the boxes.

Constraints:

1<=T<=100
1<=N<=105
1<=Number of Balls in ith box<=100

SAMPLE INPUT :
2
5
1 2 3 4 3
6
5
1 5 3 3 3
6

SAMPLE OUTPUT :
2
4
 */
//Not completed with O(n) complexity

import java.util.*;

public class CricketBalls {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int nt = s.nextInt();

        for (int i = 0; i < nt; i++) {
            int n = s.nextInt();
            LinkedList<Integer> arr = new LinkedList<>();
            for (int j = 0; j < n; j++) {
                arr.add(s.nextInt());
            }
            int r = s.nextInt();
            // Call the method
            System.out.println(CricketBalls.computeNoOfCombination(arr,n, r));
        }
    }

    private static int computeNoOfCombination(LinkedList<Integer> arr, int n, int r) {
        int counter = 0;
        int k = 0;
        while (!arr.isEmpty()) {
            int res = r - arr.remove(k);
            for (int i = 0; i < arr.size(); i++) {
                if (arr.get(i) == res) {
                    counter++;
                }
            }
        }
        return counter;
    }
}