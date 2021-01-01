package practice.problems.linearsearch;

import java.util.Scanner;

/*
Creatnx now wants to decorate his house by flower pots. He plans to buy exactly N ones. He can only buy them from Triracle's shop.
There are only two kind of flower pots available in that shop. The shop is very strange. If you buy X flower pots of kind 1
then you must pay A*X2 and B*Y2 if you buy Y flower pots of kind 2. Please help Creatnx buys exactly N flower pots that
minimizes money he pays.

Input Format

The first line contains a integer T denoting the number of test cases.

Each of test case is described in a single line containing three space-separated integers .

Output Format

For each test case, print a single line containing the answer.

SAMPLE INPUT
2
5 1 2
10 2 4

SAMPLE OUTPUT
17
134
Explanation
Query 1: we have to buy exactly  pots. There are six possible options:

Buy 0 pot of first kind, 5 pots of second kind. The cost is: 1*02+2*52 =50.
Buy 1 pot of first kind, 4 pots of second kind. The cost is: 1*12+2*42 =33.
Buy 2 pots of first kind, 3 pots of second kind. The cost is: 1*22+2*32 = 22.
Buy 3 pots of first kind, 2 pots of second kind. The cost is: 1*32+2*22 = 17.
Buy 4 pots of first kind, 1 pot of second kind. The cost is: 1*42+2*12 = 20.
Buy 5 pots of first kind, 0 pot of second kind. The cost is: 1*52+2*02 = 25.
So, the optimal cost is 17.
 */
public class SpecialShop {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for (int i = 0; i < t; i++) {
            int n = s.nextInt();
            int a = s.nextInt();
            int b = s.nextInt();
            System.out.println(SpecialShop.calculateMinimumAmount(n, a, b));
        }
    }

    private static int calculateMinimumAmount(int n, int a, int b) {
        int min = Integer.MAX_VALUE;
        int x = 0;
        int y = n;
        while (x <= n && y >= 0) {
            int sum = a * (x * x) + b * (y * y);
            if (sum <= min)
                min = sum;
            x++;
            y--;
        }
        return min;
    }
}
