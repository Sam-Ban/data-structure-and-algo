package practice.problems.linearsearch;

import java.util.ArrayList;
import java.util.Scanner;

/*
You are given a grid of size  that has the following specifications:

Each cell in the grid contains either a policeman or a thief.
A policeman can only catch a thief if both of them are in the same row.
Each policeman can only catch one thief.
A policeman cannot catch a thief who is more than K units away from the policeman.
Write a program to find the maximum number of thieves that can be caught in the grid.

Input format

First line: T (number of test cases)
For each test case
First line: Two space-separated integers N and K
Next N lines: N space-separated characters (denoting each cell in the grid)
Output format

For each test case, print the maximum number of thieves that can be caught in the grid.

Constraints




SAMPLE INPUT
1
3 1
P T P
T P T
T T P
SAMPLE OUTPUT
3
Explanation
Total Thieves = 5
Number of thieves reachable by policemen in Row 1 = 1
Number of thieves reachable by policemen in Row 2 = 2
Number of thieves reachable by policemen in Row 3 = 1
However, one policeman can catch at most 1 thief. Hence, in Row 2, only 1 thief is catchable.
Therefore, the 3 thieves can be caught.
 */
public class PolicemenAndThieves {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        for (int i = 0; i < n; i++) {
            ArrayList<ArrayList<String>> grid = new ArrayList<>();
            int gs = s.nextInt();
            int k = s.nextInt();
            for (int j = 0; j < gs; j++) {
                ArrayList<String> row = new ArrayList<>();
                for (int l = 0; l < gs; l++)
                    row.add(l, s.next());
                grid.add(j, row);
            }
            System.out.println(PolicemenAndThieves.countMaxNumberOfThievesCaught(grid, k));
        }
    }

    private static int countMaxNumberOfThievesCaught(ArrayList<ArrayList<String>> grid, int k) {
        int count = 0;
        for (int i = 0; i < grid.size(); i++) {
            ArrayList<String> row = grid.get(i);
            int index = 0;
            ArrayList<Integer> p = new ArrayList<>();
            ArrayList<Integer> t = new ArrayList<>();
            for (int a = 0; a < row.size(); a++) {
                if (row.get(a).equalsIgnoreCase("T"))
                    t.add(a);
                else
                    p.add(a);
            }
            int ip = 0;
            int it = 0;
            while (ip < p.size() && it < t.size()) {
                if (Math.abs(p.get(ip) - t.get(it)) <= k) {
                    count++;
                    ip++;
                    it++;
                } else if (t.get(it) < p.get(ip))
                    it++;
                else
                    ip++;
            }
        }
        return count;
    }
}