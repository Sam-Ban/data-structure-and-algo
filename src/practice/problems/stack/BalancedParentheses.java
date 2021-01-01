package practice.problems.stack;

import java.util.Scanner;
import java.util.Stack;

/*
Given an array of positive and negative integers, denoting different types of parentheses. The positive numbers xi denotes opening
parentheses of type xi and negative number -xi denotes closing parentheses of type xi .

Open parentheses must be closed by the same type of parentheses. Open parentheses must be closed in the correct order,
i.e., never close an open pair before its inner pair is closed (if it has an inner pair). Thus, [1,2,-2,-1] is balanced,
while [1,2,-1,-2] is not balanced.

You have to find out the length of the longest subarray that is balanced.

Input Format:
First line contains an input N , denoting the number of parentheses. Second line contains N space separated integers. xi
denoting the  parentheses of the array.

Output Format:
Print the length of the longest subarray that is balanced.

SAMPLE INPUT:
5
1 -1 2 3 -2
SAMPLE OUTPUT:
2
Explanation:
The longest subarray that is balanced is (1,-1).(2,3,-2) is not balanced as 3 is not balanced.


 */
public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = s.nextInt();
        System.out.println(BalancedParentheses.computeLongestSubarray(arr, n));
    }

    private static int computeLongestSubarray(int[] arr, int n) {
        Stack<Integer> st = new Stack<>();
        int[] resultArr = new int[n];
        int i = 0;
        int j = 0;
        int count = 0;
        while (i < n) {
            if (st.isEmpty()) {
                st.push(arr[i]);
                i++;
               // count++;
            } else if (arr[i] > 0) {
                st.push(arr[i]);
                i++;
              //  count++;
            } else if (arr[i] < 0 && st.peek() * (-1) == arr[i]) {
                st.pop();
                i++;
                //count++;
                count+=2;
                resultArr[j] = count;
                j++;
                if (!st.isEmpty()) {
                  //  resultArr[j] = count;
                  //  j++;
                    count = 0;
                }
            } else {
                st.clear();
                i++;
                count = 0;
            }
        }
        for (; j < n; j++)
            resultArr[j] = 0;
        int max = Integer.MIN_VALUE;
        for (int k = 0; k < n; k++) {
            if (resultArr[k] >= max)
                max = resultArr[k];
        }
        return max;
    }
}
