package practice.problems.recursion;

import java.util.Scanner;
/*
Given a non-negative int n, return the count of the occurrences of 7 as a digit, so for example 717 yields 2.
(no loops). Note that mod (%) by 10 yields the rightmost digit (126 % 10 is 6), while divide (/)
by 10 removes the rightmost digit (126 / 10 is 12).


count7(717) → 2
count7(7) → 1
count7(123) → 0
 */

public class Count7 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int count = 0;
        System.out.println(Count7.countNo7(n, count));  //717,0
    }

    private static int countNo7(int n, int count) {
        if (n == 0) {
            return count;
        } else {
            if (n % 10 == 7) {
                count++;    //count = 1
            }
            n = n / 10; //n = 71  n=7
            return countNo7(n, count); //1+countNo7(71,1) 1+1+countNo7(7,1)
        }
    }
}
