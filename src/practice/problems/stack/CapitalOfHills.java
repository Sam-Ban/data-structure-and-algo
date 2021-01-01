package practice.problems.stack;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/*
Sunderland capital consists of  n hills, forming a straight line. On each hill there was a watchman, who watched the neighbourhood day and night.

In case of any danger the watchman could make a fire on the hill. One watchman could see the signal of another watchman, if on the straight line connecting the two hills there was no hill higher than any of the two.  For example, for any two neighbouring watchmen it is true that the signal of one will be seen by the other.

An important characteristics of this watch system was the amount of pairs of watchmen able to see each other's signals. You are to find this amount by the given heights of the hills.

Input

The first line of the input data contains an integer number n (3 ≤ n ≤ 106), n — the amount of hills in the capital. The second line contains n numbers — heights of the hills. All height numbers are integer and lie between 1 and 109.

Output

Print the required amount of pairs.

Constraints

3 ≤ n ≤ 106

All height numbers are integer and lie between 1 and 109

SAMPLE INPUT :
4
2 3 2 1
SAMPLE OUTPUT :
3
Explanation
Required Pairs are (1,2), (2,3) and (3,4) hence output is 3.
 */
public class CapitalOfHills {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = s.nextInt();
        System.out.println(CapitalOfHills.countHills(arr, n));
    }

  /*  private static int countHills(int[] arr, int n) {
        Stack<Integer> hillList = new Stack<>();
        hillList.push(arr[0]);
        int j = 1;
        int count = 0;
        while (j < n) {
                while (hillList.size() > 0 && arr[j] > hillList.peek()) {
                    hillList.pop();
                    count++;
                }
                /*if(hillList.size()>1 && hillList.peek()>arr[j]){
               // count+=hillList.size();
                hillList.clear();
            }
            hillList.push(arr[j]);
            j++;
        }
        return count+(hillList.size()-1);
    } */

    private static int countHills(int[] arr, int n) {
        int i=1;
        int count=1;
        while(i+1<n){
            if(arr[i-1]<arr[i] && arr[i]<arr[i+1])
                count++;
            else if(arr[i-1]<arr[i] && arr[i]>arr[i+1])
                count++;
            else if(arr[i-1]>arr[i] && arr[i]>arr[i+1])
                count++;
            else if(arr[i-1]>arr[i] && arr[i]<arr[i+1])
                count+=2;
            else {
                i++;
                continue;
            }
            i++;
        }
        return count;
    }
}
